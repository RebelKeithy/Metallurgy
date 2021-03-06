package shadow.mods.metallurgy.fantasy;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.ConfigBase;
import shadow.mods.metallurgy.ender.ConfigEnder;

public class OreFantasyEnum extends IMetalSetEnum{

	public static final int numMetals = 12;	
	public static String imageName = "/shadow/MetallurgyFantasyMetals.png";
	public static String[] names = {"Prometheum", "Deep Iron", "Infuscolium", "Oureclase", "Aredrite", "Astral Silver", "Carmot", "Mithril", "Rubracium", "Orichalcum", "Adamantine", "Atlarus"};
	public static int[] expValues = {1, 2, 4, 3, 3, 11, 15, 4, 2, 5, 6, 7};
	private final int[] harvestLevels = {1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5};
	private final int[] pickLevels = {1, 2, 0, 3, 3, 4, 4, 4, 0, 5, 6, 6};
	private int[] metalLevels = {1, 2, 3, 5, 5, 6, 7, 8, 9, 10, 10, 11};

	public static int[] defaultVeinCount = {5, 5, 5, 4, 4, 3, 3, 3, 2, 2, 1, 1};
	public static int[] defaultOreCount = {6, 4, 3, 3, 3, 3, 3, 3, 3, 4, 4, 3};
	public static int[] defaultOreHeight = {128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128, 128};

	public static EnumArmorMaterial prometheumArmor = EnumHelper.addArmorMaterial("Prometheum", 9, new int[] {2, 3, 2, 1}, 16);
	public static EnumArmorMaterial deepIronArmor = EnumHelper.addArmorMaterial("Deep Iron", 14, new int[] {2, 6, 5, 2}, 14);
	public static EnumArmorMaterial oureclaseArmor = EnumHelper.addArmorMaterial("Oureclase", 20, new int[] {3, 6, 5, 4}, 18);
	public static EnumArmorMaterial aredriteArmor = EnumHelper.addArmorMaterial("Aredrite", 24, new int[] {3, 6, 5, 4}, 18);
	public static EnumArmorMaterial astralSilverArmor = EnumHelper.addArmorMaterial("Astral Silver", 10, new int[] {2, 6, 5, 2}, 30);
	public static EnumArmorMaterial carmotArmor = EnumHelper.addArmorMaterial("Carmot", 12, new int[] {3, 6, 5, 3}, 40);
	public static EnumArmorMaterial mithrilArmor = EnumHelper.addArmorMaterial("Mithril", 28, new int[] {4, 6, 5, 4}, 18);
	public static EnumArmorMaterial orichalcumArmor = EnumHelper.addArmorMaterial("Orichalcum", 34, new int[] {4, 7, 6, 4}, 20);
	public static EnumArmorMaterial adamantineArmor = EnumHelper.addArmorMaterial("Adamantine", 38, new int[] {5, 7, 6, 4}, 22);
	public static EnumArmorMaterial atlarusArmor = EnumHelper.addArmorMaterial("Atlarus", 40, new int[] {5, 7, 6, 4}, 22);
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigFantasy.ItemStartID + (i * 50);
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
		return ConfigFantasy.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return ConfigFantasy.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return ConfigFantasy.OreHeight[i];
	}

	@Override
	public int oreID() {
		return ConfigFantasy.FantasyMetalsVeinID;
	}

	@Override
	public int brickID() {
		return ConfigFantasy.FantasyMetalsBrickID;
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
	
	public EnumArmorMaterial armorEnum(int i)
	{
		switch(i)
		{
			case(0):
				return prometheumArmor;
			case(1):
				return deepIronArmor;
			case(2):
				return null;
			case(3):
				return oureclaseArmor;
			case(4):
				return aredriteArmor;
			case(5):
				return astralSilverArmor;
			case(6):
				return carmotArmor;
			case(7):
				return mithrilArmor;
			case(8):
				return null;
			case(9):
				return orichalcumArmor;
			case(10):
				return adamantineArmor;
			case(11):
				return atlarusArmor;
		}
		return prometheumArmor;
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
	public boolean spawnsInDimension(int i)
	{
		for(String str : ConfigFantasy.dimensions.split(" ")) {
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
		return ConfigFantasy.metalEnabled[i];
	}

	@Override
	public int oreMinHeight(int i) {
		return ConfigFantasy.OreMinHeight[i];
	}

	@Override
	public int level(int i) {
		return metalLevels[i];
	}
	
	public boolean hasMetalBlock() 
	{
		return true;
	}
	public int blockID() 
	{
		return ConfigFantasy.oresBlockID;
	}

	@Override
	public CreativeTabs getCreativeTab() {
		return MetallurgyFantasy.creativeTab;
	}

}
