package shadow.mods.metallurgy;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSmokeEater extends Block
{
	public boolean active;
	
	public BlockSmokeEater(int par1, Boolean active) {
		super(par1, Material.wood);
		this.active = active;
        //this.setTickRandomly(true);
        
	}
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4) //begin to tick when the block is added
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
    }

	public int tickRate()
    {
        return 20;
    }
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    @Override
    public void updateTick(World world, int x, int y, int z, Random par5Random)
    {
    	super.updateTick(world, x, y, z, par5Random);
    	if(world.isRemote)
    		return;
    	
		if(world.getBlockId(x + 1, y, z) == 1001 || world.getBlockId(x + 1, y, z) == 1000)
		{
			world.setBlock(x + 1, y, z, this.blockID);
		}
		if(world.getBlockId(x - 1, y, z) == 1001 || world.getBlockId(x - 1, y, z) == 1000)
		{
			world.setBlock(x - 1, y, z, this.blockID);
		}
		if(world.getBlockId(x, y + 1, z) == 1001 || world.getBlockId(x, y + 1, z) == 1000)
		{
			world.setBlock(x, y + 1, z, this.blockID);
		}
		if(world.getBlockId(x, y - 1, z) == 1001 || world.getBlockId(x, y - 1, z) == 1000)
		{
			world.setBlock(x, y - 1, z, this.blockID);
		}
		if(world.getBlockId(x, y, z + 1) == 1001 || world.getBlockId(x, y, z + 1) == 1000)
		{
			world.setBlock(x, y, z + 1, this.blockID);
		}
		if(world.getBlockId(x, y, z - 1) == 1001 || world.getBlockId(x, y, z - 1) == 1000)
		{
			world.setBlock(x, y, z - 1, this.blockID);
		}

		world.setBlock(x, y, z, 0);
		
        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate());
		
    }
}
