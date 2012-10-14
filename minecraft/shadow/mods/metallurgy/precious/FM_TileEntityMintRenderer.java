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


public class FM_TileEntityMintRenderer extends TileEntitySpecialRenderer
{
    /** The normal small chest model. */
    private FM_ModelMint mintModel = new FM_ModelMint();

    
    /**
     * Renders the TileEntity for the chest at a position.
     */
    public void renderTileEntityMintAt(FM_TileEntityMint par1TileEntityMint, double par2, double par4, double par6, float par8)
    {
        String imageName = "Mint.png";
        String ingotImage = new String("");

        int direction = par1TileEntityMint.getDirection();
        boolean ingot = false;
        float offset = 0;
        float headOffset = 0;
        
        int var9;

        if (!par1TileEntityMint.func_70309_m())
        {
            var9 = 5;
            offset = 0.1f;
        }
        else
        {
            var9 = par1TileEntityMint.getDirection();
        }

        var9 = par1TileEntityMint.getDirection();
        float time = par1TileEntityMint.resetTime;
        if(time >= 5)
        {
        	headOffset = 0.29f * ((10 - time)/5f);
        }
        if(time < 5 && time > 0)
        {
        	headOffset = 0.29f * (time/5f);
        }
        
        if(par1TileEntityMint.hasIngot())
        {
        	ingotImage = par1TileEntityMint.getIngotImage();
        	ingot = true;
        }
        
        FM_ModelMint var14;

        var14 = this.mintModel;
        FM_ModelMintHead mintHead = new FM_ModelMintHead();
        this.bindTextureByName(imageName);
        

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
        var14.renderAll();


        if(ingot)
        {
            this.bindTextureByName("/shadow/" + ingotImage);
        	(new FM_ModelIngot()).renderAll();
        }
        	
        GL11.glTranslatef(0F, headOffset + offset, 0F);
        
        this.bindTextureByName("/shadow/MintHead.png");
        mintHead.renderAll();
        
        //GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    }


	@Override
	public void renderTileEntityAt(TileEntity var1, double var2, double var4, double var6, float var8) {
        this.renderTileEntityMintAt((FM_TileEntityMint)var1, var2, var4, var6, var8);
		
	}
}
