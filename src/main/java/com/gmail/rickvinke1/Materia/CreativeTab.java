package com.gmail.rickvinke1.Materia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

public class CreativeTab {
	
    public static CreativeTabs tabMateria = new CreativeTabs("Materia"){
    	public Item getTabIconItem(){
    		return MateriaItems.MateriaIngot;
    	}
    	
    };

}
