package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.io.IOException;

import shadow.mods.metallurgy.base.mod_MetallurgyBaseMetals;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraftforge.common.Configuration;

public class FantasyConfig  {

	public static int veinID;
	public static int brickMetalsID;
	public static int brickAlloysID;
	
	public static boolean prometheumEnabled;
	public static boolean deepIronEnabled;
	public static boolean infuscoliumEnabled;
	public static boolean oureclaseEnabled;
	public static boolean aredriteEnabled;
	public static boolean astralSilverEnabled;
	public static boolean carmotEnabled;
	public static boolean mithrilEnabled;
	public static boolean rubraciumEnabled;
	public static boolean orichalcumEnabled;
	public static boolean adamantineEnabled;
	public static boolean atlarusEnabled;
	public static boolean blackSteelEnabled;
	public static boolean quicksilverEnabled;
	public static boolean haderothEnabled;
	public static boolean celenegilEnabled;
	public static boolean tartariteEnabled;
	
	public static int[] extractorSpeeds = new int[11];

	public static int itemPrometheumDustID;
	public static int itemPrometheumBarID;
	public static int itemPrometheumPickaxeID;
	public static int itemPrometheumShovelID;
	public static int itemPrometheumAxeID;
	public static int itemPrometheumHoeID;
	public static int itemPrometheumSwordID;
	public static int itemPrometheumHelmetID;
	public static int itemPrometheumPlateID;
	public static int itemPrometheumLegsID;
	public static int itemPrometheumBootsID;

	public static int itemDeepIronDustID;
	public static int itemDeepIronBarID;
	public static int itemDeepIronPickaxeID;
	public static int itemDeepIronShovelID;
	public static int itemDeepIronAxeID;
	public static int itemDeepIronHoeID;
	public static int itemDeepIronSwordID;
	public static int itemDeepIronHelmetID;
	public static int itemDeepIronPlateID;
	public static int itemDeepIronLegsID;
	public static int itemDeepIronBootsID;

	public static int itemInfuscoliumDustID;
	public static int itemInfuscoliumBarID;

	public static int itemBlackSteelDustID;
	public static int itemBlackSteelBarID;
	public static int itemBlackSteelPickaxeID;
	public static int itemBlackSteelShovelID;
	public static int itemBlackSteelAxeID;
	public static int itemBlackSteelHoeID;
	public static int itemBlackSteelSwordID;
	public static int itemBlackSteelHelmetID;
	public static int itemBlackSteelPlateID;
	public static int itemBlackSteelLegsID;
	public static int itemBlackSteelBootsID;

	public static int itemOureclaseDustID;
	public static int itemOureclaseBarID;
	public static int itemOureclasePickaxeID;
	public static int itemOureclaseShovelID;
	public static int itemOureclaseAxeID;
	public static int itemOureclaseHoeID;
	public static int itemOureclaseSwordID;
	public static int itemOureclaseHelmetID;
	public static int itemOureclasePlateID;
	public static int itemOureclaseLegsID;
	public static int itemOureclaseBootsID;

	public static int itemAredriteDustID;
	public static int itemAredriteBarID;
	public static int itemAredritePickaxeID;
	public static int itemAredriteShovelID;
	public static int itemAredriteAxeID;
	public static int itemAredriteHoeID;
	public static int itemAredriteSwordID;
	public static int itemAredriteHelmetID;
	public static int itemAredritePlateID;
	public static int itemAredriteLegsID;
	public static int itemAredriteBootsID;

	public static int itemAstralSilverDustID;
	public static int itemAstralSilverBarID;
	public static int itemAstralSilverPickaxeID;
	public static int itemAstralSilverShovelID;
	public static int itemAstralSilverAxeID;
	public static int itemAstralSilverHoeID;
	public static int itemAstralSilverSwordID;
	public static int itemAstralSilverHelmetID;
	public static int itemAstralSilverPlateID;
	public static int itemAstralSilverLegsID;
	public static int itemAstralSilverBootsID;

	public static int itemCarmotDustID;
	public static int itemCarmotBarID;
	public static int itemCarmotPickaxeID;
	public static int itemCarmotShovelID;
	public static int itemCarmotAxeID;
	public static int itemCarmotHoeID;
	public static int itemCarmotSwordID;
	public static int itemCarmotHelmetID;
	public static int itemCarmotPlateID;
	public static int itemCarmotLegsID;
	public static int itemCarmotBootsID;

	public static int itemMithrilDustID;
	public static int itemMithrilBarID;
	public static int itemMithrilPickaxeID;
	public static int itemMithrilShovelID;
	public static int itemMithrilAxeID;
	public static int itemMithrilHoeID;
	public static int itemMithrilSwordID;
	public static int itemMithrilHelmetID;
	public static int itemMithrilPlateID;
	public static int itemMithrilLegsID;
	public static int itemMithrilBootsID;

	public static int itemRubraciumDustID;
	public static int itemRubraciumBarID;

	public static int itemQuicksilverDustID;
	public static int itemQuicksilverBarID;
	public static int itemQuicksilverPickaxeID;
	public static int itemQuicksilverShovelID;
	public static int itemQuicksilverAxeID;
	public static int itemQuicksilverHoeID;
	public static int itemQuicksilverSwordID;
	public static int itemQuicksilverHelmetID;
	public static int itemQuicksilverPlateID;
	public static int itemQuicksilverLegsID;
	public static int itemQuicksilverBootsID;

