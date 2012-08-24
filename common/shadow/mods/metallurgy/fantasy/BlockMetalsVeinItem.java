package shadow.mods.metallurgy.fantasy;

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
			name = "PrometheumOre";
			break;
		}
		case 1: {
			name = "DeepIronOre";
			break;
		}
		case 2: {
			name = "InfuscoliumOre";
			break;
		}
		case 3: {
			name = "OureclaseOre";
			break;
		}
		case 4: {
			name = "AredriteOre";
			break;
		}
		case 5: {
			name = "AstralSilverOre";
			break;
		}
		case 6: {
			name = "CarmotOre";
			break;
		}
		case 7: {
			name = "MithrilOre";
			break;
		}
		case 8: {
			name = "RubraciumOre";
			break;
		}
		case 9: {
			name = "OrichalcumOre";
			break;
		}
		case 10: {
			name = "AdamantineOre";
			break;
		}
		case 11: {
			name = "AtlarusOre";
			break;
		}
		default:
			name = "ore";
		}
		return getItemName() + "." + name;
	}
}