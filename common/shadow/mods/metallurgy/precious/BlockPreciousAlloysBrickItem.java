package shadow.mods.metallurgy.precious;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockPreciousAlloysBrickItem extends ItemBlock {
	public BlockPreciousAlloysBrickItem(int i) {
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
			name = "BrassBrick";
			break;
		}
		case 1: {
			name = "ElectrumBrick";
			break;
		}
		default:
			name = "ore";
		}
		return getItemName() + "." + name;
	}
}
