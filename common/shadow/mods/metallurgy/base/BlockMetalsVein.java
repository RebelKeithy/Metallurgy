package shadow.mods.metallurgy.base;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;

public class BlockMetalsVein extends Block{
	public String texturePath;

	public BlockMetalsVein(int i, String s, Material material) {
		super(i, material.iron);
		texturePath = s;
        super.setCreativeTab(CreativeTabs.tabBlock);
	}

    @Override
	public int idDropped(int metadata, Random random, int j) {
		return blockID;
	}

	@Override
	protected int damageDropped(int metadata) {
		return metadata;
	}

	public int quantityDropped(Random random) {
		return 1 + random.nextInt(1);
	}

	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		int Texture;
		switch (j) {
		case 0:
			Texture = 0;
			break;
		case 1:
			Texture = 1;
			break;
		case 2:
			Texture = 2;
			break;
		case 3:
			Texture = 3;
			break;
		case 4:
			Texture = 4;
			break;
		default:
			Texture = 15;
			break;
		}
		return Texture;
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