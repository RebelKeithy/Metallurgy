package shadow.mods.metallurgy.fantasy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;

public class mod_FantasyFurnace {
	public static String texturePath = "/shadow/MetallurgyFantasyFurnace.png";

	public static int furnaceID = 925;
	public static int furnaceOnID = 926;
	
	public static Block metalFurnace = new FF_BlockMetalFurnace(furnaceID, false).setHardness(3.5F).setBlockName("MetalFantasyFurnace");
	public static Block metalFurnaceOn = new FF_BlockMetalFurnace(furnaceOnID, true).setHardness(3.5F).setBlockName("MetalFantasyFurnace");	
	
	public static void load()
	{

		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.fantasy.FF_BlockMetalFurnaceItem.class);
		GameRegistry.registerTileEntity(FF_TileEntityMetalFurnace.class, "metalFantasyFurnace");
		
		/*
		if(BaseConfig.copperEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyOreCopper.CopperBar, Character.valueOf('F'), Block.stoneOvenIdle
			});
		}
		if(BaseConfig.bronzeEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyAlloyBronze.BronzeBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 0)
			});
		}
		if(BaseConfig.ironEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 1)
			});
		}
		if(BaseConfig.steelEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 3), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyAlloySteel.SteelBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
			});
		}
		*/
	}
}
