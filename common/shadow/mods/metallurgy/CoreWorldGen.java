package shadow.mods.metallurgy;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.base.ConfigBase;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CoreWorldGen implements IWorldGenerator
{
	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		
		replaceOre(world, rand, chunkX * 16, chunkZ * 16);
		
		if(CoreConfig.DiamondEnabled)
			generateDiamond(world, rand, chunkX * 16, chunkZ * 16);
		if(CoreConfig.EmeraldEnabled)
			generateEmerald(world, rand, chunkX * 16, chunkZ * 16);
		if(CoreConfig.LapisLazuliEnabled)
			generateLapisLazuli(world, rand, chunkX * 16, chunkZ * 16);
		if(CoreConfig.RedstoneEnabled)
			generateRedstone(world, rand, chunkX * 16, chunkZ * 16);
		if(CoreConfig.goldEnabled)
			generateGold(world, rand, chunkX * 16, chunkZ * 16);
		if(CoreConfig.ironEnabled)
			generateIron(world, rand, chunkX * 16, chunkZ * 16);
		
		for(int n = 0; n < CoreConfig.customIDs.length; n++)
		{
			if(Block.blocksList[n] == null)
				continue;
			if(!spawnsInDimension(CoreConfig.customDimensions[n], world.provider.dimensionId))
				continue;
			for (int i = 0; i < CoreConfig.customVeinCount[n]; i++) {
				int randPosX = chunkX * 16 + rand.nextInt(16);
				int randPosY = rand.nextInt(CoreConfig.customMaxHeight[n] - CoreConfig.customMinHeight[n]) + CoreConfig.customMinHeight[n];
				int randPosZ = chunkZ * 16 + rand.nextInt(16);
				if(world.provider.dimensionId == -1)
					(new MetallurgyWorldGenNetherMinable(CoreConfig.customIDs[n], CoreConfig.customMetas[n], CoreConfig.customOreCount[n])).generate(world, rand, randPosX, randPosY, randPosZ);
				else if(world.provider.dimensionId == 1)
					(new MetallurgyWorldGenEnderMinable(CoreConfig.customIDs[n], CoreConfig.customMetas[n], CoreConfig.customOreCount[n])).generate(world, rand, randPosX, randPosY, randPosZ);
				else
					(new MetallurgyWorldGenMinable(CoreConfig.customIDs[n], CoreConfig.customMetas[n], CoreConfig.customOreCount[n])).generate(world, rand, randPosX, randPosY, randPosZ);
			}
		}
	}

	public boolean spawnsInDimension(String dimConfig, int i)
	{
		for(String str : dimConfig.split(" ")) {
			if(str.matches("[0-9]+-[0-9]+"))
			{
				int start = Integer.parseInt(str.split("-")[0]);
				int end = Integer.parseInt(str.split("-")[1]);
				if(i >= start && i <= end)
					return true;
			} else {
				if(i == Integer.parseInt(str))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean shouldReplace(int blockID)
	{

		if(blockID == Block.oreDiamond.blockID && CoreConfig.DiamondEnabled)
			return true;
		if(blockID == Block.oreEmerald.blockID && CoreConfig.EmeraldEnabled)
			return true;
		if(blockID == Block.oreLapis.blockID && CoreConfig.LapisLazuliEnabled)
			return true;
		if(blockID == Block.oreRedstone.blockID && CoreConfig.RedstoneEnabled)
			return true;
		if(blockID == Block.oreGold.blockID && CoreConfig.goldEnabled)
			return true;
		if(blockID == Block.oreIron.blockID && CoreConfig.ironEnabled)
			return true;
		
		return false;
	}

	public void replaceOre(World world, Random rand, int chunkX, int chunkZ) {
		for (int y = 64; y >= 1; y--) {
			for (int x = 0; x <= 15; x++) {
				for (int z = 0; z <= 15; z++) {
					if (shouldReplace(world.getBlockId(chunkX + x, y, chunkZ + z))) {
						world.setBlockAndMetadata(chunkX + x, y, chunkZ + z, 1, 0);
					}
				}
			}
		}
	}
	
	public void generateDiamond(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < CoreConfig.DiamondVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.DiamondOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreDiamond.blockID, CoreConfig.DiamondOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public void generateEmerald(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < CoreConfig.EmeraldVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.EmeraldOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreEmerald.blockID, CoreConfig.EmeraldOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public void generateLapisLazuli(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < CoreConfig.LapisLazuliVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.LapisLazuliOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreLapis.blockID, CoreConfig.LapisLazuliOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public void generateRedstone(World world, Random rand, int chunkX, int chunkZ) {
		for (int i = 0; i < CoreConfig.RedstoneVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.RedstoneOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreRedstone.blockID, CoreConfig.RedstoneOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public void generateIron(World world, Random rand, int chunkX, int chunkZ) {				
		for(int i = 0; i < CoreConfig.IronVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.IronOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(Block.oreIron.blockID, 0, CoreConfig.IronOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public void generateGold(World world, Random rand, int chunkX, int chunkZ) {		
		for(int i = 0; i < CoreConfig.GoldVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.GoldOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(Block.oreGold.blockID, 0, CoreConfig.GoldOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
