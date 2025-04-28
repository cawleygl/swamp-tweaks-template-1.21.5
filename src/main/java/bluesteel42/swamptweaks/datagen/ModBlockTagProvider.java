package bluesteel42.swamptweaks.datagen;

import bluesteel42.swamptweaks.block.ModBlocks;
import bluesteel42.swamptweaks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.ANIMALS_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.DIRT).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.FOXES_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.FROGS_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.PARROTS_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.RABBITS_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.VALID_SPAWN).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.WOLVES_SPAWNABLE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_GRASS_BLOCK);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(ModBlocks.MUDDY_GRASS_BLOCK);

        getOrCreateTagBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.DIRT).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.MOOSHROOMS_SPAWNABLE_ON).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(ModBlocks.MUDDY_MYCELIUM);
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.MUDDY_MYCELIUM);

        getOrCreateTagBuilder(BlockTags.BIG_DRIPLEAF_PLACEABLE).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.DIRT).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.FOXES_SPAWNABLE_ON).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.MUSHROOM_GROW_BLOCK).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.SNIFFER_DIGGABLE_BLOCK).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.VALID_SPAWN).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.WOLVES_SPAWNABLE_ON).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.MANGROVE_LOGS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.MANGROVE_ROOTS_CAN_GROW_THROUGH).add(ModBlocks.MUDDY_PODZOL);
        getOrCreateTagBuilder(BlockTags.SNOW_LAYER_CAN_SURVIVE_ON).add(ModBlocks.MUDDY_PODZOL);

        getOrCreateTagBuilder(ModTags.Blocks.SWAMP_LOGS)
                .add(ModBlocks.SWAMP_LOG)
                .add(ModBlocks.SWAMP_WOOD)
                .add(ModBlocks.STRIPPED_SWAMP_LOG)
                .add(ModBlocks.STRIPPED_SWAMP_WOOD);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN).addTag(ModTags.Blocks.SWAMP_LOGS);
        getOrCreateTagBuilder(BlockTags.PLANKS).add(ModBlocks.SWAMP_PLANKS);
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(ModBlocks.SWAMP_STAIRS);
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(ModBlocks.SWAMP_SLAB);
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(ModBlocks.SWAMP_DOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.SWAMP_TRAPDOOR);
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(ModBlocks.SWAMP_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.SWAMP_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(ModBlocks.SWAMP_BUTTON);
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.SWAMP_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.STANDING_SIGNS).add(ModBlocks.SWAMP_STANDING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_SIGNS).add(ModBlocks.SWAMP_WALL_SIGN);
        getOrCreateTagBuilder(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.SWAMP_HANGING_SIGN);
        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.SWAMP_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.SWAMP_WALL_HANGING_SIGN);

        getOrCreateTagBuilder(BlockTags.LEAVES).add(ModBlocks.SWAMP_LEAVES);
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(ModBlocks.SWAMP_SAPLING);
        getOrCreateTagBuilder(BlockTags.FLOWER_POTS).add(ModBlocks.POTTED_SWAMP_SAPLING);
    }
}
