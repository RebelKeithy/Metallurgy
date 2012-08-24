package shadow.mods.metallurgy;
import java.io.File;
import org.lwjgl.opengl.GL11;

import shadow.mods.metallurgy.*;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


import java.util.Iterator;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "MetallurgyCore", name = "Metallurgy Core", version = "1.3")
@NetworkMod(channels = { "MetallurgyCore" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyCore
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.CoreClientProxy", serverSide = "shadow.mods.metallurgy.CoreCommonProxy")
	public static CoreCommonProxy proxy;

	@Instance
	public static mod_MetallurgyCore instance;
	
	public static CoreConfig config;
	
	public static boolean hasBase;
	public static boolean hasNether;
	public static boolean hasPrecious;
	public static boolean hasFantasy;

	public static Block crusher;

	public mod_MetallurgyCore()
	{
		instance = this;
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		config.init();
		crusher = new BC_BlockCrusher(CoreConfig.crusherID, false).setHardness(3.5F).setBlockName("Crusher").setCreativeTab(CreativeTabs.tabDeco);

		proxy.registerRenderInformation();

	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		Iterator iterator = ModLoader.getLoadedMods().iterator();
		do
	    {	     
	    	if (!iterator.hasNext())
	    	{
	    		break;
	    	}
	    	Object obj = iterator.next();
	    	if (obj.getClass().getName().endsWith("mod_MetallurgyBaseMetals"))
		    	hasBase = true;
	    	if (obj.getClass().getName().endsWith("mod_MetallurgyPrecious"))
		    	hasPrecious = true;
	    	if (obj.getClass().getName().endsWith("mod_MetallurgyNether"))
		    	hasNether = true;
	    	if (obj.getClass().getName().endsWith("mod_MetallurgyFantasy"))
		    	hasFantasy = true;
	    	
	    }
	    while (true);
		
		GameRegistry.registerWorldGenerator(new CoreWorldGen());
		
		MinecraftForge.setToolClass(Item.pickaxeWood, "pickaxe", 1);
		MinecraftForge.setToolClass(Item.pickaxeStone, "pickaxe", 2);
		MinecraftForge.setToolClass(Item.pickaxeSteel, "pickaxe", 3);
		MinecraftForge.setToolClass(Item.pickaxeDiamond, "pickaxe", 4);
		
		MinecraftForge.setBlockHarvestLevel(Block.oreIron, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.oreRedstone, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.oreRedstoneGlowing, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.oreLapis, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.oreDiamond, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.oreGold, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(Block.obsidian, "pickaxe", 4);

		NetworkRegistry.instance().registerGuiHandler(instance, proxy);

		proxy.addNames();
		proxy.registerRenderInformation();
		ModLoader.registerBlock(crusher, shadow.mods.metallurgy.BC_BlockCrusherItem.class);
		ModLoader.registerTileEntity(BC_TileEntityCrusher.class, "crusher");
		mod_Crusher.load();
		
		mod_MetallurgyTextureOverride.load();
		//mod_MetallurgyzAchievements.load();
		
	    

	}
}