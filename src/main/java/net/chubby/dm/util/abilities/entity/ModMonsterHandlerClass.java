package net.chubby.dm.util.abilities.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.WitherSkeletonEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.RangedWeaponItem;
import net.minecraft.sound.SoundCategory;
import net.minecraft.world.World;

import java.util.function.Predicate;

public abstract class ModMonsterHandlerClass extends HostileEntity {

    protected ModMonsterHandlerClass(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
    }

    public void shootAt(LivingEntity entity,float charge){}
    public void tickMovement() {
        this.tickHandSwing();
        this.updateDespawnCounter();
        super.tickMovement();
    }

    protected void updateDespawnCounter() {
        float f = this.getBrightnessAtEyes();
        if (f > 0.5F) {
            this.despawnCounter += 2;
        }

    }

    @Override
    public boolean disablesShield() {
        return true;
    }

    @Override
    protected void dropEquipment(DamageSource source, int lootingMultiplier, boolean allowDrops) {
        super.dropEquipment(source, lootingMultiplier, allowDrops);
    }



    private int witherSpawnCount = 0;
    private static final int MAX_WITHER_SPAWNS = 5;

    public void spawnWither() {
        if (!this.getWorld().isClient() && this.getTarget() != null) {
            WitherSkeletonEntity witherSkeleton = EntityType.WITHER_SKELETON.create(this.getWorld());
            if (witherSkeleton != null) {
                for(int j=witherSpawnCount;j<=MAX_WITHER_SPAWNS;j++){
                    if(witherSpawnCount < MAX_WITHER_SPAWNS){
                        witherSkeleton.refreshPositionAndAngles(this.getX(), this.getY(), this.getZ(), this.getYaw(), 0.0F);
                        getWorld().spawnEntity(witherSkeleton);
                    }
                    if(witherSpawnCount == MAX_WITHER_SPAWNS){break;}
                }
            }
        }
    }
    public void spawnSkeleton(){

        if(!this.getWorld().isClient() && this.getTarget() != null){
            SkeletonEntity witherSkeleton = EntityType.SKELETON.create(this.getWorld());
            if(witherSkeleton != null){
                witherSkeleton.refreshPositionAndAngles(this.getX(),this.getY(),this.getZ(),this.getYaw(),0.0F);
                getWorld().spawnEntity(witherSkeleton);
            }
        }
    }
    public void spawnZombie(){

        if(!this.getWorld().isClient() && this.getTarget() != null){
            ZombieEntity witherSkeleton = EntityType.ZOMBIE.create(this.getWorld());
            if(witherSkeleton != null){
                witherSkeleton.refreshPositionAndAngles(this.getX(),this.getY(),this.getZ(),this.getYaw(),0.0F);
                getWorld().spawnEntity(witherSkeleton);
            }
        }
    }

    @Override
    public SoundCategory getSoundCategory() {
        return super.getSoundCategory();
    }
    public ItemStack getProjectileType(ItemStack stack) {
        if (stack.getItem() instanceof RangedWeaponItem) {
            Predicate<ItemStack> predicate = ((RangedWeaponItem)stack.getItem()).getHeldProjectiles();
            ItemStack itemStack = RangedWeaponItem.getHeldProjectile(this, predicate);
            return itemStack.isEmpty() ? new ItemStack(Items.ARROW) : itemStack;
        } else {
            return ItemStack.EMPTY;
        }
    }
}
