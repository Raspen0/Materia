package nl.raspen0.Materia.items;

import java.util.Random;

import com.sun.media.jfxmedia.logging.Logger;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import nl.raspen0.Materia.Strings;
import nl.raspen0.Materia.blocks.BlueMateriaChest;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.recipes.InfusionRecipes;
import nl.raspen0.Materia.tile_entity.TileEntityBlueMateriaChest;

public class MateriaCrystal extends Item {

	public MateriaCrystal() {
        setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
        setUnlocalizedName("materiaCrystal");
        setTextureName("Materia:blueMateriaCrystal");
}
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		return InfusionRecipes.Infusion(stack, player, world, x, y, z, side, hitX, hitY, hitZ);
    }
	
    public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.rare;
    }
    
    public boolean hasEffect(ItemStack par1ItemStack, int pass)
    {
        return true;
    }
}