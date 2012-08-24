package shadow.mods.metallurgy;

import net.minecraft.src.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BC_CrusherRecipes
{
    private static final BC_CrusherRecipes smeltingBase = new BC_CrusherRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map metaSmeltingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final BC_CrusherRecipes smelting()
    {
        return smeltingBase;
    }

    private BC_CrusherRecipes()
    {
    }

    /**
     * Adds a smelting recipe.
     */
    public void addCrushing(int par1, ItemStack par2ItemStack)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    /**
     * Returns the smelting result of an item.
     * Deprecated in favor of a metadata sensitive version
     */
    @Deprecated
    public ItemStack getCrushingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getCrushingList()
    {
        return this.smeltingList;
    }
    
    /**
     * Add a metadata-sensitive furnace recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addCrushing(int itemID, int metadata, ItemStack itemstack)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public ItemStack getCrushingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }
}
