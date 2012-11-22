package shadow.mods.metallurgy.precious;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyItem;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import shadow.mods.metallurgy.fantasy.MetallurgyFantasy;
import shadow.mods.metallurgy.mystcraft.OreSymbol;
import shadow.mods.metallurgy.nether.ConfigNether;
import shadow.mods.metallurgy.nether.MetallurgyNether;

import cpw.mods.fml.common.FMLLog;
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
import net.minecraft.src.CraftingManager;
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
import net.minecraftforge.oredict.ShapedOreRecipe;

@Mod(modid = "MetallurgyPrecious", name = "Metallurgy Precious", dependencies = "after:MetallurgyCore", version = "2.3.1")
@NetworkMod(channels = { "MetallurgyPrecio" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyPrecious
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.precious.ClientProxy", serverSide = "shadow.mods.metallurgy.precious.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyPrecious" )
	public static MetallurgyPrecious instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;
	
	public static Block PreciousMetalsVein;
	public static Block PreciousMetalsBrick;
	
	public static Block PreciousChest;
	public static Block Mint;
	public static Block MintStorage;
	
	public static Item Coin;
	public static Item Stack;
	public static Item Bag;
	public static Item Bullion;
	public static Item GoldCog;

	public static CreativeTabs creativeTab;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigPrecious.init();
		
		//creativeTab = MetallurgyCore.getNewCreativeTab("Precious Metals", ConfigPrecious.ItemStartID);
		creativeTab = MetallurgyCore.getNewCreativeTab("Precious Metals", ConfigPrecious.ItemStartID + 256 + 7 + 50 * 2);
		
		alloys = new MetalSet(new AlloyPreciousEnum());
		ores = new MetalSet(new OrePreciousEnum());
		
		try
		{
			PreciousChest = new FC_BlockChest(ConfigPrecious.PreciousChestID).setHardness(0.5F).setResistance(.1F).setBlockName("PreciousChest");
			Mint = new FM_BlockMint(ConfigPrecious.PreciousMintID).setHardness(0.5F).setResistance(.1F).setBlockName("Mint");
			MintStorage = new FM_BlockMintStorage(ConfigPrecious.PreciousMintLoaderID).setHardness(0.5F).setResistance(.1F).setBlockName("MintStorage");
			Coin = new ItemCoins(ConfigPrecious.ItemStartID + 248).setItemName("Coin").setCreativeTab(MetallurgyPrecious.creativeTab).setIconIndex(8);
			Stack = new ItemCoins(ConfigPrecious.ItemStartID + 247).setItemName("Stack").setCreativeTab(MetallurgyPrecious.creativeTab).setIconIndex(24);
			Bag = new ItemCoins(ConfigPrecious.ItemStartID + 246).setItemName("Bag").setCreativeTab(MetallurgyPrecious.creativeTab).setIconIndex(40);
			Bullion = new ItemCoins(ConfigPrecious.ItemStartID + 245).setItemName("Bullion").setCreativeTab(MetallurgyPrecious.creativeTab).setIconIndex(56);
			GoldCog = new MetallurgyItem(ConfigPrecious.ItemStartID + 249, "/shadow/MetallurgyCoins.png").setIconIndex(2).setItemName("GoldCog").setCreativeTab(MetallurgyPrecious.creativeTab);
		}
		catch(IllegalArgumentException e)
		{
			MetallurgyCore.blockError(e);
		    throw e;
		}
		
		MinecraftForge.EVENT_BUS.register(new AlloyRecipes());
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		try {
			Class mystcraftApi = Class.forName("xcompwiz.mystcraft.api.APICallHandler");
			Class ageSymbol = Class.forName("xcompwiz.mystcraft.api.symbol.AgeSymbol");
			Class oreSymbol = Class.forName("shadow.mods.metallurgy.mystcraft.OreSymbol");
			Constructor constructor = oreSymbol.getConstructor(new Class[]{MetalSet.class});
			Method registerSymbol = mystcraftApi.getMethod("registerSymbol", new Class[]{ageSymbol});
			registerSymbol.invoke(mystcraftApi, constructor.newInstance(ores));
		} catch(Exception e) {}
		
		GameRegistry.registerBlock(PreciousChest, FC_ChestItemBlock.class);
		GameRegistry.registerTileEntity(FC_TileEntityChest.class, "PreciousChest");
		GameRegistry.registerBlock(Mint);
		GameRegistry.registerTileEntity(FM_TileEntityMint.class, "Mint");
		GameRegistry.registerBlock(MintStorage);
		GameRegistry.registerTileEntity(FM_TileEntityMintStorage.class, "MintStorage");
		
		if(ConfigPrecious.tradesEnabled)
			for(int i = 0; i < 5; i++)
				VillagerRegistry.instance().registerVillageTradeHandler(i, new PreciousTradeHandler());
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		alloys.load();
		ores.load();
		
		proxy.addNames();
		proxy.registerTileEntitySpecialRenderer();
		proxy.registerRenderInformation();
		registerWithApi();
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{

		
		ores.registerOres();
		alloys.registerOres();
		
    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0]), "dustZinc", "dustCopper");
    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1]), "dustGold", "dustSilver");

    	if(ConfigPrecious.mintEnabled)
    	{
			ModLoader.addRecipe(new ItemStack(GoldCog, 1), new Object[] {
				" G ", "GIG", " G ", Character.valueOf('G'), Item.ingotGold, Character.valueOf('I'), Item.ingotIron
			});
			ModLoader.addRecipe(new ItemStack(MintStorage, 1), new Object[] {
				"GBG", "PCP", "GBG", Character.valueOf('G'), GoldCog, Character.valueOf('C'), Block.chest, Character.valueOf('B'), Item.ingotIron, Character.valueOf('P'), Block.pistonBase
			});
			ModLoader.addRecipe(new ItemStack(Mint, 1), new Object[] {
				"III", "SRS", "IPI", Character.valueOf('G'), GoldCog, Character.valueOf('I'), Item.ingotIron, Character.valueOf('S'), Item.stick, Character.valueOf('P'), Block.pistonBase, Character.valueOf('R'), Item.redstone
			});
    	}
		
		RecipeHelper.addPoweredRailsRecipe("ingotBrass", 1);
		RecipeHelper.addPoweredRailsRecipe(alloys.Bar[1], 9);
		RecipeHelper.addPoweredRailsRecipe("ingotSilver", 3);
		RecipeHelper.addPoweredRailsRecipe(ores.Bar[2], 24);

		RecipeHelper.addStorageRecipe(new ItemStack(Stack, 1), new ItemStack(Coin, 1));
		RecipeHelper.addStorageRecipe(new ItemStack(Bag, 1), new ItemStack(Stack, 1));
		RecipeHelper.addStorageRecipe(new ItemStack(Bullion, 1), new ItemStack(Bag, 1));
		
		if(ConfigPrecious.chestsEnabled)
			addChestRecipes();
		
		FM_MintRecipes.minting().addMinting(ores.Bar[1].shiftedIndex, 0, 3);
		FM_MintRecipes.minting().addMinting(ores.Bar[2].shiftedIndex, 0, 27);
		FM_MintRecipes.minting().addMinting(alloys.Bar[0].shiftedIndex, 0, 1);
		FM_MintRecipes.minting().addMinting(alloys.Bar[1].shiftedIndex, 0, 13);
		FM_MintRecipes.minting().addMinting(Item.ingotGold.shiftedIndex, 0, 9);
		
		if(MetallurgyCore.hasBase)
		{
			FM_MintRecipes.minting().addMinting(MetallurgyBaseMetals.alloys.Bar[1].shiftedIndex, 0, 10);
			FM_MintRecipes.minting().addMinting(MetallurgyBaseMetals.alloys.Bar[3].shiftedIndex, 0, 12);
		}
		if(MetallurgyCore.hasNether)
		{
			FM_MintRecipes.minting().addMinting(MetallurgyNether.alloys.Bar[2].shiftedIndex, 0, 30);
		}
		if(MetallurgyCore.hasFantasy)
		{
			FM_MintRecipes.minting().addMinting(MetallurgyFantasy.ores.Bar[5].shiftedIndex, 0, 10);
			FM_MintRecipes.minting().addMinting(MetallurgyFantasy.ores.Bar[6].shiftedIndex, 0, 15);
			FM_MintRecipes.minting().addMinting(MetallurgyFantasy.alloys.Bar[3].shiftedIndex, 0, 32);
		}
		
		new UpdateManager("2.3.1", "Precious", "http://ladadeda.info/PreciousVersion.txt");

		ArrayList<Integer> swordIds = new ArrayList<Integer>();
		
		for(int n = 0; n < ores.numMetals; n++)		
		{
			if(ores.Sword[n] != null)
				swordIds.add(ores.Sword[n].shiftedIndex);
		}
		for(int n = 0; n < alloys.numMetals; n++)		
		{
			if(alloys.Sword[n] != null)
				swordIds.add(alloys.Sword[n].shiftedIndex);
		}
		int[] list = new int[swordIds.size()];
		for(int n = 0; n < list.length; n++)
			list[n] = swordIds.get(n);

		try {
			Class c = Class.forName("me.Golui.SwordPedestal.common.SwordPedestalMain");
			c.getDeclaredMethod("addItems", int[].class).invoke(this, list);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void addChestRecipes()
	{
		CraftingManager cm = CraftingManager.getInstance();
		cm.addRecipe(new ItemStack(MetallurgyPrecious.PreciousChest, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotGold, Character.valueOf('F'), new ItemStack(MetallurgyPrecious.PreciousChest, 1, 1)
		});

    	ShapedOreRecipe brassChestRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyPrecious.PreciousChest, 1, 0), 
    			"XXX", "XFX", "XXX", 'X', "ingotBrass", 'F', Block.chest);

    	ShapedOreRecipe silverChestRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyPrecious.PreciousChest, 1, 1),
				"XXX", "XFX", "XXX", 'X', "ingotSilver", 'F', new ItemStack(MetallurgyPrecious.PreciousChest, 1, 0));

    	ShapedOreRecipe electrumChestRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyPrecious.PreciousChest, 1, 3),
				"XXX", "XFX", "XXX", 'X', "ingotElectrum", 'F', new ItemStack(MetallurgyPrecious.PreciousChest, 1, 2));

    	ShapedOreRecipe platinumChestRecipe = new ShapedOreRecipe(new ItemStack(MetallurgyPrecious.PreciousChest, 1, 4),
				"XXX", "XFX", "XXX", 'X', "ingotPlatinum", 'F', new ItemStack(MetallurgyPrecious.PreciousChest, 1, 3));
    	
    	cm.getRecipeList().add(brassChestRecipe);
    	cm.getRecipeList().add(silverChestRecipe);
    	cm.getRecipeList().add(electrumChestRecipe);
    	cm.getRecipeList().add(platinumChestRecipe);
	}
	
	private void registerWithApi()
	{
		MetallurgyItems.registerItem("brassChest", new ItemStack(PreciousChest, 1, 0));
		MetallurgyItems.registerItem("silverChest", new ItemStack(PreciousChest, 1, 1));
		MetallurgyItems.registerItem("goldChest", new ItemStack(PreciousChest, 1, 2));
		MetallurgyItems.registerItem("electrumChest", new ItemStack(PreciousChest, 1, 3));
		MetallurgyItems.registerItem("platinumChest", new ItemStack(PreciousChest, 1, 4));
		MetallurgyItems.registerItem("mint", new ItemStack(Mint, 1, 0));
		MetallurgyItems.registerItem("mintStorage", new ItemStack(MintStorage, 1, 0));
		MetallurgyItems.registerItem("goldCog", new ItemStack(GoldCog, 1, 0));
		MetallurgyItems.registerItem("coin", new ItemStack(Coin, 1));
		MetallurgyItems.registerItem("stack", new ItemStack(Stack, 1));
		MetallurgyItems.registerItem("bag", new ItemStack(Bag, 1));
		MetallurgyItems.registerItem("bullion", new ItemStack(Bullion, 1));
	}
}