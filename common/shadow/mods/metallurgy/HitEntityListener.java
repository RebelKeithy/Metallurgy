package shadow.mods.metallurgy;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;

public interface HitEntityListener {

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1);

}
