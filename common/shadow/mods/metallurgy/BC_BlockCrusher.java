package shadow.mods.metallurgy;

import java.util.List;
import java.util.Random;


import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

import net.minecraft.src.*;

public class BC_BlockCrusher extends BlockContainer
{
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private Random furnaceRand = new Random();

    /** True if this is an active furnace, false if idle */
    private final boolean isActive;

	private int renderId = RenderingRegistry.getNextAvailableRenderId();

    /**
     * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
     * furnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory = false;

    protected BC_BlockCrusher(int par1, boolean par2)
    {
        super(par1, Material.rock);
        this.isActive = par2;
        setRequiresSelfNotify();
    }
    
	public String getTextureFile() 
	{
		return "/shadow/MetallurgyFurnaces.png";
	}

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType()
    {
        return renderId;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    @Override
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return mod_MetallurgyCore.crusher.blockID;
    }
    
    @Override
    protected int damageDropped(int metadata)
    {
    	return (metadata < 8) ? metadata : metadata - 8;
    }
    
    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    @Override
    public int getBlockTextureFromSideAndMetadata(int side, int metadata)
    {
    	int type = (metadata < 8) ? metadata : metadata - 8;
        if (side == 1 || side == 0)
        {
            return 6 + (type * 16);
        } else if(side == 0)
        	return 7 + (type * 16);
        else
        {
            if(side != 3)
            	return 5 + (type * 16);
            else
            	return 4 + (type * 16);
        }
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    @Override
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y, int z, int side)
    {    	
    	TileEntity tileEntity = par1IBlockAccess.getBlockTileEntity(x, y, z);
    	if(!(tileEntity instanceof BC_TileEntityCrusher))
    		return 0;
    	
    	int metadata = par1IBlockAccess.getBlockMetadata(x, y, z);
    	int type = (metadata < 8) ? metadata : metadata - 8;
    	int	direction = ((BC_TileEntityCrusher)tileEntity).getDirection();
    	boolean burning = ((BC_TileEntityCrusher)tileEntity).isBurning();
    	
        if (side == 1 || side == 0)
        {
            return 6 + (type * 16);
        } else if(side == 0) {
            return 7 + (type * 16);
        }
        else
        {
            if(side != direction)
            	return 5 + (type * 16);
            else if(burning)
            {
            	return 8 + (type * 16);
            }
            else
            {
            	return 4 + (type * 16);
            }
        }
    }

    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
    public void randomDisplayTick(World par1World, int x, int y, int z, Random par5Random)
    {
    	
    	BC_TileEntityCrusher var6 = ((BC_TileEntityCrusher)(par1World.getBlockTileEntity(x, y, z)));
    	int metadata = par1World.getBlockMetadata(x, y, z);
    	
        if (var6.isBurning())
        {
        	int direction = var6.getDirection();
            float var7 = (float)x + 0.5F;
            float var8 = (float)y + 0.0F + par5Random.nextFloat() * 6.0F / 16.0F;
            float var9 = (float)z + 0.5F;
            float var10 = 0.52F;
            float var11 = par5Random.nextFloat() * 0.6F - 0.3F;

            if (direction == 4)
            {
                par1World.spawnParticle("smoke", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(var7 - var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 5)
            {
                par1World.spawnParticle("smoke", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(var7 + var10), (double)var8, (double)(var9 + var11), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 2)
            {
                par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 - var10), 0.0D, 0.0D, 0.0D);
            }
            else if (direction == 3)
            {
                par1World.spawnParticle("smoke", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
                par1World.spawnParticle("flame", (double)(var7 + var11), (double)var8, (double)(var9 + var10), 0.0D, 0.0D, 0.0D);
            }
        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    @Override
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 1 ? this.blockIndexInTexture + 17 : (par1 == 0 ? this.blockIndexInTexture + 17 : (par1 == 3 ? this.blockIndexInTexture - 1 : this.blockIndexInTexture));
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }

    	BC_TileEntityCrusher var6 = (BC_TileEntityCrusher)par1World.getBlockTileEntity(x, y, z);
    	int type = par1World.getBlockMetadata(x, y, z);
        if (var6 != null)
        {
            par5EntityPlayer.openGui(mod_MetallurgyCore.instance, type, par1World, x, y, z);
        }

        return true;
    }

    /**
     * Update which block ID the furnace is using depending on whether or not it is burning
     */
    public static void updateFurnaceBlockState(boolean isBurning, World par1World, int x, int y, int z)
    {
    	/*
    	int metadata = par1World.getBlockMetadata(x, y, z);
    	
    	if(isBurning && metadata < 8)
    		par1World.setBlockMetadata(x, y, z, metadata + 8);
    	if(!isBurning && metadata >= 8)
    		par1World.setBlockMetadata(x, y, z, metadata - 8);
    	*/
    }

