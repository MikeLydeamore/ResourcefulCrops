package main.resourcecrops.util;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.Side;

public class EnviroChecks {

	public static boolean isThaumcraftLoaded() {
		return Loader.isModLoaded("Thaumcraft");
	}

	public static boolean isBloodMagicLoaded() {
		return Loader.isModLoaded("AWWayofTime");
	}

	public static boolean isOptifineLoaded() {
		return FMLCommonHandler.instance().getSide() == Side.CLIENT && FMLClientHandler.instance().hasOptifine() || Loader.isModLoaded("optifine");
	}
}
