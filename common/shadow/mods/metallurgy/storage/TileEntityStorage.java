package shadow.mods.metallurgy.storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IInventory;
import net.minecraft.src.ItemStack;
import net.minecraft.src.TileEntity;

public class TileEntityStorage extends TileEntity implements IInventory {

	TileEntity main;
	
	Coordinate corner1;
	Coordinate corner2;
	
	private ArrayList<ItemStack[]> inventory;
	private Map<Integer, Integer> tabMap = new HashMap<Integer, Integer>();
	
	TileEntityStorage()
	{
		main = this;
		corner1 = new Coordinate(0, 0, 0);
		corner2 = new Coordinate(0, 0, 0);
        inventory = new ArrayList<ItemStack[]>();
	}
	
	public boolean isMain() 
	{
		return main == this;
	}
	
	public void printSize(EntityPlayer player)
	{
		String message = "Size: " + (corner1.x - corner2.x + 1) + "x" + (corner1.y - corner2.y + 1) + "x" + (corner1.z - corner2.z + 1);
		player.sendChatToPlayer(message);
	}
	
	public boolean isValid()
	{
		CoordinateIter iter = new CoordinateIter(corner1, corner2);
		
		Coordinate curr;
		while(iter.hasNext())
		{
			curr = iter.next();
			int id = worldObj.getBlockId(xCoord + curr.x, yCoord + curr.y, zCoord + curr.z);
			if(id != MetallurgyBaseMetals.accessor.blockID && id != MetallurgyBaseMetals.storage.blockID)
				return false;
		}
		return true;
	}

	public void updateSize() 
	{
		// Check x + 1
		int id = worldObj.getBlockId(xCoord + corner1.x + 1, yCoord, zCoord);
		if(id == MetallurgyBaseMetals.storage.blockID ||
		   id == MetallurgyBaseMetals.accessor.blockID)
		{
			boolean increaseSize = true;
			for(int j = corner2.y; j <= corner1.y; j++)
			{
				if(!increaseSize)
					break;
				for(int k = corner2.z; k <= corner1.z; k++)
				{
					System.out.println((corner1.x + 1) + " " + " " + j + " " + k);
					int id2 = worldObj.getBlockId(xCoord + corner1.x + 1, yCoord + j, zCoord + k);
					if(id2 != MetallurgyBaseMetals.accessor.blockID && id2 != MetallurgyBaseMetals.storage.blockID)
					{
						increaseSize = false;
						break;
					}
				}
			}
			if(increaseSize)
			{
				System.out.println("expanding x1");
				corner1.x++;
			}
		}
		

		// Check x - 1
		id = worldObj.getBlockId(xCoord + corner2.x - 1, yCoord, zCoord);
		if(id == MetallurgyBaseMetals.storage.blockID ||
		   id == MetallurgyBaseMetals.accessor.blockID)
		{
			boolean increaseSize = true;
			for(int j = corner2.y; j <= corner1.y; j++)
			{
				if(!increaseSize)
					break;
				for(int k = corner2.z; k <= corner1.z; k++)
				{
					int id2 = worldObj.getBlockId(xCoord + corner2.x - 1, yCoord + j, zCoord + k);
					if(id2 != MetallurgyBaseMetals.accessor.blockID && id2 != MetallurgyBaseMetals.storage.blockID)
					{
						increaseSize = false;
						break;
					}
				}
			}
			if(increaseSize)
			{
				System.out.println("expanding x2");
				corner2.x--;
			}
		}
		

		// Check z + 1
		id = worldObj.getBlockId(xCoord, yCoord, zCoord + corner1.z + 1);
		if(id == MetallurgyBaseMetals.storage.blockID ||
		   id == MetallurgyBaseMetals.accessor.blockID)
		{
			boolean increaseSize = true;
			for(int i = corner2.x; i <= corner1.x; i++)
			{
				if(!increaseSize)
					break;
				for(int j = corner2.y; j <= corner1.y; j++)
				{
					int id2 = worldObj.getBlockId(xCoord + i, yCoord + j, zCoord + corner1.z + 1);
					if(id2 != MetallurgyBaseMetals.accessor.blockID && id2 != MetallurgyBaseMetals.storage.blockID)
					{
						increaseSize = false;
						break;
					}
				}
			}
			if(increaseSize)
			{
				System.out.println("expanding z1");
				corner1.z++;
			}
		}
		

		// Check z - 1
		id = worldObj.getBlockId(xCoord, yCoord, zCoord + corner2.z - 1);
		if(id == MetallurgyBaseMetals.storage.blockID ||
		   id == MetallurgyBaseMetals.accessor.blockID)
		{
			boolean increaseSize = true;
			for(int i = corner2.x; i <= corner1.x; i++)
			{
				if(!increaseSize)
					break;
				for(int j = corner2.y; j <= corner1.y; j++)
				{
					int id2 = worldObj.getBlockId(xCoord + i, yCoord + j, zCoord + corner2.z - 1);
					if(id2 != MetallurgyBaseMetals.accessor.blockID && id2 != MetallurgyBaseMetals.storage.blockID)
					{
						increaseSize = false;
						break;
					}
				}
			}
			if(increaseSize)
			{
				System.out.println("expanding z2");
				corner2.z--;
			}
		}
		
		System.out.println("updateing storage size");
	}

	@Override
	public int getSizeInventory() 
	{
		int sum = 0;
		for(Integer i : tabMap.keySet())
		{
			sum += tabMap.get(i);
		}
		return sum * 9 * 5;
	}

	@Override
	public ItemStack getStackInSlot(int var1) 
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int var1, int var2) 
	{
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int var1) 
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int var1, ItemStack var2) 
	{
		
	}

	@Override
	public String getInvName() 
	{
		return null;
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer var1) 
	{
		return false;
	}

	@Override
	public void openChest() 
	{
	}

	@Override
	public void closeChest() 
	{

	}

}
