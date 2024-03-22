package net.chubby.dm.init;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.items.armor.ModArmorMaterial;
import net.chubby.dm.items.custom.FrostbiteSword;
import net.chubby.dm.items.custom.InferniteArmor;
import net.chubby.dm.items.custom.InfernitePickaxe;
import net.chubby.dm.items.custom.InferniteSword;
import net.chubby.dm.items.tools.ModToolMaterials;
import net.chubby.dm.projectile.ArcaneOrb;
import net.chubby.dm.projectile.FrostBolt;
import net.chubby.dm.projectile.InfernoOrb;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModItems {

    public static final Item INGOT_INFERNITE = registerItem("ingot_infernite",new Item(new FabricItemSettings()));
    public static final Item INGOT_ABBYSIUM = registerItem("ingot_abbysium",new Item(new FabricItemSettings()));
    public static final Item INGOT_FROSTBITE = registerItem("ingot_frostbite",new Item(new FabricItemSettings()));
    public static final Item INGOT_CHILLFIRE = registerItem("ingot_chillfire",new Item(new FabricItemSettings()));
    public static final Item RAW_INFERNITE = registerItem("raw_infernite",new Item(new FabricItemSettings()));
    public static final Item RAW_ABBYSIUM = registerItem("raw_abbysium",new Item(new FabricItemSettings()));

    public static final Item ABBYSIUM_SWORD = registerItem("abbysium_sword",new SwordItem(ModToolMaterials.ABBYSIUM,5,4f,new FabricItemSettings()));
    public static final Item ABBYSIUM_PICKAXE = registerItem("abbysium_pickaxe",new PickaxeItem(ModToolMaterials.ABBYSIUM,1,4f,new FabricItemSettings()));
    public static final Item ABBYSIUM_AXE = registerItem("abbysium_axe",new AxeItem(ModToolMaterials.ABBYSIUM,2,3f,new FabricItemSettings()));
    public static final Item ABBYSIUM_HELMET = registerItem("abbysium_helmet",new ArmorItem(ModArmorMaterial.ABBYSIUM,
            ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item ABBYSIUM_CHESTPLATE = registerItem("abbysium_chestplate",new ArmorItem(ModArmorMaterial.ABBYSIUM,
            ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item ABBYSIUM_LEGGINGS = registerItem("abbysium_leggings",new ArmorItem(ModArmorMaterial.ABBYSIUM,
            ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item ABBYSIUM_BOOTS = registerItem("abbysium_boots",new ArmorItem(ModArmorMaterial.ABBYSIUM,
            ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item FROSTBITE_SWORD = registerItem("frostbite_sword",new FrostbiteSword(ModToolMaterials.FROSTBITE,5,4f,new FabricItemSettings()));
    public static final Item FROSTBITE_PICKAXE = registerItem("frostbite_pickaxe",new PickaxeItem(ModToolMaterials.FROSTBITE,1,1f,new FabricItemSettings()));
    public static final Item FROSTBITE_HELMET = registerItem("frostbite_helmet",new ArmorItem(ModArmorMaterial.FROSTBITE,
            ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item FROSTBITE_CHESTPLATE = registerItem("frostbite_chestplate",new ArmorItem(ModArmorMaterial.FROSTBITE,
            ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item FROSTBITE_LEGGINGS = registerItem("frostbite_leggings",new ArmorItem(ModArmorMaterial.FROSTBITE,
            ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item FROSTBITE_BOOTS = registerItem("frostbite_boots",new ArmorItem(ModArmorMaterial.FROSTBITE,
            ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item INFERNITE_SWORD = registerItem("infernite_sword",new InferniteSword(ModToolMaterials.INFERNITE,5,4f,new FabricItemSettings()));
    public static final Item INFERNITE_PICKAXE = registerItem("infernite_pickaxe",new InfernitePickaxe(ModToolMaterials.INFERNITE,1,4f,new FabricItemSettings()));

    public static final Item INFERNITE_HELMET = registerItem("infernite_helmet",new InferniteArmor(ModArmorMaterial.INFERNITE,
            ArmorItem.Type.HELMET,new FabricItemSettings()));
    public static final Item INFERNITE_CHESTPLATE = registerItem("infernite_chestplate",new InferniteArmor(ModArmorMaterial.INFERNITE,
            ArmorItem.Type.CHESTPLATE,new FabricItemSettings()));
    public static final Item INFERNITE_LEGGINGS = registerItem("infernite_leggings",new InferniteArmor(ModArmorMaterial.INFERNITE,
            ArmorItem.Type.LEGGINGS,new FabricItemSettings()));
    public static final Item INFERNITE_BOOTS = registerItem("infernite_boots",new InferniteArmor(ModArmorMaterial.INFERNITE,
            ArmorItem.Type.BOOTS,new FabricItemSettings()));

    public static final Item SPECTRAL_DUST = registerItem("spectral_dust",new Item(new FabricItemSettings()));

    public static final Item SPECTRAL_INFUSED_IRON = registerItem("spectral_infused_iron_ingot",new Item(new FabricItemSettings()));
    public static final Item SPECTRAL_INFUSED_GOLD = registerItem("spectral_infused_gold_ingot",new Item(new FabricItemSettings()));
    public static final Item SPECTRAL_INFUSED_NETHERITE = registerItem("spectral_infused_netherite_ingot",new Item(new FabricItemSettings()));

    public static final Item SPECTRAL_SWORD = registerItem("spectral_sword",new SwordItem(ModToolMaterials.SPECTRAL,6,7f,new FabricItemSettings()));
    public static final Item ECTOPLASM = registerItem("ectoplasm",new Item(new FabricItemSettings()));

    public static final Item INFERNO_ORB = registerItem("inferno_orb",new InfernoOrb(new Item.Settings()));
    public static final Item ARCANE_ORB = registerItem("arcane_orb",new ArcaneOrb(new Item.Settings()));
    public static final Item FROST_BOLT = registerItem("frost_bolt",new FrostBolt(new Item.Settings()));

    public static final Item BLAZE_LEG_SPAWN_EGG = registerItem("blaze_leg_spawn_egg",
            new SpawnEggItem(ModEntities.BLAZE_LEG,0xa86518, 0x3b260f,new FabricItemSettings()));
    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(DemonsUnleased.MOD_ID,name),item);
    }

    public static void registerModItems() {
        DemonsUnleased.LOGGER.info("Registering Mod Items for " + DemonsUnleased.MOD_ID);

    }
}
