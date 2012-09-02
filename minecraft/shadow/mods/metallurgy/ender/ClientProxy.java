package shadow.mods.metallurgy.ender;

import java.io.File;

import shadow.mods.metallurgy.CoreClientProxy;

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

public class ClientProxy extends shadow.mods.metallurgy.ender.CommonProxy{

	public void addArmor()
	{
		CoreClientProxy.addArmorToSet(mod_MetallurgyEnder.ores);
		CoreClientProxy.addArmorToSet(mod_MetallurgyEnder.alloys);
	}
	
	public void addNames()
	{
		CoreClientProxy.addNamesToSet(mod_MetallurgyEnder.alloys);
		CoreClientProxy.addNamesToSet(mod_MetallurgyEnder.ores);
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyEnderMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyEnderAlloys.png");
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
