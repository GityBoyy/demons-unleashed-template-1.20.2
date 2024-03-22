package net.chubby.dm.client.rei;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.chubby.dm.client.rei.beCatagories.EctoplasmExtractorCategory;
import net.chubby.dm.client.rei.beCatagories.EctoplasmExtractorDisplay;
import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.recipe.EctoplasmRecipe;
import net.chubby.dm.screen.EctoplasmExtractorScreen;

public class ModREIClientPlugin implements REIClientPlugin
{
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new EctoplasmExtractorCategory());

        registry.addWorkstations(EctoplasmExtractorCategory.ECTOPLASM_EXTRACTOR, EntryStacks.of(ModBlocks.ECTOPLASM_EXTRACTOR));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(EctoplasmRecipe.class, EctoplasmRecipe.Type.INSTANCE,
                EctoplasmExtractorDisplay::new);


    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(screen -> new Rectangle(((screen.width - 176) / 2) + 78,
                        ((screen.height - 166) / 2) + 30, 20, 25),
                EctoplasmExtractorScreen.class,
                EctoplasmExtractorCategory.ECTOPLASM_EXTRACTOR);

    }
}
