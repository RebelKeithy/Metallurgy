package shadow.mods.metallurgy.precious;

import java.util.ArrayList;
import java.util.List;

import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class OrePrecious {
	
	public static final int numMetals = 3;
	
	public static Item Dust;
	public static Item Bar;
	
	public static Item[] Pickaxe = new Item[numMetals];
	public static Item[] Shovel = new Item[numMetals];
	public static Item[] Axe = new Item[numMetals];
	public static Item[] Hoe = new Item[numMetals];
	public static Item[] Sword = new Item[numMetals];
	
	public static Item[] Helmet = new Item[numMetals];
	public static Item[] Plate = new Item[numMetals];
	public static Item[] Legs = new Item[numMetals];
	public static Item[] Boots = new Item[numMetals];
	
	public static String imageName = "/shadow/MetallurgyPreciousMetals.png";
	public static String[] name = {"Zinc", "Silver", "Platinum"};
	
	public static int[] expValue = {3, 5, 20};
	public static MetallurgyEnumToolMaterial[] toolEnum = {MetallurgyEnumToolMaterial.Copper, MetallurgyEnumToolMaterial.Silver, MetallurgyEnumToolMaterial.Platinum};
	
	public static int[] defaultVeinCount = {8, 6, 3};
	public static int[] defaultOreCount = {8, 6, 3};
	public static int[] defaultOreHeight = {128, 128, 128};
	
	public static List catalysts = new ArrayList<Integer>();
	
	static
	{
		catalysts.add(new Integer(0));
	}
	
	public static void init()
	{
		Dust = (new MetallurgyItemMeta(PreciousConfig.ItemStartID+0, imageName, name)).setIconCoord(0,3).setItemName("PreciousMetalsDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		Bar = (new MetallurgyItemMeta(PreciousConfig.ItemStartID+1, imageName, name)).setIconCoord(0,4).setItemName("PreciousMetalsBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		for(int i = 0; i < numMetals; i++)
		{

			if(catalysts.contains(i))
				continue;
			
			Pickaxe[i] = new MetallurgyItemPickaxe(PreciousConfig.ItemStartID+(i*50)+2, imageName, toolEnum[i]).setIconCoord(i,7).setItemName(name[i] + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(PreciousConfig.ItemStartID+(i*50)+3, imageName, toolEnum[i]).setIconCoord(i,8).setItemName(name[i] + "Shovel");
			Axe[i] = new MetallurgyItemAxe(PreciousConfig.ItemStartID+(i*50)+4, imageName, toolEnum[i]).setIconCoord(i,5).setItemName(name[i] + "Axe");
			Hoe[i] = new MetallurgyItemHoe(PreciousConfig.ItemStartID+(i*50)+5, imageName, toolEnum[i]).setIconCoord(i,6).setItemName(name[i] + "Hoe");
			Sword[i] = new MetallurgyItemSword(PreciousConfig.ItemStartID+(i*50)+6, imageName, toolEnum[i]).setIconCoord(i,9).setItemName(name[i] + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+7, imageName, EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(name[i] + "Helmet");
			Plate[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+8, imageName, EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(name[i] + "Plate");
			Legs[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+9, imageName, EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(name[i] + "Legs");
			Boots[i] = (new MetallurgyArmor(PreciousConfig.ItemStartID+(i*50)+10, imageName, EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(name[i] + "Boots");
		}
	}
	
	public static void load()
	{		
		for(int i = 0; i < numMetals; i++)
		{
			
			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyPrecious.PreciousMetalsVein.blockID, i, new ItemStack(Bar, 1, i));
			FurnaceRecipes.smelting().addSmelting(Dust.shiftedIndex, i, new ItemStack(Bar, 1, i));	
			
			//Crusher
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyPrecious.PreciousMetalsVein.blockID, i, new ItemStack(Dust, 2, i));
			BC_CrusherRecipes.smelting().addCrushing(Bar.shiftedIndex, i, new ItemStack(Dust, 1, i));

			if(mod_MetallurgyCore.hasFantasy)
				FF_EssenceRecipes.essence().addEssence(Bar.shiftedIndex, i, expValue[i]);
			 
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyPrecious.PreciousMetalsBrick.blockID, i, Bar, i);
			
			if(catalysts.contains(i))
				continue;

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
	}
}
