package shadow.mods.metallurgy.fantasy;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockAlloysBrick extends Block
{
	public String texturePath;

	public BlockAlloysBrick(int i, String s, Material material) {
		super(i, material.iron);
		texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
	}

	@Override
	public int idDropped(int metadata, Random random, int par3) {
		return blockID;
	}

	@Override
	protected int damageDropped(int metadata) {
		return metadata;
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return metadata + 16;
	}

	public String getTextureFile() {
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