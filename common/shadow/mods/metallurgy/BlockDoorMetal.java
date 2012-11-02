package shadow.mods.metallurgy;

import java.util.Random;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

import net.minecraft.src.BlockDoor;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockDoorMetal extends BlockDoor {

	public int itemID;
	
	public BlockDoorMetal(int par1, Material par2Material, int id) {
		super(par1, par2Material);
		itemID = id;
	}
	
    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return (par1 & 8) != 0 ? 0 : (this.blockMaterial == Material.iron ? MetallurgyBaseMetals.copperItemDoor.shiftedIndex : MetallurgyBaseMetals.copperItemDoor.shiftedIndex);
    }

    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
    	System.out.println("check");
    	if(par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
    		System.out.println("powerered");
    	super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    }
    
    /**
     * A function to open a door.
     */
    public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5)
    {
        int var6 = this.getFullMetadata(par1World, par2, par3, par4);
        boolean var7 = (var6 & 4) != 0;

    	System.out.println("changing block state" + var6 + " " + var7 + " " + par5);
    	
        if (var7 != par5)
        {
        	System.out.println("needs to be changed");
            int var8 = var6 & 7;
            var8 ^= 4;

            if ((var6 & 8) == 0)
            {
                par1World.setBlockMetadataWithNotify(par2, par3, par4, var8);
                par1World.markBlocksDirty(par2, par3, par4, par2, par3, par4);
            }
            else
            {
                par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, var8);
                par1World.markBlocksDirty(par2, par3 - 1, par4, par2, par3, par4);
            }

            par1World.playAuxSFXAtEntity((EntityPlayer)null, 1003, par2, par3, par4, 0);
        }
    }
}
