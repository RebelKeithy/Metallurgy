package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class AlloyHaderoth
{
		public static final int meta = 2;
		
		public static Item haderothDust = (new MetallurgyItem(FantasyConfig.itemHaderothDustID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,3).setItemName("HaderothDust").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item haderothBar = (new MetallurgyItem(FantasyConfig.itemHaderothBarID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,4).setItemName("HaderothBar").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item haderothPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemHaderothPickaxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Haderoth).setIconCoord(meta,7).setItemName("HaderothPickaxe");
		public static Item haderothShovel = new MetallurgyItemSpade(FantasyConfig.itemHaderothShovelID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Haderoth).setIconCoord(meta,8).setItemName("HaderothShovel");
		public static Item haderothAxe = new MetallurgyItemAxe(FantasyConfig.itemHaderothAxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Haderoth).setIconCoord(meta,5).setItemName("HaderothAxe");
		public static Item haderothHoe = new MetallurgyItemHoe(FantasyConfig.itemHaderothHoeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Haderoth).setIconCoord(meta,6).setItemName("HaderothHoe");
		public static Item haderothSword = new MetallurgyItemSword(FantasyConfig.itemHaderothSwordID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Haderoth).setIconCoord(meta,9).setItemName("HaderothSword");
		
		public static Item haderothHelmet = (new MetallurgyArmor(FantasyConfig.itemHaderothHelmetID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("HaderothHelmet");
		public static Item haderothPlate = (new MetallurgyArmor(FantasyConfig.itemHaderothPlateID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("HaderothPlate");
		public static Item haderothLegs = (new MetallurgyArmor(FantasyConfig.itemHaderothLegsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("HaderothLegs");
		public static Item haderothBoots = (new MetallurgyArmor(FantasyConfig.itemHaderothBootsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("HaderothBoots");

		//Load Recipes
		public static void load()
		{			
			//Smelting
			ModLoader.addSmelting(haderothDust.shiftedIndex, new ItemStack(haderothBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(haderothBar.shiftedIndex, new ItemStack(haderothDust, 1));

			FF_EssenceRecipes.essence().addEssenceAmount(haderothBar.shiftedIndex, 6);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickAlloys.blockID, meta, haderothBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(haderothAxe, haderothBar);
			RecipeHelper.addPickaxeRecipe(haderothPickaxe, haderothBar);
			RecipeHelper.addShovelRecipe(haderothShovel, haderothBar);
			RecipeHelper.addHoeRecipe(haderothHoe, haderothBar);
			RecipeHelper.addSwordRecipe(haderothSword, haderothBar);
			RecipeHelper.addHelmetRecipe(haderothHelmet, haderothBar);
			RecipeHelper.addPlateRecipe(haderothPlate, haderothBar);
			RecipeHelper.addLegsRecipe(haderothLegs, haderothBar);
			RecipeHelper.addBootsRecipe(haderothBoots, haderothBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(haderothBar);
			RecipeHelper.addShearsRecipe(haderothBar);

		    if(FantasyConfig.haderothEnabled)
		    	ModLoader.addShapelessRecipe(new ItemStack(haderothDust, 1), new Object[] {OreMithril.mithrilDust, OreRubracium.rubraciumDust});
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), haderothBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}