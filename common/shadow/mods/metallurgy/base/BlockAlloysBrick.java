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

public class BlockAlloysBrick extends Block
{
	public String texturePath;
	
    protected BlockAlloysBrick(int i, String s, Material material) {
        super(i, material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    @Override
	public int idDropped(int i, Random random, int j) {
		int BrickDrop;
	    switch (i){
		    case 0: BrickDrop = AlloyBronze.BronzeBar.shiftedIndex; break;
		    case 1: BrickDrop = AlloyHepatizon.HepatizonBar.shiftedIndex; break;
		    case 2: BrickDrop = AlloyDamascusSteel.DamascusSteelBar.shiftedIndex; break;
		    case 3: BrickDrop = AlloyAngmallen.AngmallenBar.shiftedIndex; break;
		    case 4: BrickDrop = AlloySteel.SteelBar.shiftedIndex; break; 
		    default: BrickDrop = Item.arrow.shiftedIndex; break;
    	}
	    return BrickDrop;
    }

    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
		int Texture;
	        switch (j) {
		        case 0: Texture = 16; break; //Bronze Brick
		        case 1: Texture = 17; break; //Hepatizon Brick
		        case 2: Texture = 18; break; //Damascus Steel Brick
		        case 3: Texture = 19; break; //Angmallen Brick
		        case 4: Texture = 19; break; //Steel Brick
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
		for (int n = 0; n < 5; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}