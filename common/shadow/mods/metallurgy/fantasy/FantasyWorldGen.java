package shadow.mods.metallurgy.fantasy;

import java.util.Random;

import shadow.mods.metallurgy.MetallurgyWorldGenMinable;

import net.minecraft.src.Block;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import cpw.mods.fml.common.IWorldGenerator;

public class FantasyWorldGen implements IWorldGenerator
{

	@Override
	public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {

		if(FantasyConfig.adamantineEnabled)
			generateAdamantine(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.aredriteEnabled)
			generateAredrite(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.astralSilverEnabled)
			generateAstralSilver(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.atlarusEnabled)
			generateAtlarus(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.carmotEnabled)
			generateCarmot(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.deepIronEnabled)
			generateDeepIron(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.infuscoliumEnabled)
			generateInfuscolium(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.mithrilEnabled)
			generateMithril(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.orichalcumEnabled)
			generateOrichalcum(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.oureclaseEnabled)
			generateOureclase(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.prometheumEnabled)
			generatePrometheum(world, rand, chunkX * 16, chunkZ * 16);
		if(FantasyConfig.rubraciumEnabled)
			generateRubracium(world, rand, chunkX * 16, chunkZ * 16);

	}

	public static void generateAdamantine(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.AdamantineVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.AdamantineOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreAdamantine.meta, FantasyConfig.AdamantineOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateAredrite(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.AredriteVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.AredriteOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreAredrite.meta, FantasyConfig.AredriteOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateAstralSilver(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.AstralSilverVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.AstralSilverOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreAstralSilver.meta, FantasyConfig.AstralSilverOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateAtlarus(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.AtlarusVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.AtlarusOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreAtlarus.meta, FantasyConfig.AtlarusOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateCarmot(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.CarmotVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.CarmotOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreCarmot.meta, FantasyConfig.CarmotOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

	public static void generateDeepIron(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.DeepIronVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.DeepIronOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreDeepIron.meta, FantasyConfig.DeepIronOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateInfuscolium(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.InfuscoliumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.InfuscoliumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreInfuscolium.meta, FantasyConfig.InfuscoliumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateMithril(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.MithrilVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.MithrilOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreMithril.meta, FantasyConfig.MithrilOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateOrichalcum(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.OrichalcumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.OrichalcumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreOrichalcum.meta, FantasyConfig.OrichalcumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateOureclase(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.OureclaseVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.OureclaseOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreOureclase.meta, FantasyConfig.OureclaseOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generatePrometheum(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.PrometheumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.PrometheumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OrePrometheum.meta, FantasyConfig.PrometheumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}
	
	public static void generateRubracium(World world, Random rand, int chunkX, int chunkZ){
		for(int i = 0; i < FantasyConfig.RubraciumVeinCount; i++)
		{
			int randPosX = chunkX + rand.nextInt(16);
			int randPosY = rand.nextInt(FantasyConfig.RubraciumOreHeight);
			int randPosZ = chunkZ + rand.nextInt(16);
			(new MetallurgyWorldGenMinable(mod_MetallurgyFantasy.vein.blockID, OreRubracium.meta, FantasyConfig.RubraciumOreCount)).generate(world, rand, randPosX, randPosY, randPosZ);
		}
	}

}
