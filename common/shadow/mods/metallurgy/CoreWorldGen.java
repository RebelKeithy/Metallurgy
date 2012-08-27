package shadow.mods.metallurgy;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.base.BaseConfig;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class CoreWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

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
	}

	public static void generateDiamond(World world, Random rand, int chunkX, int chunkZ) {
		for (int y = 15; y >= 0; y--) {
			for (int x = 0; x <= 15; x++) {
				for (int z = 0; z <= 15; z++) {
					if (world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreDiamond.blockID) {
						world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
					}
				}
			}
		}

		for (int i = 0; i < CoreConfig.DiamondVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.DiamondOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreDiamond.blockID, CoreConfig.DiamondOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateEmerald(World world, Random rand, int chunkX, int chunkZ) {
		for (int y = 15; y >= 0; y--) {
			for (int x = 0; x <= 15; x++) {
				for (int z = 0; z <= 15; z++) {
					if (world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreEmerald.blockID) {
						world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
					}
				}
			}
		}

		for (int i = 0; i < CoreConfig.EmeraldVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.EmeraldOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreEmerald.blockID, CoreConfig.EmeraldOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateLapisLazuli(World world, Random rand, int chunkX, int chunkZ) {
		for (int y = 32; y >= 0; y--) {
			for (int x = 0; x <= 15; x++) {
				for (int z = 0; z <= 15; z++) {
					if (world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreLapis.blockID) {
						world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
					}
				}
			}
		}

		for (int i = 0; i < CoreConfig.LapisLazuliVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.LapisLazuliOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreLapis.blockID, CoreConfig.LapisLazuliOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateRedstone(World world, Random rand, int chunkX, int chunkZ) {
		for (int y = 16; y >= 0; y--) {
			for (int x = 0; x <= 15; x++) {
				for (int z = 0; z <= 15; z++) {
					if (world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreRedstone.blockID) {
						world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
					}
				}
			}
		}

		for (int i = 0; i < CoreConfig.RedstoneVeinCount; i++) {
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.RedstoneOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(Block.oreRedstone.blockID, CoreConfig.RedstoneOreCount))
					.generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateGold(World world, Random rand, int chunkX, int chunkZ)
	{		
		for(int y = 128; y >= 0; y--)
		{
		        for(int x = 0; x <= 15; x++)
		        {
		                for(int z = 0; z <= 15; z++)
		                {
		                        if(world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreGold.blockID)
		                        {
		                                world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
		                        }
		                }
		        }
		}
		
		for(int i = 0; i < CoreConfig.GoldVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(CoreConfig.GoldOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(Block.oreGold.blockID, 4, CoreConfig.GoldOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

}
