package shadow.mods.metallurgy.precious;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.ender.ConfigEnder;
import shadow.mods.metallurgy.nether.ConfigNether;

public class OrePreciousEnum implements IMetalSetEnum{

	public static final int numMetals = 3;
	public static final String[] name = {"Zinc", "Silver", "Platinum"};
	private final int[] expValues = {3, 5, 20};
	private final int[] harvestLevels = {0, 1, 2};
	private final int[] pickLevels = {0, 0, 2};
	private int[] metalLevels = {1, 2, 5};
	private final int[] dungeonLootChances = {40, 18, 4};
	private final int[] dungeonLootAmounts = {4, 3, 1};

	public static int[] defaultVeinCount = {6, 5, 3};
	public static int[] defaultOreCount = {5, 5, 3};
	public static int[] defaultOreHeight = {128, 128, 128};

	public static EnumArmorMaterial silverArmor = EnumHelper.addArmorMaterial("Silver", 5, new int[] {2, 4, 3, 2}, 20);
	public static EnumArmorMaterial platinumArmor = EnumHelper.addArmorMaterial("Platinum", 11, new int[] {3, 6, 5, 3}, 50);

	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigPrecious.ItemStartID + (i * 50);
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
		return ConfigPrecious.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return ConfigPrecious.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return ConfigPrecious.OreHeight[i];
	}

	@Override
	public int oreMinHeight(int i) {
		return ConfigPrecious.OreMinHeight[i];
	}

	@Override
	public int oreID() {
		return ConfigPrecious.PreciousMetalsVeinID;
	}

	@Override
	public int brickID() {
		return ConfigPrecious.PreciousMetalsBrickID;
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
	
	public EnumArmorMaterial armorEnum(int i)
	{
		switch(i)
		{
			case(0):
				return null;
			case(1):
				return silverArmor;
			case(2):
				return platinumArmor;
		}
		return silverArmor;
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

	@Override
	public boolean spawnsInDimension(int i)
	{
		for(String str : ConfigPrecious.dimensions.split(" ")) {
			if(str.matches("[0-9]+-[0-9]+"))
			{
				int start = Integer.parseInt(str.split("-")[0]);
				int end = Integer.parseInt(str.split("-")[1]);
				if(i >= start && i <= end)
					return true;
			} else {
				if(i == Integer.parseInt(str))
				{
					return true;
				}
			}
		}
		
		return false;
	}

	@Override
	public boolean metalEnabled(int i) {
		return ConfigPrecious.metalEnabled[i];
	}

	@Override
	public int level(int i) {
		return metalLevels[i];
	}

}
