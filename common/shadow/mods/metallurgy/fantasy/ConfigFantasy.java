package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import shadow.mods.metallurgy.nether.AlloyNetherEnum;
import shadow.mods.metallurgy.nether.OreNetherEnum;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigFantasy  {

	public static int FantasyMetalsVeinID;
	public static int FantasyMetalsBrickID;
	public static int FantasyAlloysBrickID;
	public static int oresBlockID;
	public static int alloysBlockID;
	public static int furnaceID;

	public static boolean[] alloyEnabled = new boolean[5];
	public static boolean[] metalEnabled = new boolean[12];
	public static boolean furnaceEnabled;
	
	public static float[] extractorSpeeds = new float[11];
	public static int[] xpBonus = new int[11];
	
	public static int ItemStartID;

	public static int[] VeinCount = new int[12];
	public static int[] OreCount = new int[12];
	public static int[] OreHeight = new int[12];
	public static int[] OreMinHeight = new int[12];
	public static int dimensionID;
	public static String dimensions;
	
	public static void init()
	{
		File file = new File(MetallurgyFantasy.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyFantasy.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyFantasy.cfg");
    	
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
        
        furnaceEnabled = config.get("Enable Abstractors", "Machines", true).getBoolean(true);
        
        FantasyMetalsVeinID = config.getBlock("Metal Ore", 919).getInt(919);
    	FantasyMetalsBrickID = config.getBlock("Metal Brick", 920).getInt(920);
    	FantasyAlloysBrickID = config.getBlock("Alloy Brick", 921).getInt(921);
    	oresBlockID = config.getBlock("Metal Block", 933).getInt(933);
    	alloysBlockID = config.getBlock("Alloy Block", 934).getInt(934);
    	furnaceID = config.getBlock("Abstractor", 922).getInt(922);

    	dimensions = config.get("Dimensions", "Dimensions", "0 2-100000").value;
    	
    	extractorSpeeds[0] = config.get("Abstractor Speeds", "Prometheum", 22000).getInt(22000)/1000f;    	
    	extractorSpeeds[1] = config.get("Abstractor Speeds", "DeepIron", 20000).getInt(20000)/1000f;    	
    	extractorSpeeds[2] = config.get("Abstractor Speeds", "BlackSteel", 18000).getInt(18000)/1000f;    	
    	extractorSpeeds[3] = config.get("Abstractor Speeds", "Oureclase", 16000).getInt(16000)/1000f;    	
    	extractorSpeeds[4] = config.get("Abstractor Speeds", "Aredrite", 14000).getInt(14000)/1000f;    	
    	extractorSpeeds[5] = config.get("Abstractor Speeds", "Mithril", 12000).getInt(12000)/1000f;    	
    	extractorSpeeds[6] = config.get("Abstractor Speeds", "Haderoth", 10000).getInt(10000)/1000f;    	
    	extractorSpeeds[7] = config.get("Abstractor Speeds", "Orichalcum", 8000).getInt(8000)/1000f;    	
    	extractorSpeeds[8] = config.get("Abstractor Speeds", "Adamantine", 6000).getInt(6000)/1000f;    	
    	extractorSpeeds[9] = config.get("Abstractor Speeds", "Atlarus", 4000).getInt(4000)/1000f;    	    	
    	extractorSpeeds[10] = config.get("Abstractor Speeds", "Tartarite", 2000).getInt(2000)/1000f;
    	
    	xpBonus[0] = config.get("Abstractor Bonus", "Prometheum", 10).getInt(10); 
    	xpBonus[1] = config.get("Abstractor Bonus", "DeepIron", 12).getInt(12); 
    	xpBonus[2] = config.get("Abstractor Bonus", "BlackSteel", 14).getInt(14); 
    	xpBonus[3] = config.get("Abstractor Bonus", "Oureclase", 16).getInt(16); 
    	xpBonus[4] = config.get("Abstractor Bonus", "Aredrite", 18).getInt(18); 
    	xpBonus[5] = config.get("Abstractor Bonus", "Mithril", 20).getInt(20); 
    	xpBonus[6] = config.get("Abstractor Bonus", "Haderoth", 24).getInt(24); 
    	xpBonus[7] = config.get("Abstractor Bonus", "Orichalcum", 28).getInt(28); 
    	xpBonus[8] = config.get("Abstractor Bonus", "Adamantine", 32).getInt(32); 
    	xpBonus[9] = config.get("Abstractor Bonus", "Atlarus", 36).getInt(36); 
    	xpBonus[10] = config.get("Abstractor Bonus", "Tartarite", 40).getInt(40); 

    	for(int i = 0; i < AlloyFantasyEnum.numMetals; i++)
    		alloyEnabled[i] = config.get("Ores", AlloyFantasyEnum.names[i] + " Enabled", true).getBoolean(true);
    	for(int i = 0; i < OreFantasyEnum.numMetals; i++)
    		metalEnabled[i] = config.get("Ores", OreFantasyEnum.names[i] + " Enabled", true).getBoolean(true);

    	ItemStartID = config.getItem("Item Ids Uses next 850", "Item Start IDs", 27550).getInt(27550);

    	for(int i = 0; i < OreFantasyEnum.numMetals; i++)
    	{
	    	VeinCount[i] = config.get("Ore Generation", OreFantasyEnum.names[i] + " Vein Count", OreFantasyEnum.defaultVeinCount[i]).getInt(OreFantasyEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.get("Ore Generation", OreFantasyEnum.names[i] + " Ore Count", OreFantasyEnum.defaultOreCount[i]).getInt(OreFantasyEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.get("Ore Generation", OreFantasyEnum.names[i] + " Height", OreFantasyEnum.defaultOreHeight[i]).getInt(OreFantasyEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.get("Ore Generation", OreFantasyEnum.names[i] + " Minimum Height", 0).getInt(0);
    	}
    	
    	config.save();
	}
}
