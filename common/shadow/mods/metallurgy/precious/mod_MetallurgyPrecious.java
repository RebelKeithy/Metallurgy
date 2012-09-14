package shadow.mods.metallurgy.precious;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.mod_MetallurgyFantasy;
import shadow.mods.metallurgy.nether.mod_MetallurgyNether;

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
import cpw.mods.fml.common.registry.VillagerRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityVillager;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyPrecious", name = "Metallurgy Precious", dependencies = "after:MetallurgyCore", version = "2.0.6")
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
	public static Block Mint;
	public static Block MintStorage;
	
	public static Item Coin;
	public static Item GoldCog;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigPrecious.init();
		alloys = new MetalSet(new AlloyPreciousEnum());
		ores = new MetalSet(new OrePreciousEnum());
		
		PreciousChest = new FC_BlockChest(ConfigPrecious.PreciousChestID).setHardness(0.5F).setResistance(.1F).setBlockName("PreciousChest");
		Mint = new FM_BlockMint(ConfigPrecious.PreciousMintID).setHardness(0.5F).setResistance(.1F).setBlockName("Mint");
		MintStorage = new FM_BlockMintStorage(ConfigPrecious.PreciousMintLoaderID).setHardness(0.5F).setResistance(.1F).setBlockName("MintStorage");
		Coin = new ItemCoins(ConfigPrecious.ItemStartID + 748).setItemName("Coin").setTabToDisplayOn(CreativeTabs.tabMisc);
		GoldCog = new MetallurgyItem(ConfigPrecious.ItemStartID + 749, "/shadow/MetallurgyCoins.png").setIconIndex(2).setItemName("GoldCog").setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(PreciousChest, FC_ChestItemBlock.class);
		GameRegistry.registerTileEntity(FC_TileEntityChest.class, "PreciousChest");
		GameRegistry.registerBlock(Mint);
		GameRegistry.registerTileEntity(FM_TileEntityMint.class, "Mint");
		GameRegistry.registerBlock(MintStorage);
		GameRegistry.registerTileEntity(FM_TileEntityMintStorage.class, "MintStorage");
		
		for(int i = 0; i < 5; i++)
			VillagerRegistry.instance().registerVillageTradeHandler(i, new PreciousTradeHandler());
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		alloys.load();
		ores.load();
		
		proxy.addNames();
		proxy.registerTileEntitySpecialRenderer();
		proxy.registerRenderInformation();
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();

		ModLoader.addRecipe(new ItemStack(GoldCog, 1), new Object[] {
			" G ", "GIG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('I'), Item.ingotIron
		});
		ModLoader.addRecipe(new ItemStack(MintStorage, 1), new Object[] {
			"GBG", "PCP", "GBG", Character.valueOf('G'), GoldCog, Character.valueOf('C'), Block.chest, Character.valueOf('B'), Item.ingotIron, Character.valueOf('P'), Block.pistonBase
		});
		ModLoader.addRecipe(new ItemStack(Mint, 1), new Object[] {
			"III", "SRS", "IPI", Character.valueOf('G'), GoldCog, Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.pistonBase, Character.valueOf('R'), Item.redstone
		});
		
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustZinc", "dustCopper");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustGold", "dustSilver");
		RecipeHelper.addStorageRecipe(new ItemStack(Coin, 1, 1), new ItemStack(Coin, 1, 0));
		RecipeHelper.addStorageRecipe(new ItemStack(Coin, 1, 2), new ItemStack(Coin, 1, 1));
		RecipeHelper.addStorageRecipe(new ItemStack(Coin, 1, 3), new ItemStack(Coin, 1, 2));
		addChestRecipes();
		
		FM_MintRecipes.minting().addMinting(ores.Bar[1].shiftedIndex, 0, 3);
		FM_MintRecipes.minting().addMinting(ores.Bar[2].shiftedIndex, 0, 27);
		FM_MintRecipes.minting().addMinting(alloys.Bar[0].shiftedIndex, 0, 1);
		FM_MintRecipes.minting().addMinting(alloys.Bar[1].shiftedIndex, 0, 13);
		FM_MintRecipes.minting().addMinting(Item.ingotGold.shiftedIndex, 0, 9);
		
		if(mod_MetallurgyCore.hasBase)
		{
			FM_MintRecipes.minting().addMinting(mod_MetallurgyBaseMetals.alloys.Bar[1].shiftedIndex, 0, 10);
			FM_MintRecipes.minting().addMinting(mod_MetallurgyBaseMetals.alloys.Bar[3].shiftedIndex, 0, 12);
		}
		if(mod_MetallurgyCore.hasNether)
		{
			FM_MintRecipes.minting().addMinting(mod_MetallurgyNether.alloys.Bar[2].shiftedIndex, 0, 30);
		}
		if(mod_MetallurgyCore.hasFantasy)
		{
			FM_MintRecipes.minting().addMinting(mod_MetallurgyFantasy.ores.Bar[5].shiftedIndex, 0, 10);
			FM_MintRecipes.minting().addMinting(mod_MetallurgyFantasy.ores.Bar[6].shiftedIndex, 0, 15);
			FM_MintRecipes.minting().addMinting(mod_MetallurgyFantasy.alloys.Bar[3].shiftedIndex, 0, 32);
		}
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