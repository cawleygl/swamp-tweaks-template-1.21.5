package bluesteel42.swamptweaks.world.tree;

import bluesteel42.swamptweaks.SwampTweaks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class ModTreeBuilders {
    public static final TrunkPlacerType<SwampTrunkPlacer> SWAMP_TRUNK_PLACER =
            Registry.register(
                    Registries.TRUNK_PLACER_TYPE,
                    Identifier.of(SwampTweaks.MOD_ID, "swamp_trunk_placer"),
                    new TrunkPlacerType<>(SwampTrunkPlacer.CODEC)
            );

    public static void initialize() {

    }
}
