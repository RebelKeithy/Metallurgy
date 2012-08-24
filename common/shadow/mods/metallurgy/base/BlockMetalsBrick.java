package shadow.mods.metallurgy.base;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockMetalsBrick extends Block
{
	public String texturePath;
	
    public BlockMetalsBrick(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
    public BlockMetalsBrick setResistance(float par1)
    {
    	return (BlockMetalsBrick)super.setResistance(par1);
    }

    @Override
	public int idDropped(int i, Random random, int j) {
	    return blockID;
    }

	@Override
    protected int damageDropped(int metadata)
    {
        return metadata;
    }

    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		int Texture;
	        switch (j) {
		        case 0: Texture = 16; break;
		        case 1: Texture = 17; break;
		        case 2: Texture = 18; break; 
		        case 3: Texture = 19; break;
		        case 4: Texture = 20; break;
		        default: Texture = 15; break;
	        }
	        return Texture;
	}

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 5; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}