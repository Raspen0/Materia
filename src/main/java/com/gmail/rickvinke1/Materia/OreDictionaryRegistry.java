package com.gmail.rickvinke1.Materia;

import net.minecraft.item.ItemStack;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryRegistry {
	
	
	
    public static void mainRegistry(){
    	OreDictBlocks();
    	OreDictItems();
    }
	
	
	public static void OreDictBlocks(){
    OreDictionary.registerOre("oreBlueMateria", MateriaBlocks.materiaOre);
    OreDictionary.registerOre("oreRedMateria", MateriaBlocks.materiaredOre);
    OreDictionary.registerOre("blockBlueMateria", MateriaBlocks.materiaBlock);
	}
	
	public static void OreDictItems(){
		//ItemStacks
	    ItemStack BlueIngot = new ItemStack(MateriaItems.MateriaIngot);
	    ItemStack RedIngot = new ItemStack(MateriaItems.MateriaIngot);
	    ItemStack BlueDust = new ItemStack(MateriaItems.Materiadust);
	    ItemStack RedDust = new ItemStack(MateriaItems.Materiadust);
	    RedIngot.setItemDamage(1);
	    RedDust.setItemDamage(1);
	    
	    OreDictionary.registerOre("ingotBlueMateria", BlueIngot);
	    OreDictionary.registerOre("ingotRedMateria", RedIngot);
	    OreDictionary.registerOre("dustBlueMateria", BlueDust);
	    OreDictionary.registerOre("dustRedMateria", RedDust);
	}
}
