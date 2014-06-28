package com.gmail.rickvinke1.Materia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;
import com.gmail.rickvinke1.Materia.generation.MateriaWorld;


import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.server.ServerProxy;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateria;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.Metadata;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid=Strings.MODID, name=Strings.name, version=Strings.version, guiFactory = "com.gmail.rickvinke1.Materia.MateriaGuiFactory")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class mainRegistry
{

	@Mod.Instance("Materia")
    public static mainRegistry instance;
	
    @SidedProxy(clientSide="com.gmail.rickvinke1.Materia.client.ClientProxy", serverSide="com.gmail.rickvinke1.Materia.server.ServerProxy")
    public static ServerProxy proxy;
    
    public static Configuration configFile;
    
    @Metadata
    public static ModMetadata meta;
    
    @Instance(Strings.MODID)
    public static mainRegistry modInstance;
    
    public static CreativeTabs tabMateria = new CreativeTabs("Materia"){
    	public Item getTabIconItem(){
    		return MateriaItems.MateriaIngot;
    	}
    	
    };
    
    //config
    public static final String CATEGORY_WORLDGEN = "worldgen";
    public static final String CATEGORY_DEV = "experimental";
	public static boolean BlockBlueMateriaChest = true;
	public static boolean BlueMateriaOreGen = true;
	public static boolean RedMateriaOreGen = true;
	
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent Event)
    {
    	configFile = new Configuration(Event.getSuggestedConfigurationFile());
    	MateriaBlocks.mainRegistry();
    	MateriaItems.mainRegistry();
    	MateriaWorld.mainRegistry();
    	TileEntityMateria.mainRegistry();
    	MateriaCrafting.MainClass();
    	proxy.registerRenderThings();
    	syncConfig();
    	
    	
    }
    
    public static void syncConfig() {
    	BlueMateriaOreGen = configFile.get(CATEGORY_WORLDGEN, "Generate BlueMateria Ore", true).getBoolean(true);
    	RedMateriaOreGen = configFile.get(CATEGORY_WORLDGEN, "Generate RedMateria Ore", true).getBoolean(true);
    	configFile.addCustomCategoryComment("experimental", "These settings are experimental, It is advised to backup your world before using!");
    	BlockBlueMateriaChest = configFile.get(CATEGORY_DEV, "BlueMateriaChest", true).getBoolean(true);

    	
    	
    	
        if(configFile.hasChanged())
            configFile.save();
    }
    
    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if(eventArgs.modID.equals("Materia"))
            syncConfig();
    }
    
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
    	FMLCommonHandler.instance().bus().register(instance);
    	
    }
    
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
    	
    	
    }
    
    
}