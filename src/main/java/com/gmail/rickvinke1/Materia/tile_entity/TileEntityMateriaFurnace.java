package com.gmail.rickvinke1.Materia.tile_entity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMateriaFurnace extends TileEntity implements ISidedInventory {

	private String localizedName;
	
	private ItemStack[] slots = new ItemStack[3];
	
	public int getSizeInventory(){
		return this.slots.length;
	}
	
	public String getInvName(){
		return this.isInvNameLocalized() ? this.localizedName : "container.materiaFurnace";
	}
	
	public boolean isInvNameLocalized() {
		return this.localizedName != null && this.localizedName.length() > 0;
	}
		
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;

	}

	public ItemStack getStackInSlot(int p_70301_1_) {

		return null;
	}


	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {

		return null;
	}


	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {

		return null;
	}

	
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
				
	}


	public String getInventoryName() {

		return null;
	}


	public boolean hasCustomInventoryName() {

		return false;
	}


	public int getInventoryStackLimit() {

		return 0;
	}


	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {

		return false;
	}


	public void openInventory() {

		
	}


	public void closeInventory() {

		
	}


	public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {

		return false;
	}

	
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}

	
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

}
