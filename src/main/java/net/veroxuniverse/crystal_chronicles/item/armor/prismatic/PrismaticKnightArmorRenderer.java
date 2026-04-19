package net.veroxuniverse.crystal_chronicles.item.armor.prismatic;

import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.curios.PrismaticSchoolRing;
import net.veroxuniverse.crystal_chronicles.registry.CCDataComponents;
import top.theillusivec4.curios.api.CuriosApi;

import java.util.Map;

public class PrismaticKnightArmorRenderer extends AzArmorRenderer {

    private static final ResourceLocation MODEL = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "geo/armor/prismatic_knight.geo.json"
    );

    private static final ResourceLocation DEFAULT_TEXTURE = ResourceLocation.fromNamespaceAndPath(
            CrystalChronicles.MODID,
            "textures/armor/prismatic_knight.png"
    );

    private static final Map<String, ResourceLocation> SCHOOL_TEXTURES = Map.of(
            "fire", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_fire.png"),
            "ice", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_ice.png"),
            "lightning", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_lightning.png"),
            "holy", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_holy.png"),
            "ender", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_ender.png"),
            "blood", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_blood.png"),
            "evocation", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_evocation.png"),
            "nature", ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "textures/armor/prismatic_knight_nature.png")
    );

    public PrismaticKnightArmorRenderer() {
        super(
                AzArmorRendererConfig.builder(
                                (entity, stack) -> MODEL,
                                (entity, stack) -> {
                                    if (entity instanceof Player player) {
                                        var curioOpt = CuriosApi.getCuriosHelper().findFirstCurio(player, itemStack -> itemStack.getItem() instanceof PrismaticSchoolRing);

                                        if (curioOpt.isPresent()) {
                                            ItemStack ringStack = curioOpt.get().stack();
                                            String school = ringStack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");
                                            return SCHOOL_TEXTURES.getOrDefault(school, DEFAULT_TEXTURE);
                                        }
                                    }
                                    return DEFAULT_TEXTURE;
                                }
                        )
                        .setAnimatorProvider(PrismaticKnightArmorAnimation::new)
                        .addRenderLayer(new AzAutoGlowingLayer<>())
                        .build()
        );
    }
}