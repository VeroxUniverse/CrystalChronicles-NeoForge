package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.block.entity.HolyLightBlockEntity;

public class CCBlockEntities {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, CrystalChronicles.MODID);

    public static final DeferredHolder<BlockEntityType<?>, BlockEntityType<HolyLightBlockEntity>> HOLY_LIGHT_BE =
            BLOCK_ENTITIES.register("holy_light_block",
                    () -> BlockEntityType.Builder.of(
                            HolyLightBlockEntity::new,
                            CCBlocks.HOLY_LIGHT_BLOCK.get()
                    ).build(null)
            );
}
