package shadow.mods.metallurgy.base;

import java.util.List;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class ItemBlockMetalLadder extends ItemBlock{

	public ItemBlockMetalLadder(int par1) {
		super(par1);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@Override
    public void addInformation(ItemStack par1ItemStack, List par2List)
    {
    	par2List.add(par1ItemStack.itemID + ":" + par1ItemStack.getItemDamage());
    }

    @Override
	public String getItemNameIS(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		if(meta == 0)
			return getItemName() + "." + "Copper";
		if(meta == 0)
			return getItemName() + "." + "Bronze";
		if(meta == 0)
			return getItemName() + "." + "Iron";
		if(meta == 0)
			return getItemName() + "." + "Steel";
		return "unknown";
	}
}
