package net.chubby.dm.entity.client;

import net.chubby.dm.DemonsUnleased;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {

    public static final EntityModelLayer SHADOW_LURKER =
            new EntityModelLayer(new Identifier(DemonsUnleased.MOD_ID,"shadow_lurker"),"main");

    public static final EntityModelLayer BLAZE_LEG =
            new EntityModelLayer(new Identifier(DemonsUnleased.MOD_ID,"blaze_leg"),"main");

    public static final EntityModelLayer ICE_BLAZE =
            new EntityModelLayer(new Identifier(DemonsUnleased.MOD_ID,"ice_blaze"),"main");
}
