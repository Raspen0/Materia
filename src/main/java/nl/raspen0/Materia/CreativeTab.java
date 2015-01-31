package nl.raspen0.Materia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.raspen0.Materia.items.MateriaItems;

public class CreativeTab {
	
    public static CreativeTabs tabMateria = new CreativeTabs("Materia"){
    	public Item getTabIconItem(){
    		return MateriaItems.MateriaIngot;
    	}
    	
    };

}
