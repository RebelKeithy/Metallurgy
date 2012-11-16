package shadow.mods.metallurgy.utility;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BlockVein extends Block
{
	public String texturePath;

	public BlockVein(int i, String s, Material material) {
		super(i, material.iron);
		texturePath = s;
		this.setCreativeTab(CreativeTabs.tabBlock);
	}

	public BlockVein setHardness(float par1) {
		return (BlockVein) super.setHardness(par1);
	}

	public BlockVein setResistance(float par1) {
		return (BlockVein) super.setResistance(par1);
	}

	@Override
	public int idDropped(int metadata, Random random, int par3) {
		if(metadata == 0)
			return MetallurgyUtility.phosphorus.shiftedIndex;
		if(metadata == 1)
			return MetallurgyUtility.sulfur.shiftedIndex;
		if(metadata == 2)
			return MetallurgyUtility.saltpeter.shiftedIndex;
		if(metadata == 3)
			return MetallurgyUtility.magnesium.shiftedIndex;
		if(metadata == 4)
			return MetallurgyUtility.bitumen.shiftedIndex;
		if(metadata == 5)
			return MetallurgyUtility.potash.shiftedIndex;
		return blockID;
	}

    /**
     * Drops the block items with a specified chance of dropping the specified items
     */
	@Override
    public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6, int par7)
    {
        super.dropBlockAsItemWithChance(par1World, par2, par3, par4, par5, par6, par7);

        if (this.idDropped(par5, par1World.rand, par7) != this.blockID)
        {
            int var8 = 0;

            var8 = MathHelper.getRandomIntegerInRange(par1World.rand, 0, 3);

            this.dropXpOnBlockBreak(par1World, par2, par3, par4, var8);
        }
    }

	@Override
	public int damageDropped(int metadata) {
		return 0;
	}

	public int quantityDropped(Random random) {
		return 1 + random.nextInt(4);
	}

	public int getBlockTextureFromSideAndMetadata(int side, int metadata) {
		return metadata;
	}

	public String getTextureFile() {
		return texturePath;
	}
	
	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < 6; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}