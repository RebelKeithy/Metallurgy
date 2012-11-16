package shadow.mods.metallurgy.nether;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.src.EntityFX;
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

public class ClientProxy extends shadow.mods.metallurgy.nether.CommonProxy{
	
	public void addNames()
	{
		CoreClientProxy.addNamesToSet(MetallurgyNether.alloys);
		CoreClientProxy.addNamesToSet(MetallurgyNether.ores);
		
		
		for(String name : NF_GuiNetherForge.names)
			LanguageRegistry.instance().addStringLocalization("tile.NetherForge." + name + "Forge.name",  name + " Smelter");
		
		LanguageRegistry.instance().addStringLocalization("container.netherforge", "Nether Smelter");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyNetherForges.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyNetherMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyNetherAlloys.png");
	}

	@Override
	public void spawnParticle(String string, World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		if(string.equals("nether2"))
		{
			EntityOreFX entity = new EntityOreFX(par1World, par2, par4, par6, (float)par8, (float)par10, (float)par12);
			Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)(entity));
            ((EntityFX)entity).setRBGColorF((float)par8, (float)par10, (float)par12);
		}
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
