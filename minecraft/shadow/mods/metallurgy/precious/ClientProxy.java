package shadow.mods.metallurgy.precious;

import net.minecraft.src.ChestItemRenderHelper;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import shadow.mods.metallurgy.MetallurgyArmor;
import shadow.mods.metallurgy.nether.AlloyNether;
import shadow.mods.metallurgy.nether.OreNether;
import shadow.mods.metallurgy.precious.*;

public class ClientProxy extends CommonProxy{

	public void addArmor()
	{
		for(int i = 0; i < AlloyPrecious.numAlloys; i++)
		{
			((MetallurgyArmor) (AlloyNether.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
		}
		
		for(int i = 0; i < OrePrecious.numMetals; i++)
		{
			if(OrePrecious.catalysts.contains(i))
				continue;
			((MetallurgyArmor) (OreNether.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
		}
	}
	
	public void addNames()
	{
		for(int i = 0; i < AlloyPrecious.numAlloys; i++)
		{
			LanguageRegistry.instance().addStringLocalization("item.PreciousAlloyBar." + AlloyPrecious.name[i] + ".name", AlloyPrecious.name[i] + " Bar");
			LanguageRegistry.instance().addStringLocalization("item.PreciousAlloyDust." + AlloyPrecious.name[i] + ".name", AlloyPrecious.name[i] + " Dust");
			ModLoader.addName(AlloyPrecious.Pickaxe[i], AlloyPrecious.name[i] + " Pickaxe");
			ModLoader.addName(AlloyPrecious.Shovel[i], AlloyPrecious.name[i] + " Shovel");
			ModLoader.addName(AlloyPrecious.Axe[i], AlloyPrecious.name[i] + " Axe");
			ModLoader.addName(AlloyPrecious.Hoe[i], AlloyPrecious.name[i] + " Hoe");
			ModLoader.addName(AlloyPrecious.Sword[i], AlloyPrecious.name[i] + " Sword");
			ModLoader.addName(AlloyPrecious.Helmet[i], AlloyPrecious.name[i] + " Helmet");
			ModLoader.addName(AlloyPrecious.Plate[i], AlloyPrecious.name[i] + " Plate");
			ModLoader.addName(AlloyPrecious.Legs[i], AlloyPrecious.name[i] + " Legs");
			ModLoader.addName(AlloyPrecious.Boots[i], AlloyPrecious.name[i] + " Boots");
			LanguageRegistry.instance().addStringLocalization("tile.PreciousAlloysBrick." + AlloyPrecious.name[i] + ".name", AlloyPrecious.name[i] + " Brick");
		}

		for(int i = 0; i < OrePrecious.numMetals; i++)
		{
			LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsVein." + OrePrecious.name[i] + ".name", OrePrecious.name[i] + " Ore");
			LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsBrick." + OrePrecious.name[i] + ".name", OrePrecious.name[i] + " Brick");
			
			LanguageRegistry.instance().addStringLocalization("item.PreciousMetalsBar." + OrePrecious.name[i] + ".name", OrePrecious.name[i] + " Bar");
			LanguageRegistry.instance().addStringLocalization("item.PreciousMetalsDust." + OrePrecious.name[i] + ".name", OrePrecious.name[i] + " Dust");
			
			if(OrePrecious.catalysts.contains(i))
				continue;
			ModLoader.addName(OrePrecious.Pickaxe[i], OrePrecious.name[i] + " Pickaxe");
			ModLoader.addName(OrePrecious.Shovel[i], OrePrecious.name[i] + " Shovel");
			ModLoader.addName(OrePrecious.Axe[i], OrePrecious.name[i] + " Axe");
			ModLoader.addName(OrePrecious.Hoe[i], OrePrecious.name[i] + " Hoe");
			ModLoader.addName(OrePrecious.Sword[i], OrePrecious.name[i] + " Sword");
			ModLoader.addName(OrePrecious.Helmet[i], OrePrecious.name[i] + " Helmet");
			ModLoader.addName(OrePrecious.Plate[i], OrePrecious.name[i] + " Plate");
			ModLoader.addName(OrePrecious.Legs[i], OrePrecious.name[i] + " Legs");
			ModLoader.addName(OrePrecious.Boots[i], OrePrecious.name[i] + " Boots");
		}
		
		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsVein.ZincOre.name", "Zinc Ore");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsVein.SilverOre.name", "Silver Ore");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsVein.PlatinumOre.name", "Platinum Ore");

		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsBrick.ZincBrick.name", "Zinc Brick");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsBrick.SilverBrick.name", "Silver Brick");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousMetalsBrick.PlatinumBrick.name", "Platinum Brick");

		LanguageRegistry.instance().addStringLocalization("tile.PreciousAlloysBrick.BrassBrick.name", "Brass Brick");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousAlloysBrick.ElectrumBrick.name", "Electrum Brick");


		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.BrassChest.name", "Brass Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.SilverChest.name", "Silver Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.GoldChest.name", "Gold Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.ElectrumChest.name", "Electrum Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.PlatinumChest.name", "Platinum Chest");
	}
	
	@Override
	public void registerRenderInformation()
	{
		RenderingRegistry.registerBlockHandler(new FC_ChestRenderHelper());
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyPreciousMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyPreciousAlloys.png");
	}
	
	@Override
	public void registerTileEntitySpecialRenderer() {
		ClientRegistry.bindTileEntitySpecialRenderer(FC_TileEntityChest.class, new FC_TileEntityChestRenderer());
	}
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
