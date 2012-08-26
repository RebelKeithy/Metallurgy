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

public class AlloyDamascusSteel
{
	public static final int meta = 2;

	public static String image = "/shadow/MetallurgyBaseAlloys.png";
	
	public static Item DamascusSteelDust = (new MetallurgyItem(BaseConfig.ItemDamascusSteelDustID, image)).setIconCoord(meta,3).setItemName("DamascusSteelDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item DamascusSteelBar = (new MetallurgyItem(BaseConfig.ItemDamascusSteelBarID, image)).setIconCoord(meta,4).setItemName("DamascusSteelBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item DamascusSteelPickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemDamascusSteelPickaxeID, image, MetallurgyEnumToolMaterial.DamascusSteel).setIconCoord(meta,7).setItemName("DamascusSteelPickaxe");
	public static Item DamascusSteelShovel = new MetallurgyItemSpade(BaseConfig.ItemDamascusSteelShovelID, image, MetallurgyEnumToolMaterial.DamascusSteel).setIconCoord(meta,8).setItemName("DamascusSteelShovel");
	public static Item DamascusSteelAxe = new MetallurgyItemAxe(BaseConfig.ItemDamascusSteelAxeID, image, MetallurgyEnumToolMaterial.DamascusSteel).setIconCoord(meta,5).setItemName("DamascusSteelAxe");
	public static Item DamascusSteelHoe = new MetallurgyItemHoe(BaseConfig.ItemDamascusSteelHoeID, image, MetallurgyEnumToolMaterial.DamascusSteel).setIconCoord(meta,6).setItemName("DamascusSteelHoe");
	public static Item DamascusSteelSword = new MetallurgyItemSword(BaseConfig.ItemDamascusSteelSwordID, image, MetallurgyEnumToolMaterial.DamascusSteel).setIconCoord(meta,9).setItemName("DamascusSteelSword");
	
	public static Item DamascusSteelHelmet = (new MetallurgyArmor(BaseConfig.ItemDamascusSteelHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 138)).setIconCoord(meta,12).setItemName("DamascusSteelHelmet");
	public static Item DamascusSteelPlate = (new MetallurgyArmor(BaseConfig.ItemDamascusSteelPlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 180)).setIconCoord(meta,13).setItemName("DamascusSteelPlate");
	public static Item DamascusSteelLegs = (new MetallurgyArmor(BaseConfig.ItemDamascusSteelLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 162)).setIconCoord(meta,14).setItemName("DamascusSteelLegs");
	public static Item DamascusSteelBoots = (new MetallurgyArmor(BaseConfig.ItemDamascusSteelBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 120)).setIconCoord(meta,15).setItemName("DamascusSteelBoots");
	
	public static void load() 
	{				
		//Smelting
		ModLoader.addSmelting(DamascusSteelDust.shiftedIndex, new ItemStack(DamascusSteelBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(DamascusSteelBar.shiftedIndex, new ItemStack(DamascusSteelDust, 1));

		if(mod_MetallurgyCore.hasFantasy)
			FF_EssenceRecipes.essence().addEssenceAmount(DamascusSteelBar.shiftedIndex, 5);
		 
        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseAlloysBrick.blockID, meta, DamascusSteelBar);
        
		RecipeHelper.addPickaxeRecipe(DamascusSteelPickaxe, DamascusSteelBar);
		RecipeHelper.addAxeRecipe(DamascusSteelAxe, DamascusSteelBar);
		RecipeHelper.addShovelRecipe(DamascusSteelShovel, DamascusSteelBar);
		RecipeHelper.addHoeRecipe(DamascusSteelHoe, DamascusSteelBar);
		RecipeHelper.addSwordRecipe(DamascusSteelSword, DamascusSteelBar);

		RecipeHelper.addHelmetRecipe(DamascusSteelHelmet, DamascusSteelBar);
		RecipeHelper.addPlateRecipe(DamascusSteelPlate, DamascusSteelBar);
		RecipeHelper.addLegsRecipe(DamascusSteelLegs, DamascusSteelBar);
		RecipeHelper.addBootsRecipe(DamascusSteelBoots, DamascusSteelBar);
	    
	    RecipeHelper.addBucketRecipe(DamascusSteelBar);
	    RecipeHelper.addShearsRecipe(DamascusSteelBar);

	    if(BaseConfig.railsEnabled)
			RecipeHelper.addRailsRecipe(DamascusSteelBar, 20);
	    
	    if(BaseConfig.damascusEnabled)
	    	ModLoader.addShapelessRecipe(new ItemStack(DamascusSteelDust, 1), new Object[] {AlloyBronze.BronzeDust, OreIron.IronDust});
	}
}