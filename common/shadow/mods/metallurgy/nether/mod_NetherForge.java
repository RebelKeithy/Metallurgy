package shadow.mods.metallurgy.nether;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;

public class mod_NetherForge {
	public static Block metalFurnace;
	
	//public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void init()
	{
		metalFurnace = new NF_BlockNetherForge(NetherConfig.furnaceID, false).setHardness(3.5F).setBlockName("NetherForge");
	}
	
	public static void load()
	{
		
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 0), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[0], Character.valueOf('F'), Block.stoneOvenIdle
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 1), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[1], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 0)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(mod_MetallurgyNether.alloys.Bar[0], 1), Character.valueOf('F'), new ItemStack(metalFurnace, 1, 1)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[3], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 4), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(mod_MetallurgyNether.alloys.Bar[1], 1), Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 5), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[5], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 4)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 6), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[6], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 5)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 7), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyNether.ores.Bar[7], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 6)
		});
	}
}
