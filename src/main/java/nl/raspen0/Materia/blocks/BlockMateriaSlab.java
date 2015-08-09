package nl.raspen0.Materia.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import nl.raspen0.Materia.CreativeTab;
import nl.raspen0.Materia.Strings;
import nl.raspen0.Materia.mainRegistry;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMateriaSlab extends BlockSlab {

	public static final String[] woodType = { "materiaBlockSlab" };

	public BlockMateriaSlab(boolean isDouble, Material mat) {
		super(isDouble, mat);
		useNeighborBrightness = true;
		setHardness(4.0F);
		setStepSound(Block.soundTypeMetal);
	}

	@SideOnly(Side.CLIENT)
	protected IIcon blockIcon;

	@SideOnly(Side.CLIENT)
	@Override
	public void registerBlockIcons(IIconRegister p_149651_1_)
	{
	blockIcon = p_149651_1_.registerIcon("Materia:blueMateriaBlock");
	}

	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return blockIcon;
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return Item.getItemFromBlock(MateriaBlocks.materiaBlockSlab);
	}

	public void onBlockPlacedBy(World par1World, int par2, int par3, int par4, EntityLiving par5EntityLiving) {
		if (par1World.getBlock(par2, par3 - 1, par4) == MateriaBlocks.materiaBlockSlab) {
			par1World.setBlock(par2, par3 - 1, par4, MateriaBlocks.materiaBlockDoubleSlab);
		}
		if (par1World.getBlock(par2, par3 + 1, par4) == MateriaBlocks.materiaBlockSlab) {
			par1World.setBlock(par2, par3 + 1, par4, MateriaBlocks.materiaBlockDoubleSlab);
		}
	}
	
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(MateriaBlocks.materiaBlockSlab, 2, par1 & 7);
	}

	public String getFullSlabName(int par1) {
		if ((par1 < 0) || (par1 >= woodType.length)) {
			par1 = 0;
		}

		return getUnlocalizedName() + "." + woodType[par1];
	}

	public void getSubBlocks(Block block, CreativeTabs par2CreativeTabs, List par3List) {
		if (block != MateriaBlocks.materiaBlockDoubleSlab) {
			par3List.add(new ItemStack(block, 1, 0));
		}
	}
	
	@Override
	public String func_150002_b(int par1) {
		return getFullSlabName(par1);
	}

	
}
