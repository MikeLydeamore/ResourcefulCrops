package main.resourcecrops;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import main.resourcecrops.blocks.BlockRecipeRegistry;
import main.resourcecrops.blocks.BlockRegistry;
import main.resourcecrops.client.gui.CreativeTabRCrops;
import main.resourcecrops.items.ItemRecipeRegistry;
import main.resourcecrops.items.ItemRegistry;
import main.resourcecrops.proxies.CommonProxy;
import main.resourcecrops.util.GenerationHandler;
import main.resourcecrops.util.OreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tterrag.core.common.Handlers;

import java.io.File;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class ResourcefulCrops {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabRCrops = new CreativeTabRCrops(ModInformation.ID + ".creativeTab");
	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static ResourcefulCrops instance;

	public static String mcPath;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.INSTANCE.initialize(new File(event.getModConfigurationDirectory() + "/" + ModInformation.NAME + "/" + ModInformation.NAME + ".cfg"));

		mcPath = event.getModConfigurationDirectory().getParent();

		OreDictHandler.initEarly();
		Handlers.addPackage("main.resourcecrops");

		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		ItemRegistry.init();
		BlockRegistry.init();

		ItemRecipeRegistry.init();
		BlockRecipeRegistry.init();

		OreDictHandler.initLate();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}
}
