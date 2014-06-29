package com.gmail.rickvinke1.Materia.tile_entity;

import com.gmail.rickvinke1.Materia.lib.Strings;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityMateria {
	
	public static void mainRegistry(){
		registerTileEntities();
	}
	
	private static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityBlueMateriaChest.class, "BlueMateriaChest");
		GameRegistry.registerTileEntity(TileEntityMateriaFurnace.class, "MateriaFurnace");
	}

}
