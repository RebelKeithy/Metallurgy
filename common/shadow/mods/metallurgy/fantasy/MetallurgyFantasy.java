package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.CreativeTabMetallurgy;
import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyBlock;
import shadow.mods.metallurgy.MetallurgyItemSword;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.ender.ConfigEnder;
import shadow.mods.metallurgy.mystcraft.OreSymbol;
import shadow.mods.metallurgy.precious.ConfigPrecious;
import shadow.mods.metallurgy.precious.MetallurgyPrecious;

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
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyFantasy", name = "Metallurgy Fantasy", dependencies = "after:MetallurgyCore", version = "2.3.2")
@NetworkMod(channels = { "MetallurgyFantas" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyFantasy
{

	@SidedProxy(clientSide = "shadow.mods.metallurgy.fantasy.ClientProxy", serverSide = "shadow.mods.metallurgy.fantasy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyFantasy" )
	public static MetallurgyFantasy instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;

	public static CreativeTabs creativeTab;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigFantasy.init();

		creativeTab = MetallurgyCore.getNewCreativeTab("Fantasy Metals", ConfigFantasy.ItemStartID);
		
		alloys = new MetalSet(new AlloyFantasyEnum());
		ores = new MetalSet(new OreFantasyEnum());
	
		try
		{
			FantasyFurnace.metalFurnace = new FF_BlockMetalFurnace(ConfigFantasy.furnaceID, false).setHardness(3.5F).setBlockName("MetalFantasyFurnace");
		}
		catch(IllegalArgumentException e)
		{
			MetallurgyCore.blockError(e);
		    throw e;
		}
		
		proxy.registerRenderInformation();
		registerWithApi();
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{		
		try {
			Class mystcraftApi = Class.forName("xcompwiz.mystcraft.api.APICallHandler");
			Class ageSymbol = Class.forName("xcompwiz.mystcraft.api.symbol.AgeSymbol");
			Class oreSymbol = Class.forName("shadow.mods.metallurgy.mystcraft.OreSymbol");
			Constructor constructor = oreSymbol.getConstructor(new Class[]{MetalSet.class});
			Method registerSymbol = mystcraftApi.getMethod("registerSymbol", new Class[]{ageSymbol});
			registerSymbol.invoke(mystcraftApi, constructor.newInstance(ores));
		} catch(Exception e) {}
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		proxy.registerRenderInformation();
		proxy.addNames();

		((CreativeTabMetallurgy)creativeTab).setTabIconItemIndex(alloys.Helmet[4].shiftedIndex);
		alloys.load();
		ores.load();

		FantasySwordEffectsListener efl = new FantasySwordEffectsListener();
		((MetallurgyItemSword)(ores.Sword[1])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[3])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[4])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[7])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[9])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[10])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[11])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[0])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[1])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[2])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[3])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[4])).addHitListener(efl);
		MinecraftForge.EVENT_BUS.register(efl);
		
		((MetallurgyItemSword)(ores.Sword[1])).setSubText("cBlindness I");
		((MetallurgyItemSword)(ores.Sword[3])).setSubText("cResistance I");
		((MetallurgyItemSword)(ores.Sword[4])).setSubText("7Strength I");
		((MetallurgyItemSword)(ores.Sword[5])).setSubText("7Looting I");
		((MetallurgyItemSword)(ores.Sword[6])).setSubText("7Looting II");
		((MetallurgyItemSword)(ores.Sword[7])).setSubText("7Haste I");
		((MetallurgyItemSword)(ores.Sword[9])).setSubText("7Resistance II");
		((MetallurgyItemSword)(ores.Sword[10])).setSubText("7Fire Resistance-cIgnite II");
		((MetallurgyItemSword)(ores.Sword[11])).setSubText("7Strength II");
		((MetallurgyItemSword)(alloys.Sword[0])).setSubText("cBlindness II");
		((MetallurgyItemSword)(alloys.Sword[1])).setSubText("7Speed I");
		((MetallurgyItemSword)(alloys.Sword[2])).setSubText("7Haste II-cIgnite II");
		((MetallurgyItemSword)(alloys.Sword[3])).setSubText("7Resistance III");
		((MetallurgyItemSword)(alloys.Sword[4])).setSubText("7Haste II-cIgnite II");
		
		FantasyFurnace.load();

		((MetallurgyBlock)(ores.ore)).addDisplayListener(new OreParticleSpawner());

		ModLoader.addShapelessRecipe(new ItemStack(mod_Iron.IronDust, 1), ores.Dust[0], ores.Dust[1]);
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), new Object[] {ores.Dust[1], ores.Dust[2]});
		if(MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), new Object[] {ores.Dust[7], new ItemStack(MetallurgyPrecious.ores.Dust[1], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new Object[] {ores.Dust[7], ores.Dust[8]});
		if(MetallurgyCore.hasPrecious)
			ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[3], 1), new Object[] {ores.Dust[9], new ItemStack(MetallurgyPrecious.ores.Dust[2], 1)});
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[4], 1), new Object[] {ores.Dust[10], ores.Dust[11]});
		
		new UpdateManager("2.3.2", "Fantasy", "http://ladadeda.info/FantasyVersion.txt");
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();
		
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustDeep Iron", "dustInfuscolium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustMithril", "dustSilver");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "dustMithril", "dustRubracium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "dustOrichalcum", "dustPlatinum");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "dustAdamantine", "dustAtlarus");

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
		} catch (Exception e) {}
	}
	public void registerWithApi()
	{
		MetallurgyItems.registerItem("prometheumAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 0));
		MetallurgyItems.registerItem("deepIronAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 1));
		MetallurgyItems.registerItem("blackSteelAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 2));
		MetallurgyItems.registerItem("oureclaseAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 3));
		MetallurgyItems.registerItem("aredriteAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 4));
		MetallurgyItems.registerItem("mithrilAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 5));
		MetallurgyItems.registerItem("haderothAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 6));
		MetallurgyItems.registerItem("orichalcumAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 7));
		MetallurgyItems.registerItem("adamantineAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 8));
		MetallurgyItems.registerItem("atlarusAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 9));
		MetallurgyItems.registerItem("tartariteAbstractor", new ItemStack(FantasyFurnace.metalFurnace, 1, 10));
	}
}
