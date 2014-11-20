package main.resourcecrops.blocks;

import main.resourcecrops.ResourcefulCrops;
import main.resourcecrops.ModInformation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	public BlockBase(String unlocName, String textureName, Material material, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.ID + "." + unlocName);
		setBlockTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(ResourcefulCrops.tabRCrops);
		setStepSound(soundType);
		setHardness(hardness);
	}

	public BlockBase(String unlocName, Material material, SoundType soundType, float hardness) {
		super(material);

		setBlockName(ModInformation.ID + "." + unlocName);
		setCreativeTab(ResourcefulCrops.tabRCrops);
		setStepSound(soundType);
		setHardness(hardness);
	}
}
