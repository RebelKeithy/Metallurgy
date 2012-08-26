package shadow.mods.metallurgy.base;

import java.io.File;

import net.minecraft.client.Minecraft;
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
import shadow.mods.metallurgy.base.*;

public class ClientProxy extends CommonProxy{

	public void addArmor()
	{
		((MetallurgyArmor) (AlloyAngmallen.AngmallenHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("angmallen"));
		((MetallurgyArmor) (AlloyAngmallen.AngmallenPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("angmallen"));
		((MetallurgyArmor) (AlloyAngmallen.AngmallenLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("angmellen"));
		((MetallurgyArmor) (AlloyAngmallen.AngmallenBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("angmellen"));

		((MetallurgyArmor) (AlloyBronze.BronzeHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("bronze"));
		((MetallurgyArmor) (AlloyBronze.BronzePlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("bronze"));
		((MetallurgyArmor) (AlloyBronze.BronzeLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("bronze"));
		((MetallurgyArmor) (AlloyBronze.BronzeBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("bronze"));

		((MetallurgyArmor) (AlloyDamascusSteel.DamascusSteelHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("damascussteel"));
		((MetallurgyArmor) (AlloyDamascusSteel.DamascusSteelPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("damascussteel"));
		((MetallurgyArmor) (AlloyDamascusSteel.DamascusSteelLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("damascussteel"));
		((MetallurgyArmor) (AlloyDamascusSteel.DamascusSteelBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("damascussteel"));

		((MetallurgyArmor) (AlloyHepatizon.HepatizonHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("hepatizon"));
		((MetallurgyArmor) (AlloyHepatizon.HepatizonPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("hepatizon"));
		((MetallurgyArmor) (AlloyHepatizon.HepatizonLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("hepatizon"));
		((MetallurgyArmor) (AlloyHepatizon.HepatizonBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("hepatizon"));
		
		((MetallurgyArmor) (OreCopper.CopperHelmet)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("copper"));
		((MetallurgyArmor) (OreCopper.CopperPlate)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("copper"));
		((MetallurgyArmor) (OreCopper.CopperLegs)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("copper"));
		((MetallurgyArmor) (OreCopper.CopperBoots)).setTexture(RenderingRegistry.addNewArmourRendererPrefix("copper"));
	}
	
	public void addNames()
	{
		ModLoader.addName(AlloyAngmallen.AngmallenBar, "Angmallen Bar");
		ModLoader.addName(AlloyAngmallen.AngmallenDust, "Angmallen Dust");
		ModLoader.addName(AlloyAngmallen.AngmallenPickaxe, "Angmallen Pickaxe");
		ModLoader.addName(AlloyAngmallen.AngmallenShovel, "Angmallen Shovel");
		ModLoader.addName(AlloyAngmallen.AngmallenAxe, "Angmallen Axe");
		ModLoader.addName(AlloyAngmallen.AngmallenHoe, "Angmallen Hoe");
		ModLoader.addName(AlloyAngmallen.AngmallenSword, "Angmallen Sword");
		ModLoader.addName(AlloyAngmallen.AngmallenHelmet, "Angmallen Helmet");
		ModLoader.addName(AlloyAngmallen.AngmallenPlate, "Angmallen Plate");
		ModLoader.addName(AlloyAngmallen.AngmallenLegs, "Angmallen Legs");
		ModLoader.addName(AlloyAngmallen.AngmallenBoots, "Angmallen Boots");
		
		ModLoader.addName(AlloyBronze.BronzeBar, "Bronze Bar");
		ModLoader.addName(AlloyBronze.BronzeDust, "Bronze Dust");
		ModLoader.addName(AlloyBronze.BronzePickaxe, "Bronze Pickaxe");
		ModLoader.addName(AlloyBronze.BronzeShovel, "Bronze Shovel");
		ModLoader.addName(AlloyBronze.BronzeAxe, "Bronze Axe");
		ModLoader.addName(AlloyBronze.BronzeHoe, "Bronze Hoe");
		ModLoader.addName(AlloyBronze.BronzeSword, "Bronze Sword");
		ModLoader.addName(AlloyBronze.BronzeHelmet, "Bronze Helmet");
		ModLoader.addName(AlloyBronze.BronzePlate, "Bronze Plate");
		ModLoader.addName(AlloyBronze.BronzeLegs, "Bronze Legs");
		ModLoader.addName(AlloyBronze.BronzeBoots, "Bronze Boots");

		ModLoader.addName(AlloyDamascusSteel.DamascusSteelBar, "Damascus Steel Bar");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelDust, "Damascus Steel Dust");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelPickaxe, "Damascus Steel Pickaxe");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelShovel, "Damascus Steel Shovel");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelAxe, "Damascus Steel Axe");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelHoe, "Damascus Steel Hoe");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelSword, "Damascus Steel Sword");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelHelmet, "Damascus Steel Helmet");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelPlate, "Damascus Steel Plate");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelLegs, "Damascus Steel Legs");
		ModLoader.addName(AlloyDamascusSteel.DamascusSteelBoots, "Damascus Steel Boots");

		ModLoader.addName(AlloyHepatizon.HepatizonBar, "Hepatizon Bar");
		ModLoader.addName(AlloyHepatizon.HepatizonDust, "Hepatizon Dust");
		ModLoader.addName(AlloyHepatizon.HepatizonPickaxe, "Hepatizon Pickaxe");
		ModLoader.addName(AlloyHepatizon.HepatizonShovel, "Hepatizon Shovel");
		ModLoader.addName(AlloyHepatizon.HepatizonAxe, "Hepatizon Axe");
		ModLoader.addName(AlloyHepatizon.HepatizonHoe, "Hepatizon Hoe");
		ModLoader.addName(AlloyHepatizon.HepatizonSword, "Hepatizon Sword");
		ModLoader.addName(AlloyHepatizon.HepatizonHelmet, "Hepatizon Helmet");
		ModLoader.addName(AlloyHepatizon.HepatizonPlate, "Hepatizon Plate");
		ModLoader.addName(AlloyHepatizon.HepatizonLegs, "Hepatizon Legs");
		ModLoader.addName(AlloyHepatizon.HepatizonBoots, "Hepatizon Boots");

		ModLoader.addName(AlloySteel.SteelBar, "Steel Bar");
		ModLoader.addName(AlloySteel.SteelDust, "Steel Dust");
		ModLoader.addName(AlloySteel.SteelPickaxe, "Steel Pickaxe");
		ModLoader.addName(AlloySteel.SteelShovel, "Steel Shovel");
		ModLoader.addName(AlloySteel.SteelAxe, "Steel Axe");
		ModLoader.addName(AlloySteel.SteelHoe, "Steel Hoe");
		ModLoader.addName(AlloySteel.SteelSword, "Steel Sword");
		ModLoader.addName(AlloySteel.SteelHelmet, "Steel Helmet");
		ModLoader.addName(AlloySteel.SteelPlate, "Steel Plate");
		ModLoader.addName(AlloySteel.SteelLegs, "Steel Legs");
		ModLoader.addName(AlloySteel.SteelBoots, "Steel Boots");
		
		ModLoader.addName(OreCopper.CopperBar, "Copper Bar");
		ModLoader.addName(OreCopper.CopperDust, "Copper Dust");
		ModLoader.addName(OreCopper.CopperPickaxe, "Copper Pickaxe");
		ModLoader.addName(OreCopper.CopperShovel, "Copper Shovel");
		ModLoader.addName(OreCopper.CopperAxe, "Copper Axe");
		ModLoader.addName(OreCopper.CopperHoe, "Copper Hoe");
		ModLoader.addName(OreCopper.CopperSword, "Copper Sword");
		ModLoader.addName(OreCopper.CopperHelmet, "Copper Helmet");
		ModLoader.addName(OreCopper.CopperPlate, "Copper Plate");
		ModLoader.addName(OreCopper.CopperLegs, "Copper Legs");
		ModLoader.addName(OreCopper.CopperBoots, "Copper Boots");

		ModLoader.addName(OreGold.GoldDust, "Gold Dust");
		ModLoader.addName(OreGold.GoldCoin, "Gold Coin");
		ModLoader.addName(OreGold.GoldCoin9, "Stack of Gold Coins");
		ModLoader.addName(OreGold.GoldCoin81, "Bag of Gold Coins");
		
		ModLoader.addName(OreIron.IronDust, "Iron Dust");

		ModLoader.addName(OreManganese.ManganeseBar, "Manganese Bar");
		ModLoader.addName(OreManganese.ManganeseDust, "Manganese Dust");

		ModLoader.addName(OreTin.TinBar, "Tin Bar");
		ModLoader.addName(OreTin.TinDust, "Tin Dust");
		
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsVein.CopperOre.name", "Copper Ore");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsVein.TinOre.name", "Tin Ore");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsVein.IronOre.name", "Iron Ore");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsVein.GoldOre.name", "Gold Ore");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsVein.ManganeseOre.name", "Manganese Ore");

		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsBrick.CopperBrick.name", "Copper Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsBrick.TinBrick.name", "Tin Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsBrick.IronBrick.name", "Iron Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsBrick.GoldBrick.name", "Gold Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseMetalsBrick.ManganeseBrick.name", "Manganese Brick");

		LanguageRegistry.instance().addStringLocalization("tile.BaseAlloysBrick.BronzeBrick.name", "Bronze Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseAlloysBrick.HepatizonBrick.name", "Hepatizon Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseAlloysBrick.DamascusBrick.name", "Damascus Steel Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseAlloysBrick.AngmallenBrick.name", "Angmallen Brick");
		LanguageRegistry.instance().addStringLocalization("tile.BaseAlloysBrick.SteelBrick.name", "Steel Brick");

		
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.CopperFurnace.name", "Copper Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.BronzeFurnace.name", "Bronze Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.IronFurnace.name", "Iron Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.SteelFurnace.name", "Steel Furnace");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFurnaces.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseAlloys.png");
	}
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}

	@Override
	public File getMinecraftDir()
	{
		return Minecraft.getMinecraftDir();
	}
}
