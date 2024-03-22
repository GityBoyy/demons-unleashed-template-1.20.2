package net.chubby.dm.entity.bosses.model;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.bosses.FrostGiantBoss;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class FrostGiantModel extends GeoModel<FrostGiantBoss> {
    @Override
    public Identifier getModelResource(FrostGiantBoss animatable) {
        return new Identifier(DemonsUnleased.MOD_ID,"geo/frost_giant.geo.json");
    }

    @Override
    public Identifier getTextureResource(FrostGiantBoss animatable) {
        return new Identifier(DemonsUnleased.MOD_ID,"textures/entity/frost_giant.png");
    }

    @Override
    public Identifier getAnimationResource(FrostGiantBoss animatable) {
        return new Identifier(DemonsUnleased.MOD_ID,"animations/frost_giant.animation.json");
    }

    @Override
    public void setCustomAnimations(FrostGiantBoss animatable, long instanceId, AnimationState<FrostGiantBoss> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * MathHelper.RADIANS_PER_DEGREE);
            head.setRotY(entityData.netHeadYaw() * MathHelper.RADIANS_PER_DEGREE);
        }
    }
}
