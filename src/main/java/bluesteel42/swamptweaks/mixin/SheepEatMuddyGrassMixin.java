package bluesteel42.swamptweaks.mixin;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.WorldEvents;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(EatGrassGoal.class)
public class SheepEatMuddyGrassMixin {
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfo ci) {
        EatGrassGoal thisObject = ((EatGrassGoal)(Object)this);
        TimerAccessor timerAccessor = (TimerAccessor) (Object) this;
        MobAccessor mobAccessor = (MobAccessor) (Object) this;
        WorldAccessor worldAccessor = (WorldAccessor) (Object) this;
        EDIBLE_PREDICATEAccessor edibleAccessor = (EDIBLE_PREDICATEAccessor) (Object) this;

        timerAccessor.setTimer(Math.max(0, timerAccessor.getTimer() - 1));
        if (timerAccessor.getTimer() == (thisObject.shouldRunEveryTick() ? 4 : MathHelper.ceilDiv(4, 2))) {
            BlockPos blockPos = mobAccessor.getMob().getBlockPos();
            BlockPos blockPosUp = blockPos.up();
            if (edibleAccessor.getEDIBLE_PREDICATE().test(worldAccessor.getWorld().getBlockState(blockPos))) {
                ServerWorld serverWorld = (ServerWorld) worldAccessor.getWorld();
                if (serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    worldAccessor.getWorld().breakBlock(blockPos, false);
                }
                mobAccessor.getMob().onEatingGrass();
            } else if (edibleAccessor.getEDIBLE_PREDICATE().test(worldAccessor.getWorld().getBlockState(blockPosUp))) {
                ServerWorld serverWorld = (ServerWorld) worldAccessor.getWorld();
                if (serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                    worldAccessor.getWorld().breakBlock(blockPosUp, false);
                }
                mobAccessor.getMob().onEatingGrass();
            } else {
                BlockPos blockPos2 = blockPos.down();
                if (worldAccessor.getWorld().getBlockState(blockPos2).isOf(Blocks.GRASS_BLOCK)) {
                    ServerWorld serverWorld = (ServerWorld) worldAccessor.getWorld();
                    if (serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        worldAccessor.getWorld().syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos2, Block.getRawIdFromState(Blocks.GRASS_BLOCK.getDefaultState()));
                        worldAccessor.getWorld().setBlockState(blockPos2, Blocks.DIRT.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                    mobAccessor.getMob().onEatingGrass();
                }
                else if (worldAccessor.getWorld().getBlockState(blockPos).isOf(ModBlocks.MUDDY_GRASS_BLOCK)) {
                    ServerWorld serverWorld = (ServerWorld) worldAccessor.getWorld();
                    if (serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) {
                        worldAccessor.getWorld().syncWorldEvent(WorldEvents.BLOCK_BROKEN, blockPos, Block.getRawIdFromState(ModBlocks.MUDDY_GRASS_BLOCK.getDefaultState()));
                        worldAccessor.getWorld().setBlockState(blockPos, Blocks.MUD.getDefaultState(), Block.NOTIFY_LISTENERS);
                    }
                    mobAccessor.getMob().onEatingGrass();
                }
            }
        }
        ci.cancel();
    }
    @Inject(method = "canStart", at = @At("HEAD"), cancellable = true)
    private void injected(CallbackInfoReturnable<Boolean> cir) {
        MobAccessor mobAccessor = (MobAccessor) (Object) this;
        WorldAccessor worldAccessor = (WorldAccessor) (Object) this;
        EDIBLE_PREDICATEAccessor edibleAccessor = (EDIBLE_PREDICATEAccessor) (Object) this;

        if (mobAccessor.getMob().getRandom().nextInt(mobAccessor.getMob().isBaby() ? 50 : 1000) != 0) {
            cir.setReturnValue(false);
            cir.cancel();
        } else {
            BlockPos blockPos = mobAccessor.getMob().getBlockPos();
            cir.setReturnValue(
                    edibleAccessor.getEDIBLE_PREDICATE().test(worldAccessor.getWorld().getBlockState(blockPos)) ||
                            worldAccessor.getWorld().getBlockState(blockPos.down()).isOf(Blocks.GRASS_BLOCK) ||
                            worldAccessor.getWorld().getBlockState(blockPos).isOf(ModBlocks.MUDDY_GRASS_BLOCK));
            cir.cancel();
        }
        cir.cancel();
    }
}
