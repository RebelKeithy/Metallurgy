package shadow.mods.metallurgy.nether;

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

	public void addArmor()
	{
		for(int i = 0; i < AlloyNether.numAlloys; i++)
		{
			((MetallurgyArmor) (AlloyNether.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
			((MetallurgyArmor) (AlloyNether.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(AlloyNether.name[i]));
		}
		
		for(int i = 0; i < OreNether.numMetals; i++)
		{
			((MetallurgyArmor) (OreNether.Helmet[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Plate[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Legs[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
			((MetallurgyArmor) (OreNether.Boots[i])).setTexture(RenderingRegistry.addNewArmourRendererPrefix(OreNether.name[i]));
		}
	}
	
	public void addNames()
	{
		for(int i = 0; i < AlloyNether.numAlloys; i++)
		{
			LanguageRegistry.instance().addStringLocalization("item.NetherAlloyBar." + AlloyNether.name[i] + ".name", AlloyNether.name[i] + " Bar");
			LanguageRegistry.instance().addStringLocalization("item.NetherAlloyDust." + AlloyNether.name[i] + ".name", AlloyNether.name[i] + " Dust");
			ModLoader.addName(AlloyNether.Pickaxe[i], AlloyNether.name[i] + " Pickaxe");
			ModLoader.addName(AlloyNether.Shovel[i], AlloyNether.name[i] + " Shovel");
			ModLoader.addName(AlloyNether.Axe[i], AlloyNether.name[i] + " Axe");
			ModLoader.addName(AlloyNether.Hoe[i], AlloyNether.name[i] + " Hoe");
			ModLoader.addName(AlloyNether.Sword[i], AlloyNether.name[i] + " Sword");
			ModLoader.addName(AlloyNether.Helmet[i], AlloyNether.name[i] + " Helmet");
			ModLoader.addName(AlloyNether.Plate[i], AlloyNether.name[i] + " Plate");
			ModLoader.addName(AlloyNether.Legs[i], AlloyNether.name[i] + " Legs");
			ModLoader.addName(AlloyNether.Boots[i], AlloyNether.name[i] + " Boots");
			LanguageRegistry.instance().addStringLocalization("tile.NetherAlloysBrick." + AlloyNether.name[i] + ".name", AlloyNether.name[i] + " Brick");
		}

		for(int i = 0; i < OreNether.numMetals; i++)
		{
			ModLoader.addName(OreNether.Bar[i], OreNether.name[i] + " Bar");
			ModLoader.addName(OreNether.Dust[i], OreNether.name[i] + " Dust");
			ModLoader.addName(OreNether.Pickaxe[i], OreNether.name[i] + " Pickaxe");
			ModLoader.addName(OreNether.Shovel[i], OreNether.name[i] + " Shovel");
			ModLoader.addName(OreNether.Axe[i], OreNether.name[i] + " Axe");
			ModLoader.addName(OreNether.Hoe[i], OreNether.name[i] + " Hoe");
			ModLoader.addName(OreNether.Sword[i], OreNether.name[i] + " Sword");
			ModLoader.addName(OreNether.Helmet[i], OreNether.name[i] + " Helmet");
			ModLoader.addName(OreNether.Plate[i], OreNether.name[i] + " Plate");
			ModLoader.addName(OreNether.Legs[i], OreNether.name[i] + " Legs");
			ModLoader.addName(OreNether.Boots[i], OreNether.name[i] + " Boots");
			LanguageRegistry.instance().addStringLocalization("tile.NetherMetalsVein." + OreNether.name[i] + ".name", OreNether.name[i] + " Ore");
			LanguageRegistry.instance().addStringLocalization("tile.NetherMetalsBrick." + OreNether.name[i] + ".name", OreNether.name[i] + " Brick");
		}
		
		for(String name : NF_GuiNetherForge.names)
			LanguageRegistry.instance().addStringLocalization("tile.NetherForge." + name + "Forge.name",  name + " Forge");
		
		LanguageRegistry.instance().addStringLocalization("container.netherforge", "Nether Forge");
	}
	
	@Override
	public void registerRenderInformation()
	{
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyFurnaces.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyNetherMetals.png");
		MinecraftForgeClient.preloadTexture("/shadow/MetallurgyNetherAlloys.png");
	}
	
	@Override
	public World getClientWorld() {
		return FMLClientHandler.instance().getClient().theWorld;
	}
}
