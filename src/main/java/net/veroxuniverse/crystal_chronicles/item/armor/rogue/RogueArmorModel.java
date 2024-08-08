package net.veroxuniverse.crystal_chronicles.item.armor.rogue;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class RogueArmorModel extends GeoModel<RogueArmor> {
    @Override
    public ResourceLocation getModelResource(RogueArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/rogue.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(RogueArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/rogue.png");
    }

    @Override
    public ResourceLocation getAnimationResource(RogueArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
