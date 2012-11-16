package shadow.mods.metallurgy.base;

import java.util.List;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.MathHelper;

public class ItemGlassDust extends Item {

	public ItemGlassDust(int i, String texture) {
		super(i);
		setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setTextureFile(texture);
	}

	@Override
	public int getMetadata(int i) {
		return i;
	}
	
    /**
     * Gets an icon index based on an item's damage value
     */
	@Override
    public int getIconFromDamage(int par1)
    {
        if(par1 == 0)
        	return this.iconIndex;
        else
        	return ((par1-1)/2)*16 + (par1-1)%2 + 4;
    }

	@Override
	public String getItemNameIS(ItemStack itemstack) {
		String name = "";
		switch (itemstack.getItemDamage()) {
		case 0: {
			name = "glass";
			break;
		}
		case 1: {
			name = "red";
			break;
		}
		case 2: {
			name = "green";
			break;
		}
		case 3: {
			name = "blue";
			break;
		}
		case 4: {
			name = "orange";
			break;
		}
		case 5: {
			name = "yellow";
			break;
		}
		case 6: {
			name = "purple";
			break;
		}
		case 7: {
			name = "grey";
			break;
		}
		case 8: {
			name = "white";
			break;
		}
		default:
			name = "error";
		}
		return getItemName() + "." + name;
	}

    @SideOnly(Side.CLIENT)

    /**
     * returns a list of items with the same ID, but different meta (eg: dye returns 16 items)
     */
    @Override
    public void getSubItems(int par1, CreativeTabs par2CreativeTabs, List par3List)
    {
        for (int var4 = 0; var4 < 9; ++var4)
        {
            par3List.add(new ItemStack(par1, 1, var4));
        }
    }
}
