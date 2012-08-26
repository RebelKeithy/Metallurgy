package shadow.mods.metallurgy;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class MetallurgyBlockItem extends ItemBlock {
	public MetallurgyBlockItem(int i) {
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
		//return getItemName() + "." + AlloyNether.name[meta];
		return "";
	}
}
