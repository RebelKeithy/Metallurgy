package shadow.mods.metallurgy.base;

import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockMetalLadder extends ItemBlock {

	public ItemBlockMetalLadder(int par1) {
		super(par1);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata * 4;
	}
	
    public int getIconFromDamage(int par1)
    {
    	return this.iconIndex + par1;
    }

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "Copper";
			break;
		}
		case 1: {
			name = "Bronze";
			break;
		}
		case 2: {
			name = "Iron";
			break;
		}
		case 3: {
			name = "Steel";
			break;
		}
		default:
			name = "Copper";
		}
		return getItemName() + "." + name;
	}
}
