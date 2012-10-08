package shadow.mods.metallurgy.precious;

import java.util.Iterator;
import java.util.List;

import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.StatCollector;
import net.minecraft.src.World;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.MathHelper;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.Entity;
import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.TileEntity;
import net.minecraft.src.IInventory;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityItem;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.ForgeDirection;

import java.util.Random;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

public class FC_BlockChest extends BlockContainer
{
    private Random random = new Random();
    private int renderId = RenderingRegistry.getNextAvailableRenderId();

    public FC_BlockChest(int par1)
    {
        super(par1, Material.wood);
        this.blockIndexInTexture = 2;
        this.setCreativeTab(CreativeTabs.tabDeco);
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
    
    @Override
    protected int damageDropped(int metadata)
    {
    	return metadata;
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
     * The type of render function that is called for this block
     */
    @Override
    public int getRenderType()
    {
        return renderId;
    }


    @Override
	public String getTextureFile()
    {		
		return "/shadow/MetallurgyFantasyMetals.png";
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        byte direction = 0;
        int var11 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var11 == 0)
        {
            direction = 2;
        }

        if (var11 == 1)
        {
            direction = 5;
        }

        if (var11 == 2)
        {
            direction = 3;
        }

        if (var11 == 3)
        {
            direction = 4;
        }
        int type = par1World.getBlockMetadata(par2, par3, par4);
        TileEntity tileEntity = par1World.getBlockTileEntity(par2, par3, par4);
        if(tileEntity instanceof FC_TileEntityChest)
        {
        	((FC_TileEntityChest)tileEntity).setDirection(direction);
        	((FC_TileEntityChest)tileEntity).setType(type);
        }

        //par1World.setBlockMetadataWithNotify(par2, par3, par4, direction);
    }

    /**
     * Retrieves the block texture to use based on the display side. Args: iBlockAccess, x, y, z, side
     */
    @Override
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5)
    {
    	int meta = par1IBlockAccess.getBlockMetadata(par2, par3, par4);
    	
        if (par5 == 1)
        {
            return this.blockIndexInTexture - 1;
        }
        else if (par5 == 0)
        {
            return this.blockIndexInTexture - 1;
        }
        else
        {
        	return 3;
        }
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    @Override
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 1 ? this.blockIndexInTexture - 1 : (par1 == 0 ? this.blockIndexInTexture - 1 : (par1 == 3 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture));
    }

    /**
     * ejects contained items into the world, and notifies neighbours of an update, as appropriate
     */
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
    	FC_TileEntityChest var5 = (FC_TileEntityChest)par1World.getBlockTileEntity(par2, par3, par4);

        if (var5 != null)
        {
            for (int var6 = 0; var6 < var5.getSizeInventory(); ++var6)
            {
                ItemStack var7 = var5.getStackInSlot(var6);

                if (var7 != null)
                {
                    float var8 = this.random.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem var12;

                    for (float var10 = this.random.nextFloat() * 0.8F + 0.1F; var7.stackSize > 0; par1World.spawnEntityInWorld(var12))
                    {
                        int var11 = this.random.nextInt(21) + 10;

                        if (var11 > var7.stackSize)
                        {
                            var11 = var7.stackSize;
                        }

                        var7.stackSize -= var11;
                        var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, var11, var7.getItemDamage()));
                        float var13 = 0.05F;
                        var12.motionX = (double)((float)this.random.nextGaussian() * var13);
                        var12.motionY = (double)((float)this.random.nextGaussian() * var13 + 0.2F);
                        var12.motionZ = (double)((float)this.random.nextGaussian() * var13);

                        if (var7.hasTagCompound())
                        {
                            var12.item.setTagCompound((NBTTagCompound)var7.getTagCompound().copy());
                        }
                    }
                }
            }
        }

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        Object var6 = (FC_TileEntityChest)par1World.getBlockTileEntity(x, y, z);

        if (var6 == null)
        {
            return true;
        }
        else if (par1World.isBlockSolidOnSide(x, y + 1, z, ForgeDirection.DOWN))
        {
            return true;
        }
        else if (isOcelotBlockingChest(par1World, x, y, z))
        {
            return true;
        }
        else
        {
            if (par1World.isRemote)
            {
                return true;
            }
            else
            {
                //par5EntityPlayer.displayGUIChest((IInventory)var6);
                par5EntityPlayer.openGui(MetallurgyPrecious.instance, -1, par1World, x, y, z);
                //ModLoader.openGUI(par5EntityPlayer, new FC_GuiChest(par5EntityPlayer.inventory, (IInventory) var6));
                return true;
            }
        }
    }

    /**
     * Returns the TileEntity used by this block.
     */
	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
        return new FC_TileEntityChest();
	}

    /**
     * Looks for a sitting ocelot within certain bounds. Such an ocelot is considered to be blocking access to the
     * chest.
     */
    private static boolean isOcelotBlockingChest(World par0World, int par1, int par2, int par3)
    {
        Iterator var4 = par0World.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par1, (double)(par2 + 1), (double)par3, (double)(par1 + 1), (double)(par2 + 2), (double)(par3 + 1))).iterator();
        EntityOcelot var6;

        do
        {
            if (!var4.hasNext())
            {
                return false;
            }

            Entity var5 = (Entity)var4.next();
            var6 = (EntityOcelot)var5;
        }
        while (!var6.isSitting());

        return true;
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
