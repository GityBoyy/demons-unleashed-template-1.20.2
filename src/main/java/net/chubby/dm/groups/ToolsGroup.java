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

public class ToolsGroup {

    public static final ItemGroup TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DemonsUnleased.MOD_ID, "tools"),
            FabricItemGroup.builder().displayName(Text.translatable("toolgroup.tools"))
                    .icon(() -> new ItemStack(ModItems.ABBYSIUM_AXE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.ABBYSIUM_SWORD);

                        entries.add(ModItems.ABBYSIUM_AXE);
                        entries.add(ModItems.ABBYSIUM_PICKAXE);

                        entries.add(ModItems.ABBYSIUM_HELMET);
                        entries.add(ModItems.ABBYSIUM_CHESTPLATE);
                        entries.add(ModItems.ABBYSIUM_LEGGINGS);
                        entries.add(ModItems.ABBYSIUM_BOOTS);

                        entries.add(ModItems.INFERNITE_SWORD);
                        entries.add(ModItems.INFERNITE_PICKAXE);

                        entries.add(ModItems.INFERNITE_HELMET);
                        entries.add(ModItems.INFERNITE_CHESTPLATE);
                        entries.add(ModItems.INFERNITE_LEGGINGS);
                        entries.add(ModItems.INFERNITE_BOOTS);

                        entries.add(ModItems.FROSTBITE_SWORD);
                        entries.add(ModItems.FROSTBITE_PICKAXE);

                        entries.add(ModItems.FROSTBITE_HELMET);
                        entries.add(ModItems.FROSTBITE_CHESTPLATE);
                        entries.add(ModItems.FROSTBITE_LEGGINGS);
                        entries.add(ModItems.FROSTBITE_BOOTS);



                    }).build());


    public static void registerItemGroups() {
        DemonsUnleased.LOGGER.info("Registering Item Groups for " + DemonsUnleased.MOD_ID);
    }
}
