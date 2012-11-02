package shadow.mods.metallurgy.base;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BF_BlockMetalFurnaceItem extends ItemBlock {
	
	public BF_BlockMetalFurnaceItem(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "CopperFurnace";
			break;
		}
		case 1: {
			name = "BronzeFurnace";
			break;
		}
		case 2: {
			name = "IronFurnace";
			break;
		}
		case 3: {
			name = "SteelFurnace";
			break;
		}
		default:
			name = "brick";
		}
		return getItemName() + "." + name;
	}
}
