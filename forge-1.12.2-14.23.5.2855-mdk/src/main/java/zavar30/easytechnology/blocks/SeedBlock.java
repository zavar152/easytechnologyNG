package zavar30.easytechnology.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class SeedBlock extends Block
{
	public SeedBlock(String name)
	{
		super(Material.PLANTS);
		setRegistryName(name);
		setUnlocalizedName(name);
        setHardness(0.2F);
        setLightOpacity(1);
        setSoundType(SoundType.PLANT);
		register();
		registerRender(name);
	}
	
	public SeedBlock setCreativeTab(CreativeTabs tab)
	{
		super.setCreativeTab(tab);
		return this;
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
