package shadow.mods.metallurgy;

import java.util.List;

import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;

public abstract class IMetalSetEnum {
	
	public abstract int numMetals();
	public abstract int startID(int i);
	public abstract String name(int i);
	public abstract int expValue(int i);
	public abstract int oreHarvestLevel(int i);
	public abstract int brickHarvestLevel(int i);
	public abstract int pickLevel(int i);
	public int dungeonLootChance(int i)
	{
		return 0;
	}
	
	public int dungeonLootAmount(int i)
	{
		return 0;
	}
	
	public abstract String image();
	
	public boolean isAlloy()
	{
		return false;
	}
	
	public int veinCount(int i)
	{
		return 0;
	}
	
	public int oreCount(int i)
	{
		return 0;
	}
	
	public int oreHeight(int i)
	{
		return 0;
	}
	
	public int oreMinHeight(int i)
	{
		return 0;
	}
	
	public abstract int oreID();
	public abstract int brickID();
	public abstract String getSetName();
	public abstract MetallurgyEnumToolMaterial toolEnum(int i);
	public abstract boolean isCatalyst(int i);
	
	public int numRails(int i)
	{
		return 0;
	}
	
	public abstract boolean spawnsInDimension(int i);
	public abstract boolean metalEnabled(int i);
	public abstract EnumArmorMaterial armorEnum(int i);
	public abstract int level(int i);
	
	public boolean hasMetalBlock() 
	{
		return false;
	}
	public int blockID() 
	{
		return 0;
	}
	public abstract CreativeTabs getCreativeTab();
}


