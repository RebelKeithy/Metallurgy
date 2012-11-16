package shadow.mods.metallurgy.nether;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigNether  {

	public static int NetherMetalsVeinID;
	public static int NetherMetalsBrickID;
	public static int NetherCatalystVeinID;
	public static int NetherCatalystBrickID;
	public static int oresBlockID;
	public static int alloysBlockID;
	public static int NetherAlloysBrickID;
	public static int furnaceID;
	
	public static boolean[] alloyEnabled = new boolean[3];
	public static boolean[] metalEnabled = new boolean[10];
	public static boolean furnaceEnabled;
	public static boolean midasiumEnabled;

	public static float[] speeds = new float[8];
	public static int[] buckets = new int[8];

	public static int[] VeinCount = new int[10];
	public static int[] OreCount = new int[10];
	public static int[] OreHeight = new int[10];
	public static int[] OreMinHeight = new int[10];

	public static int ObsidianVeinCount;
	public static int ObsidianOreCount;
	public static int ObsidianOreHeight;
	public static int ItemStartID;
	public static int ItemCatalystStartID;
	
	public static int[] alloyItemIds = new int[3];
	public static int[] metalItemIds = new int [10];
	public static String dimensions;
	public static boolean smelterDropsLava;
	
	
	public static void init()
	{
		File file = new File(MetallurgyNether.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyNether.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyNether.cfg");
    	
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
        
        
    	NetherMetalsVeinID = config.getBlock("Metal Ore", 915).getInt(915);
    	NetherMetalsBrickID = config.getBlock("Metal Brick", 916).getInt(916);
    	NetherCatalystVeinID = config.getBlock("Catalyst Ore", 924).getInt(924);
    	NetherCatalystBrickID = config.getBlock("Catalyst Brick", 925).getInt(925);
    	oresBlockID = config.getBlock("Metal Block", 931).getInt(931);
    	alloysBlockID = config.getBlock("Alloy Block", 932).getInt(931);
    	NetherAlloysBrickID = config.getBlock("Alloy Brick", 917).getInt(917);
    	furnaceID = config.getBlock("Nether Smelter", 918).getInt(918);

    	dimensions = config.get("Dimensions", "Dimensions", "-1").value;
    	
    	for(int i = 0; i < 3; i++)
    		alloyEnabled[i] = config.get("Ores", AlloyNetherEnum.names[i] + " Enabled", true).getBoolean(true);
    	for(int i = 0; i < 10; i++)
    		metalEnabled[i] = config.get("Ores", OreNetherEnum.names[i] + " Enabled", true).getBoolean(true);

    	furnaceEnabled = config.get("Options", "Enable Smelters", true).getBoolean(true);
    	midasiumEnabled = config.get("Options", "Enable Midasium Recipes", true).getBoolean(true);

    	
    	speeds[0] = config.get("Furnace Speed", "Ignatius", 6000).getInt(6000)/1000f;
    	speeds[1] = config.get("Furnace Speed", "ShadowIron", 5500).getInt(5500)/1000f;
    	speeds[2] = config.get("Furnace Speed", "ShadowSteel", 5000).getInt(5000)/1000f;
    	speeds[3] = config.get("Furnace Speed", "Vyroxeres", 4500).getInt(4500)/1000f;
    	speeds[4] = config.get("Furnace Speed", "Inolashite", 4000).getInt(4000)/1000f;
    	speeds[5] = config.get("Furnace Speed", "Kalendrite", 3500).getInt(3500)/1000f;
    	speeds[6] = config.get("Furnace Speed", "Vulcanite", 3000).getInt(3000)/1000f;
    	speeds[7] = config.get("Furnace Speed", "Sanguinite", 2000).getInt(2000)/1000f;

    	buckets[0] = config.get("Furnace Buckets", "Ignatius", 10).getInt(10);
    	buckets[1] = config.get("Furnace Buckets", "ShadowIron", 20).getInt(20);
    	buckets[2] = config.get("Furnace Buckets", "ShadowSteel", 30).getInt(30);
    	buckets[3] = config.get("Furnace Buckets", "Vyroxeres", 40).getInt(40);
    	buckets[4] = config.get("Furnace Buckets", "Inolashite", 50).getInt(50);
    	buckets[5] = config.get("Furnace Buckets", "Kalendrite", 60).getInt(60);
    	buckets[6] = config.get("Furnace Buckets", "Vulcanite", 80).getInt(80);
    	buckets[7] = config.get("Furnace Buckets", "Sanguinite", 100).getInt(100);

    	ItemStartID = config.get("Item Ids Uses next 550", "Item Start IDs", 27000).getInt(27000);
    	smelterDropsLava = config.get("Options", "Smelters leave lava", false).getBoolean(false);

    	for(int i = 0; i < 8; i++)
    	{
    		metalItemIds[i] = config.get("Item Ids uses next 50", OreNetherEnum.names[i] + " item ids", 27000 + (i * 50)).getInt(27000 + (i * 50));
    	}
    	
    	for(int i = 0; i < 3; i++)
    	{
    		alloyItemIds[i] = config.get("Item Ids uses next 50", AlloyNetherEnum.names[i] + " item ids", 27400 + (i * 50)).getInt(27400 + (i * 50));
    	}

    	for(int i = 0; i < 2; i++)
    	{
    		metalItemIds[i + 8] = config.get("Item Ids uses next 2", OreNetherEnum.names[i + 8] + " item ids", 27098 + (i * 200)).getInt(27098 + (i * 200));
    	}
    	
    	ItemCatalystStartID = config.get("Item Ids Uses next 100", "Item Catalyst Start IDs", 28500).getInt(28500);

    	for(int i = 0; i < 10; i++)
    	{
	    	VeinCount[i] = config.get("Ore Generation", OreNetherEnum.names[i] + " Vein Count", OreNetherEnum.defaultVeinCount[i]).getInt(OreNetherEnum.defaultVeinCount[i]);
	    	OreCount[i] = config.get("Ore Generation", OreNetherEnum.names[i] + " Ore Count", OreNetherEnum.defaultOreCount[i]).getInt(OreNetherEnum.defaultOreCount[i]);
	    	OreHeight[i] = config.get("Ore Generation", OreNetherEnum.names[i] + " Height", OreNetherEnum.defaultOreHeight[i]).getInt(OreNetherEnum.defaultOreHeight[i]);
	    	OreMinHeight[i] = config.get("Ore Generation", OreNetherEnum.names[i] + " Minimum Height", 0).getInt(0);
    	}
    
    	ObsidianVeinCount = config.get("Ore Generation", "Obsidian Vein Count", 1).getInt(1);
    	ObsidianOreCount = config.get("Ore Generation", "Obsidian Ore Count", 72).getInt(72);
    	ObsidianOreHeight = config.get("Ore Generation", "Obsidian Height", 128).getInt(128);
    	
    	config.save();
	}
}
