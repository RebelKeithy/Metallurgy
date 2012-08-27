package shadow.mods.metallurgy;

import shadow.mods.metallurgy.base.BaseConfig;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;

public class mod_Crusher {
	
	public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void load()
	{

		
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 0), new Object[] {
			"XSX", "SFS", "XSX", Character.valueOf('X'), Block.cobblestone, Character.valueOf('S'), Item.stick, Character.valueOf('F'), Block.stoneOvenIdle
		});
		
		try {
			Class a = Class.forName("shadow.mods.metallurgy.base.BaseConfig");
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.ores.Bar[0], Character.valueOf('F'), mod_MetallurgyCore.crusher
			});
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.alloys.Bar[0], Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 1)
			});
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 3), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 2)
			});
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), mod_MetallurgyBaseMetals.alloys.Bar[4], Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 3)
			});
		} catch (ClassNotFoundException e) {
			System.out.println("Base not found, crusher upgrade recipes not added: " + e);
		}
	}
}
