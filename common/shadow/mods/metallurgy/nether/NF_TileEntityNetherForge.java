package shadow.mods.metallurgy.nether;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;

import net.minecraft.src.*;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class NF_TileEntityNetherForge extends TileEntity implements IInventory, ISidedInventory
{
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] furnaceItemStacks = new ItemStack[3];

    /** The number of ticks that the furnace will keep burning */
    public int furnaceBurnTime = 0;

    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime = 0;

    /** The number of ticks that the current item has been cooking for */
    public int furnaceCookTime = 0;
    public float fuelMultiplier = 0.5f;
    
    public int furnaceTimeBase = 200;
    
    public int fuel = 0;
    public int maxFuel = 100;
    public boolean isBurning;

    public int direction = 0;

	private int ticksSinceSync;
    
    public void setSpeed(int var1)
    {
    	furnaceTimeBase = var1;
    }
    
    public void setMaxBuckets(int buckets)
    {
    	maxFuel = buckets * 10;
    }
    
    public void addFuelBucket()
    {
    	fuel += 10;
    }
    
    public int getFuelScaled(int scale)
    {
        return this.fuel * scale / maxFuel;
    }
    
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1)
    {
        return this.furnaceItemStacks[par1];
    }
    
    public void setDirection(int par1)
    {
    	direction = par1;
    }
    
    public int getDirection()
    {
    	return direction;
    }

    /**
     * Decrease the size of the stack in slot (first int arg) by the amount of the second int arg. Returns the new
     * stack.
     */
    public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack var3;

            if (this.furnaceItemStacks[par1].stackSize <= par2)
            {
                var3 = this.furnaceItemStacks[par1];
                this.furnaceItemStacks[par1] = null;
                return var3;
            }
            else
            {
                var3 = this.furnaceItemStacks[par1].splitStack(par2);

                if (this.furnaceItemStacks[par1].stackSize == 0)
                {
                    this.furnaceItemStacks[par1] = null;
                }

                return var3;
            }
        }
        else
        {
            return null;
        }
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     */
    public ItemStack getStackInSlotOnClosing(int par1)
    {
        if (this.furnaceItemStacks[par1] != null)
        {
            ItemStack var2 = this.furnaceItemStacks[par1];
            this.furnaceItemStacks[par1] = null;
            return var2;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.furnaceItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory.
     */
    public String getInvName()
    {
        return "container.furnace";
    }

    /**
     * Reads a tile entity from NBT.
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList var2 = par1NBTTagCompound.getTagList("Items");
        this.furnaceItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3)
        {
            NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.furnaceItemStacks.length)
            {
                this.furnaceItemStacks[var5] = ItemStack.loadItemStackFromNBT(var4);
            }
        }

        this.fuel = par1NBTTagCompound.getShort("Fuel");
        this.furnaceCookTime = par1NBTTagCompound.getShort("CookTime");
        this.direction = par1NBTTagCompound.getShort("Direction");
        this.furnaceTimeBase = par1NBTTagCompound.getShort("TimeBase");
        this.maxFuel = par1NBTTagCompound.getShort("MaxFuel");
    }

    /**
     * Writes a tile entity to NBT.
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("Fuel", (short)this.fuel);
        par1NBTTagCompound.setShort("CookTime", (short)this.furnaceCookTime);
        par1NBTTagCompound.setShort("Direction", (short)this.direction);
        par1NBTTagCompound.setShort("TimeBase", (short)this.furnaceTimeBase);
        par1NBTTagCompound.setShort("MaxFuel", (short)this.maxFuel);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.furnaceItemStacks.length; ++var3)
        {
            if (this.furnaceItemStacks[var3] != null)
            {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte)var3);
                this.furnaceItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        par1NBTTagCompound.setTag("Items", var2);
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended. *Isn't
     * this more of a set than a get?*
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    public int getCookProgressScaled(int par1)
    {
        return this.furnaceCookTime * par1 / furnaceTimeBase;
    }

    /**
     * Returns true if the furnace is currently burning
     */
    public boolean isBurning()
    {
        return this.fuel > 0 && this.canSmelt();
    }

    /**
     * Allows the entity to update its state. Overridden in most subclasses, e.g. the mob spawner uses this to count
     * ticks and creates a new spawn inside its implementation.
     */
    public void updateEntity()
    {
		if ((++ticksSinceSync % 20) == 0) 
        {
			int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 1, direction);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 2, furnaceTimeBase);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 3, fuel);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 4, maxFuel);
		}
		
        boolean var1 = this.furnaceBurnTime > 0;
        boolean var2 = false;
        boolean prevIsBurning = isBurning;

        if(this.canSmelt() && this.fuel > 0)
        {
			++this.furnaceCookTime;
			isBurning = true;

			if (this.furnaceCookTime == furnaceTimeBase) 
			{
				this.furnaceCookTime = 0;
				--this.fuel;
				this.smeltItem();
				var2 = true;
			}
        }
        else
        {
            this.furnaceCookTime = 0;
            isBurning = false;
        }
        
        if(prevIsBurning != isBurning)
        {
        	var2 = true;
            NF_BlockNetherForge.updateFurnaceBlockState(this.isBurning, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
        }

        if (var2)
        {
            this.onInventoryChanged();
			int id = worldObj.getBlockId(xCoord, yCoord, zCoord);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 1, direction);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 2, furnaceTimeBase);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 3, fuel);
			worldObj.addBlockEvent(xCoord, yCoord, zCoord, id, 4, maxFuel);
        }
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);
        if (var1 == null) return false;
        if (this.furnaceItemStacks[2] == null) return true;
        if (!this.furnaceItemStacks[2].isItemEqual(var1)) return false;
        int result = furnaceItemStacks[2].stackSize + var1.stackSize;
        return (result <= getInventoryStackLimit() && result <= var1.getMaxStackSize());
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack var1 = FurnaceRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0]);

            if (this.furnaceItemStacks[2] == null)
            {
                this.furnaceItemStacks[2] = var1.copy();
            }
            else if (this.furnaceItemStacks[2].isItemEqual(var1))
            {
                ++this.furnaceItemStacks[2].stackSize;
            }

            --this.furnaceItemStacks[0].stackSize;

            if (this.furnaceItemStacks[0].stackSize <= 0)
            {
                this.furnaceItemStacks[0] = null;
            }
        }
    }


    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer)
    {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openChest() {}

    public void closeChest() {}


    @Override
	public void receiveClientEvent(int i, int j) 
    {
		if (i == 11) {
			direction = j;
		} else if (i == 2) {
			furnaceTimeBase = j;
		} else if (i == 3) {
			fuel = j;
		} else if (i == 4) {
			maxFuel = j;
		}
	}

    @Override
    public int getStartInventorySide(ForgeDirection side)
    {
        if (side == ForgeDirection.DOWN) return 1;
        if (side == ForgeDirection.UP) return 0; 
        return 2;
    }

    @Override
    public int getSizeInventorySide(ForgeDirection side)
    {
        return 1;
    }

	public int getType() {
		int meta = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);
		return (meta < 8) ? meta : meta - 8;
	}
}
