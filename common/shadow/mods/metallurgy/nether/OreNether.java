package shadow.mods.metallurgy.nether;

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
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.base.AlloyAngmallen;
import shadow.mods.metallurgy.base.AlloyBronze;
import shadow.mods.metallurgy.base.AlloyDamascusSteel;
import shadow.mods.metallurgy.base.AlloyHepatizon;
import shadow.mods.metallurgy.base.AlloySteel;
import shadow.mods.metallurgy.base.BaseConfig;
import shadow.mods.metallurgy.base.OreCopper;
import shadow.mods.metallurgy.base.OreGold;
import shadow.mods.metallurgy.base.OreIron;
import shadow.mods.metallurgy.base.OreManganese;
import shadow.mods.metallurgy.base.OreTin;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import shadow.mods.metallurgy.fantasy.mod_MetallurgyFantasy;
import shadow.mods.metallurgy.precious.AlloyPrecious;
import shadow.mods.metallurgy.precious.OrePrecious;

public class OreNether {
	
	public static final int numMetals = 8;
	
	public static Item[] Dust = new Item[numMetals];
	public static Item[] Bar = new Item[numMetals];
	
	public static Item[] Pickaxe = new Item[numMetals];
	public static Item[] Shovel = new Item[numMetals];
	public static Item[] Axe = new Item[numMetals];
	public static Item[] Hoe = new Item[numMetals];
	public static Item[] Sword = new Item[numMetals];
	
	public static Item[] Helmet = new Item[numMetals];
	public static Item[] Plate = new Item[numMetals];
	public static Item[] Legs = new Item[numMetals];
	public static Item[] Boots = new Item[numMetals];
	
	public static String imageName = "/shadow/MetallurgyNetherMetals.png";
	public static String[] name = {"Ignatius", "Shadow Iron", "Midasium", "Vyroxeres", "Ceruclase", "Kalendrite", "Vulcanite", "Sanguinite"};
	
	public static int[] expValue = {1, 2, 3, 3, 3, 4, 5, 6};
	public static MetallurgyEnumToolMaterial[] toolEnum = {MetallurgyEnumToolMaterial.Ignatius, MetallurgyEnumToolMaterial.ShadowIron, MetallurgyEnumToolMaterial.Midasium, MetallurgyEnumToolMaterial.Vyroxeres, MetallurgyEnumToolMaterial.Ceruclase, MetallurgyEnumToolMaterial.Kalendrite, MetallurgyEnumToolMaterial.Vulcanite, MetallurgyEnumToolMaterial.Sanguinite};
	
