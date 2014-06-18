package com.gmail.rickvinke1.Materia.Blocks;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

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

public class MateriaBlocks {



    public static void mainRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    
    public static Block BlueMateriaChest = new BlueMateriaChest(0).setBlockName("BlueMateriaChest").setBlockTextureName("Materia:BlueMateriaChest.png").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);;
    public final static Block materiaOre = new MateriaOre(Material.rock);
    public final static Block materiaredOre = new MateriaredOre(Material.rock);
    public final static Block materiaBlock = new MateriaBlock(Material.iron);
    public final static Block bluemateriaBrick = new blueMateriaBrick(Material.rock);
    
    public static void initBlocks(){

    }
    
    public static void registerBlocks(){
    	
    	GameRegistry.registerBlock(BlueMateriaChest, "BlueMateriaChest");
        GameRegistry.registerBlock(materiaOre, "MateriaOre");
        GameRegistry.registerBlock(materiaBlock, "MateriaBlock");
        GameRegistry.registerBlock(bluemateriaBrick, "BlueMateriaBrick");
        GameRegistry.registerBlock(materiaredOre, "materiaredOre");
    	
    }
}