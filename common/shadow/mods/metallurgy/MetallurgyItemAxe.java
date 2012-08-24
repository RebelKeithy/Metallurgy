// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, Material, EnumToolMaterial, 
//            ItemStack

public class MetallurgyItemAxe extends ItemAxe
{
	public String texturePath;
    private static Block blocksEffectiveAgainst[];
    private int damageVsEntity;
    protected MetallurgyEnumToolMaterial toolMaterial;
    
    
    
    public MetallurgyItemAxe(int itemID, String s, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial)
    {
        super(itemID, EnumToolMaterial.EMERALD);
        texturePath = s;
        efficiencyOnProperMaterial = 4F;
        toolMaterial = metallurgyenumtoolmaterial;
        setMaxDamage(metallurgyenumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = metallurgyenumtoolmaterial.getEfficiencyOnProperMaterial();
        damageVsEntity = 2 + metallurgyenumtoolmaterial.getDamageVsEntity();
    }

    @Override
	public String getTextureFile()
    {		
		return texturePath;
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if(block != null && block.blockMaterial == Material.wood)
        {
            return efficiencyOnProperMaterial;
        } else
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
    }

    @Override
    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    @Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.woodDoubleSlab, Block.woodSingleSlab, Block.pumpkin, Block.pumpkinLantern
        });
    }
}
