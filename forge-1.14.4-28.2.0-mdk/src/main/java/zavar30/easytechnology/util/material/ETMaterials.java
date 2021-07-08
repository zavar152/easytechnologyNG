package zavar30.easytechnology.util.material;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import zavar30.easytechnology.ETItems;
import zavar30.easytechnology.EasyTechnology;

public class ETMaterials 
{
	public static IArmorMaterial boerylliumArmorMaterial = new IArmorMaterial() 
	{
		
		@Override
		public float getToughness() 					
		{
			return 2.0F;
		}
		
		@Override	
		public SoundEvent getSoundEvent() 
		{
			return SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND;
		}
		
		@Override
		public Ingredient getRepairMaterial() 
		{
			return Ingredient.fromStacks(new ItemStack(ETItems.boeryllium_ingot));
		}
		
		@Override
		public String getName() 
		{
			return EasyTechnology.MODID + ":boeryllium_armor";
		}
		
		@Override
		public int getEnchantability() 
		{
			return 7;
		}
		
		@Override
		public int getDurability(EquipmentSlotType arg0) 
		{
			return 900;
		}

		@Override
		public int getDamageReductionAmount(EquipmentSlotType arg0) 
		{
			return 2;
		}
	};
	
	public static IItemTier boerylliumTier = new IItemTier() {

		@Override
		public float getAttackDamage() 
		{
			return 8.0F;
		}

		@Override
		public float getEfficiency() 
		{
			return 5.0F;
		}

		@Override
		public int getEnchantability() 
		{
			return 4;
		}

		@Override
		public int getHarvestLevel() 
		{
			return 4;
		}

		@Override
		public int getMaxUses() 
		{
			return 1000;
		}

		@Override
		public Ingredient getRepairMaterial() 
		{
			return Ingredient.fromItems(ETItems.boeryllium_ingot);
		}
		
	};
	
	
}
