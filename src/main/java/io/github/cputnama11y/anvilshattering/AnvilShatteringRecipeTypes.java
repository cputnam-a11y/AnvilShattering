package io.github.cputnama11y.anvilshattering;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.NotNull;

public interface AnvilShatteringRecipeTypes {
    RecipeType<@NotNull AnvilShatteringRecipe> SHATTERING = RecipeType.register("anvil_shattering");

    static <T extends Recipe<?>> RecipeType<@NotNull T> register(final String string) {
        return Registry.register(BuiltInRegistries.RECIPE_TYPE, Identifier.fromNamespaceAndPath(AnvilShattering.MOD_ID, string), new RecipeType<@NotNull T>() {
            public String toString() {
                return string;
            }
        });
    }

    static void init() {

    }
}
