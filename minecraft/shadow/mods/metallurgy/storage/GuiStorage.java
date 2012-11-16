package shadow.mods.metallurgy.storage;

import net.minecraft.src.Container;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.InventoryPlayer;

public class GuiStorage extends GuiContainer
{
	public GuiStorage(InventoryPlayer inventory, TileEntityStorage te) 
	{
		super(new ContainerStorage(inventory, te));
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) 
	{
		
	}

}
