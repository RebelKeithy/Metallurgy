package shadow.mods.metallurgy;

import java.util.List;

public interface IMetalSetEnum {
	
	public int numMetals();
	public int startID();
	public String[] names();
	public int[] expValues();
	public String image();
	public boolean isAlloy();
	public int[] veinCount();
	public int[] oreCount();
	public int[] oreHeight();
	public int oreID();
	public int brickID();
	public String getSetName();
	public List catalysts();
}
