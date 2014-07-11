package com.gmail.rickvinke1.Materia.render;

import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Calendar;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import com.gmail.rickvinke1.Materia.Blocks.BlueMateriaChest;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityBlueMateriaChest;

@SideOnly(Side.CLIENT)
public class BlueMateriaChestRenderer extends TileEntitySpecialRenderer
{
    private static final ResourceLocation field_147504_g = new ResourceLocation(Strings.MODID + ":textures/blocks/BlueMateriaChest.png");
	
    private ModelChest field_147510_h = new ModelChest();

    private boolean field_147509_j;
    private static final String __OBFID = "CL_00000965";

    
    public void renderTileEntityAt(TileEntityBlueMateriaChest p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        int i;

        if (!p_147500_1_.hasWorldObj())
        {
            i = 0;
        }
        else
        {
            Block block = p_147500_1_.getBlockType();
            i = p_147500_1_.getBlockMetadata();


        if (p_147500_1_.adjacentChestZNeg == null && p_147500_1_.adjacentChestXNeg == null)
        {
            ModelChest modelchest;

            if (p_147500_1_.adjacentChestXPos == null && p_147500_1_.adjacentChestZPos == null)
            {
                modelchest = this.field_147510_h;

                if (this.field_147509_j)
                {
                }
                else
                {
                    this.bindTexture(field_147504_g);
                }
            }
            else
            {
                modelchest = this.field_147510_h;

            }

            GL11.glPushMatrix();
            GL11.glEnable(GL12.GL_RESCALE_NORMAL);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glTranslatef((float)p_147500_2_, (float)p_147500_4_ + 1.0F, (float)p_147500_6_ + 1.0F);
            GL11.glScalef(1.0F, -1.0F, -1.0F);
            GL11.glTranslatef(0.5F, 0.5F, 0.5F);
            short short1 = 0;

            if (i == 2)
            {
                short1 = 180;
            }

            if (i == 3)
            {
                short1 = 0;
            }

            if (i == 4)
            {
                short1 = 90;
            }

            if (i == 5)
            {
                short1 = -90;
            }



            GL11.glRotatef((float)short1, 0.0F, 1.0F, 0.0F);
            GL11.glTranslatef(-0.5F, -0.5F, -0.5F);
            float f1 = p_147500_1_.prevLidAngle + (p_147500_1_.lidAngle - p_147500_1_.prevLidAngle) * p_147500_8_;
            float f2;


            f1 = 1.0F - f1;
            f1 = 1.0F - f1 * f1 * f1;
            modelchest.chestLid.rotateAngleX = -(f1 * (float)Math.PI / 2.0F);
            modelchest.renderAll();
            GL11.glDisable(GL12.GL_RESCALE_NORMAL);
            GL11.glPopMatrix();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
    }

    public void renderTileEntityAt(TileEntity p_147500_1_, double p_147500_2_, double p_147500_4_, double p_147500_6_, float p_147500_8_)
    {
        this.renderTileEntityAt((TileEntityBlueMateriaChest)p_147500_1_, p_147500_2_, p_147500_4_, p_147500_6_, p_147500_8_);
    }
}