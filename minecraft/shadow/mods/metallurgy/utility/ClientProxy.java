package shadow.mods.metallurgy.utility;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.ModLoader;
import net.minecraft.src.World;
import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.FMLClientHandler;


public class ClientProxy extends shadow.mods.metallurgy.utility.CommonProxy{
	
	@Override
	public void addNames()
	{
		ModLoader.addLocalization("tile.UtilityVein.PhosphoriteOre.name", "Phosporite Ore");
		ModLoader.addLocalization("tile.UtilityVein.SulfurOre.name", "Sulfur Ore");
		ModLoader.addLocalization("tile.UtilityVein.SaltpeterOre.name", "Saltpeter Ore");
		ModLoader.addLocalization("tile.UtilityVein.MagnesiumOre.name", "Magnesium Ore");
		ModLoader.addLocalization("tile.UtilityVein.BitumenOre.name", "Bitumen Ore");
		ModLoader.addLocalization("tile.UtilityVein.PotashOre.name", "Potash Ore");

		ModLoader.addName(mod_Bitumen.bitumen, "Bitumen");
		ModLoader.addName(mod_Bitumen.tar, "Tar");
		ModLoader.addName(mod_Saltpeter.saltpeter, "Saltpeter");
		ModLoader.addName(mod_Potash.potash, "Potash");
		ModLoader.addName(mod_Potash.fertilizer, "Fertilizer");
		ModLoader.addName(mod_Magnesium.magnesium, "Magnesium");
		ModLoader.addName(mod_Phosphorite.phosphorite, "Phosphorite");
		ModLoader.addName(mod_Phosphorite.phosphorus, "Phosphorous");
		ModLoader.addName(mod_Sulfur.sulfur, "Sulfur");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyUtility.png");
		//MinecraftForgeClient.preloadTexture("");
	}
	
	@Override
	public void registerTileEntitySpecialRenderer() {

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
