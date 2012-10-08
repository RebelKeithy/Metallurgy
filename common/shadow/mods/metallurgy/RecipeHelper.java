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
		ModLoader.addShapelessRecipe(new ItemStack(ingot, 4, Itemmeta), new Object[] {new ItemStack(blockID, 1, meta)});
		ModLoader.addRecipe(new ItemStack(blockID, 1, meta), new Object[]
        {
            "##", "##", Character.valueOf('#'), new ItemStack(ingot, 1, Itemmeta)
        });
	}
	public static void addBrickRecipes(int blockID, int meta, Item ingot)
	{
		addBrickRecipes(blockID, meta, ingot, 0);
	}

	public static void addPlateRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "X X", "XXX", "XXX", Character.valueOf('X'), ingot
		}); 
	}
	public static void addPlateRecipe(Item result, Item ingot)
	{
		addPlateRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}
	
	public static void addHelmetRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "XXX", "X X", Character.valueOf('X'), ingot
	    }); 
	}
	public static void addHelmetRecipe(Item result, Item ingot)
	{
		addHelmetRecipe(new ItemStack(result, 1), new ItemStack (ingot, 1));
	}
	
	public static void addLegsRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "XXX", "X X", "X X", Character.valueOf('X'), ingot
	    }); 
	}
	public static void addLegsRecipe(Item result, Item ingot)
	{
		addLegsRecipe(new ItemStack(result, 1), new ItemStack (ingot, 1));
	}
	
	public static void addBootsRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "X X", "X X", Character.valueOf('X'), ingot
	    }); 
	}
	public static void addBootsRecipe(Item result, Item ingot)
	{
		addBootsRecipe(new ItemStack(result, 1), new ItemStack (ingot, 1));
	}
	
	public static void addSwordRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "X", "X", "S", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick
	    }); 
	}
	public static void addSwordRecipe(Item result, Item ingot)
	{
		addSwordRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}
	
	public static void addPickaxeRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "XXX", " S ", " S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick
	    }); 
	}
	public static void addPickaxeRecipe(Item result, Item ingot)
	{
		addPickaxeRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}

	public static void addAxeRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "XX", "SX", "S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick
	    }); 
	}
	public static void addAxeRecipe(Item result, Item ingot)
	{
		addAxeRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}
	
	public static void addShovelRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "X", "S", "S", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick
	    }); 
	}
	public static void addShovelRecipe(Item result, Item ingot)
	{
		addShovelRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}
	
	public static void addHoeRecipe(ItemStack result, ItemStack ingot)
	{
		GameRegistry.addRecipe(result, new Object[]{
		    "XX", "S ", "S ", Character.valueOf('X'), ingot, Character.valueOf('S'), Item.stick
	    }); 
	}
	public static void addHoeRecipe(Item result, Item ingot)
	{
		addHoeRecipe(new ItemStack(result, 1), new ItemStack(ingot, 1));
	}
	
	public static void addBucketRecipe(ItemStack ingot)
	{
	    ModLoader.addRecipe(new ItemStack(Item.bucketEmpty, 1), new Object[]{
	    "   ", "X X", " X ", Character.valueOf('X'), ingot
	    });
	}
	public static void addBucketRecipe(Item ingot)
	{
		addBucketRecipe(new ItemStack(ingot, 1));
	}
	
	public static void addShearsRecipe(ItemStack ingot)
	{
	    ModLoader.addRecipe(new ItemStack(Item.shears, 1), new Object[]{
	    " X", "X ", Character.valueOf('X'), ingot
	    });
	}
	public static void addShearsRecipe(Item ingot)
	{
		addShearsRecipe(new ItemStack(ingot, 1));
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
