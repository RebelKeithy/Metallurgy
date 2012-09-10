package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;
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
		File file = new File(mod_MetallurgyFantasy.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyFantasy.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyFantasy.cfg");
    	
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
        
        FantasyMetalsVeinID = config.getOrCreateBlockIdProperty("Metal Ore", 919).getInt(919);
    	FantasyMetalsBrickID = config.getOrCreateBlockIdProperty("Metal Brick", 920).getInt(920);
    	FantasyAlloysBrickID = config.getOrCreateBlockIdProperty("Alloy Brick", 921).getInt(921);

    	dimensions = config.getOrCreateProperty("Dimensions", "Dimensions", "0 2-100000").value;
    	
    	extractorSpeeds[0] = config.getOrCreateIntProperty("Prometheum", "Abstractor Speeds", 22000).getInt(22000)/1000f;    	
    	extractorSpeeds[1] = config.getOrCreateIntProperty("DeepIron", "Abstractor Speeds", 20000).getInt(20000)/1000f;    	
    	extractorSpeeds[2] = config.getOrCreateIntProperty("BlackSteel", "Abstractor Speeds", 18000).getInt(18000)/1000f;    	
    	extractorSpeeds[3] = config.getOrCreateIntProperty("Oureclase", "Abstractor Speeds", 16000).getInt(16000)/1000f;    	
    	extractorSpeeds[4] = config.getOrCreateIntProperty("Aredrite", "Abstractor Speeds", 14000).getInt(14000)/1000f;    	
    	extractorSpeeds[5] = config.getOrCreateIntProperty("Mithril", "Abstractor Speeds", 12000).getInt(12000)/1000f;    	
    	extractorSpeeds[6] = config.getOrCreateIntProperty("Haderoth", "Abstractor Speeds", 10000).getInt(10000)/1000f;    	
    	extractorSpeeds[7] = config.getOrCreateIntProperty("Orichalcum", "Abstractor Speeds", 8000).getInt(8000)/1000f;    	
    	extractorSpeeds[8] = config.getOrCreateIntProperty("Adamantine", "Abstractor Speeds", 6000).getInt(6000)/1000f;    	
    	extractorSpeeds[9] = config.getOrCreateIntProperty("Atlarus", "Abstractor Speeds", 4000).getInt(4000)/1000f;    	    	
    	extractorSpeeds[10] = config.getOrCreateIntProperty("Tartarite", "Abstractor Speeds", 2000).getInt(2000)/1000f;
    	
    	xpBonus[0] = config.getOrCreateIntProperty("Prometheum", "Abstractor Bonus", 10).getInt(10); 
    	xpBonus[1] = config.getOrCreateIntProperty("DeepIron", "Abstractor Bonus", 12).getInt(12); 
    	xpBonus[2] = config.getOrCreateIntProperty("BlackSteel", "Abstractor Bonus", 14).getInt(14); 
    	xpBonus[3] = config.getOrCreateIntProperty("Oureclase", "Abstractor Bonus", 16).getInt(16); 
    	xpBonus[4] = config.getOrCreateIntProperty("Aredrite", "Abstractor Bonus", 18).getInt(18); 
    	xpBonus[5] = config.getOrCreateIntProperty("Mithril", "Abstractor Bonus", 20).getInt(20); 
    	xpBonus[6] = config.getOrCreateIntProperty("Haderoth", "Abstractor Bonus", 24).getInt(24); 
    	xpBonus[7] = config.getOrCreateIntProperty("Orichalcum", "Abstractor Bonus", 28).getInt(28); 
    	xpBonus[8] = config.getOrCreateIntProperty("Adamantine", "Abstractor Bonus", 32).getInt(32); 
    	xpBonus[9] = config.getOrCreateIntProperty("Atlarus", "Abstractor Bonus", 36).getInt(36); 
    	xpBonus[10] = config.getOrCreateIntProperty("Tartarite", "Abstractor Bonus", 40).getInt(40); 

    	for(int i = 0; i < AlloyFantasyEnum.numMetals; i++)
    		alloyEnabled[i] = config.getOrCreateBooleanProperty(AlloyFantasyEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);
    	for(int i = 0; i < OreFantasyEnum.numMetals; i++)
    		metalEnabled[i] = config.getOrCreateBooleanProperty(OreFantasyEnum.names[i] + " Enabled", "Ores", true).getBoolean(true);

    	ItemStartID = config.getOrCreateIntProperty("Item Start IDs", "Item Ids Uses next 850", 27550).getInt(27550);

    	for(int i = 0; i < OreFantasyEnum.numMetals; i++)
    	{
	    	VeinCount[i] = config.getOrCreateIntProperty(OreFantasyEnum.names[i] + " Vein Count", "Ore Generation", OreFantasyEnum.defaultVeinCount[i]).getInt(OreFantasyEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.getOrCreateIntProperty(OreFantasyEnum.names[i] + " Ore Count", "Ore Generation", OreFantasyEnum.defaultOreCount[i]).getInt(OreFantasyEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.getOrCreateIntProperty(OreFantasyEnum.names[i] + " Height", "Ore Generation", OreFantasyEnum.defaultOreHeight[i]).getInt(OreFantasyEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.getOrCreateIntProperty(OreFantasyEnum.names[i] + " Minimum Height", "Ore Generation", 0).getInt(0);
    	}
    	
    	config.save();
	}
}
