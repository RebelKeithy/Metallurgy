package shadow.mods.metallurgy;

import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockSmoke extends Block
{
	public boolean active;
	
	public BlockSmoke(int par1, Boolean active) {
		super(par1, Material.wood);
		this.active = active;
		setLightOpacity(3);
        //this.setTickRandomly(true);
	}
	
    /**
     * Returns whether this block is collideable based on the arguments passed in Args: blockMetaData, unknownFlag
     */
    public boolean canCollideCheck(int par1, boolean par2)
    {
        return false;
    }
    
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        return null;
    }

	
	
	public void onBlockAdded(World par1World, int par2, int par3, int par4) //begin to tick when the block is added
    {
        par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, this.tickRate());
    }

	public int tickRate()
    {
        return 20;
    }
	
    public int getRenderBlockPass()
    {
        return 1;
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
    	
    	if(active && par5Random.nextFloat() < 1)
    	{
    		int metadata = world.getBlockMetadata(x, y, z);
    		int maxSpread = 15;
    		if(metadata < maxSpread)
    		{
    			int[] placeable = new int[6];
    			int count = 0;
    			if(canPlaceBlockAt(world, x + 1, y, z) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[0] = 1;
				}
    			if(canPlaceBlockAt(world, x - 1, y, z) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[1] = 1;
				}
    			if(canPlaceBlockAt(world, x, y + 1, z) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[2] = 1;
				}
    			if(canPlaceBlockAt(world, x, y - 1, z) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[3] = 1;
				}
    			if(canPlaceBlockAt(world, x, y, z + 1) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[4] = 1;
				}
    			if(canPlaceBlockAt(world, x, y, z - 1) && metadata < maxSpread)
				{
					metadata++;
					count++;
					placeable[5] = 1;
				}

    			
    			metadata = (int) (maxSpread - Math.ceil(((maxSpread - metadata) / (double)count)));
    			if(metadata > 15)
    				metadata = 15;
    			
    			if(placeable[0] == 1)
    				world.setBlockAndMetadata(x + 1, y, z, this.blockID, metadata);
    			if(placeable[1] == 1)
    				world.setBlockAndMetadata(x - 1, y, z, this.blockID, metadata);
    			if(placeable[2] == 1)
    				world.setBlockAndMetadata(x, y + 1, z, this.blockID, metadata);
    			if(placeable[3] == 1)
    				world.setBlockAndMetadata(x, y - 1, z, this.blockID, metadata);
    			if(placeable[4] == 1)
    				world.setBlockAndMetadata(x, y, z + 1, this.blockID, metadata);
    			if(placeable[5] == 1)
    				world.setBlockAndMetadata(x, y, z - 1, this.blockID, metadata);
    			
    			if(count > 0)
    			{
        			world.setBlock(x, y, z, MetallurgyCore.smokeInactive.blockID);
    			}
    	        world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate());
    		}
    	}
    }
	
}
