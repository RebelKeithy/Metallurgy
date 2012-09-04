package shadow.mods.metallurgy;

import java.util.List;

import net.minecraft.src.EnumArmorMaterial;

public interface IMetalSetEnum {
	
	public int numMetals();
	public int startID(int i);
	public String name(int i);
	public int expValue(int i);
	public int oreHarvestLevel(int i);
	public int brickHarvestLevel(int i);
	public int pickLevel(int i);
	public int dungeonLootChance(int i);
	public int dungeonLootAmount(int i);
	public String image();
	public boolean isAlloy();
	public int veinCount(int i);
	public int oreCount(int i);
	public int oreHeight(int i);
	public int oreMinHeight(int i);
	public int oreID();
	public int brickID();
	public String getSetName();
	public MetallurgyEnumToolMaterial toolEnum(int i);
	public boolean isCatalyst(int i);
	public int numRails(int i);
	public boolean spawnsInDimension(int i);
	public boolean metalEnabled(int i);
	public EnumArmorMaterial armorEnum(int i);
}


