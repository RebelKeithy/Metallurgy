package shadow.mods.metallurgy.armory;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Enchantment;
import net.minecraft.src.EnchantmentHelper;
import net.minecraft.src.EntityArrow;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.EntitySnowball;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

public class ItemShuriken extends Item
{

    public ItemShuriken(int par1)
    {
        super(par1);
        this.maxStackSize = 16;
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (!par3EntityPlayer.capabilities.isCreativeMode)
        {
            --par1ItemStack.stackSize;
        }

        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        boolean var5 = par3EntityPlayer.capabilities.isCreativeMode;
        		
        EntityArrow var8 = new EntityShuriken(par2World, par3EntityPlayer, 2.0F);

        //var8.func_70243_d(true);
       
        int var9 = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, par1ItemStack);

        if (var9 > 0)
        {
            var8.setDamage(var8.getDamage() + (double)var9 * 0.5D + 0.5D);
        }

        int var10 = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, par1ItemStack);

        if (var10 > 0)
        {
            var8.setKnockbackStrength(var10);
        }

        if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, par1ItemStack) > 0)
        {
            var8.setFire(100);
        }

        par1ItemStack.damageItem(1, par3EntityPlayer);
        par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);

        if (var5)
        {
            var8.canBePickedUp = 2;
        }
        else
        {
            par3EntityPlayer.inventory.consumeInventoryItem(Item.arrow.shiftedIndex);
        }

        if (!par2World.isRemote)
        {
            par2World.spawnEntityInWorld(var8);
        }

        return par1ItemStack;
    }
}
