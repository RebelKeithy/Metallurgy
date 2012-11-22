package shadow.mods.metallurgy.nether;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import shadow.mods.metallurgy.HitEntityListener;

public class NetherSwordEffectsListener implements HitEntityListener {

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving player) {

		if(Math.random() < 0.7)
			return false;
		
		// Ignatius
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[0].shiftedIndex)
		{
			entityliving.setFire(2);
		}
		
		// Shadow Iron
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[1].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 0));		//Shadow Iron - Weakness I
		}
		
		// Vyroxeres
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[3].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));		//Vyroxeres - Poison
		}
		
		// Ceruclase
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[4].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));		//Ceruclase - Slowing
		}
		
		// Vulcanite
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[5].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(10, 80, 0));				//Kalendrite - Regen
		}
		
		// Vulcanite
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[6].shiftedIndex)
		{
			entityliving.setFire(4);										//Vulcanite - Ignite II
		}
		
		// Sanguinite
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[7].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(20, 80, 0));
		}
		
		// Shadow Steel
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.alloys.Sword[0].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 1));		//Shadow Steel - Weakness II
		}
		
		// Inolasihte
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.alloys.Sword[1].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));		//Inolashite - Poison + Slowing
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));
		}
		
		// Shadow Steel
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.alloys.Sword[2].shiftedIndex)
		{
			player.heal(4);		//Amordrine - Weakness II
		}
		return false;
	}
	
	@ForgeSubscribe
	public void onDeathEvent(LivingDeathEvent event)
	{
		if(event.source.getEntity() instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) event.source.getEntity();
			if(player.getCurrentEquippedItem() == null)
				return;
			
			if(player.getCurrentEquippedItem().itemID == MetallurgyNether.ores.Sword[2].shiftedIndex)
			{
				try {
					Method m = EntityLiving.class.getDeclaredMethod("dropFewItems", Boolean.TYPE, Integer.TYPE);
					m.setAccessible(true);
					m.invoke(event.entityLiving, (Boolean)true, (Integer)0);
					//m.setAccessible(false);
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
