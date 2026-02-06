package net.veroxuniverse.crystal_chronicles.event;

import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.armor.prismatic.PrismaticKnightArmor;

@EventBusSubscriber(modid = CrystalChronicles.MODID)
public class CCEvents {

    @SubscribeEvent
    public static void onDamage(LivingIncomingDamageEvent event) {
        if (event.getEntity() instanceof Player player) {

            if (event.getSource().is(DamageTypes.FLY_INTO_WALL)) {

                int armorPieces = 0;
                for (ItemStack armorStack : player.getArmorSlots()) {
                    if (armorStack.getItem() instanceof PrismaticKnightArmor) {
                        armorPieces++;
                    }
                }

                if (armorPieces == 4) {
                    event.setCanceled(true);
                }
            }
        }
    }

}

