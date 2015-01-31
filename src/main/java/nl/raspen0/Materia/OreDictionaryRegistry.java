package nl.raspen0.Materia;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.items.MateriaItems;

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