	public static int itemHaderothDustID;
	public static int itemHaderothBarID;
	public static int itemHaderothPickaxeID;
	public static int itemHaderothShovelID;
	public static int itemHaderothAxeID;
	public static int itemHaderothHoeID;
	public static int itemHaderothSwordID;
	public static int itemHaderothHelmetID;
	public static int itemHaderothPlateID;
	public static int itemHaderothLegsID;
	public static int itemHaderothBootsID;

	public static int itemOrichalcumDustID;
	public static int itemOrichalcumBarID;
	public static int itemOrichalcumPickaxeID;
	public static int itemOrichalcumShovelID;
	public static int itemOrichalcumAxeID;
	public static int itemOrichalcumHoeID;
	public static int itemOrichalcumSwordID;
	public static int itemOrichalcumHelmetID;
	public static int itemOrichalcumPlateID;
	public static int itemOrichalcumLegsID;
	public static int itemOrichalcumBootsID;

	public static int itemCelenegilDustID;
	public static int itemCelenegilBarID;
	public static int itemCelenegilPickaxeID;
	public static int itemCelenegilShovelID;
	public static int itemCelenegilAxeID;
	public static int itemCelenegilHoeID;
	public static int itemCelenegilSwordID;
	public static int itemCelenegilHelmetID;
	public static int itemCelenegilPlateID;
	public static int itemCelenegilLegsID;
	public static int itemCelenegilBootsID;

	public static int itemAdamantineDustID;
	public static int itemAdamantineBarID;
	public static int itemAdamantinePickaxeID;
	public static int itemAdamantineShovelID;
	public static int itemAdamantineAxeID;
	public static int itemAdamantineHoeID;
	public static int itemAdamantineSwordID;
	public static int itemAdamantineHelmetID;
	public static int itemAdamantinePlateID;
	public static int itemAdamantineLegsID;
	public static int itemAdamantineBootsID;

	public static int itemAtlarusDustID;
	public static int itemAtlarusBarID;
	public static int itemAtlarusPickaxeID;
	public static int itemAtlarusShovelID;
	public static int itemAtlarusAxeID;
	public static int itemAtlarusHoeID;
	public static int itemAtlarusSwordID;
	public static int itemAtlarusHelmetID;
	public static int itemAtlarusPlateID;
	public static int itemAtlarusLegsID;
	public static int itemAtlarusBootsID;

	public static int itemTartariteDustID;
	public static int itemTartariteBarID;
	public static int itemTartaritePickaxeID;
	public static int itemTartariteShovelID;
	public static int itemTartariteAxeID;
	public static int itemTartariteHoeID;
	public static int itemTartariteSwordID;
	public static int itemTartariteHelmetID;
	public static int itemTartaritePlateID;
	public static int itemTartariteLegsID;
	public static int itemTartariteBootsID;

	public static int PrometheumVeinCount;
	public static int PrometheumOreCount;
	public static int PrometheumOreHeight;

	public static int DeepIronVeinCount;
	public static int DeepIronOreCount;
	public static int DeepIronOreHeight;

	public static int InfuscoliumVeinCount;
	public static int InfuscoliumOreCount;
	public static int InfuscoliumOreHeight;

	public static int OureclaseVeinCount;
	public static int OureclaseOreCount;
	public static int OureclaseOreHeight;

	public static int AredriteVeinCount;
	public static int AredriteOreCount;
	public static int AredriteOreHeight;

	public static int AstralSilverVeinCount;
	public static int AstralSilverOreCount;
	public static int AstralSilverOreHeight;

	public static int CarmotVeinCount;
	public static int CarmotOreCount;
	public static int CarmotOreHeight;

	public static int MithrilVeinCount;
	public static int MithrilOreCount;
	public static int MithrilOreHeight;

	public static int RubraciumVeinCount;
	public static int RubraciumOreCount;
	public static int RubraciumOreHeight;

	public static int OrichalcumVeinCount;
	public static int OrichalcumOreCount;
	public static int OrichalcumOreHeight;

	public static int AdamantineVeinCount;
	public static int AdamantineOreCount;
	public static int AdamantineOreHeight;

	public static int AtlarusVeinCount;
	public static int AtlarusOreCount;
	public static int AtlarusOreHeight;
	
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
        
        veinID = config.getOrCreateBlockIdProperty("Metal Ore", 919).getInt(919);
    	brickMetalsID = config.getOrCreateBlockIdProperty("Metal Brick", 920).getInt(920);
    	brickAlloysID = config.getOrCreateBlockIdProperty("Alloy Brick", 921).getInt(921);
    	
    	extractorSpeeds[0] = config.getOrCreateIntProperty("Prometheum", "Abstractor Speeds", 22000).getInt(22000)/1000;    	
    	extractorSpeeds[1] = config.getOrCreateIntProperty("DeepIron", "Abstractor Speeds", 20000).getInt(20000)/1000;    	
    	extractorSpeeds[2] = config.getOrCreateIntProperty("BlackSteel", "Abstractor Speeds", 18000).getInt(18000)/1000;    	
    	extractorSpeeds[3] = config.getOrCreateIntProperty("Oureclase", "Abstractor Speeds", 16000).getInt(16000)/1000;    	
    	extractorSpeeds[4] = config.getOrCreateIntProperty("Aredrite", "Abstractor Speeds", 14000).getInt(14000)/1000;    	
    	extractorSpeeds[5] = config.getOrCreateIntProperty("Mithril", "Abstractor Speeds", 12000).getInt(12000)/1000;    	
    	extractorSpeeds[6] = config.getOrCreateIntProperty("Haderoth", "Abstractor Speeds", 10000).getInt(10000)/1000;    	
    	extractorSpeeds[7] = config.getOrCreateIntProperty("Orichalcum", "Abstractor Speeds", 8000).getInt(8000)/1000;    	
    	extractorSpeeds[8] = config.getOrCreateIntProperty("Adamantine", "Abstractor Speeds", 6000).getInt(6000)/1000;    	
    	extractorSpeeds[9] = config.getOrCreateIntProperty("Atlarus", "Abstractor Speeds", 4000).getInt(4000)/1000;    	    	
    	extractorSpeeds[10] = config.getOrCreateIntProperty("Tartarite", "Abstractor Speeds", 2000).getInt(2000)/1000;

