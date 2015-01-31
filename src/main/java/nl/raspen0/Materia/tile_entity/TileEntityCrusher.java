package nl.raspen0.Materia.tile_entity;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import nl.raspen0.Materia.blocks.BlockCrusher;
import nl.raspen0.Materia.items.MateriaItems;
import nl.raspen0.Materia.recipes.CrusherRecipes;

public class TileEntityCrusher extends TileEntity implements ISidedInventory
{
    private static final int[] slotsTop = new int[] {0};
    private static final int[] slotsBottom = new int[] {2, 1};
    private static final int[] slotsSides = new int[] {1};
    /**
     * The ItemStacks that hold the items currently being used in the furnace
     */
    private ItemStack[] CrusherItemStacks = new ItemStack[3];
    
	/** Furnace Speed*/
	public int crusherspeed = 150;
	
    /** The number of ticks that the furnace will keep burning */
    public int crusherBurnTime;
    /**
     * The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for
     */
    public int currentItemBurnTime;
    /** The number of ticks that the current item has been cooking for */
    public int crusherCookTime;
	private String localizedName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.CrusherItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int i)
    {
        return this.CrusherItemStacks[i];
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     */
    public ItemStack decrStackSize(int i, int j)
    {
        if (this.CrusherItemStacks[i] != null)
        {
            ItemStack itemstack;

            if (this.CrusherItemStacks[i].stackSize <= j)
            {
                itemstack = this.CrusherItemStacks[i];
                this.CrusherItemStacks[i] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.CrusherItemStacks[i].splitStack(j);

                if (this.CrusherItemStacks[i].stackSize == 0)
                {
                    this.CrusherItemStacks[i] = null;
                }

                return itemstack;
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
    public ItemStack getStackInSlotOnClosing(int i)
    {
        if (this.CrusherItemStacks[i] != null)
        {
            ItemStack itemstack = this.CrusherItemStacks[i];
            this.CrusherItemStacks[i] = null;
            return itemstack;
        }
        else
        {
            return null;
        }
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int i, ItemStack itemstack)
    {
        this.CrusherItemStacks[i] = itemstack;

        if (itemstack != null && itemstack.stackSize > this.getInventoryStackLimit())
        {
        	itemstack.stackSize = this.getInventoryStackLimit();
        }
    }

    /**
     * Returns the name of the inventory
     */
    public String getInventoryName()
    {
        return this.hasCustomInventoryName() ? this.localizedName : "container.crusher";
    }

    /**
     * Returns if the inventory is named
     */
    public boolean hasCustomInventoryName()
    {
        return this.localizedName != null && this.localizedName.length() > 0;
    }

    public void setGuiDisplayName(String displayname)
    {
        this.localizedName = displayname;
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        NBTTagList nbttaglist = nbt.getTagList("Items", 10);
        this.CrusherItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.CrusherItemStacks.length)
            {
                this.CrusherItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.crusherBurnTime = nbt.getShort("BurnTime");
        this.crusherCookTime = nbt.getShort("CookTime");
        this.currentItemBurnTime = getItemBurnTime(this.CrusherItemStacks[1]);

        if (nbt.hasKey("CustomName", 8))
        {
            this.localizedName = nbt.getString("CustomName");
        }
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setShort("BurnTime", (short)this.crusherBurnTime);
        nbt.setShort("CookTime", (short)this.crusherCookTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.CrusherItemStacks.length; ++i)
        {
            if (this.CrusherItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.CrusherItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        nbt.setTag("Items", nbttaglist);

        if (this.hasCustomInventoryName())
        {
        	nbt.setString("CustomName", this.localizedName);
        }
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Returns an integer between 0 and the passed value representing how close the current item is to being completely
     * cooked
     */
    @SideOnly(Side.CLIENT)
    public int getCookProgressScaled(int i)
    {
        return this.crusherCookTime * i / crusherspeed;
    }

    /**
     * Returns an integer between 0 and the passed value representing how much burn time is left on the current fuel
     * item, where 0 means that the item is exhausted and the passed value means that the item is fresh
     */
    @SideOnly(Side.CLIENT)
    public int getBurnTimeRemainingScaled(int i)
    {
        if (this.currentItemBurnTime == 0)
        {
            this.currentItemBurnTime = crusherspeed;
        }

        return this.crusherBurnTime * i / this.currentItemBurnTime;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.crusherBurnTime > 0;
    }

    public void updateEntity()
    {
        boolean flag = this.crusherBurnTime > 0;
        boolean flag1 = false;

        if (this.crusherBurnTime > 0)
        {
            --this.crusherBurnTime;
        }

        if (!this.worldObj.isRemote)
        {
            if (this.crusherBurnTime != 0 || this.CrusherItemStacks[1] != null && this.CrusherItemStacks[0] != null)
            {
                if (this.crusherBurnTime == 0 && this.canSmelt())
                {
                    this.currentItemBurnTime = this.crusherBurnTime = getItemBurnTime(this.CrusherItemStacks[1]);

                    if (this.crusherBurnTime > 0)
                    {
                        flag1 = true;

                        if (this.CrusherItemStacks[1] != null)
                        {
                            --this.CrusherItemStacks[1].stackSize;

                            if (this.CrusherItemStacks[1].stackSize == 0)
                            {
                                this.CrusherItemStacks[1] = CrusherItemStacks[1].getItem().getContainerItem(CrusherItemStacks[1]);
                            }
                        }
                    }
                }

                if (this.isBurning() && this.canSmelt())
                {
                    ++this.crusherCookTime;

                    if (this.crusherCookTime == crusherspeed)
                    {
                        this.crusherCookTime = 0;
                        this.smeltItem();
                        flag1 = true;
                    }
                }
                else
                {
                    this.crusherCookTime = 0;
                }
            }

            if (flag != this.crusherBurnTime > 0)
            {
                flag1 = true;
                BlockCrusher.updateMateriaFurnaceBlockState(this.crusherBurnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
            }
        }

        if (flag1)
        {
            this.markDirty();
        }
    }


    
    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        if (this.CrusherItemStacks[0] == null)
        {
            return false;
        }
        else
        {
            ItemStack itemstack = CrusherRecipes.crushing().getCrushingResult(this.CrusherItemStacks[0]);
            if (itemstack == null) return false;
            if (this.CrusherItemStacks[2] == null) return true;
            if (!this.CrusherItemStacks[2].isItemEqual(itemstack)) return false;
            int result = CrusherItemStacks[2].stackSize + itemstack.stackSize;
            return result <= getInventoryStackLimit() && result <= this.CrusherItemStacks[2].getMaxStackSize(); //Forge BugFix: Make it respect stack sizes properly.
        }
    }
    //public void BlueFlames(ItemStack itemstack, Item item, EntityPlayer player)
   // {
  //  	if (this.isBurning()){
  //  		if (CrusherItemStacks[2].getItem() == MateriaItems.MateriaCoal){

    //	}

    	
 //   }
 //   }
    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = CrusherRecipes.crushing().getCrushingResult(this.CrusherItemStacks[0]);

            if (this.CrusherItemStacks[2] == null)
            {
                this.CrusherItemStacks[2] = itemstack.copy();
            }
            else if (this.CrusherItemStacks[2].getItem() == itemstack.getItem())
            {
                this.CrusherItemStacks[2].stackSize += itemstack.stackSize; // Forge BugFix: Results may have multiple items
            }

            --this.CrusherItemStacks[0].stackSize;

            if (this.CrusherItemStacks[0].stackSize <= 0)
            {
                this.CrusherItemStacks[0] = null;
            }
        }
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack itemstack)
    {
        if (itemstack == null)
        {
            return 0;
        }
        else
        {
            Item item = itemstack.getItem();

            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.wooden_slab)
                {
                    return 150;
                }

                if (block.getMaterial() == Material.wood)
                {
                    return 300;
                }

                if (block == Blocks.coal_block)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
            if (item == Items.stick) return 100;
            if (item == Items.coal) return 1600;
            if (item == Items.lava_bucket) return 20000;
            if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
            if (item == Items.blaze_rod) return 2400;
            
			//Custom Fuels
			if(item == MateriaItems.MateriaCoal){
				return 1800;
			}
			
            return GameRegistry.getFuelValue(itemstack);
        }
    }

    public static boolean isItemFuel(ItemStack itemstack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(itemstack) > 0;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     */
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : player.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    public void openInventory() {}

    public void closeInventory() {}

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int i, ItemStack itemstack)
    {
        return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
    }

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     */
    public int[] getAccessibleSlotsFromSide(int i)
    {
        return i == 0 ? slotsBottom : (i == 1 ? slotsTop : slotsSides);
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canInsertItem(int i, ItemStack itemstack, int j)
    {
        return this.isItemValidForSlot(i, itemstack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     */
    public boolean canExtractItem(int i, ItemStack itemstack, int j)
    {
        return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
    }
    
    
    
}