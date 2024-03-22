package net.chubby.dm.blocks.blockEntity;

import net.chubby.dm.init.ModBlockEntities;
import net.chubby.dm.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BoiledMilkBlockEntity extends BlockEntity {
    private static final int BOILING_TIME_THRESHOLD = 60;
    private int boilingTime = 0;

    public BoiledMilkBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BOILED_MILK_CAULDRON, pos, state);
    }



    public void tick(World world, BlockPos pos, BlockState state) {
        if (world.getBlockState(pos.down()).isOf(Blocks.FIRE)||world.getBlockState(pos.down()).isOf(Blocks.CAMPFIRE)) {
            boilingTime++;
        }

        if (boilingTime >= 60) {
            world.setBlockState(pos, ModBlocks.BOILED_MILK_CAULDRON.getDefaultState(), 3);
        }
    }

    @Override
    protected void writeNbt(NbtCompound tag) {
        super.writeNbt(tag);
        tag.putInt("BoilingTime", boilingTime);

    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        boilingTime = nbt.getInt("BoilingTime");
    }


}
