package shadow.mods.metallurgy.fantasy;

import net.minecraft.src.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FF_EssenceRecipes
{
    private static final FF_EssenceRecipes smeltingBase = new FF_EssenceRecipes();

    /** The list of smelting results. */
    private static Map smeltingList = new HashMap();
    private static Map metaSmeltingList = new HashMap();
    private static Map fuelList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FF_EssenceRecipes essence()
    {
        return smeltingBase;
    }

    private FF_EssenceRecipes()
    {
    }

    /**
     * Adds a smelting recipe.
     */
    public void addEssenceAmount(int itemID, int amount)
    {
        this.smeltingList.put(Integer.valueOf(itemID), amount);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public int getEssenceResuly(int par1)
    {
        return (Integer)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getEssenceList()
    {
        return this.smeltingList;
    }
    
    /**
     * Add a metadata-sensitive furnace recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public static void addEssence(int itemID, int metadata, int amount)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), amount);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public int getEssenceResult(ItemStack item) 
    {
        if (item == null)
        {
            return 0;
        }
        Integer ret = (Integer)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        ret = (Integer)smeltingList.get(Integer.valueOf(item.itemID));
        if(ret != null)
        {
        	return ret;
        }
        
        return 0;
    }
    
    public static void addFuel(int itemID, int metadata, int amount)
    {
        fuelList.put(Arrays.asList(itemID, metadata), amount);
    }

	public static int getFuelAmount(ItemStack itemStack) {
		if(fuelList.containsKey(Arrays.asList(itemStack.itemID, itemStack.getItemDamage())))
			return (Integer) fuelList.get(Arrays.asList(itemStack.itemID, itemStack.getItemDamage()));
		else
			return 0;
	}
}
