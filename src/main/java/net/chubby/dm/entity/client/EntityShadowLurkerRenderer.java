package net.chubby.dm.entity.client;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.creatures.EntityShadowLurker;
import net.chubby.dm.entity.creatures.model.ShadowLurkerModel;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;

import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class EntityShadowLurkerRenderer extends MobEntityRenderer<EntityShadowLurker, ShadowLurkerModel<EntityShadowLurker>> {

    private static final Identifier TEXTURE = new Identifier(DemonsUnleased.MOD_ID,"textures/entity/shadow_lurker.png");
    public EntityShadowLurkerRenderer(EntityRendererFactory.Context context) {
        super(context, new ShadowLurkerModel<>(context.getPart(ModModelLayers.SHADOW_LURKER)),0.6f);
    }

    @Override
    public Identifier getTexture(EntityShadowLurker entity) {
        return TEXTURE;
    }

    @Override
    public void render(EntityShadowLurker mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
