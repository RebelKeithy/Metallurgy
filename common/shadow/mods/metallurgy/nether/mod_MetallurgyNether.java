package shadow.mods.metallurgy.nether;
import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_Iron;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_MetallurgyCore;
import shadow.mods.metallurgy.base.OreBaseEnum;
import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.base.AlloyBaseEnum;
import shadow.mods.metallurgy.precious.mod_MetallurgyPrecious;

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
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyNether", name = "Metallurgy Nether", dependencies = "after:MetallurgyCore", version = "2.0.2")
@NetworkMod(channels = { "MetallurgyNether" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyNether
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.nether.ClientProxy", serverSide = "shadow.mods.metallurgy.nether.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyNether instance;
	
	public static MetalSet alloys;
	public static MetalSet ores;	
	
	public mod_MetallurgyNether()
	{
		instance = this;
	}

	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		NetherConfig.init();

		alloys = new MetalSet(new AlloyNetherEnum());
		ores = new MetalSet(new OreNetherEnum());
		
		mod_NetherForge.init();
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(mod_NetherForge.metalFurnace, NF_BlockNetherForgeItem.class);
		GameRegistry.registerTileEntity(NF_TileEntityNetherForge.class, "netherFurnace");
	
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		proxy.registerRenderInformation();
		proxy.addNames();
		proxy.addArmor();
		
		ores.load();
		alloys.load();
		
		mod_NetherForge.load();
		
		GameRegistry.registerFuelHandler(new NetherFuelDust());
		
		addMidasiumRecipes();

		ModLoader.addRecipe(new ItemStack(Item.blazeRod, 1), new Object[] {
			"X", "X", Character.valueOf('X'), ores.Bar[6]
		});
		
		GameRegistry.registerWorldGenerator(new ObsidianSpawns());
		
		ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), new Object[] {ores.Dust[0], ores.Dust[0], ores.Dust[1]});
	    ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), new Object[] {ores.Dust[3], ores.Dust[4]});
	    if(mod_MetallurgyCore.hasPrecious)
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new Object[] {new ItemStack(mod_MetallurgyPrecious.ores.Dust[2], 1), ores.Dust[5]});
	}
	
	public static void addMidasiumRecipes()
	{	    
		
		ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_Iron.IronDust, 1), ores.Dust[2]});
		ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_Gold.GoldDust, 1), ores.Dust[2]});
		
		if(mod_MetallurgyCore.hasBase)
	    {
			for(int i  = 0; i < AlloyBaseEnum.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_MetallurgyBaseMetals.alloys.Dust[i], 1), ores.Dust[2]});
			for(int i  = 0; i < OreBaseEnum.numMetals; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_MetallurgyBaseMetals.ores.Dust[i], 1), ores.Dust[2]});
		}
	    //Precious Metals
	    if(mod_MetallurgyCore.hasPrecious)
	    {
			for(int i  = 0; i < 2; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_MetallurgyPrecious.alloys.Dust[i], 1), ores.Dust[2]});
			for(int i  = 0; i < 3; i++)
				ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(mod_MetallurgyPrecious.ores.Dust[i], 1), ores.Dust[2]});
	    }
	    
	    //Nether Metals
		for(int i  = 0; i < 3; i++)
			ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {new ItemStack(alloys.Dust[i], 1), ores.Dust[2]});
		for(int i  = 0; i < 8; i++)
			ModLoader.addShapelessRecipe(new ItemStack(mod_Gold.GoldDust, 1), new Object[] {ores.Dust[i], ores.Dust[2]});
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		/*
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "dustDeep Iron", "dustInfuscolium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "dustMithril", "dustSilver");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "dustMithril", "dustRubracium");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "dustOrichalcum", "dustPlatinum");
		RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "dustAdamantine", "dustAtlarus");
		*/
	}
}