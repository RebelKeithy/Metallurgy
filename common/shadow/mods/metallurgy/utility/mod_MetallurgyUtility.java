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

@Mod(modid = "MetallurgyUtility", name = "Metallurgy Utility", dependencies = "after:MetallurgyCore", version = "2.0.6")
@NetworkMod(channels = { "MetallurgyUtilit" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyUtility
{
	@SidedProxy(clientSide = "shadow.mods.metallurgy.utility.ClientProxy", serverSide = "shadow.mods.metallurgy.utility.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance( value = "MetallurgyUtility")
	public static mod_MetallurgyUtility instance;

	public static Block vein;
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigUtility.init();
	
		vein = new BlockVein(ConfigUtility.veinID, "/shadow/MetallurgyUtilityOres.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("UtilityVein");
		MinecraftForge.EVENT_BUS.register(this);
	}

	@Init
	public void load(FMLInitializationEvent event) 
	{

		proxy.registerRenderInformation();
		proxy.addNames();

		GameRegistry.registerWorldGenerator(new UtilityWorldGen());
		
		GameRegistry.registerBlock(vein, BlockVeinItem.class);
		
		
		mod_Phosphorite.load();
		mod_Sulfur.load();
		mod_Saltpeter.load();
		mod_Magnesium.load();
		mod_Bitumen.load();
		mod_Potash.load();
		
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
		OreDictionary.registerOre("bitumen", new ItemStack(mod_Bitumen.bitumen, 1));
		OreDictionary.registerOre("magnesium", new ItemStack(mod_Magnesium.magnesium, 1));
		OreDictionary.registerOre("phosphorite", new ItemStack(mod_Phosphorite.phosphorite, 1));
		OreDictionary.registerOre("potash", new ItemStack(mod_Potash.potash, 1));
		OreDictionary.registerOre("saltpeter", new ItemStack(mod_Saltpeter.saltpeter, 1));
		OreDictionary.registerOre("sulfur", new ItemStack(mod_Sulfur.sulfur, 1));
		
		OreDictionary.registerOre("itemBitumen", mod_Bitumen.bitumen);
		OreDictionary.registerOre("itemTar", mod_Bitumen.tar);
		OreDictionary.registerOre("itemMagnesium", mod_Magnesium.magnesium);
		OreDictionary.registerOre("itemPhosphorus", mod_Phosphorite.phosphorus);
		OreDictionary.registerOre("itemPotash", mod_Potash.potash);
		OreDictionary.registerOre("itemSaltpeter", mod_Saltpeter.saltpeter);
		OreDictionary.registerOre("itemSulfur", mod_Sulfur.sulfur);
	}
	
    @ForgeSubscribe
    public void oreRegistered(OreRegisterEvent event)
    {
    	if(event.Name.equals("itemMagnesium"))
    	{
    		for(ItemStack phosphorus : OreDictionary.getOres("itemPhosphorus"))
    			for(ItemStack potash : OreDictionary.getOres("itemPotash"))	
    				ModLoader.addShapelessRecipe(new ItemStack(mod_Potash.fertilizer, 4), new Object[] {phosphorus, event.Ore, potash});
    	}
    	if(event.Name.equals("itemPhosphorus"))
    	{
    		for(ItemStack magnesium : OreDictionary.getOres("itemMagnesium"))
    			for(ItemStack potash : OreDictionary.getOres("itemPotash"))	
    				ModLoader.addShapelessRecipe(new ItemStack(mod_Potash.fertilizer, 4), new Object[] {event.Ore, magnesium, potash});
    	}
    	if(event.Name.equals("itemPotash"))
    	{
    		for(ItemStack magnesium : OreDictionary.getOres("itemMagnesium"))
    			for(ItemStack phosphorus : OreDictionary.getOres("itemPhosphorus"))	
    				ModLoader.addShapelessRecipe(new ItemStack(mod_Potash.fertilizer, 4), new Object[] {phosphorus, magnesium, event.Ore});
    	}

    	if(event.Name.equals("itemSaltpeter"))
    	{
    		for(ItemStack sulfur : OreDictionary.getOres("itemSulfur"))
    			ModLoader.addShapelessRecipe(new ItemStack(Item.gunpowder, 4), new Object[] {new ItemStack(Item.coal, 1, 1), event.Ore, sulfur});
    	}
    	if(event.Name.equals("itemSulfur"))
    	{
    		for(ItemStack saltpeter : OreDictionary.getOres("itemSaltpeter"))
    			ModLoader.addShapelessRecipe(new ItemStack(Item.gunpowder, 4), new Object[] {new ItemStack(Item.coal, 1, 1), saltpeter, event.Ore});
    	}
    }
}
