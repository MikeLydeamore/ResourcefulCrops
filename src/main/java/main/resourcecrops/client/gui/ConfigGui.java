package main.resourcecrops.client.gui;

import main.resourcecrops.ConfigHandler;
import main.resourcecrops.util.TextHelper;
import net.minecraft.client.gui.GuiScreen;
import tterrag.core.api.common.config.IConfigHandler;
import tterrag.core.client.config.BaseConfigGui;


public class ConfigGui extends BaseConfigGui {
	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen);
	}

	@Override
	protected IConfigHandler getConfigHandler() {
		return ConfigHandler.INSTANCE;
	}

	@Override
	protected String getTitle() {
		return TextHelper.localize("config.RCrops.title");
	}
}