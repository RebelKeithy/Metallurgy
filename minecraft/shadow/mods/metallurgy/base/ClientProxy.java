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