    	prometheumEnabled = config.getOrCreateBooleanProperty("Enable Prometheum", "Ores", true).getBoolean(true);
    	deepIronEnabled = config.getOrCreateBooleanProperty("Enable Deep Iron", "Ores", true).getBoolean(true);
    	infuscoliumEnabled = config.getOrCreateBooleanProperty("Enable Infuscolium", "Ores", true).getBoolean(true);
    	oureclaseEnabled = config.getOrCreateBooleanProperty("Enable Oureclase", "Ores", true).getBoolean(true);
    	aredriteEnabled = config.getOrCreateBooleanProperty("Enable Aredrite", "Ores", true).getBoolean(true);
    	astralSilverEnabled = config.getOrCreateBooleanProperty("Enable Astral Silver", "Ores", true).getBoolean(true);
    	carmotEnabled = config.getOrCreateBooleanProperty("Enable Carmot", "Ores", true).getBoolean(true);
    	mithrilEnabled = config.getOrCreateBooleanProperty("Enable Mithril", "Ores", true).getBoolean(true);
    	rubraciumEnabled = config.getOrCreateBooleanProperty("Enable Rubacium", "Ores", true).getBoolean(true);
    	orichalcumEnabled = config.getOrCreateBooleanProperty("Enable Orichalcum", "Ores", true).getBoolean(true);
    	adamantineEnabled = config.getOrCreateBooleanProperty("Enable Adamantine", "Ores", true).getBoolean(true);
    	atlarusEnabled = config.getOrCreateBooleanProperty("Enable Atlarus", "Ores", true).getBoolean(true);
    	blackSteelEnabled = config.getOrCreateBooleanProperty("Enable Black Steel", "Ores", true).getBoolean(true);
    	quicksilverEnabled = config.getOrCreateBooleanProperty("Enable Quicksilver", "Ores", true).getBoolean(true);
    	haderothEnabled = config.getOrCreateBooleanProperty("Enable Haderoth", "Ores", true).getBoolean(true);
    	celenegilEnabled = config.getOrCreateBooleanProperty("Enable Celenegil", "Ores", true).getBoolean(true);
    	tartariteEnabled = config.getOrCreateBooleanProperty("Enable Tartarite", "Ores", true).getBoolean(true);

    	itemPrometheumDustID = config.getOrCreateIntProperty("Prometheum Dust", "Prometheum Ids", 27550).getInt(27550);
    	itemPrometheumBarID = config.getOrCreateIntProperty("Prometheum Bar", "Prometheum Ids", 27551).getInt(27551);
    	itemPrometheumPickaxeID = config.getOrCreateIntProperty("Prometheum Pickaxe", "Prometheum Ids", 27552).getInt(27552);
    	itemPrometheumShovelID = config.getOrCreateIntProperty("Prometheum Shovel", "Prometheum Ids", 27553).getInt(27553);
    	itemPrometheumAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Prometheum Ids", 27554).getInt(27554);
    	itemPrometheumHoeID = config.getOrCreateIntProperty("Prometheum Hoe", "Prometheum Ids", 27555).getInt(27555);
    	itemPrometheumSwordID = config.getOrCreateIntProperty("Prometheum Sword", "Prometheum Ids", 27556).getInt(27556);
    	itemPrometheumHelmetID = config.getOrCreateIntProperty("Prometheum Helmet", "Prometheum Ids", 27557).getInt(27557);
    	itemPrometheumPlateID = config.getOrCreateIntProperty("Prometheum Plate", "Prometheum Ids", 27558).getInt(27558);
    	itemPrometheumLegsID = config.getOrCreateIntProperty("Prometheum Legs", "Prometheum Ids", 27559).getInt(27559);
    	itemPrometheumBootsID = config.getOrCreateIntProperty("Prometheum Boots", "Prometheum Ids", 27560).getInt(27560);

    	itemDeepIronDustID = config.getOrCreateIntProperty("DeepIron Dust", "DeepIron Ids", 27600).getInt(27600);
    	itemDeepIronBarID = config.getOrCreateIntProperty("DeepIron Bar", "DeepIron Ids", 27601).getInt(27601);
    	itemDeepIronPickaxeID = config.getOrCreateIntProperty("DeepIron Pickaxe", "DeepIron Ids", 27602).getInt(27602);
    	itemDeepIronShovelID = config.getOrCreateIntProperty("DeepIron Shovel", "DeepIron Ids", 27603).getInt(27603);
    	itemDeepIronAxeID = config.getOrCreateIntProperty("DeepIron Axe", "DeepIron Ids", 27604).getInt(27604);
    	itemDeepIronHoeID = config.getOrCreateIntProperty("DeepIron Hoe", "DeepIron Ids", 27605).getInt(27605);
    	itemDeepIronSwordID = config.getOrCreateIntProperty("DeepIron Sword", "DeepIron Ids", 27606).getInt(27606);
    	itemDeepIronHelmetID = config.getOrCreateIntProperty("DeepIron Helmet", "DeepIron Ids", 27607).getInt(27607);
    	itemDeepIronPlateID = config.getOrCreateIntProperty("DeepIron Plate", "DeepIron Ids", 27608).getInt(27608);
    	itemDeepIronLegsID = config.getOrCreateIntProperty("DeepIron Legs", "DeepIron Ids", 27609).getInt(27609);
    	itemDeepIronBootsID = config.getOrCreateIntProperty("DeepIron Boots", "DeepIron Ids", 27610).getInt(27610);

