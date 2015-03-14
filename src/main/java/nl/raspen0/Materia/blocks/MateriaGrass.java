package nl.raspen0.Materia.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import nl.raspen0.Materia.Strings;

public class MateriaGrass extends Block {
	
    public MateriaGrass() 
    {
        super(Material.grass);
           
           setStepSound(Block.soundTypeGrass);
           setBlockName("materiaGrass");
           setCreativeTab(nl.raspen0.Materia.CreativeTab.tabMateria);
           setHardness(0.6F);
   }
    
    
    @SideOnly(Side.CLIENT)
    private IIcon top;
    
	public boolean canCreatureSpawn(EnumCreatureType type, IBlockAccess world, int x, int y, int z) {
		return false;
    }
	
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ != 1 && p_149691_1_ != 0 ? this.blockIcon : this.top;
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Blocks.dirt);
    }
    
    public boolean canSilkHarvest(World world, EntityPlayer player, int x, int y, int z, int metadata)
    {
    	return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(Strings.MODID + ":" + "materiagrass_side");
        this.top = p_149651_1_.registerIcon(Strings.MODID + ":" + "materiagrass_top");
    }

}
