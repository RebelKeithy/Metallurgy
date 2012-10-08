package shadow.mods.metallurgy.fantasy;

import java.util.Random;

import net.minecraft.src.World;
import shadow.mods.metallurgy.DisplayListener;

public class OreParticleSpawner implements DisplayListener {

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		
		double r = 0;
		double g = 0;
		double b = 0;
		
		if(meta < 5)
			return;
		else if(meta == 5)
		{
			r = 0.6D;
			g = 0.8D;
			b = 0.95D;
		}
		else if(meta == 6)
		{
			r = 0.8D;
			g = 0.8D;
			b = 0.4D;
		}
		else if(meta == 7)
		{
			r = 0.6D;
			g = 0.9D;
			b = 0.95D;
		}
		else if(meta == 8)
		{
			return;
		}
		else if(meta == 9)
		{
			r = 0.3D;
			g = 0.5D;
			b = 0.15D;
		}
		else if(meta == 10)
		{
			r = 0.5D;
			g = 0.2D;
			b = 0.2D;
		}
		else if(meta == 11)
		{
			r = 0.8D;
			g = 0.8D;
			b = 0.2D;
		}
		
		String particle = "fantasyOre";
		
		Random var5 = par1World.rand;
        double var6 = 0.0625D;

        
        for (int var8 = 0; var8 < 6; ++var8)
        {
            if(Math.random() < 0.3)
            	continue;
            
            double var9 = (double)((float)par2 + var5.nextFloat());
            double var11 = (double)((float)par3 + var5.nextFloat());
            double var13 = (double)((float)par4 + var5.nextFloat());

            if (var8 == 0 && !par1World.isBlockOpaqueCube(par2, par3 + 1, par4))
            {
                var11 = (double)(par3 + 1) + var6;
            }

            if (var8 == 1 && !par1World.isBlockOpaqueCube(par2, par3 - 1, par4))
            {
                var11 = (double)(par3 + 0) - var6;
            }

            if (var8 == 2 && !par1World.isBlockOpaqueCube(par2, par3, par4 + 1))
            {
                var13 = (double)(par4 + 1) + var6;
            }

            if (var8 == 3 && !par1World.isBlockOpaqueCube(par2, par3, par4 - 1))
            {
                var13 = (double)(par4 + 0) - var6;
            }

            if (var8 == 4 && !par1World.isBlockOpaqueCube(par2 + 1, par3, par4))
            {
                var9 = (double)(par2 + 1) + var6;
            }

            if (var8 == 5 && !par1World.isBlockOpaqueCube(par2 - 1, par3, par4))
            {
                var9 = (double)(par2 + 0) - var6;
            }

            if (var9 < (double)par2 || var9 > (double)(par2 + 1) || var11 < 0.0D || var11 > (double)(par3 + 1) || var13 < (double)par4 || var13 > (double)(par4 + 1))
            {
                MetallurgyFantasy.proxy.spawnParticle(particle, par1World, var9, var11, var13, r, g, b);
            }
        }
		
	}

}
