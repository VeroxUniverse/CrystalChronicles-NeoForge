package net.veroxuniverse.crystal_chronicles.fusion;

import com.supermartijn642.fusion.api.predicate.FusionPredicateRegistry;
import net.minecraft.resources.ResourceLocation;

public class CCConnectionPredicates {
    public static void register(){
        FusionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "match_tag_and_properties"), SamePropertiesInTagConnectionPredicate.SERIALIZER);
        FusionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "is_same_properties"), IsSamePropertiesConnectionPredicate.SERIALIZER);
        FusionPredicateRegistry.registerConnectionPredicate(ResourceLocation.fromNamespaceAndPath("crystal_chronicles", "match_tag"), MatchTagConnectionPredicate.SERIALIZER);
    }
}