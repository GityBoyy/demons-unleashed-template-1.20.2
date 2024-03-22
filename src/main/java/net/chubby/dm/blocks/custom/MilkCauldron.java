package net.chubby.dm.blocks.custom;

import net.minecraft.block.AbstractCauldronBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class MilkCauldron extends AbstractCauldronBlock{




    public MilkCauldron(Settings settings, Map<Item, CauldronBehavior> behaviorMap) {
        super(settings, behaviorMap);
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return 0.9375;
    }



    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if(this.isEntityTouchingFluid(state,pos,entity)){
            removeActiveEffects(((LivingEntity) entity));
        }
    }



    @Override
    public boolean isFull(BlockState state) {
        return true;
    }

    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return 3;
    }
    public static void removeActiveEffects(LivingEntity player) {
        player.clearStatusEffects();
    }


}
