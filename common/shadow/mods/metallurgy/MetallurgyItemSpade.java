// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, EnumToolMaterial

public class MetallurgyItemSpade extends ItemSpade
{

	public String texturePath;
    private static Block blocksEffectiveAgainst[];
    private int damageVsEntity;
    protected MetallurgyEnumToolMaterial toolMaterial;
    
    public MetallurgyItemSpade(int itemID, String s, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial)
    {
        super(itemID, EnumToolMaterial.EMERALD);
        texturePath = s;
        efficiencyOnProperMaterial = 4F;
        toolMaterial = metallurgyenumtoolmaterial;
        setMaxDamage(metallurgyenumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = metallurgyenumtoolmaterial.getEfficiencyOnProperMaterial();
        damageVsEntity = 2 + metallurgyenumtoolmaterial.getDamageVsEntity();
    }

    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        for(int i = 0; i < blocksEffectiveAgainst.length; i++)
        {
            if(blocksEffectiveAgainst[i] == block)
            {
                return efficiencyOnProperMaterial;
            }
        }

        return 1.0F;
    }

    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }

    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.snow)
        {
            return true;
        }
        return false;
    }

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.grass, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay, Block.tilledField, Block.slowSand, Block.mycelium
        });
    }
    
    @Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }
}
