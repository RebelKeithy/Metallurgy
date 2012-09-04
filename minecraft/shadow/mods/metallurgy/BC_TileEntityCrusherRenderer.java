package shadow.mods.metallurgy;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.ModLoader;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.TileEntity;
import net.minecraft.src.ModelChest;
import org.lwjgl.opengl.GL12;

public class BC_TileEntityCrusherRenderer extends TileEntitySpecialRenderer
{
    /** The normal small chest model. */
    private BC_ModelCrusher crusherModel = new BC_ModelCrusher();

    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityChestAt(BC_TileEntityCrusher par1TileEntityChest, double par2, double par4, double par6, float par8)
    {
        int var9;
        float offset = 0;
        
        if (par1TileEntityChest.worldObj == null)
        {
            var9 = 5;
            offset = 0.1f;
        }
        else
        {
            var9 = par1TileEntityChest.direction;
        }

        BC_ModelCrusher var14;

        var14 = this.crusherModel;
        
        String type = "";
        
        if(par1TileEntityChest.getType() == 1)
        	type = "Copper";
        else if(par1TileEntityChest.getType() == 2)
        	type = "Bronze";
        else if(par1TileEntityChest.getType() == 3)
        	type = "Iron";
        else if(par1TileEntityChest.getType() == 4)
        	type = "Steel";
        
        if(par1TileEntityChest.isBurning())
        	this.bindTextureByName("/shadow/ModelCrusher" + type + "Burning.png");
        else
            this.bindTextureByName("/shadow/ModelCrusher" + type + ".png");

        GL11.glPushMatrix();
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float)par2, (float)par4 + 1.0F, (float)par6 + 1.0F);
        GL11.glScalef(1.0F, -1.0F, -1.0F);
        GL11.glTranslatef(0.5F, 0.5F, 0.5F);
        short var11 = 0;

        if (var9 == 2)
        {
            var11 = 180;
        }

        if (var9 == 3)
        {
            var11 = 0;
        }

        if (var9 == 4)
        {
            var11 = 90;
        }

        if (var9 == 5)
        {
            var11 = -90;
        }

        GL11.glRotatef((float)var11, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-0.5F, -0.5F + offset, -0.5F);
        float var13;

        var14.renderAll();
        //GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderTileEntityAt(TileEntity par1TileEntity, double par2, double par4, double par6, float par8)
    {
        this.renderTileEntityChestAt((BC_TileEntityCrusher)par1TileEntity, par2, par4, par6, par8);
    }
}
