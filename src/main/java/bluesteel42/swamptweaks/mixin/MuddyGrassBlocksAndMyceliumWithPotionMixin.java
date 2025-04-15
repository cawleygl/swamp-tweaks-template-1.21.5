package bluesteel42.swamptweaks.mixin;

import bluesteel42.swamptweaks.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PotionItem.class)
public class MuddyGrassBlocksAndMyceliumWithPotionMixin {
	@Inject(method = "useOnBlock", at = @At("HEAD"), cancellable = true)
	private void injected(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cir) {
		World world = context.getWorld();
		BlockPos blockPos = context.getBlockPos();
		PlayerEntity playerEntity = context.getPlayer();
		ItemStack itemStack = context.getStack();
		PotionContentsComponent potionContentsComponent = itemStack.getOrDefault(DataComponentTypes.POTION_CONTENTS, PotionContentsComponent.DEFAULT);
		BlockState blockState = world.getBlockState(blockPos);
		if (context.getSide() != Direction.DOWN && context.getSide() != Direction.UP && blockState.isOf(Blocks.GRASS_BLOCK) && potionContentsComponent.matches(Potions.WATER)) {
			world.playSound(null, blockPos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
			playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
			playerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
			if (!world.isClient) {
				ServerWorld serverWorld = (ServerWorld) world;

				for (int i = 0; i < 5; i++) {
					serverWorld.spawnParticles(
							ParticleTypes.SPLASH,
							blockPos.getX() + world.random.nextDouble(),
							blockPos.getY() + 1,
							blockPos.getZ() + world.random.nextDouble(),
							1,
							0.0,
							0.0,
							0.0,
							1.0
					);
				}
			}
			world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);
			world.setBlockState(blockPos, ModBlocks.MUDDY_GRASS_BLOCK.getDefaultState());
			cir.setReturnValue(ActionResult.SUCCESS);
			cir.cancel();
		}
		if (context.getSide() != Direction.DOWN && context.getSide() != Direction.UP && blockState.isOf(Blocks.MYCELIUM) && potionContentsComponent.matches(Potions.WATER)) {
			world.playSound(null, blockPos, SoundEvents.ENTITY_GENERIC_SPLASH, SoundCategory.BLOCKS, 1.0F, 1.0F);
			playerEntity.setStackInHand(context.getHand(), ItemUsage.exchangeStack(itemStack, playerEntity, new ItemStack(Items.GLASS_BOTTLE)));
			playerEntity.incrementStat(Stats.USED.getOrCreateStat(itemStack.getItem()));
			if (!world.isClient) {
				ServerWorld serverWorld = (ServerWorld) world;

				for (int i = 0; i < 5; i++) {
					serverWorld.spawnParticles(
							ParticleTypes.SPLASH,
							blockPos.getX() + world.random.nextDouble(),
							blockPos.getY() + 1,
							blockPos.getZ() + world.random.nextDouble(),
							1,
							0.0,
							0.0,
							0.0,
							1.0
					);
				}
			}
			world.playSound(null, blockPos, SoundEvents.ITEM_BOTTLE_EMPTY, SoundCategory.BLOCKS, 1.0F, 1.0F);
			world.emitGameEvent(null, GameEvent.FLUID_PLACE, blockPos);
			world.setBlockState(blockPos, ModBlocks.MUDDY_MYCELIUM.getDefaultState());
			cir.setReturnValue(ActionResult.SUCCESS);
			cir.cancel();
		}
	}
}

