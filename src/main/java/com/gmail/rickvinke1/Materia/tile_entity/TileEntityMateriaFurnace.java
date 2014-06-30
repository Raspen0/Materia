package com.gmail.rickvinke1.Materia.tile_entity;

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
import net.minecraft.tileentity.TileEntity;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityMateriaFurnace extends TileEntity implements ISidedInventory {

	private String localizedName;
	
	
	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_sides = new int[]{1};
	
	private ItemStack[] slots = new ItemStack[3];
	
	/** Furnace Speed*/
	public int furnaceSpeed = 125;
	
	/**How long this furnace will continue to burn for (fuel) */
	public int burnTime;
	
	/**The start time for this item fuel */
	public int currentItemBurnTime;
	
	/**How long time left before cooked */
	public int cooktime;
	
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
	
	public void updateEntity(){
		if(this.burnTime > 0){
			this.burnTime--;
		}
		
		if(!this.worldObj.isRemote){
			if(this.burnTime == 0 && this.canSmelt()){
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);
				
				if(this.burnTime > 0){
					if(this.slots[1] != null){
						this.slots[1].stackSize--;
						
						if(this.slots[1].stackSize ==0){
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}
		}
	}
	
	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.getItem();
			
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air){
				Block block = Block.getBlockFromItem(item);
				
				if(block == Blocks.wooden_slab){
					return 150;
				}
				
				if (block.getMaterial() == Material.wood){
					return 300;
				}
				
				if (block == Blocks.coal_block){
					return 16000;
				}
			}
			
			if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemSword && ((ItemSword) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item instanceof ItemHoe && ((ItemHoe) item).getToolMaterialName().equals("WOOD")) return 200;
			if(item == Items.stick) return 100;
			if(item == Items.coal) return 1600;
			if(item == Items.lava_bucket) return 20000;
			if(item == Item.getItemFromBlock(Blocks.sapling)) return 100;
			if(item == Items.blaze_rod) return 2400;
			
			
			//Custom Fuels
			if(item == MateriaItems.MateriaCoal) return 1600;
			
			return GameRegistry.getFuelValue(itemstack);
		}
	}
	
	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
	}

	
	public int[] getAccessibleSlotsFromSide(int var1) {
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_sides);
	}

	
	public boolean canInsertItem(int i, ItemStack itemstack, int j) {
		return this.isItemValidForSlot(i, itemstack);
	}

	
	public boolean canExtractItem(int i, ItemStack itemstack, int j) {
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}

}
