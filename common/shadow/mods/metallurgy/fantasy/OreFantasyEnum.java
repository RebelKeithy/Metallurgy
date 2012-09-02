package shadow.mods.metallurgy.fantasy;

import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;

public class OreFantasyEnum implements IMetalSetEnum{

	public static final int numMetals = 12;	
	public static String imageName = "/shadow/MetallurgyFantasyMetals.png";
	public static String[] names = {"Prometheum", "Deep Iron", "Infuscolium", "Oureclase", "Aredrite", "Astral Silver", "Carmot", "Mithril", "Rubracium", "Orichalcum", "Adamantine", "Atlarus"};
	public static int[] expValues = {1, 2, 4, 3, 3, 11, 15, 4, 2, 5, 6, 7};
	private final int[] harvestLevels = {2, 2, 2, 3, 3, 4, 4, 4, 4, 5, 6, 6};
	private final int[] pickLevels = {2, 3, 0, 4, 4, 5, 5, 5, 0, 6, 7, 7};

	public static int[] defaultVeinCount = {6, 5, 5, 4, 4, 3, 3, 3, 2, 2, 1, 1};
	public static int[] defaultOreCount = {10, 4, 3, 3, 3, 3, 2, 3, 3, 4, 4, 3};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128};
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return FantasyConfig.ItemStartID + (i * 50);
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
		return false;
	}

	@Override
	public int veinCount(int i) {
		return FantasyConfig.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return FantasyConfig.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return FantasyConfig.OreHeight[i];
	}

	@Override
	public int oreID() {
		return FantasyConfig.FantasyMetalsVeinID;
	}

	@Override
	public int brickID() {
		return FantasyConfig.FantasyMetalsBrickID;
	}

	@Override
	public String getSetName() {
		return "FantasyMetal";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Prometheum;
			case(1):
				return MetallurgyEnumToolMaterial.DeepIron;
			case(2):
				return null;
			case(3):
				return MetallurgyEnumToolMaterial.Oureclase;
			case(4):
				return MetallurgyEnumToolMaterial.Aredrite;
			case(5):
				return MetallurgyEnumToolMaterial.AstralSilver;
			case(6):
				return MetallurgyEnumToolMaterial.Carmot;
			case(7):
				return MetallurgyEnumToolMaterial.Mithril;
			case(8):
				return null;
			case(9):
				return MetallurgyEnumToolMaterial.Orichalcum;
			case(10):
				return MetallurgyEnumToolMaterial.Adamantine;
			case(11):
				return MetallurgyEnumToolMaterial.Atlarus;
		}
		return MetallurgyEnumToolMaterial.Prometheum;
	}

	@Override
	public boolean isCatalyst(int i) {
		if(i == 2 || i == 8)
			return true;
		return false;
	}

	@Override
	public int dungeonLootChance(int i) {
		return 0;
	}

	@Override
	public int dungeonLootAmount(int i) {
		return 0;
	}

	@Override
	public int numRails(int i) {
		return 0;
	}

	@Override
	public int getDimension()
	{
		return 0;
	}

}
