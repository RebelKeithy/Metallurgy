package shadow.mods.metallurgy.nether;

import shadow.mods.metallurgy.BC_TileEntityCrusher;
import shadow.mods.metallurgy.mod_MetallurgyCore;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.src.NetworkManager;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player)	{
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int direction = dat.readInt();
		int speed = dat.readInt();
		int burnTime = dat.readInt();
		
		World world = mod_MetallurgyCore.proxy.getClientWorld();
		TileEntity te = world.getBlockTileEntity(x, y, z);
		NF_TileEntityNetherForge icte = null;
		if (te instanceof NF_TileEntityNetherForge) {
			icte = (NF_TileEntityNetherForge) te;
			icte.setDirection(direction);
			icte.furnaceTimeBase = speed;
			icte.furnaceBurnTime = burnTime;
		}

		world.markBlockNeedsUpdate(x, y, z);	}}