package shadow.mods.metallurgy.fantasy;

import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockAlloysBrickItem extends ItemBlock {
	public BlockAlloysBrickItem(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "unknown Fantasy";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "BlackSteelBrick";
			break;
		}
		case 1: {
			name = "QuicksilverBrick";
			break;
		}
		case 2: {
			name = "HaderothBrick";
			break;
		}
		case 3: {
			name = "CelenegilBrick";
			break;
		}
		case 4: {
			name = "TartariteBrick";
			break;
		}
		default:
			name = "Brick";
		}
		return getItemName() + "." + name;
	}
}