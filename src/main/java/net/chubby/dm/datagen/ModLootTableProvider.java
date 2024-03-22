package net.chubby.dm.datagen;


import net.chubby.dm.init.ModBlocks;
import net.chubby.dm.init.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BLOCK_INFERNITE);
        addDrop(ModBlocks.BLOCK_ABBYSIUM);
        addDrop(ModBlocks.BLOCK_FROSTBITE);

        addDrop(ModBlocks.ORE_INFERNITE);
        addDrop(ModBlocks.ORE_INFERNITE, oreDrops(ModBlocks.ORE_INFERNITE,ModItems.RAW_INFERNITE));
        addDrop(ModBlocks.ORE_ABBYSIUM, oreDrops(ModBlocks.ORE_ABBYSIUM,ModItems.RAW_ABBYSIUM));
    }
}
