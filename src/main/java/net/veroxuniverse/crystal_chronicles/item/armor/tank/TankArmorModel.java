package net.veroxuniverse.crystal_chronicles.item.armor.tank;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

public class TankArmorModel extends GeoModel<TankArmor> {
    @Override
    public ResourceLocation getModelResource(TankArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "geo/tank.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TankArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/tank.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TankArmor animatable) {
        return ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "animations/empty.animation.json");
    }
}
