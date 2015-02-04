package nl.raspen0.Materia.items;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {
	
	
    public static void mainRegistry(){
    	initItems();
    	registerItems();
    	renderItems();
    }
    
    public static Item MateriaCrystal;

    
    
    public static void initItems(){
    MateriaCrystal = new MateriaCrystal();
    }
    
    public static void registerItems(){
    	 GameRegistry.registerItem(MateriaCrystal, "materiaCrystal");
    }
    
    public static void renderItems(){
    	 Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(MateriaCrystal, 0, new ModelResourceLocation("Materia:materiaCrystal", "inventory"));
    }
}
