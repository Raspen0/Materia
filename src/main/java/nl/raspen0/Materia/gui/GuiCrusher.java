package nl.raspen0.Materia.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import nl.raspen0.Materia.Strings;
import nl.raspen0.Materia.container.ContainerCrusher;
import nl.raspen0.Materia.tile_entity.TileEntityCrusher;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class GuiCrusher  extends GuiContainer{
	
	public static final ResourceLocation CrusherGUI = new ResourceLocation(Strings.MODID + ":textures/gui/Materia_Furnace.png");

	public TileEntityCrusher Crusher;
	
    public GuiCrusher(InventoryPlayer inventoryPlayer, TileEntityCrusher entity)
    {
        super(new ContainerCrusher(inventoryPlayer, entity));
        this.Crusher = entity;
	}
	
	public void drawGuiContainerForegroundLayer(int par1, int par2) {
		String name = this.Crusher.hasCustomInventoryName() ? this.Crusher.getInventoryName() : I18n.format(this.Crusher.getInventoryName(), new Object[0]);
		
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 8, this.ySize - 96 + 2, 4210752);
	}
	
	public void drawGuiContainerBackgroundLayer(float f, int i, int j) 
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(CrusherGUI);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int var7;

        if (Crusher.isBurning())
        {
            var7 = Crusher.getBurnTimeRemainingScaled(12);
            drawTexturedModalRect(k + 56, l + 36 + 12 - var7, 176, 12 - var7, 14, var7 + 2);
        }

        var7 = Crusher.getCookProgressScaled(24);
        drawTexturedModalRect(k + 79, l + 34, 176, 14, var7 + 1, 16);
	
    }
}