package shadow.mods.metallurgy.mystcraft;

import xcompwiz.mystcraft.api.APICallHandler;
import xcompwiz.mystcraft.api.symbol.AgeSymbol;
import xcompwiz.mystcraft.api.symbol.IAgeController;
import xcompwiz.mystcraft.api.symbol.ITerrainGenerator;

public class TerrainSymbol extends AgeSymbol implements ITerrainGenerator{

	static {
		APICallHandler.registerSymbol(new TerrainSymbol());
	}
	
	@Override
	public void registerLogic(IAgeController controller) {
		controller.registerInterface(this, this);
	}

	@Override
	public String identifier() {
		return "Random Terrain";
	}

	@Override
	public Category getCategory() {
		return AgeSymbol.Category.TerrainGen;
	}

	@Override
	public void generateTerrain(int i, int j, byte[] abyte0) {
		if(i == 0 && j == 0)
		{
			for(int x = 0; x < 16; x++)
			{
				for(int y = 0; y < 64; y++)
				{
					for(int z = 0; z < 16; z++)
					{
						int pos = x << 11 | z << 7 | z;
						abyte0[pos] = 1;
					}
				}
			}
		}
	}

}
