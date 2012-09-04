package shadow.mods.metallurgy.precious;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;

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
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyPrecious", name = "Metallurgy Precious", dependencies = "after:MetallurgyCore", version = "2.0.2")
@NetworkMod(channels = { "MetallurgyPrecio" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyPrecious
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.precious.ClientProxy", serverSide = "shadow.mods.metallurgy.precious.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyPrecious" )
	public static mod_MetallurgyPrecious instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;
	
	public static Block PreciousMetalsVein;
	public static Block PreciousMetalsBrick;
	
	public static Block PreciousChest;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigPrecious.init();
		alloys = new MetalSet(new AlloyPreciousEnum());
		ores = new MetalSet(new OrePreciousEnum());
		
		PreciousChest = new FC_BlockChest(913).setHardness(0.5F).setResistance(.1F).setBlockName("PreciousChest");
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(PreciousChest, FC_ChestItemBlock.class);
		GameRegistry.registerTileEntity(FC_TileEntityChest.class, "PreciousChest");
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		//AlloyPrecious.load();
		alloys.load();
		ores.load();
		
		
		proxy.addNames();
		proxy.registerTileEntitySpecialRenderer();
		proxy.registerRenderInformation();
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustZinc", "dustCopper");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustGold", "dustSilver");
		addChestRecipes();
	}
	
	public void addChestRecipes()
	{

    	for(ItemStack brass : OreDictionary.getOres("ingotBrass"))
			ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 0), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), brass, Character.valueOf('F'), Block.chest
			});

    	for(ItemStack silver : OreDictionary.getOres("ingotSilver"))
			ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 1), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), silver, Character.valueOf('F'), new ItemStack(PreciousChest, 1, 0)
			});

		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotGold, Character.valueOf('F'), new ItemStack(PreciousChest, 1, 1)
		});

    	for(ItemStack electrum: OreDictionary.getOres("ingotElectrum"))
			ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 3), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), electrum, Character.valueOf('F'), new ItemStack(PreciousChest, 1, 2)
			});

    	for(ItemStack platinum: OreDictionary.getOres("ingotPlatinum"))
			ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 4), new Object[] {
				"XXX", "XFX", "XXX", Character.valueOf('X'), platinum, Character.valueOf('F'), new ItemStack(PreciousChest, 1, 3)
			});
	}
}