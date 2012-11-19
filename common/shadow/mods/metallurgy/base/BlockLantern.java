package shadow.mods.metallurgy.base;

import static net.minecraftforge.common.ForgeDirection.DOWN;
import static net.minecraftforge.common.ForgeDirection.EAST;
import static net.minecraftforge.common.ForgeDirection.NORTH;
import static net.minecraftforge.common.ForgeDirection.SOUTH;
import static net.minecraftforge.common.ForgeDirection.WEST;

import java.util.List;
import java.util.Random;

import shadow.mods.metallurgy.BC_TileEntityCrusher;
import shadow.mods.metallurgy.CoreConfig;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityItem;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class BlockLantern extends BlockContainer
{
	public int renderId = RenderingRegistry.getNextAvailableRenderId();
	private int color;
	
    protected BlockLantern(int par1)
    {
        super(par1, Material.wood);
        setBlockBounds(3/16F, 0/16F, 3/16F, 13/16F, 13/16F, 13/16F);
    }
    
    @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    @Override
    public int getRenderType()
    {
        return renderId;
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns which pass should this block be rendered on. 0 for solids and 1 for alpha
     */
	@Override
    public int getRenderBlockPass()
    {
        return 1;
    }

    /**
     * Returns the TileEntity used by this block.
     */
    @Override
    public TileEntity createTileEntity(World par1World, int metadata)
    {
    	//TileEntity te = par1World.getBlockTileEntity(par1, par2, par3)
    	//if()
    	TileEntityLantern tec = new TileEntityLantern();
	    return tec;
    }

    
	@Override
	public TileEntity createNewTileEntity(World var1) {
		// TODO Auto-generated method stub
		return null;
	
	}

    /**
     * Gets if we can place a torch on a block.
     */
    private boolean canPlaceTorchOn(World par1World, int par2, int par3, int par4)
    {
        if (par1World.doesBlockHaveSolidTopSurface(par2, par3, par4))
        {
            return true;
        }
        else
        {
            int var5 = par1World.getBlockId(par2, par3, par4);
            return (Block.blocksList[var5] != null && Block.blocksList[var5].canPlaceTorchOnTop(par1World, par2, par3, par4));
        }
    }

    /**
     * Checks to see if its valid to put this block at the specified coordinates. Args: world, x, y, z
     */
	@Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4)
    {
        return par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST,  true) ||
               par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST,  true) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH, true) ||
               par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH, true) ||
               par1World.isBlockSolidOnSide(par2, par3 + 1, par4, DOWN, true) ||
               par1World.getBlockId(par2, par3 + 1, par4) == Block.fence.blockID ||
               canPlaceTorchOn(par1World, par2, par3 - 1, par4);
    }
	

	@Override
	public void onNeighborBlockChange(World par1World, int x, int y, int z, int par5)
	{
		int meta = par1World.getBlockMetadata(x, y, z);
		System.out.println(meta);
		
		boolean dropBlock = false;
		if(!par1World.isBlockNormalCube(x, y-1, z) && meta == 0)
			dropBlock = true;
		if((!par1World.isBlockNormalCube(x, y+1, z) && par1World.getBlockId(x, y+1, z) != Block.fence.blockID) && meta == 5)
			dropBlock = true;
		else if(!par1World.isBlockNormalCube(x+1, y, z) && meta == 1)
			dropBlock = true;
		else if(!par1World.isBlockNormalCube(x-1, y, z) && meta == 3)
			dropBlock = true;
		else if(!par1World.isBlockNormalCube(x, y, z+1) && meta == 2)
			dropBlock = true;
		else if(!par1World.isBlockNormalCube(x, y, z-1) && meta == 4)
			dropBlock = true;

		if(dropBlock)
		{
			//this.dropBlockAsItem(par1World, x, y, z, this.blockID, meta);
			par1World.setBlockAndMetadata(x, y, z, 0, 0);
		}
	}
	
    /**
     * Called when the block is placed in the world.
     */
    @Override
    public void onBlockPlacedBy(World par1World, int x, int y, int z, EntityLiving par5EntityLiving)
    {
        int var6 = 0;

        if(par1World.isBlockNormalCube(x, y+1, z) || par1World.getBlockId(x, y+1, z) == Block.fence.blockID)
        	var6 = 5;
        else if(par1World.isBlockNormalCube(x+1, y, z))
        	var6 = 1;
        else if(par1World.isBlockNormalCube(x-1, y, z))
        	var6 = 3;
        else if(par1World.isBlockNormalCube(x, y, z+1))
        	var6 = 2;
        else if(par1World.isBlockNormalCube(x, y, z-1))
        	var6 = 4;
        
        par1World.setBlockAndMetadata(x, y, z, this.blockID, var6);
        
    }

    /**
     * Get the block's damage value (for use with pick block).
     */
	@Override
    public int getDamageValue(World par1World, int par2, int par3, int par4)
    {
    	TileEntityLantern te = (TileEntityLantern) par1World.getBlockTileEntity(par2, par3, par4);
        return te.color;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
	@Override
    public int quantityDropped(Random par1Random)
    {
        return 0;
    }

	@Override
    public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6)
    {
       	spawnItem(par1World, par2, par3, par4);
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }
    
    public void spawnItem(World par1World, int par2, int par3, int par4) 
    {
    	TileEntity te = par1World.getBlockTileEntity(par2, par3, par4);
    	int id = par1World.getBlockId(par2, par3, par4);
    	if(te != null && id == 0)
    	{
    		int color = ((TileEntityLantern)te).color;
	    	ItemStack par5ItemStack = new ItemStack(this, 1, color);
	        float var6 = 0.7F;
	        double var7 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	        double var9 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	        double var11 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
	        EntityItem var13 = new EntityItem(par1World, (double)par2 + var7, (double)par3 + var9, (double)par4 + var11, par5ItemStack);
	        var13.delayBeforeCanPickup = 10;
	        if(!par1World.isRemote)
	        	par1World.spawnEntityInWorld(var13);
    	}
    }


    /**
     * Spawns EntityItem in the world for the given ItemStack if the world is not remote.
     */
    /*
    protected void dropBlockAsItem_do(World par1World, int par2, int par3, int par4, ItemStack par5ItemStack)
    {
        if (!par1World.isRemote && par1World.func_82736_K().func_82766_b("doTileDrops"))
        {
        	int color = 0;
        	if(par1World.getBlockTileEntity(par2, par3, par4) != null)
        		color = ((TileEntityLantern)par1World.getBlockTileEntity(par2, par3, par4)).color;
        	par5ItemStack.setItemDamage(color);
            float var6 = 0.7F;
            double var7 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var9 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            double var11 = (double)(par1World.rand.nextFloat() * var6) + (double)(1.0F - var6) * 0.5D;
            EntityItem var13 = new EntityItem(par1World, (double)par2 + var7, (double)par3 + var9, (double)par4 + var11, par5ItemStack);
            var13.delayBeforeCanPickup = 10;
            //par1World.spawnEntityInWorld(var13);
        }
    }
    */
    
    @Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 8; n++) {
			par3List.add(new ItemStack(this, 1, n));

		}
	}
}
