package shadow.mods.metallurgy.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import shadow.mods.metallurgy.BC_ModelCrusher;
import shadow.mods.metallurgy.BC_TileEntityCrusher;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntitySpecialRenderer;

public class TileEntityLanternRenderer extends TileEntitySpecialRenderer {

    /** The normal small chest model. */
    private ModelLantern lanternModel = new ModelLantern();
    int direction = 0;
    
    /**
     * Renders the TileEntity for the lantern at a position.
     */
    public void renderTileEntityLanternAt(TileEntityLantern par1TileEntityLantern, double x, double y, double z, float par8)
    {
    	int color = par1TileEntityLantern.color;
    	
    	if(color == 0)
    		this.bindTextureByName("/shadow/LanternRed.png");
    	else if(color == 1)
    		this.bindTextureByName("/shadow/LanternGreen.png");
    	else if(color == 2)
    		this.bindTextureByName("/shadow/LanternBlue.png");
    	else if(color == 3)
    		this.bindTextureByName("/shadow/LanternOrange.png");
    	else if(color == 4)
    		this.bindTextureByName("/shadow/LanternYellow.png");
    	else if(color == 5)
    		this.bindTextureByName("/shadow/LanternPurple.png");
    	else if(color == 6)
    		this.bindTextureByName("/shadow/LanternGrey.png");
    	else if(color == 7)
    		this.bindTextureByName("/shadow/LanternWhite.png");
    		
        
        if(par1TileEntityLantern.worldObj != null)
        	direction = par1TileEntityLantern.getBlockMetadata();
        else
        	direction = 0;
        
        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)x, (float)y + 1.0F, (float)z + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short var11 = 0;


        GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);

        lanternModel.renderAll(direction);
        //GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	}

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityLanternAt((TileEntityLantern)par1TileEntity, par2, par4, par6, par8);
    }

}
