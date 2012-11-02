package shadow.mods.metallurgy.base;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import shadow.mods.metallurgy.BC_ModelCrusher;
import shadow.mods.metallurgy.BC_TileEntityCrusher;
import net.minecraft.src.Block;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.RenderBlocks;
import net.minecraft.src.TileEntityRenderer;
import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class LanternRenderHelper implements ISimpleBlockRenderingHandler {

	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) 
	{
		// TODO Auto-generated method stub
		TileEntityLantern tec = new TileEntityLantern(metadata);
		TileEntityRenderer.instance.renderTileEntityAt(tec, 0.0D, 0.0D, 0.0D, 0.0F);
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) 
	{
		/*
		// TODO Auto-generated method stub
		TileEntityLantern tec = new TileEntityLantern();
		//tec.setType(metadata);
		TileEntityRenderer.instance.renderTileEntityAt(tec, x, y, z, 0.0F);
		*/
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		// TODO Auto-generated method stub
		return MetallurgyBaseMetals.lantern.getRenderType();
	}

}
