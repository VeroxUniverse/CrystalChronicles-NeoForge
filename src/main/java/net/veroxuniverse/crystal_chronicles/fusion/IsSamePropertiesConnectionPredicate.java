package net.veroxuniverse.crystal_chronicles.fusion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.supermartijn642.fusion.api.texture.types.connecting.predicates.ConnectionDirection;
import com.supermartijn642.fusion.api.texture.types.connecting.predicates.ConnectionPredicate;
import com.supermartijn642.fusion.api.util.Serializer;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

/**
 * Created 14/06/2026 by Linkershim
 * DOES NOT WORK YET
 */
public class IsSamePropertiesConnectionPredicate implements ConnectionPredicate {

    public static final IsSamePropertiesConnectionPredicate INSTANCE = new IsSamePropertiesConnectionPredicate();
    public static final Serializer<IsSamePropertiesConnectionPredicate> SERIALIZER =
            new Serializer<>() {
                @Override
                public IsSamePropertiesConnectionPredicate deserialize(JsonObject json) throws JsonParseException {
                    return INSTANCE;
                }

                @Override
                public JsonObject serialize(IsSamePropertiesConnectionPredicate value) {
                    return null;
                }
            };

    public IsSamePropertiesConnectionPredicate() {
    }

    @Override
    public boolean shouldConnect(
            Direction side,
            @Nullable BlockState ownState,
            BlockState otherState,
            BlockState blockInFront,
            ConnectionDirection direction
    ) {
        return haveSameSharedProperties(ownState, otherState);
    }

    private boolean haveSameSharedProperties(
            BlockState ownState,
            BlockState otherState
    ) {
        for (Property<?> property : ownState.getProperties()) {
            if (!otherState.hasProperty(property)) {
                continue;
            }

            if (!samePropertyValue(ownState, otherState, property)) {
                return false;
            }
        }

        return true;
    }

    private <T extends Comparable<T>> boolean samePropertyValue(
            BlockState ownState,
            BlockState otherState,
            Property<T> property
    ) {
        return ownState.getValue(property).equals(otherState.getValue(property));
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer() {
        return SERIALIZER;
    }
}