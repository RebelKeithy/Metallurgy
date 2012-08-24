package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreAredrite
{
		public static final int meta = 4;
		
		public static final String image = "/shadow/MetallurgyFantasyMetals.png";
		

		public static Item aredriteDust = (new MetallurgyItem(FantasyConfig.itemAredriteDustID, image)).setIconCoord(meta,3).setItemName("AredriteDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item aredriteBar = (new MetallurgyItem(FantasyConfig.itemAredriteBarID, image)).setIconCoord(meta,4).setItemName("AredriteBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item aredritePickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemAredritePickaxeID, image, MetallurgyEnumToolMaterial.Aredrite).setIconCoord(meta,7).setItemName("AredritePickaxe");
		public static Item aredriteShovel = new MetallurgyItemSpade(FantasyConfig.itemAredriteShovelID, image, MetallurgyEnumToolMaterial.Aredrite).setIconCoord(meta,8).setItemName("AredriteShovel");
		public static Item aredriteAxe = new MetallurgyItemAxe(FantasyConfig.itemAredriteAxeID, image, MetallurgyEnumToolMaterial.Aredrite).setIconCoord(meta,5).setItemName("AredriteAxe");
		public static Item aredriteHoe = new MetallurgyItemHoe(FantasyConfig.itemAredriteHoeID, image, MetallurgyEnumToolMaterial.Aredrite).setIconCoord(meta,6).setItemName("AredriteHoe");
		public static Item aredriteSword = new MetallurgyItemSword(FantasyConfig.itemAredriteSwordID, image, MetallurgyEnumToolMaterial.Aredrite).setIconCoord(meta,9).setItemName("AredriteSword");
		
		public static Item aredriteHelmet = (new MetallurgyArmor(FantasyConfig.itemAredriteHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("AredriteHelmet");
		public static Item aredritePlate = (new MetallurgyArmor(FantasyConfig.itemAredritePlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("AredritePlate");
		public static Item aredriteLegs = (new MetallurgyArmor(FantasyConfig.itemAredriteLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("AredriteLegs");
		public static Item aredriteBoots = (new MetallurgyArmor(FantasyConfig.itemAredriteBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("AredriteBoots");


		
		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(aredriteBar, 1));
			ModLoader.addSmelting(aredriteDust.shiftedIndex, new ItemStack(aredriteBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(aredriteBar.shiftedIndex, new ItemStack(aredriteDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(aredriteDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(aredriteBar.shiftedIndex, 3);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, aredriteBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(aredriteAxe, aredriteBar);
			RecipeHelper.addPickaxeRecipe(aredritePickaxe, aredriteBar);
			RecipeHelper.addShovelRecipe(aredriteShovel, aredriteBar);
			RecipeHelper.addHoeRecipe(aredriteHoe, aredriteBar);
			RecipeHelper.addSwordRecipe(aredriteSword, aredriteBar);
			RecipeHelper.addHelmetRecipe(aredritePickaxe, aredriteBar);
			RecipeHelper.addPlateRecipe(aredritePickaxe, aredriteBar);
			RecipeHelper.addLegsRecipe(aredritePickaxe, aredriteBar);
			RecipeHelper.addBootsRecipe(aredritePickaxe, aredriteBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(aredriteBar);
			RecipeHelper.addShearsRecipe(aredriteBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), aredriteBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}