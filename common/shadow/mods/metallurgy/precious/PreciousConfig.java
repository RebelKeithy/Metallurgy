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

    	for(int i = 0; i < 2; i++)
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyPreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < 3; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OrePreciousEnum.name[i] + " Enabled", "Ores", true).getBoolean(true);
        
        PreciousMetalsVeinID = config.getOrCreateBlockIdProperty("Precious Metal Ore", 910).getInt(910);
        PreciousMetalsBrickID = config.getOrCreateBlockIdProperty("Precious Metal Brick", 911).getInt(911);
        PreciousAlloysBrickID = config.getOrCreateBlockIdProperty("Precious Alloy Brick", 912).getInt(912);

    	ItemStartID = config.getOrCreateIntProperty("Item Start IDs", "Item Ids Uses next 250", 26750).getInt(26750);
    	
    	for(int i = 0; i < 3; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Vein Count", "Ore Generation", OrePreciousEnum.defaultVeinCount[i]).getInt(OrePreciousEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Ore Count", "Ore Generation", OrePreciousEnum.defaultOreCount[i]).getInt(OrePreciousEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OrePreciousEnum.name[i] + " Height", "Ore Generation", OrePreciousEnum.defaultOreHeight[i]).getInt(OrePreciousEnum.defaultOreHeight[i]);
    	}
        
    	config.save();
	}
}
