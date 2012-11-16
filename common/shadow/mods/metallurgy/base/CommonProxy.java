package shadow.mods.metallurgy.base;

import java.io.File;

import shadow.mods.metallurgy.storage.ContainerStorage;
import shadow.mods.metallurgy.storage.GuiStorage;
import shadow.mods.metallurgy.storage.TileEntityStorage;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler
{
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
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof BF_TileEntityMetalFurnace) 
		{
			return new BF_ContainerMetalFurnace(player.inventory, (BF_TileEntityMetalFurnace)te);
		} 
		else if(te != null && te instanceof TileEntityStorage)
		{
			return new ContainerStorage(player.inventory, (TileEntityStorage)te);
		}
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof BF_TileEntityMetalFurnace) 
		{
			return new BF_GuiMetalFurnace(player.inventory, (BF_TileEntityMetalFurnace)te);
		}  
		else if(te != null && te instanceof TileEntityStorage)
		{
			return new GuiStorage(player.inventory, (TileEntityStorage)te);
		}
		else
		{
			return null;
		}
		
		//return null;
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
