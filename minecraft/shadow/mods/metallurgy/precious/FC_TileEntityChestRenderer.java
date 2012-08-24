package shadow.mods.metallurgy.precious;

import static org.lwjgl.opengl.GL11.GL_COMPILE_AND_EXECUTE;
import static org.lwjgl.opengl.GL11.glCallList;
import static org.lwjgl.opengl.GL11.glColor4f;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEndList;
import static org.lwjgl.opengl.GL11.glGenLists;
import static org.lwjgl.opengl.GL11.glNewList;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glRotatef;
import static org.lwjgl.opengl.GL11.glScalef;
import static org.lwjgl.opengl.GL11.glTranslatef;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.client.FMLClientHandler;

import net.minecraft.src.BlockChest;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntitySpecialRenderer;
import net.minecraft.src.Block;
import net.minecraft.src.ModelChest;


public class FC_TileEntityChestRenderer extends TileEntitySpecialRenderer
{
    /** The normal small chest model. */
    private ModelChest chestModel = new ModelChest();

    
    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityChestAt(FC_TileEntityChest par1TileEntityChest, double par2, double par4, double par6, float par8)
    {
        String imageName = "brasschest.png";

        int direction = par1TileEntityChest.getDirection();
        int type = par1TileEntityChest.getType();

        switch(type)
        {
            case 0:
            {
            	imageName = "brasschest.png";
            	break;
            }
            case 1:
            {
            	imageName = "silverchest.png";
            	break;
            }
            case 2:
            {
            	imageName = "goldchest.png";
            	break;
            }
            case 3:
            {
            	imageName = "electrumchest.png";
            	break;
            }
            case 4:
            {
            	imageName = "platinumchest.png";
            	break;
            }
        }

        int var9;

        if (!par1TileEntityChest.func_70309_m())
        {
            var9 = 0;
        }
        else
        {
            Block var10 = par1TileEntityChest.getBlockType();
            var9 = par1TileEntityChest.getDirection();

            if (var10 != null && var9 == 0)
            {
                ((BlockChest)var10).unifyAdjacentChests(par1TileEntityChest.func_70314_l(), par1TileEntityChest.xCoord, par1TileEntityChest.yCoord, par1TileEntityChest.zCoord);
                var9 = par1TileEntityChest.getDirection();
            }

        }

        ModelChest var14;

        var14 = this.chestModel;
        this.bindTextureByName("/shadow/" + imageName);

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
        GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
        float var12 = par1TileEntityChest.prevLidAngle + (par1TileEntityChest.lidAngle - par1TileEntityChest.prevLidAngle) * par8;
        float var13;

        var12 = 1.0F - var12;
        var12 = 1.0F - var12 * var12 * var12;
        var14.chestLid.rotateAngleX = -(var12 * (float)Math.PI / 2.0F);
        var14.renderAll();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }


	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.renderTileEntityChestAt((FC_TileEntityChest)var1, var2, var4, var6, var8);
		
	}
}
