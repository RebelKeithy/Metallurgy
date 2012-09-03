package shadow.mods.metallurgy.fantasy;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.BaseConfig;
import shadow.mods.metallurgy.ender.EnderConfig;

public class AlloyFantasyEnum implements IMetalSetEnum{

	public static int numMetals = 5;
	public static String[] names = {"Black Steel", "Quicksilver", "Haderoth", "Celenegil", "Tartarite"};
	public static String imageName = "/shadow/MetallurgyFantasyAlloys.png";
	private int[] expValues = {4, 9, 6, 25, 13};
	private int[] harvestLevels = {2, 4, 4, 5, 7};
	private int[] pickLevels = {3, 5, 5, 6, 7};

	public static EnumArmorMaterial blackSteelArmor = EnumHelper.addArmorMaterial("Black Steel", 22, new int[] {3, 6, 5, 3}, 17);
	public static EnumArmorMaterial quicksilverArmor = EnumHelper.addArmorMaterial("Quicksilver", 30, new int[] {4, 7, 5, 4}, 20);
	public static EnumArmorMaterial haderothArmor = EnumHelper.addArmorMaterial("Haderoth", 32, new int[] {4, 7, 5, 4}, 19);
	public static EnumArmorMaterial celenegilArmor = EnumHelper.addArmorMaterial("Celenegil", 36, new int[] {5, 7, 6, 4}, 50);
	public static EnumArmorMaterial tartariteArmor = EnumHelper.addArmorMaterial("Tartarite", 42, new int[] {5, 7, 6, 5}, 25);
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return FantasyConfig.ItemStartID + 600 + (i * 50);
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
		return FantasyConfig.FantasyAlloysBrickID;
	}

	@Override
	public String getSetName() {
		return "FantasyAlloy";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.BlackSteel;
			case(1):
				return MetallurgyEnumToolMaterial.Quicksilver;
			case(2):
				return MetallurgyEnumToolMaterial.Haderoth;
			case(3):
				return MetallurgyEnumToolMaterial.Celenegil;
			case(4):
				return MetallurgyEnumToolMaterial.Tartarite;
		}
		return MetallurgyEnumToolMaterial.BlackSteel;
	}
	
	public EnumArmorMaterial armorEnum(int i)
	{
		switch(i)
		{
			case(0):
				return blackSteelArmor;
			case(1):
				return quicksilverArmor;
			case(2):
				return haderothArmor;
			case(3):
				return celenegilArmor;
			case(4):
				return tartariteArmor;
		}
		return blackSteelArmor;
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
		return FantasyConfig.dimensionID;
	}

	@Override
	public boolean metalEnabled(int i) {
		return FantasyConfig.alloyEnabled[i];
	}

}
