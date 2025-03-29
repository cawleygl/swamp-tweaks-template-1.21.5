package bluesteel42.swamptweaks.world;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_MUD_KEY = registerKey("swamp_mud");
    public static final RegistryKey<ConfiguredFeature<?, ?>> SWAMP_MUDDY_GRASS_KEY = registerKey("swamp_muddy_grass");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        register(context, SWAMP_MUD_KEY, Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.DIRT), Blocks.MUD.getDefaultState(), 55));
        register(context, SWAMP_MUDDY_GRASS_KEY, Feature.ORE, new OreFeatureConfig(new BlockMatchRuleTest(Blocks.GRASS_BLOCK), ModBlocks.MUDDY_GRASS_BLOCK.getDefaultState(), 55));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(SwampTweaks.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration ) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