    /**
     * Returns the TileEntity used by this block.
     */
    @Override
    public TileEntity createNewTileEntity(World par1World)
    {
        return null;
    }

    /**
     * Returns the TileEntity used by this block.
     */
    @Override
    public TileEntity createTileEntity(World par1World, int metadata)
    {
    	BC_TileEntityCrusher tec = new BC_TileEntityCrusher();
    	metadata = (metadata > 8) ? metadata : metadata - 8;
    	
	    switch(metadata)
	    {
	        case 0:
	        {
	            tec.setSpeed((int)(20 * CoreConfig.stoneCrusherSpeed));
	            break;
	        }
	        case 1:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.copperCrusherSpeed));
	        	break;
	        }
	        case 2:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.bronzeCrusherSpeed));
	        	break;
	        }
	        case 3:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.ironCrusherSpeed));
	        	break;
	        }
	        case 4:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.steelCrusherSpeed));
	        	break;
	        }
	        default:
	        	break;
	    }
	    
	    return tec;
	    //return new BC_TileEntityCrusher();
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            ((BC_TileEntityCrusher)(par1World.getBlockTileEntity(x, y, z))).setDirection(2);
        }

        if (var6 == 1)
        {
            ((BC_TileEntityCrusher)(par1World.getBlockTileEntity(x, y, z))).setDirection(5);
        }

        if (var6 == 2)
        {
            ((BC_TileEntityCrusher)(par1World.getBlockTileEntity(x, y, z))).setDirection(3);
        }

        if (var6 == 3)
        {
            ((BC_TileEntityCrusher)(par1World.getBlockTileEntity(x, y, z))).setDirection(4);
        }
        
        
        BC_TileEntityCrusher tec = (BC_TileEntityCrusher)par1World.getBlockTileEntity(x, y, z);
        int metadata = par1World.getBlockMetadata(x, y, z);
        
        switch(metadata)
        {
	        case 0:
	        {
	            tec.setSpeed((int)(20 * CoreConfig.stoneCrusherSpeed));
	            break;
	        }
	        case 1:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.copperCrusherSpeed));
	        	break;
	        }
	        case 2:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.bronzeCrusherSpeed));
	        	break;
	        }
	        case 3:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.ironCrusherSpeed));
	        	break;
	        }
	        case 4:
	        {
	        	tec.setSpeed((int)(20 * CoreConfig.steelCrusherSpeed));
	        	break;
	        }
	        default:
	        	break;
        }
        
    }

    /**
     * Called whenever the block is removed.
     */
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    	if(par1World.isRemote)
    		return;
    	
        if (!keepFurnaceInventory)
        {
        	BC_TileEntityCrusher var5 = (BC_TileEntityCrusher)par1World.getBlockTileEntity(par2, par3, par4);

            if (var5 != null)
            {
                for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
                {
                    ItemStack var7 = var5.getStackInSlot(var6);

                    if (var7 != null)
                    {
                        float var8 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var9 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                        float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                        while (var7.stackSize > 0)
                        {
                            int var11 = this.furnaceRand.nextInt(21) + 10;

                            if (var11 > var7.stackSize)
                            {
                                var11 = var7.stackSize;
                            }

                            var7.stackSize -= var11;
                            EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));

                            if (var7.hasTagCompound())
                            {
                                var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                            }

                            float var13 = 0.05F;
                            var12.motionX = (double)((float)this.furnaceRand.nextGaussian() * var13);
                            var12.motionY = (double)((float)this.furnaceRand.nextGaussian() * var13 + 0.2F);
                            var12.motionZ = (double)((float)this.furnaceRand.nextGaussian() * var13);
                            par1World.spawnEntityInWorld(var12);
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 5; n++) {
			par3List.add(new ItemStack(this, 1, n));

		}
	}
}
