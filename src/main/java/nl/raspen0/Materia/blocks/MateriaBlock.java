package nl.raspen0.Materia.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MateriaBlock extends Block 
{

        public MateriaBlock (Material material) 
        {
                super(material);
                
                setHardness(4.0F); // 33% harder than diamond
                setStepSound(Block.soundTypeMetal);
                setBlockName("materiaBlock");
                setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
                setBlockTextureName("Materia:blueMateriaBlock");
        }
        @Override
        public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ)
        {
            return true;
        }
    	
}
