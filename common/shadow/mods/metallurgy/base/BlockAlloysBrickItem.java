package shadow.mods.metallurgy.base;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockAlloysBrickItem extends ItemBlock 
{
        public BlockAlloysBrickItem(int i) {
                super(i);
                setHasSubtypes(true);
        }

        @Override
        public int getMetadata(int i) {
                return i;
        }

        @Override
        public String getItemNameIS(ItemStack itemstack)
        {
            String name = "";
            switch(itemstack.getItemDamage()) {
	            case 0: {
	                name = "BronzeBrick";
	                break;
	            }
	            case 1: {
	                name = "HepatizonBrick"; 
	                break;
	            }
	            case 2: {
	                name = "DamascusBrick";
	                break;
	            }
	            case 3: {
	                name = "AngmallenBrick";
	                break;
	            }
	            case 4: {
	                name = "SteelBrick";
	                break;
	            }
	            default: name = "brick";
            }
            return getItemName() + "." + name;
        }
}
