package zavar30.easytechnology;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import zavar30.easytechnology.entity.gopnik.EntityGopnik;
import zavar30.easytechnology.entity.gopnik.RenderGopnik;

public class ETMobs 
{
	public static void load()
	{
		registerEntity(EntityGopnik.class, "gopnik", 228, 50, 1293823, 16056064);
	}
	
	private static void registerEntity(Class<? extends Entity> entityClass, String entityName, int id, int trackingRange, int eggPrimary, int eggSecondary)
	{
		EntityRegistry.registerModEntity(ETConstants.GOPNIK, entityClass, entityName, id, EasyTechnology.instance, trackingRange, 1, true, eggPrimary, eggSecondary);
		EntityRegistry.addSpawn(EntityGopnik.class, 10, 1, 3, EnumCreatureType.CREATURE, Biome.getBiome(4), Biome.getBiome(5), Biome.getBiome(35));
	}
	
	public static void registerRenderGopnik()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityGopnik.class, new IRenderFactory<EntityGopnik>()
		{
			@Override
			public Render<? super EntityGopnik> createRenderFor(RenderManager manager) 
			{
				return new RenderGopnik(manager);
			}			
		});
	}
}
