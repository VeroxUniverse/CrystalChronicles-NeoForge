package net.veroxuniverse.crystal_chronicles.item.armor.prismatic;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class PrismaticKnightArmorDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand GLIDE_COMMAND = AzCommand.create(
            "base_controller",
            "glide",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand FLY_COMMAND = AzCommand.create(
            "base_controller",
            "fly",
            AzPlayBehaviors.LOOP
    );

    public void idle(Entity entity, ItemStack itemStack) {
        IDLE_COMMAND.sendForItem(entity, itemStack);
    }

    public void glide(Entity entity, ItemStack itemStack) {
        GLIDE_COMMAND.sendForItem(entity, itemStack);
    }

    public void fly(Entity entity, ItemStack itemStack) {
        FLY_COMMAND.sendForItem(entity, itemStack);
    }
}
