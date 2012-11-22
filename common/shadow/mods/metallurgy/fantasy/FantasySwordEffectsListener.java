package shadow.mods.metallurgy.fantasy;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import shadow.mods.metallurgy.HitEntityListener;
import shadow.mods.metallurgy.nether.MetallurgyNether;

public class FantasySwordEffectsListener implements HitEntityListener {

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving player) 
	{

		if(Math.random() < 0.7)
			return false;
		
		// Deep Iron
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[1].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 0));		//Blindness I
		}
		
		// Oureclase
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[3].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(11, 80, 0));			//Resistance
		}
		
		// Aredrite
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[4].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(5, 80, 0));				//Strength
		}
		
		// Astral Silver
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[5].shiftedIndex)
		{
			// Looting I
		}
		
		// Carmot
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[6].shiftedIndex)
		{
			// Looting II
		}
		
		// Mithril
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[7].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(3, 80, 0));				// Haste
		}
		
		// Orichalcum
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[9].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(11, 80, 1));			// Resistance II
		}
		
		// Adamantine
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[10].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(12, 80, 0));			// Fire Resist
			entityliving.setFire(4);								       	// Ignite II
		}
		
		// Atlarus
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.ores.Sword[11].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(5, 80, 1));				// Strength II
		}
		
		// Black Steel
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.alloys.Sword[0].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 1));		//Blindness II
		}
		
		// Quicksilver
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.alloys.Sword[1].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(1, 80, 0));				// Speed
		}

		// Haderoth
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.alloys.Sword[2].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(3, 80, 0));				// Haste
			entityliving.setFire(4);								       	// Ignite II
		}
		
		// Celenegil
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.alloys.Sword[3].shiftedIndex)
		{
			player.addPotionEffect(new PotionEffect(11, 80, 2));			// Resistance III
		}
		
		// Tartarite
		if(itemstack.getItem().shiftedIndex == MetallurgyFantasy.alloys.Sword[4].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(20, 80, 1));		// Wither
			entityliving.setFire(4);								       	// Ignite II
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
			
			if(player.getCurrentEquippedItem().itemID == MetallurgyFantasy.ores.Sword[5].shiftedIndex ||
			   player.getCurrentEquippedItem().itemID == MetallurgyFantasy.ores.Sword[6].shiftedIndex)
			{
				try {
					Method m = EntityLiving.class.getDeclaredMethod("dropFewItems", Boolean.TYPE, Integer.TYPE);
					m.setAccessible(true);
					m.invoke(event.entityLiving, (Boolean)true, (Integer)0);
					if(player.getCurrentEquippedItem().itemID == MetallurgyFantasy.ores.Sword[6].shiftedIndex)
					{
						if(Math.random() > 5)
							m.invoke(event.entityLiving, (Boolean)true, (Integer)0);
					}
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
