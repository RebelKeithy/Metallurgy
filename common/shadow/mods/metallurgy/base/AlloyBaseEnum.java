package shadow.mods.metallurgy.base;

import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;

public class AlloyBaseEnum implements IMetalSetEnum{

	public static int numMetals = 5;
	public static String[] names = {"Bronze", "Hepatizon", "Damascus Steel", "Angmallen", "Steel"};
	public static String imageName = "/shadow/MetallurgyBaseAlloys.png";
	private int[] expValues = {2, 8, 5, 9, 6};
	private int[] harvestLevels = {2, 2, 2, 2, 3};
	private int[] pickLevels = {3, 3, 4, 3, 4};

	private int[] dungeonLootChances = {120, 120, 80, 75, 50};
	private int[] dungeonLootAmounts = {3, 3, 2, 2, 2};
	
	private int[] numRails = {20, 20, 20, 20, 20};
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID() {
		return BaseConfig.ItemStartID + 150;
	}

	@Override
	public String name(int i) {
		return names[i];
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
		return imageName;
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
		return BaseConfig.baseAlloysBrickID;
	}

	@Override
	public String getSetName() {
		return "BaseAlloy";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Bronze;
			case(1):
				return MetallurgyEnumToolMaterial.Hepatizon;
			case(2):
				return MetallurgyEnumToolMaterial.DamascusSteel;
			case(3):
				return MetallurgyEnumToolMaterial.Angmallen;
			case(4):
				return MetallurgyEnumToolMaterial.Steel;
		}
		return MetallurgyEnumToolMaterial.Bronze;
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
		return numRails[i];
	}

	@Override
	public int getDimension()
	{
		return 0;
	}
}
