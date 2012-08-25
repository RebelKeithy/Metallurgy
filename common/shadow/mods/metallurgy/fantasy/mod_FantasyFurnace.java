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
		
		
		if(FantasyConfig.prometheumEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OrePrometheum.prometheumBar, Character.valueOf('F'), Block.stoneOvenIdle
			});
		}
		if(FantasyConfig.deepIronEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreDeepIron.deepIronBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 0)
			});
		}
		if(FantasyConfig.blackSteelEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), AlloyBlackSteel.blackSteelBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 1)
			});
		}
		if(FantasyConfig.oureclaseEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 3), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreOureclase.oureclaseBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
			});
		}
		if(FantasyConfig.aredriteEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreAredrite.aredriteBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
			});
		}
		if(FantasyConfig.mithrilEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 5), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreMithril.mithrilBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 4)
			});
		}
		if(FantasyConfig.haderothEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 6), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), AlloyHaderoth.haderothBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 5)
			});
		}
		if(FantasyConfig.orichalcumEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 7), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreOrichalcum.orichalcumBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 6)
			});
		}
		if(FantasyConfig.adamantineEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 8), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreAdamantine.adamantineBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 7)
			});
		}
		if(FantasyConfig.atlarusEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 9), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreAtlarus.atlarusBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 8)
			});
		}
		if(FantasyConfig.tartariteEnabled)
		{
			ModLoader.addRecipe(new ItemStack(metalFurnace, 1, 10), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), AlloyTartarite.tartariteBar, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 9)
			});
		}
		
	}
}
