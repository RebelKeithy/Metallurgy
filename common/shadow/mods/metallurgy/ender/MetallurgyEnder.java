package shadow.mods.metallurgy.ender;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyBlock;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.MetallurgyItemSword;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.mystcraft.OreSymbol;
import shadow.mods.metallurgy.precious.ConfigPrecious;

import cpw.mods.fml.common.IFuelHandler;
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
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyEnder", name = "Metallurgy Ender", dependencies = "after:MetallurgyCore", version = "2.2")
@NetworkMod(channels = { "MetallurgyNether" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyEnder
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.ender.ClientProxy", serverSide = "shadow.mods.metallurgy.ender.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyEnder" )
	public static MetallurgyEnder instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;	
	
	public static CreativeTabs creativeTab;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigEnder.init();

		//creativeTab = MetallurgyCore.getNewCreativeTab("Ender Metals", ConfigEnder.alloyItemIds[0]);
		creativeTab = MetallurgyCore.getNewCreativeTab("Ender Metals", ConfigEnder.alloyItemIds[0] + 256 + 7);
		
		alloys = new MetalSet(new AlloyEnderEnum());
		ores = new MetalSet(new OreEnderEnum());
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
			System.out.println("Metallurgy is adding symbols ");
		} catch(Exception e) {
			System.out.println("Metallurgy not adding symbols " + e);
		}
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.registerRenderInformation();
		proxy.addNames();

		ores.load();
		alloys.load();
		
		GameRegistry.addRecipe(new ItemStack(Item.enderPearl, 4), "XXX", "X X", "XXX", 'X', new ItemStack(ores.Bar[1]));
		
		((MetallurgyBlock)(ores.ore)).addDisplayListener(new OreParticleSpawner());

		((MetallurgyItemSword)(alloys.Sword[0])).addHitListener(new EnderSwordEffectsListener());
		((MetallurgyItemSword)(alloys.Sword[0])).setSubText("knothing");
		
		new UpdateManager("2.2.3", "Ender", "http://ladadeda.info/EnderVersion.txt");
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();
		
		if(ConfigEnder.alloyEnabled[0])
			RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustEximite", "dustMeutoite");

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
}