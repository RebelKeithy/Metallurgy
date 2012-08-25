package shadow.mods.metallurgy.base;

import java.io.File;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class BaseConfig  {

	public static int baseMetalsVeinID;
	public static int baseMetalsBrickID;
	public static int baseAlloysBrickID;
	public static int furnaceID;
	
	public static boolean angmallenEnabled;
	public static boolean bronzeEnabled;
	public static boolean damascusEnabled;
	public static boolean hepatizonEnabled;
	public static boolean steelEnabled;
	public static boolean copperEnabled;
	public static boolean goldEnabled;
	public static boolean ironEnabled;
	public static boolean manganeseEnabled;
	public static boolean tinEnabled;
	public static boolean furnacesEnabled;
	public static boolean railsEnabled;

	public static double copperSpeed;
	public static double bronzeSpeed;
	public static double ironSpeed;
	public static double steelSpeed;

	public static int ItemCopperDustID;
	public static int ItemCopperBarID;
	public static int ItemCopperPickaxeID;
	public static int ItemCopperShovelID;
	public static int ItemCopperAxeID;
	public static int ItemCopperHoeID;
	public static int ItemCopperSwordID;
	public static int ItemCopperHelmetID;
	public static int ItemCopperPlateID;
	public static int ItemCopperLegsID;
	public static int ItemCopperBootsID;
	
	public static int ItemTinDustID;
	public static int ItemTinBarID;
	
	public static int ItemBronzeDustID;
	public static int ItemBronzeBarID;
	public static int ItemBronzePickaxeID;
	public static int ItemBronzeShovelID;
	public static int ItemBronzeAxeID;
	public static int ItemBronzeHoeID;
	public static int ItemBronzeSwordID;
	public static int ItemBronzeHelmetID;
	public static int ItemBronzePlateID;
	public static int ItemBronzeLegsID;
	public static int ItemBronzeBootsID;

	public static int ItemHepatizonDustID;
	public static int ItemHepatizonBarID;
	public static int ItemHepatizonPickaxeID;
	public static int ItemHepatizonShovelID;
	public static int ItemHepatizonAxeID;
	public static int ItemHepatizonHoeID;
	public static int ItemHepatizonSwordID;
	public static int ItemHepatizonHelmetID;
	public static int ItemHepatizonPlateID;
	public static int ItemHepatizonLegsID;
	public static int ItemHepatizonBootsID;

	public static int ItemGoldDustID;
	public static int ItemGoldBarID;
	public static int ItemGoldPickaxeID;
	public static int ItemGoldShovelID;
	public static int ItemGoldAxeID;
	public static int ItemGoldHoeID;
	public static int ItemGoldSwordID;
	public static int ItemGoldHelmetID;
	public static int ItemGoldPlateID;
	public static int ItemGoldLegsID;
	public static int ItemGoldBootsID;
	public static int ItemGoldCoinID;
	public static int ItemGoldCoin9ID;
	public static int ItemGoldCoin81ID;

	public static int ItemIronDustID;
	public static int ItemIronBarID;
	public static int ItemIronPickaxeID;
	public static int ItemIronShovelID;
	public static int ItemIronAxeID;
	public static int ItemIronHoeID;
	public static int ItemIronSwordID;
	public static int ItemIronHelmetID;
	public static int ItemIronPlateID;
	public static int ItemIronLegsID;
	public static int ItemIronBootsID;

	public static int ItemDamascusSteelDustID;
	public static int ItemDamascusSteelBarID;
	public static int ItemDamascusSteelPickaxeID;
	public static int ItemDamascusSteelShovelID;
	public static int ItemDamascusSteelAxeID;
	public static int ItemDamascusSteelHoeID;
	public static int ItemDamascusSteelSwordID;
	public static int ItemDamascusSteelHelmetID;
	public static int ItemDamascusSteelPlateID;
	public static int ItemDamascusSteelLegsID;
	public static int ItemDamascusSteelBootsID;
	
	public static int ItemAngmallenDustID;
	public static int ItemAngmallenBarID;
	public static int ItemAngmallenPickaxeID;
	public static int ItemAngmallenShovelID;
	public static int ItemAngmallenAxeID;
	public static int ItemAngmallenHoeID;
	public static int ItemAngmallenSwordID;
	public static int ItemAngmallenHelmetID;
	public static int ItemAngmallenPlateID;
	public static int ItemAngmallenLegsID;
	public static int ItemAngmallenBootsID;	

	public static int ItemManganeseDustID;
	public static int ItemManganeseBarID;

	public static int ItemSteelDustID;
	public static int ItemSteelBarID;
	public static int ItemSteelPickaxeID;
	public static int ItemSteelShovelID;
	public static int ItemSteelAxeID;
	public static int ItemSteelHoeID;
	public static int ItemSteelSwordID;
	public static int ItemSteelHelmetID;
	public static int ItemSteelPlateID;
	public static int ItemSteelLegsID;
	public static int ItemSteelBootsID;


	public static int CopperVeinCount;
	public static int CopperOreCount;
	public static int CopperOreHeight;

	public static int TinVeinCount;
	public static int TinOreCount;
	public static int TinOreHeight;

	public static int GoldVeinCount;
	public static int GoldOreCount;
	public static int GoldOreHeight;

	public static int IronVeinCount;
	public static int IronOreCount;
	public static int IronOreHeight;

	public static int ManganeseVeinCount;
	public static int ManganeseOreCount;
	public static int ManganeseOreHeight;
	
	
	
	public static void init()
	{
		File file = new File(mod_MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy");
    	file.mkdir();
    	File newFile = new File(mod_MetallurgyBaseMetals.proxy.getMinecraftDir() + "/config/Metallurgy/MetallurgyBase.cfg");
    	
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
        
        
    	baseMetalsVeinID = config.getOrCreateBlockIdProperty("Metal Ore", 901).getInt(900);
    	baseMetalsBrickID = config.getOrCreateBlockIdProperty("Metal Brick", 902).getInt(901);
    	baseAlloysBrickID = config.getOrCreateBlockIdProperty("Alloy Brick", 903).getInt(902);
    	furnaceID = config.getOrCreateBlockIdProperty("Furnace", 904).getInt(904);
    	
    	angmallenEnabled = config.getOrCreateBooleanProperty("Enable Angmallen", "Ores", true).getBoolean(true);
    	bronzeEnabled = config.getOrCreateBooleanProperty("Enable Bronze", "Ores", true).getBoolean(true);
    	damascusEnabled = config.getOrCreateBooleanProperty("Enable Damascus Steel", "Ores", true).getBoolean(true);
    	hepatizonEnabled = config.getOrCreateBooleanProperty("Enable Hepatizon", "Ores", true).getBoolean(true);
    	steelEnabled = config.getOrCreateBooleanProperty("Enable Copper", "Ores", true).getBoolean(true);
    	copperEnabled = config.getOrCreateBooleanProperty("Enable Gold", "Ores", true).getBoolean(true);
    	goldEnabled = config.getOrCreateBooleanProperty("Enable Iron", "Ores", true).getBoolean(true);
    	ironEnabled = config.getOrCreateBooleanProperty("Enable Iron", "Ores", true).getBoolean(true);
    	manganeseEnabled = config.getOrCreateBooleanProperty("Enable Manganese", "Ores", true).getBoolean(true);
    	tinEnabled = config.getOrCreateBooleanProperty("Enable Tin", "Ores", true).getBoolean(true);
    	furnacesEnabled = config.getOrCreateBooleanProperty("Enable Furnaces", "Machines", true).getBoolean(true);
    	railsEnabled = config.getOrCreateBooleanProperty("Enable Rail Recipes", "Machines", true).getBoolean(true);
        
    	copperSpeed = config.getOrCreateIntProperty("Copper Speed", "Furnaces", 9500).getInt(9500)/1000f;
    	bronzeSpeed = config.getOrCreateIntProperty("Bronze Speed", "Furnaces", 9000).getInt(9000)/1000f;
    	ironSpeed = config.getOrCreateIntProperty("Iron Speed", "Furnaces", 8000).getInt(8000)/1000f;
    	steelSpeed = config.getOrCreateIntProperty("Steel Speed", "Furnaces", 7000).getInt(7000)/1000f;
    	
    	// Copper IDs
    	ItemCopperDustID = config.getOrCreateIntProperty("Copper Dust", "Copper Ids", 26250).getInt(26250);
    	ItemCopperBarID = config.getOrCreateIntProperty("Copper Bar", "Copper Ids", 26251).getInt(26251);
    	ItemCopperPickaxeID = config.getOrCreateIntProperty("Copper Pickaxe", "Copper Ids", 26252).getInt(26252);
    	ItemCopperShovelID = config.getOrCreateIntProperty("Copper Shovel", "Copper Ids", 26253).getInt(26253);
    	ItemCopperAxeID = config.getOrCreateIntProperty("Copper Axe", "Copper Ids", 26254).getInt(26254);
    	ItemCopperHoeID = config.getOrCreateIntProperty("Copper Hoe", "Copper Ids", 26255).getInt(26255);
    	ItemCopperSwordID = config.getOrCreateIntProperty("Copper Sword", "Copper Ids", 26256).getInt(26256);
    	ItemCopperHelmetID = config.getOrCreateIntProperty("Copper Helmet", "Copper Ids", 26257).getInt(26257);
    	ItemCopperPlateID = config.getOrCreateIntProperty("Copper Plate", "Copper Ids", 26258).getInt(26258);
    	ItemCopperLegsID = config.getOrCreateIntProperty("Copper Legs", "Copper Ids", 26259).getInt(26259);
    	ItemCopperBootsID = config.getOrCreateIntProperty("Copper Boots", "Copper Ids", 26260).getInt(26260);

    	// Tin IDs
    	ItemTinDustID = config.getOrCreateIntProperty("Tin Dust", "Tin Ids", 26300).getInt(26300);
    	ItemTinBarID = config.getOrCreateIntProperty("Tin Bar", "Tin Ids", 26301).getInt(26301);

    	// Bronze IDs
    	ItemBronzeDustID = config.getOrCreateIntProperty("Bronze Dust", "Angmallen Ids", 26350).getInt(26350);
    	ItemBronzeBarID = config.getOrCreateIntProperty("Bronze Bar", "Angmallen Ids", 26351).getInt(26351);
    	ItemBronzePickaxeID = config.getOrCreateIntProperty("Bronze Pickaxe", "Angmallen Ids", 26352).getInt(26352);
    	ItemBronzeShovelID = config.getOrCreateIntProperty("Bronze Shovel", "Angmallen Ids", 26353).getInt(26353);
    	ItemBronzeAxeID = config.getOrCreateIntProperty("Bronze Axe", "Angmallen Ids", 26354).getInt(26354);
    	ItemBronzeHoeID = config.getOrCreateIntProperty("Bronze Hoe", "Angmallen Ids", 26355).getInt(26355);
    	ItemBronzeSwordID = config.getOrCreateIntProperty("Bronze Sword", "Angmallen Ids", 26356).getInt(26356);
    	ItemBronzeHelmetID = config.getOrCreateIntProperty("Bronze Helmet", "Angmallen Ids", 26357).getInt(26357);
    	ItemBronzePlateID = config.getOrCreateIntProperty("Bronze Plate", "Angmallen Ids", 26358).getInt(26358);
    	ItemBronzeLegsID = config.getOrCreateIntProperty("Bronze Legs", "Angmallen Ids", 26359).getInt(26359);
    	ItemBronzeBootsID = config.getOrCreateIntProperty("Bronze Boots", "Angmallen Ids", 26360).getInt(26360);
    	
    	// Hepatizon IDs
    	ItemHepatizonDustID = config.getOrCreateIntProperty("Hepatizon Dust", "Hepatizon Ids", 26400).getInt(26400);
    	ItemHepatizonBarID = config.getOrCreateIntProperty("Hepatizon Bar", "Hepatizon Ids", 26401).getInt(26401);
    	ItemHepatizonPickaxeID = config.getOrCreateIntProperty("Hepatizon Pickaxe", "Hepatizon Ids", 26402).getInt(26402);
    	ItemHepatizonShovelID = config.getOrCreateIntProperty("Hepatizon Shovel", "Hepatizon Ids", 26403).getInt(26403);
    	ItemHepatizonAxeID = config.getOrCreateIntProperty("Hepatizon Axe", "Hepatizon Ids", 26404).getInt(26404);
    	ItemHepatizonHoeID = config.getOrCreateIntProperty("Hepatizon Hoe", "Hepatizon Ids", 26405).getInt(26405);
    	ItemHepatizonSwordID = config.getOrCreateIntProperty("Hepatizon Sword", "Hepatizon Ids", 26406).getInt(26406);
    	ItemHepatizonHelmetID = config.getOrCreateIntProperty("Hepatizon Helmet", "Hepatizon Ids", 26407).getInt(26407);
    	ItemHepatizonPlateID = config.getOrCreateIntProperty("Hepatizon Plate", "Hepatizon Ids", 26408).getInt(26408);
    	ItemHepatizonLegsID = config.getOrCreateIntProperty("Hepatizon Legs", "Hepatizon Ids", 26409).getInt(26409);
    	ItemHepatizonBootsID = config.getOrCreateIntProperty("Hepatizon Boots", "Hepatizon Ids", 26410).getInt(26410);

    	// Gold IDs
    	ItemGoldDustID = config.getOrCreateIntProperty("Gold Dust", "Gold Ids", 26450).getInt(26450);
    	ItemGoldBarID = config.getOrCreateIntProperty("Gold Bar", "Gold Ids", 26451).getInt(26451);
    	ItemGoldPickaxeID = config.getOrCreateIntProperty("Gold Pickaxe", "Gold Ids", 26452).getInt(26452);
    	ItemGoldShovelID = config.getOrCreateIntProperty("Gold Shovel", "Gold Ids", 26453).getInt(26453);
    	ItemGoldAxeID = config.getOrCreateIntProperty("Gold Axe", "Gold Ids", 26454).getInt(26454);
    	ItemGoldHoeID = config.getOrCreateIntProperty("Gold Hoe", "Gold Ids", 26455).getInt(26455);
    	ItemGoldSwordID = config.getOrCreateIntProperty("Gold Sword", "Gold Ids", 26456).getInt(26456);
    	ItemGoldHelmetID = config.getOrCreateIntProperty("Gold Helmet", "Gold Ids", 26457).getInt(26457);
    	ItemGoldPlateID = config.getOrCreateIntProperty("Gold Plate", "Gold Ids", 26458).getInt(26458);
    	ItemGoldLegsID = config.getOrCreateIntProperty("Gold Legs", "Gold Ids", 26459).getInt(26459);
    	ItemGoldBootsID = config.getOrCreateIntProperty("Gold Boots", "Gold Ids", 26460).getInt(26460);
    	ItemGoldCoinID = config.getOrCreateIntProperty("Gold Coin", "Gold Ids", 26461).getInt(26461);
    	ItemGoldCoin9ID = config.getOrCreateIntProperty("Gold Stack", "Gold Ids", 26462).getInt(26462);
    	ItemGoldCoin81ID = config.getOrCreateIntProperty("Gold Bag", "Gold Ids", 26463).getInt(26463);

    	// Iron IDs
    	ItemIronDustID = config.getOrCreateIntProperty("Iron Dust", "Iron Ids", 26500).getInt(26500);
    	ItemIronBarID = config.getOrCreateIntProperty("Iron Bar", "Iron Ids", 26501).getInt(26501);
    	ItemIronPickaxeID = config.getOrCreateIntProperty("Iron Pickaxe", "Iron Ids", 26502).getInt(26502);
    	ItemIronShovelID = config.getOrCreateIntProperty("Iron Shovel", "Iron Ids", 26503).getInt(26503);
    	ItemIronAxeID = config.getOrCreateIntProperty("Iron Axe", "Iron Ids", 26504).getInt(26504);
    	ItemIronHoeID = config.getOrCreateIntProperty("Iron Hoe", "Iron Ids", 26505).getInt(26505);
    	ItemIronSwordID = config.getOrCreateIntProperty("Iron Sword", "Iron Ids", 26506).getInt(26506);
    	ItemIronHelmetID = config.getOrCreateIntProperty("Iron Helmet", "Iron Ids", 26507).getInt(26507);
    	ItemIronPlateID = config.getOrCreateIntProperty("Iron Plate", "Iron Ids", 26508).getInt(26508);
    	ItemIronLegsID = config.getOrCreateIntProperty("Iron Legs", "Iron Ids", 26509).getInt(26509);
    	ItemIronBootsID = config.getOrCreateIntProperty("Iron Boots", "Iron Ids", 26510).getInt(26510);

    	// DamascusSteel IDs
    	ItemDamascusSteelDustID = config.getOrCreateIntProperty("DamascusSteel Dust", "DamascusSteel Ids", 26550).getInt(26550);
    	ItemDamascusSteelBarID = config.getOrCreateIntProperty("DamascusSteel Bar", "DamascusSteel Ids", 26551).getInt(26551);
    	ItemDamascusSteelPickaxeID = config.getOrCreateIntProperty("DamascusSteel Pickaxe", "DamascusSteel Ids", 26552).getInt(26552);
    	ItemDamascusSteelShovelID = config.getOrCreateIntProperty("DamascusSteel Shovel", "DamascusSteel Ids", 26553).getInt(26553);
    	ItemDamascusSteelAxeID = config.getOrCreateIntProperty("DamascusSteel Axe", "DamascusSteel Ids", 26554).getInt(26554);
    	ItemDamascusSteelHoeID = config.getOrCreateIntProperty("DamascusSteel Hoe", "DamascusSteel Ids", 26555).getInt(26555);
    	ItemDamascusSteelSwordID = config.getOrCreateIntProperty("DamascusSteel Sword", "DamascusSteel Ids", 26556).getInt(26556);
    	ItemDamascusSteelHelmetID = config.getOrCreateIntProperty("DamascusSteel Helmet", "DamascusSteel Ids", 26557).getInt(26557);
    	ItemDamascusSteelPlateID = config.getOrCreateIntProperty("DamascusSteel Plate", "DamascusSteel Ids", 26558).getInt(26558);
    	ItemDamascusSteelLegsID = config.getOrCreateIntProperty("DamascusSteel Legs", "DamascusSteel Ids", 26559).getInt(26559);
    	ItemDamascusSteelBootsID = config.getOrCreateIntProperty("DamascusSteel Boots", "DamascusSteel Ids", 26560).getInt(26560);
    	
    	// Angmallen IDs
    	ItemAngmallenDustID = config.getOrCreateIntProperty("Angmallen Dust", "Angmallen Ids", 26600).getInt(26600);
    	ItemAngmallenBarID = config.getOrCreateIntProperty("Angmallen Bar", "Angmallen Ids", 26601).getInt(26601);
    	ItemAngmallenPickaxeID = config.getOrCreateIntProperty("Angmallen Pickaxe", "Angmallen Ids", 26602).getInt(26602);
    	ItemAngmallenShovelID = config.getOrCreateIntProperty("Angmallen Shovel", "Angmallen Ids", 26603).getInt(26603);
    	ItemAngmallenAxeID = config.getOrCreateIntProperty("Angmallen Axe", "Angmallen Ids", 26604).getInt(26604);
    	ItemAngmallenHoeID = config.getOrCreateIntProperty("Angmallen Hoe", "Angmallen Ids", 26605).getInt(26605);
    	ItemAngmallenSwordID = config.getOrCreateIntProperty("Angmallen Sword", "Angmallen Ids", 26606).getInt(26606);
    	ItemAngmallenHelmetID = config.getOrCreateIntProperty("Angmallen Helmet", "Angmallen Ids", 26607).getInt(26607);
    	ItemAngmallenPlateID = config.getOrCreateIntProperty("Angmallen Plate", "Angmallen Ids", 26608).getInt(26608);
    	ItemAngmallenLegsID = config.getOrCreateIntProperty("Angmallen Legs", "Angmallen Ids", 26609).getInt(26609);
    	ItemAngmallenBootsID = config.getOrCreateIntProperty("Angmallen Boots", "Angmallen Ids", 26610).getInt(26610);

    	// Manganese IDs
    	ItemManganeseDustID = config.getOrCreateIntProperty("Manganese Dust", "Manganese Ids", 26650).getInt(26650);
    	ItemManganeseBarID = config.getOrCreateIntProperty("Manganese Bar", "Manganese Ids", 26651).getInt(26651);

    	// Steel IDs
    	ItemSteelDustID = config.getOrCreateIntProperty("Steel Dust", "Steel Ids", 26700).getInt(26700);
    	ItemSteelBarID = config.getOrCreateIntProperty("Steel Bar", "Steel Ids", 26701).getInt(26701);
    	ItemSteelPickaxeID = config.getOrCreateIntProperty("Steel Pickaxe", "Steel Ids", 26702).getInt(26702);
    	ItemSteelShovelID = config.getOrCreateIntProperty("Steel Shovel", "Steel Ids", 26703).getInt(26703);
    	ItemSteelAxeID = config.getOrCreateIntProperty("Steel Axe", "Steel Ids", 26704).getInt(26704);
    	ItemSteelHoeID = config.getOrCreateIntProperty("Steel Hoe", "Steel Ids", 26705).getInt(26705);
    	ItemSteelSwordID = config.getOrCreateIntProperty("Steel Sword", "Steel Ids", 26706).getInt(26706);
    	ItemSteelHelmetID = config.getOrCreateIntProperty("Steel Helmet", "Steel Ids", 26707).getInt(26707);
    	ItemSteelPlateID = config.getOrCreateIntProperty("Steel Plate", "Steel Ids", 26708).getInt(26708);
    	ItemSteelLegsID = config.getOrCreateIntProperty("Steel Legs", "Steel Ids", 26709).getInt(26709);
    	ItemSteelBootsID = config.getOrCreateIntProperty("Steel Boots", "Steel Ids", 26710).getInt(26710);
    	
    	// Copper Generation
    	CopperVeinCount = config.getOrCreateIntProperty("Copper Vein Count", "Ore Generation", 12).getInt(12);
    	CopperOreCount = config.getOrCreateIntProperty("Copper Ore Count", "Ore Generation", 6).getInt(6);
    	CopperOreHeight = config.getOrCreateIntProperty("Copper Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Tin Generation
    	TinVeinCount = config.getOrCreateIntProperty("Tin Vein Count", "Ore Generation", 10).getInt(10);
    	TinOreCount = config.getOrCreateIntProperty("Tin Ore Count", "Ore Generation", 6).getInt(6);
    	TinOreHeight = config.getOrCreateIntProperty("Tin Ore Height", "Ore Generation", 60).getInt(128);
    	
    	// Gold Generation
    	GoldVeinCount = config.getOrCreateIntProperty("Gold Vein Count", "Ore Generation", 4).getInt(4);
    	GoldOreCount = config.getOrCreateIntProperty("Gold Ore Count", "Ore Generation", 4).getInt(4);
    	GoldOreHeight = config.getOrCreateIntProperty("Gold Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Iron Generation
    	IronVeinCount = config.getOrCreateIntProperty("Iron Vein Count", "Ore Generation", 6).getInt(6);
    	IronOreCount = config.getOrCreateIntProperty("Iron Ore Count", "Ore Generation", 6).getInt(6);
    	IronOreHeight = config.getOrCreateIntProperty("Iron Ore Height", "Ore Generation", 128).getInt(128);
    	
    	// Manganese Generation
    	ManganeseVeinCount = config.getOrCreateIntProperty("Manganese Vein Count", "Ore Generation", 4).getInt(4);
    	ManganeseOreCount = config.getOrCreateIntProperty("Manganese Ore Count", "Ore Generation", 4).getInt(4);
    	ManganeseOreHeight = config.getOrCreateIntProperty("Manganese Ore Height", "Ore Generation", 128).getInt(128);
    	
    	config.save();
	}
}
