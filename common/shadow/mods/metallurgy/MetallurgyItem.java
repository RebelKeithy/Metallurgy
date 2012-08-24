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
        setHasSubtypes(true);
        setMaxDamage(0);
    }
    

    @Override
    public String getTextureFile()
    {
        return texturePath;
    }

    public String texturePath;
}
