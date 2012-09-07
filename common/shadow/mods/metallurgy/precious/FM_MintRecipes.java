package shadow.mods.metallurgy.precious;

import net.minecraft.src.ItemStack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FM_MintRecipes
{
    private static final FM_MintRecipes smeltingBase = new FM_MintRecipes();

    /** The list of smelting results. */
    private Map metaMintingList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FM_MintRecipes minting()
    {
        return smeltingBase;
    }
    
    /**
     * Add a metadata-sensitive furnace recipe
     * @param itemID The Item ID
     * @param metadata The Item Metadata
     * @param itemstack The ItemStack for the result
     */
    public void addMinting(int itemID, int metadata, int amount)
    {
        metaMintingList.put(Arrays.asList(itemID, metadata), amount);
    }
    
    /**
     * Used to get the resulting ItemStack form a source ItemStack
     * @param item The Source ItemStack
     * @return The result ItemStack
     */
    public int getMintingResult(ItemStack item) 
    {
        if (item == null)
        {
            return 0;
        }
        Integer ret = (Integer)metaMintingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if(ret == null)
        	return 0;
        return ret;
    }
}
