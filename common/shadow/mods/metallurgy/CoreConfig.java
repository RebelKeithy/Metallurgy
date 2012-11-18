
package shadow.mods.metallurgy;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class CoreConfig  {

	public static int ItemGoldDustID;
	public static int ItemIronDustID;
	public static boolean DiamondEnabled;
	public static boolean EmeraldEnabled;
	public static boolean LapisLazuliEnabled;
	public static boolean RedstoneEnabled;
	public static boolean goldEnabled;
	public static boolean ironEnabled;
	
	public static int DiamondVeinCount;
	public static int DiamondOreCount;
	public static int DiamondOreHeight;

	public static int EmeraldVeinCount;
	public static int EmeraldOreCount;
	public static int EmeraldOreHeight;

	public static int LapisLazuliVeinCount;
	public static int LapisLazuliOreCount;
	public static int LapisLazuliOreHeight;

	public static int RedstoneVeinCount;
	public static int RedstoneOreCount;
	public static int RedstoneOreHeight;

	public static int IronVeinCount;
	public static int IronOreCount;
	public static int IronOreHeight;

	public static int GoldVeinCount;
	public static int GoldOreCount;
	public static int GoldOreHeight;
	
	public static boolean crushersEnabled;
	public static int crusherID;
	public static double stoneCrusherSpeed;
	public static double copperCrusherSpeed;
	public static double bronzeCrusherSpeed;
	public static double ironCrusherSpeed;
	public static double steelCrusherSpeed;
	public static boolean enableTextureOverrides;
	public static int vanillaBrickID;
	
	public static int[] customIDs;
	public static int[] customMetas;
	public static int[] customVeinCount;
	public static int[] customOreCount;
	public static int[] customMaxHeight;
	public static int[] customMinHeight;
	public static String[] customDimensions;
	
	public static void init()
	{
		File file = new File(MetallurgyCore.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(MetallurgyCore.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyCore.cfg");
    	
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

        // [Forge] Configuration class, used as config method 
        Configuration config = new Configuration(newFile);

        config.load();

    	enableTextureOverrides = config.get("Enable", "Texture Override", true).getBoolean(true);
    	
    	ItemGoldDustID = config.get("Item Ids", "Gold Dust ID", 26200).getInt(26200);
    	ItemIronDustID = config.get("Item Ids", "Iron Dust ID", 26201).getInt(26201);
    	
    	DiamondEnabled = config.get("Ores", "Enable Diamond", true).getBoolean(true);
    	EmeraldEnabled = config.get("Ores", "Enable Emerald", true).getBoolean(true);
    	LapisLazuliEnabled = config.get("Ores", "Enable Lapis Lazuli", true).getBoolean(true);
    	RedstoneEnabled = config.get("Ores", "Enable Redstone", true).getBoolean(true);
    	goldEnabled = config.get("Ores", "Enable Gold", true).getBoolean(true);
    	ironEnabled = config.get("Ores", "Enable Iron", true).getBoolean(true);

    	DiamondVeinCount = config.get("Ore Generation", "Diamond Vein Count", 4).getInt(4);
    	DiamondOreCount = config.get("Ore Generation", "Diamond Ore Count", 3).getInt(3);
    	DiamondOreHeight = config.get("Ore Generation", "Diamond Ore Height", 128).getInt(128);
    	
    	EmeraldVeinCount = config.get("Ore Generation", "Emerald Vein Count", 2).getInt(2);
    	EmeraldOreCount = config.get("Ore Generation", "Emerald Ore Count", 3).getInt(3);
    	EmeraldOreHeight = config.get("Ore Generation", "Emerald Ore Height", 128).getInt(128);

    	LapisLazuliVeinCount = config.get("Ore Generation", "LapisLazuili Vein Count", 5).getInt(5);
    	LapisLazuliOreCount = config.get("Ore Generation", "LapisLazuili Ore Count", 4).getInt(4);
    	LapisLazuliOreHeight = config.get("Ore Generation", "LapisLazuili Ore Height", 128).getInt(128);

    	RedstoneVeinCount = config.get("Ore Generation", "Redstone Vein Count", 8).getInt(8);
    	RedstoneOreCount = config.get("Ore Generation", "Redstone Ore Count", 6).getInt(6);
    	RedstoneOreHeight = config.get("Ore Generation", "Redstone Ore Height", 128).getInt(128);
    	
    	// Gold Generation
    	GoldVeinCount = config.get("Ore Generation", "Gold Vein Count", 4).getInt(4);
    	GoldOreCount = config.get("Ore Generation", "Gold Ore Count", 5).getInt(5);
    	GoldOreHeight = config.get("Ore Generation", "Gold Ore Height", 128).getInt(128);
    	
    	// Iron Generation
    	IronVeinCount = config.get("Ore Generation", "Iron Vein Count", 10).getInt(10);
    	IronOreCount = config.get("Ore Generation", "Iron Ore Count", 7).getInt(7);
    	IronOreHeight = config.get("Ore Generation", "Iron Ore Height", 128).getInt(128);

    	crusherID = config.getBlock("Crusher", 900).getInt(900);
    	vanillaBrickID = config.getBlock("Bricks", 905).getInt(905);
    	crushersEnabled = config.get("Machines", "Enable Crushers", true).getBoolean(true);

    	stoneCrusherSpeed = config.get("Crushers", "Stone Speed", 60000).getInt(60000)/1000f;
    	copperCrusherSpeed = config.get("Crushers", "Copper Speed", 30000).getInt(30000)/1000f;
    	bronzeCrusherSpeed = config.get("Crushers", "Bronze Speed", 20000).getInt(20000)/1000f;
    	ironCrusherSpeed = config.get("Crushers", "Iron Speed", 15000).getInt(15000)/1000f;
    	steelCrusherSpeed = config.get("Crushers", "Steel Speed", 10000).getInt(10000)/1000f;
    	
    	config.addCustomCategoryComment("Custom Ores", "Add a block ids and metadata, seperate entries with a comma and a space, i.e. \"17, 35, 35:10\"\nafter adding an id, start and quit minecraft to let the information for the ore generate in \nthe Ore Generation category and fill the numbers as you like");
    	String[] ids = (config.get("Custom Ores", "ID list", "").value).split(", ");
    	
    	if(!ids[0].equals(""))
    	{
	    	customIDs = new int[ids.length];
	    	customMetas = new int[ids.length];
	    	customVeinCount = new int[ids.length];
	    	customOreCount = new int[ids.length];
	    	customMaxHeight = new int[ids.length];
	    	customMinHeight = new int[ids.length];
	    	customDimensions = new String[ids.length];
	    	for(int n = 0; n < ids.length; n++)
	    	{
	    		String[] idSplit = ids[n].replace("\"", "").split(":");
	    		customIDs[n] = Integer.parseInt(idSplit[0]);
	    		if(idSplit.length > 1)
	    			customMetas[n] = Integer.parseInt(idSplit[1]);
	    		else
	    			customMetas[n] = 0;
	    		
	    		String title = "" + customIDs[n];
	    		if(customMetas[n] != 0)
	    			title += ":" + customMetas[n];
	    		customVeinCount[n] = config.get("Ore Generation", title + " Vein Count", 0).getInt(0);
	    		customOreCount[n] = config.get("Ore Generation", title + " Ore Count", 0).getInt(0);
	    		customMaxHeight[n] = config.get("Ore Generation", title + " Ore Height", 128).getInt(128);
	    		customMinHeight[n] = config.get("Ore Generation", title + " Ore Min Height", 0).getInt(0);
	    		customDimensions[n] = config.get("Ore Generation", title + " Ore Dimensions", "0 2-100000").value;
	    	}
    	} 
    	else 
    	{
	    	customIDs = new int[0];
	    	customVeinCount = new int[0];
	    	customOreCount = new int[0];
	    	customMaxHeight = new int[0];
	    	customMinHeight = new int[0];
    	}
    	
    	config.save();
	}
	
	
}
