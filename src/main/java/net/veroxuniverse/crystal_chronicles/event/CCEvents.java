package net.veroxuniverse.crystal_chronicles.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;


public class CCEvents {

    @EventBusSubscriber(modid = CrystalChronicles.MODID)
    public static class RegistrationHandler {

        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            //event.put(CCEntities.DIMENSIONAL_RIFT.get(), DimensionalRiftEntity.attributes().build());
        }

        @SubscribeEvent
        public static void entitySpawnRestriction(RegisterSpawnPlacementsEvent event) {
            //event.register(CCEntityTypes.CRYSTAL_DRAKE.get(),
            //        SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
            //        Monster::checkMonsterSpawnRules, RegisterSpawnPlacementsEvent.Operation.REPLACE);
        }

    }

}

