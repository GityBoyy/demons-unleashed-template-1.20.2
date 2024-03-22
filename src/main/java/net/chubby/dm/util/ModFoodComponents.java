package net.chubby.dm.util;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent BOILED_MILK_BUCKET = new FoodComponent.Builder().hunger(3).alwaysEdible()
            .snack().statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION,100),0.4f).build();
}
