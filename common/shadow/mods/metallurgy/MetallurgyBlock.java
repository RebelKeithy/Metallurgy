// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package shadow.mods.metallurgy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Block;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.Entity;
import net.minecraft.src.Item;
import net.minecraft.src.Material;
import net.minecraft.src.World;
//import net.minecraft.src.forge.*;
import net.minecraft.src.ItemStack;

// Referenced classes of package net.minecraft.src:
//            Item, IInfiTexture

public class MetallurgyBlock extends Block
{

	public String texturePath;
	public int row;
	public int numTypes;
	public boolean collisionEffect;
	public List<CollisionListener> clList = new ArrayList<CollisionListener>();
	public boolean displayEffect;
	public List<DisplayListener> dlList = new ArrayList<DisplayListener>();
	public boolean isMetalBlock = false;
	
    public MetallurgyBlock(int i, String s, int numTypes, int row) {
        super(i, Material.iron);
        texturePath = s;
        this.setCreativeTab(CreativeTabs.tabBlock);
        this.numTypes = numTypes;
        this.row = row;
    }
    
    public void addCollisionListener(CollisionListener cl)
    {
    	collisionEffect = true;
    	clList.add(cl);
    }
    
    public void addDisplayListener(DisplayListener dl)
    {
        this.setTickRandomly(true);
    	displayEffect = true;
    	dlList.add(dl);
    }
    

    @Override
	public int idDropped(int metadata, Random random, int j) {
		return blockID;
	}
    
    @Override
	public int getBlockTextureFromSideAndMetadata(int i, int j) {
    	if(isMetalBlock)
    		return (16 * j) + 15;
    	else
    		return j + (row * 16);
	}
	
	public String getTextureFile()
    {		
		return texturePath;
    }
	
    public int damageDropped(int metadata) {
        return metadata;
    }
    
    /**
     * Returns a bounding box from the pool of bounding boxes (this means this box can change after the pool has been
     * cleared to be reused)
     */
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4)
    {
    	if(collisionEffect)
    	{
    		float var5 = 0.025F;
    		return AxisAlignedBB.getAABBPool().addOrModifyAABBInPool((double)par2, (double)par3, (double)par4, (double)(par2 + 1), (double)((float)(par3 + 1) - var5), (double)(par4 + 1));
    	}
    	
    	return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
    }

    /**
     * Triggered whenever an entity collides with this block (enters into the block). Args: world, x, y, z, entity
     */
    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity par5Entity)
    {
    	int meta = par1World.getBlockMetadata(par2, par3, par4);
        for(CollisionListener cl : clList)
        	cl.collide(par1World, par2, par3, par4, par5Entity, meta);
    }
    
    /**
     * A randomly called display update to be able to add particles or other items for display
     */
    public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        for(DisplayListener dl : dlList)
        	dl.randomDisplayTick(par1World, par2, par3, par4, par5Random);
    }

	@Override
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs par2CreativeTabs, List par3List) {
		for (int n = 0; n < numTypes; n++) {
			par3List.add(new ItemStack(this, 1, n));
		}
	}
}
