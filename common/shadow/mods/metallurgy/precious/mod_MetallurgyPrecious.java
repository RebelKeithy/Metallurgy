package shadow.mods.metallurgy.precious;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.base.AlloyBronze;
import shadow.mods.metallurgy.base.OreCopper;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;

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
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyPrecious", name = "Metallurgy Precious", version = "1.3")
@NetworkMod(channels = { "MetallurgyPrecio" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyPrecious
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.precious.ClientProxy", serverSide = "shadow.mods.metallurgy.precious.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyPrecious instance;

	public static Block PreciousMetalsVein;
	public static Block PreciousMetalsBrick;
	public static Block PreciousAlloysBrick;
	
	public static Block PreciousChest;
	
	public mod_MetallurgyPrecious()
	{
		instance = this;
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		PreciousConfig.init();
		
		PreciousMetalsVein = new BlockPreciousMetalsVein(PreciousConfig.PreciousMetalsVeinID, "/shadow/MetallurgyPreciousMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("PreciousMetalsVein");
		PreciousMetalsBrick = new BlockPreciousMetalsBrick(PreciousConfig.PreciousMetalsBrickID, "/shadow/MetallurgyPreciousMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("PreciousMetalsBrick");
		PreciousAlloysBrick = new BlockPreciousAlloysBrick(PreciousConfig.PreciousAlloysBrickID, "/shadow/MetallurgyPreciousAlloys.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("PreciousAlloysBrick");
		PreciousChest = new FC_BlockChest(923).setHardness(0.5F).setResistance(.1F).setBlockName("PreciousChest");
		
		AlloyPrecious.init();
		OrePrecious.init();
	}

	@Init
	public void init(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(PreciousMetalsVein, BlockPreciousMetalsVeinItem.class);
		GameRegistry.registerBlock(PreciousMetalsBrick, BlockPreciousMetalsBrickItem.class);
		GameRegistry.registerBlock(PreciousAlloysBrick, BlockPreciousAlloysBrickItem.class);

		GameRegistry.registerBlock(PreciousChest, FC_ChestItemBlock.class);
		GameRegistry.registerTileEntity(FC_TileEntityChest.class, "PreciousChest");
		proxy.registerTileEntitySpecialRenderer();
		proxy.registerRenderInformation();
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		GameRegistry.registerWorldGenerator(new PreciousWorldGen());
		
		AlloyPrecious.load();
		OrePrecious.load();
		
		registerOres();
		addDungeonLoot();
		setBlockHarvestLevels();
		addChestRecipes();
		proxy.addNames();
		
	}
	
	public void registerOres()
	{
		for(int i = 0; i < AlloyPrecious.numAlloys; i++)
		{
			OreDictionary.registerOre("dust" + AlloyPrecious.name[i], new ItemStack(AlloyPrecious.Dust, 1, i));
			OreDictionary.registerOre("ingo" + AlloyPrecious.name[i], new ItemStack(AlloyPrecious.Bar, 1, i));
		}
		for(int i = 0; i < OrePrecious.numMetals; i++)
		{
			OreDictionary.registerOre("dust" + OrePrecious.name[i], new ItemStack(OrePrecious.Dust, 1, i));
			OreDictionary.registerOre("ingo" + OrePrecious.name[i], new ItemStack(OrePrecious.Bar, 1, i));
		}
	}
	
	public void addDungeonLoot()
	{
		DungeonHooks.addDungeonLoot(new ItemStack(OrePrecious.Bar, 1, 0), 50, 1, 4);
		DungeonHooks.addDungeonLoot(new ItemStack(OrePrecious.Bar, 1, 1), 25, 1, 3);
		DungeonHooks.addDungeonLoot(new ItemStack(OrePrecious.Bar, 1, 2), 5, 1, 1);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyPrecious.Bar, 1, 0), 35, 1, 3);
		DungeonHooks.addDungeonLoot(new ItemStack(AlloyPrecious.Bar, 1, 1), 15, 1, 2);
	}
	
	public void setBlockHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsVein, 0, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsBrick, 0, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsVein, 1, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsBrick, 1, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsVein, 2, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(PreciousMetalsBrick, 2, "pickaxe", 6);
		
		MinecraftForge.setBlockHarvestLevel(PreciousAlloysBrick, 0, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(PreciousAlloysBrick, 1, "pickaxe", 6);
	}
	
	public void addChestRecipes()
	{
		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 0), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(AlloyPrecious.Bar, 1, 0), Character.valueOf('F'), Block.chest
		});
		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 1), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(OrePrecious.Bar, 1, 1), Character.valueOf('F'), new ItemStack(PreciousChest, 1, 0)
		});
		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 2), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), Item.ingotGold, Character.valueOf('F'), new ItemStack(PreciousChest, 1, 1)
		});
		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 3), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(AlloyPrecious.Bar, 1, 1), Character.valueOf('F'), new ItemStack(PreciousChest, 1, 2)
		});
		ModLoader.addRecipe(new ItemStack(PreciousChest, 1, 4), new Object[] {
			"XXX", "XFX", "XXX", Character.valueOf('X'), new ItemStack(OrePrecious.Bar, 1, 2), Character.valueOf('F'), new ItemStack(PreciousChest, 1, 3)
		});
	}
}