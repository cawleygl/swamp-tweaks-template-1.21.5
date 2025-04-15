package bluesteel42.swamptweaks.mixin;

import bluesteel42.swamptweaks.block.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.WorldView;
import net.minecraft.world.chunk.light.ChunkLightProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.SnowyBlock.SNOWY;

@Mixin(SpreadableBlock.class)
public class SpreadableToMudBlocksMixin {
    @Unique
    private static boolean canSurvive(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        BlockState blockState = world.getBlockState(blockPos);
        if (blockState.isOf(Blocks.SNOW) && (Integer)blockState.get(SnowBlock.LAYERS) == 1) {
            return true;
        } else if (blockState.getFluidState().getLevel() == 8) {
            return false;
        } else {
            int i = ChunkLightProvider.getRealisticOpacity(state, blockState, Direction.UP, blockState.getOpacity());
            return i < 15;
        }
    }
    @Unique
    private static boolean canSpread(BlockState state, WorldView world, BlockPos pos) {
        BlockPos blockPos = pos.up();
        return canSurvive(state, world, pos) && !world.getFluidState(blockPos).isIn(FluidTags.WATER);
    }

    @Unique
    private static boolean isSnow(BlockState state) {
        return state.isIn(BlockTags.SNOW);
    }

    @Inject(method = "randomTick", at = @At("HEAD"), cancellable = true)
    private void injected(BlockState state, ServerWorld world, BlockPos pos, Random random, CallbackInfo ci) {
        SpreadableBlock thisObject = ((SpreadableBlock)(Object)this);
            if (!canSurvive(state, world, pos)) {
                if (state.isOf(ModBlocks.MUDDY_GRASS_BLOCK) || state.isOf(ModBlocks.MUDDY_MYCELIUM)) {
                    world.setBlockState(pos, Blocks.MUD.getDefaultState());
                } else {
                    world.setBlockState(pos, Blocks.DIRT.getDefaultState());
                }
            } else {
                if (world.getLightLevel(pos.up()) >= 9) {
                    for (int i = 0; i < 4; i++) {
                        BlockPos blockPos = pos.add(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                        if (canSpread(thisObject.getDefaultState(), world, blockPos)) {
                            if (world.getBlockState(blockPos).isOf(Blocks.DIRT)) {
                                if (state.isOf(ModBlocks.MUDDY_GRASS_BLOCK) || state.isOf(Blocks.GRASS_BLOCK)) {
                                    world.setBlockState(blockPos, Blocks.GRASS_BLOCK.getDefaultState().with(SNOWY, isSnow(world.getBlockState(blockPos.up()))));
                                }
                                else if (state.isOf(ModBlocks.MUDDY_MYCELIUM) || state.isOf(Blocks.MYCELIUM)) {
                                    world.setBlockState(blockPos, Blocks.MYCELIUM.getDefaultState().with(SNOWY, isSnow(world.getBlockState(blockPos.up()))));
                                }
                            } else if (world.getBlockState(blockPos).isOf(Blocks.MUD)) {
                                if (state.isOf(ModBlocks.MUDDY_GRASS_BLOCK) || state.isOf(Blocks.GRASS_BLOCK)) {
                                    world.setBlockState(blockPos, ModBlocks.MUDDY_GRASS_BLOCK.getDefaultState().with(SNOWY, isSnow(world.getBlockState(blockPos.up()))));
                                }
                                else if (state.isOf(ModBlocks.MUDDY_MYCELIUM) || state.isOf(Blocks.MYCELIUM)) {
                                    world.setBlockState(blockPos, ModBlocks.MUDDY_MYCELIUM.getDefaultState().with(SNOWY, isSnow(world.getBlockState(blockPos.up()))));
                                }
                            }

                        }
                    }
                }
            }
        ci.cancel();
    }
}
