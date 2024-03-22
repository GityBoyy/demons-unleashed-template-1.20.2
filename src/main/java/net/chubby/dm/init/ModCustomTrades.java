package net.chubby.dm.init;

import net.chubby.dm.init.ModItems;
import net.chubby.dm.villagers.ModVillagers;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;

public class ModCustomTrades {
    public static void registerCustomTrades() {
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ECTOMASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ECTOPLASM, 45),
                            new ItemStack(Items.EMERALD_BLOCK, 56),
                            new ItemStack(ModItems.SPECTRAL_INFUSED_IRON, 2),
                            6, 5, 0.05f));


                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ECTOMASTER, 3,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ECTOPLASM, 56),
                            new ItemStack(Items.EMERALD_BLOCK, 56),
                            new ItemStack(ModItems.SPECTRAL_INFUSED_GOLD, 1),
                            6, 12, 0.05f));


                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ECTOMASTER, 1,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(Items.CHICKEN, 3),

                            new ItemStack(Items.ROTTEN_FLESH, 8),
                            12, 9, 0.06f));


                });
        TradeOfferHelper.registerVillagerOffers(ModVillagers.ECTOMASTER, 5,
                factories -> {
                    factories.add((entity, random) -> new TradeOffer(
                            new ItemStack(ModItems.ECTOPLASM, 62),
                            new ItemStack(Items.EMERALD_BLOCK, 64),

                            new ItemStack(ModItems.SPECTRAL_INFUSED_NETHERITE, 1),
                            24, 24, 0.07f));


                });

    }
}
