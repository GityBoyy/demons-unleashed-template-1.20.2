package net.chubby.dm.util;

import net.chubby.dm.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeveledCauldronBlock;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Map;

public class MilkCauldronBehaviour implements CauldronBehavior {

    public static Map<Item, CauldronBehavior> MILK_CAULDRON_BEHAVIOR = CauldronBehavior.createMap();
    public static final CauldronBehavior FILL_WITH_MILK=(state, world, pos, player, hand, stack) -> CauldronBehavior.fillCauldron(world, pos, player, hand, stack, (BlockState)ModBlocks.MILK_CAULDRON.getDefaultState().with(LeveledCauldronBlock.LEVEL, 3), SoundEvents.ITEM_BUCKET_EMPTY);;
    @Override
    public ActionResult interact(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, ItemStack stack) {
        return CauldronBehavior.fillCauldron(world,pos,player,hand,stack,
                ModBlocks.MILK_CAULDRON.getDefaultState(), SoundEvents.AMBIENT_UNDERWATER_ENTER);
    }


    public static void registerBehaviour()
    {
        EMPTY_CAULDRON_BEHAVIOR.put(Items.MILK_BUCKET, new MilkCauldronBehaviour());

        MILK_CAULDRON_BEHAVIOR.put(Items.BUCKET, (state, world, pos, player, hand, stack) -> CauldronBehavior.emptyCauldron(state, world, pos, player, hand, stack, new ItemStack(Items.MILK_BUCKET), statex -> true, SoundEvents.ITEM_BUCKET_FILL_LAVA));
    }

    public static void registerBucketBehaviour()
    {
        MILK_CAULDRON_BEHAVIOR.put(Items.MILK_BUCKET,FILL_WITH_MILK);
    }
}
