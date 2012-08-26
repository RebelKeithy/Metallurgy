package shadow.mods.metallurgy.nether;

import cpw.mods.fml.common.IFuelHandler;
import shadow.mods.metallurgy.MetallurgyItem;
import net.minecraft.src.ItemStack;

public class NetherFuelDust implements IFuelHandler{
 

	@Override
	public int getBurnTime(ItemStack stack) {
		if(stack.itemID == OreNether.Dust[0].shiftedIndex)
			return 6400;
		if(stack.itemID == OreNether.Dust[6].shiftedIndex)
			return 51200;
		return 0;
	}

}
