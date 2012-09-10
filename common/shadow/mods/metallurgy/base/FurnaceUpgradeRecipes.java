package shadow.mods.metallurgy.base;

import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class FurnaceUpgradeRecipes {
	
    @ForgeSubscribe
    public void oreRegistered(OreRegisterEvent event)
    {    		
    	System.out.println(event.Ore.itemID);
    	
    	
    	if(event.Name.equals("ingotCopper"))
    	{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), Block.stoneOvenIdle
			});
    	}

    	if(event.Name.equals("ingotBronze"))
    	{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 0)
			});
    	}
    	
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 1)
		});

    	if(event.Name.equals("ingotSteel"))
    	{
    		ModLoader.addRecipe(new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 3), new Object[] {
    			"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(mod_MetallurgyBaseMetals.metalFurnace, 1, 2)
    		});
    	}
    }
}
