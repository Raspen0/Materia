package nl.raspen0.Materia;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import nl.raspen0.Materia.blocks.BlockRegistry;
import nl.raspen0.Materia.items.ItemRegistry;
import nl.raspen0.Materia.server.ServerProxy;

@Mod(modid = Strings.MODID, version = Strings.version)
public class mainRegistry
{
	@SidedProxy(clientSide="nl.raspen0.Materia.client.ClientProxy", serverSide="nl.raspen0.Materia.server.ServerProxy")
	public static ServerProxy proxy;
	
	@Instance(Strings.MODID)
    public static mainRegistry instance;
    
	
	
    @EventHandler
    public void PreInit(FMLPreInitializationEvent Event)
    {
    }
	
	
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ItemRegistry.mainRegistry();
    	BlockRegistry.mainRegistry();
    }
    
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
    	
    }
}
