package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.recipe.AlloySmelterRecipe;
import net.chubby.dm.recipe.EctoplasmRecipe;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipe {
    public static void registerRecipes() {
        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(DemonsUnleased.MOD_ID, EctoplasmRecipe.Serializer.ID),
                EctoplasmRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(DemonsUnleased.MOD_ID, EctoplasmRecipe.Type.ID),
                EctoplasmRecipe.Type.INSTANCE);

        Registry.register(Registries.RECIPE_SERIALIZER, new Identifier(DemonsUnleased.MOD_ID, AlloySmelterRecipe.Serializer.ID),
                AlloySmelterRecipe.Serializer.INSTANCE);
        Registry.register(Registries.RECIPE_TYPE, new Identifier(DemonsUnleased.MOD_ID, AlloySmelterRecipe.Type.ID),
                AlloySmelterRecipe.Type.INSTANCE);
    }
}
