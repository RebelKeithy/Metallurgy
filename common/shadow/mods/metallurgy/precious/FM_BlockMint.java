package shadow.mods.metallurgy.precious;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.mod_MetallurgyFantasy;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

import net.minecraft.src.*;

public class FM_BlockMint extends BlockContainer
{
    /**
     * Is the random generator used by furnace to drop the inventory contents in random directions.
     */
    private Random furnaceRand = new Random();

	private int renderId = RenderingRegistry.getNextAvailableRenderId();
	
    /**
     * This flag is used to prevent the furnace inventory to be dropped upon block removal, is used internally when the
     * furnace block changes from idle to active and vice-versa.
     */
    private static boolean keepFurnaceInventory = false;

    protected FM_BlockMint(int par1)
    {
        super(par1, Material.rock);
        setRequiresSelfNotify();
        this.setCreativeTab(CreativeTabs.tabDeco);
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return this.blockID;
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
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            FM_TileEntityMint var6 = (FM_TileEntityMint)par1World.getBlockTileEntity(par2, par3, par4);

            if(par5EntityPlayer.inventory.getCurrentItem() != null)// && par5EntityPlayer.inventory.getCurrentItem().itemID == mod_MetallurgyBaseMetals.ores.Bar[0].shiftedIndex)
            	var6.setIngot(par5EntityPlayer.inventory.currentItem, par5EntityPlayer.inventory);
            else
            {
            	ItemStack var7 = var6.currentIngot();
            	if(var7 != null)
            	{
            		par5EntityPlayer.inventory.mainInventory[par5EntityPlayer.inventory.currentItem] = var7;
            		var6.removeIngot();
            	}
            }
            
            //var6.setIngot(null);
            
            return true;
        }
    }

    /**
     * Returns the TileEntity used by this block.
     */
    @Override
    public TileEntity createNewTileEntity(World var1)
    {
        return new FM_TileEntityMint();
    }

    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving)
    {
        int var6 = MathHelper.floor_double((double)(par5EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0)
        {
            ((FM_TileEntityMint)(par1World.getBlockTileEntity(par2, par3, par4))).setDirection(2);
        }

        if (var6 == 1)
        {
            ((FM_TileEntityMint)(par1World.getBlockTileEntity(par2, par3, par4))).setDirection(5);
        }

        if (var6 == 2)
        {
            ((FM_TileEntityMint)(par1World.getBlockTileEntity(par2, par3, par4))).setDirection(3);
        }

        if (var6 == 3)
        {
            ((FM_TileEntityMint)(par1World.getBlockTileEntity(par2, par3, par4))).setDirection(4);
        }       
    }
    
    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
    	
        if (!par1World.isRemote)
        {
        	FM_TileEntityMint tem = (FM_TileEntityMint) par1World.getBlockTileEntity(par2, par3, par4);
        	
            if (par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                tem.power();
            }
            else if (!par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
            	tem.unpower();
            }
        }
        
    }

    /**
     * Called whenever the block is removed.
     */
    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
        if (!keepFurnaceInventory)
        {
            FM_TileEntityMint tem = (FM_TileEntityMint)par1World.getBlockTileEntity(par2, par3, par4);

            if (tem != null)
            {
                ItemStack var7 = tem.currentIngot();

                if (var7 != null)
                {
                    float var8 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var9 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;
                    float var10 = this.furnaceRand.nextFloat() * 0.8F + 0.1F;

                    EntityItem var12 = new EntityItem(par1World, (double)((float)par2 + var8), (double)((float)par3 + var9), (double)((float)par4 + var10), new ItemStack(var7.itemID, 1, var7.getItemDamage()));

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

        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
}
