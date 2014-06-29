package com.gmail.rickvinke1.Materia.Blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.gmail.rickvinke1.Materia.mainRegistry;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMateriaFurnace extends BlockContainer {
    private IIcon field_149935_N;
	private final boolean isActive;
	@SideOnly(Side.CLIENT)
	private IIcon iconFront;
	
	public BlockMateriaFurnace(boolean isActive) {
		super(Material.iron);
		
		this.isActive = isActive;
	}
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Strings.MODID + ":" + "materia_furnace_side");
		this.iconFront = iconRegister.registerIcon(Strings.MODID + ":" + (this.isActive ? "materia_furnace_front_on" : "materia_furnace_front_off"));
        this.field_149935_N = iconRegister.registerIcon(Strings.MODID + ":" + "materia_furnace_top");
	}
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata){
        return side == 1 ? this.field_149935_N : (side == 0 ? this.field_149935_N : (side != metadata ? this.blockIcon : this.iconFront));
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
	
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ){
		if(world.isRemote){
			FMLNetworkHandler.openGui(player, mainRegistry.instance, mainRegistry.guiIdMateriaFurnace, world, x, y, z);
		}
		
		return true;
	}
	
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityMateriaFurnace();
	}
	
	 public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_){
		int l = MathHelper.floor_double((double)(p_149689_5_.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		
		if(l == 0){
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 2, 2);
		}
		if(l == 1){
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 5, 2);
		}
		if(l == 2){
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 3, 2);
		}
		if(l == 3){
			p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, 4, 2);
		}
		
		if(p_149689_6_.hasDisplayName()){
			 ((TileEntityMateriaFurnace)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).setGuiDisplayName(p_149689_6_.getDisplayName());
		}
	}
}

