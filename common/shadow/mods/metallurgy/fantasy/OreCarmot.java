package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreCarmot
{
		public static final int meta = 6;
	
		public static Item carmotDust = (new MetallurgyItem(FantasyConfig.itemCarmotDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("CarmotDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item carmotBar = (new MetallurgyItem(FantasyConfig.itemCarmotBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("CarmotBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item carmotPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemCarmotPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Carmot).setIconCoord(meta,7).setItemName("CarmotPickaxe");
		public static Item carmotShovel = new MetallurgyItemSpade(FantasyConfig.itemCarmotShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Carmot).setIconCoord(meta,8).setItemName("CarmotShovel");
		public static Item carmotAxe = new MetallurgyItemAxe(FantasyConfig.itemCarmotAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Carmot).setIconCoord(meta,5).setItemName("CarmotAxe");
		public static Item carmotHoe = new MetallurgyItemHoe(FantasyConfig.itemCarmotHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Carmot).setIconCoord(meta,6).setItemName("CarmotHoe");
		public static Item carmotSword = new MetallurgyItemSword(FantasyConfig.itemCarmotSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Carmot).setIconCoord(meta,9).setItemName("CarmotSword");
		
		public static Item carmotHelmet = (new MetallurgyArmor(FantasyConfig.itemCarmotHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("CarmotHelmet");
		public static Item carmotPlate = (new MetallurgyArmor(FantasyConfig.itemCarmotPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("CarmotPlate");
		public static Item carmotLegs = (new MetallurgyArmor(FantasyConfig.itemCarmotLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("CarmotLegs");
		public static Item carmotBoots = (new MetallurgyArmor(FantasyConfig.itemCarmotBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("CarmotBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(carmotBar, 1));
			ModLoader.addSmelting(carmotDust.shiftedIndex, new ItemStack(carmotBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(carmotBar.shiftedIndex, new ItemStack(carmotDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(carmotDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(carmotBar.shiftedIndex, 15);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, carmotBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(carmotAxe, carmotBar);
			RecipeHelper.addPickaxeRecipe(carmotPickaxe, carmotBar);
			RecipeHelper.addShovelRecipe(carmotShovel, carmotBar);
			RecipeHelper.addHoeRecipe(carmotHoe, carmotBar);
			RecipeHelper.addSwordRecipe(carmotSword, carmotBar);
			RecipeHelper.addHelmetRecipe(carmotHelmet, carmotBar);
			RecipeHelper.addPlateRecipe(carmotPlate, carmotBar);
			RecipeHelper.addLegsRecipe(carmotLegs, carmotBar);
			RecipeHelper.addBootsRecipe(carmotBoots, carmotBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(carmotBar);
			RecipeHelper.addShearsRecipe(carmotBar);
		    
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), carmotBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}