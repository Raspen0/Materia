package nl.raspen0.Materia.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemSlab;
import nl.raspen0.Materia.blocks.MateriaBlocks;

public class ItemMateriaSlab extends ItemSlab{

	public ItemMateriaSlab (Block block)
	{
	    super(block, (BlockSlab)MateriaBlocks.materiaBlockSlab, (BlockSlab)MateriaBlocks.materiaBlockDoubleSlab, false);
	    this.setMaxDamage(0);
	    this.setHasSubtypes(true);
	}
}
