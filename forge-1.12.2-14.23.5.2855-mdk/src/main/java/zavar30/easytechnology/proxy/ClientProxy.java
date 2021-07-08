package zavar30.easytechnology.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zavar30.easytechnology.ETConstants;
import zavar30.easytechnology.ETMobs;

public class ClientProxy extends CommonProxy
{
	public void preInit(FMLPreInitializationEvent event)
	{
	  ETMobs.registerRenderGopnik();
	  super.preInit(event);
	}
	
	public void init(FMLInitializationEvent event)
	{
	  super.init(event);
	}
	
	public void postInit(FMLPostInitializationEvent event)
	{
	  super.postInit(event);
	}
	
	public void registerItemRenderer(Item item, int meta, String id)
	{
	  ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(ETConstants.MODID + ":" + id, "inventory"));
	}
}

