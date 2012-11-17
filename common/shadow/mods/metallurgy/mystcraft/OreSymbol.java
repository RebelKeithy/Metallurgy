package shadow.mods.metallurgy.mystcraft;

import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenLakes;
import java.util.Random;

import xcompwiz.mystcraft.api.symbol.AgeSymbol;
import xcompwiz.mystcraft.api.symbol.AgeSymbol.Category;
import xcompwiz.mystcraft.api.symbol.IAgeController;
import xcompwiz.mystcraft.api.symbol.IPopulate;

import shadow.mods.metallurgy.MetalSet;
import shadow.mods.metallurgy.base.MetallurgyBaseMetals;

public class OreSymbol  extends AgeSymbol 
{
	IPopulate populator;
	MetalSet ores;
	
	public OreSymbol(MetalSet ores)
	{
		populator = new Populator(ores);
		this.ores = ores;
	}
	
	@Override
	public void registerLogic(IAgeController controller, long seed) {
		controller.registerInterface(this, populator);
	}

	@Override
	public String identifier() {
		return ores.info.getSetName().replace("Metal", "") + " Ores";
	}
	
	@Override
	public Category getCategory() {
		return AgeSymbol.Category.WorldModifier;
	}

	public int instabilityModifier(int count) {
		if(count > 2)
			return (count - 2)*50;
		return 0;
	}

	private class Populator implements IPopulate {
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
}
