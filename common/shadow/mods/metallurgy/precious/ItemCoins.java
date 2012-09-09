package shadow.mods.metallurgy.precious;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemCoins extends Item
{
	private String texturePath = "/shadow/Overrides.png";

    public ItemCoins(int i)
    {
        super(i);
        setMaxDamage(0);
		setHasSubtypes(true);
		this.iconIndex = 8;
    }

    @Override
    public String getTextureFile()
    {
        return texturePath;
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    @Override
    public int getIconFromDamage(int par1)
    {
        return this.iconIndex + (par1 * 16);
    }

    
    public String toString()
    {
    	return super.toString() + " " + this.getItemName();
    }
    
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 4; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    @Override
	public String getItemNameIS(ItemStack itemstack) {
		int meta = itemstack.getItemDamage();
		return getItemName() + "." + meta;
	}
}
