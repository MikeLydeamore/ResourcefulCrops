package main.resourcecrops.client.gui;

import main.resourcecrops.ModInformation;
import main.resourcecrops.blocks.BlockRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabRCrops extends CreativeTabs {

	public CreativeTabRCrops(String tabLabel) {
		super(tabLabel);
		setBackgroundImageName(ModInformation.ID + ".png");
	}

	public boolean hasSearchBar() {
		return true;
	}

	public int getSearchbarWidth() {
		return 60;
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(BlockRegistry.oreGaianite,1 , 0);
	}

	@Override
	public Item getTabIconItem() {
		return new Item();
	}
}
