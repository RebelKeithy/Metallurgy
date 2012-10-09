package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyBlock;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.ender.ConfigEnder;
import shadow.mods.metallurgy.nether.VyroxeresDisplay;
import shadow.mods.metallurgy.precious.MetallurgyPrecious;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyFantasy", name = "Metallurgy Fantasy", dependencies = "after:MetallurgyCore", version = "2.1.0.2")
@NetworkMod(channels = { "MetallurgyFantas" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyFantasy
{

	@SidedProxy(clientSide = "shadow.mods.metallurgy.fantasy.ClientProxy", serverSide = "shadow.mods.metallurgy.fantasy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyFantasy" )
	public static MetallurgyFantasy instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigFantasy.init();

		alloys = new MetalSet(new AlloyFantasyEnum());
		ores = new MetalSet(new OreFantasyEnum());
		
		proxy.registerRenderInformation();
		registerWithApi();
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		proxy.registerRenderInformation();
		proxy.addNames();
		
		alloys.load();
		ores.load();
		
		FantasyFurnace.load();

		((MetallurgyBlock)(ores.ore)).addDisplayListener(new OreParticleSpawner());

		ModLoader.addShapelessRecipe(new ItemStack(mod_Iron.IronDust, 1), ores.Dust[0], ores.Dust[1]);
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), new Object[] {ores.Dust[1], ores.Dust[2]});
		if(MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), new Object[] {ores.Dust[7], new ItemStack(MetallurgyPrecious.ores.Dust[1], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new Object[] {ores.Dust[7], ores.Dust[8]});
		if(MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[3], 1), new Object[] {ores.Dust[9], new ItemStack(MetallurgyPrecious.ores.Dust[2], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[4], 1), new Object[] {ores.Dust[10], ores.Dust[11]});
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();
		
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "itemDustDeep Iron", "itemDustInfuscolium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "itemDustMithril", "itemDustSilver");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "itemDustMithril", "itemDustRubracium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "itemDustOrichalcum", "itemDustPlatinum");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "itemDustAdamantine", "itemDustAtlarus");
	}
	
	public void registerWithApi()
	{
		MetallurgyItems.registerItem("prometheumAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 0));
		MetallurgyItems.registerItem("deepIronAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 1));
		MetallurgyItems.registerItem("blackSteelAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 2));
		MetallurgyItems.registerItem("oureclaseAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 3));
		MetallurgyItems.registerItem("aredriteAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 4));
		MetallurgyItems.registerItem("mithrilAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 5));
		MetallurgyItems.registerItem("haderothAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 6));
		MetallurgyItems.registerItem("orichalcumAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 7));
		MetallurgyItems.registerItem("adamantineAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 8));
		MetallurgyItems.registerItem("atlarusAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 9));
		MetallurgyItems.registerItem("tartariteAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 10));
	}
}
