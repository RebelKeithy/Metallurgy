package shadow.mods.metallurgy.precious;

import java.io.File;

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
		if (te != null && te instanceof FC_TileEntityChest) 
		{
			FC_TileEntityChest tec = (FC_TileEntityChest) te;
			return new FC_ContainerChest(player.inventory, tec);
		} 
		else if (te != null && te instanceof FM_TileEntityMintStorage) 
		{
			FM_TileEntityMintStorage tec = (FM_TileEntityMintStorage) te;
			return new FM_ContainerMintStorage(player.inventory, tec);
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof FC_TileEntityChest) 
		{
			return new FC_GuiChest(player.inventory, (FC_TileEntityChest)te);
		} 
		else if (te != null && te instanceof FM_TileEntityMintStorage) 
		{
			return new FM_GuiMintStorage(player.inventory, (FM_TileEntityMintStorage)te);
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
