package com.gmail.rickvinke1.Materia.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMateriaFurnace extends BlockContainer {
	
	private final boolean isActive;
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	public BlockMateriaFurnace(boolean isActive) {
		super(Material.iron);
		
		this.isActive = isActive;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Strings.MODID + ":" + "furnace_side");
		this.iconFront = iconRegister.registerIcon(Strings.MODID + ":" + (this.isActive ? "furnace_front_on" : "furnace_front_off.png"));
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon GetIcon(int side, int metadata){
		return  side == metadata ? this.iconFront : this.blockIcon;
	}
	
	public Item GetItemDropped(int par1, Random random, int par3){
		return Item.getItemFromBlock(MateriaBlocks.blockMateriaFurnaceIdle);
	}
	
	public void onBlockAdded(World world, int x, int y, int z){
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y,z);
	}
	
	private void setDefaultDirection(World world, int x, int y, int z){
		if(!world.isRemote){
			Block block1 = world.getBlock(x, y, z - 1);
			Block block2 = world.getBlock(x, y, z + 1);
			Block block3 = world.getBlock(x - 1, y, z);
			Block block4 = world.getBlock(x + 1, y, z);
			byte b0 = 3;
			
			if(block1.func_149730_j() && !block2.func_149730_j()){
				b0 = 3;
			}
			
			if(block2.func_149730_j() && !block1.func_149730_j()){
				b0 = 2;
			}
			
			if(block3.func_149730_j() && !block4.func_149730_j()){	
				b0 = 5;
				}
			
			if(block4.func_149730_j() && !block3.func_149730_j()){	
				b0 = 5;
				}
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityMateriaFurnace();
	}
}

