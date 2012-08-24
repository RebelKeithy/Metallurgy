package shadow.mods.metallurgy.nether;

import net.minecraft.src.*;


//Referenced classes of package net.minecraft.src:
//                   Slot, EntityPlayer, ItemStack, Item, 
//                   AchievementList, ModLoader, IInventory

public class NF_SlotNetherForge extends Slot
{

     public NF_SlotNetherForge(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
     {
             super(iinventory, i, j, k);
     }

     public boolean isItemValid(ItemStack itemstack)
     {
             return false;
     }

     public void onPickupFromSlot(ItemStack itemstack)
     {
             super.onPickupFromSlot(itemstack);
     }
}