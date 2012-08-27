package shadow.mods.metallurgy.nether;

import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;

public class AlloyNetherEnum implements IMetalSetEnum{

	public static int numMetals = 3;
	public static String[] names = {"Shadow Steel", "Inolashite", "Amordrine"};
	public static String imageName = "/shadow/MetallurgyNetherAlloys.png";
	private int[] expValues = {4, 6, 24};
	private int[] harvestLevels = {2, 3, 4};
	private int[] pickLevels = {2, 4, 4};
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID() {
		return NetherConfig.ItemStartID + 400;
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
		return NetherConfig.NetherAlloysBrickID;
	}

	@Override
	public String getSetName() {
		return "NetherAlloy";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.ShadowSteel;
			case(1):
				return MetallurgyEnumToolMaterial.Inolashite;
			case(2):
				return MetallurgyEnumToolMaterial.Amordrine;
		}
		return MetallurgyEnumToolMaterial.Brass;
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

}
