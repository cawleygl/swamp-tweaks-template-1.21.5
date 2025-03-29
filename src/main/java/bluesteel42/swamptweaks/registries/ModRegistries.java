package bluesteel42.swamptweaks.registries;

import bluesteel42.swamptweaks.block.ModBlocks;
import bluesteel42.swamptweaks.entity.ModBoats;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

import java.util.function.Consumer;

public class ModRegistries {

    public static void registerStrippables() {
        StrippableBlockRegistry.register(ModBlocks.SWAMP_WOOD, ModBlocks.STRIPPED_SWAMP_WOOD);
        StrippableBlockRegistry.register(ModBlocks.SWAMP_LOG, ModBlocks.STRIPPED_SWAMP_LOG);
    }

    public static void registerCompostables() {
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.SWAMP_LEAVES, 0.3F);
        CompostingChanceRegistry.INSTANCE.add(ModBlocks.SWAMP_SAPLING, 0.3F);
    }

    public static void registerFlammables() {
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SWAMP_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_SWAMP_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_PLANKS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_SLAB, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_FENCE_GATE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_FENCE, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_STAIRS, 5, 20);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.SWAMP_LEAVES, 30, 60);
    }

    public static void registerTrades() {
        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_COMMON_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 5),
                    new ItemStack(ModBlocks.SWAMP_SAPLING.asItem(), 1),
                    8,  1, 5)
            );
        });

        TradeOfferHelper.registerWanderingTraderOffers(wanderingTraderOffersBuilder -> {
            wanderingTraderOffersBuilder.addOffersToPool(TradeOfferHelper.WanderingTraderOffersBuilder.SELL_SPECIAL_ITEMS_POOL,
                (entity, random) -> new TradeOffer(
                    new TradedItem(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.SWAMP_LOG.asItem(), 8),
                    4,  1, 1)
            );
        });

        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FISHERMAN, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new TradedItem(ModBoats.SWAMP_BOAT, 1),
                            new ItemStack(Items.EMERALD, 1),
                            12,  30, 0.05f));
                });
    }
}
