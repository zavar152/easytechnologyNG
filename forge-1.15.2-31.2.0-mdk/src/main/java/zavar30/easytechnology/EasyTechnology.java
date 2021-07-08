package zavar30.easytechnology;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import zavar30.easytechnology.util.world.ETGenerator;

@Mod("easytechnology")
public class EasyTechnology
{
	public static EasyTechnology mod;
	public static final String MODID = "easytechnology";
	private static final Logger logger = Logger.getLogger(MODID);
	
	public EasyTechnology()
	{
		mod = this;
		
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);
		
		
		MinecraftForge.EVENT_BUS.register(this);
	}
	
	private void setup(final FMLCommonSetupEvent event)
	{
		ETGenerator.setupGenerator();
		logger.info("EasyTechnology started!");
	}
	
	private void clientRegistries(final FMLClientSetupEvent event)
	{
		logger.info("EasyTechnology clientRegistries ready!");
	}
	
	public static ItemGroup tab = new ItemGroup("easytechnology")
	{
		@Override
		public ItemStack createIcon() 
		{
			return new ItemStack(ETItems.boer);
		}
		
		   @Override
		    public void fill(NonNullList<ItemStack> itemStacks)
		    {
		        List<Item> items = Arrays.asList(ETItems.boer, ETItems.boer_main, ETItems.boer_case,
		        		ETItems.boer_controller, ETItems.machine_controller, ETItems.boeryllium_ingot, ETItems.oreryllium_ingot,
		        		ETItems.boeryllium_ingot_raw, ETItems.oreryllium_ingot_raw, ETItems.boeryllium_helmet, ETItems.boeryllium_chestplate, 
		        		ETItems.boeryllium_leggings, ETItems.boeryllium_boots, ETItems.oreryllium_ore_block, ETItems.boeryllium_ore_block, 
		        		ETItems.boeryllium_block, ETItems.boeryllium_sword, ETItems.boeryllium_pickaxe, 
		        		ETItems.boeryllium_axe, ETItems.boeryllium_spade);
		        
		        itemStacks.clear();
		        
		        for (Item item : items)
		        {
		            if(item.getCreativeTabs().contains(tab))
		            {
		                itemStacks.add(new ItemStack(item));
		            }
		        }
		    }
		
	};
}
