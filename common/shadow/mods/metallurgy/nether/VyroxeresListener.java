package shadow.mods.metallurgy.nether;

import net.minecraft.src.Entity;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.Potion;
import net.minecraft.src.PotionEffect;
import net.minecraft.src.World;
import shadow.mods.metallurgy.CollisionListener;

public class VyroxeresListener implements CollisionListener {

	@Override
	public void collide(World par1World, int par2, int par3, int par4, Entity par5Entity, int meta) {
		
		if(meta != 3)
			return;
		
		if(par5Entity instanceof EntityLiving)
		{
			((EntityLiving)(par5Entity)).addPotionEffect(new PotionEffect(19, 80, 0));
		}
	}


}
