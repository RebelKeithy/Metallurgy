package shadow.mods.metallurgy.base;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class FurnaceUpgradeRecipes {
	
	public static void load()
	{
		
		ShapedOreRecipe copperRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 0),
				"XXX", "XFX", "XXX", 'X', "ingotCopper", 'F', Block.stoneOvenIdle);
		CraftingManager.getInstance().getRecipeList().add(copperRecipe);
		
		ShapedOreRecipe bronzeRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 1),
				"XXX", "XFX", "XXX", 'X', "ingotBronze", 'F', new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 0));
		CraftingManager.getInstance().getRecipeList().add(bronzeRecipe);
		
		CraftingManager.getInstance().addRecipe(new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 2),
				"XXX", "XFX", "XXX", 'X', Item.ingotIron, 'F', new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 1));
		
		ShapedOreRecipe steelRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 3),
				"XXX", "XFX", "XXX", 'X', "ingotSteel", 'F', new ItemStack(MetallurgyBaseMetals.metalFurnace, 1, 2));
		CraftingManager.getInstance().getRecipeList().add(steelRecipe);
	}
}
