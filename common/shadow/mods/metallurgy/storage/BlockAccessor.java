package shadow.mods.metallurgy.storage;

import java.util.ArrayList;

import shadow.mods.metallurgy.base.MetallurgyBaseMetals;
import shadow.mods.metallurgy.precious.FC_TileEntityChest;
import shadow.mods.metallurgy.precious.MetallurgyPrecious;
import net.minecraft.src.Block;
import net.minecraft.src.BlockContainer;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;

public class BlockAccessor extends BlockContainer 
{
	
    public BlockAccessor(int par1)
    {
        super(par1, Material.wood);
        this.blockIndexInTexture = 4;
        this.setCreativeTab(MetallurgyBaseMetals.baseTab);
    }

	@Override
	public TileEntity createNewTileEntity(World var1) 
	{
		return new TileEntityStorage();
	}

    /**
     * Called upon block activation (left or right click on the block.). The three integers represent x,y,z of the
     * block.
     */
    @Override
    public boolean onBlockActivated(World par1World, int x, int y, int z, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        Object var6 = par1World.getBlockTileEntity(x, y, z);

        if (var6 == null)
        {
            return true;
        }
        else
        {
        	((TileEntityStorage)var6).printSize(par5EntityPlayer);
            if (par1World.isRemote)
            {
                return true;
            }
            else
            {
                par5EntityPlayer.openGui(MetallurgyBaseMetals.instance, -1, par1World, x, y, z);
                return true;
            }
        }
    }

}
