package com.gmail.rickvinke1.Materia.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.gmail.rickvinke1.Materia.Container.ContainerMateriaFurnace;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

public class GuiMateriaFurnace  extends GuiContainer{
	
	public static final ResourceLocation FurnaceGui = new ResourceLocation(Strings.MODID, "textures/gui/Materia_Furnace.png");

	public TileEntityMateriaFurnace materiaFurnace;
	
	public GuiMateriaFurnace(InventoryPlayer inventoryPlayer, TileEntityMateriaFurnace entity) {
		super(new ContainerMateriaFurnace(inventoryPlayer, entity));
		
		this.materiaFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.materiaFurnace.isInvNameLocalized() ? this.materiaFurnace.getInvName() : I18n.format(this.materiaFurnace.getInvName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}

}
