package net.chubby.dm.datagen;

import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> INFERNITE_SMELTABLES = List.of(ModItems.RAW_INFERNITE,
            ModBlocks.ORE_INFERNITE);
    private static final List<ItemConvertible> ABBYSIUM_SMELTABLES = List.of(ModItems.RAW_ABBYSIUM,
            ModBlocks.ORE_ABBYSIUM);
    private static final List<ItemConvertible> FROSTBITE_SMELTABLES = List.of(ModBlocks.ORE_FROSTBITE);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }



    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter,INFERNITE_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_INFERNITE,
                .5f,150,"infernite");
        offerBlasting(exporter,INFERNITE_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_INFERNITE,
                .5f,75,"infernite");
        offerSmelting(exporter,ABBYSIUM_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_ABBYSIUM,
                .5f,150,"abbysium");
        offerBlasting(exporter,ABBYSIUM_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_ABBYSIUM,
                .5f,75,"abbysium");
        offerSmelting(exporter,FROSTBITE_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_FROSTBITE,
                .5f,75,"frostbite");
        offerBlasting(exporter,FROSTBITE_SMELTABLES, RecipeCategory.MISC,ModItems.INGOT_FROSTBITE,
                .5f,75,"frostbite");


        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS,ModItems.INGOT_INFERNITE,
                RecipeCategory.MISC,ModBlocks.BLOCK_INFERNITE);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS,ModItems.INGOT_ABBYSIUM,
                RecipeCategory.MISC,ModBlocks.BLOCK_ABBYSIUM);
        offerReversibleCompactingRecipes(exporter,RecipeCategory.BUILDING_BLOCKS,ModItems.INGOT_FROSTBITE,
                RecipeCategory.MISC,ModBlocks.BLOCK_FROSTBITE);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_SWORD,1)
                .pattern(" S ")
                .pattern(" S ")

                .pattern(" R ")
                .input('S',ModItems.INGOT_ABBYSIUM)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_SWORD)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_PICKAXE,1)
                .pattern("SSS")
                .pattern(" R ")
                .pattern(" R ")

                .input('S',ModItems.INGOT_ABBYSIUM)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_PICKAXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_AXE,1)
                .pattern("SS")
                .pattern("SR")
                .pattern(" R")
                .input('S',ModItems.INGOT_ABBYSIUM)
                .input('R', Items.STICK)
                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_AXE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_HELMET,1)
                .pattern("SSS")
                .pattern("S S")

                .input('S',ModItems.INGOT_ABBYSIUM)
                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_HELMET)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_CHESTPLATE,1)
                .pattern("S S")
                .pattern("SSS")
                .pattern("SSS")
                .input('S',ModItems.INGOT_ABBYSIUM)

                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_CHESTPLATE)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_LEGGINGS,1)
                .pattern("SSS")
                .pattern("S S")
                .pattern("S S")
                .input('S',ModItems.INGOT_ABBYSIUM)

                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_LEGGINGS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.ABBYSIUM_BOOTS,1)
                .pattern("S S")
                .pattern("S S")

                .input('S',ModItems.INGOT_ABBYSIUM)

                .criterion(hasItem(ModItems.INGOT_ABBYSIUM),conditionsFromItem(ModItems.INGOT_ABBYSIUM))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.ABBYSIUM_BOOTS)));
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC,ModItems.SPECTRAL_SWORD,1)
                .pattern("S")
                .pattern("F")
                .pattern("R")
                .input('S',ModItems.SPECTRAL_INFUSED_NETHERITE)
                .input('R',ModItems.SPECTRAL_INFUSED_GOLD)
                .input('F',ModItems.SPECTRAL_INFUSED_IRON)
                .criterion(hasItem(ModItems.SPECTRAL_INFUSED_NETHERITE),conditionsFromItem(ModItems.SPECTRAL_INFUSED_NETHERITE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SPECTRAL_INFUSED_NETHERITE)));
    }


}
