package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class OreOureclase
{
		public static final int meta = 3;
	
		public static Item oureclaseDust = (new MetallurgyItem(FantasyConfig.itemOureclaseDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("OureclaseDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item oureclaseBar = (new MetallurgyItem(FantasyConfig.itemOureclaseBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("OureclaseBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item oureclasePickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemOureclasePickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Oureclase).setIconCoord(meta,7).setItemName("OureclasePickaxe");
		public static Item oureclaseShovel = new MetallurgyItemSpade(FantasyConfig.itemOureclaseShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Oureclase).setIconCoord(meta,8).setItemName("OureclaseShovel");
		public static Item oureclaseAxe = new MetallurgyItemAxe(FantasyConfig.itemOureclaseAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Oureclase).setIconCoord(meta,5).setItemName("OureclaseAxe");
		public static Item oureclaseHoe = new MetallurgyItemHoe(FantasyConfig.itemOureclaseHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Oureclase).setIconCoord(meta,6).setItemName("OureclaseHoe");
		public static Item oureclaseSword = new MetallurgyItemSword(FantasyConfig.itemOureclaseSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Oureclase).setIconCoord(meta,9).setItemName("OureclaseSword");
		
		public static Item oureclaseHelmet = (new MetallurgyArmor(FantasyConfig.itemOureclaseHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("OureclaseHelmet");
		public static Item oureclasePlate = (new MetallurgyArmor(FantasyConfig.itemOureclasePlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("OureclasePlate");
		public static Item oureclaseLegs = (new MetallurgyArmor(FantasyConfig.itemOureclaseLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("OureclaseLegs");
		public static Item oureclaseBoots = (new MetallurgyArmor(FantasyConfig.itemOureclaseBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("OureclaseBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(oureclaseBar, 1));
			ModLoader.addSmelting(oureclaseDust.shiftedIndex, new ItemStack(oureclaseBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(oureclaseBar.shiftedIndex, new ItemStack(oureclaseDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(oureclaseDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(oureclaseBar.shiftedIndex, 3);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, oureclaseBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(oureclaseAxe, oureclaseBar);
			RecipeHelper.addPickaxeRecipe(oureclasePickaxe, oureclaseBar);
			RecipeHelper.addShovelRecipe(oureclaseShovel, oureclaseBar);
			RecipeHelper.addHoeRecipe(oureclaseHoe, oureclaseBar);
			RecipeHelper.addSwordRecipe(oureclaseSword, oureclaseBar);
			RecipeHelper.addHelmetRecipe(oureclasePickaxe, oureclaseBar);
			RecipeHelper.addPlateRecipe(oureclasePickaxe, oureclaseBar);
			RecipeHelper.addLegsRecipe(oureclasePickaxe, oureclaseBar);
			RecipeHelper.addBootsRecipe(oureclasePickaxe, oureclaseBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(oureclaseBar);
			RecipeHelper.addShearsRecipe(oureclaseBar);
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), oureclaseBar, Character.valueOf('|'), Item.stick
			});
			*/
		}


}