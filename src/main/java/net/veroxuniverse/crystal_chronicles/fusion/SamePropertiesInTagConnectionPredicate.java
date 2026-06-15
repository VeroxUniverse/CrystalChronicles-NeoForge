package net.veroxuniverse.crystal_chronicles.fusion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.supermartijn642.fusion.api.predicate.ConnectionDirection;
import com.supermartijn642.fusion.api.predicate.ConnectionPredicate;
import com.supermartijn642.fusion.api.util.Serializer;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.jetbrains.annotations.Nullable;

/**
 * Created 14/06/2026 by Linkershim
 */
public class SamePropertiesInTagConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<SamePropertiesInTagConnectionPredicate> SERIALIZER =
            new Serializer<>() {
                @Override
                public SamePropertiesInTagConnectionPredicate deserialize(JsonObject json)
                        throws JsonParseException {
                    if (!json.has("tag")) {
                        throw new JsonParseException("Missing required property 'tag'");
                    }

                    String tagName = json.get("tag").getAsString();

                    ResourceLocation tagId = ResourceLocation.parse(tagName);

                    TagKey<Block> tag = TagKey.create(Registries.BLOCK, tagId);

                    return new SamePropertiesInTagConnectionPredicate(tag);
                }

                @Override
                public JsonObject serialize(SamePropertiesInTagConnectionPredicate value) {
                    JsonObject json = new JsonObject();
                    json.addProperty("tag", value.tag.location().toString());
                    return json;
                }
            };

    private final TagKey<Block> tag;

    public SamePropertiesInTagConnectionPredicate(TagKey<Block> tag) {
        this.tag = tag;
    }

    @Override
    public boolean shouldConnect(
            Direction side,
            @Nullable BlockState ownState,
            BlockState otherState,
            BlockState blockInFront,
            ConnectionDirection direction
    ) {
        if (ownState == null) {
            return false;
        }

        if (!ownState.is(tag) || !otherState.is(tag)) {
            return false;
        }

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