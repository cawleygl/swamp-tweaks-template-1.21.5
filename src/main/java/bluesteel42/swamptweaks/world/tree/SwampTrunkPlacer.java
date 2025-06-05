package bluesteel42.swamptweaks.world.tree;

import com.google.common.collect.Lists;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class SwampTrunkPlacer extends TrunkPlacer {
    // Use the fillTrunkPlacerFields to create our codec
    public static final MapCodec<SwampTrunkPlacer> CODEC = RecordCodecBuilder.mapCodec(
            instance -> fillTrunkPlacerFields(instance)
                    .<IntProvider, IntProvider, IntProvider, IntProvider, IntProvider>and(
                            instance.group(
                                    IntProvider.POSITIVE_CODEC.fieldOf("lower_diverge_point").forGetter((SwampTrunkPlacer trunkPlacer) -> trunkPlacer.lowerDivergePoint),
                                    IntProvider.POSITIVE_CODEC.fieldOf("upper_diverge_point").forGetter((SwampTrunkPlacer trunkPlacer) -> trunkPlacer.upperDivergePoint),
                                    IntProvider.POSITIVE_CODEC.fieldOf("lower_branch_steps").forGetter((SwampTrunkPlacer trunkPlacer) -> trunkPlacer.lowerBranchSteps),
                                    IntProvider.POSITIVE_CODEC.fieldOf("lower_number_of_branches").forGetter((SwampTrunkPlacer trunkPlacer) -> trunkPlacer.lowerNumberOfBranches),
                                    IntProvider.POSITIVE_CODEC.fieldOf("upper_number_of_branches").forGetter((SwampTrunkPlacer trunkPlacer) -> trunkPlacer.upperNumberOfBranches)
                            )
                    )
                    .apply(instance, SwampTrunkPlacer::new)
    );

    private final IntProvider lowerDivergePoint;
    private final IntProvider upperDivergePoint;
    private final IntProvider lowerBranchSteps;
    private final IntProvider lowerNumberOfBranches;
    private final IntProvider upperNumberOfBranches;

    public SwampTrunkPlacer(
            int baseHeight,
            int firstRandomHeight,
            int secondRandomHeight,
            IntProvider lowerDivergePoint,
            IntProvider upperDivergePoint,
            IntProvider lowerBranchSteps,
            IntProvider lowerNumberOfBranches,
            IntProvider upperNumberOfBranches
    ) {
        super(baseHeight, firstRandomHeight, secondRandomHeight);
        this.lowerDivergePoint = lowerDivergePoint;
        this.upperDivergePoint = upperDivergePoint;
        this.lowerBranchSteps = lowerBranchSteps;
        this.lowerNumberOfBranches = lowerNumberOfBranches;
        this.upperNumberOfBranches = upperNumberOfBranches;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return ModTreeBuilders.SWAMP_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(
            TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config
    ) {
        List<FoliagePlacer.TreeNode> list = Lists.<FoliagePlacer.TreeNode>newArrayList();
        setToDirt(world, replacer, random, startPos.down(), config);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int diverge1 = this.lowerDivergePoint.get(random);
        int diverge2 = this.upperDivergePoint.get(random);

        for (int i = 0; i < height; i++) {
            if (i == diverge1) {
                int j = startPos.getY() + i;

                if (this.getAndSetState(world, replacer, random, new BlockPos(startPos.getX(), j, startPos.getZ()), config)) {
                    List<Direction> xDirections = Direction.Type.HORIZONTAL.getShuffled(random);
                    for (int k = 0; k < this.lowerNumberOfBranches.get(random); k++) {
                        this.generateLowerBranches(world, replacer, random, height - diverge1, config, list, new BlockPos.Mutable().set(startPos.getX(), j, startPos.getZ()), j, xDirections.get(k), this.lowerBranchSteps.get(random));
                    }
                }
            } else if (i == diverge2) {
                int j = startPos.getY() + i;

                if (this.getAndSetState(world, replacer, random, new BlockPos(startPos.getX(), j, startPos.getZ()), config)) {
                    List<Direction> xDirections = Direction.Type.HORIZONTAL.getShuffled(random);
                    for (int k = 0; k < this.upperNumberOfBranches.get(random); k++) {
                        this.generateUpperBranches(world, replacer, random, height - diverge2, config, list, new BlockPos.Mutable().set(startPos.getX(), j, startPos.getZ()), j, xDirections.get(k));
                    }
                }
            } else {
                this.getAndSetState(world, replacer, random, startPos.up(i), config);
            }
        }

        list.add(new FoliagePlacer.TreeNode(mutable.set(startPos.getX(), startPos.getY() + height + 1, startPos.getZ()), 0, false));

        return list;
    }

    private void generateLowerBranches(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            int remainingHeight,
            TreeFeatureConfig config,
            List<FoliagePlacer.TreeNode> nodes,
            BlockPos.Mutable pos,
            int yOffset,
            Direction direction,
            int steps
    ) {
        int i = 0;
        int j = pos.getX();
        int k = pos.getZ();
        int l = 0;

        while (l < remainingHeight && steps > 0) {

            int m = yOffset + l;
            j += direction.getOffsetX();
            k += direction.getOffsetZ();
            i = m;
            if (this.getAndSetState(world, replacer, random, pos.set(j, m, k), config)) {
                i = m + 1;
            }

            l++;
            steps--;
        }

        BlockPos blockPos = new BlockPos(j, i, k);
        nodes.add(new FoliagePlacer.TreeNode(blockPos, 0, false));

    }

    private void generateUpperBranches(
            TestableWorld world,
            BiConsumer<BlockPos, BlockState> replacer,
            Random random,
            int remainingHeight,
            TreeFeatureConfig config,
            List<FoliagePlacer.TreeNode> nodes,
            BlockPos.Mutable pos,
            int yOffset,
            Direction direction
    ) {
        int i = 0;
        int j = pos.getX();
        int k = pos.getZ();
        int l = 0;

        while (l < remainingHeight) {

            int m = yOffset + l;
            j += direction.getOffsetX();
            k += direction.getOffsetZ();
            i = m;
            if (this.getAndSetState(world, replacer, random, pos.set(j, m, k), config)) {
                i = m + 1;
            }

            l++;
        }

        BlockPos blockPos = new BlockPos(j, i, k);
        nodes.add(new FoliagePlacer.TreeNode(blockPos, 0, false));

    }

}
