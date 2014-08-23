package com.gmail.rickvinke1.Materia.Items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;

import com.gmail.rickvinke1.Materia.lib.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class MateriaIngot extends Item {

	public MateriaIngot() {
		this.setHasSubtypes(true);
        setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);
        setUnlocalizedName("materiaIngot");
}
	public static final String[] names = new String[] { "Blue", "Red" };
	 
    @Override
    public String getUnlocalizedName(ItemStack par1ItemStack)
    {
        int i = MathHelper.clamp_int(par1ItemStack.getItemDamage(), 0, 15);
        return super.getUnlocalizedName() + "." + names[i];
    }
	
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;
	      
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
	       icons = new IIcon[2];
	            
	       for(int i = 0; i < icons.length; i++)
	       {
	        icons[i] = par1IconRegister.registerIcon(Strings.MODID + ":" + (this.getUnlocalizedName().substring(5)) + i);
	       }
	}
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1)
	{
	       return icons[par1];
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
	    for (int x = 0; x < 2; x++)
	    {
	        par3List.add(new ItemStack(this, 1, x));
	    }
	}
	
	
    public boolean hasEffect(ItemStack itemstack)
    {
        if (itemstack.getItemDamage() == 1)
        {
            return true; 	
        }

    else
    {
		return false;
    }
    }
	
}