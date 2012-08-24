package shadow.mods.metallurgy.base;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;

public class mod_Furnace {
	
	public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void load()
	{
		if(BaseConfig.copperEnabled)
		{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), OreCopper.CopperBar, Character.valueOf('F'), Block.stoneOvenIdle
			});
		}
		if(BaseConfig.bronzeEnabled)
		{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), AlloyBronze.BronzeBar, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0)
			});
		}
		if(BaseConfig.ironEnabled)
		{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1)
			});
		}
		if(BaseConfig.steelEnabled)
		{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 3), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), AlloySteel.SteelBar, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2)
			});
		}
	}
}
