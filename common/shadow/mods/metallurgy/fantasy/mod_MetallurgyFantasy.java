package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.ender.EnderConfig;
import shadow.mods.metallurgy.precious.mod_MetallurgyPrecious;

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

@Mod(modid = "MetallurgyFantasy", name = "Metallurgy Fantasy", dependencies = "after:MetallurgyCore", version = "2.0.2")
@NetworkMod(channels = { "MetallurgyFantas" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyFantasy
{

	@SidedProxy(clientSide = "shadow.mods.metallurgy.fantasy.ClientProxy", serverSide = "shadow.mods.metallurgy.fantasy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyFantasy" )
	public static mod_MetallurgyFantasy instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		FantasyConfig.init();

		alloys = new MetalSet(new AlloyFantasyEnum());
		ores = new MetalSet(new OreFantasyEnum());
		
		proxy.registerRenderInformation();
		
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		proxy.registerRenderInformation();
		proxy.addNames();
		
		alloys.load();
		ores.load();
		
		mod_FantasyFurnace.load();
		
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), new Object[] {ores.Dust[1], ores.Dust[2]});
		if(mod_MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), new Object[] {ores.Dust[7], new ItemStack(mod_MetallurgyPrecious.ores.Dust[1], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new Object[] {ores.Dust[7], ores.Dust[8]});
		if(mod_MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[3], 1), new Object[] {ores.Dust[9], new ItemStack(mod_MetallurgyPrecious.ores.Dust[2], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[4], 1), new Object[] {ores.Dust[10], ores.Dust[11]});
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustDeep Iron", "dustInfuscolium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustMithril", "dustSilver");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "dustMithril", "dustRubracium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "dustOrichalcum", "dustPlatinum");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "dustAdamantine", "dustAtlarus");
	}
}
