package com.gmail.rickvinke1.Materia.Tools;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

public class CustomShovel extends ItemSpade
{
public CustomShovel(ToolMaterial material)
{
super(material);
}
protected Item.ToolMaterial BlueMateria;


public Item.ToolMaterial func_150913_i()
{
    return this.BlueMateria;
}

@Override
public String getToolMaterialName()
{
    return this.BlueMateria.toString();
}

@Override
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
{
    return MateriaItems.MateriaIngot  == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
}

}