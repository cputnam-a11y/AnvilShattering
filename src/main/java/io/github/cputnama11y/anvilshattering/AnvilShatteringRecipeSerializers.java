package io.github.cputnama11y.anvilshattering;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeBookCategory;
import net.minecraft.world.item.crafting.RecipeSerializer;
import org.jspecify.annotations.NullMarked;

@NullMarked
public interface AnvilShatteringRecipeSerializers {
    RecipeSerializer<AnvilShatteringRecipe> ANVIL_SHATTERING = register(
            "anvil_shattering",
            AnvilShatteringRecipe.SERIALIZER
    );
    private static <T extends Recipe<?>> RecipeSerializer<T> register(String name, RecipeSerializer<T> serializer) {
        return Registry.register(BuiltInRegistries.RECIPE_SERIALIZER, Identifier.fromNamespaceAndPath(AnvilShattering.MOD_ID, name), serializer);
    }

    static void init() {
    }
}
