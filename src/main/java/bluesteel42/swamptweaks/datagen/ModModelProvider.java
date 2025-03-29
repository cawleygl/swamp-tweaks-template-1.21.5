package bluesteel42.swamptweaks.datagen;

import bluesteel42.swamptweaks.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.createLogTexturePool(ModBlocks.SWAMP_LOG).log(ModBlocks.SWAMP_LOG).wood(ModBlocks.SWAMP_WOOD);
        blockStateModelGenerator.createLogTexturePool(ModBlocks.STRIPPED_SWAMP_LOG).log(ModBlocks.STRIPPED_SWAMP_LOG).wood(ModBlocks.STRIPPED_SWAMP_WOOD);

        BlockStateModelGenerator.BlockTexturePool swampPlankPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.SWAMP_PLANKS);
        swampPlankPool.stairs(ModBlocks.SWAMP_STAIRS);
        swampPlankPool.slab(ModBlocks.SWAMP_SLAB);
        swampPlankPool.button(ModBlocks.SWAMP_BUTTON);
        swampPlankPool.fence(ModBlocks.SWAMP_FENCE);
        swampPlankPool.fenceGate(ModBlocks.SWAMP_FENCE_GATE);
        swampPlankPool.pressurePlate(ModBlocks.SWAMP_PRESSURE_PLATE);
        blockStateModelGenerator.registerDoor(ModBlocks.SWAMP_DOOR);
        blockStateModelGenerator.registerOrientableTrapdoor(ModBlocks.SWAMP_TRAPDOOR);
        
        // Signs Textures
        swampPlankPool.family(ModBlocks.SWAMP_SIGN_FAMILY);
        swampPlankPool.family(ModBlocks.SWAMP_HANGING_SIGN_FAMILY);

        blockStateModelGenerator.registerTintedBlockAndItem(ModBlocks.SWAMP_LEAVES, TexturedModel.LEAVES, -7158200);
        blockStateModelGenerator.registerFlowerPotPlantAndItem(ModBlocks.SWAMP_SAPLING, ModBlocks.POTTED_SWAMP_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);
        
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
