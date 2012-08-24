package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.precious.OrePrecious;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class AlloyQuicksilver
{
		public static final int meta = 1;
	
		public static Item quicksilverDust = (new MetallurgyItem(FantasyConfig.itemQuicksilverDustID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,3).setItemName("QuicksilverDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item quicksilverBar = (new MetallurgyItem(FantasyConfig.itemQuicksilverBarID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,4).setItemName("QuicksilverBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item quicksilverPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemQuicksilverPickaxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Quicksilver).setIconCoord(meta,7).setItemName("QuicksilverPickaxe");
		public static Item quicksilverShovel = new MetallurgyItemSpade(FantasyConfig.itemQuicksilverShovelID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Quicksilver).setIconCoord(meta,8).setItemName("QuicksilverShovel");
		public static Item quicksilverAxe = new MetallurgyItemAxe(FantasyConfig.itemQuicksilverAxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Quicksilver).setIconCoord(meta,5).setItemName("QuicksilverAxe");
		public static Item quicksilverHoe = new MetallurgyItemHoe(FantasyConfig.itemQuicksilverHoeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Quicksilver).setIconCoord(meta,6).setItemName("QuicksilverHoe");
		public static Item quicksilverSword = new MetallurgyItemSword(FantasyConfig.itemQuicksilverSwordID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Quicksilver).setIconCoord(meta,9).setItemName("QuicksilverSword");
		
		public static Item quicksilverHelmet = (new MetallurgyArmor(FantasyConfig.itemQuicksilverHelmetID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("QuicksilverHelmet");
		public static Item quicksilverPlate = (new MetallurgyArmor(FantasyConfig.itemQuicksilverPlateID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("QuicksilverPlate");
		public static Item quicksilverLegs = (new MetallurgyArmor(FantasyConfig.itemQuicksilverLegsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("QuicksilverLegs");
		public static Item quicksilverBoots = (new MetallurgyArmor(FantasyConfig.itemQuicksilverBootsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("QuicksilverBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			ModLoader.addSmelting(quicksilverDust.shiftedIndex, new ItemStack(quicksilverBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(quicksilverBar.shiftedIndex, new ItemStack(quicksilverDust, 1));

			FF_EssenceRecipes.essence().addEssenceAmount(quicksilverBar.shiftedIndex, 9);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickAlloys.blockID, meta, quicksilverBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(quicksilverAxe, quicksilverBar);
			RecipeHelper.addPickaxeRecipe(quicksilverPickaxe, quicksilverBar);
			RecipeHelper.addShovelRecipe(quicksilverShovel, quicksilverBar);
			RecipeHelper.addHoeRecipe(quicksilverHoe, quicksilverBar);
			RecipeHelper.addSwordRecipe(quicksilverSword, quicksilverBar);
			RecipeHelper.addHelmetRecipe(quicksilverPickaxe, quicksilverBar);
			RecipeHelper.addPlateRecipe(quicksilverPickaxe, quicksilverBar);
			RecipeHelper.addLegsRecipe(quicksilverPickaxe, quicksilverBar);
			RecipeHelper.addBootsRecipe(quicksilverPickaxe, quicksilverBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(quicksilverBar);
			RecipeHelper.addShearsRecipe(quicksilverBar);

		    if(FantasyConfig.quicksilverEnabled && mod_MetallurgyCore.hasPrecious)
		    	ModLoader.addShapelessRecipe(new ItemStack(quicksilverDust, 1), new Object[] {OreMithril.mithrilDust, new ItemStack(OrePrecious.Dust, 1, 1)});
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), quicksilverBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}