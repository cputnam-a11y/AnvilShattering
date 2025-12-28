package io.github.cputnama11y.anvilshattering;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AnvilShattering implements ModInitializer {
    public static final String MOD_ID = "anvilshattering";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        AnvilShatteringRecipeTypes.init();
        AnvilShatteringRecipeCategories.init();
        AnvilShatteringRecipeSerializers.init();
    }
}