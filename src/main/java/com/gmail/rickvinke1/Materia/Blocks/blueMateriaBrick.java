package com.gmail.rickvinke1.Materia.Blocks;

import java.util.Random;


import net.minecraft.block.Block;
import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.block.material.Material;

public class blueMateriaBrick extends Block
{
         public blueMateriaBrick(Material material) 
     {
             super(material);
                
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundTypeStone);
                setBlockName("blueMateriaBricks");
                setCreativeTab(com.gmail.rickvinke1.Materia.CreativeTab.tabMateria);
                setBlockTextureName("Materia:blueMateriaBricks");
                this.setLightLevel(0.5F);
                setHarvestLevel("pickaxe",2);
        }

        
        
        
}