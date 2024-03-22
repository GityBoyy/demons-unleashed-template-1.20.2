package net.chubby.dm.entity.projectile;

import net.chubby.dm.init.ModItems;
import net.chubby.dm.init.ModProjectiles;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class FrostBoltProjectileEntity extends ThrownItemEntity
{

    public FrostBoltProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public FrostBoltProjectileEntity(LivingEntity livingEntity, World world) {
        super(ModProjectiles.FROST_BOLT_PROJECTILE_ENTITY,livingEntity, world);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.FROST_BOLT;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        if(!this.getWorld().isClient())
        {
            Entity entity = entityHitResult.getEntity();
            if(entity instanceof LivingEntity target)
            {
                target.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS,100));
                spawnIceBlocks(target,3);
            }
        }
        super.onEntityHit(entityHitResult);
    }

    private void spawnIceBlocks(LivingEntity entity, int radius) {
        World world = entity.getEntityWorld();
        BlockPos centerPos = entity.getBlockPos();

        // Loop through a square area centered around the entity
        for (int x = -radius; x <= radius; x++) {
            for (int z = -radius; z <= radius; z++) {
                for (int y = 0; y <= 2; y++) { // Adjust the height as needed
                    BlockPos blockPos = centerPos.add(x, y, z);

                    // Check if the block is air or a replaceable block
                    if (world.isAir(blockPos) || world.getBlockState(blockPos).isReplaceable()) {
                        // Set the block to ice
                        world.setBlockState(blockPos, Blocks.ICE.getDefaultState(), 3); // Adjust the flags as needed
                    }
                }
            }
        }
    }
}
