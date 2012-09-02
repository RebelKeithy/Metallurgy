package shadow.mods.metallurgy.ender;

import java.io.File;


import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void addArmor() {}
	
	public void addNames() {}
	
	public void registerRenderInformation()
	{

	}
	
	public void registerTileEntitySpecialRenderer(/*PLACEHOLDER*/)
	{
		// TODO: Add special render types here
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
			return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
			return null;
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