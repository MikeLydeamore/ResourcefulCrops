package main.resourcecrops.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

	private static void registerShapedRecipes() {

	}

	private static void registerShaplessRecipes() {

	}

	public static void init() {
		registerShapedRecipes();
		registerShaplessRecipes();
	}

	private static void addGaiaToOreRecipe(Item input, int inputAmount, int inputMeta, Item output, int outputAmount, int outputMeta) {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(output, outputAmount, outputMeta), new Object[]{"III", "I I", "III", 'I', new ItemStack(input, inputAmount, inputMeta)}));
	}
}
