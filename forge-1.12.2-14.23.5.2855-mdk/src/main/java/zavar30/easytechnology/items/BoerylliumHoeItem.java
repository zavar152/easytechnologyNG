package zavar30.easytechnology.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumHoeItem extends ItemHoe
{
	public BoerylliumHoeItem(ToolMaterial material, String name)
	{
		super(material);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		registerItem(name);
	}
	
	@Override
	public BoerylliumHoeItem setCreativeTab(CreativeTabs tab)
	{
	  super.setCreativeTab(tab);
	  return this;
	}
	
	private void registerItem(String name)
	{
		ForgeRegistries.ITEMS.register(this);
	    EasyTechnology.proxy.registerItemRenderer(this, 0, name);
	}
}
