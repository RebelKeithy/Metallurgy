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
	
	public void instantiate(IAgeController controller) {
		controller.registerInterface(this, populator);
	}

	public String identifier() {
		System.out.println("setting name " + ores.info.getSetName().replace("Metal", "") + " Ores");
		return ores.info.getSetName().replace("Metal", "") + " Ores";
	}
	@Override
	public Category getCategory() {
		return AgeSymbol.Category.WorldModifier;
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
