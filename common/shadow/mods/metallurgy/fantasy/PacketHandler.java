package shadow.mods.metallurgy.fantasy;

import java.util.Random;

import shadow.mods.metallurgy.base.BF_TileEntityMetalFurnace;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.src.EntityXPOrb;
import net.minecraft.src.INetworkManager;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int id = dat.readInt();
		
		if(id == 1)
		{
			int x = dat.readInt();
			int y = dat.readInt();
			int z = dat.readInt();
			int direction = dat.readInt();
			int speed = dat.readInt();
			int burnTime = dat.readInt();
	
			World world = MetallurgyFantasy.proxy.getClientWorld();
			TileEntity te = world.getBlockTileEntity(x, y, z);
			FF_TileEntityMetalFurnace icte = null;
			if (te instanceof FF_TileEntityMetalFurnace) {
				icte = (FF_TileEntityMetalFurnace) te;
				icte.setDirection(direction);
				icte.furnaceTimeBase = speed;
				icte.furnaceBurnTime = burnTime;
			}
	
			world.markBlockForUpdate(x, y, z);
		}
	}
}
