package shadow.mods.metallurgy.storage;

import net.minecraft.src.Container;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.InventoryPlayer;

public class ContainerStorage extends Container
{
	public ContainerStorage(InventoryPlayer inv, TileEntityStorage tes)
	{
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1) 
	{
		return true;
	}

}
