
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

    	DiamondVeinCount = config.get("Ore Generation", "Diamond Vein Count", 3).getInt(3);
    	DiamondOreCount = config.get("Ore Generation", "Diamond Ore Count", 3).getInt(3);
    	DiamondOreHeight = config.get("Ore Generation", "Diamond Ore Height", 128).getInt(128);
    	
    	EmeraldVeinCount = config.get("Ore Generation", "Emerald Vein Count", 2).getInt(2);
    	EmeraldOreCount = config.get("Ore Generation", "Emerald Ore Count", 3).getInt(3);
    	EmeraldOreHeight = config.get("Ore Generation", "Emerald Ore Height", 128).getInt(128);

    	LapisLazuliVeinCount = config.get("Ore Generation", "LapisLazuili Vein Count", 4).getInt(4);
    	LapisLazuliOreCount = config.get("Ore Generation", "LapisLazuili Ore Count", 4).getInt(4);
    	LapisLazuliOreHeight = config.get("Ore Generation", "LapisLazuili Ore Height", 128).getInt(128);

    	RedstoneVeinCount = config.get("Ore Generation", "Redstone Vein Count", 6).getInt(6);
    	RedstoneOreCount = config.get("Ore Generation", "Redstone Ore Count", 6).getInt(6);
    	RedstoneOreHeight = config.get("Ore Generation", "Redstone Ore Height", 128).getInt(128);
    	
    	// Gold Generation
    	GoldVeinCount = config.get("Ore Generation", "Gold Vein Count", 4).getInt(4);
    	GoldOreCount = config.get("Ore Generation", "Gold Ore Count", 4).getInt(4);
    	GoldOreHeight = config.get("Ore Generation", "Gold Ore Height", 128).getInt(128);
    	
    	// Iron Generation
    	IronVeinCount = config.get("Ore Generation", "Iron Vein Count", 11).getInt(11);
    	IronOreCount = config.get("Ore Generation", "Iron Ore Count", 5).getInt(5);
    	IronOreHeight = config.get("Ore Generation", "Iron Ore Height", 128).getInt(128);

    	crusherID = config.getBlock("Crusher", 900).getInt(900);
    	vanillaBrickID = config.getBlock("Bricks", 905).getInt(905);
    	crushersEnabled = config.get("Machines", "Enable Crushers", true).getBoolean(true);

    	stoneCrusherSpeed = config.get("Crushers", "Stone Speed", 60000).getInt(60000)/1000f;
    	copperCrusherSpeed = config.get("Crushers", "Copper Speed", 30000).getInt(30000)/1000f;
    	bronzeCrusherSpeed = config.get("Crushers", "Bronze Speed", 20000).getInt(20000)/1000f;
    	ironCrusherSpeed = config.get("Crushers", "Iron Speed", 15000).getInt(15000)/1000f;
    	steelCrusherSpeed = config.get("Crushers", "Steel Speed", 10000).getInt(10000)/1000f;
    	config.save();
	}
	
	
}
