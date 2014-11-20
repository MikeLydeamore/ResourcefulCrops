package main.resourcecrops.items.blocks;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreGaianite extends ItemBlock {

	public static final String[] names = {"", ".nether"};

	public ItemBlockOreGaianite(Block block) {
		super(block);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack stack) {
		return getUnlocalizedName() + "" + names[stack.getItemDamage() % names.length];
	}

	@Override
	public int getMetadata(int meta) {
		return meta;
	}
}
