// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.ItemArmor;
import net.minecraft.src.ItemStack;
import net.minecraftforge.common.IArmorTextureProvider;

// Referenced classes of package net.minecraft.src:
//            Item, EnumArmorMaterial

public class MetallurgyArmor extends ItemArmor implements IArmorTextureProvider
{

    private static final int maxDamageArray[] = {
        11, 16, 15, 13
    };
    
    public final int armorType; //Slot
    public final int damageReduceAmount; //% of damage absorbed
    public int renderIndex; //Artwork Name
    private final EnumArmorMaterial material;
    public String texturePath;
    public String texturePrefix;
    
    public MetallurgyArmor(int i, String s, String s2, EnumArmorMaterial enumarmormaterial, int j, int k, int l, int m)
    {
    	super(i, enumarmormaterial, j, k);
    	
        material = enumarmormaterial;
        texturePath = s;
        texturePrefix = s2;
        armorType = k;
        damageReduceAmount = l;
        setMaxDamage(m);
        maxStackSize = 1;
    }
    
    public String getArmorTextureFile(ItemStack itemstack)
    {
            return "/armor/" + texturePrefix + ".png";
    }
    
    public void setTexturePrefix(String tex)
    {
    	texturePrefix = tex;
    }
    
    public void setTexture(int index)
    {
    	System.out.println("setting render index " + index + " of " + this);
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