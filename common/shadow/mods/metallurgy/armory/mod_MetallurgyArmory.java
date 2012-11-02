package shadow.mods.metallurgy.armory;

import net.minecraft.src.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.event.FMLInitializationEvent;

//@Mod(modid = "MetallurgyArmory", name = "Metallurgy Armory", dependencies = "after:MetallurgyCore", version = "2.0")
public class mod_MetallurgyArmory {
	
	Item shruiken = new ItemShuriken(9120);
	
	//@Init
	public void load(FMLInitializationEvent event)
	{
		
	}
}
