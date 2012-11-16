package shadow.mods.metallurgy.ender;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigEnder  {

	public static int EnderMetalsVeinID;
	public static int EnderMetalsBrickID;
	public static int EnderAlloysBrickID;
	public static int oresBlockID;
	public static int alloysBlockID;
	
	public static boolean[] alloyEnabled = new boolean[1];
	public static boolean[] metalEnabled = new boolean[2];

	public static int[] VeinCount = new int[2];
	public static int[] OreCount = new int[2];
	public static int[] OreHeight = new int[2];
	public static int[] OreMinHeight = new int[2];
	
	public static int[] alloyItemIds = new int[1];
	public static int[] metalItemIds = new int [2];
	public static String dimensions;
	
	
	public static void init()
	{
		File file = new File(MetallurgyEnder.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyEnder.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyEnder.cfg");
    	
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
        
        
    	EnderMetalsVeinID = config.getBlock("Metal Ore", 924).getInt(924);
    	EnderMetalsBrickID = config.getBlock("Metal Brick", 925).getInt(925);
    	EnderAlloysBrickID = config.getBlock("Alloy Brick", 926).getInt(926);
    	oresBlockID = config.getBlock("Metal Block", 937).getInt(937);
    	alloysBlockID = config.getBlock("Alloy Block", 938).getInt(938);

    	dimensions = config.get("Dimensions", "Dimensions", "1").value;
    	
    	for(int i = 0; i < 1; i++)
    		alloyEnabled[i] = config.get("Ores", AlloyEnderEnum.names[i] + " Enabled", true).getBoolean(true);
    	for(int i = 0; i < 2; i++)
    		metalEnabled[i] = config.get("Ores", OreEnderEnum.names[i] + " Enabled", true).getBoolean(true);

    	for(int i = 0; i < 2; i++)
    	{
    		metalItemIds[i] = config.get("Item Ids uses next 50", OreEnderEnum.names[i] + " item ids", 28500 + (i * 50)).getInt(28500 + (i * 50));
    	}
    	
    	for(int i = 0; i < 1; i++)
    	{
    		alloyItemIds[i] = config.get("Item Ids uses next 50", AlloyEnderEnum.names[i] + " item ids", 28600 + (i * 50)).getInt(28600 + (i * 50));
    	}
    	
    	for(int i = 0; i < 2; i++)
    	{
	    	VeinCount[i] = config.get("Ore Generation", OreEnderEnum.names[i] + " Vein Count", OreEnderEnum.defaultVeinCount[i]).getInt(OreEnderEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.get("Ore Generation", OreEnderEnum.names[i] + " Ore Count", OreEnderEnum.defaultOreCount[i]).getInt(OreEnderEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.get("Ore Generation", OreEnderEnum.names[i] + " Height", OreEnderEnum.defaultOreHeight[i]).getInt(OreEnderEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.get("Ore Generation", OreEnderEnum.names[i] + " Minimum Height", 0).getInt(0);
    	}
    
    	config.save();
	}
}
