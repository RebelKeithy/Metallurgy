package shadow.mods.metallurgy.nether;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.base.BaseWorldGen;

import cpw.mods.fml.common.IFuelHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyNether", name = "Metallurgy Nether", version = "1.3")
@NetworkMod(channels = { "MetallurgyNether" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyNether
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.nether.ClientProxy", serverSide = "shadow.mods.metallurgy.nether.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyNether instance;
	
	public static Block NetherMetalsVein;
	public static Block NetherMetalsBrick;
	public static Block NetherAlloysBrick;
	
	
	public mod_MetallurgyNether()
	{
		instance = this;
	}

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		NetherConfig.init();

		NetherMetalsVein = new BlockNetherMetalsVein(NetherConfig.NetherMetalsVeinID, "/shadow/MetallurgyNetherMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("NetherMetalsVein");
		NetherMetalsBrick = new BlockNetherMetalsBrick(NetherConfig.NetherMetalsBrickID, "/shadow/MetallurgyNetherMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("NetherMetalsBrick");
		NetherAlloysBrick = new BlockNetherAlloysBrick(NetherConfig.NetherAlloysBrickID, "/shadow/MetallurgyNetherAlloys.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("NetherAlloysBrick");
		mod_NetherForge.init();
		AlloyNether.init();
		OreNether.init();
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(NetherMetalsVein, BlockNetherMetalsVeinItem.class);
		GameRegistry.registerBlock(NetherMetalsBrick, BlockNetherMetalsBrickItem.class);
		GameRegistry.registerBlock(NetherAlloysBrick, BlockNetherAlloysBrickItem.class);
		GameRegistry.registerBlock(mod_NetherForge.metalFurnace, NF_BlockNetherForgeItem.class);
		
		GameRegistry.registerTileEntity(NF_TileEntityNetherForge.class, "netherFurnace");
		
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 0, "pickaxe", 4); //Ignatius
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 0, "pickaxe", 4); //Ignatius
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 1, "pickaxe", 5); //Shadow Iron
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 1, "pickaxe", 5); //Shadow Iron
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 2, "pickaxe", 7); //Midasium
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 2, "pickaxe", 7); //Midasium
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 3, "pickaxe", 8); //Vyroxeres
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 3, "pickaxe", 8); //Vyroxeres
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 4, "pickaxe", 9); //Ceruclase
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 4, "pickaxe", 9); //Ceruclase
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 5, "pickaxe", 11); //Kalendrite
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 5, "pickaxe", 11); //Kalendrite
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 6, "pickaxe", 12); //Vulcanite
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 6, "pickaxe", 12); //Vulcanite
		MinecraftForge.setBlockHarvestLevel(NetherMetalsVein, 7, "pickaxe", 13); //Sanguinite
		MinecraftForge.setBlockHarvestLevel(NetherMetalsBrick, 7, "pickaxe", 13); //Sanguinite
		
		MinecraftForge.setBlockHarvestLevel(NetherAlloysBrick, 0, "pickaxe", 6); //Shadow Steel
		MinecraftForge.setBlockHarvestLevel(NetherAlloysBrick, 1, "pickaxe", 11); //Inolashite
		MinecraftForge.setBlockHarvestLevel(NetherAlloysBrick, 2, "pickaxe", 12); //Amordrine
	
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		GameRegistry.registerWorldGenerator(new NetherWorldGen());
		proxy.registerRenderInformation();
		proxy.addNames();
		proxy.addArmor();
		
		OreNether.load();
		AlloyNether.load();
		
		mod_NetherForge.load();
		
		GameRegistry.registerFuelHandler((IFuelHandler) OreNether.Dust[0]);
		GameRegistry.registerFuelHandler((IFuelHandler) OreNether.Dust[6]);
	}
	
	public void setToolClass()
	{
		MinecraftForge.setToolClass(AlloyNether.Pickaxe[2], "pickaxe", 12);
		MinecraftForge.setToolClass(AlloyNether.Pickaxe[1], "pickaxe", 11);
		MinecraftForge.setToolClass(AlloyNether.Pickaxe[0], "pickaxe", 7);
		MinecraftForge.setToolClass(OreNether.Pickaxe[0], "pickaxe", 5);
		MinecraftForge.setToolClass(OreNether.Pickaxe[1], "pickaxe", 6);
		MinecraftForge.setToolClass(OreNether.Pickaxe[2], "pickaxe", 8);
		MinecraftForge.setToolClass(OreNether.Pickaxe[3], "pickaxe", 9);
		MinecraftForge.setToolClass(OreNether.Pickaxe[4], "pickaxe", 10);
		MinecraftForge.setToolClass(OreNether.Pickaxe[5], "pickaxe", 12);
		MinecraftForge.setToolClass(OreNether.Pickaxe[6], "pickaxe", 13);
		MinecraftForge.setToolClass(OreNether.Pickaxe[7], "pickaxe", 14);
	}
	
	public void registerOres()
	{
		for(int i = 0; i < AlloyNether.numAlloys; i++)
		{
			OreDictionary.registerOre("dust" + AlloyNether.name[i], new ItemStack(AlloyNether.Dust, 1, i));
			OreDictionary.registerOre("ingot" + AlloyNether.name[i], new ItemStack(AlloyNether.Bar, 1, i));
		}

		for(int i = 0; i < OreNether.numMetals; i++)
		{
			OreDictionary.registerOre("dust" + OreNether.name[i], new ItemStack(OreNether.Dust[i], 1));
			OreDictionary.registerOre("ingot" + OreNether.name[i], new ItemStack(OreNether.Bar[i], 1));
		}
	}
}