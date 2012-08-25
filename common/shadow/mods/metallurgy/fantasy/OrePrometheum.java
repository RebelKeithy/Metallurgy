package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OrePrometheum
{
		public static final int meta = 0;
	
		public static Item prometheumDust = (new MetallurgyItem(FantasyConfig.itemPrometheumDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("PrometheumDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item prometheumBar = (new MetallurgyItem(FantasyConfig.itemPrometheumBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("PrometheumBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item prometheumPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemPrometheumPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Prometheum).setIconCoord(meta,7).setItemName("PrometheumPickaxe");
		public static Item prometheumShovel = new MetallurgyItemSpade(FantasyConfig.itemPrometheumShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Prometheum).setIconCoord(meta,8).setItemName("PrometheumShovel");
		public static Item prometheumAxe = new MetallurgyItemAxe(FantasyConfig.itemPrometheumAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Prometheum).setIconCoord(meta,5).setItemName("PrometheumAxe");
		public static Item prometheumHoe = new MetallurgyItemHoe(FantasyConfig.itemPrometheumHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Prometheum).setIconCoord(meta,6).setItemName("PrometheumHoe");
		public static Item prometheumSword = new MetallurgyItemSword(FantasyConfig.itemPrometheumSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Prometheum).setIconCoord(meta,9).setItemName("PrometheumSword");
		
		public static Item prometheumHelmet = (new MetallurgyArmor(FantasyConfig.itemPrometheumHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("PrometheumHelmet");
		public static Item prometheumPlate = (new MetallurgyArmor(FantasyConfig.itemPrometheumPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("PrometheumPlate");
		public static Item prometheumLegs = (new MetallurgyArmor(FantasyConfig.itemPrometheumLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("PrometheumLegs");
		public static Item prometheumBoots = (new MetallurgyArmor(FantasyConfig.itemPrometheumBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("PrometheumBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(prometheumBar, 1));
			ModLoader.addSmelting(prometheumDust.shiftedIndex, new ItemStack(prometheumBar, 1));

			//Dust
			BC_CrusherRecipes.smelting().addCrushing(prometheumBar.shiftedIndex, new ItemStack(prometheumDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(prometheumDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(prometheumBar.shiftedIndex, 1);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, prometheumBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(prometheumAxe, prometheumBar);
			RecipeHelper.addPickaxeRecipe(prometheumPickaxe, prometheumBar);
			RecipeHelper.addShovelRecipe(prometheumShovel, prometheumBar);
			RecipeHelper.addHoeRecipe(prometheumHoe, prometheumBar);
			RecipeHelper.addSwordRecipe(prometheumSword, prometheumBar);
			RecipeHelper.addHelmetRecipe(prometheumHelmet, prometheumBar);
			RecipeHelper.addPlateRecipe(prometheumPlate, prometheumBar);
			RecipeHelper.addLegsRecipe(prometheumLegs, prometheumBar);
			RecipeHelper.addBootsRecipe(prometheumBoots, prometheumBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(prometheumBar);
			RecipeHelper.addShearsRecipe(prometheumBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), prometheumBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}