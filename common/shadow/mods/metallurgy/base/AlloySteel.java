package shadow.mods.metallurgy.base;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

import net.minecraft.client.Minecraft;
import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class AlloySteel
{		
	public static final int meta = 4;
	
	public static String image = "/shadow/MetallurgyBaseAlloys.png";
	
	public static Item SteelDust = (new MetallurgyItem(BaseConfig.ItemSteelDustID, image)).setIconCoord(4,3).setItemName("SteelDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item SteelBar = (new MetallurgyItem(BaseConfig.ItemSteelBarID, image)).setIconCoord(4,4).setItemName("SteelBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item SteelPickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemSteelPickaxeID, image, MetallurgyEnumToolMaterial.Steel).setIconCoord(4,7).setItemName("SteelPickaxe").setTabToDisplayOn(CreativeTabs.tabTools);
	public static Item SteelShovel = new MetallurgyItemSpade(BaseConfig.ItemSteelShovelID, image, MetallurgyEnumToolMaterial.Steel).setIconCoord(4,8).setItemName("SteelShovel").setTabToDisplayOn(CreativeTabs.tabTools);
	public static Item SteelAxe = new MetallurgyItemAxe(BaseConfig.ItemSteelAxeID, image, MetallurgyEnumToolMaterial.Steel).setIconCoord(4,5).setItemName("SteelAxe").setTabToDisplayOn(CreativeTabs.tabTools);
	public static Item SteelHoe = new MetallurgyItemHoe(BaseConfig.ItemSteelHoeID, image, MetallurgyEnumToolMaterial.Steel).setIconCoord(4,6).setItemName("SteelHoe").setTabToDisplayOn(CreativeTabs.tabTools);
	public static Item SteelSword = new MetallurgyItemSword(BaseConfig.ItemSteelSwordID, image, MetallurgyEnumToolMaterial.Steel).setIconCoord(4,9).setItemName("SteelSword").setTabToDisplayOn(CreativeTabs.tabCombat);
	
	public static Item SteelHelmet = (new MetallurgyArmor(BaseConfig.ItemSteelHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 230)).setIconCoord(4,12).setItemName("SteelHelmet").setTabToDisplayOn(CreativeTabs.tabCombat);
	public static Item SteelPlate = (new MetallurgyArmor(BaseConfig.ItemSteelPlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 300)).setIconCoord(4,13).setItemName("SteelPlate").setTabToDisplayOn(CreativeTabs.tabCombat);
	public static Item SteelLegs = (new MetallurgyArmor(BaseConfig.ItemSteelLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 270)).setIconCoord(4,14).setItemName("SteelLegs").setTabToDisplayOn(CreativeTabs.tabCombat);
	public static Item SteelBoots = (new MetallurgyArmor(BaseConfig.ItemSteelBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 200)).setIconCoord(4,15).setItemName("SteelBoots").setTabToDisplayOn(CreativeTabs.tabCombat);
		
	public static void load() 
	{
		//Smelting
		ModLoader.addSmelting(SteelDust.shiftedIndex, new ItemStack(SteelBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(SteelBar.shiftedIndex, new ItemStack(SteelDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(SteelBar.shiftedIndex, 6);
		
        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseAlloysBrick.blockID, meta, SteelBar);
        
		RecipeHelper.addPickaxeRecipe(SteelPickaxe, SteelBar);
		RecipeHelper.addAxeRecipe(SteelAxe, SteelBar);
		RecipeHelper.addShovelRecipe(SteelShovel, SteelBar);
		RecipeHelper.addHoeRecipe(SteelHoe, SteelBar);
		RecipeHelper.addSwordRecipe(SteelSword, SteelBar);

		RecipeHelper.addHelmetRecipe(SteelHelmet, SteelBar);
		RecipeHelper.addPlateRecipe(SteelPlate, SteelBar);
		RecipeHelper.addLegsRecipe(SteelLegs, SteelBar);
		RecipeHelper.addBootsRecipe(SteelBoots, SteelBar);
	    
	    RecipeHelper.addBucketRecipe(SteelBar);
	    RecipeHelper.addShearsRecipe(SteelBar);

	    if(BaseConfig.railsEnabled)
			RecipeHelper.addRailsRecipe(SteelBar, 20);
	    
	    if(BaseConfig.steelEnabled)
	    	ModLoader.addShapelessRecipe(new ItemStack(SteelDust, 1), new Object[] {OreIron.IronDust, OreManganese.ManganeseDust});
	}
}