package net.chubby.dm.items.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;

public class FrostbiteSword extends SwordItem {
    public FrostbiteSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity entity, LivingEntity user) {
        if (entity != null && user != null) {
            entity.setFrozenTicks(5);
            if(!entity.canFreeze()){
                entity.applyDamageEffects(user,entity);
            }
            stack.damage(1,user,(entity1) -> entity.sendToolBreakStatus(user.getActiveHand()));
        }
        return true;
    }
}
