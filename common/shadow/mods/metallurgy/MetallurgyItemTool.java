// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;

import net.minecraft.src.Block;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;


// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, ItemStack, Block, 
//            EntityLiving, Entity

public class MetallurgyItemTool extends Item
{

    private Block blocksEffectiveAgainst[];
    protected float efficiencyOnProperMaterial;
    private int damageVsEntity;
    protected MetallurgyEnumToolMaterial toolMaterial;

    protected MetallurgyItemTool(int i, int j, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial, Block ablock[])
    {
        super(i);
        efficiencyOnProperMaterial = 4F;
        toolMaterial = metallurgyenumtoolmaterial;
        blocksEffectiveAgainst = ablock;
        maxStackSize = 1;
        setMaxDamage(metallurgyenumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = metallurgyenumtoolmaterial.getEfficiencyOnProperMaterial();
        damageVsEntity = j + metallurgyenumtoolmaterial.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
        itemstack.damageItem(2, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(1, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
}
