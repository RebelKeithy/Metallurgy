package shadow.mods.metallurgy.ender;

import java.io.File;

import shadow.mods.metallurgy.CoreClientProxy;

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

public class ClientProxy extends shadow.mods.metallurgy.ender.CommonProxy{

	
	public void addNames()
	{
		CoreClientProxy.addNamesToSet(MetallurgyEnder.alloys);
		CoreClientProxy.addNamesToSet(MetallurgyEnder.ores);
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

	@Override
	public void spawnParticle(String string, World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		if(string.equals("enderOre1"))
		{
			System.out.println("spawning particle");
			EntityOreFX entity = new EntityOreFX(par1World, par2, par4, par6, (float)par8, (float)par10, (float)par12, 0);
			Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)(entity));
            ((EntityFX)entity).setRBGColorF((float)par8, (float)par10, (float)par12);
		}
		if(string.equals("enderOre2"))
		{
			EntityOreFX entity = new EntityOreFX(par1World, par2, par4, par6, (float)par8, (float)par10, (float)par12, 1);
			Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)(entity));
            ((EntityFX)entity).setRBGColorF((float)par8, (float)par10, (float)par12);
		}
	}
}
