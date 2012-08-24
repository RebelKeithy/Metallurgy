package shadow.mods.metallurgy.nether;

import org.lwjgl.opengl.GL11;
import net.minecraft.src.*;
public class NF_GuiNetherForge extends GuiContainer
{
    private NF_TileEntityNetherForge furnaceInventory;
    public static String[] names = {"Ignatius", "Shadow Iron", "Shadow Steel", "Vyroxeres", "Inolashite", "Kalendrite", "Vulcanite", "Sanguinite"};
    private int type;
    
    public NF_GuiNetherForge(InventoryPlayer par1InventoryPlayer, NF_TileEntityNetherForge par2TileEntityFurnace)
    {
        super(new NF_ContainerNetherForge(par1InventoryPlayer, par2TileEntityFurnace));
        this.furnaceInventory = par2TileEntityFurnace;
        this.type = par2TileEntityFurnace.getType();
    }

    /**
     * Draw the foreground layer for the GuiContainer (everything in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        this.fontRenderer.drawString(names[type] + " Smelter", 30 - (names[type] + " Smelter").length()/2, 6, 4210752);
        this.fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture("/shadow/lavafurnace.png");
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int leftSide = (this.width - this.xSize) / 2;
        int topSide = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(leftSide, topSide, 0, 0, this.xSize, this.ySize);
        int var7;

        int fuelHeight = this.furnaceInventory.getFuelScaled(63) ;
        this.drawTexturedModalRect(leftSide + 144, topSide + 11 + 63 - fuelHeight, 176, 31 + 63 - fuelHeight, 17, 31 + fuelHeight);

        var7 = this.furnaceInventory.getCookProgressScaled(24);
        this.drawTexturedModalRect(leftSide + 59, topSide + 33, 176, 14, var7 + 1, 16);
    }
}
