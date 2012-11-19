// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            Item, EnumToolMaterial, Block, ItemStack, 
//            EnumAction, EntityPlayer, EntityLiving, Entity, 
//            World

public class MetallurgyItemSword extends ItemSword
{
	public String subText;
	public String texturePath;
    private int weaponDamage;
    private final MetallurgyEnumToolMaterial field_40439_b;
    
    private List<HitEntityListener> hlList = new ArrayList<HitEntityListener>();
    private int ingotID;
    
    public MetallurgyItemSword(int itemID, String s, MetallurgyEnumToolMaterial material, int ingotID)
    {
    	this(itemID, s, material);
    	this.ingotID = ingotID;
    }

    public MetallurgyItemSword(int i, String s, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial)
    {
        super(i, EnumToolMaterial.EMERALD);
        field_40439_b = metallurgyenumtoolmaterial;
        maxStackSize = 1;
        setMaxDamage(metallurgyenumtoolmaterial.getMaxUses());
        weaponDamage = 4 + metallurgyenumtoolmaterial.getDamageVsEntity();
        texturePath = s;
        subText = null;
    }
    
    public void setSubText(String text)
    {
    	subText = text;
    }

    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
    	if(subText != null)
    	{
    		for(String string : subText.split("-"))
    			par3List.add("\u00A7" + string);
    	}
    }

	public String getTextureFile()
    {		
		return texturePath;
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        return block.blockID != Block.web.blockID ? 1.5F : 15F;
    }
    
    public void addHitListener(HitEntityListener hl)
    {
    	hlList.add(hl);
    }

    public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
    {
    	for(HitEntityListener hl : hlList)
    		hl.hitEntity(itemstack, entityliving, entityliving1);
    	
        itemstack.damageItem(1, entityliving1);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
    {
        itemstack.damageItem(2, entityliving);
        return true;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return weaponDamage;
    }

    public boolean isFull3D()
    {
        return true;
    }

    public EnumAction getItemUseAction(ItemStack itemstack)
    {
        return EnumAction.block;
    }

    public int getMaxItemUseDuration(ItemStack itemstack)
    {
        return 0x11940;
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
        entityplayer.setItemInUse(itemstack, getMaxItemUseDuration(itemstack));
        return itemstack;
    }

    public boolean canHarvestBlock(Block block)
    {
        return block.blockID == Block.web.blockID;
    }

    public int getItemEnchantability()
    {
        return field_40439_b.getEnchantability();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return ingotID == par2ItemStack.itemID;
    }
}
