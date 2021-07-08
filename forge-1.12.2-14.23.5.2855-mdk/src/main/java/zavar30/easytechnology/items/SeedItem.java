package zavar30.easytechnology.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class SeedItem extends ItemFood
{
	private int id = -1;
	private int time = 0;
	private int a = 0;
	public SeedItem(String name, int amount, float saturation, boolean isWolfFood) 
	{
		super(amount, saturation, isWolfFood);
		setUnlocalizedName(name);
		setRegistryName(name);
		registerItem(name);
	}

	private void registerItem(String name)
	{
      ForgeRegistries.ITEMS.register(this);
	  EasyTechnology.proxy.registerItemRenderer(this, 0, name);
	}

	public SeedItem setCreativeTab(CreativeTabs tab)
	{
	  super.setCreativeTab(tab);
	  return this;
	}
	
	public SeedItem setEffect(int id, int time, int a)
	{
	  this.id = id;
	  this.time = time;
	  this.a = a;
	  return this;
	}
	
	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) 
	{
		if(id != -1)
		{
	        player.addPotionEffect(new PotionEffect(Potion.getPotionById(id), time, a));
		}
		super.onFoodEaten(stack, worldIn, player);
	}
}
