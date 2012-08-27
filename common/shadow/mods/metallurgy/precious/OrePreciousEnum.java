package shadow.mods.metallurgy.precious;

import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;

public class OrePreciousEnum implements IMetalSetEnum{

	public static final int numMetals = 3;
	public static final String[] name = {"Zinc", "Silver", "Platinum"};
	private final int[] expValues = {3, 5, 20};
	private final int[] harvestLevels = {1, 2, 3};
	private final int[] pickLevels = {1, 1, 3};
	private final int[] dungeonLootChances = {50, 25, 5};
	private final int[] dungeonLootAmounts = {4, 3, 1};

	public static int[] defaultVeinCount = {8, 6, 3};
	public static int[] defaultOreCount = {8, 6, 3};
	public static int[] defaultOreHeight = {128, 128, 128};
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID() {
		return PreciousConfig.ItemStartID;
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
		return "/shadow/MetallurgyPreciousMetals.png";
	}

	@Override
	public boolean isAlloy() {
		return false;
	}

	@Override
	public int veinCount(int i) {
		return PreciousConfig.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return PreciousConfig.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return PreciousConfig.OreHeight[i];
	}

	@Override
	public int oreID() {
		return PreciousConfig.PreciousMetalsVeinID;
	}

	@Override
	public int brickID() {
		return PreciousConfig.PreciousMetalsBrickID;
	}

	@Override
	public String getSetName() {
		return "PreciousMetal";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return null;
			case(1):
				return MetallurgyEnumToolMaterial.Silver;
			case(2):
				return MetallurgyEnumToolMaterial.Platinum;
		}
		return MetallurgyEnumToolMaterial.Brass;
	}

	@Override
	public boolean isCatalyst(int i) {
		if(i == 0)
			return true;
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

}
