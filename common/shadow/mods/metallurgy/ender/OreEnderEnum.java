package shadow.mods.metallurgy.ender;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.EnumArmorMaterial;
import net.minecraftforge.common.EnumHelper;
import shadow.mods.metallurgy.IMetalSetEnum;
import shadow.mods.metallurgy.MetallurgyEnumToolMaterial;
import shadow.mods.metallurgy.base.ConfigBase;

public class OreEnderEnum implements IMetalSetEnum{

	public static final int numMetals = 2;	
	public static String imageName = "/shadow/MetallurgyEnderMetals.png";
	public static String[] names = {"Eximite", "Meutoite"};
	public static int[] expValues = {3, 3};
	private final int[] harvestLevels = {2, 3};
	private final int[] pickLevels = {2, 0};

	public static int[] defaultVeinCount = {12, 10};
	public static int[] defaultOreCount = {6, 6};
	public static int[] defaultOreHeight = {128, 128};

	public static EnumArmorMaterial eximiteArmor = EnumHelper.addArmorMaterial("Eximite", 24, new int[] {4, 6, 5, 4}, 25);

	public static List<Integer> dimList = new ArrayList<Integer>();
	
	static
	{
		for(String str : ConfigEnder.dimensions.split(" ")) {
		    dimList.add(Integer.parseInt(str));
		}
	}
	
	@Override
	public int numMetals() {
		return numMetals;
	}

	@Override
	public int startID(int i) {
		return ConfigEnder.metalItemIds[i];
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
		return ConfigEnder.VeinCount[i];
	}

	@Override
	public int oreCount(int i) {
		return ConfigEnder.OreCount[i];
	}

	@Override
	public int oreHeight(int i) {
		return ConfigEnder.OreHeight[i];
	}

	@Override
	public int oreID() {
		return ConfigEnder.EnderMetalsVeinID;
	}

	@Override
	public int brickID() {
		return ConfigEnder.EnderMetalsBrickID;
	}

	@Override
	public String getSetName() {
		return "EnderMetal";
	}

	@Override
	public MetallurgyEnumToolMaterial toolEnum(int i) {
		switch(i)
		{
			case(0):
				return MetallurgyEnumToolMaterial.Copper;
		}
		return MetallurgyEnumToolMaterial.Copper;
	}

	@Override
	public boolean isCatalyst(int i) {
		if(i == 1)
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
		for(String str : ConfigEnder.dimensions.split(" ")) {
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
		return ConfigEnder.metalEnabled[i];
	}

	@Override
	public EnumArmorMaterial armorEnum(int i) 
	{
		return eximiteArmor;
	}

	@Override
	public int oreMinHeight(int i) {
		// TODO Auto-generated method stub
		return ConfigEnder.OreMinHeight[i];
	}

}
