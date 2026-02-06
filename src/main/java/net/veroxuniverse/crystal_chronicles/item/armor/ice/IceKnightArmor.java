package net.veroxuniverse.crystal_chronicles.item.armor.ice;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class IceKnightArmor extends AnimatedSpellArmor {
    public IceKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, tankSchoolAttributes(AttributeRegistry.ICE_SPELL_POWER));;
    }

}
