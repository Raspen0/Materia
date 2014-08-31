package com.gmail.rickvinke1.Materia.Blocks;

import com.gmail.rickvinke1.Materia.Items.MateriaItems;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;

import com.gmail.rickvinke1.Materia.*;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;

public class MateriaBlocks {



    public static void mainRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    public static Block BlueMateriaChest = new BlueMateriaChest(0).setBlockName("BlueMateriaChest").setBlockTextureName("Materia:BlueMateriaChest.png").setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);
    public final static Block materiaOre = new MateriaOre(Material.rock);
    public final static Block materiaredOre = new MateriaredOre(Material.rock);
    public final static Block materiaBlock = new MateriaBlock(Material.iron);
    public final static Block bluemateriaBrick = new blueMateriaBrick(Material.rock);
    public static Block blockMateriaFurnaceIdle;
    public static Block blockMateriaFurnaceActive;
    public static Block blockCrusherIdle;
    public static Block blockCrusherActive;
    public static Block materiaBlockHalfSlab;
    public static Block materiaBlockDoubleSlab;
    
    public static void initBlocks(){
        if (mainRegistry.BlockMateriaFurnace){
    	blockMateriaFurnaceIdle = new BlockMateriaFurnace(false).setBlockName("MateriaFurnaceIdle").setHardness(3.5F).setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);
    	blockMateriaFurnaceActive = new BlockMateriaFurnace(true).setBlockName("MateriaFurnaceActive").setHardness(3.5F).setLightLevel(0.9F);
        } else {}
    	blockCrusherIdle = new BlockCrusher(false).setBlockName("CrusherIdle").setHardness(3.5F).setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);
    	blockCrusherActive = new BlockCrusher(true).setBlockName("CrusherActive").setHardness(3.5F);
    	
    	materiaBlockHalfSlab = new BlockMateriaSlab(false, materiaBlock, Material.iron).setBlockName("slabMateriaBlock");
    	materiaBlockDoubleSlab = new BlockMateriaSlab(true, materiaBlock, Material.iron).setBlockName("doubleslabMateriaBlock");

    }
    
    public static void registerBlocks(){
        if (mainRegistry.BlockBlueMateriaChest){
    	GameRegistry.registerBlock(BlueMateriaChest, "BlueMateriaChest");
        } else {}
        
        
        
        
        GameRegistry.registerBlock(materiaOre, "materiaOre");
        GameRegistry.registerBlock(materiaBlock, "MateriaBlock");
        GameRegistry.registerBlock(bluemateriaBrick, "BlueMateriaBrick");
        GameRegistry.registerBlock(materiaredOre, "materiaredOre");

        GameRegistry.registerBlock(blockMateriaFurnaceIdle, "Materia Furnace");
        GameRegistry.registerBlock(blockMateriaFurnaceActive, "Materia Furnace Active");
        
        GameRegistry.registerBlock(blockCrusherIdle, "Crusher");
        GameRegistry.registerBlock(blockCrusherActive, "Crusher Active");
        
        GameRegistry.registerBlock(materiaBlockHalfSlab, "Materia Slab");
        GameRegistry.registerBlock(materiaBlockDoubleSlab, "Materia DoubleSlab");

    	
    }
}