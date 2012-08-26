package shadow.mods.metallurgy;

public interface IMetalSetEnum {
	
	public int numMetals();
	public int getStartID();
	public String[] getNames();
	public int[] getExpValues();
	public String getImageFilename();
	public boolean isAlloy();
	public int[] getVeinCount();
	public int[] getOreCount();
	public int[] getOreHeight();
	public int getOreID();
	public int getBrickID();
	public String getSetName();
}
