package shadow.mods.metallurgy.base;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.oredict.OreDictionary;

public class mod_Furnace {
	
	public static String texturePath = "/shadow/MetallurgyFurnaces.png";
	
	public static void load()
	{
    	for(ItemStack copper : OreDictionary.getOres("ingotCopper"))
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), copper, Character.valueOf('F'), Block.stoneOvenIdle
			});

	    for(ItemStack bronze : OreDictionary.getOres("ingotBronze"))
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), bronze, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0)
			});
	    
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1)
		});

    	for(ItemStack steel : OreDictionary.getOres("ingotSteel"))
    		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 3), new Object[] {
    			"XXX", "XFX", "XXX", Character.valueOf('X'), steel, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2)
    		});
	}
}
