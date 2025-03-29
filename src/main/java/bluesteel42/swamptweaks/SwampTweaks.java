package bluesteel42.swamptweaks;

import bluesteel42.swamptweaks.block.ModBlocks;
import bluesteel42.swamptweaks.entity.ModBoats;
import bluesteel42.swamptweaks.item.ModItems;
import bluesteel42.swamptweaks.registries.ModRegistries;
import bluesteel42.swamptweaks.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SwampTweaks implements ModInitializer {
	public static final String MOD_ID = "swamp-tweaks";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		ModBlocks.initialize();
		ModItems.initialize();
		ModBoats.initialize();
		ModWorldGeneration.generateModWorldGen();
		ModRegistries.registerStrippables();
		ModRegistries.registerCompostables();
		ModRegistries.registerFlammables();
		ModRegistries.registerTrades();

		LOGGER.info("Hello Fabric world!");
	}
}