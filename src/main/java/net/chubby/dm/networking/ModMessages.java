package net.chubby.dm.networking;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.networking.packets.EnergySyncS2CPacket;
import net.chubby.dm.networking.packets.ItemSyncS2CPacket;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class ModMessages
{
    public static final Identifier ENERGY_SYNC = new Identifier(DemonsUnleased.MOD_ID, "energy_sync");
    public static final Identifier FLUID_SYNC = new Identifier(DemonsUnleased.MOD_ID, "fluid_sync");
    public static final Identifier ITEM_SYNC = new Identifier(DemonsUnleased.MOD_ID, "item_sync");

    public void registerS2CPackets() {
        ClientPlayNetworking.registerGlobalReceiver(ENERGY_SYNC, EnergySyncS2CPacket::receive);
        ClientPlayNetworking.registerGlobalReceiver(ITEM_SYNC, ItemSyncS2CPacket::receive);
    }
}
