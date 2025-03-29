package bluesteel42.swamptweaks.util;

import bluesteel42.swamptweaks.SwampTweaks;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> SWAMP_LOGS = createTag("swamp_logs");

        public static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(SwampTweaks.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> SWAMP_LOGS = createTag("swamp_logs");

        public static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(SwampTweaks.MOD_ID, name));
        }
    }
}
