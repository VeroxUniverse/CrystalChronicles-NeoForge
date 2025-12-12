package net.veroxuniverse.crystal_chronicles.spells;

import io.redspace.ironsspellbooks.api.registry.SpellRegistry;
import io.redspace.ironsspellbooks.api.spells.AbstractSpell;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

import java.util.function.Supplier;

public class CCSpells {

    public static final DeferredRegister<AbstractSpell> SPELLS =
            DeferredRegister.create(SpellRegistry.SPELL_REGISTRY_KEY, CrystalChronicles.MODID);

    private static Supplier<PrismaticPortalSpell> PRISMATIC_PORTAL_SPELL_SUPPLIER;

    public static AbstractSpell getPrismaticPortalSpell() {
        if (PRISMATIC_PORTAL_SPELL_SUPPLIER == null) {
            return null;
        }
        return PRISMATIC_PORTAL_SPELL_SUPPLIER.get();
    }


    public static void register(IEventBus modEventBus) {

        Supplier<PrismaticPortalSpell> supplier = SPELLS.register(
                PrismaticPortalSpell.SPELL_ID.getPath(),
                PrismaticPortalSpell::new
        );

        PRISMATIC_PORTAL_SPELL_SUPPLIER = supplier;

        SPELLS.register(modEventBus);
    }
}