package io.github.cputnama11y.anvilshattering;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.RecipeBookCategory;

public interface AnvilShatteringRecipeCategories {
    RecipeBookCategory ANVIL_SHATTERING = register("anvil_shattering");

    private static RecipeBookCategory register(String name) {
        return Registry.register(BuiltInRegistries.RECIPE_BOOK_CATEGORY, Identifier.fromNamespaceAndPath(AnvilShattering.MOD_ID, name), new RecipeBookCategory());
    }

    static void init() {
    }
}
