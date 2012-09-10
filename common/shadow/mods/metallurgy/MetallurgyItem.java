// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package shadow.mods.metallurgy;
import java.util.List;

import net.minecraft.src.Item;
//import net.minecraft.src.forge.*;
import net.minecraft.src.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Item, IInfiTexture

public class MetallurgyItem extends Item
{

    public MetallurgyItem(int i, String s)
    {
        super(i);
        texturePath = s;
        setMaxDamage(0);
    }


    public void addInformation(ItemStack par1ItemStack, List par2List)
    {
    	//par2List.add(par1ItemStack.itemID - 256 + ":" + par1ItemStack.getItemDamage());
    }

    @Override
    public String getTextureFile()
    {
        return texturePath;
    }

    public String toString()
    {
    	return super.toString() + " " + this.getItemName();
    }
    
    public String texturePath;
}
