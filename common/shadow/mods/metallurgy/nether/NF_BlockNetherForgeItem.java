package shadow.mods.metallurgy.nether;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;

public class NF_BlockNetherForgeItem extends ItemBlock 
{
        public NF_BlockNetherForgeItem(int i) {
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
	                name = "IgnatiusForge";
	                break;
	            }
	            case 1: {
	                name = "Shadow IronForge"; 
	                break;
	            }
	            case 2: {
	                name = "Shadow SteelForge";
	                break;
	            }
	            case 3: {
	                name = "VyroxeresForge";
	                break;
	            }
	            case 4: {
	                name = "InolashiteForge";
	                break;
	            }
	            case 5: {
	                name = "KalendriteForge";
	                break;
	            }
	            case 6: {
	                name = "VulcaniteForge";
	                break;
	            }
	            case 7: {
	                name = "SanguiniteForge";
	                break;
	            }
	            default: name = "brick";
            }
            return getItemName() + "." + name;
        }
}
