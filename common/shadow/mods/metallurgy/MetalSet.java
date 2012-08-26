package shadow.mods.metallurgy;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
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
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;

public class MetalSet implements IWorldGenerator {
	
	public int numMetals;
	
	public Block ore;
	public Block brick;
	
	public Item[] Dust;
	public Item[] Bar;
	
	public Item[] Pickaxe;
	public Item[] Shovel;
	public Item[] Axe;
	public Item[] Hoe;
	public Item[] Sword;
	
	public Item[] Helmet;
	public Item[] Plate;
	public Item[] Legs;
	public Item[] Boots;
	
	public String imageName;
	public String setName;
	public String[] name;
	
	public int[] expValue;
	public static MetallurgyEnumToolMaterial[] toolEnum = {MetallurgyEnumToolMaterial.Ignatius, MetallurgyEnumToolMaterial.ShadowIron, MetallurgyEnumToolMaterial.Midasium, MetallurgyEnumToolMaterial.Vyroxeres, MetallurgyEnumToolMaterial.Ceruclase, MetallurgyEnumToolMaterial.Kalendrite, MetallurgyEnumToolMaterial.Vulcanite, MetallurgyEnumToolMaterial.Sanguinite};
	
	public static int[] defaultVeinCount = {12, 10, 6, 5, 5, 4, 3, 3};
	public static int[] defaultOreCount = {6, 6, 6, 6, 4, 4, 4, 4};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128};
	
	public MetalSet(IMetalSetEnum info)
	{
		setName = info.getSetName();
		numMetals = info.numMetals();
		
		Dust = new Item[numMetals];
		Bar = new Item[numMetals];
		
		Pickaxe = new Item[numMetals];
		Shovel = new Item[numMetals];
		Axe = new Item[numMetals];
		Hoe = new Item[numMetals];
		Sword = new Item[numMetals];
		
		Helmet = new Item[numMetals];
		Plate = new Item[numMetals];
		Legs = new Item[numMetals];
		Boots = new Item[numMetals];
		
		name = info.names().clone();
		expValue = info.expValues().clone();
		imageName = info.image();
		int startID = info.startID();
		
		for(int i = 0; i < numMetals; i++)
		{
			Dust[i] = (new MetallurgyItem(startID+(i*50), imageName)).setIconCoord(i,3).setItemName(name[i] + "Dust").setTabToDisplayOn(CreativeTabs.tabMaterials);
			Bar[i] = (new MetallurgyItem(startID+(i*50)+1, imageName)).setIconCoord(i,4).setItemName(name[i] + "Bar").setTabToDisplayOn(CreativeTabs.tabMaterials);
			
			if(info.catalysts().contains(i))
				continue;
			Pickaxe[i] = new MetallurgyItemPickaxe(startID+(i*50)+2, imageName, toolEnum[i]).setIconCoord(i,7).setItemName(name[i] + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(startID+(i*50)+3, imageName, toolEnum[i]).setIconCoord(i,8).setItemName(name[i] + "Shovel");
			Axe[i] = new MetallurgyItemAxe(startID+(i*50)+4, imageName, toolEnum[i]).setIconCoord(i,5).setItemName(name[i] + "Axe");
			Hoe[i] = new MetallurgyItemHoe(startID+(i*50)+5, imageName, toolEnum[i]).setIconCoord(i,6).setItemName(name[i] + "Hoe");
			Sword[i] = new MetallurgyItemSword(startID+(i*50)+6, imageName, toolEnum[i]).setIconCoord(i,9).setItemName(name[i] + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(startID+(i*50)+7, imageName, EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(name[i] + "Helmet");
			Plate[i] = (new MetallurgyArmor(startID+(i*50)+8, imageName, EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(name[i] + "Plate");
			Legs[i] = (new MetallurgyArmor(startID+(i*50)+9, imageName, EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(name[i] + "Legs");
			Boots[i] = (new MetallurgyArmor(startID+(i*50)+10, imageName, EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(name[i] + "Boots");
		}
		
		if(!info.isAlloy())
		{
			defaultVeinCount = info.veinCount().clone();
			defaultOreCount = info.oreCount().clone();
			defaultOreHeight = info.oreHeight().clone();
			
			ore = new MetallurgyBlock(info.oreID(), imageName, numMetals, 0).setHardness(2F).setResistance(.1F).setBlockName(setName + "Ore");
		}
		
		brick = new MetallurgyBlock(info.brickID(), imageName, numMetals, 1).setHardness(2F).setResistance(.1F).setBlockName(setName + "Brick");
	}
	
	public void load()
	{
		for(int i = 0; i < numMetals; i++)
		{
			//Smelting
			if(ore != null)
				FurnaceRecipes.smelting().addSmelting(ore.blockID, i, new ItemStack(Bar[i], 1));
			ModLoader.addSmelting(Dust[i].shiftedIndex, new ItemStack(Bar[i], 1));
				
			//Crusher
			if(ore != null)
				BC_CrusherRecipes.smelting().addCrushing(ore.blockID, i, new ItemStack(Dust[i], 2));
			BC_CrusherRecipes.smelting().addCrushing(Bar[i].shiftedIndex, new ItemStack(Dust[i], 1));

			if(mod_MetallurgyCore.hasFantasy)
				FF_EssenceRecipes.essence().addEssenceAmount(Bar[i].shiftedIndex, expValue[i]);
			 
			//Bricks!
			RecipeHelper.addBrickRecipes(brick.blockID, i, Bar[i], 0);
			
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
		
		if(ore != null)
			GameRegistry.registerWorldGenerator(this);
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		for(int i = 0; i < numMetals; i++)
			//if(NetherConfig.metalEnabled[i])
				generateOre(world, rand, chunkX * 16, chunkZ * 16, i);
	}

	public void generateOre(World world, Random rand, int chunkX, int chunkZ, int meta)
	{
		for(int i = 0; i < defaultVeinCount[meta]; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(defaultOreHeight[meta]);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenNetherMinable(ore.blockID, meta, defaultOreCount[meta])).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

}
