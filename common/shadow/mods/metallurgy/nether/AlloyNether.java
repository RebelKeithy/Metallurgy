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
import shadow.mods.metallurgy.MetallurgyItemMeta;
import shadow.mods.metallurgy.MetallurgyItemPickaxe;
import shadow.mods.metallurgy.MetallurgyItemSpade;
import shadow.mods.metallurgy.MetallurgyItemSword;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import shadow.mods.metallurgy.fantasy.mod_MetallurgyFantasy;
import shadow.mods.metallurgy.precious.mod_MetallurgyPrecious;

public class AlloyNether {
	
	public static final int numAlloys = 3;
	
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
	
	public static String imageName = "/shadow/MetallurgyNetherAlloys.png";
	public static String[] name = {"Shadow Steel", "Inolashite", "Amordrine"};
	public static int[] expValue = {4, 6, 24};
	public static MetallurgyEnumToolMaterial[] toolEnum = {MetallurgyEnumToolMaterial.ShadowSteel, MetallurgyEnumToolMaterial.Inolashite, MetallurgyEnumToolMaterial.Amordrine};
	
	
	public static void init()
	{
		
		Dust = (new MetallurgyItemMeta(NetherConfig.ItemStartID+400, imageName, name)).setIconCoord(0,3).setItemName("NetherAlloyDust").setTabToDisplayOn(CreativeTabs.tabMaterials);
		Bar = (new MetallurgyItemMeta(NetherConfig.ItemStartID+401, imageName, name)).setIconCoord(0,4).setItemName("NetherAlloyBar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		
		for(int i = 0; i < numAlloys; i++)
		{
			
			Pickaxe[i] = new MetallurgyItemPickaxe(NetherConfig.ItemStartID+(i*50)+2+400, imageName, toolEnum[i]).setIconCoord(i,7).setItemName(name[i] + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(NetherConfig.ItemStartID+(i*50)+3+400, imageName, toolEnum[i]).setIconCoord(i,8).setItemName(name[i] + "Shovel");
			Axe[i] = new MetallurgyItemAxe(NetherConfig.ItemStartID+(i*50)+4+400, imageName, toolEnum[i]).setIconCoord(i,5).setItemName(name[i] + "Axe");
			Hoe[i] = new MetallurgyItemHoe(NetherConfig.ItemStartID+(i*50)+5+400, imageName, toolEnum[i]).setIconCoord(i,6).setItemName(name[i] + "Hoe");
			Sword[i] = new MetallurgyItemSword(NetherConfig.ItemStartID+(i*50)+6+400, imageName, toolEnum[i]).setIconCoord(i,9).setItemName(name[i] + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+7+400, "/shadow/MetallurgyNetherAlloys.png", EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(name[i] + "Helmet");
			Plate[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+8+400, "/shadow/MetallurgyNetherAlloys.png", EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(name[i] + "Plate");
			Legs[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+9+400, "/shadow/MetallurgyNetherAlloys.png", EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(name[i] + "Legs");
			Boots[i] = (new MetallurgyArmor(NetherConfig.ItemStartID+(i*50)+10+400, "/shadow/MetallurgyNetherAlloys.png", EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(name[i] + "Boots");
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
			RecipeHelper.addBrickRecipes(mod_MetallurgyNether.NetherAlloysBrick.blockID, i, Bar, i);
			
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

		ModLoader.addShapelessRecipe(new ItemStack(Dust, 1, 0), new Object[] {OreNether.Dust[0], OreNether.Dust[0], OreNether.Dust[1]});
	    ModLoader.addShapelessRecipe(new ItemStack(Dust, 1, 1), new Object[] {OreNether.Dust[3], OreNether.Dust[4]});
	    if(mod_MetallurgyCore.hasPrecious)
	    	ModLoader.addShapelessRecipe(new ItemStack(Dust, 1, 2), new Object[] {new ItemStack(mod_MetallurgyPrecious.ores.Dust[2], 1), OreNether.Dust[5]});
		
	}
}
