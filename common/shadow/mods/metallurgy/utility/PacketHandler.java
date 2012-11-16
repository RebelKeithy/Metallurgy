package shadow.mods.metallurgy.utility;

import java.util.ArrayList;
import java.util.List;

import shadow.mods.metallurgy.MetallurgyCore;
import shadow.mods.metallurgy.nether.NF_TileEntityNetherForge;

import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

import net.minecraft.src.ChunkPosition;
import net.minecraft.src.Entity;
import net.minecraft.src.Explosion;
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
		System.out.println("Utility PackeT");
		ByteArrayDataInput dat = ByteStreams.newDataInput(packet.data);
		int id = dat.readInt();
		if(id == 2)
			handleLargeExplosion(dat, manager, packet, player);
		if(id == 2)
			handleMinersExplosion(dat, manager, packet, player);
	}


	private void handleLargeExplosion(ByteArrayDataInput dat, INetworkManager manager, Packet250CustomPayload packet, Player player) {
        double explosionX = dat.readDouble();
        double explosionY = dat.readDouble();
        double explosionZ = dat.readDouble();
        float explosionSize = dat.readFloat();
        int var2 = dat.readInt();
        List chunkPositionRecords = new ArrayList(var2);
        int var3 = (int)explosionX;
        int var4 = (int)explosionY;
        int var5 = (int)explosionZ;

        for (int var6 = 0; var6 < var2; ++var6)
        {
            int var7 = dat.readByte() + var3;
            int var8 = dat.readByte() + var4;
            int var9 = dat.readByte() + var5;
            chunkPositionRecords.add(new ChunkPosition(var7, var8, var9));
        }

        float field_73610_f = dat.readFloat();
        float field_73611_g = dat.readFloat();
        float field_73617_h = dat.readFloat();
        
        World world = MetallurgyCore.proxy.getClientWorld();
        Explosion explosion = new Explosion(world, (Entity)null, explosionX, explosionY, explosionZ, explosionSize);
        explosion.affectedBlockPositions = chunkPositionRecords;
        explosion.doExplosionB(true);
        //player.motionX += (double)par1Packet60Explosion.func_73607_d();
        //player.motionY += (double)par1Packet60Explosion.func_73609_f();
        //player.motionZ += (double)par1Packet60Explosion.func_73608_g();
	}
	
	private void handleMinersExplosion(ByteArrayDataInput dat, INetworkManager manager, Packet250CustomPayload packet, Player player) {
        double explosionX = dat.readDouble();
        double explosionY = dat.readDouble();
        double explosionZ = dat.readDouble();
        float explosionSize = dat.readFloat();
        int var2 = dat.readInt();
        List chunkPositionRecords = new ArrayList(var2);
        int var3 = (int)explosionX;
        int var4 = (int)explosionY;
        int var5 = (int)explosionZ;

        for (int var6 = 0; var6 < var2; ++var6)
        {
            int var7 = dat.readByte() + var3;
            int var8 = dat.readByte() + var4;
            int var9 = dat.readByte() + var5;
            chunkPositionRecords.add(new ChunkPosition(var7, var8, var9));
        }

        float field_73610_f = dat.readFloat();
        float field_73611_g = dat.readFloat();
        float field_73617_h = dat.readFloat();
        
        World world = MetallurgyCore.proxy.getClientWorld();
        ExplosionMiners explosion = new ExplosionMiners(world, (Entity)null, explosionX, explosionY, explosionZ, explosionSize);
        explosion.affectedBlockPositions = chunkPositionRecords;
        explosion.doExplosionB(true);
        //player.motionX += (double)par1Packet60Explosion.func_73607_d();
        //player.motionY += (double)par1Packet60Explosion.func_73609_f();
        //player.motionZ += (double)par1Packet60Explosion.func_73608_g();
	}
}
