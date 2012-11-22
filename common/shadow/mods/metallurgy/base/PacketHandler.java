package shadow.mods.metallurgy.base;

import shadow.mods.metallurgy.BC_TileEntityCrusher;
import shadow.mods.metallurgy.MetallurgyCore;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.src.INetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		short id = dat.readShort();
		
		if(id == 1)
			readCrusher(dat);
		else if(id == 2)
			readLantern(dat);
	}

	private void readLantern(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		short color = dat.readShort();
		World world = MetallurgyBaseMetals.proxy.getClientWorld();
		TileEntity te = world.getBlockTileEntity(x, y, z);
		BF_TileEntityMetalFurnace icte = null;

		if (te instanceof TileEntityLantern) {
			((TileEntityLantern)te).color = color;
		}
		world.markBlockForUpdate(x, y, z);
	}

	private void readCrusher(ByteArrayDataInput dat) {
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int direction = dat.readInt();
		int speed = dat.readInt();
		int burnTime = dat.readInt();
		int cookTime = dat.readInt();
		
		World world = MetallurgyBaseMetals.proxy.getClientWorld();
		TileEntity te = world.getBlockTileEntity(x, y, z);
		BF_TileEntityMetalFurnace icte = null;
		if (te instanceof BF_TileEntityMetalFurnace) {
			icte = (BF_TileEntityMetalFurnace) te;
			icte.setDirection(direction);
			icte.furnaceTimeBase = speed;
			icte.furnaceBurnTime = burnTime;
			icte.furnaceCookTime = cookTime;
		}

		world.markBlockForUpdate(x, y, z);
	}
}
