package net.veroxuniverse.crystal_chronicles.item.armor.mage;

import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.veroxuniverse.crystal_chronicles.item.armor.AnimatedSpellArmor;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class MageArmor extends AnimatedSpellArmor {

    public MageArmor(Holder<ArmorMaterial> holder, Type type, Properties properties) {
        super(holder, type, properties, mixedSchoolAttributes(AttributeRegistry.ENDER_SPELL_POWER, AttributeRegistry.EVOCATION_SPELL_POWER));
    }

    @Override
    public void createRenderer(Consumer<RenderProvider> consumer) {
        consumer.accept(new RenderProvider() {
            private MageArmorRenderer renderer;

            @Override
            public @NotNull HumanoidModel<LivingEntity> getHumanoidArmorModel(LivingEntity livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, HumanoidModel<LivingEntity> original) {
                if (renderer == null)
                    return new MageArmorRenderer();
                renderer.prepForRender(livingEntity, itemStack, equipmentSlot, original);
                return this.renderer;
            }
        });
    }

}
