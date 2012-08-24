package shadow.mods.metallurgy.nether;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockNetherAlloysBrickItem extends ItemBlock {
	public BlockNetherAlloysBrickItem(int i) {
		super(i);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}

    @Override
	public String getItemNameIS(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		return getItemName() + "." + AlloyNether.name[meta];
	}
}
