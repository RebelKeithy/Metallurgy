// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package shadow.mods.metallurgy;
import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.MathHelper;
//import net.minecraft.src.forge.*;
import net.minecraft.src.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Item, IInfiTexture

public class MetallurgyItemMeta extends Item
{

	public String[] names;
	
    public MetallurgyItemMeta(int i, String s, String[] names)
    {
        super(i);
        texturePath = s;
        setHasSubtypes(true);
        setMaxDamage(0);
        this.names = names;
    }
    
    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        int var2 = MathHelper.clamp_int(par1, 0, names.length);
        return this.iconIndex + var2;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, names.length);
        return super.getItemName() + "." + names[var2];
    }
    
    @Override
    public String getTextureFile()
    {
        return texturePath;
    }
    
    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < names.length; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }

    public String texturePath;
}
