package net.veroxuniverse.crystal_chronicles.fusion;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.supermartijn642.fusion.api.texture.types.connecting.predicates.ConnectionDirection;
import com.supermartijn642.fusion.api.texture.types.connecting.predicates.ConnectionPredicate;
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
public class MatchTagConnectionPredicate implements ConnectionPredicate {

    public static final Serializer<MatchTagConnectionPredicate> SERIALIZER =
            new Serializer<>() {
                @Override
                public MatchTagConnectionPredicate deserialize(JsonObject json)
                        throws JsonParseException {
                    if (!json.has("tag")) {
                        throw new JsonParseException("Missing required property 'tag'");
                    }

                    String tagName = json.get("tag").getAsString();

                    ResourceLocation tagId = ResourceLocation.parse(tagName);

                    TagKey<Block> tag = TagKey.create(Registries.BLOCK, tagId);

                    return new MatchTagConnectionPredicate(tag);
                }

                @Override
                public JsonObject serialize(MatchTagConnectionPredicate value) {
                    JsonObject json = new JsonObject();
                    json.addProperty("tag", value.tag.location().toString());
                    return json;
                }
            };

    private final TagKey<Block> tag;

    public MatchTagConnectionPredicate(TagKey<Block> tag) {
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
        return ownState != null && ownState.is(tag) && otherState.is(tag);
    }

    @Override
    public Serializer<? extends ConnectionPredicate> getSerializer() {
        return SERIALIZER;
    }
}