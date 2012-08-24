package shadow.mods.metallurgy.utility;

import java.io.File;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy
{
	public void addNames() {
		
	}
	
	public void registerRenderInformation()
	{

	}
	
	public void registerTileEntitySpecialRenderer(/*PLACEHOLDER*/)
	{
		// TODO: Add special render types here
	}

	
	public World getClientWorld()
	{
		return null;
	}
	
	public File getMinecraftDir()
	{
		return new File(".");
	}

}
