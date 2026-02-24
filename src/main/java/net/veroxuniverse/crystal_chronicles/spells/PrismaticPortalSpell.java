package net.veroxuniverse.crystal_chronicles.spells;

import io.redspace.ironsspellbooks.api.config.DefaultConfig;
import io.redspace.ironsspellbooks.api.spells.*;
import net.minecraft.resources.ResourceLocation;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.registry.CCSchools;

@AutoSpellConfig
public class PrismaticPortalSpell extends AbstractSpell {

    private static final int BASE_MANA_COST = 50;
    private static final int DEFAULT_COOLDOWN = 600;
    public static final ResourceLocation SPELL_ID =
            ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "prismatic_portal");

    public PrismaticPortalSpell() {
        super();

        this.baseManaCost = BASE_MANA_COST;
        this.castTime = 0;
        this.baseSpellPower = 0;
        this.spellPowerPerLevel = 0;
    }

    @Override
    public SchoolType getSchoolType() {
        return CCSchools.PRISMATIC.get();
    }

    @Override
    public ResourceLocation getSpellResource() {
        return SPELL_ID;
    }

    @Override
    public DefaultConfig getDefaultConfig() {
        DefaultConfig config = new DefaultConfig();
        config.setMinRarity(SpellRarity.LEGENDARY);
        config.setMaxLevel(1);
        config.setCooldownSeconds(DEFAULT_COOLDOWN / 20.0);
        config.setSchoolResource(CCSchools.PRISMATIC_ID);
        return config.build();
    }

    @Override
    public CastType getCastType() {
        return CastType.INSTANT;
    }

}