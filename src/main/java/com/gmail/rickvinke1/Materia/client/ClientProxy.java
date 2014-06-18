package com.gmail.rickvinke1.Materia.client;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;


import com.gmail.rickvinke1.Materia.render.item.ItemRendererBlueMateriaChest;
import com.gmail.rickvinke1.Materia.server.ServerProxy;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityBlueMateriaChest;
import com.rickvinke1.Materia.render.BlueMateriaRenderer;

import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends ServerProxy{

	public void registerRenderThings(){

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueMateriaChest.class, new BlueMateriaRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MateriaBlocks.BlueMateriaChest), new ItemRendererBlueMateriaChest());
	}

}