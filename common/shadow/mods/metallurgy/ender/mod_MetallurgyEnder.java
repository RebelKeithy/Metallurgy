package shadow.mods.metallurgy.ender;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.RecipeHelper;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyEnder", name = "Metallurgy Ender", dependencies = "after:MetallurgyCore", version = "2.0.6")
@NetworkMod(channels = { "MetallurgyNether" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyEnder
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.ender.ClientProxy", serverSide = "shadow.mods.metallurgy.ender.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyEnder" )
	public static mod_MetallurgyEnder instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;	
	

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigEnder.init();

		alloys = new MetalSet(new AlloyEnderEnum());
		ores = new MetalSet(new OreEnderEnum());
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.registerRenderInformation();
		proxy.addNames();

		ores.load();
		alloys.load();
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();
		
		if(ConfigEnder.alloyEnabled[0])
			RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustEximite", "dustMeutoite");
	}
}