    	itemInfuscoliumDustID = config.getOrCreateIntProperty("Infuscolium Dust", "Infuscolium Ids", 27650).getInt(27650);
    	itemInfuscoliumBarID = config.getOrCreateIntProperty("Infuscolium Bar", "Infuscolium Ids", 27651).getInt(27651);

    	itemBlackSteelDustID = config.getOrCreateIntProperty("BlackSteel Dust", "BlackSteel Ids", 27700).getInt(27700);
    	itemBlackSteelBarID = config.getOrCreateIntProperty("BlackSteel Bar", "BlackSteel Ids", 27701).getInt(27701);
    	itemBlackSteelPickaxeID = config.getOrCreateIntProperty("BlackSteel Pickaxe", "BlackSteel Ids", 27702).getInt(27702);
    	itemBlackSteelShovelID = config.getOrCreateIntProperty("BlackSteel Shovel", "BlackSteel Ids", 27703).getInt(27703);
    	itemBlackSteelAxeID = config.getOrCreateIntProperty("Prometehum Axe", "BlackSteel Ids", 27704).getInt(27704);
    	itemBlackSteelHoeID = config.getOrCreateIntProperty("BlackSteel Hoe", "BlackSteel Ids", 27705).getInt(27705);
    	itemBlackSteelSwordID = config.getOrCreateIntProperty("BlackSteel Sword", "BlackSteel Ids", 27706).getInt(27706);
    	itemBlackSteelHelmetID = config.getOrCreateIntProperty("BlackSteel Helmet", "BlackSteel Ids", 27707).getInt(27707);
    	itemBlackSteelPlateID = config.getOrCreateIntProperty("BlackSteel Plate", "BlackSteel Ids", 27708).getInt(27708);
    	itemBlackSteelLegsID = config.getOrCreateIntProperty("BlackSteel Legs", "BlackSteel Ids", 27709).getInt(27709);
    	itemBlackSteelBootsID = config.getOrCreateIntProperty("BlackSteel Boots", "BlackSteel Ids", 27710).getInt(27710);

    	itemOureclaseDustID = config.getOrCreateIntProperty("Oureclase Dust", "Oureclase Ids", 27750).getInt(27750);
    	itemOureclaseBarID = config.getOrCreateIntProperty("Oureclase Bar", "Oureclase Ids", 27751).getInt(27751);
    	itemOureclasePickaxeID = config.getOrCreateIntProperty("Oureclase Pickaxe", "Oureclase Ids", 27752).getInt(27752);
    	itemOureclaseShovelID = config.getOrCreateIntProperty("Oureclase Shovel", "Oureclase Ids", 27753).getInt(27753);
    	itemOureclaseAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Oureclase Ids", 27754).getInt(27754);
    	itemOureclaseHoeID = config.getOrCreateIntProperty("Oureclase Hoe", "Oureclase Ids", 27755).getInt(27755);
    	itemOureclaseSwordID = config.getOrCreateIntProperty("Oureclase Sword", "Oureclase Ids", 27756).getInt(27756);
    	itemOureclaseHelmetID = config.getOrCreateIntProperty("Oureclase Helmet", "Oureclase Ids", 27757).getInt(27757);
    	itemOureclasePlateID = config.getOrCreateIntProperty("Oureclase Plate", "Oureclase Ids", 27758).getInt(27758);
    	itemOureclaseLegsID = config.getOrCreateIntProperty("Oureclase Legs", "Oureclase Ids", 27759).getInt(27759);
    	itemOureclaseBootsID = config.getOrCreateIntProperty("Oureclase Boots", "Oureclase Ids", 27760).getInt(27760);

    	itemAredriteDustID = config.getOrCreateIntProperty("Aredrite Dust", "Aredrite Ids", 27800).getInt(27800);
    	itemAredriteBarID = config.getOrCreateIntProperty("Aredrite Bar", "Aredrite Ids", 27801).getInt(27801);
    	itemAredritePickaxeID = config.getOrCreateIntProperty("Aredrite Pickaxe", "Aredrite Ids", 27802).getInt(27802);
    	itemAredriteShovelID = config.getOrCreateIntProperty("Aredrite Shovel", "Aredrite Ids", 27803).getInt(27803);
    	itemAredriteAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Aredrite Ids", 27804).getInt(27804);
    	itemAredriteHoeID = config.getOrCreateIntProperty("Aredrite Hoe", "Aredrite Ids", 27805).getInt(27805);
    	itemAredriteSwordID = config.getOrCreateIntProperty("Aredrite Sword", "Aredrite Ids", 27806).getInt(27806);
    	itemAredriteHelmetID = config.getOrCreateIntProperty("Aredrite Helmet", "Aredrite Ids", 27807).getInt(27807);
    	itemAredritePlateID = config.getOrCreateIntProperty("Aredrite Plate", "Aredrite Ids", 27808).getInt(27808);
    	itemAredriteLegsID = config.getOrCreateIntProperty("Aredrite Legs", "Aredrite Ids", 27809).getInt(27809);
    	itemAredriteBootsID = config.getOrCreateIntProperty("Aredrite Boots", "Aredrite Ids", 27810).getInt(27810);

