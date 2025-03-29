package bluesteel42.swamptweaks.item;

import bluesteel42.swamptweaks.SwampTweaks;
import bluesteel42.swamptweaks.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SWAMP_SIGN = registerSignItem("swamp_sign");
    public static final Item SWAMP_HANGING_SIGN = registerHangingSignItem("swamp_hanging_sign");

    public static Item registerSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwampTweaks.MOD_ID, path));
        final Item item = new SignItem(
                ModBlocks.SWAMP_STANDING_SIGN,
                ModBlocks.SWAMP_WALL_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static Item registerHangingSignItem(String path) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(SwampTweaks.MOD_ID, path));
        final Item item = new HangingSignItem(
                ModBlocks.SWAMP_HANGING_SIGN,
                ModBlocks.SWAMP_WALL_HANGING_SIGN,
                new Item.Settings().registryKey(registryKey).maxCount(16));

        return Registry.register(Registries.ITEM, registryKey.getValue(), item);
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
                .register((itemGroup) -> {
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, ModItems.SWAMP_HANGING_SIGN);
                    itemGroup.addAfter(Items.PALE_OAK_HANGING_SIGN, ModItems.SWAMP_SIGN);
                });

    }
}
