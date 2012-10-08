package shadow.mods.metallurgy.utility;

import java.io.File;
import java.util.Random;

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
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
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

@Mod(modid = "MetallurgyUtility", name = "Metallurgy Utility", dependencies = "after:MetallurgyCore", version = "2.0.7.1")
@NetworkMod(channels = { "MetallurgyUtilit" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyUtility
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.utility.ClientProxy", serverSide = "shadow.mods.metallurgy.utility.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyUtility")
	public static MetallurgyUtility instance;

	public static Block vein;
	
	public static Item phosphorite;
	public static Item phosphorus;
	public static Item sulfur;
	public static Item saltpeter;
	public static Item magnesium;
	public static Item bitumen;
	public static Item tar;
	public static Item potash;
	public static Item fertilizer;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigUtility.init();
	
		vein = new BlockVein(ConfigUtility.veinID, "/shadow/MetallurgyUtilityOres.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("UtilityVein");

		phosphorite = (new UtilityItem(ConfigUtility.itemPhosphoriteID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(0,1).setItemName("Phosphorite");
		phosphorus = (new UtilityItem(ConfigUtility.itemPhosphorousID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(0,2).setItemName("Phosphorous").setTabToDisplayOn(CreativeTabs.tabMaterials);
		sulfur = (new UtilityItem(ConfigUtility.itemSulfurID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(1,1).setItemName("Sulfur").setTabToDisplayOn(CreativeTabs.tabMaterials);
		saltpeter = (new UtilityItem(ConfigUtility.itemSaltpeterID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(2,1).setItemName("Saltpeter").setTabToDisplayOn(CreativeTabs.tabMaterials);
		magnesium = (new UtilityItem(ConfigUtility.itemMagnesiumID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(3,1).setItemName("Magnesium").setTabToDisplayOn(CreativeTabs.tabMaterials);
		bitumen = (new UtilityItem(ConfigUtility.itemBitumenID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(4,1).setItemName("Bitumen").setTabToDisplayOn(CreativeTabs.tabMaterials);
		tar = (new UtilityItem(ConfigUtility.itemTarID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(4,2).setItemName("Tar").setTabToDisplayOn(CreativeTabs.tabMaterials);
		potash = (new UtilityItem(ConfigUtility.itemPotashID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(5,1).setItemName("Potash").setTabToDisplayOn(CreativeTabs.tabMaterials);
		fertilizer = (new UtilityItemFertilizer(ConfigUtility.itemFertilizerID, "/shadow/MetallurgyUtilityOres.png")).setIconCoord(1,2).setItemName("Fertilizer").setTabToDisplayOn(CreativeTabs.tabMaterials);
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{

		proxy.registerRenderInformation();
		proxy.addNames();

		GameRegistry.registerWorldGenerator(new UtilityWorldGen());
		GameRegistry.registerBlock(vein, BlockVeinItem.class);
		
		FertilizerRecipes.load();
		
		setBlockLevels();
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
		OreDictionary.registerOre("phosphorite", new ItemStack(phosphorite, 1));
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
	}
	
}
