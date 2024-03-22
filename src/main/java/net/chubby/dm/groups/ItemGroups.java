package net.chubby.dm.groups;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ItemGroups {

    public static final ItemGroup ITEM_GROUPS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DemonsUnleased.MOD_ID, "item"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.items"))
                    .icon(() -> new ItemStack(ModItems.INGOT_ABBYSIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.INGOT_INFERNITE);
                        entries.add(ModItems.RAW_INFERNITE);
                        entries.add(ModItems.INGOT_ABBYSIUM);
                        entries.add(ModItems.RAW_ABBYSIUM);
                        entries.add(ModItems.INGOT_FROSTBITE);

                        entries.add(ModItems.SPECTRAL_INFUSED_IRON);
                        entries.add(ModItems.SPECTRAL_INFUSED_GOLD);
                        entries.add(ModItems.SPECTRAL_INFUSED_NETHERITE);
                        entries.add(ModItems.SPECTRAL_SWORD);
                        entries.add(ModItems.ECTOPLASM);



                    }).build());


    public static void registerItemGroups() {
        DemonsUnleased.LOGGER.info("Registering Item Groups for " + DemonsUnleased.MOD_ID);
    }
}
