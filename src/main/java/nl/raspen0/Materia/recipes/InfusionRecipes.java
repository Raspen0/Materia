package nl.raspen0.Materia.recipes;

import java.util.Random;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import nl.raspen0.Materia.Strings;
import nl.raspen0.Materia.blocks.BlueMateriaChest;
import nl.raspen0.Materia.blocks.MateriaBlocks;
import nl.raspen0.Materia.items.MateriaItems;
import nl.raspen0.Materia.tile_entity.TileEntityBlueMateriaChest;

public class InfusionRecipes {

    public static boolean Infusion(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
		if (world.isRemote){
			return false;
			}
		
		else if(world.getBlock(x, y, z) == Blocks.stonebrick){
			world.setBlock(x, y, z, MateriaBlocks.bluemateriaBrick, 0, 2);
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(MateriaItems.MateriaCrystal);
		}
		
		else if(world.getBlock(x, y, z) == Blocks.grass){
			world.setBlock(x, y, z, MateriaBlocks.materiaGrass, 0, 2);
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(MateriaItems.MateriaCrystal);
		}
		
		else if(world.getBlock(x, y, z) == Blocks.chest){
			BlueMateriaChest block = MateriaBlocks.BlueChestBlock;
			TileEntity te = world.getTileEntity(x, y, z);
			TileEntityChest tec = (TileEntityChest) te;
			TileEntityBlueMateriaChest newchest = new TileEntityBlueMateriaChest();
			byte b0 = 3;
			
			if(world.getBlockMetadata(x, y, z) == 2){
				b0=2;
			}
			if(world.getBlockMetadata(x, y, z) == 3){
				b0=3;
			}
			if(world.getBlockMetadata(x, y, z) == 4){
				b0=4;
			}
			if(world.getBlockMetadata(x, y, z) == 5){
				b0=5;
			}
			
			int newSize = newchest.chestContents.length;
			ItemStack[] chestContents = ObfuscationReflectionHelper.getPrivateValue(TileEntityChest.class, tec, 0);
			System.arraycopy(chestContents, 0, newchest.chestContents, 0, Math.min(newSize, chestContents.length));
			block.dropContent(newSize, tec, world, tec.xCoord, tec.yCoord, tec.zCoord);
			
	          for (int i = 0; i < Math.min(newSize, chestContents.length); i++)
	            {
	                chestContents[i] = null;
	            }
	        world.setBlock(x, y, z, Blocks.air, 0, 3); 
			world.setBlock(x, y, z, MateriaBlocks.BlueChestBlock);
			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
			world.setTileEntity(x, y, z, newchest);
			
	    	world.playSoundAtEntity(player, "random.orb", 1, 1);
			player.inventory.consumeInventoryItem(MateriaItems.MateriaCrystal);
        }

		return false;
    }
    	
}
