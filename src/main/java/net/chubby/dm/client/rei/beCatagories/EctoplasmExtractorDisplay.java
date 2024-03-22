package net.chubby.dm.client.rei.beCatagories;

import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chubby.dm.recipe.EctoplasmRecipe;
import net.minecraft.recipe.RecipeEntry;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EctoplasmExtractorDisplay extends BasicDisplay
{
    private RecipeEntry<EctoplasmRecipe> recipe;

    public EctoplasmExtractorDisplay(List<EntryIngredient> inputs, List<EntryIngredient> outputs) {
        super(inputs, outputs);
    }

    public EctoplasmExtractorDisplay(RecipeEntry<EctoplasmRecipe> recipe) {
        super(getInputList(recipe.value()), List.of(EntryIngredient.of(EntryStacks.of(recipe.value().getResult(null)))));
        this.recipe = recipe;
    }

    private static List<EntryIngredient> getInputList(EctoplasmRecipe recipe) {
        if(recipe == null) return Collections.emptyList();
        List<EntryIngredient> list = new ArrayList<>();
        list.add(EntryIngredients.ofIngredient(recipe.getIngredients().get(0)));
        return list;
    }

    public int getCraftTime() {
        return recipe.value().getCraftTime();
    }

    public int getEnergyAmount() {
        return recipe.value().getEnergyAmount();
    }

    public int getTotalEnergyAmount() {
        return getCraftTime() * getEnergyAmount();
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
        return EctoplasmExtractorCategory.ECTOPLASM_EXTRACTOR;
    }
}
