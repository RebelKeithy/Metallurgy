package shadow.mods.metallurgy.base;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.RecipeHelper;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_Iron;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
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

@Mod(modid = "MetallurgyBase", name = "Metallurgy Base", dependencies = "after:MetallurgyCore", version = "2.0.7.1")
@NetworkMod(channels = { "MetallurgyBase" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class MetallurgyBaseMetals {
	
	@SidedProxy(clientSide = "shadow.mods.metallurgy.base.ClientProxy", serverSide = "shadow.mods.metallurgy.base.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyBase" )
	public static MetallurgyBaseMetals instance;

	public static MetalSet alloys;
	public static MetalSet ores;
	
	public static Block metalFurnace;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigBase.init();
		
		alloys = new MetalSet(new AlloyBaseEnum());
		ores = new MetalSet(new OreBaseEnum());
		
		proxy.registerRenderInformation();

		metalFurnace = new BF_BlockMetalFurnace(ConfigBase.furnaceID, false).setHardness(3.5F).setBlockName("MetalFurnace");
		
		MinecraftForge.EVENT_BUS.register(new FurnaceUpgradeRecipes());
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.base.BF_BlockMetalFurnaceItem.class);

		ModLoader.registerTileEntity(BF_TileEntityMetalFurnace.class, "metalFurnace");
		
		alloys.load();
		ores.load();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		if(ConfigBase.furnacesEnabled)
			FurnaceUpgradeRecipes.load();
		
		try {
			Class a = Class.forName("ic2.api.Ic2Recipes");
			ItemStack battery = ic2.api.Items.getItem("reBattery");
			ItemStack ingot = ic2.api.Items.getItem("refinedIronIngot");
			ItemStack generator = ic2.api.Items.getItem("generator");
			GameRegistry.addRecipe(generator, new Object[] {
    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
    		});
			GameRegistry.addRecipe(generator, new Object[] {
    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
    		});
			
			battery = ic2.api.Items.getItem("chargedReBattery");
			GameRegistry.addRecipe(generator, new Object[] {
	    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 2)
	    		});
				GameRegistry.addRecipe(generator, new Object[] {
	    			" B ", "III", " F ", Character.valueOf('B'), battery, Character.valueOf('I'), ingot, Character.valueOf('F'), new ItemStack(metalFurnace, 1, 3)
	    		});
				
		} catch(Exception e) {}
		
		proxy.addNames();
	}

	@PostInit
	public void load(FMLPostInitializationEvent event) 
	{
		FMLLog.fine("Registering Base ores", "MetallurgyPrecious");
		ores.registerOres();
		alloys.registerOres();
    	
		
	    if(ConfigBase.alloyEnabled[0])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[0], 1), "itemDustCopper", "itemDustTin");
	    if(ConfigBase.alloyEnabled[1])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[1], 1), "itemDustBronze", "itemDustGold");
	    if(ConfigBase.alloyEnabled[2])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[2], 1), "itemDustBronze", "itemDustIron");
	    if(ConfigBase.alloyEnabled[3])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[3], 1), "itemDustGold", "itemDustIron");
	    if(ConfigBase.alloyEnabled[4])
	    	RecipeHelper.addAlloyRecipe(new ItemStack(alloys.Dust[4], 1), "itemDustIron", "itemDustManganese");
	}
}