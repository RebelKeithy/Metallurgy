package shadow.mods.metallurgy.nether;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.ender.ConfigEnder;

public class OreNetherEnum implements IMetalSetEnum{

	public static final int numMetals = 10;	
	public static String imageName = "/shadow/MetallurgyNetherMetals.png";
	public static String[] names = {"Ignatius", "Shadow Iron", "Midasium", "Vyroxeres", "Ceruclase", "Kalendrite", "Vulcanite", "Sanguinite", "Lemurite", "Adluorite"};
	public static int[] expValues = {1, 2, 3, 3, 3, 4, 5, 6, 3, 4};
	private final int[] harvestLevels = {2, 2, 3, 3, 3, 4, 5, 6, 0, 0};
	private final int[] pickLevels = {2, 2, 4, 4, 4, 5, 6, 7, 0, 0};
	private int[] metalLevels = {1, 2, 4, 5, 6, 8, 10, 11, 2, 6};

	public static int[] defaultVeinCount = {12, 10, 6, 5, 5, 4, 3, 3, 8, 6};
	public static int[] defaultOreCount = {6, 6, 6, 6, 4, 4, 4, 4, 6, 4};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128, 128, 128};

	public static EnumArmorMaterial ignatiusArmor = EnumHelper.addArmorMaterial("Ignatius", 15, new int[] {2, 6, 5, 2}, 15);
	public static EnumArmorMaterial shadowIronArmor = EnumHelper.addArmorMaterial("Shadow Iron", 16, new int[] {3, 6, 5, 2}, 3);
	public static EnumArmorMaterial midasiumArmor = EnumHelper.addArmorMaterial("Midasium", 8, new int[] {2, 5, 3, 3}, 35);
	public static EnumArmorMaterial vyroxeresArmor = EnumHelper.addArmorMaterial("Vyroxeres", 23, new int[] {3, 6, 5, 4}, 16);
	public static EnumArmorMaterial ceruclaseArmor = EnumHelper.addArmorMaterial("Ceruclase", 25, new int[] {3, 6, 5, 4}, 18);
	public static EnumArmorMaterial kalendriteArmor = EnumHelper.addArmorMaterial("Kalendrite", 28, new int[] {4, 6, 5, 4}, 20);
	public static EnumArmorMaterial vulcaniteArmor = EnumHelper.addArmorMaterial("Vulcanite", 34, new int[] {4, 7, 5, 4}, 20);
	public static EnumArmorMaterial sanguiniteArmor = EnumHelper.addArmorMaterial("Sanguinite", 36, new int[] {5, 7, 6, 4}, 25);
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigNether.metalItemIds[i];
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
		return ConfigNether.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return ConfigNether.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return ConfigNether.OreHeight[i];
	}

	@Override
	public int oreID() {
		return ConfigNether.NetherMetalsVeinID;
	}

	@Override
	public int brickID() {
		return ConfigNether.NetherMetalsBrickID;
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
				return MetallurgyEnumToolMaterial.Ignatius;
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
		return MetallurgyEnumToolMaterial.Ignatius;
	}
	
	public EnumArmorMaterial armorEnum(int i)
	{
		switch(i)
		{
			case(0):
				return ignatiusArmor;
			case(1):
				return shadowIronArmor;
			case(2):
				return midasiumArmor;
			case(3):
				return vyroxeresArmor;
			case(4):
				return ceruclaseArmor;
			case(5):
				return kalendriteArmor;
			case(6):
				return vulcaniteArmor;
			case(7):
				return sanguiniteArmor;
		}
		return ignatiusArmor;
	}

	@Override
	public boolean isCatalyst(int i) {
		if(i >= 8)
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
	public boolean spawnsInDimension(int i)
	{
		for(String str : ConfigNether.dimensions.split(" ")) {
			if(str.matches("[0-9]+-[0-9]+"))
			{
				int start = Integer.parseInt(str.split("-")[0]);
				int end = Integer.parseInt(str.split("-")[1]);
				if(i >= start && i <= end)
					return true;
			} else {
				if(i == Integer.parseInt(str))
					return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean metalEnabled(int i) {
		return ConfigNether.metalEnabled[i];
	}

	@Override
	public int oreMinHeight(int i) {
		return ConfigNether.OreMinHeight[i];
	}

	@Override
	public int level(int i) {
		return metalLevels[i];
	}

}
