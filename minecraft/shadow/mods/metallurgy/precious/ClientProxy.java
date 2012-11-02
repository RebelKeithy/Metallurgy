package shadow.mods.metallurgy.precious;

import java.io.File;

import net.minecraft.client.Minecraft;
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
import shadow.mods.metallurgy.CoreClientProxy;
import shadow.mods.metallurgy.MetallurgyArmor;
import shadow.mods.metallurgy.fantasy.MetallurgyFantasy;
import shadow.mods.metallurgy.precious.*;

public class ClientProxy extends CommonProxy{

	public void addNames()
	{
		CoreClientProxy.addNamesToSet(MetallurgyPrecious.alloys);
		CoreClientProxy.addNamesToSet(MetallurgyPrecious.ores);

		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.BrassChest.name", "Brass Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.SilverChest.name", "Silver Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.GoldChest.name", "Gold Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.ElectrumChest.name", "Electrum Chest");
		LanguageRegistry.instance().addStringLocalization("tile.PreciousChest.PlatinumChest.name", "Platinum Chest");
		
		LanguageRegistry.instance().addStringLocalization("tile.Mint.name", "Mint");
		LanguageRegistry.instance().addStringLocalization("tile.MintStorage.name", "Mint Storage");

		LanguageRegistry.instance().addStringLocalization("item.Coin.name", "Coin");
		LanguageRegistry.instance().addStringLocalization("item.Stack.name", "Stack");
		LanguageRegistry.instance().addStringLocalization("item.Bag.name", "Bag");
		LanguageRegistry.instance().addStringLocalization("item.Bullion.name", "Bullion");
		LanguageRegistry.instance().addStringLocalization("item.GoldCog.name", "Gold Cog");
	}
	
	@Override
	public void registerRenderInformation()
	{
		RenderingRegistry.registerBlockHandler(new FC_ChestRenderHelper());
		RenderingRegistry.registerBlockHandler(new FM_MintRenderHelper());
		MinecraftForgeClient.preloadTexture("/shadow/MintHead.png");
		MinecraftForgeClient.preloadTexture("/shadow/Mint.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyPreciousMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyPreciousAlloys.png");
	}
	
	@Override
	public void registerTileEntitySpecialRenderer() {
		ClientRegistry.bindTileEntitySpecialRenderer(FC_TileEntityChest.class, new FC_TileEntityChestRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(FM_TileEntityMint.class, new FM_TileEntityMintRenderer());
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
