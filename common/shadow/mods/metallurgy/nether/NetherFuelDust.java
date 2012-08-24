package shadow.mods.metallurgy.nether;

import cpw.mods.fml.common.IFuelHandler;
import shadow.mods.metallurgy.MetallurgyItem;
import net.minecraft.src.ItemStack;

public class NetherFuelDust extends MetallurgyItem implements IFuelHandler{
 
	public int burnTime;
	
	public NetherFuelDust(int id, String s, int time)
	{
		super(id, s);
		burnTime = time;
	}
	
	private NetherFuelDust(int i, String s) {
		super(i, s);
	}

	@Override
	public int getBurnTime(ItemStack stack) {
		return burnTime;
	}

}
