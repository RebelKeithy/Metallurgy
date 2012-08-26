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

public class AlloyBronze
{
	public static final int meta = 0;
	
	public static String image = "/shadow/MetallurgyBaseAlloys.png";
	
	public static Item BronzeDust = (new MetallurgyItem(BaseConfig.ItemBronzeDustID, image)).setIconCoord(0,3).setItemName("BronzeDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item BronzeBar = (new MetallurgyItem(BaseConfig.ItemBronzeBarID, image)).setIconCoord(0,4).setItemName("BronzeBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item BronzePickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemBronzePickaxeID, image, MetallurgyEnumToolMaterial.Bronze).setIconCoord(0,7).setItemName("BronzePickaxe");
	public static Item BronzeShovel = new MetallurgyItemSpade(BaseConfig.ItemBronzeShovelID, image, MetallurgyEnumToolMaterial.Bronze).setIconCoord(0,8).setItemName("BronzeShovel");
	public static Item BronzeAxe = new MetallurgyItemAxe(BaseConfig.ItemBronzeAxeID, image, MetallurgyEnumToolMaterial.Bronze).setIconCoord(0,5).setItemName("BronzeAxe");
	public static Item BronzeHoe = new MetallurgyItemHoe(BaseConfig.ItemBronzeHoeID, image, MetallurgyEnumToolMaterial.Bronze).setIconCoord(0,6).setItemName("BronzeHoe");
	public static Item BronzeSword = new MetallurgyItemSword(BaseConfig.ItemBronzeSwordID, image, MetallurgyEnumToolMaterial.Bronze).setIconCoord(0,9).setItemName("BronzeSword");
	
	public static Item BronzeHelmet = (new MetallurgyArmor(BaseConfig.ItemBronzeHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 138)).setIconCoord(0,12).setItemName("BronzeHelmet");
	public static Item BronzePlate = (new MetallurgyArmor(BaseConfig.ItemBronzePlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 180)).setIconCoord(0,13).setItemName("BronzePlate");
	public static Item BronzeLegs = (new MetallurgyArmor(BaseConfig.ItemBronzeLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 162)).setIconCoord(0,14).setItemName("BronzeLegs");
	public static Item BronzeBoots = (new MetallurgyArmor(BaseConfig.ItemBronzeBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 120)).setIconCoord(0,15).setItemName("BronzeBoots");

	public static void load() 
	{
		//Smelting
		ModLoader.addSmelting(BronzeDust.shiftedIndex, new ItemStack(BronzeBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(BronzeBar.shiftedIndex, new ItemStack(BronzeDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(BronzeBar.shiftedIndex, 2);
		 
        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseAlloysBrick.blockID, meta, BronzeBar);
        
		RecipeHelper.addPickaxeRecipe(BronzePickaxe, BronzeBar);
		RecipeHelper.addAxeRecipe(BronzeAxe, BronzeBar);
		RecipeHelper.addShovelRecipe(BronzeShovel, BronzeBar);
		RecipeHelper.addHoeRecipe(BronzeHoe, BronzeBar);
		RecipeHelper.addSwordRecipe(BronzeSword, BronzeBar);

		RecipeHelper.addHelmetRecipe(BronzeHelmet, BronzeBar);
		RecipeHelper.addPlateRecipe(BronzePlate, BronzeBar);
		RecipeHelper.addLegsRecipe(BronzeLegs, BronzeBar);
		RecipeHelper.addBootsRecipe(BronzeBoots, BronzeBar);
	    
	    RecipeHelper.addBucketRecipe(BronzeBar);
	    RecipeHelper.addShearsRecipe(BronzeBar);

	    if(BaseConfig.railsEnabled)
			RecipeHelper.addRailsRecipe(BronzeBar, 20);

	    if(BaseConfig.bronzeEnabled)
	    	ModLoader.addShapelessRecipe(new ItemStack(BronzeDust, 1), new Object[] {OreCopper.CopperDust, OreTin.TinDust});
	    
	}
}