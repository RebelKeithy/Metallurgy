package shadow.mods.metallurgy.base;

import java.io.File;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyBase", name = "Metallurgy Base", version = "1.3")
@NetworkMod(channels = { "MetallurgyBase" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyBaseMetals {
	
	@SidedProxy(clientSide = "shadow.mods.metallurgy.base.ClientProxy", serverSide = "shadow.mods.metallurgy.base.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyBaseMetals instance;

	public mod_MetallurgyBaseMetals() 
	{	
		instance = this;
	}
	
	public static Block BaseMetalsVein;
	public static Block BaseMetalsBrick;
	public static Block BaseAlloysBrick;
	public static Block metalFurnace;
	
	public static Block camoBlock;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		BaseConfig.init();
		
		proxy.registerRenderInformation();

		BaseMetalsVein = new BlockMetalsVein(BaseConfig.baseMetalsVeinID, "/shadow/MetallurgyBaseMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("BaseMetalsVein");
		BaseMetalsBrick = new BlockMetalsBrick(BaseConfig.baseMetalsBrickID, "/shadow/MetallurgyBaseMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("BaseMetalsBrick");
		BaseAlloysBrick = new BlockMetalsBrick(BaseConfig.baseAlloysBrickID, "/shadow/MetallurgyBaseAlloys.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("BaseAlloysBrick");
		metalFurnace = new BF_BlockMetalFurnace(BaseConfig.furnaceID, false).setHardness(3.5F).setBlockName("MetalFurnace");
		
		camoBlock = new CamoBlock(1000, Material.iron).setBlockName("CamoBlock");
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(camoBlock);
		
		GameRegistry.registerBlock(BaseMetalsVein, shadow.mods.metallurgy.base.BlockMetalsVeinItem.class);
		GameRegistry.registerBlock(BaseMetalsBrick, shadow.mods.metallurgy.base.BlockMetalsBrickItem.class);
		GameRegistry.registerBlock(BaseAlloysBrick, shadow.mods.metallurgy.base.BlockAlloysBrickItem.class);
		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.base.BF_BlockMetalFurnaceItem.class);

		ModLoader.registerTileEntity(BF_TileEntityMetalFurnace.class, "metalFurnace");
		
		GameRegistry.registerWorldGenerator(new BaseWorldGen());
		
		OreCopper.load();
		OreGold.load();
		OreIron.load();
		OreManganese.load();
		OreTin.load();
		AlloyAngmallen.load();
		AlloyBronze.load();
		AlloyDamascusSteel.load();
		AlloyHepatizon.load();
		AlloySteel.load();
		
		mod_Furnace.load();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		proxy.addNames();
		
		setBlockHarvestLevels();
		registerOres();
		addDungeonLoot();
		setToolLevels();
	}
	
	public void setBlockHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(BaseMetalsVein, 0, "pickaxe", 2); // Copper
		MinecraftForge.setBlockHarvestLevel(BaseMetalsBrick, 0, "pickaxe", 2); // Copper
		MinecraftForge.setBlockHarvestLevel(BaseMetalsVein, 1, "pickaxe", 2); // Tin
		MinecraftForge.setBlockHarvestLevel(BaseMetalsBrick, 1, "pickaxe", 2); // Tin
		MinecraftForge.setBlockHarvestLevel(BaseMetalsVein, 2, "pickaxe", 2); // Iron
		MinecraftForge.setBlockHarvestLevel(BaseMetalsBrick, 2, "pickaxe", 2); // Iron
		MinecraftForge.setBlockHarvestLevel(BaseMetalsVein, 3, "pickaxe", 3); // Manganese
		MinecraftForge.setBlockHarvestLevel(BaseMetalsBrick, 3, "pickaxe", 3); // Manganese
		MinecraftForge.setBlockHarvestLevel(BaseMetalsVein, 4, "pickaxe", 3); // Gold
		MinecraftForge.setBlockHarvestLevel(BaseMetalsBrick, 4, "pickaxe", 3); // Gold

		MinecraftForge.setBlockHarvestLevel(BaseAlloysBrick, 0, "pickaxe", 3); // Bronze
		MinecraftForge.setBlockHarvestLevel(BaseAlloysBrick, 1, "pickaxe", 3); // Hepatizon
		MinecraftForge.setBlockHarvestLevel(BaseAlloysBrick, 2, "pickaxe", 3); // Damascus
		MinecraftForge.setBlockHarvestLevel(BaseAlloysBrick, 3, "pickaxe", 3); // Angmallen
		MinecraftForge.setBlockHarvestLevel(BaseAlloysBrick, 4, "pickaxe", 4); // Steel
	}
	
	public void registerOres()
	{
		OreDictionary.registerOre("dustAngmallen", new ItemStack(AlloyAngmallen.AngmallenDust, 1));
		OreDictionary.registerOre("ingotAngmallen", new ItemStack(AlloyAngmallen.AngmallenBar, 1));

		OreDictionary.registerOre("dustBronze", new ItemStack(AlloyBronze.BronzeDust, 1));
		OreDictionary.registerOre("ingotBronze", new ItemStack(AlloyBronze.BronzeBar, 1));
		
		OreDictionary.registerOre("dustDamascusSteel", new ItemStack(AlloyDamascusSteel.DamascusSteelDust, 1));
		OreDictionary.registerOre("ingotDamascusSteel", new ItemStack(AlloyDamascusSteel.DamascusSteelBar, 1));

		OreDictionary.registerOre("dustHepatizon", new ItemStack(AlloyHepatizon.HepatizonDust, 1));
		OreDictionary.registerOre("ingotHepatizon", new ItemStack(AlloyHepatizon.HepatizonBar, 1));

		OreDictionary.registerOre("dustSteel", new ItemStack(AlloySteel.SteelDust, 1));
		OreDictionary.registerOre("ingotSteel", new ItemStack(AlloySteel.SteelBar, 1));
		
		
		OreDictionary.registerOre("oreCopper", new ItemStack(mod_MetallurgyBaseMetals.BaseMetalsVein, 1, OreCopper.meta));
		OreDictionary.registerOre("dustCopper", new ItemStack(OreCopper.CopperDust, 1));
		OreDictionary.registerOre("ingotCopper", new ItemStack(OreCopper.CopperBar, 1));

		OreDictionary.registerOre("oreGold", new ItemStack(mod_MetallurgyBaseMetals.BaseMetalsVein, 1, OreGold.meta));
		OreDictionary.registerOre("dustGold", new ItemStack(OreGold.GoldDust, 1));

		OreDictionary.registerOre("oreIron", new ItemStack(mod_MetallurgyBaseMetals.BaseMetalsVein, 1, OreIron.meta));
		OreDictionary.registerOre("dustIron", new ItemStack(OreIron.IronDust, 1));

		OreDictionary.registerOre("oreManganese", new ItemStack(mod_MetallurgyBaseMetals.BaseMetalsVein, 1, OreManganese.meta));
		OreDictionary.registerOre("dustManganese", new ItemStack(OreManganese.ManganeseDust, 1));
		OreDictionary.registerOre("ingotManganese", new ItemStack(OreManganese.ManganeseBar, 1));

		OreDictionary.registerOre("oreTin", new ItemStack(mod_MetallurgyBaseMetals.BaseMetalsVein, 1, OreTin.meta));
		OreDictionary.registerOre("dustTin", new ItemStack(OreTin.TinDust, 1));
		OreDictionary.registerOre("ingotTin", new ItemStack(OreTin.TinBar, 1));
	}
	
	public void addDungeonLoot()
	{
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyAngmallen.AngmallenBar), 075, 1, 2);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyBronze.BronzeBar), 120, 1, 3);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyDamascusSteel.DamascusSteelBar), 80, 1, 2);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyHepatizon.HepatizonBar), 120, 1, 3);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloySteel.SteelBar), 50, 1, 2);
		DungeonHooks.addDungeonLoot(new ItemStack(OreCopper.CopperBar), 150, 1, 6);
		DungeonHooks.addDungeonLoot(new ItemStack(OreManganese.ManganeseBar), 65, 1, 2);
		DungeonHooks.addDungeonLoot(new ItemStack(OreTin.TinBar), 130, 1, 4);
	}
	
	public void setToolLevels()
	{
		MinecraftForge.setToolClass(AlloyAngmallen.AngmallenPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AlloyBronze.BronzePickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AlloyDamascusSteel.DamascusSteelPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AlloyHepatizon.HepatizonPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AlloySteel.SteelPickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(OreCopper.CopperPickaxe, "pickaxe", 2);
	}
	
}