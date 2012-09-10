package shadow.mods.metallurgy.precious;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigPrecious  {

	public static int PreciousMetalsVeinID;
	public static int PreciousMetalsBrickID;
	public static int PreciousAlloysBrickID;
	public static int PreciousMintID;
	public static int PreciousMintLoaderID;

	public static boolean[] alloyEnabled = new boolean[2];
	public static boolean[] metalEnabled = new boolean[3];

	public static int ItemStartID;

	public static int[] VeinCount = new int[3];
	public static int[] OreCount = new int[3];
	public static int[] OreHeight = new int[3];
	public static int[] OreMinHeight = new int[3];
	public static String dimensions;
	
	public static void init()
	{
		File file = new File(mod_MetallurgyPrecious.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyPrecious.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyPrecious.cfg");
    	
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
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyPreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < 3; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OrePreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
        
        PreciousMetalsVeinID = config.getOrCreateBlockIdProperty("Precious Metal Ore", 910).getInt(910);
        PreciousMetalsBrickID = config.getOrCreateBlockIdProperty("Precious Metal Brick", 911).getInt(911);
        PreciousAlloysBrickID = config.getOrCreateBlockIdProperty("Precious Alloy Brick", 912).getInt(912);
        PreciousMintID = config.getOrCreateBlockIdProperty("Mint", 914).getInt(914);
        PreciousMintLoaderID = config.getOrCreateBlockIdProperty("Mint Loader", 925).getInt(925);

    	dimensions = config.getOrCreateProperty("Dimensions", "Dimensions", "0 2-100000").value;
    	
    	ItemStartID = config.getOrCreateIntProperty("Item Start IDs", "Item Ids Uses next 250", 26750).getInt(26750);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Vein Count", "Ore Generation", OrePreciousEnum.defaultVeinCount[i]).getInt(OrePreciousEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Ore Count", "Ore Generation", OrePreciousEnum.defaultOreCount[i]).getInt(OrePreciousEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Height", "Ore Generation", OrePreciousEnum.defaultOreHeight[i]).getInt(OrePreciousEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Minimum Height", "Ore Generation", 0).getInt(0);
    	}
        
    	config.save();
	}
}
