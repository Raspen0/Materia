package nl.raspen0.Materia.items;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import nl.raspen0.Materia.items.MateriaIngot;
import nl.raspen0.Materia.tools.CustomAxe;
import nl.raspen0.Materia.tools.CustomHoe;
import nl.raspen0.Materia.tools.CustomPickaxe;
import nl.raspen0.Materia.tools.CustomShovel;
import nl.raspen0.Materia.tools.CustomSword;

public class MateriaItems {



    public static void mainRegistry(){
    	initItems();
    	registerBlocks();
    }
    public static ToolMaterial BlueMateria = net.minecraftforge.common.util.EnumHelper.addToolMaterial("REDSTONE", 2, 512, 7.0F, 2.0F, 17);
    
    public static Item MateriaIngot;
	
	public static Item MateriaCrystal;
	
   //tools
	public static Item MateriaPickaxe;
	public static Item ItemTutorial;
	public static Item MateriaSword;
	public static Item MateriaShovel;
	public static Item MateriaHoe;
	public static Item MateriaAxe;
	public static Item Materiadust;
	//Currently used for Testing
	public static Item MateriaCoal;
	
    
    public static void initItems(){
        MateriaIngot = new nl.raspen0.Materia.items.MateriaIngot();
        MateriaCrystal = new nl.raspen0.Materia.items.MateriaCrystal();
        Materiadust = new nl.raspen0.Materia.items.MateriaDust();
        MateriaPickaxe = new CustomPickaxe(BlueMateria).setUnlocalizedName("MateriaPickaxe").setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria).setTextureName("Materia:blueMateriaPickaxe");
        MateriaSword = new CustomSword(BlueMateria).setUnlocalizedName("MateriaSword").setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria).setTextureName("Materia:blueMateriaSword");
        MateriaShovel = new CustomShovel(BlueMateria).setUnlocalizedName("MateriaShovel").setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria).setTextureName("Materia:blueMateriaShovel");
        MateriaHoe = new CustomHoe(BlueMateria).setUnlocalizedName("MateriaHoe").setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria).setTextureName("Materia:blueMateriaHoe");
        MateriaAxe = new CustomAxe(BlueMateria).setUnlocalizedName("MateriaAxe").setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria).setTextureName("Materia:blueMateriaAxe");
        MateriaCoal = new nl.raspen0.Materia.items.MateriaCoal();
    }
    
    public static void registerBlocks(){
    	

        GameRegistry.registerItem(MateriaIngot, "MateriaIngot");

        GameRegistry.registerItem(MateriaCrystal, "MateriaCrystal");

        GameRegistry.registerItem(Materiadust, "MateriaDust");
       
    	GameRegistry.registerItem(MateriaPickaxe, "MateriaPickaxe");
      
    	GameRegistry.registerItem(MateriaSword, "MateriaSword");

    	GameRegistry.registerItem(MateriaShovel, "MateriaShovel");

    	GameRegistry.registerItem(MateriaAxe, "MateriaAxe");

    	GameRegistry.registerItem(MateriaHoe, "MateriaHoe");
    	
    	GameRegistry.registerItem(MateriaCoal, "MateriaCoal");
    	
    	
    	
    }
}