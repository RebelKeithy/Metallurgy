package shadow.mods.metallurgy.fantasy;

import java.io.File;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
	public void addNames() {}
	
	public void registerRenderInformation() {}
	
	public void registerTileEntitySpecialRenderer() {}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof FF_TileEntityMetalFurnace) 
		{
			FF_TileEntityMetalFurnace tef = (FF_TileEntityMetalFurnace) te;
			return new FF_ContainerMetalFurnace(player.inventory, tef);
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof FF_TileEntityMetalFurnace) 
		{
			return new FF_GuiMetalFurnace(player.inventory, (FF_TileEntityMetalFurnace)te);
		} 
		else
		{
			return null;
		}
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
