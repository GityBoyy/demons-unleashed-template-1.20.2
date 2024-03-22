package net.chubby.dm.entity.projectile;

import net.chubby.dm.init.ModItems;
import net.chubby.dm.init.ModProjectiles;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion;

import java.util.List;

public class ArcaneOrbProjectileEntity extends ThrownItemEntity
{
    public ArcaneOrbProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public ArcaneOrbProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModProjectiles.INFERNO_ORB_PROJECTILE_ENTITY,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.INFERNO_ORB;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        World world = this.getEntityWorld();
        BlockPos impactPos = blockHitResult.getBlockPos();
        int explosionRadius = 3;

        if(!world.isClient())
        {
            world.createExplosion(this, impactPos.getX(), impactPos.getY(), impactPos.getZ(), explosionRadius, World.ExplosionSourceType.MOB);

            // Optionally, spawn particles or play sound effects
            world.playSound(null, impactPos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 1.0f, 1.0f);
            world.addParticle(ParticleTypes.EXPLOSION, impactPos.getX(), impactPos.getY(), impactPos.getZ(), 0.0, 0.0, 0.0);
        }

        super.onBlockHit(blockHitResult);
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);

        Entity targetEntity = entityHitResult.getEntity();

        // Apply knockback to the hit entity
        if (targetEntity instanceof LivingEntity) {
            LivingEntity livingEntity = (LivingEntity) targetEntity;
            livingEntity.takeKnockback(0.5f, entityHitResult.getPos().x - this.getX(), entityHitResult.getPos().z - this.getZ());
        }

        // Apply knockback to nearby entities
        double knockbackRadius = 5.0; // Adjust this radius as needed
        List<Entity> nearbyEntities = this.getWorld().getOtherEntities(this, this.getBoundingBox().expand(knockbackRadius),
                entity -> entity instanceof LivingEntity && entity != targetEntity);
        for (Entity nearbyEntity : nearbyEntities) {
            if (nearbyEntity instanceof LivingEntity) {
                LivingEntity nearbyLivingEntity = (LivingEntity) nearbyEntity;
                double deltaX = nearbyLivingEntity.getX() - this.getX();
                double deltaZ = nearbyLivingEntity.getZ() - this.getZ();
                double distance = Math.sqrt(deltaX * deltaX + deltaZ * deltaZ);
                double knockbackStrength = 1.0 - distance / knockbackRadius;
                if (knockbackStrength > 0) {
                    nearbyLivingEntity.takeKnockback((float) knockbackStrength, deltaX, deltaZ);
                }
            }
        }
    }

}
