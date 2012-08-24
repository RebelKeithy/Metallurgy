package shadow.mods.metallurgy.precious;

import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockPreciousMetalsBrickItem extends ItemBlock {

    public BlockPreciousMetalsBrickItem(int i) {
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
                name = "ZincBrick";
                break;
            }
            case 1: {
                name = "SilverBrick"; 
                break;
            }
            case 2: {
                name = "PlatinumBrick";
                break;
            }
            default: name = "ore";
        }
        return getItemName() + "." + name;
    }
}
