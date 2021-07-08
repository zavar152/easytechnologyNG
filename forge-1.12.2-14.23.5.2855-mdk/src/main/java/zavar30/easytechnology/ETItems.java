package zavar30.easytechnology;

import java.util.Set;

import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import zavar30.easytechnology.items.BoerItem;
import zavar30.easytechnology.items.BoerylliumArmorItem;
import zavar30.easytechnology.items.BoerylliumAxeItem;
import zavar30.easytechnology.items.BoerylliumHoeItem;
import zavar30.easytechnology.items.BoerylliumPickaxeItem;
import zavar30.easytechnology.items.BoerylliumSpadeItem;
import zavar30.easytechnology.items.BoerylliumSwordItem;
import zavar30.easytechnology.items.SeedItem;
import zavar30.easytechnology.items.SimpleItem;

public class ETItems
{
  public static BoerItem boer;
  public static SimpleItem boer_main, boer_case, boeryllium_ingot, boeryllium_ingot_raw, boer_controller, oreryllium_ingot, oreryllium_ingot_raw, machine_controller;
  public static SeedItem seed, seed_golden, pack, golden_pack;
  public static BoerylliumPickaxeItem boeryllium_pickaxe;
  public static BoerylliumSwordItem boeryllium_sword;
  public static BoerylliumSpadeItem boeryllium_spade; 
  public static BoerylliumAxeItem boeryllium_axe;
  public static BoerylliumHoeItem boeryllium_hoe;
  public static Item boeryllium_helmet, boeryllium_chestplate, boeryllium_leggings, boeryllium_boots;
  private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] {});
  private static ToolMaterial boerToolMaterial = EnumHelper.addToolMaterial("BOER", 3, 500, 15.0F, 0.0F, 0);
  private static ToolMaterial boerylliumToolMaterial = EnumHelper.addToolMaterial("boeryllium", 3, 1000, 10.0F, 7.0F, 5).setRepairItem(new ItemStack(ETItems.boeryllium_ingot));
  private static ArmorMaterial armorMaterial = EnumHelper.addArmorMaterial("boeryllium_armor", 
		  ETConstants.MODID + ":boeryllium_armor", 900, new int[]{2, 4, 6, 3}, 7, 
		  SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F).setRepairItem(new ItemStack(Item.getItemFromBlock(ETBlocks.boery_block)));
  
  public static void load()
  {
	  boer_main = new SimpleItem("boer_main").setCreativeTab(EasyTechnology.tab);
	  boer_case = new SimpleItem("boer_case").setCreativeTab(EasyTechnology.tab);
	  
	  boer = new BoerItem(-1.0F, -1.0F, boerToolMaterial, EFFECTIVE_ON, "boer").setCreativeTab(EasyTechnology.tab);
	  boer_controller = new SimpleItem("boer_controller").setCreativeTab(EasyTechnology.tab);
	  
	  boeryllium_ingot = new SimpleItem("boeryllium_ingot").setCreativeTab(EasyTechnology.tab);
	  boeryllium_ingot_raw = new SimpleItem("boeryllium_ingot_raw").setCreativeTab(EasyTechnology.tab);
	  
	  boeryllium_pickaxe = new BoerylliumPickaxeItem(boerylliumToolMaterial, "boeryllium_pickaxe").setCreativeTab(EasyTechnology.tab);
	  boeryllium_sword = new BoerylliumSwordItem(boerylliumToolMaterial, "boeryllium_sword").setCreativeTab(EasyTechnology.tab);
	  boeryllium_spade = new BoerylliumSpadeItem(boerylliumToolMaterial, "boeryllium_spade").setCreativeTab(EasyTechnology.tab);
	  boeryllium_axe = new BoerylliumAxeItem(boerylliumToolMaterial, "boeryllium_axe").setCreativeTab(EasyTechnology.tab);
	  boeryllium_hoe = new BoerylliumHoeItem(boerylliumToolMaterial, "boeryllium_hoe").setCreativeTab(EasyTechnology.tab);
	  
	  seed = new SeedItem("seed", 1, 1, false).setCreativeTab(EasyTechnology.tab);
	  seed_golden = new SeedItem("seed_golden", 3, 5, false).setCreativeTab(EasyTechnology.tab);
	  pack = new SeedItem("simple_pack", 5, 5, false).setCreativeTab(EasyTechnology.tab);
	  golden_pack = new SeedItem("golden_pack", 7, 7, false).setCreativeTab(EasyTechnology.tab).setEffect(21, 3000, 10);
	  
	  boeryllium_boots = new BoerylliumArmorItem("boeryllium_boots", armorMaterial, 1, EntityEquipmentSlot.FEET).setCreativeTab(EasyTechnology.tab);
      boeryllium_leggings = new BoerylliumArmorItem("boeryllium_leggings", armorMaterial, 2, EntityEquipmentSlot.LEGS).setCreativeTab(EasyTechnology.tab);
      boeryllium_chestplate = new BoerylliumArmorItem("boeryllium_chestplate", armorMaterial, 1, EntityEquipmentSlot.CHEST).setCreativeTab(EasyTechnology.tab);
      boeryllium_helmet = new BoerylliumArmorItem("boeryllium_helmet", armorMaterial, 1, EntityEquipmentSlot.HEAD).setCreativeTab(EasyTechnology.tab);
      
	  oreryllium_ingot = new SimpleItem("oreryllium_ingot").setCreativeTab(EasyTechnology.tab);
	  oreryllium_ingot_raw = new SimpleItem("oreryllium_ingot_raw").setCreativeTab(EasyTechnology.tab);
	  
	  machine_controller = new SimpleItem("machine_controller").setCreativeTab(EasyTechnology.tab);
  }
}
