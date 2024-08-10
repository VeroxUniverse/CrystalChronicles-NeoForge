package net.veroxuniverse.crystal_chronicles.event;

import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.levelgen.Heightmap;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.LogicalSide;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.entity.CCEntityTypes;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalDrakeEntity;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalGolemEntity;
import net.veroxuniverse.crystal_chronicles.entity.custom.CrystalWolfEntity;

public class CCEvents {

    @EventBusSubscriber(modid = CrystalChronicles.MODID, bus = EventBusSubscriber.Bus.MOD)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(CCEntityTypes.CRYSTAL_DRAKE.get(), CrystalDrakeEntity.attributes().build());
            event.put(CCEntityTypes.CRYSTAL_SCORPION.get(), CrystalDrakeEntity.attributes().build());
            event.put(CCEntityTypes.CRYSTAL_GOLEM.get(), CrystalGolemEntity.attributes().build());
            event.put(CCEntityTypes.CRYSTAL_WOLF.get(), CrystalWolfEntity.attributes().build());
        }

        @SubscribeEvent
        public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
            event.register(CCEntityTypes.CRYSTAL_DRAKE.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
            event.register(CCEntityTypes.CRYSTAL_SCORPION.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
            event.register(CCEntityTypes.CRYSTAL_GOLEM.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
            event.register(CCEntityTypes.CRYSTAL_WOLF.get(),
                    SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        }

    }

}
