package shadow.mods.metallurgy.base;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class BaseWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		
		if(BaseConfig.copperEnabled)
			generateCopper(world, rand, chunkX * 16, chunkZ * 16);
		if(BaseConfig.goldEnabled)
			generateGold(world, rand, chunkX * 16, chunkZ * 16);
		if(BaseConfig.ironEnabled)
			generateIron(world, rand, chunkX * 16, chunkZ * 16);
		if(BaseConfig.manganeseEnabled)
			generateManganese(world, rand, chunkX * 16, chunkZ * 16);
		if(BaseConfig.tinEnabled)
			generateTin(world, rand, chunkX * 16, chunkZ * 16);
	}

	public static void generateCopper(World world, Random rand, int chunkX, int chunkZ)
	{
		if(BaseConfig.copperEnabled)
		for(int i = 0; i < BaseConfig.CopperVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(BaseConfig.CopperOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, 0, BaseConfig.CopperOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
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
		
		for(int i = 0; i < BaseConfig.GoldVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(BaseConfig.GoldOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, 4, BaseConfig.GoldOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateIron(World world, Random rand, int chunkX, int chunkZ)
	{		
		for(int y = 128; y >= 0; y--)
		{
		        for(int x = 0; x <= 15; x++)
		        {
		                for(int z = 0; z <= 15; z++)
		                {
		                        if(world.getBlockId(chunkX + x, y, chunkZ + z) == Block.oreIron.blockID)
		                        {
		                                world.setBlockWithNotify(chunkX + x, y, chunkZ + z, 1);
		                        }
		                }
		        }
		}
		
		for(int i = 0; i < BaseConfig.IronVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(BaseConfig.IronOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, 2, BaseConfig.IronOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateManganese(World world, Random rand, int chunkX, int chunkZ)
	{			
			for(int i = 0; i < BaseConfig.ManganeseVeinCount; i++)
			{
				int randPosX = chunkX + rand.nextInt(16);
				int randPosY = rand.nextInt(BaseConfig.ManganeseOreHeight);
				int randPosZ = chunkZ + rand.nextInt(16);
				(new MetallurgyWorldGenMinable(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, 3, BaseConfig.ManganeseOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
			}
	}

	public static void generateTin(World world, Random rand, int chunkX, int chunkZ)
	{				
		for(int i = 0; i < BaseConfig.TinVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(BaseConfig.TinOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyBaseMetals.BaseMetalsVein.blockID, 1, BaseConfig.TinOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
