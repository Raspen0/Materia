package com.gmail.rickvinke1.Materia.render.item;

import com.gmail.rickvinke1.Materia.tile_entity.TileEntityBlueMateriaChest;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class ItemRendererBlueMateriaChest implements IItemRenderer {
	
	private ModelChest chestModel;

	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return true;
	}

	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		TileEntityRendererDispatcher.instance.renderTileEntityAt(new TileEntityBlueMateriaChest(), 0.0D, 0.0D, 0.0D, 0.0F);
		

	}

	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		
		return true;
	}

}