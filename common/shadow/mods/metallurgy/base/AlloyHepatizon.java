package shadow.mods.metallurgy.base;
import java.util.Random;
import java.util.Map;
import java.io.File;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class AlloyHepatizon
{
	public static final int meta = 1;

	public static String image = "/shadow/MetallurgyBaseAlloys.png";

	public static Item HepatizonDust = (new MetallurgyItem(BaseConfig.ItemHepatizonDustID, image)).setIconCoord(1,3).setItemName("HepatizonDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item HepatizonBar = (new MetallurgyItem(BaseConfig.ItemHepatizonBarID, image)).setIconCoord(1,4).setItemName("HepatizonBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item HepatizonPickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemHepatizonPickaxeID, image, MetallurgyEnumToolMaterial.Hepatizon).setIconCoord(1,7).setItemName("HepatizonPickaxe");
	public static Item HepatizonShovel = new MetallurgyItemSpade(BaseConfig.ItemHepatizonShovelID, image, MetallurgyEnumToolMaterial.Hepatizon).setIconCoord(1,8).setItemName("HepatizonShovel");
	public static Item HepatizonAxe = new MetallurgyItemAxe(BaseConfig.ItemHepatizonAxeID, image, MetallurgyEnumToolMaterial.Hepatizon).setIconCoord(1,5).setItemName("HepatizonAxe");
	public static Item HepatizonHoe = new MetallurgyItemHoe(BaseConfig.ItemHepatizonHoeID, image, MetallurgyEnumToolMaterial.Hepatizon).setIconCoord(1,6).setItemName("HepatizonHoe");
	public static Item HepatizonSword = new MetallurgyItemSword(BaseConfig.ItemHepatizonSwordID, image, MetallurgyEnumToolMaterial.Hepatizon).setIconCoord(1,9).setItemName("HepatizonSword");
	
	public static Item HepatizonHelmet = (new MetallurgyArmor(BaseConfig.ItemHepatizonHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 138)).setIconCoord(1,12).setItemName("HepatizonHelmet");
	public static Item HepatizonPlate = (new MetallurgyArmor(BaseConfig.ItemHepatizonPlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 180)).setIconCoord(1,13).setItemName("HepatizonPlate");
	public static Item HepatizonLegs = (new MetallurgyArmor(BaseConfig.ItemHepatizonLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 162)).setIconCoord(1,14).setItemName("HepatizonLegs");
	public static Item HepatizonBoots = (new MetallurgyArmor(BaseConfig.ItemHepatizonBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 120)).setIconCoord(1,15).setItemName("HepatizonBoots");

	public static void load() 
	{
		//Smelting
		ModLoader.addSmelting(HepatizonDust.shiftedIndex, new ItemStack(HepatizonBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(HepatizonBar.shiftedIndex, new ItemStack(HepatizonDust, 1));

		try {
			Class a = Class.forName("FF_EssenceRecipes");
			FF_EssenceRecipes.essence().addEssenceAmount(HepatizonBar.shiftedIndex, 8);
		} catch (ClassNotFoundException e) {
		}
		 
        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseAlloysBrick.blockID, meta, HepatizonBar);
        
		RecipeHelper.addPickaxeRecipe(HepatizonPickaxe, HepatizonBar);
		RecipeHelper.addAxeRecipe(HepatizonAxe, HepatizonBar);
		RecipeHelper.addShovelRecipe(HepatizonShovel, HepatizonBar);
		RecipeHelper.addHoeRecipe(HepatizonHoe, HepatizonBar);
		RecipeHelper.addSwordRecipe(HepatizonSword, HepatizonBar);

		RecipeHelper.addHelmetRecipe(HepatizonHelmet, HepatizonBar);
		RecipeHelper.addPlateRecipe(HepatizonPlate, HepatizonBar);
		RecipeHelper.addLegsRecipe(HepatizonLegs, HepatizonBar);
		RecipeHelper.addBootsRecipe(HepatizonBoots, HepatizonBar);
	    
	    RecipeHelper.addBucketRecipe(HepatizonBar);
	    RecipeHelper.addShearsRecipe(HepatizonBar);

	    if(BaseConfig.railsEnabled)
			RecipeHelper.addRailsRecipe(HepatizonBar, 20);
	    
	    if(BaseConfig.hepatizonEnabled)
	    	ModLoader.addShapelessRecipe(new ItemStack(HepatizonDust, 1), new Object[] {AlloyBronze.BronzeDust, OreGold.GoldDust});
	}
}