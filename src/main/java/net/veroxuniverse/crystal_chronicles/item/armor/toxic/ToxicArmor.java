package net.veroxuniverse.crystal_chronicles.item.armor.toxic;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class ToxicArmor extends AnimatedSpellArmor {

    public ToxicArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.NATURE_SPELL_POWER));
    }

}
