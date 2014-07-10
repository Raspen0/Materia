package com.gmail.rickvinke1.Materia.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Iterator;
import java.util.Random;

import com.gmail.rickvinke1.Materia.mainRegistry;
import com.gmail.rickvinke1.Materia.lib.Strings;
import com.gmail.rickvinke1.Materia.tile_entity.TileEntityBlueMateriaChest;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import static net.minecraftforge.common.util.ForgeDirection.*;

public class BlueMateriaChest extends BlockContainer
{
    private final Random random = new Random();
    public final int field_149956_a;
    private static final String __OBFID = "CL_00000214";

    protected BlueMateriaChest(int i)
    {
        super(Material.iron);
        this.field_149956_a = i;
        this.setCreativeTab(mainRegistry.tabMateria);
        this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
    }
    
    
    

    /**
     * Is this block (a) opaque and (b) a full 1m cube?  This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }
    
    

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return 22;
    }

    /**
     * Updates the blocks bounds based on its current state. Args: world, x, y, z
     */
    public void setBlockBoundsBasedOnState(IBlockAccess iblockaccess, int x, int y, int z)
    {
        if (iblockaccess.getBlock(x, y, z - 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (iblockaccess.getBlock(x, y, z + 1) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 1.0F);
        }
        else if (iblockaccess.getBlock(x - 1, y, z) == this)
        {
            this.setBlockBounds(0.0F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
        else if (iblockaccess.getBlock(x + 1, y, z) == this)
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 1.0F, 0.875F, 0.9375F);
        }
        else
        {
            this.setBlockBounds(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     */
    public void onBlockAdded(World world, int x, int y, int z)
    {
        super.onBlockAdded(world, x, y, z);
        this.func_149954_e(world, x, y, z);
        Block block = world.getBlock(x, y, z - 1);
        Block block1 = world.getBlock(x, y, z + 1);
        Block block2 = world.getBlock(x - 1, y, z);
        Block block3 = world.getBlock(x + 1, y, z);

        if (block == this)
        {
            this.func_149954_e(world, x, y, z - 1);
        }

        if (block1 == this)
        {
            this.func_149954_e(world, x, y, z + 1);
        }

        if (block2 == this)
        {
            this.func_149954_e(world, x - 1, y, z);
        }

        if (block3 == this)
        {
            this.func_149954_e(world, x + 1, y, z);
        }
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase Entity, ItemStack itemstack)
    {
        Block block = world.getBlock(x, y, z - 1);
        Block block1 = world.getBlock(x, y, z + 1);
        Block block2 = world.getBlock(x - 1, y, z);
        Block block3 = world.getBlock(x + 1, y, z);
        byte b0 = 0;
        int l = MathHelper.floor_double((double)(Entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (l == 0)
        {
            b0 = 2;
        }

        if (l == 1)
        {
            b0 = 5;
        }

        if (l == 2)
        {
            b0 = 3;
        }

        if (l == 3)
        {
            b0 = 4;
        }

        if (block != this && block1 != this && block2 != this && block3 != this)
        {
            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
        else
        {
            if ((block == this || block1 == this) && (b0 == 4 || b0 == 5))
            {
                if (block == this)
                {
                    world.setBlockMetadataWithNotify(x, y, z - 1, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x, y, z + 1, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }

            if ((block2 == this || block3 == this) && (b0 == 2 || b0 == 3))
            {
                if (block2 == this)
                {
                    world.setBlockMetadataWithNotify(x - 1, y, z, b0, 3);
                }
                else
                {
                    world.setBlockMetadataWithNotify(x + 1, y, z, b0, 3);
                }

                world.setBlockMetadataWithNotify(x, y, z, b0, 3);
            }
        }

        if (itemstack.hasDisplayName())
        {
            ((TileEntityBlueMateriaChest)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
        }
    }

    public void func_149954_e(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block block = world.getBlock(x, y, z - 1);
            Block block1 = world.getBlock(x, y, z + 1);
            Block block2 = world.getBlock(x - 1, y, z);
            Block block3 = world.getBlock(x + 1, y, z);
            boolean flag = true;
            int l;
            Block block4;
            int i1;
            Block block5;
            boolean flag1;
            byte b0;
            int j1;

            if (block != this && block1 != this)
            {
                if (block2 != this && block3 != this)
                {
                    b0 = 3;

                    if (block.func_149730_j() && !block1.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if (block1.func_149730_j() && !block.func_149730_j())
                    {
                        b0 = 2;
                    }

                    if (block2.func_149730_j() && !block3.func_149730_j())
                    {
                        b0 = 5;
                    }

                    if (block3.func_149730_j() && !block2.func_149730_j())
                    {
                        b0 = 4;
                    }
                }
                else
                {
                    l = block2 == this ? x - 1 : x + 1;
                    block4 = world.getBlock(l, y, z - 1);
                    i1 = block2 == this ? x - 1 : x + 1;
                    block5 = world.getBlock(i1, y, z + 1);
                    b0 = 3;
                    flag1 = true;

                    if (block2 == this)
                    {
                        j1 = world.getBlockMetadata(x - 1, y, z);
                    }
                    else
                    {
                        j1 = world.getBlockMetadata(x + 1, y, z);
                    }

                    if (j1 == 2)
                    {
                        b0 = 2;
                    }

                    if ((block.func_149730_j() || block4.func_149730_j()) && !block1.func_149730_j() && !block5.func_149730_j())
                    {
                        b0 = 3;
                    }

                    if ((block1.func_149730_j() || block5.func_149730_j()) && !block.func_149730_j() && !block4.func_149730_j())
                    {
                        b0 = 2;
                    }
                }
            }
            else
            {
                l = block == this ? z - 1 : z + 1;
                block4 = world.getBlock(x - 1, y, l);
                i1 = block == this ? z - 1 : z + 1;
                block5 = world.getBlock(x + 1, y, i1);
                b0 = 5;
                flag1 = true;

                if (block == this)
                {
                    j1 = world.getBlockMetadata(x, y, z - 1);
                }
                else
                {
                    j1 = world.getBlockMetadata(x, y, z + 1);
                }

                if (j1 == 4)
                {
                    b0 = 4;
                }

                if ((block2.func_149730_j() || block4.func_149730_j()) && !block3.func_149730_j() && !block5.func_149730_j())
                {
                    b0 = 5;
                }

                if ((block3.func_149730_j() || block5.func_149730_j()) && !block2.func_149730_j() && !block4.func_149730_j())
                {
                    b0 = 4;
                }
            }

            world.setBlockMetadataWithNotify(x, y, z, b0, 3);
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor Block
     */
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block)
    {
        super.onNeighborBlockChange(world, x, y, z, block);
        TileEntityBlueMateriaChest TileEntityBlueMateriaChest = (TileEntityBlueMateriaChest)world.getTileEntity(x, y, z);

        if (TileEntityBlueMateriaChest != null)
        {
            TileEntityBlueMateriaChest.updateContainingBlockInfo();
        }
    }

    public void breakBlock(World world, int x, int y, int z, Block block, int i)
    {
        TileEntityBlueMateriaChest TileEntityBlueMateriaChest = (TileEntityBlueMateriaChest)world.getTileEntity(x, y, z);

        if (TileEntityBlueMateriaChest != null)
        {
            for (int i1 = 0; i1 < TileEntityBlueMateriaChest.getSizeInventory(); ++i1)
            {
                ItemStack itemstack = TileEntityBlueMateriaChest.getStackInSlot(i1);

                if (itemstack != null)
                {
                    float f = this.random.nextFloat() * 0.8F + 0.1F;
                    float f1 = this.random.nextFloat() * 0.8F + 0.1F;
                    EntityItem entityitem;

                    for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; world.spawnEntityInWorld(entityitem))
                    {
                        int j1 = this.random.nextInt(21) + 10;

                        if (j1 > itemstack.stackSize)
                        {
                            j1 = itemstack.stackSize;
                        }

                        itemstack.stackSize -= j1;
                        entityitem = new EntityItem(world, (double)((float)x + f), (double)((float)y + f1), (double)((float)z + f2), new ItemStack(itemstack.getItem(), j1, itemstack.getItemDamage()));
                        float f3 = 0.05F;
                        entityitem.motionX = (double)((float)this.random.nextGaussian() * f3);
                        entityitem.motionY = (double)((float)this.random.nextGaussian() * f3 + 0.2F);
                        entityitem.motionZ = (double)((float)this.random.nextGaussian() * f3);

                        if (itemstack.hasTagCompound())
                        {
                            entityitem.getEntityItem().setTagCompound((NBTTagCompound)itemstack.getTagCompound().copy());
                        }
                    }
                }
            }

            world.func_147453_f(x, y, z, block);
        }

        super.breakBlock(world, x, y, z, block, i);
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int i, float f1, float f2, float f3)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IInventory iinventory = this.func_149951_m(world, x, y, z);

            if (iinventory != null)
            {
                player.displayGUIChest(iinventory);
            }

            return true;
        }
    }

    public IInventory func_149951_m(World world, int x, int y, int z)
    {
        Object object = (TileEntityBlueMateriaChest)world.getTileEntity(x, y, z);

        if (object == null)
        {
            return null;
        }
        else if (world.isSideSolid(x, y + 1, z, DOWN))
        {
            return null;
        }
        else if (SittingOcelot(world, x, y, z))
        {
            return null;
        }
        else if (world.getBlock(x - 1, y, z) == this && (world.isSideSolid(x - 1, y + 1, z, DOWN) || SittingOcelot(world, x - 1, y, z)))
        {
            return null;
        }
        else if (world.getBlock(x + 1, y, z) == this && (world.isSideSolid(x + 1, y + 1, z, DOWN) || SittingOcelot(world, x + 1, y, z)))
        {
            return null;
        }
        else if (world.getBlock(x, y, z - 1) == this && (world.isSideSolid(x, y + 1, z - 1, DOWN) || SittingOcelot(world, x, y, z - 1)))
        {
            return null;
        }
        else if (world.getBlock(x, y, z + 1) == this && (world.isSideSolid(x, y + 1, z + 1, DOWN) || SittingOcelot(world, x, y, z + 1)))
        {
            return null;
        }
        else
        {
            return (IInventory)object;
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int tileentity)
    {
        TileEntityBlueMateriaChest TileEntityBlueMateriaChest = new TileEntityBlueMateriaChest();
        return TileEntityBlueMateriaChest;
    }

    /**
     * Can this block provide power. Only wire currently seems to have this change based on its state.
     */
    public boolean canProvidePower()
    {
        return this.field_149956_a == 1;
    }

    public int isProvidingWeakPower(IBlockAccess Access, int i, int j, int k, int l)
    {
        if (!this.canProvidePower())
        {
            return 0;
        }
        else
        {
            int i1 = ((TileEntityBlueMateriaChest)Access.getTileEntity(i, j, k)).numPlayersUsing;
            return MathHelper.clamp_int(i1, 0, 15);
        }
    }

    public int isProvidingStrongPower(IBlockAccess Access, int i, int j, int k, int l)
    {
        return l == 1 ? this.isProvidingWeakPower(Access, i, j, k, l) : 0;
    }

    private static boolean SittingOcelot(World world, int x, int y, int z)
    {
        Iterator iterator = world.getEntitiesWithinAABB(EntityOcelot.class, AxisAlignedBB.getBoundingBox((double)x, (double)(y + 1), (double)z, (double)(x + 1), (double)(y + 2), (double)(z + 1))).iterator();
        EntityOcelot entityocelot;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            Entity entity = (Entity)iterator.next();
            entityocelot = (EntityOcelot)entity;
        }
        while (!entityocelot.isSitting());

        return true;
    }

    /**
     * If this returns true, then comparators facing away from this block will use the value from
     * getComparatorInputOverride instead of the actual redstone signal strength.
     */
    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    /**
     * If hasComparatorInputOverride returns true, the return value from this is used instead of the redstone signal
     * strength when this block inputs to a comparator.
     */
    public int getComparatorInputOverride(World world, int x, int y, int z, int l)
    {
        return Container.calcRedstoneFromInventory(this.func_149951_m(world, x, y, z));
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister icon)
    {
        this.blockIcon = icon.registerIcon(Strings.MODID + ":BlueMateriaBlock");
    }
    
	
}