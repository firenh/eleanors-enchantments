package firenh.eleanorsenchantments;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import firenh.eleanorsenchantments.polymer.itemcheck.ItemChecks;
import net.fabricmc.api.ModInitializer;

public class EleanorsEnchantments implements ModInitializer {
	public static final String MODID = "eleanorsenchantments";
    public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		ItemChecks.init();
	}

	public static void log(String info) {
		LOGGER.info(info);
	}
}