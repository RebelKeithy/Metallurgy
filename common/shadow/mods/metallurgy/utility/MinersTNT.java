package shadow.mods.metallurgy.utility;

import net.minecraft.src.BlockTNT;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.World;

public class MinersTNT extends BlockTNT{

	public MinersTNT(int par1, int par2) {
		super(par1, par2);
		this.setCreativeTab(MetallurgyUtility.creativeTab);
	}

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 0 ? this.blockIndexInTexture + 2 : (par1 == 1 ? this.blockIndexInTexture + 1 : this.blockIndexInTexture);
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
	@Override
    public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            EntityMinersTNTPrimed var5 = new EntityMinersTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
            var5.fuse = par1World.rand.nextInt(var5.fuse / 4) + var5.fuse / 8;
            par1World.spawnEntityInWorld(var5);
        }
    }

    /**
     * Called right before the block is destroyed by a player.  Args: world, x, y, z, metaData
     */
	@Override
    public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if ((par5 & 1) == 1)
            {
            	EntityMinersTNTPrimed var6 = new EntityMinersTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
                par1World.spawnEntityInWorld(var6);
                par1World.playSoundAtEntity(var6, "random.fuse", 1.0F, 1.0F);
            }
        }
    }


}
