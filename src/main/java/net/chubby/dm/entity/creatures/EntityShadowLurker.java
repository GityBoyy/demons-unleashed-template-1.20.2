package net.chubby.dm.entity.creatures;

import net.chubby.dm.entity.ai.ShadowLurkerMeleeAttackGoal;
import net.chubby.dm.entity.animations.ShadowLurkerEntityAnimations;
import net.chubby.dm.util.abilities.entity.ModMonsterHandlerClass;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.RevengeGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageEffects;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Arm;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;

public class EntityShadowLurker extends ModMonsterHandlerClass {

    private static final TrackedData<Boolean> ATTACKING =
            DataTracker.registerData(EntityShadowLurker.class, TrackedDataHandlerRegistry.BOOLEAN);

    private static final TrackedData<Boolean> SPAWNING =
            DataTracker.registerData(EntityShadowLurker.class, TrackedDataHandlerRegistry.BOOLEAN);
    public EntityShadowLurker(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);

    }

    public final AnimationState idleAnimationState = new AnimationState();
    public AnimationState attackAnimationState = new AnimationState();
    public AnimationState attackAnimationState2 = new AnimationState();
    private int idleAnimationTimeout = 0;
    public int attackAnimationTimeout=0;
    public int attackAnimation2Timeout=0;

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new LookAtEntityGoal(this,PlayerEntity.class,10.0f));

        this.goalSelector.add(1, new LookAroundGoal(this));
        this.goalSelector.add(2, new ShadowLurkerMeleeAttackGoal(this,5D,true));
        this.goalSelector.add(3, new RevengeGoal(this,new Class[0]));

        this.initCustomGoals();
    }

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0) {
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else {
            --this.attackAnimationTimeout;
        }
        if(!this.isSpawning()) {
            attackAnimationState.stop();
        }
        if(this.isSpawning() && attackAnimation2Timeout <= 0) {
            attackAnimation2Timeout = 40;
            attackAnimationState2.start(this.age);
        } else {
            --this.attackAnimation2Timeout;
        }

        if(this.isSpawning()) {
            attackAnimationState2.stop();
        }


    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }


    protected void initCustomGoals() {

        this.targetSelector.add(3, new ActiveTargetGoal(this, PlayerEntity.class, true));
        this.targetSelector.add(4, new ActiveTargetGoal(this, MerchantEntity.class, false));
        this.targetSelector.add(5, new ActiveTargetGoal(this, IronGolemEntity.class, true));
    }

    public static DefaultAttributeContainer.Builder createPorcupineAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.15f)
                .add(EntityAttributes.GENERIC_ARMOR, 0.7f)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 7);
    }

    public void setAttacking(boolean attacking) {
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking() {
        return this.dataTracker.get(ATTACKING);
    }
    public boolean isSpawning(){
        return this.dataTracker.get(SPAWNING);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(SPAWNING, false);
    }
    private void startSpawnAnimation() {
        // Start the spawning animation
        this.dataTracker.set(SPAWNING, true);
        this.attackAnimationState2.start(this.age);
    }
    @Override
    protected void initEquipment(Random random, LocalDifficulty localDifficulty) {
        super.initEquipment(random, localDifficulty);
        this.equipStack(EquipmentSlot.MAINHAND, new ItemStack(Items.NETHERITE_SWORD));
    }

    @Override
    protected void enchantMainHandItem(Random random, float power) {
        super.enchantMainHandItem(random, power);
        this.enchantMainHandItem(random,5);
    }

    @Override
    public void onPlayerCollision(PlayerEntity player) {
        super.onPlayerCollision(player);
        if(player!=null){
            player.setOnFireFor(15);
            player.canFreeze();
            player.setMovementSpeed(0f);
        }
    }

    @Override
    public boolean isAngryAt(PlayerEntity player) {
        return true;
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
        if(this.getHealth() <=50){
            this.spawnWither();
            this.startSpawnAnimation();
        }
    }
}
