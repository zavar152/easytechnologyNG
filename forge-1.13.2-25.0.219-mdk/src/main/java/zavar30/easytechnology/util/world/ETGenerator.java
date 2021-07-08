package zavar30.easytechnology.util.world;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;
import zavar30.easytechnology.ETBlocks;

public class ETGenerator 
{
	public static void setupGenerator()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, ETBlocks.boeryllium_ore_block.getDefaultState(), 10), new CountRange(), new CountRangeConfig(4 + new Random().nextInt(4), 16, 48, 64)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, new CompositeFeature<>(Feature.MINABLE, new MinableConfig(MinableConfig.IS_ROCK, ETBlocks.oreryllium_ore_block.getDefaultState(), 5), new CountRange(), new CountRangeConfig(2 + new Random().nextInt(2), 8, 32, 48)));
		}
	}
}
