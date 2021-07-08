package zavar30.easytechnology;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import zavar30.easytechnology.items.ItemBoer;
import zavar30.easytechnology.util.material.ETMaterials;

@EventBusSubscriber(modid = EasyTechnology.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ETItems
{
	public static Item boer, boer_main, boer_case, boeryllium_ingot, boeryllium_ingot_raw, boer_controller, oreryllium_ingot, oreryllium_ingot_raw, machine_controller,
						boeryllium_helmet, boeryllium_chestplate, boeryllium_leggings, boeryllium_boots, oreryllium_ore_block, boeryllium_ore_block, 
						boeryllium_block, boeryllium_sword, boeryllium_pickaxe, boeryllium_axe, boeryllium_spade, double_furnace_block;
	
    @SubscribeEvent
    public static void registerItems(Register<Item> event) 
    {
    	event.getRegistry().registerAll(
    			boer = new ItemBoer().setRegistryName(EasyTechnology.MODID, "boer"),
    			
    			boer_main = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boer_main"),
    	    	boer_case = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boer_case"),
    	    	boer_controller = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boer_controller"),
    	    	machine_controller = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "machine_controller"),
    			
    			boeryllium_ingot = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_ingot"),
    			boeryllium_ingot_raw = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_ingot_raw"),
    			oreryllium_ingot = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "oreryllium_ingot"),
    			oreryllium_ingot_raw = new Item(new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "oreryllium_ingot_raw"),
    			
    			boeryllium_helmet = new ArmorItem(ETMaterials.boerylliumArmorMaterial, EquipmentSlotType.HEAD, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_helmet"),
    			boeryllium_chestplate = new ArmorItem(ETMaterials.boerylliumArmorMaterial, EquipmentSlotType.CHEST, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_chestplate"),
    			boeryllium_leggings = new ArmorItem(ETMaterials.boerylliumArmorMaterial, EquipmentSlotType.LEGS, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_leggings"),
    			boeryllium_boots = new ArmorItem(ETMaterials.boerylliumArmorMaterial, EquipmentSlotType.FEET, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_boots"),
    			
    			oreryllium_ore_block = new BlockItem(ETBlocks.oreryllium_ore_block, new Properties().group(EasyTechnology.tab)).setRegistryName(ETBlocks.oreryllium_ore_block.getRegistryName()),
    			boeryllium_ore_block = new BlockItem(ETBlocks.boeryllium_ore_block, new Properties().group(EasyTechnology.tab)).setRegistryName(ETBlocks.boeryllium_ore_block.getRegistryName()),
    			boeryllium_block = new BlockItem(ETBlocks.boeryllium_block, new Properties().group(EasyTechnology.tab)).setRegistryName(ETBlocks.boeryllium_block.getRegistryName()),
    			
    			boeryllium_sword = new SwordItem(ETMaterials.boerylliumTier, -1, 0, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_sword"),
    			boeryllium_pickaxe = new PickaxeItem(ETMaterials.boerylliumTier, -6, -2, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_pickaxe"),
    			boeryllium_spade = new ShovelItem(ETMaterials.boerylliumTier, -6, -2, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_spade"),
    			boeryllium_axe = new AxeItem(ETMaterials.boerylliumTier, 2, -2, new Properties().group(EasyTechnology.tab)).setRegistryName(EasyTechnology.MODID, "boeryllium_axe")
    			);
    }
}
