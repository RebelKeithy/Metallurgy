package shadow.mods.metallurgy;

import java.util.ArrayList;

import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import net.minecraft.src.Block;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.ShapelessOreRecipe;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHelper {

	public static void addBrickRecipes(int blockID, int meta, Item ingot, int Itemmeta)
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ingot, 1, Itemmeta), new Object[] {new ItemStack(blockID, 1, meta)});
		GameRegistry.addRecipe(new ItemStack(blockID, 4, meta), "##", "##", Character.valueOf('#'), new ItemStack(ingot, 1, Itemmeta));
	}
	public static void addBrickRecipes(int blockID, int meta, Item ingot)
	{
		addBrickRecipes(blockID, meta, ingot, 0);
	}

	public static void addBrickRecipes(int blockID, int meta, String ingot)
	{
		//GameRegistry.addRecipe(new ShapelessOreRecipe(ingot, new Object[] {new ItemStack(blockID, 1, meta)}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(blockID, 4, meta), "##", "##", Character.valueOf('#'), ingot));
	}

	public static void addPlateRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "X X", "XXX", "XXX", Character.valueOf('X'), ingot)); 
	}
	public static void addPlateRecipe(Item result, String ingot)
	{
		addPlateRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addHelmetRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "XXX", "X X", Character.valueOf('X'), ingot)); 
	}
	public static void addHelmetRecipe(Item result, String ingot)
	{
		addHelmetRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addLegsRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "XXX", "X X", "X X", Character.valueOf('X'), ingot)); 
	}
	public static void addLegsRecipe(Item result, String ingot)
	{
		addLegsRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addBootsRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "X X", "X X", Character.valueOf('X'), ingot)); 
	}
	public static void addBootsRecipe(Item result, String ingot)
	{
		addBootsRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addSwordRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "X", "X", "S", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick)); 
	}
	public static void addSwordRecipe(Item result, String ingot)
	{
		addSwordRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addPickaxeRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "XXX", " S ", " S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick)); 
	}
	public static void addPickaxeRecipe(Item result, String ingot)
	{
		addPickaxeRecipe(new ItemStack(result, 1), ingot);
	}

	public static void addAxeRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "XX", "SX", "S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick)); 
	}
	public static void addAxeRecipe(Item result, String ingot)
	{
		addAxeRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addShovelRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "X", "S", "S", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick)); 
	}
	public static void addShovelRecipe(Item result, String ingot)
	{
		addShovelRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addHoeRecipe(ItemStack result, String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(result, "XX", "S ", "S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick)); 
	}
	public static void addHoeRecipe(Item result, String ingot)
	{
		addHoeRecipe(new ItemStack(result, 1), ingot);
	}
	
	public static void addBucketRecipe(String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.bucketEmpty, 1), "   ", "X X", " X ", Character.valueOf('X'), ingot));
	}
	
	public static void addShearsRecipe(String ingot)
	{
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Item.shears, 1), " X", "X ", Character.valueOf('X'), ingot));
	}
	
	public static void addRailsRecipe(Item ingot, int amount)
	{
		ModLoader.addRecipe(new ItemStack(Block.rail, amount), new Object[] {
			"X X", "X|X", "X X", Character.valueOf('X'), ingot, Character.valueOf('|'), Item.stick
		});
	}
	
	public static void addPoweredRailsRecipe(Item ingot, int amount)
	{
		ModLoader.addRecipe(new ItemStack(Block.railPowered, amount), new Object[] {
			"X X", "X|X", "X X", Character.valueOf('X'), ingot, Character.valueOf('|'), Item.stick
		});
	}
	
	public static void addPoweredRailsRecipe(String ingot, int amount)
	{
		CraftingManager.getInstance().getRecipeList().add(
			new ShapedOreRecipe(new ItemStack(Block.railPowered, amount),
					"X X", "X|X", "X X", Character.valueOf('X'), ingot, Character.valueOf('|'), Item.stick));
	}
	
	public static void addStorageRecipe(ItemStack storage, ItemStack item)
	{
		
		ModLoader.addShapelessRecipe(new ItemStack(item.getItem(), 9, item.getItemDamage()), new Object[] {storage});
		ModLoader.addRecipe(new ItemStack(storage.getItem(), 1, storage.getItemDamage()), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), item
		});
	}
	
	public static void addStorageRecipe(Item storage, Item item)
	{
		ModLoader.addShapelessRecipe(new ItemStack(item, 9), new Object[] {storage});
		ModLoader.addRecipe(new ItemStack(storage, 1), new Object[] {
			"XXX", "XXX", "XXX", Character.valueOf('X'), item
		});
	}
	
	public static void addAlloyRecipe(ItemStack alloy, String dust1, String dust2)
	{
		ShapelessOreRecipe alloyRecipe = new ShapelessOreRecipe(alloy, dust1, dust2);
		CraftingManager.getInstance().getRecipeList().add(alloyRecipe);
	}

}
