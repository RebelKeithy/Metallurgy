package shadow.mods.metallurgy.precious;

import org.lwjgl.opengl.GL11;
import net.minecraft.src.GuiContainer;
import net.minecraft.src.IInventory;
import net.minecraft.src.StatCollector;


public class FM_GuiMintStorage extends GuiContainer
{
    private IInventory upperChestInventory;
    private IInventory lowerChestInventory;

    /**
     * window height is calculated with this values, the more rows, the heigher
     */
    private int inventoryRows = 0;
    private int inventoryCols = 0;
    private String image;

    public FM_GuiMintStorage(IInventory playerInv, IInventory chestInv)
    {
        super(new FM_ContainerMintStorage(playerInv, chestInv));
        this.upperChestInventory = playerInv;
        this.lowerChestInventory = chestInv;
        this.allowUserInput = false;
        
        short var3 = 222;
        int var4 = var3 - 108;
        //this.inventoryRows = chestInv.getSizeInventory() / 9;
        this.inventoryRows = 2;
        this.inventoryCols = 3;
        this.ySize = var4 + this.inventoryRows * 18;
        
        image = "/shadow/mintstorage.png";
        		
    }

    /**
     * Draw the foreground layer for the GuiContainer (everythin in front of the items)
     */
    protected void drawGuiContainerForegroundLayer()
    {
        //this.fontRenderer.drawString(StatCollector.translateToLocal(this.lowerChestInventory.getInvName()), 8, 6, 4210752);
        //this.fontRenderer.drawString(StatCollector.translateToLocal(this.upperChestInventory.getInvName()), 8, this.ySize - 96 + 2, 4210752);
    }

    /**
     * Draw the background layer for the GuiContainer (everything behind the items)
     */
    protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
    {
        int var4 = this.mc.renderEngine.getTexture(image);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var4);
        int imageWidth = 176;
        int imageHeight = 168;
        
        int var5 = (this.width / 2) - (imageWidth/2);
        int var6 = (this.height / 2) - (imageHeight / 2);
        
        this.drawTexturedModalRect(var5, var6, 0, 0, imageWidth, imageHeight);
    }
}
