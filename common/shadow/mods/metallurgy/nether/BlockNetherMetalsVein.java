package shadow.mods.metallurgy.nether;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;

public class BlockNetherMetalsVein extends Block
{
	public String texturePath;
	
    public BlockNetherMetalsVein(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }

    @Override
	public int idDropped(int metadata, Random random, int j) {
		return blockID;
	}
    
    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		int Texture;
	        switch (j) {
		        case 0: Texture = 0; break; //Ignatius
		        case 1: Texture = 1; break; //ShadowIron
		        case 2: Texture = 2; break; //Midasium
		        case 3: Texture = 3; break; //Vyroxeres
		        case 4: Texture = 4; break; //Ceruclase
		        case 5: Texture = 5; break; //Kalendrite
		        case 6: Texture = 6; break; //Vulcanite
		        case 7: Texture = 7; break; //Sanguinite
		        default: Texture = 15; break;
	        }
	        return Texture;
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
		for (int n = 0; n < 8; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}