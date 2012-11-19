package shadow.mods.metallurgy.utility;

import net.minecraft.src.BlockTNT;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntityTNTPrimed;
import net.minecraft.src.Item;
import net.minecraft.src.World;

public class LargeTNT extends BlockTNT{

	public LargeTNT(int par1, int par2) {
		super(par1, par2);
		this.setCreativeTab(MetallurgyUtility.creativeTab);
	}

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par5EntityPlayer.getCurrentEquippedItem() != null && isActivator(par5EntityPlayer.getCurrentEquippedItem().itemID))
        {
            this.onBlockDestroyedByPlayer(par1World, par2, par3, par4, 1);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
            return true;
        }
        else
        {
            return super.onBlockActivated(par1World, par2, par3, par4, par5EntityPlayer, par6, par7, par8, par9);
        }
    }
    
    public boolean isActivator(int id)
    {
    	if(id == Item.flintAndSteel.shiftedIndex || id == MetallurgyUtility.match.shiftedIndex || id == MetallurgyUtility.igniter.shiftedIndex)
    		return true;
    	else
    		return false;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
	@Override
    public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
        	EntityLargeTNTPrimed var5 = new EntityLargeTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
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
            	EntityLargeTNTPrimed var6 = new EntityLargeTNTPrimed(par1World, (double)((float)par2 + 0.5F), (double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F));
                par1World.spawnEntityInWorld(var6);
                par1World.playSoundAtEntity(var6, "random.fuse", 1.0F, 1.0F);
            }
        }
    }


}
