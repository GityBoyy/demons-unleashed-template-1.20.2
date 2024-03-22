package net.chubby.dm.villagers;

import com.google.common.collect.ImmutableSet;
import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> ECTOPLASM_POI_KEY = poiKey("ectoplasmpoi");
    public static final PointOfInterestType ECTOPLASM_POI = registerPoi("ectoplasmpoi", ModBlocks.ECTOPLASM_EXTRACTOR);

    public static final VillagerProfession ECTOMASTER = registerProfession("ectomaster", ECTOPLASM_POI_KEY);


    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
        return Registry.register(Registries.VILLAGER_PROFESSION, new Identifier(DemonsUnleased.MOD_ID, name),
                new VillagerProfession(name, entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
                        ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_SHEPHERD));
    }

    private static PointOfInterestType registerPoi(String name, Block block) {
        return PointOfInterestHelper.register(new Identifier(DemonsUnleased.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> poiKey(String name) {
        return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, new Identifier(DemonsUnleased.MOD_ID, name));
    }

    public static void registerVillagers() {
        DemonsUnleased.LOGGER.info("Registering Villagers " + DemonsUnleased.MOD_ID);
    }
}
