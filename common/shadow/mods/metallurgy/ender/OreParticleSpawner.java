package shadow.mods.metallurgy.ender;

import java.util.Random;

import net.minecraft.src.World;
import shadow.mods.metallurgy.DisplayListener;

public class OreParticleSpawner implements DisplayListener {

	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int meta = par1World.getBlockMetadata(par2, par3, par4);
		
		double r = 1;
		double g = 1;
		double b = 1;


		String particle = "";
		if(meta == 0)
			particle = "enderOre1";
		if(meta == 1)
			particle = "enderOre2";
		
		Random var5 = par1World.rand;
        double var6 = 1/8D;

        
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
                MetallurgyEnder.proxy.spawnParticle(particle, par1World, var9, var11, var13, r, g, b);
            }
        }
		
	}

}
