package shadow.mods.metallurgy.precious;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
import shadow.mods.metallurgy.nether.AlloyNether;
import shadow.mods.metallurgy.nether.OreNether;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class PreciousConfig  {

	public static int PreciousMetalsVeinID;
	public static int PreciousMetalsBrickID;
	public static int PreciousAlloysBrickID;

	public static boolean[] alloyEnabled = new boolean[2];
	public static boolean[] metalEnabled = new boolean[3];
	
	public static int ItemZincDustID;
	public static int ItemZincBarID;

	public static int ItemStartID;

	public static int[] VeinCount = new int[8];
	public static int[] OreCount = new int[8];
	public static int[] OreHeight = new int[8];
	
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

    	for(int i = 0; i < AlloyPrecious.numAlloys; i++)
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyPrecious.name[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < OrePrecious.numMetals; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OrePrecious.name[i] + " Enabled", "Ores", true).getBoolean(true);
        
        PreciousMetalsVeinID = config.getOrCreateBlockIdProperty("Precious Metal Ore", 903).getInt(903);
        PreciousMetalsBrickID = config.getOrCreateBlockIdProperty("Precious Metal Brick", 904).getInt(904);
        PreciousAlloysBrickID = config.getOrCreateBlockIdProperty("Precious Alloy Brick", 905).getInt(905);

    	ItemStartID = config.getOrCreateIntProperty("Item Start IDs", "Item Ids Uses next 250", 26750).getInt(26750);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OrePrecious.name[i] + " Vein Count", "Ore Generation", OrePrecious.defaultVeinCount[i]).getInt(OrePrecious.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OrePrecious.name[i] + " Ore Count", "Ore Generation", OrePrecious.defaultOreCount[i]).getInt(OrePrecious.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OrePrecious.name[i] + " Height", "Ore Generation", OrePrecious.defaultOreHeight[i]).getInt(OrePrecious.defaultOreHeight[i]);
    	}
        
    	config.save();
	}
}
