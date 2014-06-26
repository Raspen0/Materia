package com.gmail.rickvinke1.Materia.tile_entity;
import com.gmail.rickvinke1.Materia.Blocks.BlueMateriaChest;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityChest;

public class TileEntityBlueMateriaChest extends TileEntityChest{



	private String customName;
	private ItemStack[] chestContents = new ItemStack[54];
	private int cachedChestType;

    @Override
	public int getSizeInventory()
    {
        return 54;
    }


	 public TileEntityBlueMateriaChest adjacentChestZNeg;

	    public TileEntityBlueMateriaChest adjacentChestXPos;

	    public TileEntityBlueMateriaChest adjacentChestXNeg;

	    public TileEntityBlueMateriaChest adjacentChestZPos;

	    public String getInventoryName()
	    {
	        return this.hasCustomInventoryName() ? this.customName : "Blue Materia Chest";
	    }

	    public boolean hasCustomInventoryName()
	    {
	        return this.customName != null && this.customName.length() > 0;
	    }

	    public void func_145976_a(String p_145976_1_)
	    {
	        this.customName = p_145976_1_;
	    }

	    public void readFromNBT(NBTTagCompound p_145839_1_)
	    {
	        super.readFromNBT(p_145839_1_);
	        NBTTagList nbttaglist = p_145839_1_.getTagList("Items", 10);
	        this.chestContents = new ItemStack[this.getSizeInventory()];

	        if (p_145839_1_.hasKey("Blue Materia Chest", 8))
	        {
	            this.customName = p_145839_1_.getString("Blue Materia Chest");
	        }

	        for (int i = 0; i < nbttaglist.tagCount(); ++i)
	        {
	            NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
	            int j = nbttagcompound1.getByte("Slot") & 255;

	            if (j >= 0 && j < this.chestContents.length)
	            {
	                this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
	            }
	        }
	    }

	    public void writeToNBT(NBTTagCompound p_145841_1_)
	    {
	        super.writeToNBT(p_145841_1_);
	        NBTTagList nbttaglist = new NBTTagList();

	        for (int i = 0; i < this.chestContents.length; ++i)
	        {
	            if (this.chestContents[i] != null)
	            {
	                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
	                nbttagcompound1.setByte("Slot", (byte)i);
	                this.chestContents[i].writeToNBT(nbttagcompound1);
	                nbttaglist.appendTag(nbttagcompound1);
	            }
	        }

	        p_145841_1_.setTag("Items", nbttaglist);

	        if (this.hasCustomInventoryName())
	        {
	            p_145841_1_.setString("Blue Materia Chest", this.customName);
	        }
	    }




	    public ItemStack getStackInSlot(int par1){
	    	return this.chestContents[par1];
	    }

	    public ItemStack decrStackSize(int par1, int par2)
	    {
	        if (this.chestContents[par1] != null)
	        {
	            ItemStack itemstack;

	            if (this.chestContents[par1].stackSize <= par2)
	            {
	                itemstack = this.chestContents[par1];
	                this.chestContents[par1] = null;
	                this.markDirty();
	                return itemstack;
	            }
	            else
	            {
	                itemstack = this.chestContents[par1].splitStack(par2);

	                if (this.chestContents[par1].stackSize == 0)
	                {
	                    this.chestContents[par1] = null;
	                }

	                this.markDirty();
	                return itemstack;
	            }
	        }
	        else
	        {
	            return null;
	        }
	    }

	    public ItemStack getStackInSlotOnClosing(int par1){
	    	if(this.chestContents[par1] != null){
	    		ItemStack itemstack = this.chestContents[par1];
	    		this.chestContents[par1] = null;
	    		return itemstack;
	    	}
	    	else{
	    		return null;
	    	}
	    }

	    public void setInventorySlotContents(int par1, ItemStack itemstack){
	    	this.chestContents[par1] = itemstack;
	    	if(itemstack != null && itemstack.stackSize > this.getInventoryStackLimit()){
	    		itemstack.stackSize = this.getInventoryStackLimit();
	    	}
	    	this.markDirty();
	    }

}