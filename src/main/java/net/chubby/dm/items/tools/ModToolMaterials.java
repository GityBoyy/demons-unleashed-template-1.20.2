package net.chubby.dm.items.tools;

import net.chubby.dm.init.ModItems;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterials implements ToolMaterial {
    ABBYSIUM(1200,3.5f,5,4.5f,26,()-> Ingredient.ofItems(ModItems.INGOT_ABBYSIUM)),
    SPECTRAL(3200,8f,10,8.9f,100,()-> Ingredient.ofItems(ModItems.SPECTRAL_INFUSED_IRON,ModItems.SPECTRAL_INFUSED_GOLD,ModItems.SPECTRAL_INFUSED_NETHERITE)),
    INFERNITE(1000,2f,5,5.1f,31,()-> Ingredient.ofItems(ModItems.INGOT_INFERNITE)),
    FROSTBITE(1000,1.8f,5,6.2f,25,()-> Ingredient.ofItems(ModItems.INGOT_FROSTBITE));

    private final int durability;
    private final float miningSpeed;
    private final int miningLevel;
    private final float attackDamage;
    private final int enchantability;

    private final Supplier<Ingredient> repairIngredient;

    ModToolMaterials(int durability, float miningSpeed, int miningLevel, float attackDamage, int enchantability, Supplier<Ingredient> repairIngredient) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.miningLevel = miningLevel;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
