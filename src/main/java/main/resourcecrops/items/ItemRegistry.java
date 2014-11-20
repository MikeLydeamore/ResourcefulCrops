package main.resourcecrops.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistry {

	// Items
	public static Item seed;

	private static void registerItems() {
		seed = new ItemBaseSeed();
		GameRegistry.registerItem(seed, "ItemCropSeeds");
	}

	public static void init() {
		registerItems();
	}
}
