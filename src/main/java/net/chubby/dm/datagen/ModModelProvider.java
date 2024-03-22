package net.chubby.dm.datagen;

import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.init.ModFoods;
import net.chubby.dm.init.ModWoods;
import net.chubby.dm.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_INFERNITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_ABBYSIUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_INFERNITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_ABBYSIUM);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BLOCK_FROSTBITE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ORE_FROSTBITE);

        BlockStateModelGenerator.BlockTexturePool sylvan_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.SYLVANHEARTWOOD_PLANKS);
        BlockStateModelGenerator.BlockTexturePool mysticgroovetimber_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.MYSTICGROOVETIMBER_PLANK);
        BlockStateModelGenerator.BlockTexturePool eclipse_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.ECLIPSE_PLANK);
        BlockStateModelGenerator.BlockTexturePool whisperwood_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.WHISPERWOOD_PLANK);
        BlockStateModelGenerator.BlockTexturePool glowwood_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.GLOWWOOD_PLANK);
        BlockStateModelGenerator.BlockTexturePool emberwood_pool =
                blockStateModelGenerator.registerCubeAllModelTexturePool(ModWoods.EMBERWOOD_PLANK);

        whisperwood_pool.stairs(ModWoods.WHISPERWOOD_STAIR);
        whisperwood_pool.fence(ModWoods.WHISPERWOOD_FENCE);
        whisperwood_pool.fenceGate(ModWoods.WHISPERWOOD_FENCE_GATE);
        whisperwood_pool.slab(ModWoods.WHISPERWOOD_SLAB);
        whisperwood_pool.button(ModWoods.WHISPERWOOD_BUTTON);
        whisperwood_pool.pressurePlate(ModWoods.WHISPERWOOD_PRESSURE_PLATE);

        sylvan_pool.stairs(ModWoods.SYLVANHEARTWOOD_STAIR);
        sylvan_pool.fence(ModWoods.SYLVANHEARTWOOD_FENCE);
        sylvan_pool.fenceGate(ModWoods.SYLVANHEARTWOOD_FENCE_GATE);
        sylvan_pool.slab(ModWoods.SYLVANHEARTWOOD_SLAB);
        sylvan_pool.button(ModWoods.SYLVANHEARTWOOD_BUTTON);
        sylvan_pool.pressurePlate(ModWoods.SYLVANHEARTWOOD_PRESSURE_PLATE);

        eclipse_pool.stairs(ModWoods.ECLIPSE_STAIR);
        eclipse_pool.fence(ModWoods.ECLIPSE_FENCE);
        eclipse_pool.fenceGate(ModWoods.ECLIPSE_FENCE_GATE);
        eclipse_pool.slab(ModWoods.ECLIPSE_SLAB);
        eclipse_pool.button(ModWoods.ECLIPSE_BUTTON);
        eclipse_pool.pressurePlate(ModWoods.ECLIPSE_PRESSURE_PLATE);

        mysticgroovetimber_pool.stairs(ModWoods.MYSTICGROOVETIMBER_STAIR);
        mysticgroovetimber_pool.fence(ModWoods.MYSTICGROOVETIMBER_FENCE);
        mysticgroovetimber_pool.fenceGate(ModWoods.MYSTICGROOVETIMBER_FENCE_GATE);
        mysticgroovetimber_pool.slab(ModWoods.MYSTICGROOVETIMBER_SLAB);
        mysticgroovetimber_pool.button(ModWoods.MYSTICGROOVETIMBER_BUTTON);
        mysticgroovetimber_pool.pressurePlate(ModWoods.MYSTICGROOVETIMBER_PRESSURE_PLATE);

        glowwood_pool.stairs(ModWoods.GLOWWOOD_STAIR);
        glowwood_pool.fence(ModWoods.GLOWWOOD_FENCE);
        glowwood_pool.fenceGate(ModWoods.GLOWWOOD_FENCE_GATE);
        glowwood_pool.slab(ModWoods.GLOWWOOD_SLAB);
        glowwood_pool.button(ModWoods.GLOWWOOD_BUTTON);
        glowwood_pool.pressurePlate(ModWoods.GLOWWOOD_PRESSURE_PLATE);

        emberwood_pool.stairs(ModWoods.EMBERWOOD_STAIR);
        emberwood_pool.fence(ModWoods.EMBERWOOD_FENCE);
        emberwood_pool.fenceGate(ModWoods.EMBERWOOD_FENCE_GATE);
        emberwood_pool.slab(ModWoods.EMBERWOOD_SLAB);
        emberwood_pool.button(ModWoods.EMBERWOOD_BUTTON);
        emberwood_pool.pressurePlate(ModWoods.EMBERWOOD_PRESSURE_PLATE);

        blockStateModelGenerator.registerDoor(ModWoods.ECLIPSE_DOOR);
        blockStateModelGenerator.registerDoor(ModWoods.WHISPERWOOD_DOOR);
        blockStateModelGenerator.registerDoor(ModWoods.GLOWWOOD_DOOR);
        blockStateModelGenerator.registerDoor(ModWoods.EMBERWOOD_DOOR);
        blockStateModelGenerator.registerDoor(ModWoods.SYLVANHEARTWOOD_DOOR);
        blockStateModelGenerator.registerDoor(ModWoods.MYSTICGROOVETIMBER_DOOR);

        blockStateModelGenerator.registerLog(ModWoods.SYLVANHEARTWOOD_LOG).log(ModWoods.SYLVANHEARTWOOD_LOG)
                .wood(ModWoods.SYLVANHEARTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.MYSTICGROOVETIMBER_LOG).log(ModWoods.MYSTICGROOVETIMBER_LOG)
                .wood(ModWoods.MYSTICGROOVETIMBER_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.ECLIPSE_LOG).log(ModWoods.ECLIPSE_LOG)
                .wood(ModWoods.ECLIPSE_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.WHISPERWOOD_LOG).log(ModWoods.WHISPERWOOD_LOG)
                .wood(ModWoods.WHISPERWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.GLOWWOOD_LOG).log(ModWoods.GLOWWOOD_LOG)
                .wood(ModWoods.GLOWWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.EMBERWOOD_LOG).log(ModWoods.EMBERWOOD_LOG)
                .wood(ModWoods.EMBERWOOD_WOOD);

        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_SYLVANHEARTWOOD_LOG).log(ModWoods.STRIPPED_SYLVANHEARTWOOD_LOG)
                .wood(ModWoods.STRIPPED_SYLVANHEARTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_MYSTICGROOVETIMBER_LOG).log(ModWoods.STRIPPED_MYSTICGROOVETIMBER_LOG)
                .wood(ModWoods.STRIPPED_MYSTICGROOVETIMBER_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_ECLIPSE_LOG).log(ModWoods.STRIPPED_ECLIPSE_LOG)
                .wood(ModWoods.STRIPPED_ECLIPSE_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_WHISPERWOOD_LOG).log(ModWoods.STRIPPED_WHISPERWOOD_LOG)
                .wood(ModWoods.STRIPPED_WHISPERWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_GLOWWOOD_LOG).log(ModWoods.STRIPPED_GLOWWOOD_LOG)
                .wood(ModWoods.STRIPPED_GLOWWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModWoods.STRIPPED_EMBERWOOD_LOG).log(ModWoods.STRIPPED_EMBERWOOD_LOG)
                .wood(ModWoods.STRIPPED_EMBERWOOD_WOOD);



    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.INGOT_INFERNITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_ABBYSIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_FROSTBITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.INGOT_CHILLFIRE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_INFERNITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ECTOPLASM, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPECTRAL_DUST, Models.GENERATED);


        itemModelGenerator.register(ModItems.SPECTRAL_INFUSED_GOLD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPECTRAL_INFUSED_IRON, Models.GENERATED);
        itemModelGenerator.register(ModItems.SPECTRAL_INFUSED_NETHERITE, Models.GENERATED);


        itemModelGenerator.register(ModItems.ABBYSIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ABBYSIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.ABBYSIUM_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.INFERNITE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.INFERNITE_PICKAXE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FROSTBITE_SWORD, Models.HANDHELD);

        itemModelGenerator.register(ModItems.FROSTBITE_PICKAXE, Models.HANDHELD);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.ABBYSIUM_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ABBYSIUM_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ABBYSIUM_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.ABBYSIUM_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.INFERNITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.INFERNITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.INFERNITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.INFERNITE_BOOTS);

        itemModelGenerator.registerArmor((ArmorItem) ModItems.FROSTBITE_BOOTS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FROSTBITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FROSTBITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.FROSTBITE_LEGGINGS);

        itemModelGenerator.register(ModItems.SPECTRAL_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.INFERNO_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.ARCANE_ORB, Models.GENERATED);
        itemModelGenerator.register(ModItems.FROST_BOLT, Models.GENERATED);

        itemModelGenerator.register(ModFoods.BOILED_MILK_BUCKET, Models.GENERATED);

        itemModelGenerator.register(ModItems.BLAZE_LEG_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}
