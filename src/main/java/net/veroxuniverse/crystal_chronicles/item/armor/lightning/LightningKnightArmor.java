package net.veroxuniverse.crystal_chronicles.item.armor.lightning;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorMaterial;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;

public class LightningKnightArmor extends AnimatedSpellArmor {

    public LightningKnightArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, schoolAttributes(AttributeRegistry.LIGHTNING_SPELL_POWER));
    }

}
