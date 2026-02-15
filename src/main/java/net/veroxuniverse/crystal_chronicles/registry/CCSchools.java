package net.veroxuniverse.crystal_chronicles.registry;

import io.redspace.ironsspellbooks.api.registry.SchoolRegistry;
import io.redspace.ironsspellbooks.api.spells.SchoolType;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

import java.util.function.Supplier;

public class CCSchools extends SchoolRegistry {

    private static final DeferredRegister<SchoolType> SCHOOLS =
            DeferredRegister.create(SCHOOL_REGISTRY_KEY, CrystalChronicles.MODID);

    public static final TagKey<Item> PRISMATIC_FOCUS_TAG =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "prismatic_focus"));

    public static final ResourceLocation PRISMATIC_ID =
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "prismatic");

    public static void register(IEventBus eventBus) {
        SCHOOLS.register(eventBus);
    }

    private static Supplier<SchoolType> registerSchool(SchoolType schoolType) {
        return SCHOOLS.register(schoolType.getId().getPath(), () -> schoolType);
    }

    public static final Supplier<SchoolType> PRISMATIC = registerSchool(new SchoolType(
            PRISMATIC_ID,
            PRISMATIC_FOCUS_TAG,
            Component.translatable("school.crystal_chronicles.prismatic").withStyle(s -> s.withColor(0xCC33CC)),
            CCAttributes.PRISMATIC_SPELL_POWER,
            CCAttributes.PRISMATIC_MAGIC_RESIST,
            Holder.direct(SoundEvents.WARDEN_HEARTBEAT),
            DamageTypes.MAGIC
    ));
}