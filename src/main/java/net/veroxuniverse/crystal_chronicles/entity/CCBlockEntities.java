/*package net.veroxuniverse.crystal_chronicles.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.PortalFrameBlockEntity;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

import java.util.function.Supplier;

public class CCBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, CrystalChronicles.MODID);

    public static final Supplier<BlockEntityType<PortalFrameBlockEntity>> PORTAL_FRAME_BE =
            BLOCK_ENTITIES.register("portal_frame_block_entity",
                    () -> BlockEntityType.Builder.of(PortalFrameBlockEntity::new,
                                    CCBlocks.PORTAL_FRAME_BLOCK.get())
                            .build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}

 */