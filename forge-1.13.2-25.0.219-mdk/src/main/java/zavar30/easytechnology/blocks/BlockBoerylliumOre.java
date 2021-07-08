package zavar30.easytechnology.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import zavar30.easytechnology.ETItems;

public class BlockBoerylliumOre extends Block
{

	public BlockBoerylliumOre() 
	{
		super(Properties.create(Material.IRON).hardnessAndResistance(3.0F, 5.0F).sound(SoundType.STONE));
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
	
	@Override
	public IItemProvider getItemDropped(IBlockState state, World worldIn, BlockPos pos, int fortune)
	{
		return ETItems.boeryllium_ingot_raw;
	}
}
