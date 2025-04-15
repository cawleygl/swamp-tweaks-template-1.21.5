package bluesteel42.swamptweaks.world;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.block.ModBlocks;
import com.google.common.collect.ImmutableList;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.treedecorator.AttachedToLogsTreeDecorator;

import java.util.List;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_MUD_KEY = registerKey("swamp_mud");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_MUDDY_GRASS_KEY = registerKey("swamp_muddy_grass");
    public static final RegistryKey<ConfiguredFeature<?, ?>> FALLEN_SWAMP_TREE_KEY = registerKey("fallen_swamp_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_SWAMP_KEY = registerKey("trees_swamp");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, SWAMP_MUD_KEY, Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.DIRT), Blocks.MUD.getDefaultState(), 55));
        register(context, SWAMP_MUDDY_GRASS_KEY, Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), ModBlocks.MUDDY_GRASS_BLOCK.getDefaultState(), 55));

        register(context, FALLEN_SWAMP_TREE_KEY, Feature.FALLEN_TREE, new FallenTreeFeatureConfig.Builder(BlockStateProvider.of(ModBlocks.SWAMP_LOG), UniformIntProvider.create(5, 8))
                .logDecorators(
                        ImmutableList.of(
                                new AttachedToLogsTreeDecorator(
                                        0.5F,
                                        new WeightedBlockStateProvider(Pool.<BlockState>builder().add(Blocks.RED_MUSHROOM.getDefaultState(), 1).add(Blocks.BROWN_MUSHROOM.getDefaultState(), 2)),
                                        List.of(Direction.UP)
                                )
                        )
                ).build());

        register(context, TREES_SWAMP_KEY, Feature.RANDOM_SELECTOR, new RandomFeatureConfig(List.of(
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SWAMP_HUGE_RED_MUSHROOM_PLACED_KEY), 0.05F),
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SWAMP_HUGE_BROWN_MUSHROOM_PLACED_KEY), 0.05F),
            new RandomFeatureEntry(context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.FALLEN_SWAMP_TREE_PLACED_KEY), 0.0125F)
        ),
                context.getRegistryLookup(RegistryKeys.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.SWAMP_TREE_PLACED_KEY)
        ));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SwampTweaks.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
