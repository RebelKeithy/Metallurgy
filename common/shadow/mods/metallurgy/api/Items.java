package shadow.mods.metallurgy.api;

import java.lang.reflect.Method;

import net.minecraft.src.ItemStack;

public class Items
{
	private static Class metallurgyItems;
	private static Method getItem;
	
	public static ItemStack getItem(String name)
	{	
		try 
		{
			if (metallurgyItems == null) 
				metallurgyItems = Class.forName("shadow.mods.metallurgy.MetallurgyItems");
			if(getItem == null)
				getItem = metallurgyItems.getDeclaredMethod(name, new Class[] {String.class});
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
}