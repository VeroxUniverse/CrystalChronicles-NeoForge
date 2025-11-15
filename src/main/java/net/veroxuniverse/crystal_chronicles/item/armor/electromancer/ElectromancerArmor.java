package net.veroxuniverse.crystal_chronicles.item.armor.electromancer;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class ElectromancerArmor extends AnimatedSpellArmor {

    public ElectromancerArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.LIGHTNING_SPELL_POWER));
    }

}
