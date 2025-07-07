package bluesteel42.swamptweaks.datagen;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.block.ModBlocks;
import bluesteel42.swamptweaks.entity.ModBoats;
import bluesteel42.swamptweaks.item.ModItems;
import bluesteel42.swamptweaks.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {
                RegistryEntryLookup<Item> registryLookup = wrapperLookup.getOrThrow(RegistryKeys.ITEM);

                offerBarkBlockRecipe(ModBlocks.SWAMP_WOOD, ModBlocks.SWAMP_LOG);
                offerBarkBlockRecipe(ModBlocks.STRIPPED_SWAMP_WOOD, ModBlocks.STRIPPED_SWAMP_LOG);
                offerPlanksRecipe(ModBlocks.SWAMP_PLANKS, ModTags.Items.SWAMP_LOGS, 4);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SWAMP_STAIRS, 4)
                        .pattern("#  ")
                        .pattern("## ")
                        .pattern("###")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_stairs")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.BUILDING_BLOCKS, ModBlocks.SWAMP_SLAB, 6)
                        .pattern("###")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_slab")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapelessRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.SWAMP_BUTTON, 1)
                        .input(ModBlocks.SWAMP_PLANKS)
                        .group("wooden_button")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.SWAMP_PRESSURE_PLATE, 1)
                        .pattern("##")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_pressure_plate")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.DECORATIONS, ModBlocks.SWAMP_FENCE, 3)
                        .pattern("W#W")
                        .pattern("W#W")
                        .input('#', Items.STICK)
                        .input('W', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_fence")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.SWAMP_FENCE_GATE, 1)
                        .pattern("#W#")
                        .pattern("#W#")
                        .input('#', Items.STICK)
                        .input('W', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_fence_gate")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.SWAMP_DOOR, 3)
                        .pattern("##")
                        .pattern("##")
                        .pattern("##")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_door")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.REDSTONE, ModBlocks.SWAMP_TRAPDOOR, 2)
                        .pattern("###")
                        .pattern("###")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .group("wooden_trapdoor")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                ShapedRecipeJsonBuilder.create(registryLookup, RecipeCategory.DECORATIONS, ModItems.SWAMP_SIGN, 3)
                        .pattern("###")
                        .pattern("###")
                        .pattern(" X ")
                        .input('#', ModBlocks.SWAMP_PLANKS)
                        .input('X', Items.STICK)
                        .group("wooden_sign")
                        .criterion("has_planks", conditionsFromItem(ModBlocks.SWAMP_PLANKS))
                        .offerTo(exporter);
                offerHangingSignRecipe(ModItems.SWAMP_HANGING_SIGN, ModBlocks.STRIPPED_SWAMP_LOG);
                offerBoatRecipe(ModBoats.SWAMP_BOAT, ModBlocks.SWAMP_PLANKS);
                offerChestBoatRecipe(ModBoats.SWAMP_CHEST_BOAT, ModBoats.SWAMP_BOAT);
            }
        };
    }

    @Override
    public String getName() {
        return SwampTweaks.MOD_ID + "Recipes";
    }
}