package com.gmail.rickvinke1.Materia;

import cpw.mods.fml.client.config.GuiConfig;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import com.gmail.rickvinke1.Materia.*;

public class MateriaConfigGUI extends GuiConfig {
    public MateriaConfigGUI(GuiScreen parent) {
        super(parent,
                new ConfigElement(mainRegistry.configFile.getCategory(mainRegistry.CATEGORY_WORLDGEN)).getChildElements(), 
                "Materia", false, true, GuiConfig.getAbridgedConfigPath(mainRegistry.configFile.toString()));
    
        	       
        
       
    }
}