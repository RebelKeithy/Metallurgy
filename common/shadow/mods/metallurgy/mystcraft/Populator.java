package shadow.mods.metallurgy.mystcraft;

import java.util.Random;

import net.minecraft.src.World;
import shadow.mods.metallurgy.MetalSet;
import xcompwiz.mystcraft.api.symbol.IPopulate;

public class Populator implements IPopulate {

	MetalSet ores;
	
	public Populator(MetalSet ores) 
	{
		this.ores = ores;
	}

	public boolean populate(World worldObj, Random rand, int i, int j, boolean flag) {
		if(flag)
			return false;
		ores.generateAllOres(rand, i/16, j/16, worldObj);
		
		return false;
	}
}
