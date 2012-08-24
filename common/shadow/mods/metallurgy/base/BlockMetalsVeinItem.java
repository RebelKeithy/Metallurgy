package shadow.mods.metallurgy.base;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockMetalsVeinItem extends ItemBlock {
	public BlockMetalsVeinItem(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

    @Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "CopperOre";
			break;
		}
		case 1: {
			name = "TinOre";
			break;
		}
		case 2: {
			name = "IronOre";
			break;
		}
		case 3: {
			name = "ManganeseOre";
			break;
		}
		case 4: {
			name = "GoldOre";
			break;
		}
		default:
			name = "ore";
		}
		return getItemName() + "." + name;
	}
}