package main.resourcecrops.util;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.resourcecrops.ConfigHandler;
import main.resourcecrops.blocks.BlockBaseCrops;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.oredict.OreDictionary;
import tterrag.core.common.Handlers.Handler;

@Handler
public class EventHandler {

	@SubscribeEvent
	public void onRegisterOreDict(OreDictionary.OreRegisterEvent event) {
		if (ConfigHandler.logOreDictEntries) {
			Utils.writeOreDictLog(event.Ore + " ==> " + event.Name, "OreDict.txt");
		}
	}

	@SubscribeEvent
	public void onBoneMeal(BonemealEvent event) {

		if (event.block instanceof BlockBaseCrops) {
			event.setCanceled(true);
		}
	}
}