    	itemAstralSilverDustID = config.getOrCreateIntProperty("AstralSilver Dust", "AstralSilver Ids", 27850).getInt(27850);
    	itemAstralSilverBarID = config.getOrCreateIntProperty("AstralSilver Bar", "AstralSilver Ids", 27851).getInt(27851);
    	itemAstralSilverPickaxeID = config.getOrCreateIntProperty("AstralSilver Pickaxe", "AstralSilver Ids", 27852).getInt(27852);
    	itemAstralSilverShovelID = config.getOrCreateIntProperty("AstralSilver Shovel", "AstralSilver Ids", 27853).getInt(27853);
    	itemAstralSilverAxeID = config.getOrCreateIntProperty("Prometehum Axe", "AstralSilver Ids", 27854).getInt(27854);
    	itemAstralSilverHoeID = config.getOrCreateIntProperty("AstralSilver Hoe", "AstralSilver Ids", 27855).getInt(27855);
    	itemAstralSilverSwordID = config.getOrCreateIntProperty("AstralSilver Sword", "AstralSilver Ids", 27856).getInt(27856);
    	itemAstralSilverHelmetID = config.getOrCreateIntProperty("AstralSilver Helmet", "AstralSilver Ids", 27857).getInt(27857);
    	itemAstralSilverPlateID = config.getOrCreateIntProperty("AstralSilver Plate", "AstralSilver Ids", 27858).getInt(27858);
    	itemAstralSilverLegsID = config.getOrCreateIntProperty("AstralSilver Legs", "AstralSilver Ids", 27859).getInt(27859);
    	itemAstralSilverBootsID = config.getOrCreateIntProperty("AstralSilver Boots", "AstralSilver Ids", 27860).getInt(27860);

    	itemCarmotDustID = config.getOrCreateIntProperty("Carmot Dust", "Carmot Ids", 27900).getInt(27900);
    	itemCarmotBarID = config.getOrCreateIntProperty("Carmot Bar", "Carmot Ids", 27901).getInt(27901);
    	itemCarmotPickaxeID = config.getOrCreateIntProperty("Carmot Pickaxe", "Carmot Ids", 27902).getInt(27902);
    	itemCarmotShovelID = config.getOrCreateIntProperty("Carmot Shovel", "Carmot Ids", 27903).getInt(27903);
    	itemCarmotAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Carmot Ids", 27904).getInt(27904);
    	itemCarmotHoeID = config.getOrCreateIntProperty("Carmot Hoe", "Carmot Ids", 27905).getInt(27905);
    	itemCarmotSwordID = config.getOrCreateIntProperty("Carmot Sword", "Carmot Ids", 27906).getInt(27906);
    	itemCarmotHelmetID = config.getOrCreateIntProperty("Carmot Helmet", "Carmot Ids", 27907).getInt(27907);
    	itemCarmotPlateID = config.getOrCreateIntProperty("Carmot Plate", "Carmot Ids", 27908).getInt(27908);
    	itemCarmotLegsID = config.getOrCreateIntProperty("Carmot Legs", "Carmot Ids", 27909).getInt(27909);
    	itemCarmotBootsID = config.getOrCreateIntProperty("Carmot Boots", "Carmot Ids", 27910).getInt(27910);

    	itemMithrilDustID = config.getOrCreateIntProperty("Mithril Dust", "Mithril Ids", 27950).getInt(27950);
    	itemMithrilBarID = config.getOrCreateIntProperty("Mithril Bar", "Mithril Ids", 27951).getInt(27951);
    	itemMithrilPickaxeID = config.getOrCreateIntProperty("Mithril Pickaxe", "Mithril Ids", 27952).getInt(27952);
    	itemMithrilShovelID = config.getOrCreateIntProperty("Mithril Shovel", "Mithril Ids", 27953).getInt(27953);
    	itemMithrilAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Mithril Ids", 27954).getInt(27954);
    	itemMithrilHoeID = config.getOrCreateIntProperty("Mithril Hoe", "Mithril Ids", 27955).getInt(27955);
    	itemMithrilSwordID = config.getOrCreateIntProperty("Mithril Sword", "Mithril Ids", 27956).getInt(27956);
    	itemMithrilHelmetID = config.getOrCreateIntProperty("Mithril Helmet", "Mithril Ids", 27957).getInt(27957);
    	itemMithrilPlateID = config.getOrCreateIntProperty("Mithril Plate", "Mithril Ids", 27958).getInt(27958);
    	itemMithrilLegsID = config.getOrCreateIntProperty("Mithril Legs", "Mithril Ids", 27959).getInt(27959);
    	itemMithrilBootsID = config.getOrCreateIntProperty("Mithril Boots", "Mithril Ids", 27960).getInt(27960);

    	itemRubraciumDustID = config.getOrCreateIntProperty("Rubracium Dust", "Rubracium Ids", 28000).getInt(28000);
    	itemRubraciumBarID = config.getOrCreateIntProperty("Rubracium Bar", "Rubracium Ids", 28001).getInt(28001);

