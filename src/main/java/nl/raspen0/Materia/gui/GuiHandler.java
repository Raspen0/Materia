package nl.raspen0.Materia.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import nl.raspen0.Materia.mainRegistry;
import nl.raspen0.Materia.container.ContainerBlueMateriaChest;
import nl.raspen0.Materia.container.ContainerCrusher;
import nl.raspen0.Materia.container.ContainerMateriaFurnace;
import nl.raspen0.Materia.tile_entity.TileEntityBlueMateriaChest;
import nl.raspen0.Materia.tile_entity.TileEntityCrusher;
import nl.raspen0.Materia.tile_entity.TileEntityMateriaFurnace;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class GuiHandler implements IGuiHandler {
	
    public GuiHandler(){
        NetworkRegistry.INSTANCE.registerGuiHandler(mainRegistry.instance, this);
        
    }
	
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
				case mainRegistry.guiIdMateriaFurnace:
					if(entity instanceof TileEntityMateriaFurnace){
						return new ContainerMateriaFurnace(player.inventory, (TileEntityMateriaFurnace) entity);
				}
				case mainRegistry.guiIdBlueMateriaChest:
					if(entity instanceof TileEntityBlueMateriaChest){
						return new ContainerBlueMateriaChest(player.inventory, (TileEntityBlueMateriaChest) entity);
					}
			case mainRegistry.guiIdCrusher:
				if(entity instanceof TileEntityCrusher){
					return new ContainerCrusher(player.inventory, (TileEntityCrusher) entity);
			}
	//		case mainRegistry.guiIdMixer:
	//			if(entity instanceof TileEntityMixer){
	//				return new ContainerMixer(player.inventory, (TileEntityMixer) entity);
	//		}
		}
		}
		return null;
	}
	
	@SideOnly(Side.CLIENT)
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		
		if(entity != null){
			switch(ID){
				case mainRegistry.guiIdMateriaFurnace:
					if(entity instanceof TileEntityMateriaFurnace){
						return new GuiMateriaFurnace(player.inventory, (TileEntityMateriaFurnace) entity);
					}
					case mainRegistry.guiIdBlueMateriaChest:
						if(entity instanceof TileEntityBlueMateriaChest){
							return new ContainerBlueMateriaChest(player.inventory, (TileEntityBlueMateriaChest) entity);
						}
					case mainRegistry.guiIdCrusher:
						if(entity instanceof TileEntityCrusher){
							return new GuiCrusher(player.inventory, (TileEntityCrusher) entity);
						}
	//				case mainRegistry.guiIdMixer:
	//					if(entity instanceof TileEntityMixer){
	//						return new GuiMixer(player.inventory, (TileEntityMixer) entity);
	//					}
				
			}
		}
		
		return null;
	}
	
}
