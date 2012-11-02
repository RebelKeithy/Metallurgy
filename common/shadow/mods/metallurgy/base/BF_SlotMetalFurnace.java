package shadow.mods.metallurgy.base;

import net.minecraft.src.*;


//Referenced classes of package net.minecraft.src:
//                   Slot, EntityPlayer, ItemStack, Item, 
//                   AchievementList, ModLoader, IInventory

public class BF_SlotMetalFurnace extends Slot
{

     public BF_SlotMetalFurnace(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
     {
             super(iinventory, i, j, k);
     }

     @Override
     public boolean isItemValid(ItemStack itemstack)
     {
             return false;
     }

     @Override
     public void func_82870_a(EntityPlayer par1, ItemStack itemstack)
     {
             super.func_82870_a(par1, itemstack);
     }
}