package shadow.mods.metallurgy.nether;

import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;

public class OreNetherEnum implements IMetalSetEnum{

	public static final int numMetals = 8;	
	public static String imageName = "/shadow/MetallurgyNetherMetals.png";
	public static String[] names = {"Ignatius", "Shadow Iron", "Midasium", "Vyroxeres", "Ceruclase", "Kalendrite", "Vulcanite", "Sanguinite"};
	public static int[] expValues = {1, 2, 3, 3, 3, 4, 5, 6};
	private final int[] harvestLevels = {2, 2, 2, 2, 2, 3, 4, 5};
	private final int[] pickLevels = {2, 2, 3, 3, 3, 4, 5, 6};

	public static int[] defaultVeinCount = {12, 10, 6, 5, 5, 4, 3, 3};
	public static int[] defaultOreCount = {6, 6, 6, 6, 4, 4, 4, 4};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128};
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID() {
		return NetherConfig.ItemStartID;
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
		return NetherConfig.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return NetherConfig.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return NetherConfig.OreHeight[i];
	}

	@Override
	public int oreID() {
		return NetherConfig.NetherMetalsVeinID;
	}

	@Override
	public int brickID() {
		return NetherConfig.NetherMetalsBrickID;
	}

	@Override
	public String getSetName() {
		return "NetherMetal";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Inolashite;
			case(1):
				return MetallurgyEnumToolMaterial.ShadowIron;
			case(2):
				return MetallurgyEnumToolMaterial.Midasium;
			case(3):
				return MetallurgyEnumToolMaterial.Vyroxeres;
			case(4):
				return MetallurgyEnumToolMaterial.Ceruclase;
			case(5):
				return MetallurgyEnumToolMaterial.Kalendrite;
			case(6):
				return MetallurgyEnumToolMaterial.Vulcanite;
			case(7):
				return MetallurgyEnumToolMaterial.Sanguinite;
		}
		return MetallurgyEnumToolMaterial.Inolashite;
	}

	@Override
	public boolean isCatalyst(int i) {
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
		return -1;
	}

}
