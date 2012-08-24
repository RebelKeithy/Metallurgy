package shadow.mods.metallurgy.precious;
import net.minecraft.src.Block;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockPreciousMetalsVeinItem extends ItemBlock 
{
    public BlockPreciousMetalsVeinItem(int i) {
    	super(i);
    	setHasSubtypes(true);
    }
        
    @Override
	public int getMetadata(int metadata)
	{
		return metadata;
	}

    @Override
    public String getItemNameIS(ItemStack itemstack)
    {
        String name = "";
        switch(itemstack.getItemDamage()) {
            case 0: {
                name = "ZincOre";
                break;
            }
            case 1: {
                name = "SilverOre"; 
                break;
            }
            case 2: {
                name = "PlatinumOre";
                break;
            }
            default: name = "ore";
        }
        return getItemName() + "." + name;
    }
}