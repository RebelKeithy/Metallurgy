package shadow.mods.metallurgy.base;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;

public class mod_Furnace {
	
	public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void load()
	{
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.ores.Bar[0], Character.valueOf('F'), Block.stoneOvenIdle
		});
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.alloys.Bar[0], Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0)
		});
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1)
		});
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.alloys.Bar[4], Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2)
		});
	}
}
