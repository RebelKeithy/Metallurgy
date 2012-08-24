package shadow.mods.metallurgy;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BC_BlockCrusherItem extends ItemBlock 
{
        public BC_BlockCrusherItem(int i) {
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
	                name = "StoneCrusher";
	                break;
	            }
	            case 1: {
	                name = "CopperCrusher"; 
	                break;
	            }
	            case 2: {
	                name = "BronzeCrusher";
	                break;
	            }
	            case 3: {
	                name = "IronCrusher";
	                break;
	            }
	            case 4: {
	                name = "SteelCrusher";
	                break;
	            }
	            default: name = "brick";
            }
            return getItemName() + "." + name;
        }
}
