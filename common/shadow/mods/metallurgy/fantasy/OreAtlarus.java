package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreAtlarus
{
		public static final int meta = 11;
	
		public static Item atlarusDust = (new MetallurgyItem(FantasyConfig.itemAtlarusDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("AtlarusDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item atlarusBar = (new MetallurgyItem(FantasyConfig.itemAtlarusBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("AtlarusBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item atlarusPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemAtlarusPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Atlarus).setIconCoord(meta,7).setItemName("AtlarusPickaxe");
		public static Item atlarusShovel = new MetallurgyItemSpade(FantasyConfig.itemAtlarusShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Atlarus).setIconCoord(meta,8).setItemName("AtlarusShovel");
		public static Item atlarusAxe = new MetallurgyItemAxe(FantasyConfig.itemAtlarusAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Atlarus).setIconCoord(meta,5).setItemName("AtlarusAxe");
		public static Item atlarusHoe = new MetallurgyItemHoe(FantasyConfig.itemAtlarusHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Atlarus).setIconCoord(meta,6).setItemName("AtlarusHoe");
		public static Item atlarusSword = new MetallurgyItemSword(FantasyConfig.itemAtlarusSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Atlarus).setIconCoord(meta,9).setItemName("AtlarusSword");
		
		public static Item atlarusHelmet = (new MetallurgyArmor(FantasyConfig.itemAtlarusHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("AtlarusHelmet");
		public static Item atlarusPlate = (new MetallurgyArmor(FantasyConfig.itemAtlarusPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("AtlarusPlate");
		public static Item atlarusLegs = (new MetallurgyArmor(FantasyConfig.itemAtlarusLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("AtlarusLegs");
		public static Item atlarusBoots = (new MetallurgyArmor(FantasyConfig.itemAtlarusBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("AtlarusBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(atlarusBar, 1));
			ModLoader.addSmelting(atlarusDust.shiftedIndex, new ItemStack(atlarusBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(atlarusBar.shiftedIndex, new ItemStack(atlarusDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(atlarusDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(atlarusBar.shiftedIndex, 7);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, atlarusBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(atlarusAxe, atlarusBar);
			RecipeHelper.addPickaxeRecipe(atlarusPickaxe, atlarusBar);
			RecipeHelper.addShovelRecipe(atlarusShovel, atlarusBar);
			RecipeHelper.addHoeRecipe(atlarusHoe, atlarusBar);
			RecipeHelper.addSwordRecipe(atlarusSword, atlarusBar);
			RecipeHelper.addHelmetRecipe(atlarusHelmet, atlarusBar);
			RecipeHelper.addPlateRecipe(atlarusPlate, atlarusBar);
			RecipeHelper.addLegsRecipe(atlarusLegs, atlarusBar);
			RecipeHelper.addBootsRecipe(atlarusBoots, atlarusBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(atlarusBar);
			RecipeHelper.addShearsRecipe(atlarusBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), atlarusBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}