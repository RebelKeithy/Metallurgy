package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreAstralSilver
{
		public static final int meta = 5;
	
		public static Item astralSilverDust = (new MetallurgyItem(FantasyConfig.itemAstralSilverDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("AstralSilverDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item astralSilverBar = (new MetallurgyItem(FantasyConfig.itemAstralSilverBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("AstralSilverBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item astralSilverPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemAstralSilverPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.AstralSilver).setIconCoord(meta,7).setItemName("AstralSilverPickaxe");
		public static Item astralSilverShovel = new MetallurgyItemSpade(FantasyConfig.itemAstralSilverShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.AstralSilver).setIconCoord(meta,8).setItemName("AstralSilverShovel");
		public static Item astralSilverAxe = new MetallurgyItemAxe(FantasyConfig.itemAstralSilverAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.AstralSilver).setIconCoord(meta,5).setItemName("AstralSilverAxe");
		public static Item astralSilverHoe = new MetallurgyItemHoe(FantasyConfig.itemAstralSilverHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.AstralSilver).setIconCoord(meta,6).setItemName("AstralSilverHoe");
		public static Item astralSilverSword = new MetallurgyItemSword(FantasyConfig.itemAstralSilverSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.AstralSilver).setIconCoord(meta,9).setItemName("AstralSilverSword");
		
		public static Item astralSilverHelmet = (new MetallurgyArmor(FantasyConfig.itemAstralSilverHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("AstralSilverHelmet");
		public static Item astralSilverPlate = (new MetallurgyArmor(FantasyConfig.itemAstralSilverPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("AstralSilverPlate");
		public static Item astralSilverLegs = (new MetallurgyArmor(FantasyConfig.itemAstralSilverLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("AstralSilverLegs");
		public static Item astralSilverBoots = (new MetallurgyArmor(FantasyConfig.itemAstralSilverBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("AstralSilverBoots");


		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(astralSilverBar, 1));
			ModLoader.addSmelting(astralSilverDust.shiftedIndex, new ItemStack(astralSilverBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(astralSilverBar.shiftedIndex, new ItemStack(astralSilverDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(astralSilverDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(astralSilverBar.shiftedIndex, 11);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, astralSilverBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(astralSilverAxe, astralSilverBar);
			RecipeHelper.addPickaxeRecipe(astralSilverPickaxe, astralSilverBar);
			RecipeHelper.addShovelRecipe(astralSilverShovel, astralSilverBar);
			RecipeHelper.addHoeRecipe(astralSilverHoe, astralSilverBar);
			RecipeHelper.addSwordRecipe(astralSilverSword, astralSilverBar);
			RecipeHelper.addHelmetRecipe(astralSilverHelmet, astralSilverBar);
			RecipeHelper.addPlateRecipe(astralSilverPlate, astralSilverBar);
			RecipeHelper.addLegsRecipe(astralSilverLegs, astralSilverBar);
			RecipeHelper.addBootsRecipe(astralSilverBoots, astralSilverBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(astralSilverBar);
			RecipeHelper.addShearsRecipe(astralSilverBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), astralSilverBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}