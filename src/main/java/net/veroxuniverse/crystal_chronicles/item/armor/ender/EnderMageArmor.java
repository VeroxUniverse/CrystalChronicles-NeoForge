package net.veroxuniverse.crystal_chronicles.item.armor.ender;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class EnderMageArmor extends AnimatedSpellArmor {

    public EnderMageArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.ENDER_SPELL_POWER));
    }

}
