package shadow.mods.metallurgy;

import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.src.*;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

public class CrusherUpgradeRecipes {

	public static void load()
	{

		CraftingManager.getInstance().addRecipe(new ItemStack(MetallurgyCore.crusher, 1, 0),
			"XSX", "SFS", "XSX", 'X', Block.cobblestone, 'S', Item.stick, 'F', Block.stoneOvenIdle);
	    
		ShapedOreRecipe copperRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyCore.crusher, 1, 1),
				"XXX", "XFX", "XXX", 'X', "ingotCopper", 'F', new ItemStack(MetallurgyCore.crusher, 1, 0));
		CraftingManager.getInstance().getRecipeList().add(copperRecipe);
		
		ShapedOreRecipe bronzeRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyCore.crusher, 1, 2),
				"XXX", "XFX", "XXX", 'X', "ingotBronze", 'F', new ItemStack(MetallurgyCore.crusher, 1, 1));
		CraftingManager.getInstance().getRecipeList().add(bronzeRecipe);
		
		CraftingManager.getInstance().addRecipe(new ItemStack(MetallurgyCore.crusher, 1, 3),
				"XXX", "XFX", "XXX", 'X', Item.ingotIron, 'F', new ItemStack(MetallurgyCore.crusher, 1, 2));
		
		ShapedOreRecipe steelRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyCore.crusher, 1, 4),
				"XXX", "XFX", "XXX", 'X', "ingotSteel", 'F', new ItemStack(MetallurgyCore.crusher, 1, 3));
		CraftingManager.getInstance().getRecipeList().add(steelRecipe);
	}
	
    @ForgeSubscribe
    public void oreRegistered(OreRegisterEvent event)
    {    

    	if(event.Name.equals("ingotCopper"))
    	{
			ModLoader.addRecipe(new ItemStack(MetallurgyCore.crusher, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(MetallurgyCore.crusher, 1, 0)
			});
    	}

    	if(event.Name.equals("ingotBronze"))
    	{
			ModLoader.addRecipe(new ItemStack(MetallurgyCore.crusher, 1, 2), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(MetallurgyCore.crusher, 1, 1)
			});
    	}

    	if(event.Name.equals("ingotSteel"))
    	{
			ModLoader.addRecipe(new ItemStack(MetallurgyCore.crusher, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), event.Ore, Character.valueOf('F'), new ItemStack(MetallurgyCore.crusher, 1, 3)
			});
    	}
	}
}
