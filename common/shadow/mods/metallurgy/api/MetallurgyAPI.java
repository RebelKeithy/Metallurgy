package shadow.mods.metallurgy.api;

import java.lang.reflect.Method;

import net.minecraft.src.ItemStack;

public class MetallurgyAPI
{
	private static Class metallurgyItems;
	private static Method getItem;

	private static Class crusherRecipes;
	private static Method addCrushing;

	private static Class abstractorRecipes;
	private static Method addAbstraction;
	private static Method addAbstractorFuel;

	private static Class mintRecipes;
	private static Method addMinting;
	
	public static ItemStack getItem(String name)
	{	
		try 
		{
			if (metallurgyItems == null) 
				metallurgyItems = Class.forName("shadow.mods.metallurgy.MetallurgyItems");
			if(getItem == null)
				getItem = metallurgyItems.getDeclaredMethod("getItem", new Class[] {String.class});
			Object item = getItem.invoke(metallurgyItems, new Object[] {name});
			
			if (item instanceof ItemStack) 
			{
				return (ItemStack) item;
			} else {
				return null;
			}
		} catch (Exception e) {
			System.out.println("Metallurgy API: Failed to get item " + name);
			
			return null;
		}
	}
	
	public static void addCrusherRecipe(int itemID, int metadata, ItemStack result)
	{
		try 
		{
			if (crusherRecipes == null) 
				crusherRecipes = Class.forName("shadow.mods.metallurgy.BC_CrusherRecipes");
			if(addCrushing == null)
				addCrushing = crusherRecipes.getDeclaredMethod("addCrushing", new Class[] {Integer.TYPE, Integer.TYPE, ItemStack.class});
			addCrushing.invoke(crusherRecipes, new Object[] {(Integer)itemID, (Integer)metadata, result});
			
		} catch (Exception e) {
			System.out.println("Metallurgy API: Failed to add crusher recipe"  + e);
		}
	}
	
	public static void addAbstractorRecipe(int itemID, int metadata, int amount)
	{
		try 
		{
			if (abstractorRecipes == null) 
				abstractorRecipes = Class.forName("shadow.mods.metallurgy.fantasy.FF_EssenceRecipes");
			if(addAbstraction == null)
				addAbstraction = abstractorRecipes.getDeclaredMethod("addEssence", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE});
			addAbstraction.invoke(abstractorRecipes, new Object[] {(Integer)itemID, (Integer)metadata, amount});
			
		} catch (Exception e) {
			System.out.println("Metallurgy API: Failed to add abstractor recipe" + e);
		}
	}
	
	public static void addAbstractorFuel(int itemID, int metadata, int amount)
	{
		try 
		{
			if (abstractorRecipes == null) 
				abstractorRecipes = Class.forName("shadow.mods.metallurgy.fantasy.FF_EssenceRecipes");
			if(addAbstractorFuel == null)
				addAbstractorFuel = abstractorRecipes.getDeclaredMethod("addFuel", new Class[] {Integer.TYPE, Integer.TYPE, Integer.TYPE});
			addAbstractorFuel.invoke(abstractorRecipes, new Object[] {(Integer)itemID, (Integer)metadata, amount});
			
		} catch (Exception e) {
			System.out.println("Metallurgy API: Failed to add abstractor fuel" + e);
		}
	}
	
	public static void addMintingIngot(int itemID, int amount, String image)
	{
		try 
		{
			if (mintRecipes == null) 
				mintRecipes = Class.forName("shadow.mods.metallurgy.precious.FM_MintRecipes");
			if(addMinting == null)
				addMinting = mintRecipes.getDeclaredMethod("addMinting", new Class[] {Integer.TYPE, Integer.TYPE, String.class});
			addMinting.invoke(mintRecipes, new Object[] {(Integer)itemID, (Integer)amount, image});
			
		} catch (Exception e) {
			System.out.println("Metallurgy API: Failed to add minting recipe" + e);
		}
	}
}