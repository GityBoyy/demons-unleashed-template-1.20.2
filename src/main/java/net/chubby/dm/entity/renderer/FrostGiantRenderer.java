package net.chubby.dm.entity.renderer;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.bosses.FrostGiantBoss;
import net.chubby.dm.entity.bosses.model.FrostGiantModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FrostGiantRenderer extends GeoEntityRenderer<FrostGiantBoss> {

    public FrostGiantRenderer(EntityRendererFactory.Context renderManager) {
        super(renderManager, new FrostGiantModel());
    }

    @Override
    public Identifier getTextureLocation(FrostGiantBoss animatable) {
        return new Identifier(DemonsUnleased.MOD_ID,"textures/entity/frost_giant.png");
    }

    @Override
    public void render(FrostGiantBoss entity, float entityYaw, float partialTick, MatrixStack poseStack,
                       VertexConsumerProvider bufferSource, int packedLight) {

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
