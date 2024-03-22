package net.chubby.dm.screen;

import net.chubby.dm.DemonsUnleased;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<EctoplasmExtractorScreenHandler> ECTOPLASM_EXTRACTOR_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(DemonsUnleased.MOD_ID, "ectoplasm_extract"),
                    new ExtendedScreenHandlerType<>(EctoplasmExtractorScreenHandler::new));
    public static final ScreenHandlerType<AlloyFurnaceScreen> ALlOY_SMELTER_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(DemonsUnleased.MOD_ID, "alloy_smelter"),
                    new ExtendedScreenHandlerType<>(AlloyFurnaceScreen::new));
    public static final ScreenHandlerType<DungeonChestScreenHandler> DUNGEON_CHEST_SCREEN =
            Registry.register(Registries.SCREEN_HANDLER, new Identifier(DemonsUnleased.MOD_ID, "dungeon_chest"),
                    new ExtendedScreenHandlerType<>((int syncId, PlayerInventory playerInventory, PacketByteBuf blockEntity) -> new DungeonChestScreenHandler(syncId, playerInventory, blockEntity)));

    public static void registerScreenHandlers() {
        DemonsUnleased.LOGGER.info("Registering Screen Handlers for " + DemonsUnleased.MOD_ID);
    }
}
