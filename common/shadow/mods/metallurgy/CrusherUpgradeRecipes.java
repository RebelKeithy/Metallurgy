package shadow.mods.metallurgy;

import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class CrusherUpgradeRecipes {
	
    @ForgeSubscribe
    public void oreRegistered(OreRegisterEvent event)
    {    


		ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 0), new Object[] {
			"XSX", "SFS", "XSX", Character.valueOf('X'), Block.cobblestone, Character.valueOf('S'), Item.stick, Character.valueOf('F'), Block.stoneOvenIdle
		});

    	if(event.Name.equals("ingotCopper"))
    	{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), mod_MetallurgyCore.crusher
			});
    	}

    	if(event.Name.equals("ingotBronze"))
    	{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 1)
			});
    	}
    	
		ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotIron, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 2)
		});

    	if(event.Name.equals("ingotSteel"))
    	{
			ModLoader.addRecipe(new ItemStack(mod_MetallurgyCore.crusher, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(mod_MetallurgyCore.crusher, 1, 3)
			});
    	}
	}
}
