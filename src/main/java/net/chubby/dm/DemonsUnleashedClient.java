package net.chubby.dm;

import net.chubby.dm.entity.client.EntityBlazeLegRenderer;
import net.chubby.dm.entity.creatures.model.BlazeLegModel;
import net.chubby.dm.entity.guardians.model.IceBlazeModel;
import net.chubby.dm.entity.renderer.EntityIceBlazeRenderer;
import net.chubby.dm.entity.renderer.FrostGiantRenderer;
import net.chubby.dm.event.PlayerEventHandler;
import net.chubby.dm.init.ModEntities;
import net.chubby.dm.entity.client.EntityShadowLurkerRenderer;
import net.chubby.dm.entity.client.ModModelLayers;
import net.chubby.dm.entity.creatures.model.ShadowLurkerModel;
import net.chubby.dm.init.ModProjectiles;
import net.chubby.dm.screen.AlloyFurnaceScreenHandler;
import net.chubby.dm.screen.EctoplasmExtractorScreen;
import net.chubby.dm.screen.ModScreenHandlers;
import net.chubby.dm.util.MilkCauldronBehaviour;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;

public class DemonsUnleashedClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        HandledScreens.register(ModScreenHandlers.ECTOPLASM_EXTRACTOR_SCREEN, EctoplasmExtractorScreen::new);
        HandledScreens.register(ModScreenHandlers.ALlOY_SMELTER_SCREEN, AlloyFurnaceScreenHandler::new);

        EntityRendererRegistry.register(ModEntities.SHADOW_LURKER, EntityShadowLurkerRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SHADOW_LURKER, ShadowLurkerModel::getTexturedModelData);

        EntityRendererRegistry.register(ModEntities.BLAZE_LEG, EntityBlazeLegRenderer::new);
        EntityRendererRegistry.register(ModEntities.ICE_BLAZE, EntityIceBlazeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BLAZE_LEG, BlazeLegModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.ICE_BLAZE, IceBlazeModel::getTexturedModelData);

        EntityRendererRegistry.register(ModProjectiles.INFERNO_ORB_PROJECTILE_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModProjectiles.ARCANE_ORB_PROJECTILE_ENTITY, FlyingItemEntityRenderer::new);
        EntityRendererRegistry.register(ModProjectiles.FROST_BOLT_PROJECTILE_ENTITY, FlyingItemEntityRenderer::new);

        EntityRendererRegistry.register(ModEntities.Frost_GIANT_BOSS, FrostGiantRenderer::new);

        MilkCauldronBehaviour.registerBehaviour();

    }
}
