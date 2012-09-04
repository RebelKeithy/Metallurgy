// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package shadow.mods.metallurgy;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
//import net.minecraft.src.forge.*;
import net.minecraft.src.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Item, IInfiTexture

public class MetallurgyBlock extends Block
{

	public String texturePath;
	public int row;
	public int numTypes;
	
    public MetallurgyBlock(int i, String s, int numTypes, int row) {
        super(i, Material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.numTypes = numTypes;
        this.row = row;
    }

    @Override
	public int idDropped(int metadata, Random random, int j) {
		return blockID;
	}
    
    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		return j + (row * 16);
	}
	
	public String getTextureFile()
    {		
		return texturePath;
    }
	
    protected int damageDropped(int metadata) {
        return metadata;
    }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < numTypes; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}
