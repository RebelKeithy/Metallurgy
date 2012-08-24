package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreDeepIron
{
	public static final int meta = 1;
	
	public static Item deepIronDust = (new MetallurgyItem(FantasyConfig.itemDeepIronDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("deepIronDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item deepIronBar = (new MetallurgyItem(FantasyConfig.itemDeepIronBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("deepIronBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item deepIronPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemDeepIronPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.DeepIron).setIconCoord(meta,7).setItemName("deepIronPickaxe");
	public static Item deepIronShovel = new MetallurgyItemSpade(FantasyConfig.itemDeepIronShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.DeepIron).setIconCoord(meta,8).setItemName("deepIronShovel");
	public static Item deepIronAxe = new MetallurgyItemAxe(FantasyConfig.itemDeepIronAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.DeepIron).setIconCoord(meta,5).setItemName("deepIronAxe");
	public static Item deepIronHoe = new MetallurgyItemHoe(FantasyConfig.itemDeepIronHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.DeepIron).setIconCoord(meta,6).setItemName("deepIronHoe");
	public static Item deepIronSword = new MetallurgyItemSword(FantasyConfig.itemDeepIronSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.DeepIron).setIconCoord(meta,9).setItemName("deepIronSword");
	
	public static Item deepIronHelmet = (new MetallurgyArmor(FantasyConfig.itemDeepIronHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("deepIronHelmet");
	public static Item deepIronPlate = (new MetallurgyArmor(FantasyConfig.itemDeepIronPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("deepIronPlate");
	public static Item deepIronLegs = (new MetallurgyArmor(FantasyConfig.itemDeepIronLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("deepIronLegs");
	public static Item deepIronBoots = (new MetallurgyArmor(FantasyConfig.itemDeepIronBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("deepIronBoots");

	//Load Recipes
	public static void load()
	{

		//Smelting
		FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(deepIronBar, 1));
		ModLoader.addSmelting(deepIronDust.shiftedIndex, new ItemStack(deepIronBar, 1));
		
		//Dust
		BC_CrusherRecipes.smelting().addCrushing(deepIronBar.shiftedIndex, new ItemStack(deepIronDust, 1));
		BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(deepIronDust, 2));

		FF_EssenceRecipes.essence().addEssenceAmount(deepIronBar.shiftedIndex, 2);
		
		//Bricks!
		RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, deepIronBar);
		
        //Tools
		RecipeHelper.addAxeRecipe(deepIronAxe, deepIronBar);
		RecipeHelper.addPickaxeRecipe(deepIronPickaxe, deepIronBar);
		RecipeHelper.addShovelRecipe(deepIronShovel, deepIronBar);
		RecipeHelper.addHoeRecipe(deepIronHoe, deepIronBar);
		RecipeHelper.addSwordRecipe(deepIronSword, deepIronBar);
		RecipeHelper.addHelmetRecipe(deepIronPickaxe, deepIronBar);
		RecipeHelper.addPlateRecipe(deepIronPickaxe, deepIronBar);
		RecipeHelper.addLegsRecipe(deepIronPickaxe, deepIronBar);
		RecipeHelper.addBootsRecipe(deepIronPickaxe, deepIronBar);
	    
	    //Buckets/Shears
		RecipeHelper.addBucketRecipe(deepIronBar);
		RecipeHelper.addShearsRecipe(deepIronBar);
	    
	    
	    /*
	    //Rails!
		ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
			"X X", "X|X", "X X", Character.valueOf('X'), deepIronBar, Character.valueOf('|'), Item.stick
		});
		*/
	}


}