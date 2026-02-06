package net.veroxuniverse.crystal_chronicles.item.armor.nature;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class NatureKnightArmor extends AnimatedSpellArmor {

    public NatureKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.NATURE_SPELL_POWER));
    }

}
