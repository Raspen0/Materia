package nl.raspen0.Materia.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class MateriaBlock extends Block 
{

        public MateriaBlock (Material material) 
        {
                super(material);
                
                setHardness(4.0F);
                setStepSound(Block.soundTypeMetal);
                setUnlocalizedName("materiaBlock");
                setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
        }
        @Override
        public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
        {
            return true;
        }
    	
}