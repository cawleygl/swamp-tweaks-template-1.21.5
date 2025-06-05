package bluesteel42.swamptweaks.world.tree;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator SWAMP = new SaplingGenerator(
            SwampTweaks.MOD_ID + ":swamp",
            0.1F,
            Optional.empty(),
            Optional.empty(),
            Optional.of(TreeConfiguredFeatures.SWAMP_OAK),
            Optional.of(ModConfiguredFeatures.SWAMP_WILLOW_KEY),
            Optional.empty(),
            Optional.empty());
}
