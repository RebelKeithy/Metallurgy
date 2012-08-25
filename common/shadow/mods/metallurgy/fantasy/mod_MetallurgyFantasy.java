package shadow.mods.metallurgy.fantasy;

import java.io.File;
import java.util.Random;

import shadow.mods.metallurgy.base.BaseWorldGen;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;

@Mod(modid = "MetallurgyFantasy", name = "Metallurgy Fantasy", version = "1.3")
@NetworkMod(channels = { "MetallurgyFantas" }, clientSideRequired = true, serverSideRequired = false, packetHandler = PacketHandler.class )
public class mod_MetallurgyFantasy
{

	@SidedProxy(clientSide = "shadow.mods.metallurgy.fantasy.ClientProxy", serverSide = "shadow.mods.metallurgy.fantasy.CommonProxy")
	public static CommonProxy proxy;
	
	@Instance
	public static mod_MetallurgyFantasy instance;
	
	public static Block vein;
	public static Block brickMetals;
	public static Block brickAlloys;
	
	public mod_MetallurgyFantasy()
	{
		instance = this;
	}
	
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		FantasyConfig.init();

		proxy.registerRenderInformation();
		
		vein = new BlockMetalsVein(FantasyConfig.veinID, "/shadow/MetallurgyFantasyMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("FantasyVein");
		brickMetals = new BlockMetalsBrick(FantasyConfig.brickMetalsID, "/shadow/MetallurgyFantasyMetals.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("FantasyBrickMetals");
		brickAlloys = new BlockAlloysBrick(FantasyConfig.brickAlloysID, "/shadow/MetallurgyFantasyAlloys.png", Material.iron).setHardness(2F).setResistance(.1F).setBlockName("FantasyBrickAlloys");
	}
	
	@Init
	public void load(FMLInitializationEvent event) 
	{
		GameRegistry.registerBlock(vein, BlockMetalsVeinItem.class);
		GameRegistry.registerBlock(brickMetals, BlockMetalsBrickItem.class);
		GameRegistry.registerBlock(brickAlloys, BlockAlloysBrickItem.class);

		load();
		
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		GameRegistry.registerWorldGenerator(new FantasyWorldGen());
		
		proxy.addNames();
		proxy.addArmor();
		
		setBlockHarvestLevels();
		registerOres();
		setToolLevels();
		
		FF_EssenceRecipes.essence().addEssenceAmount(Block.oreGold.blockID, 10);
	}
	
	public void setBlockHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(vein, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(vein, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(vein, 2, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(vein, 3, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(vein, 4, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(vein, 5, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(vein, 6, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(vein, 7, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(vein, 8, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(vein, 9, "pickaxe", 5);
		MinecraftForge.setBlockHarvestLevel(vein, 10, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(vein, 11, "pickaxe", 6);

		MinecraftForge.setBlockHarvestLevel(brickMetals, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 1, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 2, "pickaxe", 2); //Infuscolium
		MinecraftForge.setBlockHarvestLevel(brickMetals, 3, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 4, "pickaxe", 3);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 5, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 6, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 7, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 8, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 9, "pickaxe", 5);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 10, "pickaxe", 6);
		MinecraftForge.setBlockHarvestLevel(brickMetals, 11, "pickaxe", 6);
		
		MinecraftForge.setBlockHarvestLevel(brickAlloys, 0, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(brickAlloys, 1, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickAlloys, 2, "pickaxe", 4);
		MinecraftForge.setBlockHarvestLevel(brickAlloys, 3, "pickaxe", 5);
		MinecraftForge.setBlockHarvestLevel(brickAlloys, 4, "pickaxe", 7);
	}
	
	public void setToolLevels()
	{
		MinecraftForge.setToolClass(OreAdamantine.adamantinePickaxe, "pickaxe", 7);
		MinecraftForge.setToolClass(OreAredrite.aredritePickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(OreAstralSilver.astralSilverPickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(OreAtlarus.atlarusPickaxe, "pickaxe", 7);
		MinecraftForge.setToolClass(AlloyBlackSteel.blackSteelPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(OreCarmot.carmotPickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(AlloyCelenegil.celenegilPickaxe, "pickaxe", 6);
		MinecraftForge.setToolClass(OreDeepIron.deepIronPickaxe, "pickaxe", 3);
		MinecraftForge.setToolClass(AlloyHaderoth.haderothPickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(OreMithril.mithrilPickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(OreOrichalcum.orichalcumPickaxe, "pickaxe", 6);
		MinecraftForge.setToolClass(OreOureclase.oureclasePickaxe, "pickaxe", 4);
		MinecraftForge.setToolClass(OrePrometheum.prometheumPickaxe, "pickaxe", 2);
		MinecraftForge.setToolClass(AlloyQuicksilver.quicksilverPickaxe, "pickaxe", 5);
		MinecraftForge.setToolClass(AlloyTartarite.tartaritePickaxe, "pickaxe", 8);
	}

	public void registerOres()
	{
		OreDictionary.registerOre("oreAdamantine", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreAdamantine.meta));
		OreDictionary.registerOre("dustAdamantine", new ItemStack(OreAdamantine.adamantineDust, 1));
		OreDictionary.registerOre("ingotAdamantine", new ItemStack(OreAdamantine.adamantineBar, 1));

		OreDictionary.registerOre("oreAredrite", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreAredrite.meta));
		OreDictionary.registerOre("dustAredrite", new ItemStack(OreAredrite.aredriteDust, 1));
		OreDictionary.registerOre("ingotAredrite", new ItemStack(OreAredrite.aredriteBar, 1));

		OreDictionary.registerOre("oreAstralSilver", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreAstralSilver.meta));
		OreDictionary.registerOre("dustAstralSilver", new ItemStack(OreAstralSilver.astralSilverDust, 1));
		OreDictionary.registerOre("ingotAstralSilver", new ItemStack(OreAstralSilver.astralSilverBar, 1));

		OreDictionary.registerOre("oreAtlarus", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreAtlarus.meta));
		OreDictionary.registerOre("dustAtlarus", new ItemStack(OreAtlarus.atlarusDust, 1));
		OreDictionary.registerOre("ingotAtlarus", new ItemStack(OreAtlarus.atlarusBar, 1));

		OreDictionary.registerOre("dustBlackSteel", new ItemStack(AlloyBlackSteel.blackSteelDust, 1));
		OreDictionary.registerOre("ingotBlackSteel", new ItemStack(AlloyBlackSteel.blackSteelBar, 1));

		OreDictionary.registerOre("oreCarmot", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreCarmot.meta));
		OreDictionary.registerOre("dustCarmot", new ItemStack(OreCarmot.carmotDust, 1));
		OreDictionary.registerOre("ingotCarmot", new ItemStack(OreCarmot.carmotBar, 1));

		OreDictionary.registerOre("dustCelenegil", new ItemStack(AlloyCelenegil.celenegilDust, 1));
		OreDictionary.registerOre("ingotCelenegil", new ItemStack(AlloyCelenegil.celenegilBar, 1));

		OreDictionary.registerOre("oredeepIron", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreDeepIron.meta));
		OreDictionary.registerOre("dustdeepIron", new ItemStack(OreDeepIron.deepIronDust, 1));
		OreDictionary.registerOre("ingotdeepIron", new ItemStack(OreDeepIron.deepIronBar, 1));

		OreDictionary.registerOre("dustHaderoth", new ItemStack(AlloyHaderoth.haderothDust, 1));
		OreDictionary.registerOre("ingotHaderoth", new ItemStack(AlloyHaderoth.haderothBar, 1));
		
		OreDictionary.registerOre("oreInfuscolium", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreInfuscolium.meta));
		OreDictionary.registerOre("dustInfuscolium", new ItemStack(OreInfuscolium.infuscoliumDust, 1));
		OreDictionary.registerOre("ingotInfuscolium", new ItemStack(OreInfuscolium.infuscoliumBar, 1));

		OreDictionary.registerOre("oreMithril", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreMithril.meta));
		OreDictionary.registerOre("dustMithril", new ItemStack(OreMithril.mithrilDust, 1));
		OreDictionary.registerOre("ingotMithril", new ItemStack(OreMithril.mithrilBar, 1));

		OreDictionary.registerOre("oreOrichalcum", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreOrichalcum.meta));
		OreDictionary.registerOre("dustOrichalcum", new ItemStack(OreOrichalcum.orichalcumDust, 1));
		OreDictionary.registerOre("ingotOrichalcum", new ItemStack(OreOrichalcum.orichalcumBar, 1));

		OreDictionary.registerOre("oreOureclase", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreOureclase.meta));
		OreDictionary.registerOre("dustOureclase", new ItemStack(OreOureclase.oureclaseDust, 1));
		OreDictionary.registerOre("ingotOureclase", new ItemStack(OreOureclase.oureclaseBar, 1));

		OreDictionary.registerOre("orePrometheum", new ItemStack(mod_MetallurgyFantasy.vein, 1, OrePrometheum.meta));
		OreDictionary.registerOre("dustPrometheum", new ItemStack(OrePrometheum.prometheumDust, 1));
		OreDictionary.registerOre("ingotPrometheum", new ItemStack(OrePrometheum.prometheumBar, 1));

		OreDictionary.registerOre("dustQuicksilver", new ItemStack(AlloyQuicksilver.quicksilverDust, 1));
		OreDictionary.registerOre("ingotQuicksilver", new ItemStack(AlloyQuicksilver.quicksilverBar, 1));

		OreDictionary.registerOre("oreRubracium", new ItemStack(mod_MetallurgyFantasy.vein, 1, OreRubracium.meta));
		OreDictionary.registerOre("dustRubracium", new ItemStack(OreRubracium.rubraciumDust, 1));
		OreDictionary.registerOre("ingotRubracium", new ItemStack(OreRubracium.rubraciumBar, 1));

		OreDictionary.registerOre("dustTartarite", new ItemStack(AlloyTartarite.tartariteDust, 1));
		OreDictionary.registerOre("ingotTartarite", new ItemStack(AlloyTartarite.tartariteBar, 1));
	}
	

	public void load() {
		mod_FantasyFurnace.load();
		
		if(FantasyConfig.prometheumEnabled)
			OrePrometheum.load();
		if(FantasyConfig.deepIronEnabled)
			OreDeepIron.load();
		if(FantasyConfig.infuscoliumEnabled)
			OreInfuscolium.load();
		if(FantasyConfig.oureclaseEnabled)
			OreOureclase.load();
		if(FantasyConfig.aredriteEnabled)
			OreAredrite.load();
		if(FantasyConfig.astralSilverEnabled)
			OreAstralSilver.load();
		if(FantasyConfig.carmotEnabled)
			OreCarmot.load();
		if(FantasyConfig.mithrilEnabled)
			OreMithril.load();
		if(FantasyConfig.rubraciumEnabled)
			OreRubracium.load();
		if(FantasyConfig.orichalcumEnabled)
			OreOrichalcum.load();
		if(FantasyConfig.adamantineEnabled)
			OreAdamantine.load();
		if(FantasyConfig.atlarusEnabled)
			OreAtlarus.load();

		if(FantasyConfig.blackSteelEnabled)
			AlloyBlackSteel.load();
		if(FantasyConfig.quicksilverEnabled)
			AlloyQuicksilver.load();
		if(FantasyConfig.haderothEnabled)
			AlloyHaderoth.load();
		if(FantasyConfig.celenegilEnabled)
			AlloyCelenegil.load();
		if(FantasyConfig.tartariteEnabled)
			AlloyTartarite.load();
		
	}
}
