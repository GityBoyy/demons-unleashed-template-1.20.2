package net.chubby.dm.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class InferniteSword extends SwordItem {


    public InferniteSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity user) {
        if (entity != null && user != null) {
            entity.setOnFireFor(5);
            if(entity.isFireImmune()){
                entity.applyDamageEffects(user,entity);
            }
            stack.damage(1,user,(entity1) -> entity.sendToolBreakStatus(user.getActiveHand()));
        }
        return true;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient) {
            // Spawn fire particles in a horizontal direction
            for (int i = 0; i < 8; i++) {
                double motionX = (world.random.nextDouble() - 0.5) * 0.5;
                double motionZ = (world.random.nextDouble() - 0.5) * 0.5;
                world.addParticle(ParticleTypes.FLAME,
                        user.getX(), user.getY() + 1.0, user.getZ(),
                        motionX, 0.1, motionZ);
            }

            // Damage nearby entities
           
        }

        return new TypedActionResult<>(ActionResult.SUCCESS, user.getStackInHand(hand));
    }
}
