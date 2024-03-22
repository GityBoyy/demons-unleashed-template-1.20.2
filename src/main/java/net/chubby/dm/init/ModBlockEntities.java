package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.blocks.blockEntity.AlloyFurnaceBlockEntity;
import net.chubby.dm.blocks.blockEntity.BoiledMilkBlockEntity;
import net.chubby.dm.blocks.blockEntity.DungeonChestBlockEntity;
import net.chubby.dm.blocks.blockEntity.EctoplasmExtractorEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.awt.geom.RectangularShape;

public class ModBlockEntities {
    public static final BlockEntityType<EctoplasmExtractorEntity> GEM_POLISHING_STATION_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID, "ectoplasm_extractor_be"),
                    FabricBlockEntityTypeBuilder.create(EctoplasmExtractorEntity::new,
                            ModBlocks.ECTOPLASM_EXTRACTOR).build());
    public static final BlockEntityType<AlloyFurnaceBlockEntity> ALLOY_FURNACE_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID, "alloy_furnace_be"),
                    FabricBlockEntityTypeBuilder.create(AlloyFurnaceBlockEntity::new,
                            ModBlocks.ALLOY_FURNACE).build());
    public static final BlockEntityType<DungeonChestBlockEntity> DUNGEON_CHEST_BLOCK_ENTITY =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID, "dungeon_chest_be"),
                    FabricBlockEntityTypeBuilder.create(DungeonChestBlockEntity::new,
                            ModBlocks.DUNGEON_CHEST).build());
    public static final BlockEntityType<BoiledMilkBlockEntity> BOILED_MILK_CAULDRON =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID, "boiled_milk_cauldron"),
                    FabricBlockEntityTypeBuilder.create(BoiledMilkBlockEntity::new,
                            ModBlocks.BOILED_MILK_CAULDRON).build());

    public static void registerBlockEntities() {
        DemonsUnleased.LOGGER.info("Registering Block Entities for " + DemonsUnleased.MOD_ID);
    }
}
