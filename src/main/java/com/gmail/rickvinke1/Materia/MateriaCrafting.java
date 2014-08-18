package com.gmail.rickvinke1.Materia;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;
import com.gmail.rickvinke1.Materia.generation.MateriaWorldGenerator;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class MateriaCrafting {
	
	public static void MainClass(){
		addCraftingRecipes();
		addSmeltingRecipes();
	}
		
		public static void addCraftingRecipes(){
        
        //Recipes
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
        public static void addSmeltingRecipes(){
            ItemStack BlueOrestack = new ItemStack(MateriaBlocks.materiaOre);
            ItemStack RedOrestack = new ItemStack(MateriaBlocks.materiaredOre);
            ItemStack RedmateriaStack = new ItemStack(MateriaItems.MateriaIngot);
            ItemStack BluemateriaStack = new ItemStack(MateriaItems.MateriaIngot);
            RedmateriaStack.setItemDamage(1);
        GameRegistry.addSmelting(BlueOrestack, BluemateriaStack, 0.1f);
        GameRegistry.addSmelting(RedOrestack, RedmateriaStack, 0.3f);
        GameRegistry.addSmelting(MateriaItems.Materiadust, BluemateriaStack, 0);
    }

}
