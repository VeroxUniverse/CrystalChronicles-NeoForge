package net.veroxuniverse.crystal_chronicles.item.armor.fire;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class FireKnightArmor extends AnimatedSpellArmor {

    public FireKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.FIRE_SPELL_POWER));
    }

}
