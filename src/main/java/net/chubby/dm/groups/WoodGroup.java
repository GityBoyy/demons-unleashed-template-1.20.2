package net.chubby.dm.groups;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModWoods;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class WoodGroup {

    public static final ItemGroup WOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(DemonsUnleased.MOD_ID, "woods"),
            FabricItemGroup.builder().displayName(Text.translatable("woodgroup.woods"))
                    .icon(() -> new ItemStack(ModWoods.SYLVANHEARTWOOD_LOG)).entries((displayContext, entries) -> {
                        entries.add(ModWoods.SYLVANHEARTWOOD_LOG);
                        entries.add(ModWoods.SYLVANHEARTWOOD_WOOD);
                        entries.add(ModWoods.STRIPPED_SYLVANHEARTWOOD_WOOD);
                        entries.add(ModWoods.STRIPPED_SYLVANHEARTWOOD_LOG);

                        entries.add(ModWoods.SYLVANHEARTWOOD_PLANKS);
                        entries.add(ModWoods.SYLVANHEARTWOOD_TRAPDOOR);
                        entries.add(ModWoods.SYLVANHEARTWOOD_SLAB);
                        entries.add(ModWoods.SYLVANHEARTWOOD_FENCE);
                        entries.add(ModWoods.SYLVANHEARTWOOD_FENCE_GATE);
                        entries.add(ModWoods.SYLVANHEARTWOOD_PRESSURE_PLATE);
                        entries.add(ModWoods.SYLVANHEARTWOOD_STAIR);
                        entries.add(ModWoods.SYLVANHEARTWOOD_BUTTON);

                        entries.add(ModWoods.WHISPERWOOD_LOG);
                        entries.add(ModWoods.WHISPERWOOD_WOOD);
                        entries.add(ModWoods.STRIPPED_WHISPERWOOD_WOOD);
                        entries.add(ModWoods.STRIPPED_WHISPERWOOD_LOG);

                        entries.add(ModWoods.WHISPERWOOD_PLANK);
                        entries.add(ModWoods.WHISPERWOOD_TRAPDOOR);
                        entries.add(ModWoods.WHISPERWOOD_SLAB);
                        entries.add(ModWoods.WHISPERWOOD_FENCE);
                        entries.add(ModWoods.WHISPERWOOD_FENCE_GATE);
                        entries.add(ModWoods.WHISPERWOOD_PRESSURE_PLATE);
                        entries.add(ModWoods.WHISPERWOOD_STAIR);
                        entries.add(ModWoods.WHISPERWOOD_BUTTON);

                        entries.add(ModWoods.MYSTICGROOVETIMBER_LOG);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_WOOD);
                        entries.add(ModWoods.STRIPPED_MYSTICGROOVETIMBER_WOOD);
                        entries.add(ModWoods.STRIPPED_MYSTICGROOVETIMBER_LOG);

                        entries.add(ModWoods.MYSTICGROOVETIMBER_PLANK);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_TRAPDOOR);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_SLAB);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_FENCE);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_FENCE_GATE);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_PRESSURE_PLATE);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_STAIR);
                        entries.add(ModWoods.MYSTICGROOVETIMBER_BUTTON);

                        entries.add(ModWoods.ECLIPSE_LOG);
                        entries.add(ModWoods.ECLIPSE_WOOD);
                        entries.add(ModWoods.STRIPPED_ECLIPSE_WOOD);
                        entries.add(ModWoods.STRIPPED_ECLIPSE_LOG);

                        entries.add(ModWoods.ECLIPSE_PLANK);
                        entries.add(ModWoods.ECLIPSE_TRAPDOOR);
                        entries.add(ModWoods.ECLIPSE_SLAB);
                        entries.add(ModWoods.ECLIPSE_FENCE);
                        entries.add(ModWoods.ECLIPSE_FENCE_GATE);
                        entries.add(ModWoods.ECLIPSE_PRESSURE_PLATE);
                        entries.add(ModWoods.ECLIPSE_STAIR);
                        entries.add(ModWoods.ECLIPSE_BUTTON);





                    }).build());


    public static void registerItemGroups() {
        DemonsUnleased.LOGGER.info("Registering Wood Groups for " + DemonsUnleased.MOD_ID);
    }
}
