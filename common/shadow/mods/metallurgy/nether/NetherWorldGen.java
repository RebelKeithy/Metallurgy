package shadow.mods.metallurgy.nether;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.MetallurgyWorldGenNetherMinable;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class NetherWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		for(int i = 0; i < 8; i++)
			if(NetherConfig.metalEnabled[i])
				generateOre(world, rand, chunkX * 16, chunkZ * 16, i);
	}

	public static void generateOre(World world, Random rand, int chunkX, int chunkZ, int meta)
	{
		for(int i = 0; i < NetherConfig.VeinCount[meta]; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(NetherConfig.OreHeight[meta]);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenNetherMinable(mod_MetallurgyNether.NetherMetalsVein.blockID, meta, NetherConfig.OreCount[meta])).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public void generateObsidian(World world, Random rand, int chunkX, int chunkZ)
	{				
		for(int i = 0; i < NetherConfig.ObsidianVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(NetherConfig.ObsidianOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenNetherMinable(Block.obsidian.blockID, 0, NetherConfig.ObsidianOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
