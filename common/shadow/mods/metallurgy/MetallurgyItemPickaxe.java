// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;
import net.minecraft.src.*;

// Referenced classes of package net.minecraft.src:
//            ItemTool, Block, MetallurgyEnumToolMaterial, Material, 
//            ItemStack

public class MetallurgyItemPickaxe extends ItemPickaxe
{
	public String texturePath;
    private static Block blocksEffectiveAgainst[];
    private int damageVsEntity;
    protected MetallurgyEnumToolMaterial toolMaterial;
    
    public MetallurgyItemPickaxe(int itemID, String s, MetallurgyEnumToolMaterial metallurgyenumtoolmaterial)
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
    public boolean canHarvestBlock(Block block)
    {
        if(block == Block.obsidian)
        {
            return toolMaterial.getHarvestLevel() == 3;
        }
        if(block == Block.blockDiamond || block == Block.oreDiamond)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockGold || block == Block.oreGold)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block == Block.blockSteel || block == Block.oreIron)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.blockLapis || block == Block.oreLapis)
        {
            return toolMaterial.getHarvestLevel() >= 1;
        }
        if(block == Block.oreRedstone || block == Block.oreRedstoneGlowing)
        {
            return toolMaterial.getHarvestLevel() >= 2;
        }
        if(block.blockMaterial == Material.rock)
        {
            return true;
        }
        return block.blockMaterial == Material.iron;
    }

    @Override
    public float getStrVsBlock(ItemStack itemstack, Block block)
    {
        if(block != null && (block.blockMaterial == Material.iron || block.blockMaterial == Material.rock))
        {
            return efficiencyOnProperMaterial;
        } else {
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
    public int getItemEnchantability()
    {
        return toolMaterial.getEnchantability();
    }

    @Override
    public int getDamageVsEntity(Entity entity)
    {
        return damageVsEntity;
    }

    static 
    {
        blocksEffectiveAgainst = (new Block[] {
            Block.cobblestone, Block.stoneDoubleSlab, Block.stone, Block.sandStone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, 
            Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice, Block.netherrack, Block.oreLapis, Block.blockLapis, Block.oreRedstone, Block.oreRedstoneGlowing, Block.rail, 
            Block.railDetector, Block.railPowered
        });
    }
    
}
