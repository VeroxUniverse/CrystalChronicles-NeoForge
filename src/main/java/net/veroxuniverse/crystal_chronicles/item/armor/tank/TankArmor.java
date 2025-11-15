package net.veroxuniverse.crystal_chronicles.item.armor.tank;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class TankArmor extends AnimatedSpellArmor {
    public TankArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, tankSchoolAttributes(AttributeRegistry.ICE_SPELL_POWER));;
    }

}
