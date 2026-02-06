package net.veroxuniverse.crystal_chronicles.item.armor.blood;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class BloodKnightArmor extends AnimatedSpellArmor {
    public BloodKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.BLOOD_SPELL_POWER));
    }

}
