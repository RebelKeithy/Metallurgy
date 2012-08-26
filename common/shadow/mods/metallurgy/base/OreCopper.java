package shadow.mods.metallurgy.base;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class OreCopper
{
		public static final int meta = 0;
	
		public static String image = "/shadow/MetallurgyBaseMetals.png";
		
		public static Item CopperDust = (new MetallurgyItem(BaseConfig.ItemCopperDustID, image)).setIconCoord(0,3).setItemName("CopperDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		public static Item CopperBar = (new MetallurgyItem(BaseConfig.ItemCopperBarID, image)).setIconCoord(0,4).setItemName("CopperBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		public static Item CopperPickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemCopperPickaxeID, image, MetallurgyEnumToolMaterial.Copper).setIconCoord(0,7).setItemName("CopperPickaxe");
		public static Item CopperShovel = new MetallurgyItemSpade(BaseConfig.ItemCopperShovelID, image, MetallurgyEnumToolMaterial.Copper).setIconCoord(0,8).setItemName("CopperShovel");
		public static Item CopperAxe = new MetallurgyItemAxe(BaseConfig.ItemCopperAxeID, image, MetallurgyEnumToolMaterial.Copper).setIconCoord(0,5).setItemName("CopperAxe");
		public static Item CopperHoe = new MetallurgyItemHoe(BaseConfig.ItemCopperHoeID, image, MetallurgyEnumToolMaterial.Copper).setIconCoord(0,6).setItemName("CopperHoe");
		public static Item CopperSword = new MetallurgyItemSword(BaseConfig.ItemCopperSwordID, image, MetallurgyEnumToolMaterial.Copper).setIconCoord(0,9).setItemName("CopperSword");
		
		
		public static Item CopperHelmet = (new MetallurgyArmor(BaseConfig.ItemCopperHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 92)).setIconCoord(0,12).setItemName("CopperHelmet");
		public static Item CopperPlate = (new MetallurgyArmor(BaseConfig.ItemCopperPlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 120)).setIconCoord(0,13).setItemName("CopperPlate");
		public static Item CopperLegs = (new MetallurgyArmor(BaseConfig.ItemCopperLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 108)).setIconCoord(0,14).setItemName("CopperLegs");
		public static Item CopperBoots = (new MetallurgyArmor(BaseConfig.ItemCopperBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 80)).setIconCoord(0,15).setItemName("CopperBoots");
	
		public static void load()
		{
			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(CopperBar, 1));
			ModLoader.addSmelting(CopperDust.shiftedIndex, new ItemStack(CopperBar, 1));
				
			//Crusher
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, meta, new ItemStack(CopperDust, 2));
			BC_CrusherRecipes.smelting().addCrushing(CopperBar.shiftedIndex, new ItemStack(CopperDust, 1));

			if(mod_MetallurgyCore.hasFantasy)
				FF_EssenceRecipes.essence().addEssenceAmount(CopperBar.shiftedIndex, 1);
			else
				System.out.println("Fantasy not found, base abstractor recipes not added");
			 
	        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseMetalsBrick.blockID, meta, CopperBar);
	        
	        RecipeHelper.addPickaxeRecipe(CopperPickaxe, CopperBar);
	        RecipeHelper.addAxeRecipe(CopperAxe, CopperBar);
	        RecipeHelper.addShovelRecipe(CopperShovel, CopperBar);
	        RecipeHelper.addHoeRecipe(CopperHoe, CopperBar);
	        RecipeHelper.addSwordRecipe(CopperSword, CopperBar);
	        RecipeHelper.addHelmetRecipe(CopperHelmet, CopperBar);
	        RecipeHelper.addPlateRecipe(CopperPlate, CopperBar);
	        RecipeHelper.addLegsRecipe(CopperLegs, CopperBar);
	        RecipeHelper.addBootsRecipe(CopperBoots, CopperBar);
		    
		    //Buckets/Shears
		    RecipeHelper.addBucketRecipe(CopperBar);
		    RecipeHelper.addShearsRecipe(CopperBar);
		    
		    //Rails!
		    if(BaseConfig.railsEnabled)
		    	RecipeHelper.addRailsRecipe(CopperBar, 4);
		}

	
	public static void generateSurface(World world, Random rand, int chunkX, int chunkZ){
	}

}