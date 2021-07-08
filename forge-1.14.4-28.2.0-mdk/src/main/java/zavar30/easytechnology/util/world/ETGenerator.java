package zavar30.easytechnology.util.world;

import java.util.Random;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import zavar30.easytechnology.ETBlocks;

public class ETGenerator 
{
	public static void setupGenerator()
	{
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ETBlocks.boeryllium_ore_block.getDefaultState(), 10), Placement.COUNT_RANGE, new CountRangeConfig(4 + new Random().nextInt(4), 16, 48, 64)));
			biome.addFeature(Decoration.UNDERGROUND_ORES, Biome.createDecoratedFeature(Feature.ORE, new OreFeatureConfig(FillerBlockType.NATURAL_STONE, ETBlocks.oreryllium_ore_block.getDefaultState(), 5), Placement.COUNT_RANGE, new CountRangeConfig(2 + new Random().nextInt(2), 8, 32, 48)));
		}
	}
}
