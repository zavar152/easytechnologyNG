package zavar30.easytechnology.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraftforge.common.ToolType;

public class BlockBoeryllium extends Block
{
	public BlockBoeryllium() 
	{
		super(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 5.0F).sound(SoundType.METAL));
	}

	@Override
	public ToolType getHarvestTool(IBlockState state) 
	{
		return ToolType.PICKAXE;
	}
	
	@Override
	public int getHarvestLevel(IBlockState state) 
	{
		return 2;
	}
}
