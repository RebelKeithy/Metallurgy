package shadow.mods.metallurgy.fantasy;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class FF_BlockMetalFurnaceItem extends ItemBlock 
{
        public FF_BlockMetalFurnaceItem(int i) {
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
	                name = "PrometheumFurnace";
	                break;
	            }
	            case 1: {
	                name = "DeepIronFurnace"; 
	                break;
	            }
	            case 2: {
	                name = "BlackSteelFurnace";
	                break;
	            }
	            case 3: {
	                name = "OureclaseFurnace";
	                break;
	            }
	            case 4: {
	                name = "AredriteFurnace";
	                break;
	            }
	            case 5: {
	                name = "MithrilFurnace";
	                break;
	            }
	            case 6: {
	                name = "HaderothFurnace";
	                break;
	            }
	            case 7: {
	                name = "OrichalcumFurnace";
	                break;
	            }
	            case 8: {
	                name = "AdamantineFurnace";
	                break;
	            }
	            case 9: {
	                name = "AtlarusFurnace";
	                break;
	            }
	            case 10: {
	                name = "TartariteFurnace";
	                break;
	            }
	            default: name = "brick";
            }
            return getItemName() + "." + name;
        }
}
