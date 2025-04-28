package bluesteel42.swamptweaks.datagen;

import bluesteel42.swamptweaks.block.ModBlocks;
import bluesteel42.swamptweaks.entity.ModBoats;
import bluesteel42.swamptweaks.item.ModItems;
import bluesteel42.swamptweaks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.DIRT).add(ModBlocks.MUDDY_GRASS_BLOCK.asItem());
        getOrCreateTagBuilder(ItemTags.DIRT).add(ModBlocks.MUDDY_MYCELIUM.asItem());
        getOrCreateTagBuilder(ItemTags.DIRT).add(ModBlocks.MUDDY_PODZOL.asItem());

        getOrCreateTagBuilder(ModTags.Items.SWAMP_LOGS)
                .add(ModBlocks.SWAMP_LOG.asItem())
                .add(ModBlocks.SWAMP_WOOD.asItem())
                .add(ModBlocks.STRIPPED_SWAMP_LOG.asItem())
                .add(ModBlocks.STRIPPED_SWAMP_WOOD.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN).addTag(ModTags.Items.SWAMP_LOGS);
        getOrCreateTagBuilder(ItemTags.PLANKS).add(ModBlocks.SWAMP_PLANKS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(ModBlocks.SWAMP_STAIRS.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(ModBlocks.SWAMP_SLAB.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(ModBlocks.SWAMP_DOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_TRAPDOORS).add(ModBlocks.SWAMP_TRAPDOOR.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(ModBlocks.SWAMP_FENCE.asItem());
        getOrCreateTagBuilder(ItemTags.FENCE_GATES).add(ModBlocks.SWAMP_FENCE_GATE.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(ModBlocks.SWAMP_BUTTON.asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.SWAMP_PRESSURE_PLATE.asItem());

        getOrCreateTagBuilder(ItemTags.SIGNS).add(ModItems.SWAMP_SIGN);
        getOrCreateTagBuilder(ItemTags.HANGING_SIGNS).add(ModItems.SWAMP_HANGING_SIGN);

        getOrCreateTagBuilder(ItemTags.BOATS).add(ModBoats.SWAMP_BOAT.asItem());
        getOrCreateTagBuilder(ItemTags.CHEST_BOATS).add(ModBoats.SWAMP_CHEST_BOAT.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES).add(ModBlocks.SWAMP_LEAVES.asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(ModBlocks.SWAMP_SAPLING.asItem());
    }
}
