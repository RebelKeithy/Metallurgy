package shadow.mods.metallurgy;

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
	public void onPacketData(NetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int x = dat.readInt();
		int y = dat.readInt();
		int z = dat.readInt();
		int direction = dat.readInt();
		int speed = dat.readInt();
		int burnTime = dat.readInt();
		
		System.out.println("recieving packet " + direction + " " + speed + " " + burnTime);

		World world = mod_MetallurgyCore.proxy.getClientWorld();
		TileEntity te = world.getBlockTileEntity(x, y, z);
		BC_TileEntityCrusher icte = null;
		if (te instanceof BC_TileEntityCrusher) {
			icte = (BC_TileEntityCrusher) te;
			icte.setDirection(direction);
			icte.furnaceTimeBase = speed;
			icte.furnaceBurnTime = burnTime;
		}
		
		//((BC_BlockCrusher)mod_MetallurgyCore.crusher).updateFurnaceBlockState(icte.isBurning(), world, x, y, z);
		
		/*
		int metadata = world.getBlockMetadata(x, y, z);
		if(metadata < 8 && icte.isBurning())
			world.setBlockMetadata(x, y, z, metadata + 8);
		if(metadata >= 8 && !icte.isBurning())
			world.setBlockMetadata(x, y, z, metadata - 8);
		*/
		
		world.markBlockNeedsUpdate(x, y, z);
		
		//world.setBlockTileEntity(x, y, z, icte);
	}
}
