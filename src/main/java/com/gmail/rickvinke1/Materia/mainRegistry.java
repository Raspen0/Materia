package com.gmail.rickvinke1.Materia;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

import com.gmail.rickvinke1.Materia.Blocks.MateriaBlocks;
import com.gmail.rickvinke1.Materia.Items.MateriaItems;
import com.gmail.rickvinke1.Materia.generation.MateriaWorld;


import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.server.ServerProxy;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateria;

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

@Mod(modid=Strings.MODID, name=Strings.name, version=Strings.version)
//@NetworkMod(clientSideRequired=true) // not used in 1.7
public class mainRegistry
{

    @SidedProxy(clientSide="com.gmail.rickvinke1.Materia.client.ClientProxy", serverSide="com.gmail.rickvinke1.Materia.ServerProxy")
    public static ServerProxy proxy;

    @Metadata
    public static ModMetadata meta;
    
    @Instance(Strings.MODID)
    public static mainRegistry modInstance;
    
    public static CreativeTabs tabMateria = new CreativeTabs("Materia"){
    	public Item getTabIconItem(){
    		return MateriaItems.MateriaIngot;
    	}
    	
    };
    
    @EventHandler
    public void PreLoad(FMLPreInitializationEvent PreEvent)
    {
    	
    	MateriaBlocks.mainRegistry();
    	MateriaItems.mainRegistry();
    	MateriaWorld.mainRegistry();
    	TileEntityMateria.mainRegistry();
    	MateriaCrafting.MainClass();
    	
    	proxy.registerRenderThings();
    	
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
 
    	
    }
    
    @EventHandler
    public void PostLoad(FMLPostInitializationEvent PostEvent)
    {
    	
    	
    }
    
    
}