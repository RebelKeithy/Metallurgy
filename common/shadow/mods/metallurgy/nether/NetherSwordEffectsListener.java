package shadow.mods.metallurgy.nether;

import net.minecraft.src.EntityLiving;
import net.minecraft.src.ItemStack;
import net.minecraft.src.PotionEffect;
import shadow.mods.metallurgy.HitEntityListener;

public class NetherSwordEffectsListener implements HitEntityListener {

	@Override
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving player) {
				
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[0].shiftedIndex)
		{
			entityliving.setFire(2);
		}
		
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[1].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 0));
		}
		
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[3].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));
		}
		
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[4].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));
		}
		
		// Vulcanite
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[6].shiftedIndex)
		{
			entityliving.setFire(4);
		}
		
		// Sanguinite
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.ores.Sword[7].shiftedIndex)
		{
			if(!entityliving.isDead && entityliving.attackTime == 0)
				player.heal(1);
		}
		
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.alloys.Sword[0].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(15, 80, 1));
		}
		
		if(itemstack.getItem().shiftedIndex == mod_MetallurgyNether.alloys.Sword[0].shiftedIndex)
		{
			entityliving.addPotionEffect(new PotionEffect(2, 80, 0));
			entityliving.addPotionEffect(new PotionEffect(19, 80, 0));
		}
		return false;
	}

}
