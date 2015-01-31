package nl.raspen0.Materia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import nl.raspen0.Materia.CreativeTab;
import nl.raspen0.Materia.Strings;
import nl.raspen0.Materia.mainRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMateriaSlab extends BlockSlab {
	
	private Block extendingBlock;

	public BlockMateriaSlab(boolean fullBlock, Block block, Material material) {
		super(fullBlock, material);
		
		if(!fullBlock){
			this.setCreativeTab(CreativeTab.tabMateria);
	            this.opaque = true;
	        }
	        else
	        {
	            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
	        }
	}
	
	public String func_150002_b(int i) {
		return super.getUnlocalizedName();
	}
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int i, int j)
    {
        return MateriaBlocks.materiaBlock.getIcon(i, j & 7);
    }
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register){
	}

	protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(MateriaBlocks.materiaBlockHalfSlab), 2, p_149644_1_ & 7);
    }

}
