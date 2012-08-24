// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;

// Referenced classes of package net.minecraft.src:
//            Item, EnumArmorMaterial

public class MetallurgyArmor extends ItemArmor
{

    private static final int maxDamageArray[] = {
        11, 16, 15, 13
    };
    
    public final int armorType; //Slot
    public final int damageReduceAmount; //% of damage absorbed
    public int renderIndex; //Artwork Name
    private final EnumArmorMaterial material;
    public String texturePath;
    
    public MetallurgyArmor(int i, String s, EnumArmorMaterial enumarmormaterial, int j, int k, int l, int m)
    {
    	super(i, enumarmormaterial, j, k);
    	
        material = enumarmormaterial;
        texturePath = s;
        armorType = k;
        damageReduceAmount = l;
        setMaxDamage(m);
        maxStackSize = 1;
    }
    
    public void setTexture(int index)
    {
    	this.renderIndex = index;
    }

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }

    public int getItemEnchantability()
    {
        return material.getEnchantability();
    }

    static int[] func_40436_c()
    {
        return maxDamageArray;
    }
}