    	itemQuicksilverDustID = config.getOrCreateIntProperty("Quicksilver Dust", "Quicksilver Ids", 28050).getInt(28050);
    	itemQuicksilverBarID = config.getOrCreateIntProperty("Quicksilver Bar", "Quicksilver Ids", 28051).getInt(28051);
    	itemQuicksilverPickaxeID = config.getOrCreateIntProperty("Quicksilver Pickaxe", "Quicksilver Ids", 28052).getInt(28052);
    	itemQuicksilverShovelID = config.getOrCreateIntProperty("Quicksilver Shovel", "Quicksilver Ids", 28053).getInt(28053);
    	itemQuicksilverAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Quicksilver Ids", 28054).getInt(28054);
    	itemQuicksilverHoeID = config.getOrCreateIntProperty("Quicksilver Hoe", "Quicksilver Ids", 28055).getInt(28055);
    	itemQuicksilverSwordID = config.getOrCreateIntProperty("Quicksilver Sword", "Quicksilver Ids", 28056).getInt(28056);
    	itemQuicksilverHelmetID = config.getOrCreateIntProperty("Quicksilver Helmet", "Quicksilver Ids", 28057).getInt(28057);
    	itemQuicksilverPlateID = config.getOrCreateIntProperty("Quicksilver Plate", "Quicksilver Ids", 28058).getInt(28058);
    	itemQuicksilverLegsID = config.getOrCreateIntProperty("Quicksilver Legs", "Quicksilver Ids", 28059).getInt(28059);
    	itemQuicksilverBootsID = config.getOrCreateIntProperty("Quicksilver Boots", "Quicksilver Ids", 28060).getInt(28060);

    	itemHaderothDustID = config.getOrCreateIntProperty("Haderoth Dust", "Haderoth Ids", 28100).getInt(28100);
    	itemHaderothBarID = config.getOrCreateIntProperty("Haderoth Bar", "Haderoth Ids", 28101).getInt(28101);
    	itemHaderothPickaxeID = config.getOrCreateIntProperty("Haderoth Pickaxe", "Haderoth Ids", 28102).getInt(28102);
    	itemHaderothShovelID = config.getOrCreateIntProperty("Haderoth Shovel", "Haderoth Ids", 28103).getInt(28103);
    	itemHaderothAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Haderoth Ids", 28104).getInt(28104);
    	itemHaderothHoeID = config.getOrCreateIntProperty("Haderoth Hoe", "Haderoth Ids", 28105).getInt(28105);
    	itemHaderothSwordID = config.getOrCreateIntProperty("Haderoth Sword", "Haderoth Ids", 28106).getInt(28106);
    	itemHaderothHelmetID = config.getOrCreateIntProperty("Haderoth Helmet", "Haderoth Ids", 28107).getInt(28107);
    	itemHaderothPlateID = config.getOrCreateIntProperty("Haderoth Plate", "Haderoth Ids", 28108).getInt(28108);
    	itemHaderothLegsID = config.getOrCreateIntProperty("Haderoth Legs", "Haderoth Ids", 28109).getInt(28109);
    	itemHaderothBootsID = config.getOrCreateIntProperty("Haderoth Boots", "Haderoth Ids", 28110).getInt(28110);

    	itemOrichalcumDustID = config.getOrCreateIntProperty("Orichalcum Dust", "Orichalcum Ids", 28150).getInt(28150);
    	itemOrichalcumBarID = config.getOrCreateIntProperty("Orichalcum Bar", "Orichalcum Ids", 28151).getInt(28151);
    	itemOrichalcumPickaxeID = config.getOrCreateIntProperty("Orichalcum Pickaxe", "Orichalcum Ids", 28152).getInt(28152);
    	itemOrichalcumShovelID = config.getOrCreateIntProperty("Orichalcum Shovel", "Orichalcum Ids", 28153).getInt(28153);
    	itemOrichalcumAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Orichalcum Ids", 28154).getInt(28154);
    	itemOrichalcumHoeID = config.getOrCreateIntProperty("Orichalcum Hoe", "Orichalcum Ids", 28155).getInt(28155);
    	itemOrichalcumSwordID = config.getOrCreateIntProperty("Orichalcum Sword", "Orichalcum Ids", 28156).getInt(28156);
    	itemOrichalcumHelmetID = config.getOrCreateIntProperty("Orichalcum Helmet", "Orichalcum Ids", 28157).getInt(28157);
    	itemOrichalcumPlateID = config.getOrCreateIntProperty("Orichalcum Plate", "Orichalcum Ids", 28158).getInt(28158);
    	itemOrichalcumLegsID = config.getOrCreateIntProperty("Orichalcum Legs", "Orichalcum Ids", 28159).getInt(28159);
    	itemOrichalcumBootsID = config.getOrCreateIntProperty("Orichalcum Boots", "Orichalcum Ids", 28160).getInt(28160);

