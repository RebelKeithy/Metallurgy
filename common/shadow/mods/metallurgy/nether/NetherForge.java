package shadow.mods.metallurgy.nether;

import shadow.mods.metallurgy.MetallurgyCore;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;

public class NetherForge {
	public static Block metalFurnace;
	
	//public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void init()
	{
		try
		{
			metalFurnace = new NF_BlockNetherForge(ConfigNether.furnaceID, false).setHardness(3.5F).setBlockName("NetherForge");
		}
		catch(IllegalArgumentException e)
		{
			MetallurgyCore.blockError(e);
		    throw e;
		}
	}
	
	public static void load()
	{
		if(ConfigNether.furnaceEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 0),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[0], Character.valueOf('F'), Block.stoneOvenIdle);
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 1),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[1], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 0));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 2),
				"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(MetallurgyNether.alloys.Bar[0], 1), Character.valueOf('F'), new ItemStack(metalFurnace, 1, 1));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 3),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[3], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 4),
				"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(MetallurgyNether.alloys.Bar[1], 1), Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 5),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[5], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 4));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 6),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[6], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 5));
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 7),
				"XXX", "XFX", "XXX", Character.valueOf('X'), MetallurgyNether.ores.Bar[7], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 6));
		}
	}
}
