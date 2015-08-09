package nl.raspen0.Materia.mobs;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import nl.raspen0.Materia.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MateriaPigRenderer extends RenderLiving{
	
	public MateriaPigRenderer(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }
	
    //private static final ResourceLocation saddledPigTextures = new ResourceLocation("textures/entity/pig/pig_saddle.png");
    private static final ResourceLocation pigTextures = new ResourceLocation(Strings.MODID + ":" + "textures/entity/MateriaPig.png");

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return pigTextures;
	}

}
