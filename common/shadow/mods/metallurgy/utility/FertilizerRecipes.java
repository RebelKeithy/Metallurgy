package shadow.mods.metallurgy.utility;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;

public class FertilizerRecipes 
{
	public static void load()
	{
		ShapelessOreRecipe fert1 = new ShapelessOreRecipe(new ItemStack(MetallurgyUtility.fertilizer, 8),
				"itemPhosphorus", "itemMagnesium", "itemPotash");
		ShapelessOreRecipe fert2 = new ShapelessOreRecipe(new ItemStack(MetallurgyUtility.fertilizer, 8),
				"itemPhosphorus", "itemMagnesium", "itemSaltpeter");
		ShapelessOreRecipe fert3 = new ShapelessOreRecipe(new ItemStack(MetallurgyUtility.fertilizer, 8),
				"itemPhosphorus", "itemSaltpeter", "itemPotash");
		ShapelessOreRecipe fert4 = new ShapelessOreRecipe(new ItemStack(MetallurgyUtility.fertilizer, 8),
				"itemSaltpeter", "itemMagnesium", "itemPotash");

		ShapelessOreRecipe gunpowder1 = new ShapelessOreRecipe(new ItemStack(Item.gunpowder, 4),
				new ItemStack(Item.coal, 1, 1), "itemSulfur", "itemSaltpeter");
		
		CraftingManager.getInstance().getRecipeList().add(fert1);
		CraftingManager.getInstance().getRecipeList().add(fert2);
		CraftingManager.getInstance().getRecipeList().add(fert3);
		CraftingManager.getInstance().getRecipeList().add(fert4);
		CraftingManager.getInstance().getRecipeList().add(gunpowder1);
		
		ModLoader.addSmelting(MetallurgyUtility.bitumen.shiftedIndex, new ItemStack(MetallurgyUtility.tar, 1));
		
		GameRegistry.addRecipe(new ItemStack(Block.pistonStickyBase, 1), new Object[] {
			"X", "|", Character.valueOf('X'), MetallurgyUtility.tar, Character.valueOf('|'), Block.pistonBase
		});
		GameRegistry.addShapelessRecipe(new ItemStack(Item.magmaCream, 1), MetallurgyUtility.tar, Item.blazePowder);
		
		ShapedOreRecipe matchRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyUtility.match, 4), new Object[] {
			"X", "|", 'X', "itemPhosphorus", '|', Item.stick
		});
		ShapedOreRecipe igniterRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyUtility.igniter, 1), new Object[] {
			"M ", " F", 'M', "itemMagnesium", 'F', Item.flint
		});
		
		GameRegistry.addRecipe(matchRecipe);
		GameRegistry.addRecipe(igniterRecipe);
	}
}
