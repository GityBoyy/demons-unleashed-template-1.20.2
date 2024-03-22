package net.chubby.dm.blocks.blockEntity;

import net.chubby.dm.init.ModBlockEntities;
import net.chubby.dm.networking.ModMessages;
import net.chubby.dm.recipe.EctoplasmRecipe;
import net.chubby.dm.screen.EctoplasmExtractorScreenHandler;
import net.chubby.dm.util.ImplementedInventory;
import net.fabricmc.fabric.api.networking.v1.PacketByteBufs;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import team.reborn.energy.api.base.SimpleEnergyStorage;

import java.util.Optional;

public class EctoplasmExtractorEntity extends BlockEntity implements ExtendedScreenHandlerFactory, ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(3,ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int BOTTLE_SLOT = 1;
    private static final int OUTPUT_SLOT = 2;
    private int  energyAmount = 25;

    public void setInventory(DefaultedList<ItemStack> inventory) {
        for (int i = 0; i < inventory.size(); i++) {
            this.inventory.set(i, inventory.get(i));
        }
    }

    @Override
    public void markDirty() {
        if(!world.isClient() && world!=null) {
            PacketByteBuf data = PacketByteBufs.create();
            data.writeInt(inventory.size());
            for(int i = 0; i < inventory.size(); i++) {
                data.writeItemStack(inventory.get(i));
            }
            data.writeBlockPos(getPos());

            for (ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
                ServerPlayNetworking.send(player, ModMessages.ITEM_SYNC, data);
            }
        }

        super.markDirty();
    }

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(10000,56,24)
    {
        @Override
        protected void onFinalCommit() {
            markDirty();
            getWorld().updateListeners(pos, getCachedState(), getCachedState(), 3);
        }
    };

    private void sendEnergyPacket() {
        PacketByteBuf data = PacketByteBufs.create();
        data.writeLong(energyStorage.amount);
        data.writeBlockPos(getPos());

        for(ServerPlayerEntity player : PlayerLookup.tracking((ServerWorld) world, getPos())) {
            ServerPlayNetworking.send(player, ModMessages.ENERGY_SYNC, data);
        }
    }

    private final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 150;
    public EctoplasmExtractorEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.GEM_POLISHING_STATION_BLOCK_ENTITY, pos, state);
        this.world = this.getWorld();
        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index){
                    case 0 -> EctoplasmExtractorEntity.this.progress;
                    case 1 -> EctoplasmExtractorEntity.this.maxProgress;
                    default ->0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index){
                    case 0 -> EctoplasmExtractorEntity.this.progress=value;
                    case 1 -> EctoplasmExtractorEntity.this.maxProgress=value;

                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    public void setEnergyLevel(long energyLevel) {
        this.energyStorage.amount = energyLevel;
    }

    @Override
    public void writeScreenOpeningData(ServerPlayerEntity player, PacketByteBuf buf) {
        buf.writeBlockPos(this.pos);
    }

    @Override
    public Text getDisplayName() {
        return Text.literal("Ectoplasm Extractor");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        sendEnergyPacket();
        return new EctoplasmExtractorScreenHandler(syncId,playerInventory,this,this.propertyDelegate);
    }


    @Override
    protected void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, inventory);
        nbt.putInt("ectoplasm_extractor.progress", progress);
        nbt.putLong("ectoplasm_extractor.energy", energyStorage.amount);
        nbt.putInt("ectoplasm_extractor.energy_amount", energyAmount);
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, inventory);
        progress = nbt.getInt("ectoplasm_extractor.progress");
        energyStorage.amount = nbt.getLong("ectoplasm_extractor.energy");
        energyAmount = nbt.getInt("ectoplasm_extractor.energy_amount");
    }


    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public NbtCompound toInitialChunkDataNbt() {
        return createNbt();
    }

    public void tick(World world,BlockPos pos1,BlockState state) {
        fillUpOnEnergy();

        if (world.isClient()) {
            return;
        }


        if(hasGemInSlot())
        {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(16, transaction);
                transaction.commit();
            }
        }

        if (canInsertIntoOutputSlot()) {
            if(hasRecipe()) {
                this.progress++;
                extractEnergy(this);
                markDirty(world, pos1, state);
                if(this.progress >= this.maxProgress) {
                    craftItem();

                }
            } else {
                this.resetProgress();
            }
        } else {
            this.resetProgress();
            markDirty();
        }
    }

    private void reciveEnergy() {

    }
    private void fillUpOnEnergy() {
        if(hasBottleInSecondPlace()) {
            try(Transaction transaction = Transaction.openOuter()) {
                this.energyStorage.insert(64, transaction);
                transaction.commit();
            }
        }
    }

    private boolean hasGemInSlot() {
        return this.getStack(BOTTLE_SLOT).getItem() == Items.GLASS_BOTTLE;
    }

    private static boolean hasEnoughEnergy(EctoplasmExtractorEntity entity) {
        return entity.energyStorage.amount >= 32;
    }
    private boolean hasBottleInSecondPlace() {
        return this.getStack(BOTTLE_SLOT).getItem() == Items.GLASS_BOTTLE;
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private void craftItem() {
        Optional<RecipeEntry<EctoplasmRecipe>> recipe = getCurrentRecipe();

        this.removeStack(INPUT_SLOT, 1);
        this.removeStack(BOTTLE_SLOT,1);

        this.setStack(OUTPUT_SLOT, new ItemStack(recipe.get().value().getResult(null).getItem(),
                getStack(OUTPUT_SLOT).getCount() + recipe.get().value().getResult(null).getCount()));
    }

    private static void extractEnergy(EctoplasmExtractorEntity entity) {
        try(Transaction transaction = Transaction.openOuter()) {
            entity.energyStorage.extract(32, transaction);
            transaction.commit();
        }
    }


    private boolean hasCraftingFinished() {
        return progress >= maxProgress;
    }

    private void increaseCraftProgress() {
        progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<EctoplasmRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()) {
            return false;
        }
        ItemStack output = recipe.get().value().getResult(null);
        this.maxProgress = recipe.get().value().getCraftTime();
        this.energyAmount = recipe.get().value().getEnergyAmount();

        return canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output) && hasEnoughEnergyToCraft();
    }

    private boolean canInsertItemIntoOutputSlot(Item item) {
        return this.getStack(OUTPUT_SLOT).getItem() == item || this.getStack(OUTPUT_SLOT).isEmpty();
    }

    private boolean hasEnoughEnergyToCraft() {
        return this.energyStorage.amount >= this.energyAmount * this.maxProgress;
    }
    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        return this.getStack(OUTPUT_SLOT).getMaxCount() >= this.getStack(OUTPUT_SLOT).getCount() + count;
    }

    private Optional<RecipeEntry<EctoplasmRecipe>> getCurrentRecipe() {
        SimpleInventory inventory = new SimpleInventory((this.size()));
        for(int i = 0; i < this.size(); i++) {
            inventory.setStack(i, this.getStack(i));
        }

        return this.getWorld().getRecipeManager().getFirstMatch(EctoplasmRecipe.Type.INSTANCE, inventory, this.getWorld());
    }

    private boolean canInsertIntoOutputSlot() {
        return this.getStack(OUTPUT_SLOT).isEmpty() ||
                this.getStack(OUTPUT_SLOT).getCount() < this.getStack(OUTPUT_SLOT).getMaxCount();
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

}
