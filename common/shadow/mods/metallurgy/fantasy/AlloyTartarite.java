package shadow.mods.metallurgy.fantasy;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;

import net.minecraft.client.Minecraft;
import net.minecraft.src.*;

public class AlloyTartarite
{
		public static final int meta = 4;
		
		public static Item tartariteDust = (new MetallurgyItem(FantasyConfig.itemTartariteDustID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,3).setItemName("TartariteDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item tartariteBar = (new MetallurgyItem(FantasyConfig.itemTartariteBarID, "/shadow/MetallurgyFantasyAlloys.png")).setIconCoord(meta,4).setItemName("TartariteBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item tartaritePickaxe = new MetallurgyItemPickaxe(FantasyConfig.itemTartaritePickaxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Tartarite).setIconCoord(meta,7).setItemName("TartaritePickaxe");
		public static Item tartariteShovel = new MetallurgyItemSpade(FantasyConfig.itemTartariteShovelID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Tartarite).setIconCoord(meta,8).setItemName("TartariteShovel");
		public static Item 	tartariteAxe = new MetallurgyItemAxe(FantasyConfig.itemTartariteAxeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Tartarite).setIconCoord(meta,5).setItemName("TartariteAxe");
		public static Item tartariteHoe = new MetallurgyItemHoe(FantasyConfig.itemTartariteHoeID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Tartarite).setIconCoord(meta,6).setItemName("TartariteHoe");
		public static Item tartariteSword = new MetallurgyItemSword(FantasyConfig.itemTartariteSwordID, "/shadow/MetallurgyFantasyAlloys.png", MetallurgyEnumToolMaterial.Tartarite).setIconCoord(meta,9).setItemName("TartariteSword");
		
		public static Item tartariteHelmet = (new MetallurgyArmor(FantasyConfig.itemTartariteHelmetID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(meta,12).setItemName("TartariteHelmet");
		public static Item tartaritePlate = (new MetallurgyArmor(FantasyConfig.itemTartaritePlateID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(meta,13).setItemName("TartaritePlate");
		public static Item tartariteLegs = (new MetallurgyArmor(FantasyConfig.itemTartariteLegsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(meta,14).setItemName("TartariteLegs");
		public static Item tartariteBoots = (new MetallurgyArmor(FantasyConfig.itemTartariteBootsID, "/shadow/MetallurgyFantasyAlloys.png", EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(meta,15).setItemName("TartariteBoots");

		//Load Recipes
		public static void load()
		{

			//Smelting
			ModLoader.addSmelting(tartariteDust.shiftedIndex, new ItemStack(tartariteBar, 1));
			
			//Dust
			BC_CrusherRecipes.smelting().addCrushing(tartariteBar.shiftedIndex, new ItemStack(tartariteDust, 1));

			FF_EssenceRecipes.essence().addEssenceAmount(tartariteBar.shiftedIndex, 13);
			
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyFantasy.brickAlloys.blockID, meta, tartariteBar);
			
	        //Tools
			RecipeHelper.addAxeRecipe(tartariteAxe, tartariteBar);
			RecipeHelper.addPickaxeRecipe(tartaritePickaxe, tartariteBar);
			RecipeHelper.addShovelRecipe(tartariteShovel, tartariteBar);
			RecipeHelper.addHoeRecipe(tartariteHoe, tartariteBar);
			RecipeHelper.addSwordRecipe(tartariteSword, tartariteBar);
			RecipeHelper.addHelmetRecipe(tartariteHelmet, tartariteBar);
			RecipeHelper.addPlateRecipe(tartaritePlate, tartariteBar);
			RecipeHelper.addLegsRecipe(tartariteLegs, tartariteBar);
			RecipeHelper.addBootsRecipe(tartariteBoots, tartariteBar);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(tartariteBar);
			RecipeHelper.addShearsRecipe(tartariteBar);
		    
			if(FantasyConfig.tartariteEnabled)
		    	ModLoader.addShapelessRecipe(new ItemStack(tartariteDust, 1), new Object[] {OreAdamantine.adamantineDust, OreAtlarus.atlarusDust});
		    
		    /*
		    //Rails!
			ModLoader.addRecipe(new ItemStack(Block.rail, 4), new Object[] {
				"X X", "X|X", "X X", Character.valueOf('X'), tartariteBar, Character.valueOf('|'), Item.stick
			});
			*/
		}

}