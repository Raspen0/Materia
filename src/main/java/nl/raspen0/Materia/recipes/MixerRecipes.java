package nl.raspen0.Materia.recipes;

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

public class MixerRecipes
{
    private static final MixerRecipes smeltingBase = new MixerRecipes();
    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private static final String __OBFID = "CL_00000085";

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static MixerRecipes smelting()
    {
        return smeltingBase;
    }

    private MixerRecipes()
    {
        this.addRecipe(Blocks.iron_ore, new ItemStack(Items.iron_ingot), 0.7F);
        this.addRecipe(Blocks.gold_ore, new ItemStack(Items.gold_ingot), 1.0F);
        this.addRecipe(Blocks.diamond_ore, new ItemStack(Items.diamond), 1.0F);
        this.addRecipe(Blocks.sand, new ItemStack(Blocks.glass), 0.1F);
        this.addRecipe(Items.porkchop, new ItemStack(Items.cooked_porkchop), 0.35F);
        this.addRecipe(Items.beef, new ItemStack(Items.cooked_beef), 0.35F);
        this.addRecipe(Items.chicken, new ItemStack(Items.cooked_chicken), 0.35F);
        this.addRecipe(Blocks.cobblestone, new ItemStack(Blocks.stone), 0.1F);
        this.addRecipe(Items.clay_ball, new ItemStack(Items.brick), 0.3F);
        this.addRecipe(Blocks.clay, new ItemStack(Blocks.hardened_clay), 0.35F);
        this.addRecipe(Blocks.cactus, new ItemStack(Items.dye, 1, 2), 0.2F);
        this.addRecipe(Blocks.log, new ItemStack(Items.coal, 1, 1), 0.15F);
        this.addRecipe(Blocks.log2, new ItemStack(Items.coal, 1, 1), 0.15F);
        this.addRecipe(Blocks.emerald_ore, new ItemStack(Items.emerald), 1.0F);
        this.addRecipe(Items.potato, new ItemStack(Items.baked_potato), 0.35F);
        this.addRecipe(Blocks.netherrack, new ItemStack(Items.netherbrick), 0.1F);
        ItemFishFood.FishType[] afishtype = ItemFishFood.FishType.values();
        int i = afishtype.length;

        for (int j = 0; j < i; ++j)
        {
            ItemFishFood.FishType fishtype = afishtype[j];

            if (fishtype.func_150973_i())
            {
                this.addRecipe(new ItemStack(Items.fish, 1, fishtype.func_150976_a()), new ItemStack(Items.cooked_fished, 1, fishtype.func_150976_a()), 0.35F);
            }
        }

        this.addRecipe(Blocks.coal_ore, new ItemStack(Items.coal), 0.1F);
        this.addRecipe(Blocks.redstone_ore, new ItemStack(Items.redstone), 0.7F);
        this.addRecipe(Blocks.lapis_ore, new ItemStack(Items.dye, 1, 4), 0.2F);
        this.addRecipe(Blocks.quartz_ore, new ItemStack(Items.quartz), 0.2F);
    }

    public void addRecipe(Block block, ItemStack stack, float f1)
    {
        this.addRecipe(Item.getItemFromBlock(block), stack, f1);
    }

    public void addRecipe(Item item, ItemStack itemstack, float f1)
    {
        this.addRecipe(new ItemStack(item, 1, 32767), itemstack, f1);
    }

    public void addRecipe(ItemStack stack, ItemStack stack2, float f1)
    {
        this.smeltingList.put(stack, stack2);
        this.experienceList.put(stack2, Float.valueOf(f1));
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(ItemStack stack)
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
        while (!this.func_151397_a(stack, (ItemStack)entry.getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean func_151397_a(ItemStack stack, ItemStack stack2)
    {
        return stack2.getItem() == stack.getItem() && (stack2.getItemDamage() == 32767 || stack2.getItemDamage() == stack.getItemDamage());
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float func_151398_b(ItemStack p_151398_1_)
    {
        float ret = p_151398_1_.getItem().getSmeltingExperience(p_151398_1_);
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
        while (!this.func_151397_a(p_151398_1_, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}