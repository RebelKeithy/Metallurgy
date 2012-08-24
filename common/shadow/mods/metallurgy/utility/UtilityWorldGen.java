package shadow.mods.metallurgy.utility;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class UtilityWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		if(UtilityConfig.bitumenEnabled)
			generateBitumen(world, rand, chunkX * 16, chunkZ * 16);
		if(UtilityConfig.magnesiumEnabled)
			generateMagnesium(world, rand, chunkX * 16, chunkZ * 16);
		if(UtilityConfig.phosphoriteEnabled)
			generatePhosphorite(world, rand, chunkX * 16, chunkZ * 16);
		if(UtilityConfig.potashEnabled)
			generatePostash(world, rand, chunkX * 16, chunkZ * 16);
		if(UtilityConfig.saltpeterEnabled)
			generateSaltpeter(world, rand, chunkX * 16, chunkZ * 16);
		if(UtilityConfig.sulfurEnabled)
			generateSulfur(world, rand, chunkX * 16, chunkZ * 16);

	}
	
	public static void generateBitumen(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.BitumenVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.BitumenOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Bitumen.meta, UtilityConfig.BitumenOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}


	public static void generateMagnesium(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.MagnesiumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.MagnesiumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Magnesium.meta, UtilityConfig.MagnesiumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generatePhosphorite(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.PhosphoriteVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.PhosphoriteOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Phosphorite.meta, UtilityConfig.PhosphoriteOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generatePostash(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.PotashVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.PotashOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Potash.meta, UtilityConfig.PotashOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSaltpeter(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.SaltpeterVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.SaltpeterOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Saltpeter.meta, UtilityConfig.SaltpeterOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSulfur(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < UtilityConfig.SulfurVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(UtilityConfig.SulfurOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Sulfur.meta, UtilityConfig.SulfurOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
