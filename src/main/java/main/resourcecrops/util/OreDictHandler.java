package main.resourcecrops.util;

import main.resourcecrops.blocks.BlockRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tterrag.core.common.OreDict;

import java.awt.*;
import java.util.HashMap;

public class OreDictHandler {

	public static HashMap<String, Integer> oreDictColor = new HashMap<String, Integer>();

	// Items
	public static String dustBlaze = "dustBlaze";
	public static String dustRedstone = "dustRedstone";

	// Blocks
	public static String oreGaianite = "oreGaianite";
	public static String oreGaianiteNether = "oreGaianiteNether";

	public static void initEarly() {
		addOreDictColors();

		// Items
		OreDict.safeRegister(dustBlaze, Items.blaze_powder);
		OreDict.safeRegister(dustRedstone, Items.redstone);

		// Blocks
	}

	public static void initLate() {

		// Blocks
		OreDict.safeRegister(oreGaianite, new ItemStack(BlockRegistry.oreGaianite, 1, 0));
		OreDict.safeRegister(oreGaianiteNether, new ItemStack(BlockRegistry.oreGaianite, 1, 1));
	}

	public static NBTTagCompound setCompound(ItemStack stack) {
		if (!stack.hasTagCompound()) {
			NBTTagCompound tag = new NBTTagCompound();
			stack.setTagCompound(tag);
			return tag;
		}
		return null;
	}

	public static void addOreDictColors() {
		oreDictColor.put("Coal", new Color(45, 44, 47).getRGB());
		oreDictColor.put("Charcoal", new Color(45, 44, 47).getRGB());
		oreDictColor.put("Iron", new Color(242, 201, 182).getRGB());
		oreDictColor.put("Gold", new Color(255, 255, 0).getRGB());
		oreDictColor.put("Emerald", new Color(87, 242, 111).getRGB());
		oreDictColor.put("Diamond", new Color(58, 242, 239).getRGB());
		oreDictColor.put("Lapis", new Color(63, 71, 206).getRGB());
		oreDictColor.put("Quartz", new Color(255, 255, 255).getRGB());
		oreDictColor.put("Blaze", new Color(255, 215, 66).getRGB());
		oreDictColor.put("Redstone", new Color(159, 13, 0).getRGB());
		oreDictColor.put("Glowstone", new Color(233, 255, 84).getRGB());
		oreDictColor.put("Obsidian", new Color(48, 0, 97).getRGB());
		oreDictColor.put("Copper", new Color(204, 102, 51).getRGB());
		oreDictColor.put("Tin", new Color(135, 154, 168).getRGB());
		oreDictColor.put("Lead", new Color(102, 102, 153).getRGB());
		oreDictColor.put("Ardite", new Color(255, 102, 0).getRGB());
		oreDictColor.put("Cobalt", new Color(0, 60, 255).getRGB());
		oreDictColor.put("Nickel", new Color(204, 204, 204).getRGB());
		oreDictColor.put("Silver", new Color(187, 189, 184).getRGB());
		oreDictColor.put("Platinum", new Color(30, 208, 243).getRGB());
		oreDictColor.put("Enderium", new Color(9, 79, 79).getRGB());
		oreDictColor.put("Lumium", new Color(255, 247, 153).getRGB());
		oreDictColor.put("Signalum", new Color(255, 84, 0).getRGB());
		oreDictColor.put("Bronze", new Color(255, 186, 80).getRGB());
		oreDictColor.put("Invar", new Color(139, 133, 103).getRGB());
		oreDictColor.put("Electrum", new Color(255, 224, 75).getRGB());
		oreDictColor.put("Aluminium", new Color(198, 206, 130).getRGB());
		oreDictColor.put("Aluminum", new Color(198, 206, 130).getRGB());
		oreDictColor.put("Uranium", new Color(90, 159, 50).getRGB());
		oreDictColor.put("Yellorium", new Color(142, 160, 19).getRGB());
		oreDictColor.put("Sulfur", new Color(212, 190, 85).getRGB());
		oreDictColor.put("Saltpeter", new Color(182, 197, 212).getRGB());
		oreDictColor.put("Blood", new Color(212, 51, 55).getRGB());
		oreDictColor.put("Primal", new Color(212, 107, 168).getRGB());
	}
}