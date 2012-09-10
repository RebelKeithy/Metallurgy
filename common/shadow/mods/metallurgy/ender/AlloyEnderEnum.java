package shadow.mods.metallurgy.ender;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.ConfigBase;

public class AlloyEnderEnum implements IMetalSetEnum{

	public static int numMetals = 1;
	public static String[] names = {"Desichalkos"};
	public static String imageName = "/shadow/MetallurgyEnderAlloys.png";
	private int[] expValues = {10};
	private int[] harvestLevels = {4};
	private int[] pickLevels = {4};
	private int[] metalLevels = {7};
	
	public static EnumArmorMaterial desichalkosArmor = EnumHelper.addArmorMaterial("Desichalkos", 30, new int[] {4, 7, 5, 4}, 30);
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigEnder.alloyItemIds[i];
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
		return ConfigEnder.EnderAlloysBrickID;
	}

	@Override
	public String getSetName() {
		return "EnderAlloy";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Steel;
		}
		return MetallurgyEnumToolMaterial.Steel;
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
		return ConfigEnder.alloyEnabled[i];
	}

	@Override
	public EnumArmorMaterial armorEnum(int i) 
	{
		return desichalkosArmor;
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
