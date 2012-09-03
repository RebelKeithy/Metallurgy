package shadow.mods.metallurgy.base;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.BlockLadder;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraftforge.common.ForgeDirection;
import static net.minecraftforge.common.ForgeDirection.*;

public class BlockMetalLadder extends BlockLadder
{
    protected BlockMetalLadder(int par1, int par2)
    {
        super(par1, par2);
        this.setRequiresSelfNotify();
        this.setCreativeTab(CreativeTabs.tabDeco);
    }

	@Override
	public String getTextureFile()
    {		
		return "/shadow/MetallurgyFurnaces.png";
    }

    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4);
        float var6 = 0.125F;

        if (var5 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4)
        {
            this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    @SideOnly(Side.CLIENT)

    /**
     * Returns the bounding box of the wired rectangular prism to render.
     */
    public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
        int var5 = par1World.getBlockMetadata(par2, par3, par4) / 4;
        float var6 = 0.125F;

        if (var5 == 2)
        {
            this.setBlockBounds(0.0F, 0.0F, 1.0F - var6, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 3)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var6);
        }

        if (var5 == 4)
        {
            this.setBlockBounds(1.0F - var6, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }

        if (var5 == 5)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0F, var6, 1.0F, 1.0F);
        }

        return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * called before onBlockPlacedBy by ItemBlock and ItemReed
     */
    public void updateBlockMetadata(World par1World, int par2, int par3, int par4, int par5, float par6, float par7, float par8)
    {
        int var9 = par1World.getBlockMetadata(par2, par3, par4) / 4;
        int type = par1World.getBlockMetadata(par2, par3, par4) - (var9 * 4);

        if ((var9 == 0 || par5 == 2) && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
        {
            var9 = 2;
        }

        if ((var9 == 0 || par5 == 3) && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
        {
            var9 = 3;
        }

        if ((var9 == 0 || par5 == 4) && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
        {
            var9 = 4;
        }

        if ((var9 == 0 || par5 == 5) && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
        {
            var9 = 5;
        }

        par1World.setBlockMetadataWithNotify(par2, par3, par4, var9 + type);
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     */
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        int var6 = par1World.getBlockMetadata(par2, par3, par4);
        boolean var7 = false;

        if (var6 == 2 && par1World.isBlockSolidOnSide(par2, par3, par4 + 1, NORTH))
        {
            var7 = true;
        }

        if (var6 == 3 && par1World.isBlockSolidOnSide(par2, par3, par4 - 1, SOUTH))
        {
            var7 = true;
        }

        if (var6 == 4 && par1World.isBlockSolidOnSide(par2 + 1, par3, par4, WEST))
        {
            var7 = true;
        }

        if (var6 == 5 && par1World.isBlockSolidOnSide(par2 - 1, par3, par4, EAST))
        {
            var7 = true;
        }

        if (!var7)
        {
            this.dropBlockAsItem(par1World, par2, par3, par4, var6, 0);
            par1World.setBlockWithNotify(par2, par3, par4, 0);
        }

        super.onNeighborBlockChange(par1World, par2, par3, par4, par5);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
        par5Entity.motionY *= 1.4D;
    }
}
