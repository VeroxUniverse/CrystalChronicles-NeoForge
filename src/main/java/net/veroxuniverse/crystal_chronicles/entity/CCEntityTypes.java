package net.veroxuniverse.crystal_chronicles.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalDrakeEntity;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalGolemEntity;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalScorpionEntity;
import net.veroxuniverse.crystal_chronicles.lib.CCEntityNames;

public class CCEntityTypes {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, CrystalChronicles.MODID);

    static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(CrystalChronicles.MODID + ":" + name));
    }

    public static final DeferredHolder<EntityType<?>, EntityType<CrystalDrakeEntity>> CRYSTAL_DRAKE = registerEntity(
            CCEntityNames.CRYSTAL_DRAKE,
            EntityType.Builder.<CrystalDrakeEntity>of(CrystalDrakeEntity::new, MobCategory.MONSTER)
                    .sized(3.2f, 2.2F)
                    .setTrackingRange(20)
                    .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<CrystalGolemEntity>> CRYSTAL_GOLEM = registerEntity(
            CCEntityNames.CRYSTAL_GOLEM,
            EntityType.Builder.<CrystalGolemEntity>of(CrystalGolemEntity::new, MobCategory.MONSTER)
                    .sized(0.8f, 1.2F)
                    .setTrackingRange(20)
                    .setShouldReceiveVelocityUpdates(true));

    public static final DeferredHolder<EntityType<?>, EntityType<CrystalScorpionEntity>> CRYSTAL_SCORPION = registerEntity(
            CCEntityNames.CRYSTAL_SCORPION,
            EntityType.Builder.<CrystalScorpionEntity>of(CrystalScorpionEntity::new, MobCategory.MONSTER)
                    .sized(3.2f, 2.2F)
                    .setTrackingRange(20)
                    .setShouldReceiveVelocityUpdates(true));



    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

}
