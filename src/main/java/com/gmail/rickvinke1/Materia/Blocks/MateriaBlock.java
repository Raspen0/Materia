package com.gmail.rickvinke1.Materia.Blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class MateriaBlock extends Block 
{

        public MateriaBlock (Material material) 
        {
                super(material);
                
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundTypeMetal);
                setBlockName("materiaBlock");
                setCreativeTab(com.gmail.rickvinke1.Materia.mainRegistry.tabMateria);
                setBlockTextureName("Materia:blueMateriaBlock");
        }

}