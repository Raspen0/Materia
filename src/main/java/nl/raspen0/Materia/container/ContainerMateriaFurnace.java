package nl.raspen0.Materia.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import nl.raspen0.Materia.tile_entity.TileEntityMateriaFurnace;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerMateriaFurnace extends Container
{
    private TileEntityMateriaFurnace materiaFurnace;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;
    private static final String __OBFID = "CL_00001748";

    public ContainerMateriaFurnace(InventoryPlayer inventory, TileEntityMateriaFurnace tileentity)
    {
        this.materiaFurnace = tileentity;
        this.addSlotToContainer(new Slot(tileentity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileentity, 1, 56, 53));
        this.addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 2, 116, 35));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(inventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting p_75132_1_)
    {
        super.addCraftingToCrafters(p_75132_1_);
        p_75132_1_.sendProgressBarUpdate(this, 0, this.materiaFurnace.furnaceCookTime);
        p_75132_1_.sendProgressBarUpdate(this, 1, this.materiaFurnace.furnaceBurnTime);
        p_75132_1_.sendProgressBarUpdate(this, 2, this.materiaFurnace.currentItemBurnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.materiaFurnace.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.materiaFurnace.furnaceCookTime);
            }

            if (this.lastBurnTime != this.materiaFurnace.furnaceBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.materiaFurnace.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.materiaFurnace.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.materiaFurnace.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.materiaFurnace.furnaceCookTime;
        this.lastBurnTime = this.materiaFurnace.furnaceBurnTime;
        this.lastItemBurnTime = this.materiaFurnace.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.materiaFurnace.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.materiaFurnace.furnaceBurnTime = par2;
        }

        if (par1 == 2)
        {
            this.materiaFurnace.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return this.materiaFurnace.isUseableByPlayer(player);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int clickedSlotNumber)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(clickedSlotNumber);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (clickedSlotNumber == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (clickedSlotNumber != 1 && clickedSlotNumber != 0)
            {
                if (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (TileEntityMateriaFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (clickedSlotNumber >= 3 && clickedSlotNumber < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (clickedSlotNumber >= 30 && clickedSlotNumber < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}