package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.base.BaseConfig;
import shadow.mods.metallurgy.base.OreGold;
import shadow.mods.metallurgy.base.OreIron;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class AlloyBlackSteel
{
		public static final int meta = 0;
	
		public static Item blackSteelDust = (new MetallurgyItem(FantasyConfig.itemBlackSteelDustID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,3).setItemName("BlackSteelDust").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item blackSteelBar = (new MetallurgyItem(FantasyConfig.itemBlackSteelBarID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,4).setItemName("BlackSteelBar").setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item blackSteelPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemBlackSteelPickaxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.BlackSteel).setIconCoord(meta,7).setItemName("BlackSteelPickaxe");
		public static Item blackSteelShovel = new MetallurgyItemSpade(FantasyConfig.itemBlackSteelShovelID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.BlackSteel).setIconCoord(meta,8).setItemName("BlackSteelShovel");
		public static Item blackSteelAxe = new MetallurgyItemAxe(FantasyConfig.itemBlackSteelAxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.BlackSteel).setIconCoord(meta,5).setItemName("BlackSteelAxe");
		public static Item blackSteelHoe = new MetallurgyItemHoe(FantasyConfig.itemBlackSteelHoeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.BlackSteel).setIconCoord(meta,6).setItemName("BlackSteelHoe");
		public static Item blackSteelSword = new MetallurgyItemSword(FantasyConfig.itemBlackSteelSwordID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.BlackSteel).setIconCoord(meta,9).setItemName("BlackSteelSword");
		
		public static Item blackSteelHelmet = (new MetallurgyArmor(FantasyConfig.itemBlackSteelHelmetID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("BlackSteelHelmet");
		public static Item blackSteelPlate = (new MetallurgyArmor(FantasyConfig.itemBlackSteelPlateID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("BlackSteelPlate");
		public static Item blackSteelLegs = (new MetallurgyArmor(FantasyConfig.itemBlackSteelLegsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("BlackSteelLegs");
		public static Item blackSteelBoots = (new MetallurgyArmor(FantasyConfig.itemBlackSteelBootsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("BlackSteelBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			ModLoader.addSmelting(blackSteelDust.shiftedIndex, new ItemStack(blackSteelBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(blackSteelBar.shiftedIndex, new ItemStack(blackSteelDust, 1));
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickAlloys.blockID, meta, blackSteelBar);
			
			FF_EssenceRecipes.essence().addEssenceAmount(blackSteelBar.shiftedIndex, 4);
			
	        //Tools
			RecipeHelper.addAxeRecipe(blackSteelAxe, blackSteelBar);
			RecipeHelper.addPickaxeRecipe(blackSteelPickaxe, blackSteelBar);
			RecipeHelper.addShovelRecipe(blackSteelShovel, blackSteelBar);
			RecipeHelper.addHoeRecipe(blackSteelHoe, blackSteelBar);
			RecipeHelper.addSwordRecipe(blackSteelSword, blackSteelBar);
			RecipeHelper.addHelmetRecipe(blackSteelPickaxe, blackSteelBar);
			RecipeHelper.addPlateRecipe(blackSteelPickaxe, blackSteelBar);
			RecipeHelper.addLegsRecipe(blackSteelPickaxe, blackSteelBar);
			RecipeHelper.addBootsRecipe(blackSteelPickaxe, blackSteelBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(blackSteelBar);
			RecipeHelper.addShearsRecipe(blackSteelBar);
			
		    if(FantasyConfig.blackSteelEnabled)
		    	ModLoader.addShapelessRecipe(new ItemStack(blackSteelDust, 1), new Object[] {OreDeepIron.deepIronDust, OreInfuscolium.infuscoliumDust});
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), blackSteelBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}