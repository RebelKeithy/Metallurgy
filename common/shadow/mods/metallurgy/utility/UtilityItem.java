package shadow.mods.metallurgy.utility;

import net.minecraft.src.Item;

public class UtilityItem extends Item
{
	public String texturePath;

	protected UtilityItem(int par1, String s) {
		super(par1);
        texturePath = s;
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTextureFile()
    {		
		return texturePath;
    }

	public String toString()
	{
		return this.getItemName();
		
		//return super.toString();
	}
}
