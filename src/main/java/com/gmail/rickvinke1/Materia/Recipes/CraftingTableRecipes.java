package com.gmail.rickvinke1.Materia.Recipes;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class CraftingTableRecipes {
	


	public static void addCraftingRecipes(){
		
	    ItemStack materiaStack = new ItemStack(MateriaItems.MateriaIngot);
	    ItemStack RedmateriaStack = new ItemStack(MateriaItems.MateriaIngot);
	    RedmateriaStack.setItemDamage(1);
	    ItemStack materiablockStack = new ItemStack(MateriaBlocks.materiaBlock);
	    ItemStack diamondstack = new ItemStack(Items.diamond);
	    ItemStack stickstack = new ItemStack(Items.stick);
	    ItemStack brickstack = new ItemStack(Blocks.stonebrick);
	    ItemStack furnace = new ItemStack(Blocks.furnace);
	    

    GameRegistry.addRecipe(new ItemStack(MateriaBlocks.materiaBlock), "xxx", "xxx", "xxx", 
            'x', materiaStack);
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaCrystal), " x ", "xyx", " x ", 
            'x', materiaStack, 'y', diamondstack);
    GameRegistry.addRecipe(new ItemStack(MateriaBlocks.bluemateriaBrick, 8), "xxx", "xyx", "xxx", 
            'x', brickstack, 'y', materiaStack);
    GameRegistry.addRecipe(new ItemStack(MateriaBlocks.blockMateriaFurnaceIdle), "xxx", "xyx", "xxx", 
            'x', materiaStack, 'y', furnace);
    
    //tools
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaPickaxe), "xxx", " y ", " y ", 
            'x', materiaStack, 'y', stickstack);
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaSword), " x ", " x ", " y ", 
            'x', materiaStack, 'y', stickstack);
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaAxe), "xx ", "xy ", " y ", 
            'x', materiaStack, 'y', stickstack);
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaShovel), " x ", " y ", " y ", 
            'x', materiaStack, 'y', stickstack);
    GameRegistry.addRecipe(new ItemStack(MateriaItems.MateriaHoe), "xx ", " y ", " y ", 
            'x', materiaStack, 'y', stickstack);
    GameRegistry.addShapelessRecipe(new ItemStack(MateriaItems.MateriaIngot, 9), new ItemStack(MateriaBlocks.materiaBlock));
	}

}
