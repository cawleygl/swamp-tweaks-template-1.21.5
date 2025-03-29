package bluesteel42.swamptweaks.datagen;

import bluesteel42.swamptweaks.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.SWAMP_LOG);
        addDrop(ModBlocks.SWAMP_WOOD);
        addDrop(ModBlocks.STRIPPED_SWAMP_LOG);
        addDrop(ModBlocks.STRIPPED_SWAMP_WOOD);

        addDrop(ModBlocks.SWAMP_PLANKS);
        addDrop(ModBlocks.SWAMP_STAIRS);
        addDrop(ModBlocks.SWAMP_BUTTON);
        addDrop(ModBlocks.SWAMP_FENCE_GATE);
        addDrop(ModBlocks.SWAMP_FENCE);
        addDrop(ModBlocks.SWAMP_PRESSURE_PLATE);
        addDrop(ModBlocks.SWAMP_TRAPDOOR);
        addDrop(ModBlocks.SWAMP_DOOR, doorDrops(ModBlocks.SWAMP_DOOR));
        addDrop(ModBlocks.SWAMP_SLAB, slabDrops(ModBlocks.SWAMP_SLAB));

        addDrop(ModBlocks.SWAMP_STANDING_SIGN);
        addDrop(ModBlocks.SWAMP_WALL_SIGN);
        addDrop(ModBlocks.SWAMP_HANGING_SIGN);
        addDrop(ModBlocks.SWAMP_WALL_HANGING_SIGN);

        addDrop(ModBlocks.SWAMP_SAPLING);
        addDrop(ModBlocks.POTTED_SWAMP_SAPLING, pottedPlantDrops(ModBlocks.SWAMP_SAPLING));
        addDrop(ModBlocks.SWAMP_LEAVES, leavesDrops(ModBlocks.SWAMP_LEAVES, ModBlocks.SWAMP_SAPLING, 0.05f));
    }
}
