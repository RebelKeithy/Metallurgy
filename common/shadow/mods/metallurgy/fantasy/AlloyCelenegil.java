package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.precious.OrePrecious;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class AlloyCelenegil
{
		public static final int meta = 3;
	
		public static Item celenegilDust = (new MetallurgyItem(FantasyConfig.itemCelenegilDustID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,3).setItemName("CelenegilDust").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item celenegilBar = (new MetallurgyItem(FantasyConfig.itemCelenegilBarID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,4).setItemName("CelenegilBar").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item celenegilPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemCelenegilPickaxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Celenegil).setIconCoord(meta,7).setItemName("CelenegilPickaxe");
		public static Item celenegilShovel = new MetallurgyItemSpade(FantasyConfig.itemCelenegilShovelID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Celenegil).setIconCoord(meta,8).setItemName("CelenegilShovel");
		public static Item celenegilAxe = new MetallurgyItemAxe(FantasyConfig.itemCelenegilAxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Celenegil).setIconCoord(meta,5).setItemName("CelenegilAxe");
		public static Item celenegilHoe = new MetallurgyItemHoe(FantasyConfig.itemCelenegilHoeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Celenegil).setIconCoord(meta,6).setItemName("CelenegilHoe");
		public static Item celenegilSword = new MetallurgyItemSword(FantasyConfig.itemCelenegilSwordID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Celenegil).setIconCoord(meta,9).setItemName("CelenegilSword");
		
		public static Item celenegilHelmet = (new MetallurgyArmor(FantasyConfig.itemCelenegilHelmetID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("CelenegilHelmet");
		public static Item celenegilPlate = (new MetallurgyArmor(FantasyConfig.itemCelenegilPlateID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("CelenegilPlate");
		public static Item celenegilLegs = (new MetallurgyArmor(FantasyConfig.itemCelenegilLegsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("CelenegilLegs");
		public static Item celenegilBoots = (new MetallurgyArmor(FantasyConfig.itemCelenegilBootsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("CelenegilBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			ModLoader.addSmelting(celenegilDust.shiftedIndex, new ItemStack(celenegilBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(celenegilBar.shiftedIndex, new ItemStack(celenegilDust, 1));

			FF_EssenceRecipes.essence().addEssenceAmount(celenegilBar.shiftedIndex, 25);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickAlloys.blockID, meta, celenegilBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(celenegilAxe, celenegilBar);
			RecipeHelper.addPickaxeRecipe(celenegilPickaxe, celenegilBar);
			RecipeHelper.addShovelRecipe(celenegilShovel, celenegilBar);
			RecipeHelper.addHoeRecipe(celenegilHoe, celenegilBar);
			RecipeHelper.addSwordRecipe(celenegilSword, celenegilBar);
			RecipeHelper.addHelmetRecipe(celenegilPickaxe, celenegilBar);
			RecipeHelper.addPlateRecipe(celenegilPickaxe, celenegilBar);
			RecipeHelper.addLegsRecipe(celenegilPickaxe, celenegilBar);
			RecipeHelper.addBootsRecipe(celenegilPickaxe, celenegilBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(celenegilBar);
			RecipeHelper.addShearsRecipe(celenegilBar);

		    if(FantasyConfig.celenegilEnabled && mod_MetallurgyCore.hasPrecious)
		    	ModLoader.addShapelessRecipe(new ItemStack(celenegilDust, 1), new Object[] {OreOrichalcum.orichalcumDust, new ItemStack(OrePrecious.Dust, 1, 2)});
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), celenegilBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}