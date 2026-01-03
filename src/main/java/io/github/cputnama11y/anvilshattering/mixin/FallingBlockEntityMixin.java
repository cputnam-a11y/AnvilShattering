package io.github.cputnama11y.anvilshattering.mixin;

import com.google.common.base.Predicates;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import io.github.cputnama11y.anvilshattering.AnvilShatteringRecipe;
import io.github.cputnama11y.anvilshattering.AnvilShatteringRecipeTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.entity.EntityTypeTest;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

import java.util.List;
import java.util.function.Consumer;

@Mixin(FallingBlockEntity.class)
public abstract class FallingBlockEntityMixin extends Entity {
    @Shadow
    private BlockState blockState;
    @Unique
    RecipeManager.CachedCheck<@NotNull SingleRecipeInput, @NotNull AnvilShatteringRecipe> cache = RecipeManager.createCheck(AnvilShatteringRecipeTypes.SHATTERING);

    public FallingBlockEntityMixin(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @WrapOperation(
            method = "causeFallDamage",
            at = @At(value = "INVOKE", target = "Ljava/util/List;forEach(Ljava/util/function/Consumer;)V")
    )

    private void doSmashingRecipes(List<Entity> instance, Consumer<Entity> consumer, Operation<Void> original) {
        if (!(this.blockState.getBlock() instanceof AnvilBlock)) return;
        if (!(this.level() instanceof ServerLevel serverLevel)) {
            original.call(instance, consumer);
            return;
        }

        level().getEntities(
                EntityTypeTest.forClass(ItemEntity.class),
                this.getBoundingBox(),
                Predicates.alwaysTrue()
        ).forEach(item -> {
            var stack = item.getItem();
            var input = new SingleRecipeInput(stack);
            cache.getRecipeFor(input, serverLevel).ifPresent(recipe -> {
                item.discard();
                for (int i = 0; i < stack.getCount(); i++) {
                    var result = recipe.value().assemble(input, serverLevel.registryAccess());
                    if (!result.isEmpty()) {
                        Block.popResource(serverLevel, item.blockPosition().below(), result);
                    }
                }
            });  
        });

        original.call(instance, consumer);
    }
}
