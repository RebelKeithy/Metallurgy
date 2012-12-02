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
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.LanguageRegistry;
import shadow.mods.metallurgy.*;
import shadow.mods.metallurgy.base.*;
import shadow.mods.metallurgy.fantasy.MetallurgyFantasy;

public class ClientProxy extends CommonProxy{
	
	public void addNames()
	{
		CoreClientProxy.addNamesToSet(MetallurgyBaseMetals.alloys);
		CoreClientProxy.addNamesToSet(MetallurgyBaseMetals.ores);
		
		ModLoader.addName(mod_Gold.GoldDust, "Gold Dust");
		
		ModLoader.addName(mod_Iron.IronDust, "Iron Dust");

		
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.CopperFurnace.name", "Copper Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.BronzeFurnace.name", "Bronze Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.IronFurnace.name", "Iron Furnace");
		LanguageRegistry.instance().addStringLocalization("tile.MetalFurnace.SteelFurnace.name", "Steel Furnace");
		
		LanguageRegistry.instance().addStringLocalization("tile.MetalLadder.Copper.name", "Copper Ladder");
		LanguageRegistry.instance().addStringLocalization("tile.MetalLadder.Bronze.name", "Bronze Ladder");
		LanguageRegistry.instance().addStringLocalization("tile.MetalLadder.Iron.name", "Iron Ladder");
		LanguageRegistry.instance().addStringLocalization("tile.MetalLadder.Steel.name", "Steel Ladder");

		LanguageRegistry.instance().addStringLocalization("item.glassDust.glass.name", "Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.red.name", "Red Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.green.name", "Green Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.blue.name", "Blue Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.orange.name", "Orange Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.yellow.name", "Yellow Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.purple.name", "Purple Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.grey.name", "Grey Glass Dust");
		LanguageRegistry.instance().addStringLocalization("item.glassDust.white.name", "White Glass Dust");
		
		LanguageRegistry.instance().addStringLocalization("tile.lantern.red.name", "Red Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.green.name", "Green Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.blue.name", "Blue Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.orange.name", "Orange Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.yellow.name", "Yellow Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.purple.name", "Purple Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.grey.name", "Grey Lantern");
		LanguageRegistry.instance().addStringLocalization("tile.lantern.white.name", "White Lantern");
		
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.red.name", "Red Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.green.name", "Green Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.blue.name", "Blue Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.orange.name", "Orange Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.yellow.name", "Yellow Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.purple.name", "Purple Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.grey.name", "Grey Glass");
		LanguageRegistry.instance().addStringLocalization("tile.coloredGlass.white.name", "White Glass");

		
		if(MetallurgyBaseMetals.spear[0] != null)
		{
			String[] baseMaterials = {"Copper", "Bronze", "Hepatizon", "Angmallen", "Damascus Steel", "Steel"};
			for(int n = 0; n < 6; n++)
			{
				if(MetallurgyBaseMetals.spear[n] != null)
				ModLoader.addName(MetallurgyBaseMetals.spear[n], baseMaterials[n] + " Spear");
				if(MetallurgyBaseMetals.halberd[n] != null)
					ModLoader.addName(MetallurgyBaseMetals.halberd[n], baseMaterials[n] + " Halberd");
				if(MetallurgyBaseMetals.knife[n] != null)
					ModLoader.addName(MetallurgyBaseMetals.knife[n], baseMaterials[n] + " Knife");
				if(MetallurgyBaseMetals.warhammer[n] != null)
					ModLoader.addName(MetallurgyBaseMetals.warhammer[n], baseMaterials[n] + " Warhammer");
				if(MetallurgyBaseMetals.flail[n] != null)
					ModLoader.addName(MetallurgyBaseMetals.flail[n], baseMaterials[n] + " Flail");
			}
		}
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/deco.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFurnaces.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseAlloys.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternBlue.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternGreen.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternGrey.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternOrange.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternPurple.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternRed.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternWhite.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternYellow.png");
		MinecraftForgeClient.preloadTexture("/shadow/LanternYellow1.png");

		RenderingRegistry.registerBlockHandler(new LanternRenderHelper());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLantern.class, new TileEntityLanternRenderer());
		RenderingRegistry.registerBlockHandler(BlockMetalLadder.renderType, new LadderRenderer());
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
