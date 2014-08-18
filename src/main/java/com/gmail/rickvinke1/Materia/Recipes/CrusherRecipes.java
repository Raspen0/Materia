package com.gmail.rickvinke1.Materia.Recipes;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;

public class CrusherRecipes
{
    private static final CrusherRecipes smeltingBase = new CrusherRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CrusherRecipes crushing()
    {
        return smeltingBase;
    }

    private CrusherRecipes()
    {
        ItemStack RedDust = new ItemStack(MateriaItems.Materiadust);
        RedDust.setItemDamage(1);
        this.CrusherBlockRecipe(Blocks.iron_ore, new ItemStack(Items.iron_ingot, 2), 0.4F);
        this.CrusherBlockRecipe(MateriaBlocks.materiaOre, new ItemStack(MateriaItems.Materiadust, 2), 0.7F);
        this.CrusherBlockRecipe(MateriaBlocks.materiaredOre, new ItemStack(MateriaItems.Materiadust, 2, 1), 0.7F);

    }

    public void CrusherBlockRecipe(Block block, ItemStack itemstack, float f1)
    {
        this.CrusherItemRecipe(Item.getItemFromBlock(block), itemstack, f1);
    }

    public void CrusherItemRecipe(Item item, ItemStack itemstack, float f2)
    {
        this.func_151394_a(new ItemStack(item, 1, 32767), itemstack, f2);
    }

    public void func_151394_a(ItemStack p_151394_1_, ItemStack p_151394_2_, float p_151394_3_)
    {
        this.smeltingList.put(p_151394_1_, p_151394_2_);
        this.experienceList.put(p_151394_2_, Float.valueOf(p_151394_3_));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getCrushingResult(ItemStack itemstack)
    {
        Iterator iterator = this.smeltingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(itemstack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack p_151397_1_, ItemStack p_151397_2_)
    {
        return p_151397_2_.getItem() == p_151397_1_.getItem() && (p_151397_2_.getItemDamage() == 32767 || p_151397_2_.getItemDamage() == p_151397_1_.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float experience(ItemStack itemstack)
    {
        float ret = itemstack.getItem().getSmeltingExperience(itemstack);
        if (ret != -1) return ret;

        Iterator iterator = this.experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!this.func_151397_a(itemstack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}