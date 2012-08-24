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

public class BlockNetherMetalsBrick extends Block{
	public String texturePath;
	
    public BlockNetherMetalsBrick(int i, String s, Material material) {
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
		        case 0: Texture = 16; break; //
		        case 1: Texture = 17; break; //
		        case 2: Texture = 18; break; //
		        case 3: Texture = 19; break; //
		        case 4: Texture = 20; break; //
		        case 5: Texture = 21; break; //
		        case 6: Texture = 22; break; //
		        case 7: Texture = 23; break; //
		        default: Texture = 15; break;
	        }
	        return Texture;
	}
	
	public String getTextureFile()
    {		
		return texturePath;
    }
	
    protected int damageDropped(int i) {
        return i;
    }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 8; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}