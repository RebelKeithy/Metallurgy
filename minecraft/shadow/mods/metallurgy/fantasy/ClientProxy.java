package shadow.mods.metallurgy.fantasy;

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
import shadow.mods.metallurgy.fantasy.*;

public class ClientProxy extends CommonProxy{


	public void addNames()
	{
		CoreClientProxy.addNamesToSet(MetallurgyFantasy.alloys);
		CoreClientProxy.addNamesToSet(MetallurgyFantasy.ores);
		
		ModLoader.addLocalization("tile.MetalFantasyFurnace.PrometheumFurnace.name", "Prometheum Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.DeepIronFurnace.name", "Deep Iron Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.BlackSteelFurnace.name", "Black Steel Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.OureclaseFurnace.name", "Oureclase Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AredriteFurnace.name", "Aredrite Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.MithrilFurnace.name", "Mithril Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.HaderothFurnace.name", "Haderoth Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.OrichalcumFurnace.name", "Orichalcum Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AdamantineFurnace.name", "Adamantine Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.AtlarusFurnace.name", "Atlarus Abstractor");
		ModLoader.addLocalization("tile.MetalFantasyFurnace.TartariteFurnace.name", "Tartarite Abstractor");
				

	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/AbstractorParticle.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFantasyFurnace.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFantasyMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFantasyAlloys.png");
	}

	@Override
	public void spawnParticle(String string, World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		if(string.equals("abstractorLarge"))
			Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)(new EntityAbstractorFX(par1World, par2, par4, par6, par8, par10, par12)));
		if(string.equals("abstractorSmall"))
			Minecraft.getMinecraft().effectRenderer.addEffect((EntityFX)(new EntitySmallAbstractorFX(par1World, par2, par4, par6, par8, par10, par12)));
		if(string.equals("fantasyOre"))
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
