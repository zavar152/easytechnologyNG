package zavar30.easytechnology.items;

import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumPickaxeItem extends ItemPickaxe
{
	public BoerylliumPickaxeItem(ToolMaterial material, String name)
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		this.attackDamage = 1.0F;
		this.attackSpeed = -2.8F;
		registerItem(name);
	}
	
	@Override
	public BoerylliumPickaxeItem setCreativeTab(CreativeTabs tab)
	{
	  super.setCreativeTab(tab);
	  return this;
	}
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving) 
	{
		if (!worldIn.isRemote) 
		{
			if(stack.canHarvestBlock(state))
			{
				stack.damageItem(1, entityLiving);
			}
			else
			{
				stack.damageItem(2, entityLiving);
			}
		}
		return true;
	}
	
	private void registerItem(String name)
	{
		ForgeRegistries.ITEMS.register(this);
	    EasyTechnology.proxy.registerItemRenderer(this, 0, name);
	}
}
