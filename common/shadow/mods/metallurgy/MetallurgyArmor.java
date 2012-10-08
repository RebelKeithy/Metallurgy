// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
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
    public String texturePath;
    public String texturePrefix;
    
    public MetallurgyArmor(int i, String s, String s2, EnumArmorMaterial enumarmormaterial, int j, int k)
    {
    	super(i, enumarmormaterial, j, k);
    	
        texturePath = s;
        texturePrefix = s2;
    }
    
    public String getArmorTextureFile(ItemStack itemstack)
    {
            return "/armor/" + texturePrefix + ".png";
    }
    
    public void setTexturePrefix(String tex)
    {
    	texturePrefix = tex;
    }

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }
}