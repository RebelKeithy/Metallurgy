package shadow.mods.metallurgy.ender;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class EnderConfig  {

	public static int EnderMetalsVeinID;
	public static int EnderMetalsBrickID;
	public static int EnderAlloysBrickID;
	
	public static boolean[] alloyEnabled = new boolean[1];
	public static boolean[] metalEnabled = new boolean[2];

	public static int[] VeinCount = new int[2];
	public static int[] OreCount = new int[2];
	public static int[] OreHeight = new int[2];
	
	public static int[] alloyItemIds = new int[1];
	public static int[] metalItemIds = new int [2];
	
	
	public static void init()
	{
		File file = new File(mod_MetallurgyEnder.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyEnder.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyEnder.cfg");
    	
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
        
        
    	EnderMetalsVeinID = config.getOrCreateBlockIdProperty("Metal Ore", 924).getInt(924);
    	EnderMetalsBrickID = config.getOrCreateBlockIdProperty("Metal Brick", 925).getInt(925);
    	EnderAlloysBrickID = config.getOrCreateBlockIdProperty("Alloy Brick", 926).getInt(926);

    	for(int i = 0; i < 1; i++)
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyEnderEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < 2; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OreEnderEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);

    	for(int i = 0; i < 2; i++)
    	{
    		metalItemIds[i] = config.getOrCreateIntProperty(OreEnderEnum.names[i] + " item ids", "Item Ids uses next 50", 28500 + (i * 50)).getInt(28500 + (i * 50));
    	}
    	
    	for(int i = 0; i < 1; i++)
    	{
    		alloyItemIds[i] = config.getOrCreateIntProperty(AlloyEnderEnum.names[i] + " item ids", "Item Ids uses next 50", 28600 + (i * 50)).getInt(28600 + (i * 50));
    	}
    	
    	for(int i = 0; i < 2; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OreEnderEnum.names[i] + " Vein Count", "Ore Generation", OreEnderEnum.defaultVeinCount[i]).getInt(OreEnderEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OreEnderEnum.names[i] + " Ore Count", "Ore Generation", OreEnderEnum.defaultOreCount[i]).getInt(OreEnderEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OreEnderEnum.names[i] + " Height", "Ore Generation", OreEnderEnum.defaultOreHeight[i]).getInt(OreEnderEnum.defaultOreHeight[i]);
    	}
    
    	config.save();
	}
}
