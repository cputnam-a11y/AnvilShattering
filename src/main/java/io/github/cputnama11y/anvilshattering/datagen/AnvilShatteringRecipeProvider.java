package io.github.cputnama11y.anvilshattering.datagen;

import io.github.cputnama11y.anvilshattering.AnvilShattering;
import io.github.cputnama11y.anvilshattering.AnvilShatteringRecipe;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

class AnvilShatteringRecipeProvider extends FabricRecipeProvider {
    public AnvilShatteringRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.TRANSPORTATION, Items.COPPER_HORSE_ARMOR)
                        .pattern("  C")
                        .pattern("CSC")
                        .pattern("C C")
                        .define('C', ConventionalItemTags.COPPER_INGOTS)
                        .define('S', Items.LEATHER_HORSE_ARMOR)
                        .unlockedBy("has_leather_horse_armor", has(Items.LEATHER_HORSE_ARMOR))
                        .unlockedBy("has_copper_ingot", has(ConventionalItemTags.COPPER_INGOTS))
                        .save(this.output, ident("copper_horse_armor_from_leather"));
                shaped(RecipeCategory.TRANSPORTATION, Items.IRON_HORSE_ARMOR)
                        .pattern("  I")
                        .pattern("ISI")
                        .pattern("I I")
                        .define('I', ConventionalItemTags.IRON_INGOTS)
                        .define('S', Items.COPPER_HORSE_ARMOR)
                        .unlockedBy("has_copper_horse_armor", has(Items.COPPER_HORSE_ARMOR))
                        .unlockedBy("has_iron_ingot", has(ConventionalItemTags.IRON_INGOTS))
                        .save(this.output, ident("iron_horse_armor_from_copper"));
                shaped(RecipeCategory.TRANSPORTATION, Items.GOLDEN_HORSE_ARMOR)
                        .pattern("  G")
                        .pattern("GSG")
                        .pattern("G G")
                        .define('G', ConventionalItemTags.GOLD_INGOTS)
                        .define('S', Items.IRON_HORSE_ARMOR)
                        .unlockedBy("has_iron_horse_armor", has(Items.IRON_HORSE_ARMOR))
                        .unlockedBy("has_gold_ingot", has(ConventionalItemTags.GOLD_INGOTS))
                        .save(this.output, ident("gold_horse_armor_from_iron"));
                shaped(RecipeCategory.TRANSPORTATION, Items.DIAMOND_HORSE_ARMOR)
                        .pattern("  D")
                        .pattern("DSD")
                        .pattern("D D")
                        .define('D', ConventionalItemTags.DIAMOND_GEMS)
                        .define('S', Items.GOLDEN_HORSE_ARMOR)
                        .unlockedBy("has_gold_horse_armor", has(Items.GOLDEN_HORSE_ARMOR))
                        .unlockedBy("has_diamond", has(ConventionalItemTags.DIAMOND_GEMS))
                        .save(this.output, ident("diamond_horse_armor_from_gold"));
                shaped(RecipeCategory.COMBAT, Items.COPPER_NAUTILUS_ARMOR)
                        .pattern("CCC")
                        .pattern("CSC")
                        .pattern(" CC")
                        .define('C', ConventionalItemTags.COPPER_INGOTS)
                        .define('S', Items.BUNDLE)
                        .unlockedBy("has_nautilus_armor", has(Items.BUNDLE))
                        .unlockedBy("has_copper_ingot", has(ConventionalItemTags.COPPER_INGOTS))
                        .save(this.output, ident("copper_nautilus_armor"));
                shaped(RecipeCategory.COMBAT, Items.IRON_NAUTILUS_ARMOR)
                        .pattern("III")
                        .pattern("ISI")
                        .pattern(" II")
                        .define('I', ConventionalItemTags.IRON_INGOTS)
                        .define('S', Items.COPPER_NAUTILUS_ARMOR)
                        .unlockedBy("has_copper_nautilus_armor", has(Items.COPPER_NAUTILUS_ARMOR))
                        .unlockedBy("has_iron_ingot", has(ConventionalItemTags.IRON_INGOTS))
                        .save(this.output, ident("iron_nautilus_armor"));
                shaped(RecipeCategory.COMBAT, Items.GOLDEN_NAUTILUS_ARMOR)
                        .pattern("GGG")
                        .pattern("GSG")
                        .pattern(" GG")
                        .define('G', ConventionalItemTags.GOLD_INGOTS)
                        .define('S', Items.IRON_NAUTILUS_ARMOR)
                        .unlockedBy("has_iron_nautilus_armor", has(Items.IRON_NAUTILUS_ARMOR))
                        .unlockedBy("has_gold_ingot", has(ConventionalItemTags.GOLD_INGOTS))
                        .save(this.output, ident("gold_nautilus_armor"));
                shaped(RecipeCategory.COMBAT, Items.DIAMOND_NAUTILUS_ARMOR)
                        .pattern("DDD")
                        .pattern("DSD")
                        .pattern(" DD")
                        .define('D', ConventionalItemTags.DIAMOND_GEMS)
                        .define('S', Items.GOLDEN_NAUTILUS_ARMOR)
                        .unlockedBy("has_gold_nautilus_armor", has(Items.GOLDEN_NAUTILUS_ARMOR))
                        .unlockedBy("has_diamond", has(ConventionalItemTags.DIAMOND_GEMS))
                        .save(this.output, ident("diamond_nautilus_armor"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.COPPER_HORSE_ARMOR), Items.COPPER_NUGGET, 62, 2)
                        .unlockedBy("has_copper_horse_armor", has(Items.COPPER_HORSE_ARMOR))
                        .save(this.output, ident("copper_horse_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.IRON_HORSE_ARMOR), Items.IRON_NUGGET, 62, 2)
                        .unlockedBy("has_iron_horse_armor", has(Items.IRON_HORSE_ARMOR))
                        .save(this.output, ident("iron_horse_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.GOLDEN_HORSE_ARMOR), Items.GOLD_NUGGET, 62, 2)
                        .unlockedBy("has_golden_horse_armor", has(Items.GOLDEN_HORSE_ARMOR))
                        .save(this.output, ident("golden_horse_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_HORSE_ARMOR), Items.DIAMOND, 9, 2)
                        .unlockedBy("has_diamond_horse_armor", has(Items.DIAMOND_HORSE_ARMOR))
                        .save(this.output, ident("diamond_horse_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.NETHERITE_HORSE_ARMOR), Items.NETHERITE_SCRAP, 15, 4)
                        .unlockedBy("has_netherite_horse_armor", has(Items.NETHERITE_HORSE_ARMOR))
                        .save(this.output, ident("netherite_horse_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.STONE), Items.COBBLESTONE, 3, 1)
                        .unlockedBy("has_cobblestone", has(Items.STONE))
                        .save(this.output, ident("stone_shattering"));

                shattering(RecipeCategory.MISC, Ingredient.of(Items.COPPER_NAUTILUS_ARMOR), Items.COPPER_NUGGET, 62, 2)
                        .unlockedBy("has_copper_nautilus_armor", has(Items.COPPER_NAUTILUS_ARMOR))
                        .save(this.output, ident("copper_nautilus_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.IRON_NAUTILUS_ARMOR), Items.IRON_NUGGET, 62, 2)
                        .unlockedBy("has_iron_nautilus_armor", has(Items.IRON_NAUTILUS_ARMOR))
                        .save(this.output, ident("iron_nautilus_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.GOLDEN_NAUTILUS_ARMOR), Items.GOLD_NUGGET, 62, 2)
                        .unlockedBy("has_golden_nautilus_armor", has(Items.GOLDEN_NAUTILUS_ARMOR))
                        .save(this.output, ident("golden_nautilus_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.DIAMOND_NAUTILUS_ARMOR), Items.DIAMOND, 9, 2)
                        .unlockedBy("has_diamond_nautilus_armor", has(Items.DIAMOND_NAUTILUS_ARMOR))
                        .save(this.output, ident("diamond_nautilus_armor_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.NETHERITE_NAUTILUS_ARMOR), Items.NETHERITE_SCRAP, 15, 4)
                        .unlockedBy("has_netherite_nautilus_armor", has(Items.NETHERITE_NAUTILUS_ARMOR))
                        .save(this.output, ident("netherite_nautilus_armor_shattering"));

                shattering(RecipeCategory.MISC, Ingredient.of(Items.COBBLESTONE), Items.GRAVEL, 3, 1)
                        .unlockedBy("has_cobblestone", has(Items.COBBLESTONE))
                        .save(this.output, ident("cobblestone_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.GRAVEL), Items.DIRT, 2, 1)
                        .unlockedBy("has_gravel", has(Items.GRAVEL))
                        .save(this.output, ident("gravel_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.DIRT), Items.SAND, 1, 1)
                        .unlockedBy("has_dirt", has(Items.DIRT))
                        .save(this.output, ident("dirt_shattering"));
                shattering(RecipeCategory.MISC, Ingredient.of(Items.LIGHT_GRAY_CONCRETE), Items.CLAY, 1, 0)
                        .unlockedBy("has_light_gray_concrete", has(Items.LIGHT_GRAY_CONCRETE))
                        .save(this.output, ident("light_gray_concrete_shattering"));

            }

            private static SingleItemRecipeBuilder shattering(RecipeCategory category, Ingredient input, ItemLike result, int count, int variance) {
                return new SingleItemRecipeBuilder(category, (group, shadowedInput, output) -> new AnvilShatteringRecipe(group, shadowedInput, output, variance), input, result, count);
            }
        };
    }

    public static String ident(String path) {
        return AnvilShattering.MOD_ID + ":" + path;
    }

    @Override
    public String getName() {
        return "Recipes :)";
    }
}
