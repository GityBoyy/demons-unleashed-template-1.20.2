package net.chubby.dm.entity.client;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.creatures.EntityBlazeLeg;
import net.chubby.dm.entity.creatures.EntityShadowLurker;
import net.chubby.dm.entity.creatures.model.BlazeLegModel;
import net.chubby.dm.entity.creatures.model.ShadowLurkerModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EntityBlazeLegRenderer extends MobEntityRenderer<EntityBlazeLeg, BlazeLegModel<EntityBlazeLeg>> {

    private static final Identifier TEXTURE = new Identifier(DemonsUnleased.MOD_ID,"textures/entity/blaze_leg.png");
    public EntityBlazeLegRenderer(EntityRendererFactory.Context context) {
        super(context, new BlazeLegModel<>(context.getPart(ModModelLayers.BLAZE_LEG)),0.6f);
    }

    @Override
    public Identifier getTexture(EntityBlazeLeg entity) {
        return TEXTURE;
    }

    @Override
    public void render(EntityBlazeLeg mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
