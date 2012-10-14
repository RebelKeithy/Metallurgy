package shadow.mods.metallurgy.utility;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;
import shadow.mods.metallurgy.base.ConfigBase;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class UtilityWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		if(!spawnsInDim(world.provider.dimensionId))
			return;
		
		generateAllOres(rand, chunkX, chunkZ, world);
	}
	
	public static void generateAllOres(Random rand, int chunkX, int chunkZ, World world)
	{
		if(ConfigUtility.bitumenEnabled)
			generateBitumen(world, rand, chunkX * 16, chunkZ * 16);
		if(ConfigUtility.magnesiumEnabled)
			generateMagnesium(world, rand, chunkX * 16, chunkZ * 16);
		if(ConfigUtility.phosphoriteEnabled)
			generatePhosphorite(world, rand, chunkX * 16, chunkZ * 16);
		if(ConfigUtility.potashEnabled)
			generatePostash(world, rand, chunkX * 16, chunkZ * 16);
		if(ConfigUtility.saltpeterEnabled)
			generateSaltpeter(world, rand, chunkX * 16, chunkZ * 16);
		if(ConfigUtility.sulfurEnabled)
			generateSulfur(world, rand, chunkX * 16, chunkZ * 16);
		
	}
	
	public boolean spawnsInDim(int id)
	{
		for(String str : ConfigUtility.dimensions.split(" ")) {
			if(str.matches("[0-9]+-[0-9]+"))
			{
				int start = Integer.parseInt(str.split("-")[0]);
				int end = Integer.parseInt(str.split("-")[1]);
				if(id >= start && id <= end)
					return true;
			} else {
				if(id == Integer.parseInt(str))
					return true;
			}
		}
		
		return false;
	}
	
	public static void generateBitumen(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.BitumenVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.BitumenOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 4, ConfigUtility.BitumenOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}


	public static void generateMagnesium(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.MagnesiumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.MagnesiumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 3, ConfigUtility.MagnesiumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generatePhosphorite(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.PhosphoriteVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.PhosphoriteOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 0, ConfigUtility.PhosphoriteOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generatePostash(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.PotashVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.PotashOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 5, ConfigUtility.PotashOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSaltpeter(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.SaltpeterVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.SaltpeterOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 2, ConfigUtility.SaltpeterOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSulfur(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.SulfurVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.SulfurOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(MetallurgyUtility.vein.blockID, 1, ConfigUtility.SulfurOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
