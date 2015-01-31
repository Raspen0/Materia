package nl.raspen0.Materia.tools;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import nl.raspen0.Materia.items.MateriaItems;

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
    return this.toolMaterial.toString();
}

@Override
public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
{
	return par2ItemStack.isItemEqual(new ItemStack(MateriaItems.MateriaIngot, 1, 0)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
}

}