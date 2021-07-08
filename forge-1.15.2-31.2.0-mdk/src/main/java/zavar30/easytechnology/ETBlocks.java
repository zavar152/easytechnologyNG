package zavar30.easytechnology;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import zavar30.easytechnology.blocks.BlockBoeryllium;
import zavar30.easytechnology.blocks.BlockBoerylliumOre;
import zavar30.easytechnology.blocks.BlockOrerylliumOre;

@EventBusSubscriber(modid = EasyTechnology.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ETBlocks 
{
	public static Block oreryllium_ore_block, boeryllium_ore_block, boeryllium_block;//, lit_double_furnace_block;
	
	@SubscribeEvent
	public static void registerBlocks(Register<Block> event)
	{
		event.getRegistry().registerAll(
				oreryllium_ore_block = new BlockOrerylliumOre().setRegistryName(EasyTechnology.MODID, "oreryllium_ore_block"),
				boeryllium_ore_block = new BlockBoerylliumOre().setRegistryName(EasyTechnology.MODID, "boeryllium_ore_block"),
				boeryllium_block = new BlockBoeryllium().setRegistryName(EasyTechnology.MODID, "boeryllium_block")
				);
		
	}
}
