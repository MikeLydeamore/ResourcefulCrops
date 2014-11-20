package main.resourcecrops;

import tterrag.core.common.config.AbstractConfigHandler;

public class ConfigHandler extends AbstractConfigHandler {

	public static final ConfigHandler INSTANCE = new ConfigHandler();

	private ConfigHandler() {
		super(ModInformation.ID);
	}

	// Sections to add to the config
	public static final String balancing = "Balancing";
	public static final String lists = "Lists";
	public static final String compat = "Compatability";
	public static final String misc = "Miscellaneous";
	public static final String world = "World";

	// Options in the config
	public static String[] oreDictBlacklistIngot = { "Brick", "BrickNether", "Blutonium", "Cyanite", "Graphite", "Ludicrite", "Thaumium", "Void", "Manasteel", "ElvenElementium", "Terrasteel", "Meat", "MeatRaw", "ElectricalSteel", "EnergeticAlloy", "PhasedGold", "RedstoneAlloy", "ConductiveIron", "PhasedIron", "DarkSteel", "Soularium", "Obsidian", "PigIron", "Unstable", "FzDarkIron", "ElectrumFlux", "IronCompressed", "GelidEnderium", "Alloy", "RefinedObsidian", "RefinedGlowstone" };
	public static String[] oreDictBlacklistDust = { "NetherQuartz", "Fluix", "Ashes", "Wheat", "Ash", "Wood", "Plastic", "Aluminium", "AluminiumBrass", "EnderPearl", "ElectrumFlux", "Cinnabar", "Silicon", "RefinedObsidian", "Salt" };
	public static String[] oreDictBlacklistGem = { "CrystalFlux", "Gelid" };
	public static String[] extraMaterialWhitelist = { "Enderpearl", "GhastTear", "RottenFlesh", "String", "Slimeball", "Bone" };
	public static boolean addSillyCrop = true;

	public static boolean enableBloodMagicCompat = true;
	public static boolean enableThaumcraftCompat = true;

	public static boolean logOreDictEntries = false;

	public static boolean enableGeneration = true;
	public static int gaianiteOreMaxY = 40;

	@Override
	protected void init() {
		addSection(balancing, balancing, "Hello, I am OP. Nice to meet you.");
		addSection(lists, lists, "Hey, look! It's a list of lists!");
		addSection(compat, compat, "Don't like mod interaction? Here's your place to check!");
		addSection(misc, misc);
		addSection(world, world, "World settings.");
	}

	@Override
	protected void reloadNonIngameConfigs() {
		activateSection(balancing);
		// Do stuff

		activateSection(lists);
		oreDictBlacklistIngot = getValue("oreDictBlacklistIngot", "Blacklist specific ingots from getting a seed. Do not add the prefix.", oreDictBlacklistIngot, RestartReqs.REQUIRES_WORLD_RESTART);
		oreDictBlacklistDust = getValue("oreDictBlacklistDust", "Blacklist specific dusts from getting a seed. Do not add the prefix.", oreDictBlacklistDust, RestartReqs.REQUIRES_WORLD_RESTART);
		oreDictBlacklistGem = getValue("oreDictBlacklistGem", "Blacklist specific gems from getting a seed. Do not add the prefix.", oreDictBlacklistGem, RestartReqs.REQUIRES_WORLD_RESTART);
		extraMaterialWhitelist = getValue("extraMaterialWhitelist", "Whitelist of supported materials not found in the OreDict. Adding new entries doesn't do anything.", extraMaterialWhitelist, RestartReqs.REQUIRES_WORLD_RESTART);
		addSillyCrop = getValue("addSillyCrop", "The silliest in the land.", addSillyCrop, RestartReqs.REQUIRES_WORLD_RESTART);

		activateSection(compat);
		enableBloodMagicCompat = getValue("enableBloodMagicCompat", enableBloodMagicCompat, RestartReqs.REQUIRES_MC_RESTART);
		enableThaumcraftCompat = getValue("enableThaumcraftCompat", enableThaumcraftCompat , RestartReqs.REQUIRES_MC_RESTART);

		activateSection(misc);
		logOreDictEntries = getValue("logOreDictEntries", "Creates a text file with a list of every OreDict entry.", logOreDictEntries, RestartReqs.REQUIRES_MC_RESTART);

		activateSection(world);
		enableGeneration = getValue("enableGeneration", "Enables worldgen for ores.", enableGeneration, RestartReqs.REQUIRES_MC_RESTART);
		gaianiteOreMaxY = getValue("gaianiteOreMaxY", "Max Y level of Gaianite Ore generation.", gaianiteOreMaxY, RestartReqs.REQUIRES_WORLD_RESTART);
	}

	@Override
	protected void reloadIngameConfigs() {

	}

	public static boolean checkIngotBlacklist(String entry) {
		int i;
		for (i = 0; i < oreDictBlacklistIngot.length; i++) {
			if(oreDictBlacklistIngot[i].equals(entry)) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkDustBlacklist(String entry) {
		int i;
		for (i = 0; i < oreDictBlacklistDust.length; i++) {
			if(oreDictBlacklistDust[i].equals(entry) || entry.startsWith("Tiny") || entry.startsWith("Small") || entry.startsWith("Dirty")) {
				return true;
			}
		}
		return false;
	}

	public static boolean checkGemBlacklist(String entry) {
		int i;
		for (i = 0; i < oreDictBlacklistGem.length; i++) {
			if(oreDictBlacklistGem[i].equals(entry)) {
				return true;
			}
		}
		return false;
	}
}
