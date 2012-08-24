package shadow.mods.metallurgy.precious;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockPreciousAlloysBrick extends Block
{
	public String texturePath;
	
    protected BlockPreciousAlloysBrick(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
        super.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
	public int idDropped(int i, Random random, int j) {
	    return blockID;
    }

    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		return j + 16;
	}

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }

    @Override
    protected int damageDropped(int i) {
        return i;
    }

    
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 2; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
	
	
}