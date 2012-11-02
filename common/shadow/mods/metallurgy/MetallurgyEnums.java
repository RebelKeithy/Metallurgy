package shadow.mods.metallurgy;

import net.minecraft.src.EnumToolMaterial;
import net.minecraftforge.common.EnumHelper;

public class MetallurgyEnums {

	public static EnumToolMaterial copper = EnumHelper.addToolMaterial("Copper", 1, 180, 5F, 1, 5);
	public static EnumToolMaterial bronze = EnumHelper.addToolMaterial("Bronze", 2, 250, 6F, 1, 9);
	public static EnumToolMaterial hepatizon = EnumHelper.addToolMaterial("Hepatizon", 2, 300, 8F, 1, 22);
	public static EnumToolMaterial damascusSteel = EnumHelper.addToolMaterial("DamascusSteel", 3, 500, 6F, 2, 18);
	public static EnumToolMaterial angmallen = EnumHelper.addToolMaterial("Angmallen", 2, 300, 8F, 2, 30);
	public static EnumToolMaterial steel = EnumHelper.addToolMaterial("Steel", 3, 750, 8F, 3, 14);
	
	public static EnumToolMaterial base[] = {copper, bronze, hepatizon, damascusSteel, angmallen, steel};
	
    /*
    Ignatius("Ignatius", 0, 1, 200, 4F, 2, 15),
    ShadowIron("ShadowIron", 0, 1, 300, 5F, 2, 2),
    ShadowSteel("ShadowSteel", 0, 2, 400, 6F, 2, 5),
    Midasium("Midasium", 0, 3, 100, 10F, 2, 35),
    Vyroxeres("Vyroxeres", 0, 3, 300, 7F, 2, 16),
    Ceruclase("Ceruclase", 0, 3, 500, 7F, 2, 18),
    Inolashite("Inolashite", 0, 4, 900, 8F, 3, 25),
    Kalendrite("Kalendrite", 0, 4, 1000, 8F, 3, 20),
    Amordrine("Amordrine", 0, 4, 500, 14F, 2, 50),
    Vulcanite("Vulcanite", 0, 5, 1500, 10F, 3, 20),
    Sanguinite("Sanguinite", 0, 6, 1750, 12F, 4, 25),
    //Fantasy
    Prometheum("Prometheum", 0, 1, 200, 4F, 1, 16),
    DeepIron("DeepIron", 0, 2, 250, 6F, 2, 14),
	BlackSteel("BlackSteel", 0, 2, 500, 8F, 2, 17),
    Oureclase("Oureclase", 0, 3, 750, 8F, 2, 18),
    Aredrite("Aredrite", 0, 3, 1000, 4F, 2, 18),
    AstralSilver("AstralSilver", 0, 4, 35, 12F, 1, 30),
    Carmot("Carmot", 0, 4, 50, 12F, 1, 40),
    Mithril("Mithril", 0, 4, 1000, 9F, 3, 18),
	Quicksilver("Quicksilver", 0, 4, 1100, 14F, 3, 20),
    Haderoth("Haderoth", 0, 4, 1250, 12F, 3, 19),
    Orichalcum("Orichalcum", 0, 5, 1350, 9F, 3, 20),
	Celenegil("Celenegil", 0, 5, 1600, 14F, 3, 50),
    Adamantine("Adamantine", 0, 6, 1550, 10F, 4, 22),
    Atlarus("Atlarus", 0, 6, 1750, 10F, 4, 22),
    Tartarite("Tartarite", 0, 7, 3000, 14F, 5, 25),
    //Precious
    Brass("Brass", 0, 0, 15, 18F, 1, 18),
    Silver("Silver", 0, 0, 25, 12F, 1, 20),
    //Gold("Gold", 0, 0, 75, 50F, 1, 22),
    Electrum("Electrum", 0, 1, 50, 14F, 1, 30),
    Platinum("Platinum", 0, 2, 100, 16F, 1, 50);
    private MetallurgyEnumToolMaterial(String s, int i, int harvestLevel, int maxUses, float efficiencyOnProperMaterial, int damageVsEntity, int enchantability)
    {
        harvestLevel = j;
        maxUses = k;
        efficiencyOnProperMaterial = f;
        damageVsEntity = l;
        enchantability = i1;
    }
    */
}
