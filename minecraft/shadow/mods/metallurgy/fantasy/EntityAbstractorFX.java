package shadow.mods.metallurgy.fantasy;

import org.lwjgl.opengl.GL11;

import net.minecraft.src.EntityFX;
import net.minecraft.src.ModLoader;
import net.minecraft.src.Tessellator;
import net.minecraft.src.World;
import net.minecraftforge.client.ForgeHooksClient;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityAbstractorFX extends EntityFX
{
    /** the scale of the flame FX */
    private float flameScale;

    public EntityAbstractorFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12)
    {
        super(par1World, par2, par4, par6, par8, par10, par12);
        this.motionX = this.motionX * 0.01D + par8;
        this.motionY = this.motionY * 0.01D + par10;
        this.motionZ = this.motionZ * 0.01D + par12;
        double var10000 = par2 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        var10000 = par4 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        var10000 = par6 + (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.flameScale = this.particleScale;
        this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
        this.particleMaxAge = (int)(8.0D / (Math.random() * 0.8D + 0.2D)) + 4;
        this.noClip = true;
        this.setParticleTextureIndex(0);
    }
/*
    public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7)
    {
    	ForgeHooksClient.bindTexture("/shadow/AbstractorParticle.png", 0);
        float var8 = ((float)this.particleAge + par2) / (float)this.particleMaxAge;
        this.particleScale = this.flameScale * (1.0F - var8 * var8 * 0.5F);
        var8 = (float)(0 % 16) / 16.0F;
        float var9 = var8 + 0.0624375F;
        float var10 = (float)(0 / 16) / 16.0F;
        float var11 = var10 + 0.0624375F;
        float var12 = 0.1F * this.particleScale;
        float var13 = (float)(this.prevPosX + (this.posX - this.prevPosX) * (double)par2 - interpPosX);
        float var14 = (float)(this.prevPosY + (this.posY - this.prevPosY) * (double)par2 - interpPosY);
        float var15 = (float)(this.prevPosZ + (this.posZ - this.prevPosZ) * (double)par2 - interpPosZ);
        float var16 = 1.0F;
        par1Tessellator.setColorOpaque_F(this.particleRed * var16, this.particleGreen * var16, this.particleBlue * var16);
        par1Tessellator.addVertexWithUV((double)(var13 - par3 * var12 - par6 * var12), (double)(var14 - par4 * var12), (double)(var15 - par5 * var12 - par7 * var12), (double)var9, (double)var11);
        par1Tessellator.addVertexWithUV((double)(var13 - par3 * var12 + par6 * var12), (double)(var14 + par4 * var12), (double)(var15 - par5 * var12 + par7 * var12), (double)var9, (double)var10);
        par1Tessellator.addVertexWithUV((double)(var13 + par3 * var12 + par6 * var12), (double)(var14 + par4 * var12), (double)(var15 + par5 * var12 + par7 * var12), (double)var8, (double)var10);
        par1Tessellator.addVertexWithUV((double)(var13 + par3 * var12 - par6 * var12), (double)(var14 - par4 * var12), (double)(var15 + par5 * var12 - par7 * var12), (double)var8, (double)var11);
    	
        par1Tessellator.draw();
        GL11.glBindTexture(3553 /*GL_TEXTURE_2D, FMLClientHandler.instance().getClient().renderEngine.getTexture("/particles.png"));
    }
*/

	public void renderParticle(Tessellator tessellator, float f, float f1, float f2, float f3, float f4, float f5)
	{
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    
	    Tessellator tessellator1 = new Tessellator();
	    tessellator1.startDrawingQuads();
	    tessellator1.setBrightness(getBrightnessForRender(f));
	    
	    float f6 = (((float)particleAge + f) / (float)particleMaxAge) * 32F;
	    if(f6 < 0.0F)
	    {
	        f6 = 0.0F;
	    }
	    if(f6 > 1.0F)
	    {
	        f6 = 1.0F;
	    }
	
	    float var8 = ((float)this.particleAge + f) / (float)this.particleMaxAge;
	    this.particleScale = this.flameScale * (1.0F - var8 * var8 * 0.5F);
	    
	    GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture("/shadow/AbstractorParticle.png"));
	    float f0 = (float)(getParticleTextureIndex() % 16) / 16F;
	    float f7 = f0 + 0.0624375F;
	    float f8 = (float)(getParticleTextureIndex() / 16) / 16F;
	    float f9 = f8 + 0.0624375F;
	    float f10 = 0.1F * particleScale;
	    float f11 = (float)((prevPosX + (posX - prevPosX) * (double)f) - interpPosX);
	    float f12 = (float)((prevPosY + (posY - prevPosY) * (double)f) - interpPosY);
	    float f13 = (float)((prevPosZ + (posZ - prevPosZ) * (double)f) - interpPosZ);
	    float f14 = 1.0F;
	    //tessellator1.setColorOpaque_F(particleRed * f14, particleGreen * f14, particleBlue * f14);
	    tessellator1.addVertexWithUV(f11 - f1 * f10 - f4 * f10, f12 - f2 * f10, f13 - f3 * f10 - f5 * f10, f7, f9);
	    tessellator1.addVertexWithUV((f11 - f1 * f10) + f4 * f10, f12 + f2 * f10, (f13 - f3 * f10) + f5 * f10, f7, f8);
	    tessellator1.addVertexWithUV(f11 + f1 * f10 + f4 * f10, f12 + f2 * f10, f13 + f3 * f10 + f5 * f10, f0, f8);
	    tessellator1.addVertexWithUV((f11 + f1 * f10) - f4 * f10, f12 - f2 * f10, (f13 + f3 * f10) - f5 * f10, f0, f9);
	    
	    tessellator1.draw();
	    GL11.glBindTexture(3553 /*GL_TEXTURE_2D*/, ModLoader.getMinecraftInstance().renderEngine.getTexture("/particles.png"));
	}
	
    public int getBrightnessForRender(float par1)
    {
        float var2 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;

        if (var2 < 0.0F)
        {
            var2 = 0.0F;
        }

        if (var2 > 1.0F)
        {
            var2 = 1.0F;
        }

        int var3 = super.getBrightnessForRender(par1);
        int var4 = var3 & 255;
        int var5 = var3 >> 16 & 255;
        var4 += (int)(var2 * 15.0F * 16.0F);

        if (var4 > 240)
        {
            var4 = 240;
        }

        return var4 | var5 << 16;
    }

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        float var2 = ((float)this.particleAge + par1) / (float)this.particleMaxAge;

        if (var2 < 0.0F)
        {
            var2 = 0.0F;
        }

        if (var2 > 1.0F)
        {
            var2 = 1.0F;
        }

        float var3 = super.getBrightness(par1);
        return var3 * var2 + (1.0F - var2);
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        if (this.particleAge++ >= this.particleMaxAge)
        {
            this.setDead();
        }

        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9599999785423279D;
        this.motionY *= 0.9599999785423279D;
        this.motionZ *= 0.9599999785423279D;

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }
    }
}
