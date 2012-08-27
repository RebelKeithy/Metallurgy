package shadow.mods.metallurgy;

import java.util.Random;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.FurnaceRecipes;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Item;
import net.minecraft.src.ItemBlock;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
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
	public String setName;
	
	public IMetalSetEnum info;
	
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
	
	public MetalSet(IMetalSetEnum info)
	{
		this.info = info;
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
	
		int startID = info.startID();
		
		for(int i = 0; i < numMetals; i++)
		{
			System.out.println(startID);
			Dust[i] = (new MetallurgyItem(startID+(i*50), info.image())).setIconCoord(i,3).setItemName(info.name(i) + "Dust").setTabToDisplayOn(CreativeTabs.tabMaterials);
			Bar[i] = (new MetallurgyItem(startID+(i*50)+1, info.image())).setIconCoord(i,4).setItemName(info.name(i) + "Bar").setTabToDisplayOn(CreativeTabs.tabMaterials);
			
			if(info.isCatalyst(i))
				continue;
			Pickaxe[i] = new MetallurgyItemPickaxe(startID+(i*50)+2, info.image(), info.toolEnum(i)).setIconCoord(i,7).setItemName(info.name(i) + "Pickaxe");
			Shovel[i] = new MetallurgyItemSpade(startID+(i*50)+3, info.image(), info.toolEnum(i)).setIconCoord(i,8).setItemName(info.name(i) + "Shovel");
			Axe[i] = new MetallurgyItemAxe(startID+(i*50)+4, info.image(), info.toolEnum(i)).setIconCoord(i,5).setItemName(info.name(i) + "Axe");
			Hoe[i] = new MetallurgyItemHoe(startID+(i*50)+5, info.image(), info.toolEnum(i)).setIconCoord(i,6).setItemName(info.name(i) + "Hoe");
			Sword[i] = new MetallurgyItemSword(startID+(i*50)+6, info.image(), info.toolEnum(i)).setIconCoord(i,9).setItemName(info.name(i) + "Sword");
			
			Helmet[i] = (new MetallurgyArmor(startID+(i*50)+7, info.image(), EnumArmorMaterial.IRON, 0, 0, 10, 230)).setIconCoord(i,12).setItemName(info.name(i) + "Helmet");
			Plate[i] = (new MetallurgyArmor(startID+(i*50)+8, info.image(), EnumArmorMaterial.IRON, 0, 1, 10, 300)).setIconCoord(i,13).setItemName(info.name(i) + "Plate");
			Legs[i] = (new MetallurgyArmor(startID+(i*50)+9, info.image(), EnumArmorMaterial.IRON, 0, 2, 10, 270)).setIconCoord(i,14).setItemName(info.name(i) + "Legs");
			Boots[i] = (new MetallurgyArmor(startID+(i*50)+10, info.image(), EnumArmorMaterial.IRON, 0, 3, 10, 200)).setIconCoord(i,15).setItemName(info.name(i) + "Boots");
		}
		
		if(!info.isAlloy())			
			ore = new MetallurgyBlock(info.oreID(), info.image(), numMetals, 0).setHardness(2F).setResistance(.1F).setBlockName(setName + "Ore");
		
		brick = new MetallurgyBlock(info.brickID(), info.image(), numMetals, 1).setHardness(2F).setResistance(.1F).setBlockName(setName + "Brick");
		
		for(int i = 0; i < numMetals; i++)
		{
			MinecraftForge.setBlockHarvestLevel(ore, i, "pickaxe", info.oreHarvestLevel(i));
			MinecraftForge.setBlockHarvestLevel(brick, i, "pickaxe", info.oreHarvestLevel(i)); 
			MinecraftForge.setToolClass(Pickaxe[0], "pickaxe", info.pickLevel(i));
		}
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
				FF_EssenceRecipes.essence().addEssenceAmount(Bar[i].shiftedIndex, info.expValue(i));
			 
			//Bricks!
			RecipeHelper.addBrickRecipes(brick.blockID, i, Bar[i], 0);
			
	        if(!info.isCatalyst(i))
	        {
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
		

		for(int i = 0; i < numMetals; i++)
		{
			OreDictionary.registerOre("dust" + info.name(i), new ItemStack(Dust[i], 1));
			OreDictionary.registerOre("ingot" + info.name(i), new ItemStack(Bar[i], 1));
			DungeonHooks.addDungeonLoot(new ItemStack(Bar[i], 1), info.dungeonLootChance(i), 1, info.dungeonLootAmount(i));
		}
		
		if(ore != null)
		{
			GameRegistry.registerWorldGenerator(this);
			GameRegistry.registerBlock(ore, MetallurgyItemBlock.class);
		}

		GameRegistry.registerBlock(brick, MetallurgyItemBlock.class);
	}
	
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		for(int i = 0; i < numMetals; i++)
			//if(NetherConfig.metalEnabled[i])
				generateOre(world, rand, chunkX * 16, chunkZ * 16, i);
	}

	public void generateOre(World world, Random rand, int chunkX, int chunkZ, int meta)
	{
		for(int i = 0; i < info.veinCount(meta); i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(info.oreHeight(meta));
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenNetherMinable(ore.blockID, meta, info.oreCount(meta))).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

}
