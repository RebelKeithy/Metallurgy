package shadow.mods.metallurgy.storage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;

public class BlockStorage extends Block
{
	

    public BlockStorage(int par1)
    {
        super(par1, Material.iron);
        this.blockIndexInTexture = 1;
        this.setCreativeTab(MetallurgyBaseMetals.baseTab);
    }


    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    @Override
    public void onBlockAdded(World par1World, int x, int y, int z) 
    {
    	if(par1World.isRemote)
    		return;
    	
    	
    	
    	List<Coordinate> searched = new ArrayList<Coordinate>();
    	searched.add(new Coordinate(x, y, z));
    	if(searched.contains(new Coordinate(x, y, z)))
    		System.out.println("good!");
    	else
    		System.out.println("bad!");
    		
    	TileEntityStorage te = findAccessor(par1World, x, y, z, searched);
    	te.updateSize();
    }
    
    public TileEntityStorage findAccessor(World world, int x, int y, int z, List<Coordinate> searched)
    {
    	System.out.println("Searching " + x + " " + y + " " + z);
    	
    	TileEntityStorage te = null;
    	searched.add(new Coordinate(x, y, z));
    	for(int i = -1; i <= 1; i++)
    	{
    		for(int j = -1; j <= 1; j++)
    		{
    			for(int k = -1; k <= 1; k++)
    			{
    				if(i == 0 && j == 0 && k == 0)
    					continue;
    				if(searched.contains(new Coordinate(x + i, y + j, z + k)))
    					continue;
    				
    				int id = world.getBlockId(x + i, y + j, z + k);
    				if(id == MetallurgyBaseMetals.accessor.blockID)
    				{
    					te = (TileEntityStorage) world.getBlockTileEntity(x + i, y + j, z + k);
    					if(te != null && te.isMain())
    					{
    						return te;
    					}
    					else
    					{
    						System.out.println("tile entity is null");
    						te = findAccessor(world, x + i, y + j, z + k, searched);
    						if(te != null)
	    						return te;
    					}
    				}
    				else if(id == MetallurgyBaseMetals.storage.blockID)
    				{
						te = findAccessor(world, x + i, y + j, z + k, searched);
						if(te != null)
    						return te;
    				}
    			}
    		}
    	}
    	return null;
    }
    
}
