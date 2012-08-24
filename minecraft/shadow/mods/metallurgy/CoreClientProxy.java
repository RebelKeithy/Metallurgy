package shadow.mods.metallurgy;

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
import shadow.mods.metallurgy.base.*;

public class CoreClientProxy extends CoreCommonProxy{

	public void addArmor()
	{
	}
	
	public void addNames()
	{
		LanguageRegistry.instance().addStringLocalization("container.crusher", "Crusher");
		LanguageRegistry.instance().addStringLocalization("tile.Crusher.StoneCrusher.name", "Stone Crusher");
		LanguageRegistry.instance().addStringLocalization("tile.Crusher.CopperCrusher.name", "Copper Crusher");
		LanguageRegistry.instance().addStringLocalization("tile.Crusher.BronzeCrusher.name", "Bronze Crusher");
		LanguageRegistry.instance().addStringLocalization("tile.Crusher.IronCrusher.name", "Iron Crusher");
		LanguageRegistry.instance().addStringLocalization("tile.Crusher.SteelCrusher.name", "Steel Crusher");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyTerrain.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFurnaces.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyBaseAlloys.png");
	}
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
