package nl.raspen0.Materia.client;

import net.minecraft.client.model.ModelPig;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.mobs.MateriaPig;
import nl.raspen0.Materia.mobs.MateriaPigRenderer;
import nl.raspen0.Materia.render.BlueMateriaChestRenderer;
import nl.raspen0.Materia.render.item.ItemRendererBlueMateriaChest;
import nl.raspen0.Materia.server.ServerProxy;
import nl.raspen0.Materia.tile_entity.TileEntityBlueMateriaChest;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy{

	public void registerRenderThings(){

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlueMateriaChest.class, new BlueMateriaChestRenderer());
		MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(MateriaBlocks.BlueChestBlock), new ItemRendererBlueMateriaChest());
		
		RenderingRegistry.registerEntityRenderingHandler(MateriaPig.class, new MateriaPigRenderer(new ModelPig(), 0.5F));
	}
	

}