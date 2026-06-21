package net.veroxuniverse.crystal_chronicles.fusion;

import com.supermartijn642.fusion.api.texture.types.connecting.predicates.FusionConnectionPredicateRegistry;
import net.minecraft.resources.ResourceLocation;

public class CCConnectionPredicates {
    public static void register(){
        FusionConnectionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "match_tag_and_properties"), SamePropertiesInTagConnectionPredicate.SERIALIZER);
        FusionConnectionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "is_same_properties"), IsSamePropertiesConnectionPredicate.SERIALIZER);
        FusionConnectionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "match_tag"), MatchTagConnectionPredicate.SERIALIZER);
    }
}