package zavar30.easytechnology.util.world;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig.FillerBlockType;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import zavar30.easytechnology.ETBlocks;

public class ETGenerator 
{
	private static void addOre(BlockState state, int maxSize, int minY, int maxY, int chunkOccurence)
	{
		OreFeatureConfig cfg = new OreFeatureConfig(FillerBlockType.NATURAL_STONE, state, maxSize);
		ConfiguredFeature<?, ?> feature = new ConfiguredFeature<>(Feature.ORE, cfg)
				.withPlacement(
						new ConfiguredPlacement<>(Placement.COUNT_RANGE, new CountRangeConfig(chunkOccurence, minY, minY, maxY))
				);
		
		for(Biome biome : ForgeRegistries.BIOMES)
		{
			biome.addFeature(Decoration.UNDERGROUND_ORES, feature);
		}
	}

	public static void setupGenerator() 
	{
		addOre(ETBlocks.boeryllium_ore_block.getDefaultState(), 10, 48, 64, 4 + new Random().nextInt(4));
		addOre(ETBlocks.oreryllium_ore_block.getDefaultState(), 5, 32, 48, 2 + new Random().nextInt(2));
	}
}
