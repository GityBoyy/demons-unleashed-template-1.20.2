package net.chubby.dm.world.biome;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.world.biome.surface.ModMaterialRules;
import net.minecraft.util.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;
import terrablender.api.TerraBlenderApi;

public class ModTerraBlenderAPI implements TerraBlenderApi {
    @Override
    public void onTerraBlenderInitialized() {

        Regions.register(new ModOverworldRegion(new Identifier(DemonsUnleased.MOD_ID, "overworld"), 4));

        SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, DemonsUnleased.MOD_ID, ModMaterialRules.makeRules());
    }
}
