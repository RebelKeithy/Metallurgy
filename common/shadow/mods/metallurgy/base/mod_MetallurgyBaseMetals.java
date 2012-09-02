package shadow.mods.metallurgy.base;

import java.io.File;
import java.util.Map;
import java.util.Random;

import org.lwjgl.opengl.GL11;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.mod_Gold;
import shadow.mods.metallurgy.mod_Iron;

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

@Mod(modid = "MetallurgyBase", name = "Metallurgy Base", dependencies = "after:MetallurgyCore", version = "2.0.2")
@NetworkMod(channels = { "MetallurgyBase" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyBaseMetals {
	
	@SidedProxy(clientSide = "shadow.mods.metallurgy.base.ClientProxy", serverSide = "shadow.mods.metallurgy.base.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyBaseMetals instance;

	public static MetalSet alloys;
	public static MetalSet ores;
	
	public mod_MetallurgyBaseMetals() 
	{	
		instance = this;
	}
	
	public static Block metalFurnace;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		BaseConfig.init();
		
		alloys = new MetalSet(new AlloyBaseEnum());
		ores = new MetalSet(new OreBaseEnum());
		
		proxy.registerRenderInformation();

		metalFurnace = new BF_BlockMetalFurnace(BaseConfig.furnaceID, false).setHardness(3.5F).setBlockName("MetalFurnace");
	
		MinecraftForge.EVENT_BUS.register(ores);
		MinecraftForge.EVENT_BUS.register(alloys);
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(metalFurnace, shadow.mods.metallurgy.base.BF_BlockMetalFurnaceItem.class);

		ModLoader.registerTileEntity(BF_TileEntityMetalFurnace.class, "metalFurnace");
		
		alloys.load();
		ores.load();
		
		mod_Furnace.load();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		
		proxy.addNames();

	    if(BaseConfig.alloyEnabled[0])
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[0], 1), new Object[] {ores.Dust[0], ores.Dust[1]});
	    if(BaseConfig.alloyEnabled[1])
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[1], 1), new Object[] {alloys.Dust[0], mod_Gold.GoldDust});
	    if(BaseConfig.alloyEnabled[2])
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[2], 1), new Object[] {alloys.Dust[0], mod_Iron.IronDust});
	    if(BaseConfig.alloyEnabled[3])
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[3], 1), new Object[] {mod_Gold.GoldDust, mod_Iron.IronDust});
	    if(BaseConfig.alloyEnabled[4])
	    	ModLoader.addShapelessRecipe(new ItemStack(alloys.Dust[4], 1), new Object[] {mod_Iron.IronDust, ores.Dust[2]});
	}
}