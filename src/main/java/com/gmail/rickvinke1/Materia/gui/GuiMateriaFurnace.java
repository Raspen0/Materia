package com.gmail.rickvinke1.Materia.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.gmail.rickvinke1.Materia.Container.ContainerMateriaFurnace;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityMateriaFurnace;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class GuiMateriaFurnace  extends GuiContainer{
	
	public static final ResourceLocation FurnaceGui = new ResourceLocation(Strings.MODID + ":textures/gui/Materia_Furnace.png");

	public TileEntityMateriaFurnace materiaFurnace;
	
    public GuiMateriaFurnace(InventoryPlayer inventoryPlayer, TileEntityMateriaFurnace entity)
    {
        super(new ContainerMateriaFurnace(inventoryPlayer, entity));
        this.materiaFurnace = entity;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.materiaFurnace.hasCustomInventoryName() ? this.materiaFurnace.getInventoryName() : I18n.format(this.materiaFurnace.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) 
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(FurnaceGui);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int var7;

        if (materiaFurnace.isBurning())
        {
            var7 = materiaFurnace.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(k + 56, l + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = materiaFurnace.getCookProgressScaled(24);
        drawTexturedModalRect(k + 79, l + 34, 176, 14, var7 + 1, 16);
	
    }
}