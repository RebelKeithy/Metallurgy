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
import shadow.mods.metallurgy.precious.*;

public class ClientProxy extends CommonProxy{

	public void addArmor()
	{
		for(int i = 0; i < mod_MetallurgyPrecious.alloys.numMetals; i++)
		{
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
		}
		
		for(int i = 0; i < mod_MetallurgyPrecious.ores.numMetals; i++)
		{
			if(mod_MetallurgyPrecious.ores.info.isCatalyst(i))
				continue;
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
			((MetallurgyArmor) (mod_MetallurgyPrecious.alloys.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyPreciousEnum.name[i]));
		}
	}
	
	public void addNames()
	{
		CoreClientProxy.addNamesToSet(mod_MetallurgyPrecious.alloys);
		CoreClientProxy.addNamesToSet(mod_MetallurgyPrecious.ores);

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

	@Override
	public File getMinecraftDir()
	{
		return Minecraft.getMinecraftDir();
	}
}
