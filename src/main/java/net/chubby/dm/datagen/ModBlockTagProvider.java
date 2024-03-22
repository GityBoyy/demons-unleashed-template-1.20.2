package net.chubby.dm.datagen;

import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.init.ModWoods;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BLOCK_INFERNITE)
                .add(ModBlocks.BLOCK_ABBYSIUM)
                .add(ModBlocks.BLOCK_FROSTBITE)
                .add(ModBlocks.ORE_ABBYSIUM)
                .add(ModBlocks.ORE_FROSTBITE)
                .add(ModBlocks.ORE_INFERNITE);
        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BLOCK_INFERNITE)
                .add(ModBlocks.BLOCK_ABBYSIUM)
                .add(ModBlocks.ORE_ABBYSIUM)
                .add(ModBlocks.BLOCK_FROSTBITE)
                .add(ModBlocks.ORE_ABBYSIUM)
                .add(ModBlocks.ORE_INFERNITE);
        getOrCreateTagBuilder(BlockTags.FENCES)
                .add(ModWoods.ECLIPSE_FENCE)
                .add(ModWoods.SYLVANHEARTWOOD_FENCE)
                .add(ModWoods.MYSTICGROOVETIMBER_FENCE)
                .add(ModWoods.WHISPERWOOD_FENCE)
                .add(ModWoods.GLOWWOOD_FENCE)
                .add(ModWoods.EMBERWOOD_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModWoods.ECLIPSE_FENCE_GATE)
                .add(ModWoods.SYLVANHEARTWOOD_FENCE_GATE)
                .add(ModWoods.MYSTICGROOVETIMBER_FENCE_GATE)
                .add(ModWoods.WHISPERWOOD_FENCE_GATE)
                .add(ModWoods.GLOWWOOD_FENCE_GATE)
                .add(ModWoods.EMBERWOOD_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModWoods.ECLIPSE_FENCE)
                .add(ModWoods.SYLVANHEARTWOOD_FENCE)
                .add(ModWoods.MYSTICGROOVETIMBER_FENCE)
                .add(ModWoods.WHISPERWOOD_FENCE)
                .add(ModWoods.GLOWWOOD_FENCE)
                .add(ModWoods.ECLIPSE_FENCE_GATE)
                .add(ModWoods.SYLVANHEARTWOOD_FENCE_GATE)
                .add(ModWoods.MYSTICGROOVETIMBER_FENCE_GATE)
                .add(ModWoods.WHISPERWOOD_FENCE_GATE)
                .add(ModWoods.GLOWWOOD_FENCE_GATE)
                .add(ModWoods.EMBERWOOD_FENCE_GATE)

                .add(ModWoods.EMBERWOOD_PLANK)
                .add(ModWoods.MYSTICGROOVETIMBER_PLANK)
                .add(ModWoods.WHISPERWOOD_PLANK)
                .add(ModWoods.SYLVANHEARTWOOD_PLANKS)
                .add(ModWoods.GLOWWOOD_PLANK)
                .add(ModWoods.ECLIPSE_PLANK)
                .add(ModWoods.EMBERWOOD_FENCE);
    }
}
