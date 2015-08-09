package nl.raspen0.Materia.tile_entity;

import nl.raspen0.Materia.Strings;
import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityMateria {
	
	public static void mainRegistry(){
		registerTileEntities();
	}
	
	private static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityBlueMateriaChest.class, "BlueMateriaChest");
		GameRegistry.registerTileEntity(TileEntityMateriaFurnace.class, "MateriaFurnace");
		GameRegistry.registerTileEntity(TileEntityCrusher.class, "Crusher");
		//GameRegistry.registerTileEntity(TileEntityInfuser.class, "Infuser");
		//GameRegistry.registerTileEntity(TileEntityMixer.class, "Mixer");
	}

}
