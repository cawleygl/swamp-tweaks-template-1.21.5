package bluesteel42.swamptweaks.mixin;

import bluesteel42.swamptweaks.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.enums.StairShape;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.mob.WitchEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.structure.ShiftableStructurePiece;
import net.minecraft.structure.StructurePieceType;
import net.minecraft.structure.SwampHutGenerator;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SwampHutGenerator.class)
public class SwampWoodHutMixin extends ShiftableStructurePiece {
	protected SwampWoodHutMixin(StructurePieceType type, int x, int y, int z, int width, int height, int depth, Direction orientation) {
		super(type, x, y, z, width, height, depth, orientation);
	}

	@Inject(method = "generate", at = @At("HEAD"), cancellable = true)
	private void injected(StructureWorldAccess world,
						  StructureAccessor structureAccessor,
						  ChunkGenerator chunkGenerator,
						  Random random,
						  BlockBox chunkBox,
						  ChunkPos chunkPos,
						  BlockPos pivot,
						  CallbackInfo ci
	) {

		if (this.adjustToAverageHeight(world, chunkBox, 0)) {
			this.fillWithOutline(world, chunkBox, 1, 1, 1, 5, 1, 7, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 2, 5, 3, 4, 5, 6, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 2, 1, 0, 4, 1, 0, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 2, 2, 2, 4, 4, 2, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 1, 2, 3, 1, 4, 6, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 5, 2, 3, 5, 4, 6, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 2, 2, 7, 4, 4, 7, ModBlocks.SWAMP_PLANKS.getDefaultState(), ModBlocks.SWAMP_PLANKS.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 1, 0, 2, 1, 4, 2, ModBlocks.SWAMP_LOG.getDefaultState(), ModBlocks.SWAMP_LOG.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 5, 0, 2, 5, 4, 2, ModBlocks.SWAMP_LOG.getDefaultState(), ModBlocks.SWAMP_LOG.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 1, 0, 7, 1, 4, 7, ModBlocks.SWAMP_LOG.getDefaultState(), ModBlocks.SWAMP_LOG.getDefaultState(), false);
			this.fillWithOutline(world, chunkBox, 5, 0, 7, 5, 4, 7, ModBlocks.SWAMP_LOG.getDefaultState(), ModBlocks.SWAMP_LOG.getDefaultState(), false);
			this.addBlock(world, Blocks.AIR.getDefaultState(), 4, 2, 2, chunkBox);
			this.addBlock(world, Blocks.AIR.getDefaultState(), 4, 3, 2, chunkBox);
			this.addBlock(world, Blocks.AIR.getDefaultState(), 1, 3, 4, chunkBox);
			this.addBlock(world, Blocks.AIR.getDefaultState(), 5, 3, 4, chunkBox);
			this.addBlock(world, Blocks.AIR.getDefaultState(), 5, 3, 5, chunkBox);
			this.addBlock(world, Blocks.POTTED_RED_MUSHROOM.getDefaultState(), 1, 3, 5, chunkBox);
			this.addBlock(world, Blocks.CRAFTING_TABLE.getDefaultState(), 3, 2, 6, chunkBox);
			this.addBlock(world, Blocks.CAULDRON.getDefaultState(), 4, 2, 6, chunkBox);
			BlockState blockState = ModBlocks.SWAMP_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.NORTH);
			BlockState blockState2 = ModBlocks.SWAMP_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.EAST);
			BlockState blockState3 = ModBlocks.SWAMP_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.WEST);
			BlockState blockState4 = ModBlocks.SWAMP_STAIRS.getDefaultState().with(StairsBlock.FACING, Direction.SOUTH);
			this.fillWithOutline(world, chunkBox, 0, 4, 1, 6, 4, 1, blockState, blockState, false);
			this.fillWithOutline(world, chunkBox, 0, 4, 2, 0, 4, 7, blockState2, blockState2, false);
			this.fillWithOutline(world, chunkBox, 6, 4, 2, 6, 4, 7, blockState3, blockState3, false);
			this.fillWithOutline(world, chunkBox, 0, 4, 8, 6, 4, 8, blockState4, blockState4, false);
			this.addBlock(world, ModBlocks.SWAMP_FENCE.getDefaultState().with(FenceBlock.NORTH, true), 1, 2, 1, chunkBox);
			this.addBlock(world, ModBlocks.SWAMP_FENCE.getDefaultState().with(FenceBlock.NORTH, true), 5, 2, 1, chunkBox);
			this.addBlock(world, ModBlocks.SWAMP_FENCE.getDefaultState().with(FenceBlock.EAST, true).with(FenceBlock.WEST, true), 2, 3, 2, chunkBox);
			this.addBlock(world, ModBlocks.SWAMP_FENCE.getDefaultState().with(FenceBlock.EAST, true).with(FenceBlock.WEST, true), 3, 3, 7, chunkBox);
			this.fillWithOutline(world, chunkBox, 2, 5, 2, 4, 5, 2, blockState, blockState, false);
			this.fillWithOutline(world, chunkBox, 1, 5, 3, 1, 5, 6, blockState2, blockState2, false);
			this.fillWithOutline(world, chunkBox, 5, 5, 3, 5, 5, 6, blockState3, blockState3, false);
			this.fillWithOutline(world, chunkBox, 2, 5, 7, 4, 5, 7, blockState4, blockState4, false);
			this.addBlock(world, blockState.with(StairsBlock.SHAPE, StairShape.OUTER_RIGHT), 0, 4, 1, chunkBox);
			this.addBlock(world, blockState.with(StairsBlock.SHAPE, StairShape.OUTER_LEFT), 6, 4, 1, chunkBox);
			this.addBlock(world, blockState4.with(StairsBlock.SHAPE, StairShape.OUTER_LEFT), 0, 4, 8, chunkBox);
			this.addBlock(world, blockState4.with(StairsBlock.SHAPE, StairShape.OUTER_RIGHT), 6, 4, 8, chunkBox);
			this.addBlock(world, blockState.with(StairsBlock.SHAPE, StairShape.OUTER_RIGHT), 1, 5, 2, chunkBox);
			this.addBlock(world, blockState.with(StairsBlock.SHAPE, StairShape.OUTER_LEFT), 5, 5, 2, chunkBox);
			this.addBlock(world, blockState4.with(StairsBlock.SHAPE, StairShape.OUTER_LEFT), 1, 5, 7, chunkBox);
			this.addBlock(world, blockState4.with(StairsBlock.SHAPE, StairShape.OUTER_RIGHT), 5, 5, 7, chunkBox);

			for (int i = 2; i <= 7; i += 5) {
				for (int j = 1; j <= 5; j += 4) {
					this.fillDownwards(world, ModBlocks.SWAMP_LOG.getDefaultState(), j, -1, i, chunkBox);
				}
			}

			HasWitchAccessor witchAccessor = (HasWitchAccessor) (Object) this;
			if (!witchAccessor.getHasWitch()) {
				BlockPos blockPos = this.offsetPos(2, 2, 5);
				if (chunkBox.contains(blockPos)) {
					witchAccessor.setHasWitch(true);
					WitchEntity witchEntity = EntityType.WITCH.create(world.toServerWorld(), SpawnReason.STRUCTURE);
					if (witchEntity != null) {
						witchEntity.setPersistent();
						witchEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
						witchEntity.initialize(world, world.getLocalDifficulty(blockPos), SpawnReason.STRUCTURE, null);
						world.spawnEntityAndPassengers(witchEntity);
					}
				}
			}

			HasCatAccessor catAccessor = (HasCatAccessor) (Object) this;
			if (!catAccessor.getHasCat()) {
				BlockPos blockPos = this.offsetPos(2, 2, 5);
				if (chunkBox.contains(blockPos)) {
					catAccessor.setHasCat(true);
					CatEntity catEntity = EntityType.CAT.create(world.toServerWorld(), SpawnReason.STRUCTURE);
					if (catEntity != null) {
						catEntity.setPersistent();
						catEntity.refreshPositionAndAngles((double)blockPos.getX() + 0.5, (double)blockPos.getY(), (double)blockPos.getZ() + 0.5, 0.0F, 0.0F);
						catEntity.initialize(world, world.getLocalDifficulty(blockPos), SpawnReason.STRUCTURE, null);
						world.spawnEntityAndPassengers(catEntity);
					}
				}
			}

			ci.cancel();
		}
	}

	@Override
	public void generate(StructureWorldAccess world, StructureAccessor structureAccessor, ChunkGenerator chunkGenerator, Random random, BlockBox chunkBox, ChunkPos chunkPos, BlockPos pivot) {

	}
}

