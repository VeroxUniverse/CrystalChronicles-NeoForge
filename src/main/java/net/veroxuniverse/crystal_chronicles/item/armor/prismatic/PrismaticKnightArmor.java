package net.veroxuniverse.crystal_chronicles.item.armor.prismatic;

import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class PrismaticKnightArmor extends AnimatedSpellArmor {

    public final PrismaticKnightArmorDispatcher dispatcher;

    public PrismaticKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, withManaAndSpellPowerAttribute(200, 0.2));
        this.dispatcher = new PrismaticKnightArmorDispatcher();
    }

    @Override
    public void inventoryTick(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
        if (!level.isClientSide && entity instanceof Player player) {
            int armorPieces = 0;
            boolean isCurrentStackEquipped = false;

            for (ItemStack armorStack : player.getArmorSlots()) {
                if (armorStack.getItem() instanceof PrismaticKnightArmor) {
                    armorPieces++;
                }
                if (armorStack == stack) {
                    isCurrentStackEquipped = true;
                }
            }

            if (isCurrentStackEquipped) {
                if (armorPieces == 4) {
                    player.fallDistance = 0.0f;
                }
                if (!player.isFallFlying()) {
                    dispatcher.idle(player, stack);
                }
            }
        }
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return true;
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
        if (entity instanceof Player player) {
            player.fallDistance = 0.0f;
            double speed = player.getDeltaMovement().length();
            if (speed > 0.65 || player.getXRot() > 35.0f) {
                dispatcher.glide(player, stack);
            } else {
                dispatcher.fly(player, stack);
            }
        }
        return true;
    }
}