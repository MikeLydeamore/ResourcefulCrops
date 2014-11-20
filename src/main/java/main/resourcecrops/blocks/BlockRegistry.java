package main.resourcecrops.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import main.resourcecrops.items.blocks.ItemBlockCrops;
import main.resourcecrops.items.blocks.ItemBlockOreGaianite;
import net.minecraft.block.Block;

public class BlockRegistry {

	// Blocks
	public static Block oreGaianite;
	public static Block crop;

	private static void registerBlocks() {

		oreGaianite = new BlockOreGaianite();
		GameRegistry.registerBlock(oreGaianite, ItemBlockOreGaianite.class, "BlockOreGaianite");

		crop = new BlockBaseCrops();
		GameRegistry.registerBlock(crop, ItemBlockCrops.class, "BlockCrops");
	}

	public static void init() {
		registerBlocks();
	}
}
