package nl.raspen0.Materia.blocks;

import codechicken.nei.api.API;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import nl.raspen0.Materia.*;
import nl.raspen0.Materia.items.ItemMateriaSlab;
import nl.raspen0.Materia.items.MateriaItems;

public class MateriaBlocks {



    public static void mainRegistry(){
    	initBlocks();
    	registerBlocks();
    }
    public static BlueMateriaChest BlueChestBlock;
    public final static Block materiaOre = new MateriaOre(Material.rock);
    public final static Block materiaredOre = new MateriaredOre(Material.rock);
    public final static Block materiaBlock = new MateriaBlock(Material.iron);
    public final static Block bluemateriaBrick = new blueMateriaBrick(Material.rock);
    public final static Block materiaGrass = new MateriaGrass();
    //public final static Block Infuser = new MultiBlock(Material.iron);
    public static Block blockMateriaFurnaceIdle;
    public static Block blockMateriaFurnaceActive;
    public static Block blockCrusherIdle;
    public static Block blockCrusherActive;
    
    public static Block blockMixerIdle;
    public static Block blockMixerActive;
    
    public static Block materiaBlockSlab;
    public static Block materiaBlockDoubleSlab;
    

    
    
    public static void initBlocks(){
    	blockMateriaFurnaceIdle = new BlockMateriaFurnace(false).setBlockName("MateriaFurnaceIdle").setHardness(3.5F).setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
    	blockMateriaFurnaceActive = new BlockMateriaFurnace(true).setBlockName("MateriaFurnaceActive").setHardness(3.5F).setLightLevel(0.9F);
    	blockCrusherIdle = new BlockCrusher(false).setBlockName("CrusherIdle").setHardness(3.5F).setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
    	blockCrusherActive = new BlockCrusher(true).setBlockName("CrusherActive").setHardness(3.5F);
    	
    //	blockMixerIdle = new BlockMixer(false).setBlockName("MixerIdle").setHardness(3.5F).setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
    //	blockMixerActive = new BlockMixer(true).setBlockName("MixerActive").setHardness(3.5F);
    	
    	materiaBlockSlab = new BlockMateriaSlab(false, Material.iron).setBlockName("materiaSlab");
    	materiaBlockDoubleSlab = new BlockMateriaSlab(true, Material.iron).setBlockName("materiaSlabDouble");
    	
    	BlueChestBlock = new BlueMateriaChest(0);
    }
    
    public static void registerBlocks(){
    	
    	GameRegistry.registerBlock(BlueChestBlock, "BlueMateriaChest");
        
        
        
        
        GameRegistry.registerBlock(materiaOre, "materiaOre");
        GameRegistry.registerBlock(materiaBlock, "MateriaBlock");
        GameRegistry.registerBlock(bluemateriaBrick, "BlueMateriaBrick");
        GameRegistry.registerBlock(materiaredOre, "materiaredOre");
        GameRegistry.registerBlock(materiaGrass, "materiaGrass");
      //  GameRegistry.registerBlock(Infuser, "infuser");

        GameRegistry.registerBlock(blockMateriaFurnaceIdle, "Materia Furnace");
        GameRegistry.registerBlock(blockMateriaFurnaceActive, "Materia Furnace Active");
        
	    ItemStack MateriaActiveFurnace = new ItemStack(blockMateriaFurnaceActive);
        API.hideItem(MateriaActiveFurnace);
        
        GameRegistry.registerBlock(materiaBlockSlab, ItemMateriaSlab.class, "materiaSlab");
        GameRegistry.registerBlock(materiaBlockDoubleSlab, ItemMateriaSlab.class, "materiaDoubleSlab");
        
	    ItemStack materiaBlockDSlab = new ItemStack(materiaBlockDoubleSlab);
        API.hideItem(materiaBlockDSlab);
        
        if (mainRegistry.BlockCrusher){
        GameRegistry.registerBlock(blockCrusherIdle, "Crusher");
        GameRegistry.registerBlock(blockCrusherActive, "Crusher Active");
        } else {}
        
        
   //     GameRegistry.registerBlock(blockMixerIdle, "Mixer");
   //     GameRegistry.registerBlock(blockMixerActive, "Mixer Active");
    	
    }
}