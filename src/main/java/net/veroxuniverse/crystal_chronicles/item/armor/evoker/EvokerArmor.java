package net.veroxuniverse.crystal_chronicles.item.armor.evoker;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class EvokerArmor extends AnimatedSpellArmor {

    public EvokerArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.EVOCATION_SPELL_POWER));
    }

}
