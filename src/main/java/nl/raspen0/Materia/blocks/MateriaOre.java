package nl.raspen0.Materia.blocks;

import java.util.Random;



import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;

public class MateriaOre extends Block
{
         public MateriaOre(Material material) 
     {
             super(material);
                
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundTypeStone);
                setBlockName("materiaOre");
                setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
                setBlockTextureName("Materia:blueMateriaOre");
                this.setLightLevel(0.1F);
                setHarvestLevel("pickaxe",2);
        }

        
        
        
}