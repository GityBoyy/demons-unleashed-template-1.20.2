package net.chubby.dm.items.armor;

import net.chubby.dm.DemonsUnleased;
import net.chubby.dm.init.ModItems;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    ABBYSIUM("abbysium",30,new int[]{4,8,5,4},19,null,4f,0.2f,()-> Ingredient.ofItems( ModItems.INGOT_ABBYSIUM)),
    INFERNITE("infernite",32,new int[]{5,9,6,5},25,null,6f,0.1f,()->Ingredient.ofItems(ModItems.INGOT_INFERNITE)),
    FROSTBITE("frostbite",28,new int[]{4,10,7,3},21,null,8f,0.3f,()->Ingredient.ofItems(ModItems.INGOT_FROSTBITE));
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 20, 20, 20, 20 };

        ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return DemonsUnleased.MOD_ID + ":" +this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
