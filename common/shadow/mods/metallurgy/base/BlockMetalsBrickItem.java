package shadow.mods.metallurgy.base;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class BlockMetalsBrickItem extends ItemBlock 
{
        public BlockMetalsBrickItem(int i) {
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
	                name = "CopperBrick";
	                break;
	            }
	            case 1: {
	                name = "TinBrick"; 
	                break;
	            }
	            case 2: {
	                name = "IronBrick";
	                break;
	            }
	            case 3: {
	                name = "ManganeseBrick";
	                break;
	            }
	            case 4: {
	                name = "GoldBrick";
	                break;
	            }
	            default: name = "brick";
            }
            return getItemName() + "." + name;
    }
}