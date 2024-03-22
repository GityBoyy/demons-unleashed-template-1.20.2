package net.chubby.dm.items.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class InfernitePickaxe extends PickaxeItem {
    public InfernitePickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        Block block = state.getBlock();
        ItemStack resultStack = ItemStack.EMPTY;

        if (block == Blocks.IRON_ORE || block == Blocks.DEEPSLATE_IRON_ORE) {
            resultStack = new ItemStack(Items.IRON_INGOT);

        } else if (block == Blocks.GOLD_ORE || block == Blocks.DEEPSLATE_GOLD_ORE) {
            resultStack = new ItemStack(Items.GOLD_INGOT);
        } else if (block == Blocks.DIAMOND_ORE || block == Blocks.DEEPSLATE_DIAMOND_ORE) {
            resultStack = new ItemStack(Items.DIAMOND);
        } else if (block == Blocks.EMERALD_ORE || block == Blocks.DEEPSLATE_EMERALD_ORE) {
            resultStack = new ItemStack(Items.EMERALD);
        } else if (block == Blocks.COPPER_ORE || block == Blocks.DEEPSLATE_COPPER_ORE) {
            resultStack = new ItemStack(Items.COPPER_INGOT);
        }

        if (!resultStack.isEmpty()) {
            if (!world.isClient) {
                if (state.isIn(BlockTags.BASE_STONE_OVERWORLD)) {


                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    Block.dropStack(world, pos, resultStack);
                    stack.damage(1, miner, (entity) -> entity.sendToolBreakStatus(miner.getActiveHand()));
                }

            }
            return true;
        }


        return super.postMine(stack, world, state, pos, miner);
    }

    @Override
    public void usageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks) {
        if(!hasInferniteArmor(user)){
            user.setOnFireFor(1);
        }
        super.usageTick(world,user,stack,remainingUseTicks);
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {

        if(!hasInferniteArmor((LivingEntity) entity)){
            entity.setOnFireFor(1);
        }
        super.inventoryTick(stack, world, entity, slot, selected);


    }

    private static boolean hasInferniteArmor(LivingEntity user) {
        for (ItemStack armorStack : user.getArmorItems()) {
            if (!(armorStack.getItem() instanceof InferniteArmor)) {
                return false;
            }
        }

        return true;
    }
}
