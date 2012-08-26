package shadow.mods.metallurgy.precious;

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
import shadow.mods.metallurgy.MetallurgyItemMeta;
import shadow.mods.metallurgy.MetallurgyItemPickaxe;
import shadow.mods.metallurgy.MetallurgyItemSpade;
import shadow.mods.metallurgy.MetallurgyItemSword;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.base.OreCopper;
import shadow.mods.metallurgy.base.OreGold;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import shadow.mods.metallurgy.fantasy.mod_MetallurgyFantasy;

public class AlloyPrecious {
	
	public static final int numAlloys = 2;
	
	public static Item Dust;
	public static Item Bar;
	
	public static Item[] Pickaxe = new Item[numAlloys];
	public static Item[] Shovel = new Item[numAlloys];
	public static Item[] Axe = new Item[numAlloys];
	public static Item[] Hoe = new Item[numAlloys];
	public static Item[] Sword = new Item[numAlloys];
	
	public static Item[] Helmet = new Item[numAlloys];
	public static Item[] Plate = new Item[numAlloys];
	public static Item[] Legs = new Item[numAlloys];
	public static Item[] Boots = new Item[numAlloys];
	
	public static String imageName = "/shadow/MetallurgyPreciousAlloys.png";
	public static String[] name = {"Brass", "Electrum"};
	public static int[] expValue = {4, 11};
	public static MetallurgyEnumToolMaterial[] toolEnum = {MetallurgyEnumToolMaterial.Brass, MetallurgyEnumToolMaterial.Electrum};
	
	
	public static void init()
	{
		
		Dust = (new MetallurgyItemMeta(PreciousConfig.ItemStartID+150, imageName, name)).setIconCoord(0,3).setItemName("PreciousAlloyDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		Bar = (new MetallurgyItemMeta(PreciousConfig.ItemStartID+151, imageName, name)).setIconCoord(0,4).setItemName("PreciousAlloyBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		for(int i = 0; i < numAlloys; i++)
		{
			
			Pickaxe[i] = new MetallurgyItemPickaxe(PreciousConfig.ItemStartID+(i*50)+2+150, imageName, toolEnum[i]).setIconCoord(i,7).setItemName(name[i] + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(PreciousConfig.ItemStartID+(i*50)+3+150, imageName, toolEnum[i]).setIconCoord(i,8).setItemName(name[i] + "Shovel");
			Axe[i] = new MetallurgyItemAxe(PreciousConfig.ItemStartID+(i*50)+4+150, imageName, toolEnum[i]).setIconCoord(i,5).setItemName(name[i] + "Axe");
			Hoe[i] = new MetallurgyItemHoe(PreciousConfig.ItemStartID+(i*50)+5+150, imageName, toolEnum[i]).setIconCoord(i,6).setItemName(name[i] + "Hoe");
			Sword[i] = new MetallurgyItemSword(PreciousConfig.ItemStartID+(i*50)+6+150, imageName, toolEnum[i]).setIconCoord(i,9).setItemName(name[i] + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+7+150, imageName, EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(name[i] + "Helmet");
			Plate[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+8+150, imageName, EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(name[i] + "Plate");
			Legs[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+9+150, imageName, EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(name[i] + "Legs");
			Boots[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+10+150, imageName, EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(name[i] + "Boots");
		}
	}
	
	public static void load()
	{
		for(int i = 0; i < numAlloys; i++)
		{
			//Smelting
			FurnaceRecipes.smelting().addSmelting(Dust.shiftedIndex, i, new ItemStack(Bar, 1, i));
				
			//Crusher
			BC_CrusherRecipes.smelting().addCrushing(Bar.shiftedIndex, i, new ItemStack(Dust, 1, i));

			if(mod_MetallurgyCore.hasFantasy)
				FF_EssenceRecipes.essence().addEssence(Bar.shiftedIndex, i, expValue[i]);
			 
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyPrecious.PreciousAlloysBrick.blockID, i, Bar, i);
			
	        //Tools
			RecipeHelper.addAxeRecipe(new ItemStack(Axe[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addPickaxeRecipe(new ItemStack(Pickaxe[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addShovelRecipe(new ItemStack(Shovel[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addHoeRecipe(new ItemStack(Hoe[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addSwordRecipe(new ItemStack(Sword[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addHelmetRecipe(new ItemStack(Helmet[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addPlateRecipe(new ItemStack(Plate[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addLegsRecipe(new ItemStack(Legs[i], 1), new ItemStack(Bar, 1, i));
			RecipeHelper.addBootsRecipe(new ItemStack(Boots[i], 1), new ItemStack(Bar, 1, i));
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(new ItemStack(Bar, 1, i));
			RecipeHelper.addShearsRecipe(new ItemStack(Bar, 1, i));
		}

		if(mod_MetallurgyCore.hasBase)
		{
			ModLoader.addShapelessRecipe(new ItemStack(Dust, 1, 0), new Object[] {OreCopper.CopperDust, new ItemStack(OrePrecious.Dust, 1, 0)});
	    	ModLoader.addShapelessRecipe(new ItemStack(Dust, 1, 1), new Object[] {OreGold.GoldDust, new ItemStack(OrePrecious.Dust, 1, 1)});
		}
	}
}
