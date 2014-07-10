//Renders the Inventory Icon of the chest
package com.gmail.rickvinke1.Materia.render.item;

import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import com.gmail.rickvinke1.Materia.tile_entity.TileEntityBlueMateriaChest;

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