package shadow.mods.metallurgy.utility;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockVeinItem extends ItemBlock {
	public BlockVeinItem(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "PhosphoriteOre";
			break;
		}
		case 1: {
			name = "SulfurOre";
			break;
		}
		case 2: {
			name = "SaltpeterOre";
			break;
		}
		case 3: {
			name = "MagnesiumOre";
			break;
		}
		case 4: {
			name = "BitumenOre";
			break;
		}
		case 5: {
			name = "PotashOre";
			break;
		}
		default:
			name = "ore";
		}
		return getItemName() + "." + name;
	}
}