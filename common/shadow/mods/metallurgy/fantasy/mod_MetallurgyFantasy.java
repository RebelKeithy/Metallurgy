package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.base.BaseWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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

@Mod(modid = "MetallurgyFantasy", name = "Metallurgy Fantasy", version = "1.3")
@NetworkMod(channels = { "MetallurgyFantas" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyFantasy
{

	@SidedProxy(clientSide = "shadow.mods.metallurgy.fantasy.ClientProxy", serverSide = "shadow.mods.metallurgy.fantasy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyFantasy instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;
	
	public mod_MetallurgyFantasy()
	{
		instance = this;
	}
	
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
		proxy.addArmor();
		
		alloys.load();
		ores.load();
		
		mod_FantasyFurnace.load();
		
		FF_EssenceRecipes.essence().addEssenceAmount(Block.oreGold.blockID, 10);
	}
}
