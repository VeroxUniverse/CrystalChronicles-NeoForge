package net.veroxuniverse.crystal_chronicles.item.armor.paladin;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class PaladinArmor extends AnimatedSpellArmor {
    public PaladinArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.HOLY_SPELL_POWER));
    }

}