	public static int[] defaultVeinCount = {12, 10, 6, 5, 5, 4, 3, 3};
	public static int[] defaultOreCount = {6, 6, 6, 6, 4, 4, 4, 4};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128};
	
	public static void init()
	{
		for(int i = 0; i < numMetals; i++)
		{
			if(i == 0)
				Dust[i] = (new NetherFuelDust(NetherConfig.ItemStartID+(i*50), imageName, 6400)).setIconCoord(i,3).setItemName(name[i] + "Dust").setTabToDisplayOn(CreativeTabs.tabMaterials);
			else if(i == 6)
				Dust[i] = (new NetherFuelDust(NetherConfig.ItemStartID+(i*50), imageName, 51200)).setIconCoord(i,3).setItemName(name[i] + "Dust").setTabToDisplayOn(CreativeTabs.tabMaterials);
			else
				Dust[i] = (new MetallurgyItem(NetherConfig.ItemStartID+(i*50), imageName)).setIconCoord(i,3).setItemName(name[i] + "Dust").setTabToDisplayOn(CreativeTabs.tabMaterials);
			Bar[i] = (new MetallurgyItem(NetherConfig.ItemStartID+(i*50)+1, imageName)).setIconCoord(i,4).setItemName(name[i] + "Bar").setTabToDisplayOn(CreativeTabs.tabMaterials);
			
			Pickaxe[i] = new MetallurgyItemPickaxe(NetherConfig.ItemStartID+(i*50)+2, imageName, toolEnum[0]).setIconCoord(i,7).setItemName(name[i] + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(NetherConfig.ItemStartID+(i*50)+3, imageName, toolEnum[0]).setIconCoord(i,8).setItemName(name[i] + "Shovel");
			Axe[i] = new MetallurgyItemAxe(NetherConfig.ItemStartID+(i*50)+4, imageName, toolEnum[0]).setIconCoord(i,5).setItemName(name[i] + "Axe");
			Hoe[i] = new MetallurgyItemHoe(NetherConfig.ItemStartID+(i*50)+5, imageName, toolEnum[0]).setIconCoord(i,6).setItemName(name[i] + "Hoe");
			Sword[i] = new MetallurgyItemSword(NetherConfig.ItemStartID+(i*50)+6, imageName, toolEnum[0]).setIconCoord(i,9).setItemName(name[i] + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+7, "/shadow/MetallurgyNetherMetals.png", EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(name[i] + "Helmet");
			Plate[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+8, "/shadow/MetallurgyNetherMetals.png", EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(name[i] + "Plate");
			Legs[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+9, "/shadow/MetallurgyNetherMetals.png", EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(name[i] + "Legs");
			Boots[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+10, "/shadow/MetallurgyNetherMetals.png", EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(name[i] + "Boots");
		}
	}
	
	public static void load()
	{
		addMidasiumRecipes();

		ModLoader.addRecipe(new ItemStack(Item.blazeRod, 1), new Object[] {
			"X", "X", Character.valueOf('X'), Bar[6]
		});
		
		for(int i = 0; i < numMetals; i++)
		{
			
			//Smelting
			FurnaceRecipes.smelting().addSmelting(mod_MetallurgyNether.NetherMetalsVein.blockID, i, new ItemStack(Bar[i], 1));
			ModLoader.addSmelting(Dust[i].shiftedIndex, new ItemStack(Bar[i], 1));
				
			//Crusher
			BC_CrusherRecipes.smelting().addCrushing(mod_MetallurgyNether.NetherMetalsVein.blockID, i, new ItemStack(Dust[i], 2));
			BC_CrusherRecipes.smelting().addCrushing(Bar[i].shiftedIndex, new ItemStack(Dust[i], 1));
	
			try {
				Class a = Class.forName("FF_EssenceRecipes");
				FF_EssenceRecipes.essence().addEssenceAmount(Bar[i].shiftedIndex, expValue[i]);
			} catch (ClassNotFoundException e) {
			}
			 
			//Bricks!
			RecipeHelper.addBrickRecipes(mod_MetallurgyNether.NetherMetalsBrick.blockID, i, Bar[i], 0);
			
	        //Tools
			RecipeHelper.addAxeRecipe(Axe[i], Bar[i]);
			RecipeHelper.addPickaxeRecipe(Pickaxe[i], Bar[i]);
			RecipeHelper.addShovelRecipe(Shovel[i], Bar[i]);
			RecipeHelper.addHoeRecipe(Hoe[i], Bar[i]);
			RecipeHelper.addSwordRecipe(Sword[i], Bar[i]);
			RecipeHelper.addHelmetRecipe(Helmet[i], Bar[i]);
			RecipeHelper.addPlateRecipe(Plate[i], Bar[i]);
			RecipeHelper.addLegsRecipe(Legs[i], Bar[i]);
			RecipeHelper.addBootsRecipe(Boots[i], Bar[i]);
		    
		    //Buckets/Shears
			RecipeHelper.addBucketRecipe(Bar[i]);
			RecipeHelper.addShearsRecipe(Bar[i]);
		}		
	}
	
	public static void addMidasiumRecipes()
	{	    
		if(mod_MetallurgyCore.hasBase)
	    {
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {OreCopper.CopperDust, Dust[2]}); //Copper
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {OreTin.TinDust, Dust[2]}); //Tin
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {AlloyBronze.BronzeDust, Dust[2]}); //Bronze
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {AlloyHepatizon.HepatizonDust, Dust[2]}); //Hepatizon
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {OreGold.GoldDust, Dust[2]}); //Gold
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {OreIron.IronDust, Dust[2]}); //Iron
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {AlloyDamascusSteel.DamascusSteelDust, Dust[2]}); //Damascus Steel
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {AlloyAngmallen.AngmallenDust, Dust[2]}); //Angmallen
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {OreManganese.ManganeseDust, Dust[2]}); //Manganese
    		ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {AlloySteel.SteelDust, Dust[2]}); //Steel
	    	    
		    //Precious Metals
		    if(mod_MetallurgyCore.hasPrecious)
		    {
				for(int i  = 0; i < 2; i++)
					ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {new ItemStack(AlloyPrecious.Dust, 1, i), Dust[2]});
				for(int i  = 0; i < 3; i++)
					ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {new ItemStack(OrePrecious.Dust, 1, i), Dust[2]});
		    }
		    
		    //Nether Metals
			for(int i  = 0; i < 3; i++)
				ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {new ItemStack(AlloyNether.Dust, 1, i), Dust[2]});
			for(int i  = 0; i < 8; i++)
				ModLoader.addShapelessRecipe(new ItemStack(OreGold.GoldDust, 1), new Object[] {Dust[i], Dust[2]});
	    }
	}
}
