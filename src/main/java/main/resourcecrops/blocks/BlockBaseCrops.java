package main.resourcecrops.blocks;

import main.resourcecrops.ModInformation;
import main.resourcecrops.ResourcefulCrops;
import net.minecraft.block.BlockCrops;

public class BlockBaseCrops extends BlockCrops {

	public BlockBaseCrops() {
		super();

		setBlockName(ModInformation.ID + ".crop");
		setBlockTextureName(ModInformation.ID + ":cropBase");
		setCreativeTab(ResourcefulCrops.tabRCrops);
	}
}
