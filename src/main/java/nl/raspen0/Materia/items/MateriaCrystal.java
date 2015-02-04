package nl.raspen0.Materia.items;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MateriaCrystal extends Item {

	public MateriaCrystal() {
        setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
        setUnlocalizedName("materiaCrystal");
}
	
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
    
    public boolean hasEffect(ItemStack par1ItemStack, int pass)
    {
        return true;
    }
}
