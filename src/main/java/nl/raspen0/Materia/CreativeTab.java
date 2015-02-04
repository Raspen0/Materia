package nl.raspen0.Materia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import nl.raspen0.Materia.items.ItemRegistry;

public class CreativeTab {
	
    public static CreativeTabs tabMateria = new CreativeTabs("Materia"){
    	public Item getTabIconItem(){
    		return ItemRegistry.MateriaCrystal;
    	}
    	
    };

}