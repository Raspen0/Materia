package com.gmail.rickvinke1.Materia.Tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

public class CustomSword extends ItemSword
{
    private final Item.ToolMaterial field_150933_b;
public CustomSword(ToolMaterial material){
super(material);
this.field_150933_b = material;
}
protected Item.ToolMaterial BlueMateria;


public Item.ToolMaterial func_150913_i()
{
    return this.BlueMateria;
}

@Override
public String getToolMaterialName()
{
    return this.field_150933_b.toString();
}

@Override
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
{
	return par2ItemStack.isItemEqual(new ItemStack(MateriaItems.MateriaIngot, 1, 0)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
}

}