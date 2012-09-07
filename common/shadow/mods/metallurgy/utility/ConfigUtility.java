package shadow.mods.metallurgy.utility;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class ConfigUtility  {

	public static int veinID;
	
	public static boolean phosphoriteEnabled;
	public static boolean sulfurEnabled;
	public static boolean saltpeterEnabled;
	public static boolean magnesiumEnabled;
	public static boolean bitumenEnabled;
	public static boolean potashEnabled;

	public static int itemPhosphoriteID;
	public static int itemPhosphorousID;
	public static int itemSulfurID;
	public static int itemSaltpeterID;
	public static int itemMagnesiumID;
	public static int itemBitumenID;
	public static int itemTarID;
	public static int itemPotashID;
	public static int itemFertilizerID;
	
	public static int BitumenVeinCount;
	public static int BitumenOreCount;
	public static int BitumenOreHeight;

	public static int MagnesiumVeinCount;
	public static int MagnesiumOreCount;
	public static int MagnesiumOreHeight;

	public static int PhosphoriteVeinCount;
	public static int PhosphoriteOreCount;
	public static int PhosphoriteOreHeight;

	public static int PotashVeinCount;
	public static int PotashOreCount;
	public static int PotashOreHeight;

	public static int SaltpeterVeinCount;
	public static int SaltpeterOreCount;
	public static int SaltpeterOreHeight;

	public static int SulfurVeinCount;
	public static int SulfurOreCount;
	public static int SulfurOreHeight;

	public static int dimensionID;
	
	
	
	public static void init()
	{
		File file = new File(mod_MetallurgyUtility.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyUtility.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyUtility.cfg");
    	
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
        
        
    	veinID = config.getOrCreateBlockIdProperty("Utility Ore", 923).getInt(923);

    	dimensionID = config.getOrCreateIntProperty("Dimension ID", "Dimension", 0).getInt(0);
    	
    	bitumenEnabled = config.getOrCreateBooleanProperty("Enable Bitumen", "Ores", true).getBoolean(true);
    	magnesiumEnabled = config.getOrCreateBooleanProperty("Enable Magnesium", "Ores", true).getBoolean(true);
    	phosphoriteEnabled = config.getOrCreateBooleanProperty("Enable Phosphorite", "Ores", true).getBoolean(true);
    	potashEnabled = config.getOrCreateBooleanProperty("Enable Potash", "Ores", true).getBoolean(true);
    	saltpeterEnabled = config.getOrCreateBooleanProperty("Enable SaltPeter", "Ores", true).getBoolean(true);
    	sulfurEnabled = config.getOrCreateBooleanProperty("Enable Sulfur", "Ores", true).getBoolean(true);

		itemPhosphoriteID = config.getOrCreateIntProperty("Phosphorite Id", "Item IDs", 28400).getInt(28400);
		itemPhosphorousID = config.getOrCreateIntProperty("Phosphorous Id", "Item IDs", 28401).getInt(28401);
		itemSulfurID = config.getOrCreateIntProperty("Sulfur Id", "Item IDs", 28402).getInt(28402);
		itemSaltpeterID = config.getOrCreateIntProperty("Saltpeter Id", "Item IDs", 28403).getInt(28403);
		itemMagnesiumID = config.getOrCreateIntProperty("Magnesium Id", "Item IDs", 28404).getInt(28404);
    	itemBitumenID = config.getOrCreateIntProperty("Bitumen Id", "Item IDs", 28406).getInt(28406);
    	itemTarID = config.getOrCreateIntProperty("Tar Id", "Item IDs", 28405).getInt(28405);
		itemPotashID = config.getOrCreateIntProperty("Potash Id", "Item IDs", 28407).getInt(28407);
		itemFertilizerID = config.getOrCreateIntProperty("Fertilizer Id", "Item IDs", 28408).getInt(28408);
    	
    	
    	// Bitumen Generation
    	BitumenVeinCount = config.getOrCreateIntProperty("Bitumen Vein Count", "Ore Generation", 4).getInt(4);
    	BitumenOreCount = config.getOrCreateIntProperty("Bitumen Ore Count", "Ore Generation", 4).getInt(4);
    	BitumenOreHeight = config.getOrCreateIntProperty("Bitumen Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Magnesium Generation
    	MagnesiumVeinCount = config.getOrCreateIntProperty("Magnesium Vein Count", "Ore Generation", 4).getInt(4);
    	MagnesiumOreCount = config.getOrCreateIntProperty("Magnesium Ore Count", "Ore Generation", 4).getInt(4);
    	MagnesiumOreHeight = config.getOrCreateIntProperty("Magnesium Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Phosphorite Generation
    	PhosphoriteVeinCount = config.getOrCreateIntProperty("Phosphorite Vein Count", "Ore Generation", 4).getInt(4);
    	PhosphoriteOreCount = config.getOrCreateIntProperty("Phosphorite Ore Count", "Ore Generation", 4).getInt(4);
    	PhosphoriteOreHeight = config.getOrCreateIntProperty("Phosphorite Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Potash Generation
    	PotashVeinCount = config.getOrCreateIntProperty("Potash Vein Count", "Ore Generation", 4).getInt(4);
    	PotashOreCount = config.getOrCreateIntProperty("Potash Ore Count", "Ore Generation", 4).getInt(4);
    	PotashOreHeight = config.getOrCreateIntProperty("Potash Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Saltpeter Generation
    	SaltpeterVeinCount = config.getOrCreateIntProperty("Saltpeter Vein Count", "Ore Generation", 4).getInt(4);
    	SaltpeterOreCount = config.getOrCreateIntProperty("Saltpeter Ore Count", "Ore Generation", 4).getInt(4);
    	SaltpeterOreHeight = config.getOrCreateIntProperty("Saltpeter Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Sulfur Generation
    	SulfurVeinCount = config.getOrCreateIntProperty("Sulfur Vein Count", "Ore Generation", 4).getInt(4);
    	SulfurOreCount = config.getOrCreateIntProperty("Sulfur Ore Count", "Ore Generation", 4).getInt(4);
    	SulfurOreHeight = config.getOrCreateIntProperty("Sulfur Ore Height", "Ore Generation", 128).getInt(128);
    	
    	config.save();
	}
}
