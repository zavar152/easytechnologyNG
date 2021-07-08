package zavar30.easytechnology.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumSpadeItem extends ItemSpade
{
	public BoerylliumSpadeItem(ToolMaterial material, String name)
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
	public BoerylliumSpadeItem setCreativeTab(CreativeTabs tab)
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
