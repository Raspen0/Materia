package nl.raspen0.Materia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import nl.raspen0.Materia.Strings;

public class BlockRegistry {
	
	
    public static void mainRegistry(){
    	initBlocks();
    	registerBlocks();
    	renderBlocks();    	
    }
    
    public final static Block materiaOre = new MateriaOre(Material.rock);
    public final static Block materiaBlock = new MateriaBlock(Material.iron);
    
    
    public static void initBlocks(){
    }
    
    public static void registerBlocks(){
    	GameRegistry.registerBlock(materiaOre, "materiaOre");
    	GameRegistry.registerBlock(materiaBlock, "materiaBlock");
    }
    
    public static void renderBlocks(){
    	Item materiaOreItem = GameRegistry.findItem(Strings.MODID, "materiaOre");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(materiaOreItem, 0, new ModelResourceLocation("Materia:materiaOre", "inventory"));
    	
    	Item materiaBlockItem = GameRegistry.findItem(Strings.MODID, "materiaBlock");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(materiaBlockItem, 0, new ModelResourceLocation("Materia:materiaBlock", "inventory"));
    }
}
