package nl.raspen0.Materia.recipes;

import net.minecraft.item.ItemStack;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.items.MateriaItems;
import cpw.mods.fml.common.registry.GameRegistry;

public class FurnaceRecipes {
	
    public static void addSmeltingRecipes(){
        ItemStack BlueOre = new ItemStack(MateriaBlocks.materiaOre);
        ItemStack RedOre = new ItemStack(MateriaBlocks.materiaredOre);
        ItemStack RedIngot = new ItemStack(MateriaItems.MateriaIngot);
        ItemStack BlueIngot = new ItemStack(MateriaItems.MateriaIngot);
        ItemStack RedDust = new ItemStack(MateriaItems.Materiadust);
        ItemStack BlueDust = new ItemStack(MateriaItems.Materiadust);
        RedIngot.setItemDamage(1);
        RedDust.setItemDamage(1);
        BlueDust.setItemDamage(0);
        
        
    GameRegistry.addSmelting(BlueOre, BlueIngot, 0.1f);
    GameRegistry.addSmelting(RedOre, RedIngot, 0.3f);
    GameRegistry.addSmelting(RedDust, RedIngot, 0);
    GameRegistry.addSmelting(BlueDust, BlueIngot, 0);
    }

}
