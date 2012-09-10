package shadow.mods.metallurgy.nether;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.ender.ConfigEnder;
import shadow.mods.metallurgy.fantasy.ConfigFantasy;

public class AlloyNetherEnum implements IMetalSetEnum{

	public static int numMetals = 3;
	public static String[] names = {"Shadow Steel", "Inolashite", "Amordrine"};
	public static String imageName = "/shadow/MetallurgyNetherAlloys.png";
	private int[] expValues = {4, 6, 24};
	private int[] harvestLevels = {2, 4, 4};
	private int[] pickLevels = {2, 4, 4};
	private int[] metalLevels = {3, 7, 9};

	public static EnumArmorMaterial shadowSteelArmor = EnumHelper.addArmorMaterial("Shadow Steel", 20, new int[] {3, 6, 5, 4}, 5);
	public static EnumArmorMaterial inolashiteArmor = EnumHelper.addArmorMaterial("Inolashite", 30, new int[] {4, 7, 5, 4}, 25);
	public static EnumArmorMaterial amordrineArmor = EnumHelper.addArmorMaterial("Amordrine", 32, new int[] {4, 7, 5, 4}, 50);
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigNether.alloyItemIds[i];
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
		return ConfigNether.NetherAlloysBrickID;
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
	
	public EnumArmorMaterial armorEnum(int i)
	{
		switch(i)
		{
			case(0):
				return shadowSteelArmor;
			case(1):
				return inolashiteArmor;
			case(2):
				return amordrineArmor;
		}
		return shadowSteelArmor;
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
	public boolean spawnsInDimension(int i)
	{
		return false;
	}

	@Override
	public boolean metalEnabled(int i) {
		return ConfigNether.alloyEnabled[i];
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
