package zavar30.easytechnology.items;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import zavar30.easytechnology.EasyTechnology;

public class BoerylliumArmorItem extends ItemArmor
{
    public BoerylliumArmorItem(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
    {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        registerItem(name);
    } 
    
	private void registerItem(String name)
	{
      ForgeRegistries.ITEMS.register(this);
	  EasyTechnology.proxy.registerItemRenderer(this, 0, name);
	}
}
