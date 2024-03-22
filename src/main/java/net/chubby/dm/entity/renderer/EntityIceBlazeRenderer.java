package net.chubby.dm.entity.renderer;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.client.ModModelLayers;
import net.chubby.dm.entity.creatures.model.BlazeLegModel;
import net.chubby.dm.entity.guardians.EntityIceBlaze;
import net.chubby.dm.entity.guardians.model.IceBlazeModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class EntityIceBlazeRenderer extends MobEntityRenderer<EntityIceBlaze, IceBlazeModel<EntityIceBlaze>>
{
    private static final Identifier TEXTURE = new Identifier(DemonsUnleased.MOD_ID,"textures/entity/ice_blaze.png");
    public EntityIceBlazeRenderer(EntityRendererFactory.Context context) {
        super(context, new IceBlazeModel<>(context.getPart(ModModelLayers.ICE_BLAZE)),0.6f);
    }

    @Override
    public Identifier getTexture(EntityIceBlaze entity) {
        return TEXTURE;
    }
}
