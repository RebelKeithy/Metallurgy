package shadow.mods.metallurgy.base;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import cpw.mods.fml.common.network.PacketDispatcher;
import net.minecraft.src.DataWatcher;
import net.minecraft.src.ItemStack;
import net.minecraft.src.NBTTagCompound;
import net.minecraft.src.NBTTagList;
import net.minecraft.src.Packet250CustomPayload;
import net.minecraft.src.TileEntity;

public class TileEntityLantern extends TileEntity
{
	public short color;
	public boolean canUpdate = true;
	
	public TileEntityLantern()
	{
		
	}

	public TileEntityLantern(int color) 
	{
		this.color = (short) color;
		this.canUpdate = true;
	}

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        this.color = par1NBTTagCompound.getShort("color");

    	if(worldObj != null)
	    {
			int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 1, color);
	    }
    	//sendPacket();
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("color", (short)this.color);
    }
    
    @Override
    public void updateEntity()
    {
    	if(worldObj != null && canUpdate)
	    {
			int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 1, color);
			canUpdate = false;
	    }
    }
	
	public void sendPacket()
	{
		if(worldObj != null && worldObj.isRemote)
			return;
		
		ByteArrayOutputStream bos = new ByteArrayOutputStream(140);
		DataOutputStream dos = new DataOutputStream(bos);
		try {
			dos.writeShort(2);
			dos.writeInt(xCoord);
			dos.writeInt(yCoord);
			dos.writeInt(zCoord);
			dos.writeShort(color);
		} catch (IOException e) {
			// UNPOSSIBLE?
		}
		Packet250CustomPayload packet = new Packet250CustomPayload();
		packet.channel = "MetallurgyBase";
		packet.data = bos.toByteArray();
		packet.length = bos.size();
		packet.isChunkDataPacket = true;
		
		if (packet != null) {
			PacketDispatcher.sendPacketToAllPlayers(packet);
			//PacketDispatcher.sendPacketToAllAround(xCoord, yCoord, zCoord, 16, worldObj.provider.dimensionId, packet);
		}
	}

    @Override
	public void receiveClientEvent(int i, int j) 
    {
		color = (short) j;
	}

    public boolean canUpdate()
    {
        return canUpdate;
    }
}
