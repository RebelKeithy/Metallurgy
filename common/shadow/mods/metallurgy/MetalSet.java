package shadow.mods.metallurgy;

import java.util.HashMap;
import java.util.Random;

//import ic2.api.Ic2Recipes;

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
import net.minecraft.src.WorldGenMinable;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
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
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.fantasy.FF_EssenceRecipes;
import shadow.mods.metallurgy.precious.OrePreciousEnum;

public class MetalSet implements IWorldGenerator {
	
	public int numMetals;
	public String setName;
	
	public IMetalSetEnum info;
	
	public Block ore;
	public Block brick;
	public Block block;
	
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

	public static int oreSpawnCount;
	
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
	
		
		for(int i = 0; i < numMetals; i++)
		{
			int startID = info.startID(i);
			Dust[i] = (new MetallurgyItem(startID, info.image())).setIconCoord(i,3).setItemName(info.name(i) + "Dust").setCreativeTab(info.getCreativeTab());
			Bar[i] = (new MetallurgyItem(startID+1, info.image())).setIconCoord(i,4).setItemName(info.name(i) + "Bar").setCreativeTab(info.getCreativeTab());
			
			if(info.isCatalyst(i))
				continue;
			Pickaxe[i] = new MetallurgyItemPickaxe(startID+2, info.image(), info.toolEnum(i)).setIconCoord(i,7).setItemName(info.name(i) + "Pickaxe").setCreativeTab(info.getCreativeTab());
			Shovel[i] = new MetallurgyItemSpade(startID+3, info.image(), info.toolEnum(i)).setIconCoord(i,8).setItemName(info.name(i) + "Shovel").setCreativeTab(info.getCreativeTab());
			Axe[i] = new MetallurgyItemAxe(startID+4, info.image(), info.toolEnum(i)).setIconCoord(i,5).setItemName(info.name(i) + "Axe").setCreativeTab(info.getCreativeTab());
			Hoe[i] = new MetallurgyItemHoe(startID+5, info.image(), info.toolEnum(i)).setIconCoord(i,6).setItemName(info.name(i) + "Hoe").setCreativeTab(info.getCreativeTab());
			Sword[i] = new MetallurgyItemSword(startID+6, info.image(), info.toolEnum(i)).setIconCoord(i,9).setItemName(info.name(i) + "Sword").setCreativeTab(info.getCreativeTab());
			
			Helmet[i] = (new MetallurgyArmor(startID+7, info.image(), info.name(i).toLowerCase().replaceAll("\\W", "") + "_1", info.armorEnum(i), 0, 0)).setIconCoord(i,12).setItemName(info.name(i) + "Helmet").setCreativeTab(info.getCreativeTab());
			Plate[i] = (new MetallurgyArmor(startID+8, info.image(), info.name(i).toLowerCase().replaceAll("\\W", "") + "_1", info.armorEnum(i), 0, 1)).setIconCoord(i,13).setItemName(info.name(i) + "Plate").setCreativeTab(info.getCreativeTab());
			Legs[i] = (new MetallurgyArmor(startID+9, info.image(), info.name(i).toLowerCase().replaceAll("\\W", "") + "_2", info.armorEnum(i), 0, 2)).setIconCoord(i,14).setItemName(info.name(i) + "Legs").setCreativeTab(info.getCreativeTab());
			Boots[i] = (new MetallurgyArmor(startID+10, info.image(), info.name(i).toLowerCase().replaceAll("\\W", "") + "_1", info.armorEnum(i), 0, 3)).setIconCoord(i,15).setItemName(info.name(i) + "Boots").setCreativeTab(info.getCreativeTab());
		
			if(info.numRails(i) > 0)
				RecipeHelper.addRailsRecipe(Bar[i], info.numRails(i));
		}
		
		if(!info.isAlloy())			
			ore = new MetallurgyBlock(info.oreID(), info.image(), numMetals, 0).setHardness(2F).setResistance(.1F).setBlockName(setName + "Ore").setCreativeTab(info.getCreativeTab());
		
		brick = new MetallurgyBlock(info.brickID(), info.image(), numMetals, 1).setHardness(5F).setResistance(10F).setBlockName(setName + "Brick").setCreativeTab(info.getCreativeTab());
		
		if(info.hasMetalBlock())
		{
			block = new MetallurgyBlock(info.blockID(), info.image(), numMetals, 0).setHardness(5F).setResistance(.1F).setBlockName(setName + "Block").setCreativeTab(info.getCreativeTab());
			((MetallurgyBlock)block).isMetalBlock = true;
		}
		
