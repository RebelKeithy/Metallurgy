// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode fieldsfirst 

package shadow.mods.metallurgy;

import net.minecraft.src.EnumToolMaterial;

public enum MetallurgyEnumToolMaterial
{
	//Name, ID?, HarvestLevel, Durability, Strength, Damage, Enchantability
	//Base
    Wood("Wood", 0, 0, 60, 2F, 0, 15),
    Stone("Stone", 0, 1, 132, 4F, 1, 5),
	Copper("Copper", 0, 1, 180, 5F, 1, 5),
	Bronze("Bronze", 0, 1, 200, 6F, 2, 14),
	Hepatizon("Hepatizon", 0, 1, 300, 8F, 2, 14),
    Iron("Iron", 0, 2, 251, 6F, 2, 14),
    DamascusSteel("DamascusSteel", 0, 1, 500, 6F, 2, 14),
    Angmallen("Angmallen", 0, 2, 300, 8F, 2, 14),
    Steel("Steel", 0, 2, 750, 8F, 2, 14),
    Diamond("Diamond", 0, 3, 1562, 8F, 3, 10),
    //Nether
    Ignatius("Ignatius", 0, 3, 300, 5F, 3, 14),
    ShadowIron("ShadowIron", 0, 3, 350, 6F, 3, 14),
    ShadowSteel("ShadowSteel", 0, 3, 400, 7F, 3, 14),
    Midasium("Midasium", 0, 3, 450, 8F, 3, 14),
    Vyroxeres("Vyroxeres", 0, 3, 500, 9F, 3, 14),
    Ceruclase("Ceruclase", 0, 3, 550, 10F, 3, 14),
    Inolashite("Inolashite", 0, 3, 600, 11F, 3, 14),
    Kalendrite("Kalendrite", 0, 3, 650, 12F, 3, 14),
    Amordrine("Amordrine", 0, 3, 700, 13F, 3, 14),
    Vulcanite("Vulcanite", 0, 3, 750, 14F, 3, 14),
    Sanguinite("Sanguinite", 0, 3, 800, 15F, 3, 14),
    //Fantasy
    Prometheum("Mithril", 0, 3, 425, 7F, 3, 14),
    DeepIron("Mithril", 0, 3, 425, 7F, 3, 14),
    Oureclase("Mithril", 0, 3, 425, 7F, 3, 14),
    Aredrite("Mithril", 0, 3, 425, 7F, 3, 14),
    AstralSilver("Mithril", 0, 3, 425, 7F, 3, 14),
    Carmot("Mithril", 0, 3, 425, 7F, 3, 14),
    Mithril("Mithril", 0, 3, 425, 7F, 3, 14),
    Orichalcum("Orichalcum", 0, 3, 500, 7F, 3, 14),
    Adamantine("Adamantine", 0, 3, 750, 7F, 3, 14),
    Atlarus("Adamantine", 0, 3, 750, 7F, 3, 14),
    BlackSteel("Mithril", 0, 3, 425, 7F, 3, 14),
    Quicksilver("Mithril", 0, 3, 425, 7F, 3, 14),
    Haderoth("Mithril", 0, 3, 425, 7F, 3, 14),
    Celenegil("Mithril", 0, 3, 425, 7F, 3, 14),
    Tartarite("Mithril", 0, 3, 425, 7F, 3, 14),
    //Precious
    Brass("Brass", 0, 3, 25, 50F, 3, 14),
    Silver("Silver", 0, 3, 50, 50F, 3, 14),
    Gold("Gold", 0, 0, 75, 50F, 0, 22),
    Electrum("Electrum", 0, 3, 100, 50F, 3, 14),
    Platinum("Platinum", 0, 3, 150, 50F, 3, 14);

    static 
    {
        allToolMaterials = (new MetallurgyEnumToolMaterial[] {
            Wood, Stone, Copper, Bronze, Hepatizon, Iron, DamascusSteel, Angmallen, Steel, Diamond, Ignatius, ShadowIron, ShadowSteel, Midasium, Vyroxeres, Ceruclase, Inolashite, Kalendrite, Amordrine, Vulcanite, Sanguinite, Mithril, Orichalcum, Adamantine, Brass, Silver, Gold, Platinum
        });
    }
  /*
    public static final EnumToolMaterial WOOD;
    public static final EnumToolMaterial STONE;
    public static final EnumToolMaterial IRON;
    public static final EnumToolMaterial EMERALD;
    public static final EnumToolMaterial GOLD;
*/
    private final int harvestLevel;
    private final int maxUses;
    private final float efficiencyOnProperMaterial;
    private final int damageVsEntity;
    private final int enchantability;
    private static final MetallurgyEnumToolMaterial allToolMaterials[]; /* synthetic field */
/*
    public static final EnumToolMaterial[] values()
    {
        return (EnumToolMaterial[])allToolMaterials.clone();
    }

    public static EnumToolMaterial valueOf(String s)
    {
        return (EnumToolMaterial)Enum.valueOf(net.minecraft.src.EnumToolMaterial.class, s);
    }
*/
    private MetallurgyEnumToolMaterial(String s, int i, int j, int k, float f, int l, int i1)
    {
//        super(s, i);
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
        enchantability = i1;
    }

    public int getMaxUses()
    {
        return maxUses;
    }

    public float getEfficiencyOnProperMaterial()
    {
        return efficiencyOnProperMaterial;
    }

    public int getDamageVsEntity()
    {
        return damageVsEntity;
    }

    public int getHarvestLevel()
    {
        return harvestLevel;
    }

    public int getEnchantability()
    {
        return enchantability;
    }


}
