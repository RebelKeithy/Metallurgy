package shadow.mods.metallurgy.utility;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import shadow.mods.metallurgy.CreativeTabMetallurgy;
import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mystcraft.OreSymbol;
import shadow.mods.metallurgy.mystcraft.OreSymbolUtility;
import shadow.mods.metallurgy.precious.ConfigPrecious;

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
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EntityList;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.OreDictionary.OreRegisterEvent;

@Mod(modid = "MetallurgyUtility", name = "Metallurgy Utility", dependencies = "after:MetallurgyCore", version = MetallurgyUtility.version)
@NetworkMod(channels = { "MetallurgyUtilit" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyUtility
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.utility.ClientProxy", serverSide = "shadow.mods.metallurgy.utility.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyUtility")
	public static MetallurgyUtility instance;

	public static final String version = "2.3.3";
	
	public static Block vein;
	public static Block minersTNT;
	public static Block largeTNT;
	
	public static Item phosphorus;
	public static Item sulfur;
	public static Item saltpeter;
	public static Item magnesium;
	public static Item bitumen;
	public static Item tar;
	public static Item potash;
	public static Item fertilizer;
	public static Item igniter;
	public static Item match;
	
	public static CreativeTabs creativeTab;
	
	public static List oreBlockIDs;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigUtility.init();

		creativeTab = MetallurgyCore.getNewCreativeTab("Utility Ores", ConfigUtility.itemMagnesiumID + 256);
		
		try
		{
			vein = new BlockVein(ConfigUtility.veinID, "/shadow/MetallurgyUtilityOres.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("UtilityVein").setCreativeTab(creativeTab);
			minersTNT = new MinersTNT(ConfigUtility.minersTntId, 64).setBlockName("MinersTNT").setCreativeTab(creativeTab);
			largeTNT = new LargeTNT(ConfigUtility.largeTntId, 48).setBlockName("largeTNT").setCreativeTab(creativeTab);
		}
		catch(IllegalArgumentException e)
		{
			MetallurgyCore.blockError(e);
		    throw e;
		}
		
		minersTNT.setTextureFile("/shadow/MetallurgyUtilityOres.png").setStepSound(Block.soundGrassFootstep);
		largeTNT.setTextureFile("/shadow/MetallurgyUtilityOres.png").setStepSound(Block.soundGrassFootstep);
		
		phosphorus = (new UtilityItem(ConfigUtility.itemPhosphorousID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(0,2).setItemName("Phosphorous").setCreativeTab(creativeTab);
		sulfur = (new UtilityItem(ConfigUtility.itemSulfurID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(1,1).setItemName("Sulfur").setCreativeTab(creativeTab);
		saltpeter = (new UtilityItem(ConfigUtility.itemSaltpeterID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(2,1).setItemName("Saltpeter").setCreativeTab(creativeTab);
		magnesium = (new UtilityItem(ConfigUtility.itemMagnesiumID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(3,1).setItemName("Magnesium").setCreativeTab(creativeTab);
		bitumen = (new UtilityItem(ConfigUtility.itemBitumenID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(4,1).setItemName("Bitumen").setCreativeTab(creativeTab);
		tar = (new UtilityItem(ConfigUtility.itemTarID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(4,2).setItemName("Tar").setCreativeTab(creativeTab);
		potash = (new UtilityItem(ConfigUtility.itemPotashID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(5,1).setItemName("Potash").setCreativeTab(creativeTab);
		fertilizer = (new UtilityItemFertilizer(ConfigUtility.itemFertilizerID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(1,2).setItemName("Fertilizer").setCreativeTab(creativeTab);
		igniter = (new ItemIgniter(ConfigUtility.itemIgniterID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(4, 3).setItemName("Igniter").setCreativeTab(creativeTab);
		match = (new ItemMatch(ConfigUtility.itemMatchID,  "/shadow/MetallurgyUtilityOres.png")).setIconCoord(3, 3).setItemName("Match").setCreativeTab(creativeTab);
		
		((CreativeTabMetallurgy)creativeTab).setTabIconItemIndex(magnesium.shiftedIndex);
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		try {
			Class mystcraftApi = Class.forName("xcompwiz.mystcraft.api.APICallHandler");
			Class ageSymbol = Class.forName("xcompwiz.mystcraft.api.symbol.AgeSymbol");
			Class oreSymbol = Class.forName("shadow.mods.metallurgy.mystcraft.OreSymbolUtility");
			Constructor constructor = oreSymbol.getConstructor();
			Method registerSymbol = mystcraftApi.getMethod("registerSymbol", new Class[]{ageSymbol});
			registerSymbol.invoke(mystcraftApi, constructor.newInstance());
		} catch(Exception e) {}
		

		GameRegistry.registerWorldGenerator(new UtilityWorldGen());
		GameRegistry.registerBlock(vein, BlockVeinItem.class);
		GameRegistry.registerBlock(minersTNT);
		GameRegistry.registerBlock(largeTNT);
		
		//EntityList.addMapping(EntityMinersTNTPrimed.class, "MinersTNTEntity", 112);
		EntityRegistry.registerModEntity(shadow.mods.metallurgy.utility.EntityMinersTNTPrimed.class, "MinersTNTEntity", 112, this, 64, 10, true);
		//EntityList.addMapping(EntityLargeTNTPrimed.class, "LargeTNTEntity", 113);
		EntityRegistry.registerModEntity(shadow.mods.metallurgy.utility.EntityLargeTNTPrimed.class, "LargeTNTEntity", 113, this, 64, 10, true);

		proxy.registerRenderInformation();
		proxy.addNames();
		
		FertilizerRecipes.load();
		
		setBlockLevels();
		
		new UpdateManager(MetallurgyUtility.version, "Utility", "http://ladadeda.info/UtilityVersion.txt");
	}
	
	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		registerOres();
	}
	
	public void setBlockLevels()
	{
		MinecraftForge.setBlockHarvestLevel(vein, 0, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(vein, 1, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(vein, 2, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(vein, 3, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(vein, 4, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(vein, 5, "pickaxe", 1);
	}
	
	public void registerOres()
	{
		OreDictionary.registerOre("bitumen", new ItemStack(bitumen, 1));
		OreDictionary.registerOre("magnesium", new ItemStack(magnesium, 1));
		OreDictionary.registerOre("potash", new ItemStack(potash, 1));
		OreDictionary.registerOre("saltpeter", new ItemStack(saltpeter, 1));
		OreDictionary.registerOre("sulfur", new ItemStack(sulfur, 1));
		
		OreDictionary.registerOre("itemBitumen", bitumen);
		OreDictionary.registerOre("itemTar", tar);
		OreDictionary.registerOre("itemMagnesium", magnesium);
		OreDictionary.registerOre("itemPhosphorus", phosphorus);
		OreDictionary.registerOre("itemPotash", potash);
		OreDictionary.registerOre("itemSaltpeter", saltpeter);
		OreDictionary.registerOre("itemSulfur", sulfur);
		
		OreDictionary.registerOre("orePhosphorite", new ItemStack(vein, 1, 0));
		OreDictionary.registerOre("oreSulfur", new ItemStack(vein, 1, 1));
		OreDictionary.registerOre("oreSaltpeter", new ItemStack(vein, 1, 2));
		OreDictionary.registerOre("oreMagnesium", new ItemStack(vein, 1, 3));
		OreDictionary.registerOre("oreBitumen", new ItemStack(vein, 1, 4));
		OreDictionary.registerOre("orePotash", new ItemStack(vein, 1, 5));
	}
	
	public void registerWithApi()
	{
		MetallurgyItems.registerItem("bitumen", new ItemStack(bitumen, 1));
		MetallurgyItems.registerItem("magnesium", new ItemStack(magnesium, 1));
		MetallurgyItems.registerItem("potash", new ItemStack(potash, 1));
		MetallurgyItems.registerItem("saltpeter", new ItemStack(saltpeter, 1));
		MetallurgyItems.registerItem("sulfur", new ItemStack(sulfur, 1));
		
		MetallurgyItems.registerItem("orePhosphorite", new ItemStack(vein, 1, 0));
		MetallurgyItems.registerItem("oreSulfur", new ItemStack(vein, 1, 1));
		MetallurgyItems.registerItem("oreSaltpeter", new ItemStack(vein, 1, 2));
		MetallurgyItems.registerItem("oreMagnesium", new ItemStack(vein, 1, 3));
		MetallurgyItems.registerItem("oreBitumen", new ItemStack(vein, 1, 4));
		MetallurgyItems.registerItem("orePotash", new ItemStack(vein, 1, 5));
	}
	
	public static void initializeOreList()
	{
		oreBlockIDs = new ArrayList();
		oreBlockIDs.add(Block.oreCoal.blockID);
		oreBlockIDs.add(Block.oreIron.blockID);
		oreBlockIDs.add(Block.oreGold.blockID);
		oreBlockIDs.add(Block.oreDiamond.blockID);
		oreBlockIDs.add(Block.oreRedstone.blockID);
		oreBlockIDs.add(Block.oreLapis.blockID);
		
		String[] names = OreDictionary.getOreNames();
		
		for(String name : names)
		{
			if(name.contains("ore"))
			{
				List<ItemStack> ores = OreDictionary.getOres(name);
				
				for(ItemStack ore : ores)
				{
					oreBlockIDs.add(ore.itemID);
				}
			}
		}
	}

	public static boolean isOre(int var25) {
		if(oreBlockIDs == null)
			initializeOreList();
		
		return oreBlockIDs.contains(var25);
	}
	
}
