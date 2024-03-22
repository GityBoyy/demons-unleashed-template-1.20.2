package net.chubby.dm.screen;

import net.chubby.dm.blocks.blockEntity.DungeonChestBlockEntity;
import net.chubby.dm.blocks.blockEntity.EctoplasmExtractorEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;

public class DungeonChestScreenHandler extends ScreenHandler
{

    private final Inventory inventory;
    public final DungeonChestBlockEntity blockEntity;

    public DungeonChestScreenHandler(int syncId, PlayerInventory inventory, PacketByteBuf buf) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(buf.readBlockPos())
                );
    }

    public DungeonChestScreenHandler(int syncId, PlayerInventory playerInventory,
                                     BlockEntity blockEntity) {
        super(ModScreenHandlers.DUNGEON_CHEST_SCREEN, syncId);
        this.blockEntity = (DungeonChestBlockEntity) blockEntity;
        checkSize(((Inventory) blockEntity), 1); // Assuming 3 slots in the inventory
        this.inventory = ((Inventory) blockEntity);


        this.addSlot(new Slot(inventory, 0, 16, 16));


        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }



    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);
        if (slot != null && slot.hasStack()) {
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();
            if (invSlot < this.inventory.size()) {
                if (!this.insertItem(originalStack, this.inventory.size(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, this.inventory.size(), false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
