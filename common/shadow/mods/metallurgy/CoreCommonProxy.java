package shadow.mods.metallurgy;

import java.io.File;

import shadow.mods.metallurgy.base.BF_ContainerMetalFurnace;
import shadow.mods.metallurgy.base.BF_GuiMetalFurnace;
import shadow.mods.metallurgy.base.BF_TileEntityMetalFurnace;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class CoreCommonProxy implements IGuiHandler
{
	public void addNames() {}
	
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


	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof BC_TileEntityCrusher) 
		{
			BC_TileEntityCrusher tec = (BC_TileEntityCrusher) te;
			((BC_TileEntityCrusher) te).sendPacket();
			return new BC_ContainerCrusher(player.inventory, tec);
		}
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		TileEntity te = world.getBlockTileEntity(x, y, z);
		if (te != null && te instanceof BC_TileEntityCrusher) 
		{
			return new BC_GuiCrusher(player.inventory, (BC_TileEntityCrusher)te, "Crusher");
		}
		else
		{
			return null;
		}
		
		//return null;
	}

	public void addTextureOverrides() {
	}
}
