package bluesteel42.swamptweaks.world;

import bluesteel42.swamptweaks.SwampTweaks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightmapPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {

    public static final RegistryKey<PlacedFeature> SWAMP_MUD_PLACED_KEY = registerKey("swamp_mud");
    public static final RegistryKey<PlacedFeature> SWAMP_MUDDY_GRASS_PLACED_KEY = registerKey("swamp_muddy_grass");
    public static final RegistryKey<PlacedFeature> SWAMP_HUGE_MUSHROOMS_PLACED_KEY = registerKey("swamp_huge_mushrooms");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatures = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

        register(context, SWAMP_MUD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_MUD_KEY),
                ModPlacedFeaturesModifiers.modifiersWithCount(256,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(320))
                )
        );
        register(context, SWAMP_MUDDY_GRASS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SWAMP_MUDDY_GRASS_KEY),
                ModPlacedFeaturesModifiers.modifiersWithCount(256,
                        HeightRangePlacementModifier.uniform(YOffset.fixed(-64), YOffset.fixed(320))
                )
        );

        register(context, SWAMP_HUGE_MUSHROOMS_PLACED_KEY, configuredFeatures.getOrThrow(VegetationConfiguredFeatures.MUSHROOM_ISLAND_VEGETATION),
                ModPlacedFeaturesModifiers.modifiersWithRarity(6,
                        HeightmapPlacementModifier.of(Heightmap.Type.WORLD_SURFACE)
                )
        );
    }

    public static RegistryKey<PlacedFeature> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(SwampTweaks.MOD_ID, name));
    }

    private static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key,
                                                                                   RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                                                                   PlacementModifier... modifiers) {
        register(context, key, configuration, List.of(modifiers));
    }
}
