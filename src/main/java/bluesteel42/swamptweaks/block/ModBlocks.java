package bluesteel42.swamptweaks.block;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.world.tree.ModSaplingGenerators;
import com.terraformersmc.terraform.sign.api.block.TerraformHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallHangingSignBlock;
import com.terraformersmc.terraform.sign.api.block.TerraformWallSignBlock;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.data.family.BlockFamilies;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {

    public static final Block MUDDY_GRASS_BLOCK = registerNonOpaqueBlock("muddy_grass_block", MuddyGrassBlock::new, AbstractBlock.Settings.create().mapColor(MapColor.PALE_GREEN).ticksRandomly().strength(0.6F).sounds(BlockSoundGroup.MUD));

    public static final Block SWAMP_LOG = registerBlock("swamp_log", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_CYAN, MapColor.GREEN, BlockSoundGroup.WOOD));
    public static final Block SWAMP_WOOD = registerBlock("swamp_wood", PillarBlock::new, Blocks.createLogSettings(MapColor.GREEN, MapColor.GREEN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_SWAMP_LOG = registerBlock("stripped_swamp_log", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_CYAN, BlockSoundGroup.WOOD));
    public static final Block STRIPPED_SWAMP_WOOD = registerBlock("stripped_swamp_wood", PillarBlock::new, Blocks.createLogSettings(MapColor.TERRACOTTA_CYAN, MapColor.TERRACOTTA_CYAN, BlockSoundGroup.WOOD));
    public static final Block SWAMP_PLANKS = registerBlock(
            "swamp_planks",
            Block::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block SWAMP_STAIRS = registerBlock(
            "swamp_stairs",
            settings -> new StairsBlock(SWAMP_PLANKS.getDefaultState(), settings),
            AbstractBlock.Settings.copy(SWAMP_PLANKS)
    );
    public static final Block SWAMP_SLAB = registerBlock(
            "swamp_slab",
            SlabBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block SWAMP_BUTTON = registerBlock(
            "swamp_button",
            settings -> new ButtonBlock(BlockSetType.OAK, 30, settings),
            AbstractBlock.Settings.create()
                    .noCollision()
                    .strength(0.5F)
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SWAMP_PRESSURE_PLATE = registerBlock(
            "swamp_pressure_plate",
            settings -> new PressurePlateBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .noCollision()
                    .strength(0.5F)
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SWAMP_FENCE = registerBlock(
            "swamp_fence",
            FenceBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .burnable()
    );
    public static final Block SWAMP_FENCE_GATE = registerBlock(
            "swamp_fence_gate",
            settings -> new FenceGateBlock(WoodType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .solid()
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0F, 3.0F)
                    .burnable()
    );
    public static final Block SWAMP_DOOR = registerNonOpaqueBlock(
            "swamp_door",
            settings -> new DoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .burnable()
                    .pistonBehavior(PistonBehavior.DESTROY)
    );
    public static final Block SWAMP_TRAPDOOR = registerNonOpaqueBlock(
            "swamp_trapdoor",
            settings -> new TrapdoorBlock(BlockSetType.OAK, settings),
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_CYAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(3.0F)
                    .nonOpaque()
                    .allowsSpawning(Blocks::never)
                    .burnable()
    );
    public static final Identifier SWAMP_SIGN_TEXTURE = Identifier.of(SwampTweaks.MOD_ID, "entity/signs/swamp");
    public static final Identifier SWAMP_HANGING_SIGN_TEXTURE = Identifier.of(SwampTweaks.MOD_ID, "entity/signs/hanging/swamp");
    public static final Identifier SWAMP_HANGING_GUI_SIGN_TEXTURE = Identifier.of(SwampTweaks.MOD_ID, "textures/gui/hanging_signs/swamp");
    public static final Block SWAMP_STANDING_SIGN = registerBlockWithoutItem(
            "swamp_standing_sign",
            settings -> new TerraformSignBlock(SWAMP_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN)
                    .mapColor(MapColor.TERRACOTTA_CYAN)
    );

    public static final Block SWAMP_WALL_SIGN = registerBlockWithoutItem(
            "swamp_wall_sign",
            settings -> new TerraformWallSignBlock(SWAMP_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SIGN).mapColor(MapColor.TERRACOTTA_CYAN).lootTable(SWAMP_STANDING_SIGN.getLootTableKey()).overrideTranslationKey(SWAMP_STANDING_SIGN.getTranslationKey())
    );

    public static final Block SWAMP_HANGING_SIGN = registerBlockWithoutItem(
            "swamp_hanging_sign",
            settings -> new TerraformHangingSignBlock(SWAMP_HANGING_SIGN_TEXTURE, SWAMP_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN)
                    .mapColor(MapColor.TERRACOTTA_CYAN)
    );

    public static final Block SWAMP_WALL_HANGING_SIGN = registerBlockWithoutItem(
            "swamp_hanging_wall_sign",
            settings -> new TerraformWallHangingSignBlock(SWAMP_HANGING_SIGN_TEXTURE, SWAMP_HANGING_GUI_SIGN_TEXTURE, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_HANGING_SIGN).mapColor(MapColor.TERRACOTTA_CYAN).lootTable(SWAMP_HANGING_SIGN.getLootTableKey()).overrideTranslationKey(SWAMP_HANGING_SIGN.getTranslationKey())
    );

    public static final BlockFamily SWAMP_SIGN_FAMILY = BlockFamilies.register(ModBlocks.SWAMP_PLANKS)
            .sign(ModBlocks.SWAMP_STANDING_SIGN, ModBlocks.SWAMP_WALL_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final BlockFamily SWAMP_HANGING_SIGN_FAMILY = BlockFamilies.register(ModBlocks.STRIPPED_SWAMP_LOG)
            .sign(ModBlocks.SWAMP_HANGING_SIGN, ModBlocks.SWAMP_WALL_HANGING_SIGN)
            .group("wooden").unlockCriterionName("has_planks").build();

    public static final Block SWAMP_LEAVES = registerNonOpaqueBlock(
            "swamp_leaves",
            settings -> new TintedParticleLeavesBlock(0.01F, settings),
            Blocks.createLeavesSettings(BlockSoundGroup.GRASS)
    );
    public static final Block SWAMP_SAPLING = registerNonOpaqueBlock(
            "swamp_sapling",
            settings -> new SaplingBlock(ModSaplingGenerators.SWAMP, settings),
            AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
    );
    public static final Block POTTED_SWAMP_SAPLING = registerNonOpaqueBlock(
            "potted_swamp_sapling",
            settings -> new FlowerPotBlock(SWAMP_SAPLING, settings),
            Blocks.createFlowerPotSettings()
    );

    private static Block registerBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(SwampTweaks.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        Items.register(block);

        return block;
    }

    private static Block registerNonOpaqueBlock(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(SwampTweaks.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);

        BlockRenderLayerMap.INSTANCE.putBlock(block, RenderLayer.getCutout());

        Items.register(block);

        return block;
    }

    private static Block registerBlockWithoutItem(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of(SwampTweaks.MOD_ID, path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        return Blocks.register(registryKey, factory, settings);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_BUTTON);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_PRESSURE_PLATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_TRAPDOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_DOOR);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_FENCE_GATE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_FENCE);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_SLAB);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_STAIRS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_PLANKS);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_SWAMP_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.STRIPPED_SWAMP_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_WOOD);
                    itemGroup.addAfter(Items.PALE_OAK_BUTTON, ModBlocks.SWAMP_LOG);
                });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_LOG, ModBlocks.SWAMP_LOG);
                    itemGroup.addAfter(Items.PALE_OAK_LEAVES, ModBlocks.SWAMP_LEAVES);
                    itemGroup.addAfter(Items.PALE_OAK_SAPLING, ModBlocks.SWAMP_SAPLING);
                    itemGroup.addBefore(Items.MUD, ModBlocks.MUDDY_GRASS_BLOCK);
                });
    }
}
