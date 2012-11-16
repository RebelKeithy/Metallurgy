package shadow.mods.metallurgy.nether;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.MetallurgyBlock;
import shadow.mods.metallurgy.MetallurgyItems;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.UpdateManager;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.base.OreBaseEnum;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import shadow.mods.metallurgy.base.AlloyBaseEnum;
import shadow.mods.metallurgy.ender.MetallurgyEnder;
import shadow.mods.metallurgy.fantasy.ConfigFantasy;
import shadow.mods.metallurgy.fantasy.MetallurgyFantasy;
import shadow.mods.metallurgy.mystcraft.OreSymbol;
import shadow.mods.metallurgy.precious.ConfigPrecious;
import shadow.mods.metallurgy.precious.MetallurgyPrecious;
import shadow.mods.metallurgy.MetallurgyItemSword;

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

@Mod(modid = "MetallurgyNether", name = "Metallurgy Nether", dependencies = "after:MetallurgyCore", version = "2.2")
@NetworkMod(channels = { "MetallurgyNether" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyNether
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.nether.ClientProxy", serverSide = "shadow.mods.metallurgy.nether.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyNether" )
	public static MetallurgyNether instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;	

	public static CreativeTabs creativeTab;
	
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigNether.init();

		//creativeTab = MetallurgyCore.getNewCreativeTab("Nether Metals", ConfigNether.ItemStartID);
		creativeTab = MetallurgyCore.getNewCreativeTab("Nether Metals", ConfigNether.ItemStartID + 256 + 7 + 50 * 7);
		
		alloys = new MetalSet(new AlloyNetherEnum());
		ores = new MetalSet(new OreNetherEnum());
		
		NetherForge.init();
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
		
		GameRegistry.registerBlock(NetherForge.metalFurnace, NF_BlockNetherForgeItem.class);
		GameRegistry.registerTileEntity(NF_TileEntityNetherForge.class, "netherFurnace");
	
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.registerRenderInformation();
		proxy.addNames();
		
		ores.load();
		alloys.load();

		((MetallurgyBlock)(ores.ore)).addCollisionListener(new VyroxeresListener());
		((MetallurgyBlock)(ores.ore)).addDisplayListener(new VyroxeresDisplay());
		NetherSwordEffectsListener efl = new NetherSwordEffectsListener();
		((MetallurgyItemSword)(ores.Sword[0])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[1])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[3])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[4])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[5])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[6])).addHitListener(efl);
		((MetallurgyItemSword)(ores.Sword[7])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[0])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[1])).addHitListener(efl);
		((MetallurgyItemSword)(alloys.Sword[2])).addHitListener(efl);
		MinecraftForge.EVENT_BUS.register(efl);
		
		NetherForge.load();
		
		GameRegistry.registerFuelHandler(new NetherFuelDust());
		
		if(ConfigNether.midasiumEnabled)
			addMidasiumRecipes();

		ModLoader.addRecipe(new ItemStack(Item.blazeRod, 1), new Object[] {
			"X", "X", Character.valueOf('X'), ores.Bar[6]
		});
		
		GameRegistry.registerWorldGenerator(new ObsidianSpawns());
		
		ModLoader.addShapelessRecipe(new ItemStack(mod_Iron.IronDust, 1), ores.Dust[0], ores.Dust[1]);
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), ores.Dust[8], ores.Dust[1]);
	    ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), ores.Dust[9], ores.Dust[4]);
	    if(MetallurgyCore.hasPrecious)
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new ItemStack(MetallurgyPrecious.ores.Dust[2], 1), ores.Dust[5]);
	    
		new UpdateManager("2.2.3", "Nether", "http://ladadeda.info/NetherVersion.txt");
	}
	
	public static void addMidasiumRecipes()
	{	    
		
		ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(mod_Iron.IronDust, 1), ores.Dust[2]);
		ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(mod_Gold.GoldDust, 1), ores.Dust[2]);
		
		if(MetallurgyCore.hasBase)
	    {
			for(int i  = 0; i < AlloyBaseEnum.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyBaseMetals.alloys.Dust[i], 1), ores.Dust[2]);
			for(int i  = 0; i < OreBaseEnum.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyBaseMetals.ores.Dust[i], 1), ores.Dust[2]);
		}
	    //Precious Metals
	    if(MetallurgyCore.hasPrecious)
	    {
			for(int i  = 0; i < MetallurgyPrecious.alloys.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyPrecious.alloys.Dust[i], 1), ores.Dust[2]);
			for(int i  = 0; i < MetallurgyPrecious.ores.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyPrecious.ores.Dust[i], 1), ores.Dust[2]);
	    }
	    
	    //Fantasy Metals
	    if(MetallurgyCore.hasFantasy)
	    {
			for(int i  = 0; i < MetallurgyFantasy.alloys.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyFantasy.alloys.Dust[i], 1), ores.Dust[2]);
			for(int i  = 0; i < MetallurgyFantasy.ores.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyFantasy.ores.Dust[i], 1), ores.Dust[2]);
	    }
	    
	    //Fantasy Metals
	    if(MetallurgyCore.hasEnder)
	    {
			for(int i  = 0; i < MetallurgyEnder.alloys.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyEnder.alloys.Dust[i], 1), ores.Dust[2]);
			for(int i  = 0; i < MetallurgyEnder.ores.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(MetallurgyEnder.ores.Dust[i], 1), ores.Dust[2]);
	    }
	    
	    //Nether Metals
		for(int i  = 0; i < alloys.numMetals; i++)
			ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new ItemStack(alloys.Dust[i], 1), ores.Dust[2]);
		for(int i  = 0; i < ores.numMetals; i++)
			ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), ores.Dust[i], ores.Dust[2]);
	    
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		ores.registerOres();
		alloys.registerOres();

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
	
	public void registerWithApi()
	{
		MetallurgyItems.registerItem("ignatiusSmelter", new ItemStack(NetherForge.metalFurnace, 1, 0));
		MetallurgyItems.registerItem("shadowIronSmelter", new ItemStack(NetherForge.metalFurnace, 1, 1));
		MetallurgyItems.registerItem("shadowSteelSmelter", new ItemStack(NetherForge.metalFurnace, 1, 2));
		MetallurgyItems.registerItem("vyroxeresSmelter", new ItemStack(NetherForge.metalFurnace, 1, 3));
		MetallurgyItems.registerItem("inolashiteSmelter", new ItemStack(NetherForge.metalFurnace, 1, 4));
		MetallurgyItems.registerItem("kalendriteSmelter", new ItemStack(NetherForge.metalFurnace, 1, 5));
		MetallurgyItems.registerItem("vulcaniteSmelter", new ItemStack(NetherForge.metalFurnace, 1, 6));
		MetallurgyItems.registerItem("sanguiniteSmelter", new ItemStack(NetherForge.metalFurnace, 1, 7));
	}
}