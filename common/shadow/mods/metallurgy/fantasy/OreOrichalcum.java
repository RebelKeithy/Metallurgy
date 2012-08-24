package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreOrichalcum
{
		public static final int meta = 9;

		public static Item orichalcumDust = (new MetallurgyItem(FantasyConfig.itemOrichalcumDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("OrichalcumDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item orichalcumBar = (new MetallurgyItem(FantasyConfig.itemOrichalcumBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("OrichalcumBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item orichalcumPickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemOrichalcumPickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Orichalcum).setIconCoord(meta,7).setItemName("OrichalcumPickaxe");
		public static Item orichalcumShovel = new MetallurgyItemSpade(FantasyConfig.itemOrichalcumShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Orichalcum).setIconCoord(meta,8).setItemName("OrichalcumShovel");
		public static Item orichalcumAxe = new MetallurgyItemAxe(FantasyConfig.itemOrichalcumAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Orichalcum).setIconCoord(meta,5).setItemName("OrichalcumAxe");
		public static Item orichalcumHoe = new MetallurgyItemHoe(FantasyConfig.itemOrichalcumHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Orichalcum).setIconCoord(meta,6).setItemName("OrichalcumHoe");
		public static Item orichalcumSword = new MetallurgyItemSword(FantasyConfig.itemOrichalcumSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Orichalcum).setIconCoord(meta,9).setItemName("OrichalcumSword");
		
		public static Item orichalcumHelmet = (new MetallurgyArmor(FantasyConfig.itemOrichalcumHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("OrichalcumHelmet");
		public static Item orichalcumPlate = (new MetallurgyArmor(FantasyConfig.itemOrichalcumPlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("OrichalcumPlate");
		public static Item orichalcumLegs = (new MetallurgyArmor(FantasyConfig.itemOrichalcumLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("OrichalcumLegs");
		public static Item orichalcumBoots = (new MetallurgyArmor(FantasyConfig.itemOrichalcumBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("OrichalcumBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(orichalcumBar, 1));
			ModLoader.addSmelting(orichalcumDust.shiftedIndex, new ItemStack(orichalcumBar, 1));

			//Dust
			BC_CrusherRecipes.smelting().addCrushing(orichalcumBar.shiftedIndex, new ItemStack(orichalcumDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(orichalcumDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(orichalcumBar.shiftedIndex, 5);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, orichalcumBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(orichalcumAxe, orichalcumBar);
			RecipeHelper.addPickaxeRecipe(orichalcumPickaxe, orichalcumBar);
			RecipeHelper.addShovelRecipe(orichalcumShovel, orichalcumBar);
			RecipeHelper.addHoeRecipe(orichalcumHoe, orichalcumBar);
			RecipeHelper.addSwordRecipe(orichalcumSword, orichalcumBar);
			RecipeHelper.addHelmetRecipe(orichalcumPickaxe, orichalcumBar);
			RecipeHelper.addPlateRecipe(orichalcumPickaxe, orichalcumBar);
			RecipeHelper.addLegsRecipe(orichalcumPickaxe, orichalcumBar);
			RecipeHelper.addBootsRecipe(orichalcumPickaxe, orichalcumBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(orichalcumBar);
			RecipeHelper.addShearsRecipe(orichalcumBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), orichalcumBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}