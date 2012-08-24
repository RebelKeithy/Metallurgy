package shadow.mods.metallurgy.nether;

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
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof NF_TileEntityNetherForge) 
		{
			NF_TileEntityNetherForge tef = (NF_TileEntityNetherForge) te;
			return new NF_ContainerNetherForge(player.inventory, tef);
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof NF_TileEntityNetherForge) 
		{
			return new NF_GuiNetherForge(player.inventory, (NF_TileEntityNetherForge)te);
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