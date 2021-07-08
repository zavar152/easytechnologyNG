package zavar30.easytechnology.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumAxeItem extends ItemAxe
{
	public BoerylliumAxeItem(ToolMaterial material, String name)
	{
		super(material, 6.0F, -3.2F);
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setMaxStackSize(1);
		registerItem(name);
	}
	
	@Override
	public BoerylliumAxeItem setCreativeTab(CreativeTabs tab)
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
