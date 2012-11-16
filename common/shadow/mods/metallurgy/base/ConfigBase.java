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
	public static int baseMetalsBlockID;
	public static int baseAlloysBlockID;
	public static int itemDoorID;
	public static int doorID;
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
		File file = new File(MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyBase.cfg");
    	
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
        
        
    	baseMetalsVeinID = config.getBlock("Metal Ore", 901).getInt(900);
    	baseMetalsBrickID = config.getBlock("Metal Brick", 902).getInt(901);
    	baseAlloysBrickID = config.getBlock("Alloy Brick", 903).getInt(902);
    	baseMetalsBlockID = config.getBlock("Metal Block", 929).getInt(929);
    	baseAlloysBlockID = config.getBlock("Alloy Block", 930).getInt(930);
    	doorID = config.getBlock("Copper Door", 935).getInt(935);
    	furnaceID = config.getBlock("Furnace", 904).getInt(904);
    	itemDoorID = config.getItem("Copper Door", 926).getInt(9350);
    	
    	dimensions = config.get("Dimensions", "Dimensions", "0 2-10000").value;
    	
    	furnacesEnabled = config.get("Machines", "Enable Furnaces", true).getBoolean(true);
    	railsEnabled = config.get("Machines", "Enable Rail Recipes", true).getBoolean(true);
        
    	copperSpeed = config.get("Furnaces", "Copper Speed", 9500).getInt(9500)/1000f;
    	bronzeSpeed = config.get("Furnaces", "Bronze Speed", 9000).getInt(9000)/1000f;
    	ironSpeed = config.get("Furnaces", "Iron Speed", 8000).getInt(8000)/1000f;
    	steelSpeed = config.get("Furnaces", "Steel Speed", 7000).getInt(7000)/1000f;
    	

    	for(int i = 0; i < 5; i++)
    		alloyEnabled[i] = config.get("Ores", AlloyBaseEnum.names[i] + " Enabled", true).getBoolean(true);
    	for(int i = 0; i < 3; i++)
    		metalEnabled[i] = config.get("Ores", OreBaseEnum.names[i] + " Enabled", true).getBoolean(true);
        
    	ItemStartID = config.get("Item Ids Uses next 250", "Item Start IDs", 26250).getInt(26250);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.get("Ore Generation", OreBaseEnum.names[i] + " Vein Count", OreBaseEnum.defaultVeinCount[i]).getInt(OreBaseEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.get("Ore Generation", OreBaseEnum.names[i] + " Ore Count", OreBaseEnum.defaultOreCount[i]).getInt(OreBaseEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.get("Ore Generation", OreBaseEnum.names[i] + " Height", OreBaseEnum.defaultOreHeight[i]).getInt(OreBaseEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.get("Ore Generation", OreBaseEnum.names[i] + " Minimum Height", 0).getInt(0);
    	}
        
    	
    	config.save();
	}
}
