package shadow.mods.metallurgy.nether;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.MetallurgyWorldGenNetherMinable;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class ObsidianSpawns implements IWorldGenerator {

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		for(int i = 0; i < ConfigNether.ObsidianVeinCount; i++)
		{
			int randPosX = (chunkX * 16) + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigNether.ObsidianOreHeight);
			int randPosZ = (chunkZ * 16) + rand.nextInt(16);
			(new MetallurgyWorldGenNetherMinable(Block.obsidian.blockID, 0, ConfigNether.ObsidianOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

}
