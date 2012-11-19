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
    protected MetallurgyEnumToolMaterial toolMaterial;
    private int ingotID;
    
    public MetallurgyItemAxe(int itemID, String s, MetallurgyEnumToolMaterial material, int ingotID)
    {
    	this(itemID, s, material);
    	this.ingotID = ingotID;
    }
    
    public MetallurgyItemAxe(int itemID, String s, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial)
    {
        super(itemID, EnumToolMaterial.EMERALD);
        texturePath = s;
        toolMaterial = metallurgyenumtoolmaterial;
        setMaxDamage(metallurgyenumtoolmaterial.getMaxUses());
        efficiencyOnProperMaterial = metallurgyenumtoolmaterial.getEfficiencyOnProperMaterial();
        ingotID = 0;
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
        return 2 + toolMaterial.getDamageVsEntity();
    }

    @Override
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }

    /**
     * Return whether this item is repairable in an anvil.
     */
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return ingotID == par2ItemStack.itemID;
    }

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.planks, Block.bookShelf, Block.wood, Block.chest, Block.woodDoubleSlab, Block.woodSingleSlab, Block.pumpkin, Block.pumpkinLantern
        });
    }
}
