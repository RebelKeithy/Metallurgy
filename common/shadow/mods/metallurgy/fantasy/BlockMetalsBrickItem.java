package shadow.mods.metallurgy.fantasy;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockMetalsBrickItem extends ItemBlock {
	public BlockMetalsBrickItem(int i) {
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
			name = "PrometheumBrick";
			break;
		}
		case 1: {
			name = "DeepIronBrick";
			break;
		}
		case 2: {
			name = "InfuscoliumBrick";
			break;
		}
		case 3: {
			name = "OureclaseBrick";
			break;
		}
		case 4: {
			name = "AredriteBrick";
			break;
		}
		case 5: {
			name = "AstralSilverBrick";
			break;
		}
		case 6: {
			name = "CarmotBrick";
			break;
		}
		case 7: {
			name = "MithrilBrick";
			break;
		}
		case 8: {
			name = "RubraciumBrick";
			break;
		}
		case 9: {
			name = "OrichalcumBrick";
			break;
		}
		case 10: {
			name = "AdamantineBrick";
			break;
		}
		case 11: {
			name = "AtlarusBrick";
			break;
		}
		default:
			name = "Brick";
		}
		return getItemName() + "." + name;
	}
}