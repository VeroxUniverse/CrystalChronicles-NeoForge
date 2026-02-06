package net.veroxuniverse.crystal_chronicles.item.armor.evocation;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class EvocationKnightArmor extends AnimatedSpellArmor {

    public EvocationKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.EVOCATION_SPELL_POWER));
    }

}
