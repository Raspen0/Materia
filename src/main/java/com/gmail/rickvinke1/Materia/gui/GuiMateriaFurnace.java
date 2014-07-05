package com.gmail.rickvinke1.Materia.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import com.gmail.rickvinke1.Materia.Container.ContainerMateriaFurnace;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

public class GuiMateriaFurnace  extends GuiContainer{
	
	public static final ResourceLocation FurnaceGui = new ResourceLocation(Strings.MODID + ":textures/gui/Materia_Furnace.png");

	public TileEntityMateriaFurnace materiaFurnace;
	
	public GuiMateriaFurnace(InventoryPlayer inventoryPlayer, TileEntityMateriaFurnace entity) {
		super(new ContainerMateriaFurnace(inventoryPlayer, entity));
		
		this.materiaFurnace = entity;
		
		this.xSize = 176;
		this.ySize = 166;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.materiaFurnace.isInvNameLocalized() ? this.materiaFurnace.getInventoryName() : I18n.format(this.materiaFurnace.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		Minecraft.getMinecraft().getTextureManager().bindTexture(FurnaceGui);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		if(this.materiaFurnace.isBurning()){
			int k = this.materiaFurnace.getBurnTimeRemainingScaled(12);
			drawTexturedModalRect(guiLeft + 56, guiTop + 36 + 12 - k, 176, 12-k, 14, k + 2);
		}
		
		int k = this.materiaFurnace.getCookProgessScaled(24);
		drawTexturedModalRect(guiLeft + 79, guiTop + 34, 176, 14, k + 1, 16);
	}

}