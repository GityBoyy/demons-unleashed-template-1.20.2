package net.chubby.dm.groups;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class BlockGroup {

    public static final ItemGroup BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DemonsUnleased.MOD_ID, "block"),
            FabricItemGroup.builder().displayName(Text.translatable("blockgroup.blocks"))
                    .icon(() -> new ItemStack(ModBlocks.BLOCK_ABBYSIUM)).entries((displayContext, entries) -> {


                        entries.add(ModBlocks.BLOCK_INFERNITE);
                        entries.add(ModBlocks.ORE_INFERNITE);
                        entries.add(ModBlocks.BLOCK_ABBYSIUM);
                        entries.add(ModBlocks.ORE_ABBYSIUM);
                        entries.add(ModBlocks.BLOCK_FROSTBITE);
                        entries.add(ModBlocks.ORE_FROSTBITE);
                        entries.add(ModBlocks.ECTOPLASM_EXTRACTOR);

                    }).build());


    public static void registerItemGroups() {
        DemonsUnleased.LOGGER.info("Registering Block Groups for " + DemonsUnleased.MOD_ID);
    }
}
