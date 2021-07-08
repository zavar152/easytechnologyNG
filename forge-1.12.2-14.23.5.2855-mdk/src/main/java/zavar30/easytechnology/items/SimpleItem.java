package zavar30.easytechnology.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class SimpleItem
extends Item
{

public SimpleItem(String name)
{
  setRegistryName(name);
  setUnlocalizedName(name);
  registerItem(name);
}

private void registerItem(String name)
{
  ForgeRegistries.ITEMS.register(this);
  EasyTechnology.proxy.registerItemRenderer(this, 0, name);
}

public SimpleItem setCreativeTab(CreativeTabs tab)
{
  super.setCreativeTab(tab);
  return this;
}
}