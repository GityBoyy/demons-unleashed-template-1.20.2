package net.chubby.dm.blocks.custom;

import net.chubby.dm.blocks.blockEntity.BoiledMilkBlockEntity;
import net.chubby.dm.init.ModBlockEntities;
import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.init.ModFoods;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class BoiledMilkCauldron extends BlockWithEntity implements BlockEntityProvider {

    public BoiledMilkCauldron(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new BoiledMilkBlockEntity(pos,state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
        ItemStack mainHandItem = player.getStackInHand(hand);
        if (mainHandItem.getItem() == Items.BUCKET) {
            if (!world.isClient) {
                // Set the block to a milk bucket

                player.setStackInHand(hand, new ItemStack(ModFoods.BOILED_MILK_BUCKET));
                world.setBlockState(pos, Blocks.CAULDRON.getDefaultState());
            }
            return ActionResult.SUCCESS;
        }
        if (mainHandItem.getItem() == ModFoods.BOILED_MILK_BUCKET) {
            if (!world.isClient) {
                // Set the block to a milk bucket

                player.setStackInHand(hand, new ItemStack(Items.MILK_BUCKET));
                world.setBlockState(pos, ModBlocks.BOILED_MILK_CAULDRON.getDefaultState());
            }
            return ActionResult.SUCCESS;
        }

        return ActionResult.PASS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, ModBlockEntities.BOILED_MILK_CAULDRON,
                (world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }
}
