package nl.raspen0.Materia.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import nl.raspen0.Materia.CreativeTab;
import nl.raspen0.Materia.Strings;

public class MateriaPork extends ItemFood{
	private PotionEffect[] effects;

    public MateriaPork(String unlocalizedName, int healAmount, float saturationModifier, boolean wolvesFavourite) {
        super(healAmount, saturationModifier, wolvesFavourite);
        
        this.setUnlocalizedName(unlocalizedName);
        this.setTextureName(Strings.MODID + ":" + unlocalizedName);
        this.setCreativeTab(CreativeTab.tabMateria);
    }

	@Override
	protected void onFoodEaten(ItemStack stack, World world, EntityPlayer player) {
		super.onFoodEaten(stack, world, player);
	}
	
	

}
