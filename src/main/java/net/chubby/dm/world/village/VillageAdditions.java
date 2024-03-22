package net.chubby.dm.world.village;

import fzzyhmstrs.structurized_reborn.impl.FabricStructurePoolRegistry;
import net.chubby.dm.DemonsUnleased;
import net.minecraft.util.Identifier;

public class VillageAdditions {
    // Using https://github.com/fzzyhmstrs/structurized-reborn (Under MIT License)
     public static void registerNewVillageStructures() {
         FabricStructurePoolRegistry.registerSimple(
                 new Identifier("minecraft:village/plains/houses"),
                 new Identifier(DemonsUnleased.MOD_ID, "plains_ectomaster"),
                 50
         );
     }
}
