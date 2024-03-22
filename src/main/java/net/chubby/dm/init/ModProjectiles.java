package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.entity.projectile.ArcaneOrbProjectileEntity;
import net.chubby.dm.entity.projectile.FrostBoltProjectileEntity;
import net.chubby.dm.entity.projectile.InfernoOrbProjectileEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModProjectiles
{
    public static final EntityType<InfernoOrbProjectileEntity> INFERNO_ORB_PROJECTILE_ENTITY =
            Registry.register(Registries.ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID,
                    "inferno_orb_projectile_entity"), FabricEntityTypeBuilder.<InfernoOrbProjectileEntity>create(
                            SpawnGroup.MISC,InfernoOrbProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build()
            );
    public static final EntityType<ArcaneOrbProjectileEntity> ARCANE_ORB_PROJECTILE_ENTITY =
            Registry.register(Registries.ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID,
                    "arcane_orb_projectile_entity"), FabricEntityTypeBuilder.<ArcaneOrbProjectileEntity>create(
                            SpawnGroup.MISC,ArcaneOrbProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build()
            );
    public static final EntityType<FrostBoltProjectileEntity> FROST_BOLT_PROJECTILE_ENTITY =
            Registry.register(Registries.ENTITY_TYPE, new Identifier(DemonsUnleased.MOD_ID,
                    "frost_bolt_projectile_entity"), FabricEntityTypeBuilder.<FrostBoltProjectileEntity>create(
                            SpawnGroup.MISC,FrostBoltProjectileEntity::new)
                    .dimensions(EntityDimensions.fixed(0.25f,0.25f)).build()
            );
}
