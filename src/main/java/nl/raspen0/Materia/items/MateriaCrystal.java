package nl.raspen0.Materia.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import nl.raspen0.Materia.blocks.MateriaBlocks;

public class MateriaCrystal extends Item {

	public MateriaCrystal() {
        setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
        setUnlocalizedName("materiaCrystal");
        setTextureName("Materia:blueMateriaCrystal");
}
	@Override
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if (world.isRemote) return false;
		
//		else if(world.getBlock(x, y, z) == Blocks.furnace){
//			world.setBlock(x, y, z, Blocks.air, 0, 2);
//			world.setBlock(x, y, z, MateriaBlocks.blockMateriaFurnaceIdle, 0, 2);
//	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
//			player.inventory.consumeInventoryItem(this);
//			
//		}
		else if(world.getBlock(x, y, z) == Blocks.stonebrick){
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			world.setBlock(x, y, z, MateriaBlocks.bluemateriaBrick, 0, 2);
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(this);
			
		}
		else if(world.getBlock(x, y, z) == Blocks.grass){
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			world.setBlock(x, y, z, MateriaBlocks.materiaGrass, 0, 2);
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(this);
			
		}
		else if(world.getBlock(x, y, z) == Blocks.chest){
			world.setBlock(x, y, z, Blocks.air, 0, 2);
			world.setBlock(x, y, z, MateriaBlocks.BlueMateriaChest, 0, 2);
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(this);
			
		}
		return false;
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