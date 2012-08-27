package shadow.mods.metallurgy.fantasy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;

public class mod_FantasyFurnace {
	public static String texturePath = "/shadow/MetallurgyFantasyFurnace.png";

	public static int furnaceID = 922;
	public static int furnaceOnID = 923;
	
	public static Block metalFurnace = new FF_BlockMetalFurnace(furnaceID, false).setHardness(3.5F).setBlockName("MetalFantasyFurnace");
	public static Block metalFurnaceOn = new FF_BlockMetalFurnace(furnaceOnID, true).setHardness(3.5F).setBlockName("MetalFantasyFurnace");	
	
	public static void load()
	{

		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.fantasy.FF_BlockMetalFurnaceItem.class);
		GameRegistry.registerTileEntity(FF_TileEntityMetalFurnace.class, "metalFantasyFurnace");
		
		
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 0), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[0], Character.valueOf('F'), Block.stoneOvenIdle
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 1), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[1], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 0)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.alloys.Bar[0], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 1)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[3], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 4), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[4], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 5), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[7], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 4)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 6), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.alloys.Bar[2], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 5)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 7), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[9], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 6)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 8), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[10], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 7)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 9), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.ores.Bar[11], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 8)
		});
		ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 10), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyFantasy.alloys.Bar[4], Character.valueOf('F'), new ItemStack(metalFurnace, 1, 9)
		});
		
	}
}
