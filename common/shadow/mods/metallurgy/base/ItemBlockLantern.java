package shadow.mods.metallurgy.base;

import net.minecraft.src.Block;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;

public class ItemBlockLantern extends ItemBlock
{
	public ItemBlockLantern(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

    /**
     * Called to actually place the block, after the location is determined
     * and all permission checks have been made.
     * 
     * @param stack The item stack that was used to place the block. This can be changed inside the method.
     * @param player The player who is placing the block. Can be null if the block is not being placed by a player.
     * @param side The side the player (or machine) right-clicked on.
     */
	@Override
    public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ, int metadata)
    {
       if (!world.setBlockAndMetadataWithNotify(x, y, z, MetallurgyBaseMetals.lantern.blockID, this.getMetadata(stack.getItemDamage())))
       {
               return false;
       }

       if (world.getBlockId(x, y, z) == MetallurgyBaseMetals.lantern.blockID)
       {
    	   //Block.blocksList[MetallurgyBaseMetals.lantern.blockID].func_85104_a(par1World, par2, par3, par4, par5, par6, par7, par8, par9)
           Block.blocksList[MetallurgyBaseMetals.lantern.blockID].func_85104_a(world, x, y, z, side, hitX, hitY, hitZ, metadata);
           Block.blocksList[MetallurgyBaseMetals.lantern.blockID].onBlockPlacedBy(world, x, y, z, player);
           TileEntity le = new TileEntityLantern(stack.getItemDamage());
           world.setBlockTileEntity(x, y, z, le);
       }

       return true;
    }

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "red";
			break;
		}
		case 1: {
			name = "green";
			break;
		}
		case 2: {
			name = "blue";
			break;
		}
		case 3: {
			name = "orange";
			break;
		}
		case 4: {
			name = "yellow";
			break;
		}
		case 5: {
			name = "purple";
			break;
		}
		case 6: {
			name = "grey";
			break;
		}
		case 7: {
			name = "white";
			break;
		}
		default:
			name = "red";
		}
		return getItemName() + "." + name;
	}

}
