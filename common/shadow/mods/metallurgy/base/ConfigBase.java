package shadow.mods.metallurgy.base;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.precious.AlloyPreciousEnum;
import shadow.mods.metallurgy.precious.OrePreciousEnum;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigBase  {

	public static int baseMetalsVeinID;
	public static int baseMetalsBrickID;
	public static int baseAlloysBrickID;
	public static int furnaceID;

	public static boolean[] alloyEnabled = new boolean[5];
	public static boolean[] metalEnabled = new boolean[3];
	
	public static boolean furnacesEnabled;
	public static boolean railsEnabled;

	public static double copperSpeed;
	public static double bronzeSpeed;
	public static double ironSpeed;
	public static double steelSpeed;

	public static int ItemStartID;

	public static int[] VeinCount = new int[8];
	public static int[] OreCount = new int[8];
	public static int[] OreHeight = new int[8];
	public static int[] OreMinHeight = new int[8];
	public static String dimensions;
	
	
	
	public static void init()
	{
		File file = new File(mod_MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyBase.cfg");
    	
        try
        {
            newFile.createNewFile();
            System.out.println("Successfully created/read configuration file");
        }
        catch (IOException e)
        {
            System.out.println("Could not create configuration file for mod_MetallugyBase. Reason:");
            System.out.println(e);
        }

        /* [Forge] Configuration class, used as config method */
        Configuration config = new Configuration(newFile);

        /* Load the configuration file */
        config.load();
        
        
    	baseMetalsVeinID = config.getOrCreateBlockIdProperty("Metal Ore", 901).getInt(900);
    	baseMetalsBrickID = config.getOrCreateBlockIdProperty("Metal Brick", 902).getInt(901);
    	baseAlloysBrickID = config.getOrCreateBlockIdProperty("Alloy Brick", 903).getInt(902);
    	furnaceID = config.getOrCreateBlockIdProperty("Furnace", 904).getInt(904);
    	
    	dimensions = config.getOrCreateProperty("Dimensions", "Dimensions", "0").value;
    	
    	furnacesEnabled = config.getOrCreateBooleanProperty("Enable Furnaces", "Machines", true).getBoolean(true);
    	railsEnabled = config.getOrCreateBooleanProperty("Enable Rail Recipes", "Machines", true).getBoolean(true);
        
    	copperSpeed = config.getOrCreateIntProperty("Copper Speed", "Furnaces", 9500).getInt(9500)/1000f;
    	bronzeSpeed = config.getOrCreateIntProperty("Bronze Speed", "Furnaces", 9000).getInt(9000)/1000f;
    	ironSpeed = config.getOrCreateIntProperty("Iron Speed", "Furnaces", 8000).getInt(8000)/1000f;
    	steelSpeed = config.getOrCreateIntProperty("Steel Speed", "Furnaces", 7000).getInt(7000)/1000f;
    	

    	for(int i = 0; i < 5; i++)
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyBaseEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < 3; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OreBaseEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);
        
    	ItemStartID = config.getOrCreateIntProperty("Item Start IDs", "Item Ids Uses next 250", 26250).getInt(26250);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OreBaseEnum.names[i] + " Vein Count", "Ore Generation", OreBaseEnum.defaultVeinCount[i]).getInt(OreBaseEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OreBaseEnum.names[i] + " Ore Count", "Ore Generation", OreBaseEnum.defaultOreCount[i]).getInt(OreBaseEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OreBaseEnum.names[i] + " Height", "Ore Generation", OreBaseEnum.defaultOreHeight[i]).getInt(OreBaseEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.getOrCreateIntProperty(OreBaseEnum.names[i] + " Minimum Height", "Ore Generation", 0).getInt(0);
    	}
        
    	
    	config.save();
	}
}
