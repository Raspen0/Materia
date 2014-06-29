package com.gmail.rickvinke1.Materia.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.gmail.rickvinke1.Materia.mainRegistry;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	

	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case mainRegistry.guiIdMateriaFurnace:
				if(entity instanceof TileEntityMateriaFurnace){
					return new ContainerMateriaFurnace(player.inventory, (TileEntityMateriaFurnace) entity);
				}
			}
		}
		
		return null;
	}

	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
			case mainRegistry.guiIdMateriaFurnace:
				if(entity instanceof TileEntityMateriaFurnace){
					return new GuiMateriaFurnace(player.inventory, (TileEntityMateriaFurnace) entity);
				}
			}
		}
		
		return null;
	}
	
}
