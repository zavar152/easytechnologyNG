package zavar30.easytechnology.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.ETItems;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumOreBlock extends Block
{
	public BoerylliumOreBlock(String name) 
	{
		super(Material.IRON);
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(3.0F);
		setHarvestLevel("pickaxe", 2);
		setResistance(5.0F);
        setLightOpacity(1);
        setSoundType(SoundType.STONE);
		register();
		registerRender(name);
	}

	public BoerylliumOreBlock setCreativeTab(CreativeTabs tab)
	{
		super.setCreativeTab(tab);
		return this;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune) 
	{
		return ETItems.boeryllium_ingot_raw;
	}
	
	private void register()
	{
		 ForgeRegistries.BLOCKS.register(this);
	     ForgeRegistries.ITEMS.register(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	private void registerRender(String name)
	{
		EasyTechnology.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, name);
	}
}
