package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModWoods {

    public static final Block SYLVANHEARTWOOD_PLANKS = registerBlock("sylvanheartwood_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)));


    public static final Block WHISPERWOOD_PLANK = registerBlock("whisperwood_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block ECLIPSE_PLANK = registerBlock("eclipse_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block GLOWWOOD_PLANK = registerBlock("glowwood_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));

    public static final Block EMBERWOOD_PLANK = registerBlock("emberwood_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));

    public static final Block WHISPERWOOD_DOOR = registerBlock("whisperwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block WHISPERWOOD_TRAPDOOR = registerBlock("whisperwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block WHISPERWOOD_FENCE = registerBlock("whisperwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block WHISPERWOOD_FENCE_GATE = registerBlock("whisperwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block WHISPERWOOD_BUTTON = registerBlock("whisperwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block WHISPERWOOD_SLAB = registerBlock("whisperwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block WHISPERWOOD_STAIR = registerBlock("whisperwood_stair",
            new StairsBlock(ModWoods.WHISPERWOOD_PLANK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));

    public static final Block EMBERWOOD_DOOR = registerBlock("emberwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block EMBERWOOD_TRAPDOOR = registerBlock("emberwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block EMBERWOOD_FENCE = registerBlock("emberwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block EMBERWOOD_FENCE_GATE = registerBlock("emberwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block EMBERWOOD_BUTTON = registerBlock("emberwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block EMBERWOOD_SLAB = registerBlock("emberwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block EMBERWOOD_STAIR = registerBlock("emberwood_stair",
            new StairsBlock(ModWoods.WHISPERWOOD_PLANK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));

    public static final Block EMBERWOOD_PRESSURE_PLATE = registerBlock("emberwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));

    public static final Block ECLIPSE_DOOR = registerBlock("eclipse_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block ECLIPSE_TRAPDOOR = registerBlock("eclipse_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block ECLIPSE_FENCE = registerBlock("eclipse_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block ECLIPSE_FENCE_GATE = registerBlock("eclipse_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block ECLIPSE_BUTTON = registerBlock("eclipse_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block ECLIPSE_SLAB = registerBlock("eclipse_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block ECLIPSE_STAIR = registerBlock("eclipse_stair",
            new StairsBlock(ModWoods.ECLIPSE_PLANK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));

    public static final Block ECLIPSE_PRESSURE_PLATE = registerBlock("eclipse_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));
    public static final Block WHISPERWOOD_PRESSURE_PLATE = registerBlock("whisperwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));

    public static final Block WHISPERWOOD_LOG = registerBlock("whisperwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block WHISPERWOOD_WOOD = registerBlock("whisperwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_WHISPERWOOD_LOG = registerBlock("stripped_whisperwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_WHISPERWOOD_WOOD = registerBlock("stripped_whisperwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));
    public static final Block MYSTICGROOVETIMBER_PLANK = registerBlock("mysticgroovetimber_plank",
            new Block(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));

    public static final Block EMBERWOOD_LOG = registerBlock("emberwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block EMBERWOOD_WOOD = registerBlock("emberwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_EMBERWOOD_LOG = registerBlock("stripped_emberwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_EMBERWOOD_WOOD = registerBlock("stripped_emberwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));


    public static final Block MYSTICGROOVETIMBER_DOOR = registerBlock("mysticgroovetimber_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block MYSTICGROOVETIMBER_TRAPDOOR = registerBlock("mysticgroovetimber_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block MYSTICGROOVETIMBER_FENCE = registerBlock("mysticgroovetimber_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block MYSTICGROOVETIMBER_FENCE_GATE = registerBlock("mysticgroovetimber_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block MYSTICGROOVETIMBER_BUTTON = registerBlock("mysticgroovetimber_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block MYSTICGROOVETIMBER_SLAB = registerBlock("mysticgroovetimber_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block MYSTICGROOVETIMBER_STAIR = registerBlock("mysticgroovetimber_stair",
            new StairsBlock(ModWoods.MYSTICGROOVETIMBER_PLANK.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));
    public static final Block MYSTICGROOVETIMBER_PRESSURE_PLATE = registerBlock("mysticgroovetimber_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));

    public static final Block MYSTICGROOVETIMBER_LOG = registerBlock("mysticgroovetimber_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block MYSTICGROOVETIMBER_WOOD = registerBlock("mysticgroovetimber_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_MYSTICGROOVETIMBER_LOG = registerBlock("stripped_mysticgroovetimber_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_MYSTICGROOVETIMBER_WOOD = registerBlock("stripped_mysticgroovetimber_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block SYLVANHEARTWOOD_DOOR = registerBlock("sylvanheartwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block SYLVANHEARTWOOD_TRAPDOOR = registerBlock("sylvanheartwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block SYLVANHEARTWOOD_FENCE = registerBlock("sylvanheartwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block SYLVANHEARTWOOD_FENCE_GATE = registerBlock("sylvanheartwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block SYLVANHEARTWOOD_BUTTON = registerBlock("sylvanheartwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block SYLVANHEARTWOOD_SLAB = registerBlock("sylvanheartwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block SYLVANHEARTWOOD_STAIR = registerBlock("sylvanheartwood_stair",
            new StairsBlock(ModWoods.SYLVANHEARTWOOD_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));
    public static final Block SYLVANHEARTWOOD_PRESSURE_PLATE = registerBlock("sylvanheartwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));

    public static final Block GLOWWOOD_DOOR = registerBlock("glowwood_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_DOOR).strength(4f), BlockSetType.OAK
            ));
    public static final Block GLOWWOOD_TRAPDOOR = registerBlock("glowwood_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),BlockSetType.OAK
            ));
    public static final Block GLOWWOOD_FENCE = registerBlock("glowwood_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block GLOWWOOD_FENCE_GATE = registerBlock("glowwood_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f),WoodType.OAK
            ));
    public static final Block GLOWWOOD_BUTTON = registerBlock("glowwood_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).strength(4f), BlockSetType.IRON, 10, true));


    public static final Block GLOWWOOD_SLAB = registerBlock("glowwood_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f)
            ));
    public static final Block GLOWWOOD_STAIR = registerBlock("glowwood_stair",
            new StairsBlock(ModWoods.SYLVANHEARTWOOD_PLANKS.getDefaultState(),FabricBlockSettings.copyOf(Blocks.OAK_PLANKS)
            ));
    public static final Block GLOWWOOD_PRESSURE_PLATE = registerBlock("glowwood_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                    FabricBlockSettings.copyOf(Blocks.OAK_PLANKS).strength(4f), BlockSetType.OAK));

    public static final Block SYLVANHEARTWOOD_LOG = registerBlock("sylvanheartwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block SYLVANHEARTWOOD_WOOD = registerBlock("sylvanheartwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_SYLVANHEARTWOOD_LOG = registerBlock("stripped_sylvanheartwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_SYLVANHEARTWOOD_WOOD = registerBlock("stripped_sylvanheartwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block ECLIPSE_LOG = registerBlock("eclipse_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block ECLIPSE_WOOD = registerBlock("eclipse_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_ECLIPSE_LOG = registerBlock("stripped_eclipse_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_ECLIPSE_WOOD = registerBlock("stripped_eclipse_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    public static final Block GLOWWOOD_LOG = registerBlock("glowwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_LOG).strength(4f)));
    public static final Block GLOWWOOD_WOOD = registerBlock("glowwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD).strength(4f)));
    public static final Block STRIPPED_GLOWWOOD_LOG = registerBlock("stripped_glowwood_log",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_BAMBOO_BLOCK).strength(4f)));
    public static final Block STRIPPED_GLOWWOOD_WOOD = registerBlock("stripped_glowwood_wood",
            new PillarBlock(FabricBlockSettings.copyOf(Blocks.STRIPPED_OAK_WOOD).strength(4f)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(DemonsUnleased.MOD_ID, name), block);
    }
    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(DemonsUnleased.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        DemonsUnleased.LOGGER.info("Registering ModWoods for " + DemonsUnleased.MOD_ID);
    }
}
