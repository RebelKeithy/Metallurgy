package shadow.mods.metallurgy.nether;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
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
			entityliving.addPotionEffect(new PotionEffect(15, 80, 0));
		}
		
		// Vyroxeres
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[3].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));
		}
		
		// Ceruclase
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[4].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));
		}
		
		// Vulcanite
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[6].shiftedIndex)
		{
			entityliving.setFire(4);
		}
		
		// Sanguinite
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.ores.Sword[7].shiftedIndex)
		{
			if(!entityliving.isDead && entityliving.attackTime == 0)
				player.heal(1);
		}
		
		// Shadow Steel
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.alloys.Sword[0].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 1));
		}
		
		// Inolasihte
		if(itemstack.getItem().shiftedIndex == MetallurgyNether.alloys.Sword[1].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));
		}
		return false;
	}

}
