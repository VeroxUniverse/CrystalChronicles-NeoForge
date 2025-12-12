/*package net.veroxuniverse.crystal_chronicles.entity.client;

import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.veroxuniverse.crystal_chronicles.entity.custom.DimensionalRiftEntity;

public class DimensionalRiftEntityDispatcher {
    private static final AzCommand IDLE_COMMAND = AzCommand.create(
            "base_controller",
            "idle",
            AzPlayBehaviors.LOOP
    );

    private static final AzCommand OPEN_COMMAND = AzCommand.create(
            "base_controller",
            "open",
            AzPlayBehaviors.PLAY_ONCE
    );

    private static final AzCommand CLOSE_COMMAND = AzCommand.create(
            "base_controller",
            "close",
            AzPlayBehaviors.PLAY_ONCE
    );

    private final DimensionalRiftEntity entity;

    public DimensionalRiftEntityDispatcher(DimensionalRiftEntity animatable) {
        this.entity = animatable;
    }

    public void idle() {
        IDLE_COMMAND.sendForEntity(entity);
    }

    public void open() {
        OPEN_COMMAND.sendForEntity(entity);
    }

    public void close() {
        CLOSE_COMMAND.sendForEntity(entity);
    }

}

 */