package net.veroxuniverse.crystal_chronicles.item.armor.rogue;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class RogueArmor extends AnimatedSpellArmor {
    public RogueArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.BLOOD_SPELL_POWER));
    }

}
