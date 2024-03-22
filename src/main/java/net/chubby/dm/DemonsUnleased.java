package net.chubby.dm;

import net.chubby.dm.entity.bosses.FrostGiantBoss;
import net.chubby.dm.entity.creatures.EntityBlazeLeg;
import net.chubby.dm.entity.guardians.EntityIceBlaze;
import net.chubby.dm.init.*;
import net.chubby.dm.entity.creatures.EntityShadowLurker;
import net.chubby.dm.groups.BlockGroup;
import net.chubby.dm.groups.ItemGroups;
import net.chubby.dm.groups.ToolsGroup;
import net.chubby.dm.groups.WoodGroup;
import net.chubby.dm.screen.ModScreenHandlers;
import net.chubby.dm.villagers.ModVillagers;
import net.chubby.dm.world.village.VillageAdditions;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class DemonsUnleased implements ModInitializer {

	public static final String MOD_ID = "dm";
    public static final Logger LOGGER = LoggerFactory.getLogger("dm");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ItemGroups.registerItemGroups();
		BlockGroup.registerItemGroups();
		ToolsGroup.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipe.registerRecipes();
		ModVillagers.registerVillagers();
		ModCustomTrades.registerCustomTrades();
		ModWoods.registerModBlocks();
		WoodGroup.registerItemGroups();
		ModFoods.registerModFoods();
		GeckoLib.initialize();
		VillageAdditions.registerNewVillageStructures();

		FabricDefaultAttributeRegistry.register(ModEntities.SHADOW_LURKER, EntityShadowLurker.createPorcupineAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BLAZE_LEG, EntityBlazeLeg.createBlazeLegAttribute());
		FabricDefaultAttributeRegistry.register(ModEntities.ICE_BLAZE, EntityIceBlaze.createBlazeAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.Frost_GIANT_BOSS, FrostGiantBoss.setAttributes());
	}
}