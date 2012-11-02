package shadow.mods.metallurgy;

import java.util.List;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class MetallurgyItemBlock extends ItemBlock{

	public MetallurgyItemBlock(int par1) {
		super(par1);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int metadata) {
		return metadata;
	}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	//par2List.add(par1ItemStack.itemID + ":" + par1ItemStack.getItemDamage());
    }

    @Override
	public String getItemNameIS(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		return getItemName() + "." + meta;
	}
}
