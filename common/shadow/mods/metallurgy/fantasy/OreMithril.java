package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreMithril
{
		public static final int meta = 7;

		public static Item mithrilDust = (new MetallurgyItem(FantasyConfig.itemMithrilDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("MithrilDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item mithrilBar = (new MetallurgyItem(FantasyConfig.itemMithrilBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("MithrilBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item mithrilPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemMithrilPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Mithril).setIconCoord(meta,7).setItemName("MithrilPickaxe");
		public static Item mithrilShovel = new MetallurgyItemSpade(FantasyConfig.itemMithrilShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Mithril).setIconCoord(meta,8).setItemName("MithrilShovel");
		public static Item mithrilAxe = new MetallurgyItemAxe(FantasyConfig.itemMithrilAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Mithril).setIconCoord(meta,5).setItemName("MithrilAxe");
		public static Item mithrilHoe = new MetallurgyItemHoe(FantasyConfig.itemMithrilHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Mithril).setIconCoord(meta,6).setItemName("MithrilHoe");
		public static Item mithrilSword = new MetallurgyItemSword(FantasyConfig.itemMithrilSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Mithril).setIconCoord(meta,9).setItemName("MithrilSword");
		
		public static Item mithrilHelmet = (new MetallurgyArmor(FantasyConfig.itemMithrilHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("MithrilHelmet");
		public static Item mithrilPlate = (new MetallurgyArmor(FantasyConfig.itemMithrilPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("MithrilPlate");
		public static Item mithrilLegs = (new MetallurgyArmor(FantasyConfig.itemMithrilLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("MithrilLegs");
		public static Item mithrilBoots = (new MetallurgyArmor(FantasyConfig.itemMithrilBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("MithrilBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(mithrilBar, 1));
			ModLoader.addSmelting(mithrilDust.shiftedIndex, new ItemStack(mithrilBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(mithrilBar.shiftedIndex, new ItemStack(mithrilDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(mithrilDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(mithrilBar.shiftedIndex, 4);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, mithrilBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(mithrilAxe, mithrilBar);
			RecipeHelper.addPickaxeRecipe(mithrilPickaxe, mithrilBar);
			RecipeHelper.addShovelRecipe(mithrilShovel, mithrilBar);
			RecipeHelper.addHoeRecipe(mithrilHoe, mithrilBar);
			RecipeHelper.addSwordRecipe(mithrilSword, mithrilBar);
			RecipeHelper.addHelmetRecipe(mithrilHelmet, mithrilBar);
			RecipeHelper.addPlateRecipe(mithrilPlate, mithrilBar);
			RecipeHelper.addLegsRecipe(mithrilLegs, mithrilBar);
			RecipeHelper.addBootsRecipe(mithrilBoots, mithrilBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(mithrilBar);
			RecipeHelper.addShearsRecipe(mithrilBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), mithrilBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}