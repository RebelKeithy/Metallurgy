package shadow.mods.metallurgy.nether;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockNetherAlloysBrick extends Block
{
	public String texturePath;
	
    protected BlockNetherAlloysBrick(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
	public int idDropped(int i, Random random, int j) {
		return blockID;
    }

    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		int Texture;
	        switch (j) {
		        case 0: Texture = 16; break; //Shadowsteel
		        case 1: Texture = 17; break; //Inolashite
		        case 2: Texture = 18; break; //Amordrine
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
    protected int damageDropped(int i) {
        return i;
    }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 3; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}