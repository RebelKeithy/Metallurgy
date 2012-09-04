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

		if(world.provider.worldType != ConfigUtility.dimensionID)
			return;
		
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
	
	public static void generateBitumen(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.BitumenVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.BitumenOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Bitumen.meta, ConfigUtility.BitumenOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}


	public static void generateMagnesium(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.MagnesiumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.MagnesiumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Magnesium.meta, ConfigUtility.MagnesiumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generatePhosphorite(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.PhosphoriteVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.PhosphoriteOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Phosphorite.meta, ConfigUtility.PhosphoriteOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generatePostash(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.PotashVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.PotashOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Potash.meta, ConfigUtility.PotashOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSaltpeter(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.SaltpeterVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.SaltpeterOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Saltpeter.meta, ConfigUtility.SaltpeterOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateSulfur(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < ConfigUtility.SulfurVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(ConfigUtility.SulfurOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyUtility.vein.blockID, mod_Sulfur.meta, ConfigUtility.SulfurOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
}
