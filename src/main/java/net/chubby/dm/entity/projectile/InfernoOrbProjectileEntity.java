package net.chubby.dm.entity.projectile;

import net.chubby.dm.init.ModEntities;
import net.chubby.dm.init.ModItems;
import net.chubby.dm.init.ModProjectiles;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.projectile.AbstractFireballEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;

public class InfernoOrbProjectileEntity extends ThrownItemEntity {
    public InfernoOrbProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public InfernoOrbProjectileEntity(LivingEntity livingEntity, World world) {
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
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if(!this.getWorld().isClient())
        {
            Entity entity = entityHitResult.getEntity();
            if(entity instanceof LivingEntity)
            {
                LivingEntity livingEntity = (LivingEntity) entity;
                entity.setOnFireFor(5);
            }
        }

        super.onEntityHit(entityHitResult);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if(!this.getWorld().isClient)
        {
            this.getWorld().sendEntityStatus(this, ((byte) 3));
            this.getWorld().setBlockState(getBlockPos(), Blocks.FIRE.getDefaultState());
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }

}
