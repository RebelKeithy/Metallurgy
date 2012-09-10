package shadow.mods.metallurgy.precious;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.ender.ConfigEnder;
import shadow.mods.metallurgy.nether.ConfigNether;

public class AlloyPreciousEnum implements IMetalSetEnum{

	public static String[] name = {"Brass", "Electrum"};
	private int[] expValues = {4, 11};
	private int[] harvestLevels = {1, 1};
	private int[] pickLevels = {0, 1};
	private int[] dungeonLootChances = {25, 10};
	private int[] dungeonLootAmounts = {3, 2};
	private int[] metalLevels = {2, 4};
	
	public static EnumArmorMaterial brassArmor = EnumHelper.addArmorMaterial("Brass", 3, new int[] {2, 5, 3, 3}, 18);
	public static EnumArmorMaterial electrumArmor = EnumHelper.addArmorMaterial("Electrum", 9, new int[] {2, 6, 5, 2}, 30);
	
	@Override
	public int numMetals() {
		return 2;
	}

	@Override
	public int startID(int i) {
		return ConfigPrecious.ItemStartID + 150 + (i * 50);
	}

	@Override
	public String name(int i) {
		return name[i];
	}

	@Override
	public int expValue(int i) {
		return expValues[i];
	}

	@Override
	public int oreHarvestLevel(int i) {
		return harvestLevels[i];
	}

	@Override
	public int brickHarvestLevel(int i) {
		return harvestLevels[i];
	}

	@Override
	public int pickLevel(int i) {
		return pickLevels[i];
	}

	@Override
	public String image() {
		return "/shadow/MetallurgyPreciousAlloys.png";
	}

	@Override
	public boolean isAlloy() {
		return true;
	}

	@Override
	public int veinCount(int i) {
		return 0;
	}

	@Override
	public int oreCount(int i) {
		return 0;
	}

	@Override
	public int oreHeight(int i) {
		return 0;
	}

	@Override
	public int oreID() {
		return 0;
	}

	@Override
	public int brickID() {
		return ConfigPrecious.PreciousAlloysBrickID;
	}

	@Override
	public String getSetName() {
		return "PreciousAlloy";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Brass;
			case(1):
				return MetallurgyEnumToolMaterial.Electrum;
		}
		return MetallurgyEnumToolMaterial.Brass;
	}

	@Override
	public boolean isCatalyst(int i) {
		return false;
	}

	@Override
	public int dungeonLootChance(int i) {
		return dungeonLootChances[i];
	}

	@Override
	public int dungeonLootAmount(int i) {
		return dungeonLootAmounts[i];
	}

	@Override
	public int numRails(int i) {
		return 0;
	}

	@Override
	public boolean spawnsInDimension(int i)
	{
		return false;
	}

	@Override
	public boolean metalEnabled(int i) {
		return ConfigPrecious.alloyEnabled[i];
	}

	@Override
	public EnumArmorMaterial armorEnum(int i) 
	{
		if(i == 0)
			return brassArmor;
		else
			return electrumArmor;
	}

	@Override
	public int oreMinHeight(int i) {
		return 0;
	}

	@Override
	public int level(int i) {
		return metalLevels[i];
	}

}
