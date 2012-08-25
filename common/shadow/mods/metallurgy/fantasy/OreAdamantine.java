package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;
import net.minecraftforge.common.MinecraftForge;

public class OreAdamantine
{
		public static final int meta = 10;
		
		public static Item adamantineDust = (new MetallurgyItem(FantasyConfig.itemAdamantineDustID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,3).setItemName("AdamantineDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item adamantineBar = (new MetallurgyItem(FantasyConfig.itemAdamantineBarID, "/shadow/MetallurgyFantasyMetals.png")).setIconCoord(meta,4).setItemName("AdamantineBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item adamantinePickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemAdamantinePickaxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Adamantine).setIconCoord(meta,7).setItemName("AdamantinePickaxe");
		public static Item adamantineShovel = new MetallurgyItemSpade(FantasyConfig.itemAdamantineShovelID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Adamantine).setIconCoord(meta,8).setItemName("AdamantineShovel");
		public static Item adamantineAxe = new MetallurgyItemAxe(FantasyConfig.itemAdamantineAxeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Adamantine).setIconCoord(meta,5).setItemName("AdamantineAxe");
		public static Item adamantineHoe = new MetallurgyItemHoe(FantasyConfig.itemAdamantineHoeID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Adamantine).setIconCoord(meta,6).setItemName("AdamantineHoe");
		public static Item adamantineSword = new MetallurgyItemSword(FantasyConfig.itemAdamantineSwordID, "/shadow/MetallurgyFantasyMetals.png", MetallurgyEnumToolMaterial.Adamantine).setIconCoord(meta,9).setItemName("AdamantineSword");
		
		public static Item adamantineHelmet = (new MetallurgyArmor(FantasyConfig.itemAdamantineHelmetID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("AdamantineHelmet");
		public static Item adamantinePlate = (new MetallurgyArmor(FantasyConfig.itemAdamantinePlateID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("AdamantinePlate");
		public static Item adamantineLegs = (new MetallurgyArmor(FantasyConfig.itemAdamantineLegsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("AdamantineLegs");
		public static Item adamantineBoots = (new MetallurgyArmor(FantasyConfig.itemAdamantineBootsID, "/shadow/MetallurgyFantasyMetals.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("AdamantineBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(adamantineBar, 1));
			ModLoader.addSmelting(adamantineDust.shiftedIndex, new ItemStack(adamantineBar, 1));
			
			FF_EssenceRecipes.essence().addEssenceAmount(adamantineBar.shiftedIndex, 6);
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(adamantineBar.shiftedIndex, new ItemStack(adamantineDust, 1));
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyFantasy.vein.blockID, meta, new ItemStack(adamantineDust, 2));

			FF_EssenceRecipes.essence().addEssenceAmount(adamantineBar.shiftedIndex, 6);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickMetals.blockID, meta, adamantineBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(adamantineAxe, adamantineBar);
			RecipeHelper.addPickaxeRecipe(adamantinePickaxe, adamantineBar);
			RecipeHelper.addShovelRecipe(adamantineShovel, adamantineBar);
			RecipeHelper.addHoeRecipe(adamantineHoe, adamantineBar);
			RecipeHelper.addSwordRecipe(adamantineSword, adamantineBar);
			RecipeHelper.addHelmetRecipe(adamantineHelmet, adamantineBar);
			RecipeHelper.addPlateRecipe(adamantinePlate, adamantineBar);
			RecipeHelper.addLegsRecipe(adamantineLegs, adamantineBar);
			RecipeHelper.addBootsRecipe(adamantineBoots, adamantineBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(adamantineBar);
			RecipeHelper.addShearsRecipe(adamantineBar);
		    
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), adamantineBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

	


}