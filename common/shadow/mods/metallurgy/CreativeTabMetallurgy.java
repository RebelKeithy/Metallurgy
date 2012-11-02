package shadow.mods.metallurgy;

import shadow.mods.metallurgy.nether.MetallurgyNether;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

public class CreativeTabMetallurgy extends CreativeTabs{

	private int iconItemID = 1;
	
	CreativeTabMetallurgy(int par1, String par2Str, int id)
    {
        super(par1, par2Str);
        iconItemID = id;
    }

    @SideOnly(Side.CLIENT)

    /**
     * the itemID for the item to be displayed on the tab
     */
    public int getTabIconItemIndex()
    {
        return iconItemID;
    }
}
