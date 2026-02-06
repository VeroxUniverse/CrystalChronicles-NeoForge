package net.veroxuniverse.crystal_chronicles.item.armor.holy;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class HolyKnightArmor extends AnimatedSpellArmor {
    public HolyKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.HOLY_SPELL_POWER));
    }

}
