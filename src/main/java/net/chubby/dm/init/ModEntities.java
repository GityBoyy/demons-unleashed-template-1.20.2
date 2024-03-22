package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.bosses.FrostGiantBoss;
import net.chubby.dm.entity.creatures.EntityBlazeLeg;
import net.chubby.dm.entity.creatures.EntityShadowLurker;
import net.chubby.dm.entity.guardians.EntityIceBlaze;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<EntityShadowLurker> SHADOW_LURKER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(DemonsUnleased.MOD_ID, "shadow_lurker"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EntityShadowLurker::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());

    public static final EntityType<EntityBlazeLeg> BLAZE_LEG = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(DemonsUnleased.MOD_ID, "blaze_leg"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EntityBlazeLeg::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 2.9f)).build());

    public static final EntityType<EntityIceBlaze> ICE_BLAZE = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(DemonsUnleased.MOD_ID, "ice_blaze"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, EntityIceBlaze::new)
                    .dimensions(EntityDimensions.fixed(1f,1f)).build());

    public static final EntityType<FrostGiantBoss> Frost_GIANT_BOSS = Registry.register(
            Registries.ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID, "frost_giant"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, FrostGiantBoss::new)
                    .dimensions(EntityDimensions.fixed(3.5f, 2.75f)).build());
}
