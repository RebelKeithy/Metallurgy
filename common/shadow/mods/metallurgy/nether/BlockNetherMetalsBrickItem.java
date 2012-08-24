package shadow.mods.metallurgy.nether;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockNetherMetalsBrickItem extends ItemBlock{
	public BlockNetherMetalsBrickItem(int i) {
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
		return getItemName() + "." + OreNether.name[meta];
	}
}
