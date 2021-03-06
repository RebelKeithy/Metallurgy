package shadow.mods.metallurgy.nether;

import cpw.mods.fml.common.IFuelHandler;
import shadow.mods.metallurgy.MetallurgyItem;
import net.minecraft.src.ItemStack;

public class NetherFuelDust implements IFuelHandler{
 

	@Override
	public int getBurnTime(ItemStack stack) {
		if(stack.itemID == MetallurgyNether.ores.Dust[0].shiftedIndex)
			return 3200;
		if(stack.itemID == MetallurgyNether.ores.Dust[6].shiftedIndex)
			return 25600;
		return 0;
	}

}
