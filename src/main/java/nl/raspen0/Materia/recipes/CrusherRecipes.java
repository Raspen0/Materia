package nl.raspen0.Materia.recipes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFishFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.items.MateriaItems;

public class CrusherRecipes
{
    private static final CrusherRecipes instance = new CrusherRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";
    private final HashMap<String, ItemStack[]> inputList = new HashMap<String, ItemStack[]>();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static CrusherRecipes crushing()
    {
        return instance;
    }

    private CrusherRecipes()
    {
        ItemStack RedDust = new ItemStack(MateriaItems.Materiadust);
        RedDust.setItemDamage(1);
        addRecipe(Blocks.iron_ore, new ItemStack(Items.iron_ingot, 2), 0.4F);
        addRecipe(MateriaBlocks.materiaOre, new ItemStack(MateriaItems.Materiadust, 2), 0.7F);
        addRecipe(MateriaBlocks.materiaredOre, new ItemStack(MateriaItems.Materiadust, 2, 1), 0.7F);

    }

    public void addRecipe(Block block, ItemStack itemStack, float f1)
    {
       this.addRecipe(Item.getItemFromBlock(block), itemStack, f1);
    }

    public void addRecipe(Item item, ItemStack result, float f2)
    {
        this.func_151394_a(new ItemStack(item, 1, 32767), result, f2);
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
        while (!this.areItemStacksEqual(itemstack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean areItemStacksEqual(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack1.getItemDamage());
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
        while (!this.areItemStacksEqual(itemstack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
    
    public HashMap<ItemStack, ItemStack> getInput(ItemStack itemStack)
    {

        if (itemStack == null) { return null; }

        HashMap<ItemStack, ItemStack> result = new HashMap<ItemStack, ItemStack>();

        ItemStack[] inputList = this.inputList.get(itemStack.getUnlocalizedName());

        if (inputList == null) { return null; }

        for (int i = 0; i < inputList.length; i++)
        {
            result.put(inputList[i], this.getCrushingResult(inputList[i]));
        }

        return result;
    }
}