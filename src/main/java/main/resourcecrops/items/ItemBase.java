package main.resourcecrops.items;

import main.resourcecrops.ResourcefulCrops;
import main.resourcecrops.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

	public ItemBase(String unlocName, String textureName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setTextureName(ModInformation.ID + ":" + textureName);
		setCreativeTab(ResourcefulCrops.tabRCrops);
	}

	public ItemBase(String unlocName) {
		super();

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setCreativeTab(ResourcefulCrops.tabRCrops);
	}
}