    	itemCelenegilDustID = config.getOrCreateIntProperty("Celenegil Dust", "Celenegil Ids", 28200).getInt(28200);
    	itemCelenegilBarID = config.getOrCreateIntProperty("Celenegil Bar", "Celenegil Ids", 28201).getInt(28201);
    	itemCelenegilPickaxeID = config.getOrCreateIntProperty("Celenegil Pickaxe", "Celenegil Ids", 28202).getInt(28202);
    	itemCelenegilShovelID = config.getOrCreateIntProperty("Celenegil Shovel", "Celenegil Ids", 28203).getInt(28203);
    	itemCelenegilAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Celenegil Ids", 28204).getInt(28204);
    	itemCelenegilHoeID = config.getOrCreateIntProperty("Celenegil Hoe", "Celenegil Ids", 28205).getInt(28205);
    	itemCelenegilSwordID = config.getOrCreateIntProperty("Celenegil Sword", "Celenegil Ids", 28206).getInt(28206);
    	itemCelenegilHelmetID = config.getOrCreateIntProperty("Celenegil Helmet", "Celenegil Ids", 28207).getInt(28207);
    	itemCelenegilPlateID = config.getOrCreateIntProperty("Celenegil Plate", "Celenegil Ids", 28208).getInt(28208);
    	itemCelenegilLegsID = config.getOrCreateIntProperty("Celenegil Legs", "Celenegil Ids", 28209).getInt(28209);
    	itemCelenegilBootsID = config.getOrCreateIntProperty("Celenegil Boots", "Celenegil Ids", 28210).getInt(28210);

    	itemAdamantineDustID = config.getOrCreateIntProperty("Adamantine Dust", "Adamantine Ids", 28250).getInt(28250);
    	itemAdamantineBarID = config.getOrCreateIntProperty("Adamantine Bar", "Adamantine Ids", 28251).getInt(28251);
    	itemAdamantinePickaxeID = config.getOrCreateIntProperty("Adamantine Pickaxe", "Adamantine Ids", 28252).getInt(28252);
    	itemAdamantineShovelID = config.getOrCreateIntProperty("Adamantine Shovel", "Adamantine Ids", 28253).getInt(28253);
    	itemAdamantineAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Adamantine Ids", 28254).getInt(28254);
    	itemAdamantineHoeID = config.getOrCreateIntProperty("Adamantine Hoe", "Adamantine Ids", 28255).getInt(28255);
    	itemAdamantineSwordID = config.getOrCreateIntProperty("Adamantine Sword", "Adamantine Ids", 28256).getInt(28256);
    	itemAdamantineHelmetID = config.getOrCreateIntProperty("Adamantine Helmet", "Adamantine Ids", 28257).getInt(28257);
    	itemAdamantinePlateID = config.getOrCreateIntProperty("Adamantine Plate", "Adamantine Ids", 28258).getInt(28258);
    	itemAdamantineLegsID = config.getOrCreateIntProperty("Adamantine Legs", "Adamantine Ids", 28259).getInt(28259);
    	itemAdamantineBootsID = config.getOrCreateIntProperty("Adamantine Boots", "Adamantine Ids", 28260).getInt(28260);

    	itemAtlarusDustID = config.getOrCreateIntProperty("Atlarus Dust", "Atlarus Ids", 28300).getInt(28300);
    	itemAtlarusBarID = config.getOrCreateIntProperty("Atlarus Bar", "Atlarus Ids", 28301).getInt(28301);
    	itemAtlarusPickaxeID = config.getOrCreateIntProperty("Atlarus Pickaxe", "Atlarus Ids", 28302).getInt(28302);
    	itemAtlarusShovelID = config.getOrCreateIntProperty("Atlarus Shovel", "Atlarus Ids", 28303).getInt(28303);
    	itemAtlarusAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Atlarus Ids", 28304).getInt(28304);
    	itemAtlarusHoeID = config.getOrCreateIntProperty("Atlarus Hoe", "Atlarus Ids", 28305).getInt(28305);
    	itemAtlarusSwordID = config.getOrCreateIntProperty("Atlarus Sword", "Atlarus Ids", 28306).getInt(28306);
    	itemAtlarusHelmetID = config.getOrCreateIntProperty("Atlarus Helmet", "Atlarus Ids", 28307).getInt(28307);
    	itemAtlarusPlateID = config.getOrCreateIntProperty("Atlarus Plate", "Atlarus Ids", 28308).getInt(28308);
    	itemAtlarusLegsID = config.getOrCreateIntProperty("Atlarus Legs", "Atlarus Ids", 28309).getInt(28309);
    	itemAtlarusBootsID = config.getOrCreateIntProperty("Atlarus Boots", "Atlarus Ids", 28310).getInt(28310);

    	itemTartariteDustID = config.getOrCreateIntProperty("Tartarite Dust", "Tartarite Ids", 28350).getInt(28350);
    	itemTartariteBarID = config.getOrCreateIntProperty("Tartarite Bar", "Tartarite Ids", 28351).getInt(28351);
    	itemTartaritePickaxeID = config.getOrCreateIntProperty("Tartarite Pickaxe", "Tartarite Ids", 28352).getInt(28352);
    	itemTartariteShovelID = config.getOrCreateIntProperty("Tartarite Shovel", "Tartarite Ids", 28353).getInt(28353);
    	itemTartariteAxeID = config.getOrCreateIntProperty("Prometehum Axe", "Tartarite Ids", 28354).getInt(28354);
    	itemTartariteHoeID = config.getOrCreateIntProperty("Tartarite Hoe", "Tartarite Ids", 28355).getInt(28355);
    	itemTartariteSwordID = config.getOrCreateIntProperty("Tartarite Sword", "Tartarite Ids", 28356).getInt(28356);
    	itemTartariteHelmetID = config.getOrCreateIntProperty("Tartarite Helmet", "Tartarite Ids", 28357).getInt(28357);
    	itemTartaritePlateID = config.getOrCreateIntProperty("Tartarite Plate", "Tartarite Ids", 28358).getInt(28358);
    	itemTartariteLegsID = config.getOrCreateIntProperty("Tartarite Legs", "Tartarite Ids", 28359).getInt(28359);
    	itemTartariteBootsID = config.getOrCreateIntProperty("Tartarite Boots", "Tartarite Ids", 28360).getInt(28360);
    	
