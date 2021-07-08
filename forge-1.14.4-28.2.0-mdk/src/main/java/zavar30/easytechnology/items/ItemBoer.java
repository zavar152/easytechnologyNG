package zavar30.easytechnology.items;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTier;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;
import zavar30.easytechnology.EasyTechnology;

public class ItemBoer extends ToolItem
{
	private Material[] m = {Material.ROCK, Material.ANVIL, Material.CORAL, Material.SNOW_BLOCK, 
			Material.CLAY, Material.EARTH, Material.IRON, Material.SAND, Material.SNOW, Material.PISTON, 
			Material.CORAL, Material.DRAGON_EGG, Material.ICE, Material.PACKED_ICE};
	private ITextComponent info_text = new TranslationTextComponent("boer.info.text", "dank");
	private ITextComponent reload_text = new TranslationTextComponent("boer.reload.text", "dank");
	private ITextComponent need = new TranslationTextComponent("boer.need.text", "dank");
	private TranslationTextComponent need_text = new TranslationTextComponent(need.getFormattedText());
	private final float EFF = 15.0F;
	
	public ItemBoer() 
	{
		super(-4.0F, -3.0F, ItemTier.DIAMOND, Sets.newHashSet(new Block[] {}), new Properties().group(EasyTechnology.tab).maxStackSize(1).addToolType(ToolType.PICKAXE, 4).addToolType(ToolType.SHOVEL, 4).defaultMaxDamage(500));
	}
	
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) 
	{
		info_text.getStyle().setBold(true).setColor(TextFormatting.GRAY);
		reload_text.getStyle().setBold(true).setColor(TextFormatting.GRAY);
		tooltip.add(new TranslationTextComponent(info_text.getFormattedText() + (stack.getMaxDamage() - stack.getDamage()) + "/" + stack.getMaxDamage()));
		tooltip.add(new TranslationTextComponent(reload_text.getFormattedText()));
		if(stack.getDamage() == (stack.getMaxDamage() - 1))
		{
			need_text.getStyle().setColor(TextFormatting.RED);
			tooltip.add(need_text);
		}
		else
		{
			if(tooltip.contains(need_text))
			{
				tooltip.remove(need_text);
			}
		}
		super.addInformation(stack, worldIn, tooltip, flagIn);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) 
	{
		ItemStack boer = playerIn.inventory.getCurrentItem();
		for (int i = 0; i < playerIn.inventory.getSizeInventory(); i++)
		{
		  ItemStack coal = playerIn.inventory.getStackInSlot(i);
		  
		  if(isCoal(coal)) //8 ед. за 1 уголь
		  {
			  if(boer.getDamage() != 0)
			  {
				 int y = 64 - (boer.getMaxDamage() - boer.getDamage())/8;
				 if(coal.getCount() >= y)
				 {
					coal.setCount(coal.getCount() - y);
				 	boer.setDamage(0);
					if(coal.getCount() == 0)
					{
						playerIn.inventory.deleteStack(coal);
					}
			  	 }
			  }
		  }
		}
		return super.onItemRightClick(worldIn, playerIn, handIn);
	}
	
	protected boolean isCoal(@Nullable ItemStack stack)
	{
	  return (stack != null) && ((stack.getItem().equals(Items.COAL)));
	}
	
	@Override
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) 
	{
		stack.setDamage(stack.getMaxDamage() - 1);
		super.onCreated(stack, worldIn, playerIn);
	}
	
	@Override
	public float getDestroySpeed(ItemStack stack, BlockState state) 
	{
		for(int k = 0; k < m.length; k++)
		{
			if((state.getMaterial() == m[k] | state.getBlock().isToolEffective(state, ToolType.SHOVEL) | state.getBlock().isToolEffective(state, ToolType.PICKAXE)) && !(stack.getDamage() >= stack.getMaxDamage() - 1))
			{
				return EFF;
			}
		}
		return -1.0F;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity entityLiving)
	{
	  if (!world.isRemote) 
	  {
	    if(getDestroySpeed(stack, state) != -1.0F)
	    {
	      float pitch = entityLiving.rotationPitch;
	      Direction o = entityLiving.getHorizontalFacing();
	      int i = pos.getX();
	      int j = pos.getY();
	      int k = pos.getZ();
	      if((pitch > 45.0f && pitch <= 90.0f) | (pitch < -45.0f && pitch >= -90.0f))
	      {
	        for (int i1 = i + 1; i1 >= i - 1; i1--) {
	          for (int k1 = k + 1; k1 >= k - 1; k1--) {
	            if ((world.getBlockState(new BlockPos(i1, j, k1)).getBlock() != Blocks.BEDROCK) && getDestroySpeed(stack, world.getBlockState(new BlockPos(i1, j, k1))) != -1.0F)
	            {
	              world.destroyBlock(new BlockPos(i1, j, k1), true);
	            }
	          }
	        }
	      }
	      else if (o.getIndex() == 5 && (pitch <= 45.0f || pitch > 90.0f) | (pitch < -45.0f && pitch >= -90.0f))
	      {
	            for (int j1 = j + 1; j1 >= j - 1; j1--) {
	              for (int k1 = k + 1; k1 >= k - 1; k1--) {
	                if ((world.getBlockState(new BlockPos(i, j1, k1)).getBlock() != Blocks.BEDROCK) && getDestroySpeed(stack, world.getBlockState(new BlockPos(i, j1, k1))) != -1.0F)
	                {
	                  world.destroyBlock(new BlockPos(i, j1, k1), true);
	                }
	              }
	            }
	      }
	      else if (o.getIndex() == 4 && (pitch <= 45.0f || pitch > 90.0f) | (pitch < -45.0f && pitch >= -90.0f))
	          {
	            for (int j1 = j + 1; j1 >= j - 1; j1--) {
	              for (int k1 = k + 1; k1 >= k - 1; k1--) {
	                if ((world.getBlockState(new BlockPos(i, j1, k1)).getBlock() != Blocks.BEDROCK) && getDestroySpeed(stack, world.getBlockState(new BlockPos(i, j1, k1))) != -1.0F)
	                {
	                  world.destroyBlock(new BlockPos(i, j1, k1), true);
	                }
	              }
	            }
	          }
	      else if (o.getIndex() == 3 && (pitch <= 45.0f || pitch > 90.0f) | (pitch < -45.0f && pitch >= -90.0f))
	      {
	            for (int i1 = i - 1; i1 <= i + 1; i1++) {
	              for (int j1 = j + 1; j1 >= j - 1; j1--) {
	                if ((world.getBlockState(new BlockPos(i1, j1, k)).getBlock() != Blocks.BEDROCK) && getDestroySpeed(stack, world.getBlockState(new BlockPos(i1, j1, k))) != -1.0F)
	                {
	                  world.destroyBlock(new BlockPos(i1, j1, k), true);
	                }
	              }
	            }
	      }
	      else if (o.getIndex() == 2 && (pitch <= 45.0f || pitch > 90.0f) | (pitch < -45.0f && pitch >= -90.0f))
	      {
	            for (int i1 = i - 1; i1 <= i + 1; i1++) {
	              for (int j1 = j + 1; j1 >= j - 1; j1--) {
	                if ((world.getBlockState(new BlockPos(i1, j1, k)).getBlock() != Blocks.BEDROCK) && getDestroySpeed(stack, world.getBlockState(new BlockPos(i1, j1, k))) != -1.0F)
	                {
	                  world.destroyBlock(new BlockPos(i1, j1, k), true);
	                }
	              }
	            }
	          }
	      if(!(stack.getDamage() >= stack.getMaxDamage() - 1)) 
		  {
	    	  stack.damageItem(1, entityLiving, null);
		  } 
		  }
	  }
	  return true;
	 }
}
