package shadow.mods.metallurgy.fantasy;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.fantasy.*;

public class ClientProxy extends CommonProxy{

	public void addArmor()
	{
		((MetallurgyArmor) (OreAdamantine.adamantineHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("adamantine"));
		((MetallurgyArmor) (OreAdamantine.adamantinePlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("adamantine"));
		((MetallurgyArmor) (OreAdamantine.adamantineLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("adamantine"));
		((MetallurgyArmor) (OreAdamantine.adamantineBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("adamantine"));

		((MetallurgyArmor) (AlloyBlackSteel.blackSteelHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("blackSteel"));
		((MetallurgyArmor) (AlloyBlackSteel.blackSteelPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("blackSteel"));
		((MetallurgyArmor) (AlloyBlackSteel.blackSteelLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("blackSteel"));
		((MetallurgyArmor) (AlloyBlackSteel.blackSteelBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("blackSteel"));

		((MetallurgyArmor) (AlloyCelenegil.celenegilHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("celenegil"));
		((MetallurgyArmor) (AlloyCelenegil.celenegilPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("celenegil"));
		((MetallurgyArmor) (AlloyCelenegil.celenegilLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("celenegil"));
		((MetallurgyArmor) (AlloyCelenegil.celenegilBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("celenegil"));

		((MetallurgyArmor) (AlloyHaderoth.haderothHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("haderoth"));
		((MetallurgyArmor) (AlloyHaderoth.haderothPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("haderoth"));
		((MetallurgyArmor) (AlloyHaderoth.haderothLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("haderoth"));
		((MetallurgyArmor) (AlloyHaderoth.haderothBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("haderoth"));

		((MetallurgyArmor) (AlloyQuicksilver.quicksilverHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("quicksilver"));
		((MetallurgyArmor) (AlloyQuicksilver.quicksilverPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("quicksilver"));
		((MetallurgyArmor) (AlloyQuicksilver.quicksilverLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("quicksilver"));
		((MetallurgyArmor) (AlloyQuicksilver.quicksilverBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("quicksilver"));

		((MetallurgyArmor) (AlloyTartarite.tartariteHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("tartarite"));
		((MetallurgyArmor) (AlloyTartarite.tartaritePlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("tartarite"));
		((MetallurgyArmor) (AlloyTartarite.tartariteLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("tartarite"));
		((MetallurgyArmor) (AlloyTartarite.tartariteBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("tartarite"));

		((MetallurgyArmor) (OreAredrite.aredriteHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("aredrite"));
		((MetallurgyArmor) (OreAredrite.aredritePlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("aredrite"));
		((MetallurgyArmor) (OreAredrite.aredriteLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("aredrite"));
		((MetallurgyArmor) (OreAredrite.aredriteBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("aredrite"));

		((MetallurgyArmor) (OreAstralSilver.astralSilverHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("astralSilver"));
		((MetallurgyArmor) (OreAstralSilver.astralSilverPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("astralSilver"));
		((MetallurgyArmor) (OreAstralSilver.astralSilverLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("astralSilver"));
		((MetallurgyArmor) (OreAstralSilver.astralSilverBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("astralSilver"));

		((MetallurgyArmor) (OreAtlarus.atlarusHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("atlarus"));
		((MetallurgyArmor) (OreAtlarus.atlarusPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("atlarus"));
		((MetallurgyArmor) (OreAtlarus.atlarusLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("atlarus"));
		((MetallurgyArmor) (OreAtlarus.atlarusBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("atlarus"));

		((MetallurgyArmor) (OreCarmot.carmotHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("carmot"));
		((MetallurgyArmor) (OreCarmot.carmotPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("carmot"));
		((MetallurgyArmor) (OreCarmot.carmotLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("carmot"));
		((MetallurgyArmor) (OreCarmot.carmotBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("carmot"));

		((MetallurgyArmor) (OreDeepIron.deepIronHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("deepIron"));
		((MetallurgyArmor) (OreDeepIron.deepIronPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("deepIron"));
		((MetallurgyArmor) (OreDeepIron.deepIronLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("deepIron"));
		((MetallurgyArmor) (OreDeepIron.deepIronBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("deepIron"));

		((MetallurgyArmor) (OreMithril.mithrilHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("mithril"));
		((MetallurgyArmor) (OreMithril.mithrilPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("mithril"));
		((MetallurgyArmor) (OreMithril.mithrilLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("mithril"));
		((MetallurgyArmor) (OreMithril.mithrilBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("mithril"));

		((MetallurgyArmor) (OreOrichalcum.orichalcumHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("orichalcum"));
		((MetallurgyArmor) (OreOrichalcum.orichalcumPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("orichalcum"));
		((MetallurgyArmor) (OreOrichalcum.orichalcumLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("orichalcum"));
		((MetallurgyArmor) (OreOrichalcum.orichalcumBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("orichalcum"));

		((MetallurgyArmor) (OreOureclase.oureclaseHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("oureclase"));
		((MetallurgyArmor) (OreOureclase.oureclasePlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("oureclase"));
		((MetallurgyArmor) (OreOureclase.oureclaseLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("oureclase"));
		((MetallurgyArmor) (OreOureclase.oureclaseBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("oureclase"));

		((MetallurgyArmor) (OrePrometheum.prometheumHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("prometheum"));
		((MetallurgyArmor) (OrePrometheum.prometheumPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("prometheum"));
		((MetallurgyArmor) (OrePrometheum.prometheumLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("prometheum"));
		((MetallurgyArmor) (OrePrometheum.prometheumBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("prometheum"));
	}
	
	public void addNames()
	{
		ModLoader.addName(OreAdamantine.adamantineBar, "Adamantine Bar");
		ModLoader.addName(OreAdamantine.adamantineDust, "Adamantine Dust");
		ModLoader.addName(OreAdamantine.adamantinePickaxe, "Adamantine Pickaxe");
		ModLoader.addName(OreAdamantine.adamantineShovel, "Adamantine Shovel");
		ModLoader.addName(OreAdamantine.adamantineAxe, "Adamantine Axe");
		ModLoader.addName(OreAdamantine.adamantineHoe, "Adamantine Hoe");
		ModLoader.addName(OreAdamantine.adamantineSword, "Adamantine Sword");
		ModLoader.addName(OreAdamantine.adamantineHelmet, "Adamantine Helmet");
		ModLoader.addName(OreAdamantine.adamantinePlate, "Adamantine Plate");
		ModLoader.addName(OreAdamantine.adamantineLegs, "Adamantine Legs");
		ModLoader.addName(OreAdamantine.adamantineBoots, "Adamantine Boots");

		ModLoader.addName(OreAredrite.aredriteBar, "Aredrite Bar");
		ModLoader.addName(OreAredrite.aredriteDust, "Aredrite Dust");
		ModLoader.addName(OreAredrite.aredritePickaxe, "Aredrite Pickaxe");
		ModLoader.addName(OreAredrite.aredriteShovel, "Aredrite Shovel");
		ModLoader.addName(OreAredrite.aredriteAxe, "Aredrite Axe");
		ModLoader.addName(OreAredrite.aredriteHoe, "Aredrite Hoe");
		ModLoader.addName(OreAredrite.aredriteSword, "Aredrite Sword");
		ModLoader.addName(OreAredrite.aredriteHelmet, "Aredrite Helmet");
		ModLoader.addName(OreAredrite.aredritePlate, "Aredrite Plate");
		ModLoader.addName(OreAredrite.aredriteLegs, "Aredrite Legs");
		ModLoader.addName(OreAredrite.aredriteBoots, "Aredrite Boots");

		ModLoader.addName(OreAstralSilver.astralSilverBar, "Astral Silver Bar");
		ModLoader.addName(OreAstralSilver.astralSilverDust, "Astral Silver Dust");
		ModLoader.addName(OreAstralSilver.astralSilverPickaxe, "Astral Silver Pickaxe");
		ModLoader.addName(OreAstralSilver.astralSilverShovel, "Astral Silver Shovel");
		ModLoader.addName(OreAstralSilver.astralSilverAxe, "Astral Silver Axe");
		ModLoader.addName(OreAstralSilver.astralSilverHoe, "Astral Silver Hoe");
		ModLoader.addName(OreAstralSilver.astralSilverSword, "Astral Silver Sword");
		ModLoader.addName(OreAstralSilver.astralSilverHelmet, "Astral Silver Helmet");
		ModLoader.addName(OreAstralSilver.astralSilverPlate, "Astral Silver Plate");
		ModLoader.addName(OreAstralSilver.astralSilverLegs, "Astral Silver Legs");
		ModLoader.addName(OreAstralSilver.astralSilverBoots, "Astral Silver Boots");

		ModLoader.addName(OreAtlarus.atlarusBar, "Atlarus Bar");
		ModLoader.addName(OreAtlarus.atlarusDust, "Atlarus Dust");
		ModLoader.addName(OreAtlarus.atlarusPickaxe, "Atlarus Pickaxe");
		ModLoader.addName(OreAtlarus.atlarusShovel, "Atlarus Shovel");
		ModLoader.addName(OreAtlarus.atlarusAxe, "Atlarus Axe");
		ModLoader.addName(OreAtlarus.atlarusHoe, "Atlarus Hoe");
		ModLoader.addName(OreAtlarus.atlarusSword, "Atlarus Sword");
		ModLoader.addName(OreAtlarus.atlarusHelmet, "Atlarus Helmet");
		ModLoader.addName(OreAtlarus.atlarusPlate, "Atlarus Plate");
		ModLoader.addName(OreAtlarus.atlarusLegs, "Atlarus Legs");
		ModLoader.addName(OreAtlarus.atlarusBoots, "Atlarus Boots");

		ModLoader.addName(AlloyBlackSteel.blackSteelBar, "Black Steel Bar");
		ModLoader.addName(AlloyBlackSteel.blackSteelDust, "Black Steel Dust");
		ModLoader.addName(AlloyBlackSteel.blackSteelPickaxe, "Black Steel Pickaxe");
		ModLoader.addName(AlloyBlackSteel.blackSteelShovel, "Black Steel Shovel");
		ModLoader.addName(AlloyBlackSteel.blackSteelAxe, "Black Steel Axe");
		ModLoader.addName(AlloyBlackSteel.blackSteelHoe, "Black Steel Hoe");
		ModLoader.addName(AlloyBlackSteel.blackSteelSword, "Black Steel Sword");
		ModLoader.addName(AlloyBlackSteel.blackSteelHelmet, "Black Steel Helmet");
		ModLoader.addName(AlloyBlackSteel.blackSteelPlate, "Black Steel Plate");
		ModLoader.addName(AlloyBlackSteel.blackSteelLegs, "Black Steel Legs");
		ModLoader.addName(AlloyBlackSteel.blackSteelBoots, "Black Steel Boots");

		ModLoader.addName(OreCarmot.carmotBar, "Carmot Bar");
		ModLoader.addName(OreCarmot.carmotDust, "Carmot Dust");
		ModLoader.addName(OreCarmot.carmotPickaxe, "Carmot Pickaxe");
		ModLoader.addName(OreCarmot.carmotShovel, "Carmot Shovel");
		ModLoader.addName(OreCarmot.carmotAxe, "Carmot Axe");
		ModLoader.addName(OreCarmot.carmotHoe, "Carmot Hoe");
		ModLoader.addName(OreCarmot.carmotSword, "Carmot Sword");
		ModLoader.addName(OreCarmot.carmotHelmet, "Carmot Helmet");
		ModLoader.addName(OreCarmot.carmotPlate, "Carmot Plate");
		ModLoader.addName(OreCarmot.carmotLegs, "Carmot Legs");
		ModLoader.addName(OreCarmot.carmotBoots, "Carmot Boots");

		ModLoader.addName(AlloyCelenegil.celenegilBar, "Celenegil Bar");
		ModLoader.addName(AlloyCelenegil.celenegilDust, "Celenegil Dust");
		ModLoader.addName(AlloyCelenegil.celenegilPickaxe, "Celenegil Pickaxe");
		ModLoader.addName(AlloyCelenegil.celenegilShovel, "Celenegil Shovel");
		ModLoader.addName(AlloyCelenegil.celenegilAxe, "Celenegil Axe");
		ModLoader.addName(AlloyCelenegil.celenegilHoe, "Celenegil Hoe");
		ModLoader.addName(AlloyCelenegil.celenegilSword, "Celenegil Sword");
		ModLoader.addName(AlloyCelenegil.celenegilHelmet, "Celenegil Helmet");
		ModLoader.addName(AlloyCelenegil.celenegilPlate, "Celenegil Plate");
		ModLoader.addName(AlloyCelenegil.celenegilLegs, "Celenegil Legs");
		ModLoader.addName(AlloyCelenegil.celenegilBoots, "Celenegil Boots");

		ModLoader.addName(OreDeepIron.deepIronBar, "Deep Iron Bar");
		ModLoader.addName(OreDeepIron.deepIronDust, "Deep Iron Dust");
		ModLoader.addName(OreDeepIron.deepIronPickaxe, "Deep Iron Pickaxe");
		ModLoader.addName(OreDeepIron.deepIronShovel, "Deep Iron Shovel");
		ModLoader.addName(OreDeepIron.deepIronAxe, "Deep Iron Axe");
		ModLoader.addName(OreDeepIron.deepIronHoe, "Deep Iron Hoe");
		ModLoader.addName(OreDeepIron.deepIronSword, "Deep Iron Sword");
		ModLoader.addName(OreDeepIron.deepIronHelmet, "Deep Iron Helmet");
		ModLoader.addName(OreDeepIron.deepIronPlate, "Deep Iron Plate");
		ModLoader.addName(OreDeepIron.deepIronLegs, "Deep Iron Legs");
		ModLoader.addName(OreDeepIron.deepIronBoots, "Deep Iron Boots");

		ModLoader.addName(AlloyHaderoth.haderothBar, "Haderoth Bar");
		ModLoader.addName(AlloyHaderoth.haderothDust, "Haderoth Dust");
		ModLoader.addName(AlloyHaderoth.haderothPickaxe, "Haderoth Pickaxe");
		ModLoader.addName(AlloyHaderoth.haderothShovel, "Haderoth Shovel");
		ModLoader.addName(AlloyHaderoth.haderothAxe, "Haderoth Axe");
		ModLoader.addName(AlloyHaderoth.haderothHoe, "Haderoth Hoe");
		ModLoader.addName(AlloyHaderoth.haderothSword, "Haderoth Sword");
		ModLoader.addName(AlloyHaderoth.haderothHelmet, "Haderoth Helmet");
		ModLoader.addName(AlloyHaderoth.haderothPlate, "Haderoth Plate");
		ModLoader.addName(AlloyHaderoth.haderothLegs, "Haderoth Legs");
		ModLoader.addName(AlloyHaderoth.haderothBoots, "Haderoth Boots");

		ModLoader.addName(OreInfuscolium.infuscoliumBar, "Infuscolium Bar");
		ModLoader.addName(OreInfuscolium.infuscoliumDust, "Infuscolium Dust");

		ModLoader.addName(OreMithril.mithrilBar, "Mithril Bar");
		ModLoader.addName(OreMithril.mithrilDust, "Mithril Dust");
		ModLoader.addName(OreMithril.mithrilPickaxe, "Mithril Pickaxe");
		ModLoader.addName(OreMithril.mithrilShovel, "Mithril Shovel");
		ModLoader.addName(OreMithril.mithrilAxe, "Mithril Axe");
		ModLoader.addName(OreMithril.mithrilHoe, "Mithril Hoe");
		ModLoader.addName(OreMithril.mithrilSword, "Mithril Sword");
		ModLoader.addName(OreMithril.mithrilHelmet, "Mithril Helmet");
		ModLoader.addName(OreMithril.mithrilPlate, "Mithril Plate");
		ModLoader.addName(OreMithril.mithrilLegs, "Mithril Legs");
		ModLoader.addName(OreMithril.mithrilBoots, "Mithril Boots");

		ModLoader.addName(OreOrichalcum.orichalcumBar, "Orichalcum Bar");
		ModLoader.addName(OreOrichalcum.orichalcumDust, "Orichalcum Dust");
		ModLoader.addName(OreOrichalcum.orichalcumPickaxe, "Orichalcum Pickaxe");
		ModLoader.addName(OreOrichalcum.orichalcumShovel, "Orichalcum Shovel");
		ModLoader.addName(OreOrichalcum.orichalcumAxe, "Orichalcum Axe");
		ModLoader.addName(OreOrichalcum.orichalcumHoe, "Orichalcum Hoe");
		ModLoader.addName(OreOrichalcum.orichalcumSword, "Orichalcum Sword");
		ModLoader.addName(OreOrichalcum.orichalcumHelmet, "Orichalcum Helmet");
		ModLoader.addName(OreOrichalcum.orichalcumPlate, "Orichalcum Plate");
		ModLoader.addName(OreOrichalcum.orichalcumLegs, "Orichalcum Legs");
		ModLoader.addName(OreOrichalcum.orichalcumBoots, "Orichalcum Boots");

		ModLoader.addName(OreOureclase.oureclaseBar, "Oureclase Bar");
		ModLoader.addName(OreOureclase.oureclaseDust, "Oureclase Dust");
		ModLoader.addName(OreOureclase.oureclasePickaxe, "Oureclase Pickaxe");
		ModLoader.addName(OreOureclase.oureclaseShovel, "Oureclase Shovel");
		ModLoader.addName(OreOureclase.oureclaseAxe, "Oureclase Axe");
		ModLoader.addName(OreOureclase.oureclaseHoe, "Oureclase Hoe");
		ModLoader.addName(OreOureclase.oureclaseSword, "Oureclase Sword");
		ModLoader.addName(OreOureclase.oureclaseHelmet, "Oureclase Helmet");
		ModLoader.addName(OreOureclase.oureclasePlate, "Oureclase Plate");
		ModLoader.addName(OreOureclase.oureclaseLegs, "Oureclase Legs");
		ModLoader.addName(OreOureclase.oureclaseBoots, "Oureclase Boots");

		ModLoader.addName(OrePrometheum.prometheumBar, "Prometheum Bar");
		ModLoader.addName(OrePrometheum.prometheumDust, "Prometheum Dust");
		ModLoader.addName(OrePrometheum.prometheumPickaxe, "Prometheum Pickaxe");
		ModLoader.addName(OrePrometheum.prometheumShovel, "Prometheum Shovel");
		ModLoader.addName(OrePrometheum.prometheumAxe, "Prometheum Axe");
		ModLoader.addName(OrePrometheum.prometheumHoe, "Prometheum Hoe");
		ModLoader.addName(OrePrometheum.prometheumSword, "Prometheum Sword");
		ModLoader.addName(OrePrometheum.prometheumHelmet, "Prometheum Helmet");
		ModLoader.addName(OrePrometheum.prometheumPlate, "Prometheum Plate");
		ModLoader.addName(OrePrometheum.prometheumLegs, "Prometheum Legs");
		ModLoader.addName(OrePrometheum.prometheumBoots, "Prometheum Boots");

		ModLoader.addName(AlloyQuicksilver.quicksilverBar, "Quicksilver Bar");
		ModLoader.addName(AlloyQuicksilver.quicksilverDust, "Quicksilver Dust");
		ModLoader.addName(AlloyQuicksilver.quicksilverPickaxe, "Quicksilver Pickaxe");
		ModLoader.addName(AlloyQuicksilver.quicksilverShovel, "Quicksilver Shovel");
		ModLoader.addName(AlloyQuicksilver.quicksilverAxe, "Quicksilver Axe");
		ModLoader.addName(AlloyQuicksilver.quicksilverHoe, "Quicksilver Hoe");
		ModLoader.addName(AlloyQuicksilver.quicksilverSword, "Quicksilver Sword");
		ModLoader.addName(AlloyQuicksilver.quicksilverHelmet, "Quicksilver Helmet");
		ModLoader.addName(AlloyQuicksilver.quicksilverPlate, "Quicksilver Plate");
		ModLoader.addName(AlloyQuicksilver.quicksilverLegs, "Quicksilver Legs");
		ModLoader.addName(AlloyQuicksilver.quicksilverBoots, "Quicksilver Boots");

		ModLoader.addName(OreRubracium.rubraciumBar, "Rubracium Bar");
		ModLoader.addName(OreRubracium.rubraciumDust, "Rubracium Dust");
		
		ModLoader.addName(AlloyTartarite.tartariteBar, "Tartarite Bar");
		ModLoader.addName(AlloyTartarite.tartariteDust, "Tartarite Dust");
		ModLoader.addName(AlloyTartarite.tartaritePickaxe, "Tartarite Pickaxe");
		ModLoader.addName(AlloyTartarite.tartariteShovel, "Tartarite Shovel");
		ModLoader.addName(AlloyTartarite.tartariteAxe, "Tartarite Axe");
		ModLoader.addName(AlloyTartarite.tartariteHoe, "Tartarite Hoe");
		ModLoader.addName(AlloyTartarite.tartariteSword, "Tartarite Sword");
		ModLoader.addName(AlloyTartarite.tartariteHelmet, "Tartarite Helmet");
		ModLoader.addName(AlloyTartarite.tartaritePlate, "Tartarite Plate");
		ModLoader.addName(AlloyTartarite.tartariteLegs, "Tartarite Legs");
		ModLoader.addName(AlloyTartarite.tartariteBoots, "Tartarite Boots");

		
		ModLoader.addLocalization("tile.MetalFantasyFurnace.PrometheumFurnace.name", "Prometheum Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.DeepIronFurnace.name", "Deep Iron Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.BlackSteelFurnace.name", "Black Steel Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.OureclaseFurnace.name", "Oureclase Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AredriteFurnace.name", "Aredrite Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.MithrilFurnace.name", "Mithril Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.HaderothFurnace.name", "Haderoth Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.OrichalcumFurnace.name", "Orichalcum Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AdamantineFurnace.name", "Adamantine Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AtlarusFurnace.name", "Atlarus Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.TartariteFurnace.name", "Tartarite Abstractor");
		
		ModLoader.addLocalization("tile.FantasyVein.PrometheumOre.name", "Prometheum Ore");
		ModLoader.addLocalization("tile.FantasyVein.DeepIronOre.name", "Deep Iron Ore");
		ModLoader.addLocalization("tile.FantasyVein.InfuscoliumOre.name", "Infuscolium Ore");
		ModLoader.addLocalization("tile.FantasyVein.OureclaseOre.name", "Oureclase Ore");
		ModLoader.addLocalization("tile.FantasyVein.AredriteOre.name", "Aredrite Ore");
		ModLoader.addLocalization("tile.FantasyVein.AstralSilverOre.name", "Astral Silver Ore");
		ModLoader.addLocalization("tile.FantasyVein.CarmotOre.name", "Carmot Ore");
		ModLoader.addLocalization("tile.FantasyVein.MithrilOre.name", "Mithril Ore");
		ModLoader.addLocalization("tile.FantasyVein.RubraciumOre.name", "Rubracium Ore");
		ModLoader.addLocalization("tile.FantasyVein.OrichalcumOre.name", "Orichalcum Ore");
		ModLoader.addLocalization("tile.FantasyVein.AdamantineOre.name", "Adamantine Ore");
		ModLoader.addLocalization("tile.FantasyVein.AtlarusOre.name", "Atlarus Ore");

		ModLoader.addLocalization("tile.FantasyBrickMetals.PrometheumBrick.name", "Prometheum Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.DeepIronBrick.name", "Deep Iron Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.InfuscoliumBrick.name", "Infuscoliums Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.OureclaseBrick.name", "Oureclase Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.AredriteBrick.name", "Aredrite Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.AstralSilverBrick.name", "Astral Silver Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.CarmotBrick.name", "Carmot Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.MithrilBrick.name", "Mithril Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.RubraciumBrick.name", "Rubracium Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.OrichalcumBrick.name", "Orichalcum Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.AdamantineBrick.name", "Adamantine Brick");
		ModLoader.addLocalization("tile.FantasyBrickMetals.AtlarusBrick.name", "Atlarus Brick");

		ModLoader.addLocalization("tile.FantasyBrickAlloys.BlackSteelBrick.name", "Black Steel Brick");
		ModLoader.addLocalization("tile.FantasyBrickAlloys.QuicksilverBrick.name", "Quicksilver Brick");
		ModLoader.addLocalization("tile.FantasyBrickAlloys.HaderothBrick.name", "Haderoth Brick");
		ModLoader.addLocalization("tile.FantasyBrickAlloys.CelenegilBrick.name", "Celenegil Brick");
		ModLoader.addLocalization("tile.FantasyBrickAlloys.TartariteBrick.name", "Tartarite Brick");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFurnaces.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFantasyMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFantasyAlloys.png");
	}
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