    	PrometheumVeinCount = config.getOrCreateIntProperty("Prometheum Vein Count", "Ore Generation", 6).getInt(6);
    	PrometheumOreCount = config.getOrCreateIntProperty("Prometheum Ore Count", "Ore Generation", 10).getInt(10);
    	PrometheumOreHeight = config.getOrCreateIntProperty("Prometheum Vein Count", "Ore Height", 128).getInt(128);
    	
    	DeepIronVeinCount = config.getOrCreateIntProperty("DeepIron Vein Count", "Ore Generation", 5).getInt(5);
    	DeepIronOreCount = config.getOrCreateIntProperty("DeepIron Ore Count", "Ore Generation", 4).getInt(4);
    	DeepIronOreHeight = config.getOrCreateIntProperty("DeepIron Vein Count", "Ore Height", 128).getInt(128);
    	
    	InfuscoliumVeinCount = config.getOrCreateIntProperty("Infuscolium Vein Count", "Ore Generation", 5).getInt(5);
    	InfuscoliumOreCount = config.getOrCreateIntProperty("Infuscolium Ore Count", "Ore Generation", 3).getInt(3);
    	InfuscoliumOreHeight = config.getOrCreateIntProperty("Infuscolium Vein Count", "Ore Height", 128).getInt(128);
    	
    	OureclaseVeinCount = config.getOrCreateIntProperty("Oureclase Vein Count", "Ore Generation", 4).getInt(4);
    	OureclaseOreCount = config.getOrCreateIntProperty("Oureclase Ore Count", "Ore Generation", 3).getInt(3);
    	OureclaseOreHeight = config.getOrCreateIntProperty("Oureclase Vein Count", "Ore Height", 128).getInt(128);
    	
    	AredriteVeinCount = config.getOrCreateIntProperty("Aredrite Vein Count", "Ore Generation", 4).getInt(4);
    	AredriteOreCount = config.getOrCreateIntProperty("Aredrite Ore Count", "Ore Generation", 3).getInt(3);
    	AredriteOreHeight = config.getOrCreateIntProperty("Aredrite Vein Count", "Ore Height", 128).getInt(128);
    	
    	AstralSilverVeinCount = config.getOrCreateIntProperty("AstralSilver Vein Count", "Ore Generation", 3).getInt(3);
    	AstralSilverOreCount = config.getOrCreateIntProperty("AstralSilver Ore Count", "Ore Generation", 3).getInt(3);
    	AstralSilverOreHeight = config.getOrCreateIntProperty("AstralSilver Vein Count", "Ore Height", 128).getInt(128);
    	
    	CarmotVeinCount = config.getOrCreateIntProperty("Carmot Vein Count", "Ore Generation", 3).getInt(3);
    	CarmotOreCount = config.getOrCreateIntProperty("Carmot Ore Count", "Ore Generation", 2).getInt(2);
    	CarmotOreHeight = config.getOrCreateIntProperty("Carmot Vein Count", "Ore Height", 128).getInt(128);
    	
    	MithrilVeinCount = config.getOrCreateIntProperty("Mithril Vein Count", "Ore Generation", 3).getInt(3);
    	MithrilOreCount = config.getOrCreateIntProperty("Mithril Ore Count", "Ore Generation", 3).getInt(3);
    	MithrilOreHeight = config.getOrCreateIntProperty("Mithril Vein Count", "Ore Height", 128).getInt(128);
    	
    	RubraciumVeinCount = config.getOrCreateIntProperty("Rubracium Vein Count", "Ore Generation", 2).getInt(2);
    	RubraciumOreCount = config.getOrCreateIntProperty("Rubracium Ore Count", "Ore Generation", 3).getInt(3);
    	RubraciumOreHeight = config.getOrCreateIntProperty("Rubracium Vein Count", "Ore Height", 128).getInt(128);
    	
    	OrichalcumVeinCount = config.getOrCreateIntProperty("Orichalcum Vein Count", "Ore Generation", 2).getInt(2);
    	OrichalcumOreCount = config.getOrCreateIntProperty("Orichalcum Ore Count", "Ore Generation", 4).getInt(4);
    	OrichalcumOreHeight = config.getOrCreateIntProperty("Orichalcum Vein Count", "Ore Height", 128).getInt(128);
    	
    	AdamantineVeinCount = config.getOrCreateIntProperty("Adamantine Vein Count", "Ore Generation", 1).getInt(1);
    	AdamantineOreCount = config.getOrCreateIntProperty("Adamantine Ore Count", "Ore Generation", 4).getInt(4);
    	AdamantineOreHeight = config.getOrCreateIntProperty("Adamantine Vein Count", "Ore Height", 128).getInt(128);
    	
    	AtlarusVeinCount = config.getOrCreateIntProperty("Atlarus Vein Count", "Ore Generation", 1).getInt(1);
    	AtlarusOreCount = config.getOrCreateIntProperty("Atlarus Ore Count", "Ore Generation", 3).getInt(3);
    	AtlarusOreHeight = config.getOrCreateIntProperty("Atlarus Vein Count", "Ore Height", 128).getInt(128);
    	
    	config.save();
	}
}
