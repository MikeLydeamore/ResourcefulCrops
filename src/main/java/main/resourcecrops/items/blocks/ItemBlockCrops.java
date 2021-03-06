package main.resourcecrops.items.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.resourcecrops.ConfigHandler;
import main.resourcecrops.blocks.BlockRegistry;
import main.resourcecrops.util.EnviroChecks;
import main.resourcecrops.util.OreDictHandler;
import main.resourcecrops.util.TextHelper;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSeeds;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;

import java.util.Arrays;
import java.util.List;

public class ItemBlockCrops extends ItemBlock {

	public ItemBlockCrops(Block block) {
		super(block);

		setHasSubtypes(true);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

		Block placedOn = world.getBlock(x, y, z);
		String getPlantToPlace = stack.stackTagCompound.getString("ore");

		if (placedOn.canSustainPlant(world, x, y, z, ForgeDirection.UP, (ItemSeeds) Items.wheat_seeds) && side == ForgeDirection.UP.ordinal()) {
			world.setBlock(x, y + 1, z, BlockRegistry.crop, 0, 0);
			world.markBlockForUpdate(x, y, z);
			if (!player.capabilities.isCreativeMode) {
				player.inventory.decrStackSize(player.inventory.currentItem, 1);
			}
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) {
		if (stack.hasTagCompound()) {
			list.add(TextHelper.localize(stack.stackTagCompound.getString("ore")));

			if (stack.stackTagCompound.getString("ore").equals("Blaze")) {
				list.add("420");
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	@SuppressWarnings("unchecked")
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (String ore : OreDictionary.getOreNames()) {
			if (ore.startsWith("ingot")) {
				String output = ore.substring(5);
				if (!OreDictionary.getOres(ore).isEmpty() && !OreDictionary.getOres("ingot" + output).isEmpty()) {
					if (!ConfigHandler.checkIngotBlacklist(output)) {
						ItemStack stack = new ItemStack(this);
						OreDictHandler.setCompound(stack);
						stack.stackTagCompound.setString("ore", output);
						list.add(stack);
					}
				}
			}

			if (ore.startsWith("dust")) {
				String output = ore.substring(4);

				if (!OreDictionary.getOres(ore).isEmpty() && !OreDictionary.getOres("dust" + output).isEmpty()) {
					if(OreDictionary.getOres("ingot" + output).isEmpty() && !ConfigHandler.checkDustBlacklist(output)) {
						ItemStack stack = new ItemStack(this);
						OreDictHandler.setCompound(stack);
						stack.stackTagCompound.setString("ore", output);
						list.add(stack);
					}
				}
			}

			if (ore.startsWith("gem")) {
				String output = ore.substring(3);
				if (!OreDictionary.getOres(ore).isEmpty() && !OreDictionary.getOres("gem" + output).isEmpty()) {
					if (!ConfigHandler.checkGemBlacklist(output)) {
						ItemStack stack = new ItemStack(this);
						OreDictHandler.setCompound(stack);
						stack.stackTagCompound.setString("ore", output);
						list.add(stack);
					}
				}
			}
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("Enderpearl")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Ender");
			list.add(stack);
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("GhastTear")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Ghastly");
			list.add(stack);
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("RottenFlesh")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Flesh");
			list.add(stack);
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("String")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Stringy");
			list.add(stack);
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("Slimeball")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Slimey");
			list.add(stack);
		}

		if (Arrays.asList(ConfigHandler.extraMaterialWhitelist).contains("Bone")) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Boney");
			list.add(stack);
		}

		if (ConfigHandler.addSillyCrop) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Airy");
			list.add(stack);
		}

		if (EnviroChecks.isBloodMagicLoaded() && ConfigHandler.enableBloodMagicCompat) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Blood");
			list.add(stack);
		}

		if (EnviroChecks.isThaumcraftLoaded() && ConfigHandler.enableThaumcraftCompat) {
			ItemStack stack = new ItemStack(this);
			OreDictHandler.setCompound(stack);
			stack.getTagCompound().setString("ore", "Primal");
			list.add(stack);
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		if (stack.hasTagCompound()) {
			return String.format(TextHelper.localize("tile.RCrops.crop.name"), stack.stackTagCompound.getString("ore"));
		} else {
			return String.format(TextHelper.localize("tile.RCrops.crop.name"), "Null");
		}
	}
}
