package net.veroxuniverse.crystal_chronicles.registry;

import io.redspace.ironsspellbooks.api.attribute.MagicPercentAttribute;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityAttributeModificationEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;

import java.util.function.Supplier;

@EventBusSubscriber(modid = CrystalChronicles.MODID, bus = EventBusSubscriber.Bus.MOD)
public class CCAttributes {

    private static final DeferredRegister<Attribute> ATTRIBUTES =
            DeferredRegister.create(Registries.ATTRIBUTE, CrystalChronicles.MODID);

    public static void register(IEventBus eventBus) {
        ATTRIBUTES.register(eventBus);
    }

    public static final DeferredHolder<Attribute, Attribute> PRISMATIC_MAGIC_RESIST = newResistanceAttribute("prismatic");
    public static final DeferredHolder<Attribute, Attribute> PRISMATIC_SPELL_POWER = newPowerAttribute("prismatic");

    public static Holder<Attribute> holder(Supplier<Attribute> attributeSupplier) {
        return Holder.direct(attributeSupplier.get());
    }

    @SubscribeEvent
    public static void modifyEntityAttributes(EntityAttributeModificationEvent e) {
        e.getTypes().forEach(entity -> ATTRIBUTES.getEntries().forEach(attribute -> e.add(entity, attribute)));
    }

    private static DeferredHolder<Attribute, Attribute> newResistanceAttribute(String id) {
        return ATTRIBUTES.register(id + "_magic_resist",
                () -> new MagicPercentAttribute("attribute." + CrystalChronicles.MODID + "." + id + "_magic_resist", 1.0D, -100, 100).setSyncable(true));
    }

    private static DeferredHolder<Attribute, Attribute> newPowerAttribute(String id) {
        return ATTRIBUTES.register(id + "_spell_power",
                () -> new MagicPercentAttribute("attribute." + CrystalChronicles.MODID + "." + id + "_spell_power", 1.0D, -100, 100).setSyncable(true));
    }
}