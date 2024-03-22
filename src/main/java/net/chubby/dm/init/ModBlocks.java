package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.blocks.custom.*;
import net.chubby.dm.util.MilkCauldronBehaviour;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block BLOCK_INFERNITE = registerBlock("block_infernite",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block BLOCK_ABBYSIUM = registerBlock("block_abbysium",
            new Block(FabricBlockSettings.copyOf(Blocks.NETHERITE_BLOCK)));
    public static final Block BLOCK_FROSTBITE = registerBlock("block_frostbite",
            new Block(FabricBlockSettings.copyOf(Blocks.SNOW_BLOCK).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block ORE_INFERNITE = registerBlock("ore_infernite",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE)));
    public static final Block ORE_FROSTBITE = registerBlock("ore_frostbite",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE)));
    public static final Block ORE_ABBYSIUM = registerBlock("ore_abbysium",
            new Block(FabricBlockSettings.copyOf(Blocks.ANCIENT_DEBRIS).sounds(BlockSoundGroup.STONE)));

    public static final Block ECTOPLASM_EXTRACTOR = registerBlock("ectoplasm_extractor",
            new EctoplasmExtractor(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block ALLOY_FURNACE = registerBlock("alloy_furnace",
            new AlloyFurnace(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block DUNGEON_CHEST = registerBlock("dungeon_chest",
            new DungeonChest(FabricBlockSettings.copyOf(Blocks.CHEST)));
    public static final Block MILK_CAULDRON = registerBlock("milk_cauldron",
            new MilkCauldron(FabricBlockSettings.copyOf(Blocks.CAULDRON), MilkCauldronBehaviour.MILK_CAULDRON_BEHAVIOR));
    public static final Block BOILED_MILK_CAULDRON = registerBlock("boiled_milk_cauldron",
            new BoiledMilkCauldron(FabricBlockSettings.copyOf(Blocks.CAULDRON)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DemonsUnleased.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DemonsUnleased.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        DemonsUnleased.LOGGER.info("Registering ModBlocks for " + DemonsUnleased.MOD_ID);
    }
}
