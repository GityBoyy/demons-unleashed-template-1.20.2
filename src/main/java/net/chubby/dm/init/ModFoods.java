package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.util.ModFoodComponents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModFoods
{
    public static final Item BOILED_MILK_BUCKET = registerFoods("boiled_milk_bucket",new Item(new Item.Settings().food(ModFoodComponents.BOILED_MILK_BUCKET)));

    private static Item registerFoods(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DemonsUnleased.MOD_ID,name),item);
    }

    public static void registerModFoods() {
        DemonsUnleased.LOGGER.info("Registering Mod Foods for " + DemonsUnleased.MOD_ID);

    }
}
