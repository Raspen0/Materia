package com.gmail.rickvinke1.Materia.Tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;

public class CustomSword extends ItemSword
{
public CustomSword(ToolMaterial material)
{
super(material);
}
protected Item.ToolMaterial toolMaterial;


public Item.ToolMaterial func_150913_i()
{
    return this.toolMaterial;
}


public String getToolMaterialName()
{
    return this.toolMaterial.toString();
}


public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
{
    return this.toolMaterial.func_150995_f() == par2ItemStack.getItem() ? true : super.getIsRepairable(par1ItemStack, par2ItemStack);
}

}