		for(int i = 0; i < numMetals; i++)
		{
			
			if(!info.isAlloy())	
				MinecraftForge.setBlockHarvestLevel(ore, i, "pickaxe", info.oreHarvestLevel(i));

			if(info.hasMetalBlock())
				MinecraftForge.setBlockHarvestLevel(block, i, "pickaxe", info.oreHarvestLevel(i));
			
			MinecraftForge.setBlockHarvestLevel(brick, i, "pickaxe", info.oreHarvestLevel(i)); 
			
			if(!info.isCatalyst(i))
				MinecraftForge.setToolClass(Pickaxe[i], "pickaxe", info.pickLevel(i));
			
		}
		
		registerWithApi();
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	public void load()
	{
		
		if(ore != null)
		{
			GameRegistry.registerWorldGenerator(this);
			GameRegistry.registerBlock(ore, MetallurgyItemBlock.class);
		}
		
		if(block != null)
		{
			GameRegistry.registerBlock(block, MetallurgyItemBlock.class);
			for(int n = 0; n < info.numMetals(); n++)
			{
				ShapedOreRecipe recipe = new ShapedOreRecipe(new ItemStack(block, 1, n), "XXX", "XXX", "XXX", 'X', "ingot" + info.name(n));
				GameRegistry.addRecipe(recipe);
				GameRegistry.addRecipe(new ItemStack(Bar[n], 9), "X", 'X', new ItemStack(block, 1, n));
			}
		}

		GameRegistry.registerBlock(brick, MetallurgyItemBlock.class);
		

		for(int i = 0; i < info.numMetals(); i++)
		{
			GameRegistry.addSmelting(Dust[i].shiftedIndex, new ItemStack(Bar[i], 1), 1);
			
			if(ore != null)
			{
    			FurnaceRecipes.smelting().addSmelting(ore.blockID, i, new ItemStack(Bar[i], 1));
    			
    			// RAILCRAFT COMPATIBILITY
				try {
					Class a = Class.forName("railcraft.common.api.crafting.RailcraftCraftingManager");
					
					HashMap<ItemStack, Float> rockCrusherRecipe = new HashMap<ItemStack, Float>();
					rockCrusherRecipe.put(new ItemStack(Dust[i], 2), 1.0F);
					railcraft.common.api.crafting.RailcraftCraftingManager.rockCrusher.addRecipe(new ItemStack(ore, 1, i), rockCrusherRecipe);
				} catch(Exception e) {}

				// IC2 COMPATIBILITY
				try {
					Class a = Class.forName("ic2.api.Ic2Recipes");
					ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(ore, 1, i), new ItemStack(Dust[i], 2, 0));
				} catch(Exception e) {}
				
				
				// Thermal Expansion Compatibility
				try {
					Class a = Class.forName("thermalexpansion.api.crafting.CraftingManagers");
					thermalexpansion.api.crafting.CraftingManagers.pulverizerManager.addRecipe(400, new ItemStack(ore, 1, i), new ItemStack(Dust[i], 2, 0));
					thermalexpansion.api.crafting.CraftingManagers.smelterManager.addRecipe(320, new ItemStack(ore, 1, i), new ItemStack(Block.sand), new ItemStack(Bar[i], 2), thermalexpansion.api.core.ItemRegistry.getItem("slag", 1));
					thermalexpansion.api.crafting.CraftingManagers.smelterManager.addRecipe(80, new ItemStack(Dust[i], 2), new ItemStack(Block.sand), new ItemStack(Bar[i], 2), thermalexpansion.api.core.ItemRegistry.getItem("slag", 1));
				} catch(Exception e) {}
				
				DungeonHooks.addDungeonLoot(new ItemStack(Bar[i], 1), info.dungeonLootChance(i), 1, info.dungeonLootAmount(i));
			}

			try {
				Class a = Class.forName("ic2.api.Ic2Recipes");
				ic2.api.Ic2Recipes.addMaceratorRecipe(new ItemStack(Bar[i], 1, 0), new ItemStack(Dust[i], 1, 0));
			} catch(Exception e) {}
			
			
		}
	}
	
	public void registerWithApi()
	{
		for(int n = 0; n < numMetals; n++)
		{
			if(ore != null)
				MetallurgyItems.registerItem("ore" + info.name(n), new ItemStack(ore, 1, n));
			MetallurgyItems.registerItem("brick" + info.name(n), new ItemStack(brick, 1, n));
			if(block != null)
				MetallurgyItems.registerItem("block" + info.name(n), new ItemStack(block, 1, n));
			MetallurgyItems.registerItem("dust" + info.name(n), new ItemStack(Dust[n]));
			MetallurgyItems.registerItem("ingot" + info.name(n), new ItemStack(Bar[n]));
			
			if(info.isCatalyst(n))
				continue;
			
			MetallurgyItems.registerItem("sword" + info.name(n), new ItemStack(Sword[n]));
			MetallurgyItems.registerItem("pickaxe" + info.name(n), new ItemStack(Pickaxe[n]));
			MetallurgyItems.registerItem("axe" + info.name(n), new ItemStack(Axe[n]));
			MetallurgyItems.registerItem("shovel" + info.name(n), new ItemStack(Shovel[n]));
			MetallurgyItems.registerItem("hoe" + info.name(n), new ItemStack(Hoe[n]));
			
			MetallurgyItems.registerItem("helmet" + info.name(n), new ItemStack(Helmet[n]));
			MetallurgyItems.registerItem("plate" + info.name(n), new ItemStack(Plate[n]));
			MetallurgyItems.registerItem("legs" + info.name(n), new ItemStack(Legs[n]));
			MetallurgyItems.registerItem("boots" + info.name(n), new ItemStack(Boots[n]));
		}
	}
	

    @ForgeSubscribe
    public void oreRegistered(OreRegisterEvent event)
    {    		
    	for(int i = 0; i < info.numMetals(); i++)
    	{
    		if(event.Name.equals("ore" + info.name(i)))
    		{
    			//BC_CrusherRecipes.smelting().addCrushing(event.Ore.itemID, event.Ore.getItemDamage(), new ItemStack(Dust[i], 2));
    		}

    		if(event.Name.equals("ingot" + info.name(i)))
    		{
    			if(MetallurgyCore.hasFantasy)
    				FF_EssenceRecipes.essence().addEssenceAmount(event.Ore.itemID, info.expValue(i));

    			BC_CrusherRecipes.smelting().addCrushing(event.Ore.itemID, new ItemStack(Dust[i], 1));
    			
    			//Bricks!
    			RecipeHelper.addBrickRecipes(brick.blockID, i, event.Ore.getItem(), event.Ore.getItemDamage());
    			
    	        if(!info.isCatalyst(i))
    	        {
    				RecipeHelper.addAxeRecipe(Axe[i], event.Ore.getItem());
    				RecipeHelper.addPickaxeRecipe(Pickaxe[i], event.Ore.getItem());
    				RecipeHelper.addShovelRecipe(Shovel[i], event.Ore.getItem());
    				RecipeHelper.addHoeRecipe(Hoe[i], event.Ore.getItem());
    				RecipeHelper.addSwordRecipe(Sword[i], event.Ore.getItem());
    				RecipeHelper.addHelmetRecipe(Helmet[i], event.Ore.getItem());
    				RecipeHelper.addPlateRecipe(Plate[i], event.Ore.getItem());
    				RecipeHelper.addLegsRecipe(Legs[i], event.Ore.getItem());
    				RecipeHelper.addBootsRecipe(Boots[i], event.Ore.getItem());
    			    
    			    //Buckets/Shears
    				RecipeHelper.addBucketRecipe(event.Ore.getItem());
    				RecipeHelper.addShearsRecipe(event.Ore.getItem());
    	        }
    		}
    	}
    }
    
    public void registerOres()
    {

		for(int i = 0; i < info.numMetals(); i++)
		{
			if(ore != null)
				OreDictionary.registerOre("ore" + info.name(i), new ItemStack(ore, 1, i));
			if(block != null)
				OreDictionary.registerOre("block" + info.name(i), new ItemStack(block, 1, i));
			OreDictionary.registerOre("dust" + info.name(i), new ItemStack(Dust[i], 1));
			OreDictionary.registerOre("ingot" + info.name(i), new ItemStack(Bar[i], 1));
		}
    }
    
    
    
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		if(!info.spawnsInDimension(world.provider.dimensionId))
			return;
		
		generateAllOres(rand, chunkX, chunkZ, world);
	}
	
	public void generateAllOres(Random rand, int chunkX, int chunkZ, World world)
	{
		for(int i = 0; i < numMetals; i++)
			if(info.metalEnabled(i))
				generateOre(world, rand, chunkX * 16, chunkZ * 16, i);
	}

	public void generateOre(World world, Random rand, int chunkX, int chunkZ, int meta)
	{
		oreSpawnCount = 0;
		
		for(int i = 0; i < info.veinCount(meta); i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(info.oreHeight(meta) - info.oreMinHeight(meta)) + info.oreMinHeight(meta);
			int randPosZ = chunkZ + rand.nextInt(16);
			if(world.provider.isHellWorld)
				(new MetallurgyWorldGenNetherMinable(ore.blockID, meta, info.oreCount(meta))).generate(world, rand, randPosX, randPosY, randPosZ);
			else if(world.provider.dimensionId == 1)
				(new MetallurgyWorldGenEnderMinable(ore.blockID, meta, info.oreCount(meta))).generate(world, rand, randPosX, randPosY, randPosZ);
			else
			{
				(new WorldGenMinable(ore.blockID, meta, info.oreCount(meta))).generate(world, rand, randPosX, randPosY, randPosZ);
			}
		}
		
		//System.out.println("Spawned " + oreSpawnCount + " " + info.name(meta));
	}

}
