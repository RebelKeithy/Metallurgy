package shadow.mods.metallurgy;

import java.util.HashMap;

import net.minecraft.src.ItemStack;

public class MetallurgyItems
{
	private static HashMap<String, ItemStack> items = new HashMap<String, ItemStack>();
	
	public static void registerItem(String name, ItemStack item)
	{
		if(!items.containsKey(name))
			items.put(name, item);
	}
	
	public static ItemStack getItem(String name)
	{
		return items.get(name);
	}
}
