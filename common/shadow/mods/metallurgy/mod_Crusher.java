package shadow.mods.metallurgy;

import shadow.mods.metallurgy.base.BaseConfig;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;

public class mod_Crusher {
	
	public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void load()
	{

		
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 0), new Object[] {
			"XSX", "SFS", "XSX", Character.valueOf('X'), Block.cobblestone, Character.valueOf('S'), Item.stick, Character.valueOf('F'), Block.stoneOvenIdle
		});
		
    	for(ItemStack copper : OreDictionary.getOres("ingotCopper"))
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), copper, Character.valueOf('F'), mod_MetallurgyCore.crusher
			});
    	
    	for(ItemStack bronze : OreDictionary.getOres("ingotBronze"))
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), bronze, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 1)
			});

		ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 2)
		});
		
    	for(ItemStack steel : OreDictionary.getOres("ingotSteel"))
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), steel, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 3)
			});
	}
}
