package shadow.mods.metallurgy.precious;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigPrecious  {

	public static int PreciousMetalsVeinID;
	public static int PreciousMetalsBrickID;
	public static int PreciousAlloysBrickID;
	public static int oresBlockID;
	public static int alloysBlockID;
	public static int PreciousChestID;
	public static int PreciousMintID;
	public static int PreciousMintLoaderID;

	public static boolean[] alloyEnabled = new boolean[2];
	public static boolean[] metalEnabled = new boolean[3];
	public static boolean chestsEnabled;
	public static boolean tradesEnabled;
	public static boolean mintEnabled;

	public static int ItemStartID;

	public static int[] VeinCount = new int[3];
	public static int[] OreCount = new int[3];
	public static int[] OreHeight = new int[3];
	public static int[] OreMinHeight = new int[3];
	public static String dimensions;
	
	public static void init()
	{
		File file = new File(MetallurgyPrecious.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyPrecious.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyPrecious.cfg");
    	
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

    	for(int i = 0; i < 2; i++)
    		alloyEnabled[i] = config.get(AlloyPreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < 3; i++)
    		metalEnabled[i] = config.get(OrePreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
        
        PreciousMetalsVeinID = config.getBlock("Precious Metal Ore", 910).getInt(910);
        PreciousMetalsBrickID = config.getBlock("Precious Metal Brick", 911).getInt(911);
        PreciousAlloysBrickID = config.getBlock("Precious Alloy Brick", 912).getInt(912);
    	oresBlockID = config.getBlock("-_-", 935).getInt(935);
    	alloysBlockID = config.getBlock("Alloy Block", 936).getInt(936);
        PreciousChestID = config.getBlock("Chest", 913).getInt(913);
        PreciousMintID = config.getBlock("Mint", 914).getInt(914);
        PreciousMintLoaderID = config.getBlock("Mint auto ", 925).getInt(925);
        
    	chestsEnabled = config.get("Options", "Enable Chests", true).getBoolean(true);
    	tradesEnabled = config.get("Options", "Enable Trades", true).getBoolean(true);
    	mintEnabled = config.get("Options", "Enable Mint", true).getBoolean(true);

    	dimensions = config.get("Dimensions", "Dimensions", "0 2-100000").value;
    	
    	ItemStartID = config.get("Item Ids Uses next 250", "Item Start IDs", 26750).getInt(26750);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.get("Ore Generation", OrePreciousEnum.name[i] + " Vein Count", OrePreciousEnum.defaultVeinCount[i]).getInt(OrePreciousEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.get("Ore Generation", OrePreciousEnum.name[i] + " Ore Count", OrePreciousEnum.defaultOreCount[i]).getInt(OrePreciousEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.get("Ore Generation", OrePreciousEnum.name[i] + " Height", OrePreciousEnum.defaultOreHeight[i]).getInt(OrePreciousEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.get("Ore Generation", OrePreciousEnum.name[i] + " Minimum Height", 0).getInt(0);
    	}
        
    	config.save();
	}
}
