package net.veroxuniverse.crystal_chronicles.lib;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.weapons.AttributeContainer;
import io.redspace.ironsspellbooks.item.weapons.ExtendedWeaponTier;
import io.redspace.ironsspellbooks.item.weapons.IronsWeaponTier;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.veroxuniverse.crystal_chronicles.registry.CCItems;
import net.veroxuniverse.crystal_chronicles.util.CCTags;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class CCWeaponTiers implements Tier, IronsWeaponTier {

    public static final Tier VOIDSTONE = new ExtendedWeaponTier(
            3069, 4.0f, -3.0f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.VOIDSTONE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.ENDER_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final Tier CELESTITE = new ExtendedWeaponTier(
            3069, 8.0f, -2.6f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.CELESTITE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.LIGHTNING_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final Tier LUNARITE = new ExtendedWeaponTier(
            3069, 9.0f, -2.4f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.LUNARITE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.HOLY_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final Tier TOXITE = new ExtendedWeaponTier(
            3069, 9.0f, -2.7f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.TOXITE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.NATURE_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final Tier PYRONITE = new ExtendedWeaponTier(
            3069, 7.0f, -3.0f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.PYRONITE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.FIRE_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.15, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(Attributes.MOVEMENT_SPEED, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
    public static final Tier BLOODSTONE = new ExtendedWeaponTier(
            3069, 8.0f, -2.2f, 20, CCTags.Blocks.INCORRECT_FOR_CRYSTAL_TOOL,
            () -> Ingredient.of(CCItems.BLOODSTONE_SHARD.get()),
            new AttributeContainer(AttributeRegistry.BLOOD_SPELL_POWER, 0.10, AttributeModifier.Operation.ADD_MULTIPLIED_BASE),
            new AttributeContainer(AttributeRegistry.COOLDOWN_REDUCTION, 0.05, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    int uses;
    float damage;
    float speed;
    int enchantmentValue;
    TagKey<Block> incorrectBlocksForDrops;
    Supplier<Ingredient> repairIngredient;
    AttributeContainer[] attributes;

    public CCWeaponTiers(int uses, float damage, float speed, int enchantmentValue, TagKey<Block> incorrectBlocksForDrops, Supplier<Ingredient> repairIngredient, AttributeContainer... attributes) {
        this.uses = uses;
        this.damage = damage;
        this.speed = speed;
        this.enchantmentValue = enchantmentValue;
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.repairIngredient = repairIngredient;
        this.attributes = attributes;
    }

    @Override
    public int getUses() {
        return uses;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return damage;
    }

    @Override
    public @NotNull TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return repairIngredient.get();
    }

    @Override
    public AttributeContainer[] getAdditionalAttributes() {
        return this.attributes;
    }
}