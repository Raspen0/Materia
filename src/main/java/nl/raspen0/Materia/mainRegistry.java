package nl.raspen0.Materia;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.config.Configuration;




import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.gui.GuiHandler;
import nl.raspen0.Materia.items.MateriaItems;
import nl.raspen0.Materia.mobs.MateriaPig;
import nl.raspen0.Materia.recipes.CraftingTableRecipes;
import nl.raspen0.Materia.recipes.FurnaceRecipes;
import nl.raspen0.Materia.server.ServerProxy;
import nl.raspen0.Materia.tile_entity.TileEntityMateria;
import nl.raspen0.Materia.worldgen.MateriaWorld;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;

@Mod(modid=Strings.MODID, name=Strings.name, version=Strings.version, guiFactory = "nl.raspen0.Materia.MateriaGuiFactory")
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class mainRegistry
{

	@Instance(Strings.MODID)
    public static mainRegistry instance;
	
	public static final int guiIdMateriaFurnace = 0; 
	
	public static final int guiIdBlueMateriaChest = 1; 
	
	public static final int guiIdCrusher = 2; 
	
	public static final int guiIdMixer = 3; 
	
	
	
    @SidedProxy(clientSide="nl.raspen0.Materia.client.ClientProxy", serverSide="nl.raspen0.Materia.server.ServerProxy")
    public static ServerProxy proxy;
    
    public static Configuration configFile;
    
    @Metadata
    public static ModMetadata meta;
    

    
    //config
    public static final String CATEGORY_WORLDGEN = "worldgen";
    public static final String CATEGORY_DEV = "experimental";
	public static boolean BlockCrusher = true;
	public static boolean BlueMateriaOreGen = true;
	public static boolean RedMateriaOreGen = true;
	public static boolean HQTextures = true;
	public static boolean MateriaSlabs = true;
	
	
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent Event)
    {
    	configFile = new Configuration(Event.getSuggestedConfigurationFile());
    	MateriaBlocks.mainRegistry();
    	MateriaItems.mainRegistry();
    	MateriaWorld.mainRegistry();
    	TileEntityMateria.mainRegistry();
    	CraftingTableRecipes.addCraftingRecipes();
    	FurnaceRecipes.addSmeltingRecipes();
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
    	syncConfig();
    	
    	
    	
    }
    
    public static void syncConfig() {
    	BlueMateriaOreGen = configFile.get(CATEGORY_WORLDGEN, "Generate BlueMateria Ore", true).getBoolean(true);
    	RedMateriaOreGen = configFile.get(CATEGORY_WORLDGEN, "Generate RedMateria Ore", true).getBoolean(true);
    	configFile.addCustomCategoryComment("experimental", "These settings are experimental, It is advised to backup your world before using!");
    	HQTextures = configFile.get(Configuration.CATEGORY_GENERAL, "High Quality Textures", true).getBoolean(true);
    	BlockCrusher = configFile.get(CATEGORY_DEV, "Enable Crusher", true).getBoolean(true);
    	MateriaSlabs = configFile.get(CATEGORY_DEV, "Enable Materia Slabs", true).getBoolean(true);
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
    	int modEntityID = 0;

        EntityRegistry.registerModEntity(MateriaPig.class, "Materia_Pig", ++modEntityID, this.instance, 80, 1, true);
       // EntityRegistry.addSpawn(EntityYourMob.class, 2, 0, 1, EnumCreatureType.creature, BiomeGenBase.biomeList);
   
        
    	proxy.registerRenderThings();
    	
    	FMLCommonHandler.instance().bus().register(instance);
        OreDictionaryRegistry.mainRegistry();
    }
    
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
    	
    }
    
    
}