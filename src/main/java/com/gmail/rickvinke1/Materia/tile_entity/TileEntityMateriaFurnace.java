package com.gmail.rickvinke1.Materia.tile_entity;

import net.minecraft.tileentity.TileEntity;

public class TileEntityMateriaFurnace extends TileEntity {

	private String localizedName;
	
	public void setGuiDisplayName(String displayName) {
		this.localizedName = displayName;
	}

}
