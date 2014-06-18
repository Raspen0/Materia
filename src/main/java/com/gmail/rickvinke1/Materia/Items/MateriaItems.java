package com.gmail.rickvinke1.Materia.Items;

import com.gmail.rickvinke1.Materia.Tools.CustomAxe;
import com.gmail.rickvinke1.Materia.Tools.CustomShovel;
import com.gmail.rickvinke1.Materia.Tools.CustomSword;
import com.gmail.rickvinke1.Materia.Tools.CustomPickaxe;
import com.gmail.rickvinke1.Materia.Items.MateriaIngot;
import com.gmail.rickvinke1.Materia.Tools.CustomHoe;
import com.gmail.rickvinke1.Materia.Tools.CustomSword;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class MateriaItems {



    public static void mainRegistry(){
    	initItems();
    	registerBlocks();
    }
    public static ToolMaterial BlueMateria = net.minecraftforge.common.util.EnumHelper.addToolMaterial("REDSTONE", 2, 512, 7.0F, 2.0F, 17);
    
    public static Item MateriaIngot;
	
	public static Item MateriaCrystal;
	
   //tools
	public static Item MateriaPickaxe;
	public static Item MateriaSword;
	public static Item MateriaShovel;
	public static Item MateriaHoe;
	public static Item MateriaAxe;
	public static Item Materiadust;
	
    
    public static void initItems(){
        MateriaIngot = new com.gmail.rickvinke1.Materia.Items.MateriaIngot();
        MateriaCrystal = new com.gmail.rickvinke1.Materia.Items.MateriaCrystal();
        Materiadust = new com.gmail.rickvinke1.Materia.Items.MateriaDust();
        MateriaPickaxe = new CustomPickaxe(BlueMateria).setUnlocalizedName("MateriaPickaxe").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria).setTextureName("Materia:blueMateriaPickaxe");
        MateriaSword = new CustomSword(BlueMateria).setUnlocalizedName("MateriaSword").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria).setTextureName("Materia:blueMateriaSword");
        MateriaShovel = new CustomShovel(BlueMateria).setUnlocalizedName("MateriaShovel").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria).setTextureName("Materia:blueMateriaShovel");
        MateriaHoe = new CustomHoe(BlueMateria).setUnlocalizedName("MateriaHoe").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria).setTextureName("Materia:blueMateriaHoe");
        MateriaAxe = new CustomSword(BlueMateria).setUnlocalizedName("MateriaAxe").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria).setTextureName("Materia:blueMateriaAxe");   
    }
    
    public static void registerBlocks(){
    	

        GameRegistry.registerItem(MateriaIngot, "MateriaIngot");

        GameRegistry.registerItem(MateriaCrystal, "MateriaCrystal");

        GameRegistry.registerItem(Materiadust, "MateriaDust");
       
    	GameRegistry.registerItem(MateriaPickaxe, "MateriaPickaxe");
      
    	GameRegistry.registerItem(MateriaSword, "MateriaSword");

    	GameRegistry.registerItem(MateriaShovel, "MateriaShovel");

    	GameRegistry.registerItem(MateriaAxe, "MateriaAxe");

    	GameRegistry.registerItem(MateriaHoe, "MateriaHoe");
    	
    }
}