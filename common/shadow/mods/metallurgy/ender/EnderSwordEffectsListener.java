package shadow.mods.metallurgy.ender;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import shadow.mods.metallurgy.HitEntityListener;

public class EnderSwordEffectsListener implements HitEntityListener {

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving player) {

		if(Math.random() < 0.5)
			return false;

		if(entityliving.worldObj.isRemote)
			return false;
		
		// Shadow Steel
		if(itemstack.getItem().shiftedIndex == MetallurgyEnder.alloys.Sword[0].shiftedIndex)
		{
			double x = entityliving.posX - Math.sin((player.rotationYawHead/180.0) * Math.PI) * 6;
			double z = entityliving.posZ + Math.cos((player.rotationYawHead/180.0) * Math.PI) * 6;
			double y = entityliving.posY + Math.random() * 1 + 1;
			entityliving.setPosition(x, y, z);
			entityliving.worldObj.updateEntity(entityliving);
		}
		
		return true;
	}

}
