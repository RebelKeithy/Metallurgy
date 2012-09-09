package shadow.mods.metallurgy;

import net.minecraft.src.Entity;
import net.minecraft.src.World;

public interface CollisionListener {
	public void collide(World par1World, int par2, int par3, int par4, Entity par5Entity, int metadata);
}
