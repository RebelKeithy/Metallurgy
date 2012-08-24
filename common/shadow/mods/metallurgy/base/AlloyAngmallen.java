package shadow.mods.metallurgy.base;
import java.util.Random;
import java.util.Map;
import java.io.File;

import net.minecraft.src.BaseMod;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import shadow.mods.metallurgy.BC_CrusherRecipes;
import shadow.mods.metallurgy.MetallurgyArmor;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.MetallurgyItemAxe;
import shadow.mods.metallurgy.MetallurgyItemHoe;
import shadow.mods.metallurgy.MetallurgyItemPickaxe;
import shadow.mods.metallurgy.MetallurgyItemSpade;
import shadow.mods.metallurgy.MetallurgyItemSword;
import shadow.mods.metallurgy.MetallurgyProps;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

public class AlloyAngmallen
{
	public static final int meta = 3;
	
	public static String image = "/shadow/MetallurgyBaseAlloys.png";

	public static Item AngmallenDust = (new MetallurgyItem(BaseConfig.ItemAngmallenDustID, image)).setIconCoord(meta,3).setItemName("AngmallenDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
	public static Item AngmallenBar = (new MetallurgyItem(BaseConfig.ItemAngmallenBarID, image)).setIconCoord(meta,4).setItemName("AngmallenBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
	
	public static Item AngmallenPickaxe = new MetallurgyItemPickaxe(BaseConfig.ItemAngmallenPickaxeID, image, MetallurgyEnumToolMaterial.Angmallen).setIconCoord(meta,7).setItemName("AngmallenPickaxe");
	public static Item AngmallenShovel = new MetallurgyItemSpade(BaseConfig.ItemAngmallenShovelID, image, MetallurgyEnumToolMaterial.Angmallen).setIconCoord(meta,8).setItemName("AngmallenShovel");
	public static Item AngmallenAxe = new MetallurgyItemAxe(BaseConfig.ItemAngmallenAxeID, image, MetallurgyEnumToolMaterial.Angmallen).setIconCoord(meta,5).setItemName("AngmallenAxe");
	public static Item AngmallenHoe = new MetallurgyItemHoe(BaseConfig.ItemAngmallenHoeID, image, MetallurgyEnumToolMaterial.Angmallen).setIconCoord(meta,6).setItemName("AngmallenHoe");
	public static Item AngmallenSword = new MetallurgyItemSword(BaseConfig.ItemAngmallenSwordID, image, MetallurgyEnumToolMaterial.Angmallen).setIconCoord(meta,9).setItemName("AngmallenSword");
	
	public static Item AngmallenHelmet = (new MetallurgyArmor(BaseConfig.ItemAngmallenHelmetID, image, EnumArmorMaterial.CLOTH, 0, 0, 10, 138)).setIconCoord(meta,12).setItemName("AngmallenHelmet");
	public static Item AngmallenPlate = (new MetallurgyArmor(BaseConfig.ItemAngmallenPlateID, image, EnumArmorMaterial.CLOTH, 0, 1, 10, 180)).setIconCoord(meta,13).setItemName("AngmallenPlate");
	public static Item AngmallenLegs = (new MetallurgyArmor(BaseConfig.ItemAngmallenLegsID, image, EnumArmorMaterial.CLOTH, 0, 2, 10, 162)).setIconCoord(meta,14).setItemName("AngmallenLegs");
	public static Item AngmallenBoots = (new MetallurgyArmor(BaseConfig.ItemAngmallenBootsID, image, EnumArmorMaterial.CLOTH, 0, 3, 10, 120)).setIconCoord(meta,15).setItemName("AngmallenBoots");
	
		
	public static void load()
	{
		//Smelting
		ModLoader.addSmelting(AngmallenDust.shiftedIndex, new ItemStack(AngmallenBar, 1));
			
		//Crusher
		BC_CrusherRecipes.smelting().addCrushing(AngmallenBar.shiftedIndex, new ItemStack(AngmallenDust, 1));

		
		 try {
			Class a = Class.forName("FF_EssenceRecipes");
			FF_EssenceRecipes.essence().addEssenceAmount(AngmallenBar.shiftedIndex, 9);
		} catch (ClassNotFoundException e) {
		}
		
        RecipeHelper.addBrickRecipes(mod_MetallurgyBaseMetals.BaseAlloysBrick.blockID, meta, AngmallenBar);
        
		RecipeHelper.addPickaxeRecipe(AngmallenPickaxe, AngmallenBar);
		RecipeHelper.addAxeRecipe(AngmallenAxe, AngmallenBar);
		RecipeHelper.addShovelRecipe(AngmallenShovel, AngmallenBar);
		RecipeHelper.addHoeRecipe(AngmallenHoe, AngmallenBar);
		RecipeHelper.addSwordRecipe(AngmallenSword, AngmallenBar);

		RecipeHelper.addHelmetRecipe(AngmallenHelmet, AngmallenBar);
		RecipeHelper.addPlateRecipe(AngmallenPlate, AngmallenBar);
		RecipeHelper.addLegsRecipe(AngmallenLegs, AngmallenBar);
		RecipeHelper.addBootsRecipe(AngmallenBoots, AngmallenBar);
	    
	    RecipeHelper.addBucketRecipe(AngmallenBar);
	    RecipeHelper.addShearsRecipe(AngmallenBar);
	    
	    if(BaseConfig.angmallenEnabled)
	    	ModLoader.addShapelessRecipe(new ItemStack(AngmallenDust, 1), new Object[] {OreGold.GoldDust, OreIron.IronDust});
	    
	    //Rails!
	    if(BaseConfig.railsEnabled)
		ModLoader.addRecipe(new ItemStack(Block.rail, 20), new Object[] {
			"X X", "X|X", "X X", Character.valueOf('X'), AngmallenBar, Character.valueOf('|'), Item.stick
		});
	}

}