package io.github.cputnama11y.anvilshattering;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import org.jspecify.annotations.NullMarked;

import java.util.concurrent.ThreadLocalRandom;

@NullMarked
public class AnvilShatteringRecipe extends SingleItemRecipe {
    public static final Serializer SERIALIZER = new Serializer();
    private final int variance;

    public AnvilShatteringRecipe(String string, Ingredient ingredient, ItemStack itemStack, int variance) {
        super(string, ingredient, itemStack);
        this.variance = variance;
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public ItemStack result() {
        return super.result();
    }

    public int variance() {
        return this.variance;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleRecipeInput, HolderLookup.Provider provider) {
        var stack = super.assemble(singleRecipeInput, provider);
        if (variance != 0)
            stack.setCount(stack.getCount() + ThreadLocalRandom.current().nextInt(-variance, variance + 1));
        return stack;
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return AnvilShatteringRecipeTypes.SHATTERING;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return AnvilShatteringRecipeCategories.ANVIL_SHATTERING;
    }

    public static final class Serializer implements RecipeSerializer<AnvilShatteringRecipe> {
        private static final MapCodec<AnvilShatteringRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(SingleItemRecipe::group),
                Ingredient.CODEC.fieldOf("ingredient").forGetter(SingleItemRecipe::input),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(AnvilShatteringRecipe::result),
                Codec.INT.optionalFieldOf("variance", 0).forGetter(AnvilShatteringRecipe::variance)
        ).apply(instance, AnvilShatteringRecipe::new));
        private static final StreamCodec<RegistryFriendlyByteBuf, AnvilShatteringRecipe> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.STRING_UTF8,
                SingleItemRecipe::group,
                Ingredient.CONTENTS_STREAM_CODEC,
                SingleItemRecipe::input,
                ItemStack.STREAM_CODEC,
                AnvilShatteringRecipe::result,
                ByteBufCodecs.VAR_INT,
                AnvilShatteringRecipe::variance,
                AnvilShatteringRecipe::new
        );

        private Serializer() {
        }

        public MapCodec<AnvilShatteringRecipe> codec() {
            return CODEC;
        }

        public StreamCodec<RegistryFriendlyByteBuf, AnvilShatteringRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
