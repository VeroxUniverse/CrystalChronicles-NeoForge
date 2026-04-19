package net.veroxuniverse.crystal_chronicles.item.curios;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import net.minecraft.ChatFormatting;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.veroxuniverse.crystal_chronicles.registry.CCDataComponents;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class PrismaticSchoolRing extends Item implements ICurioItem {

    private static final List<String> SCHOOLS = List.of("fire", "ice", "lightning", "holy", "ender", "blood", "evocation", "nature");

    public PrismaticSchoolRing(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            String current = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");
            int nextIndex = (SCHOOLS.indexOf(current) + 1) % SCHOOLS.size();
            String nextSchool = SCHOOLS.get(nextIndex);

            stack.set(CCDataComponents.SPELL_SCHOOL_ID.get(), nextSchool);

            level.playSound(null, player.getX(), player.getY(), player.getZ(),
                    SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.PLAYERS, 0.8f, 1.2f);

            player.displayClientMessage(
                    Component.translatable("tooltip.crystal_chronicles.school_changed")
                            .append(": ")
                            .append(getSchoolComponent(nextSchool)), true);
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
        String school = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");

        double bonus = 0.20; // 20% Spell Power

        switch (school) {
            case "fire" -> builder.put(AttributeRegistry.FIRE_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "ice" -> builder.put(AttributeRegistry.ICE_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "lightning" -> builder.put(AttributeRegistry.LIGHTNING_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "holy" -> builder.put(AttributeRegistry.HOLY_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "ender" -> builder.put(AttributeRegistry.ENDER_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "blood" -> builder.put(AttributeRegistry.BLOOD_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "evocation" -> builder.put(AttributeRegistry.EVOCATION_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
            case "nature" -> builder.put(AttributeRegistry.NATURE_SPELL_POWER, new AttributeModifier(id, bonus, AttributeModifier.Operation.ADD_MULTIPLIED_BASE));
        }

        return builder.build();
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag flag) {
        String school = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");

        tooltip.add(Component.translatable("tooltip.crystal_chronicles.current_school")
                .append(": ")
                .append(getSchoolComponent(school)));

        tooltip.add(Component.empty());

        tooltip.add(Component.translatable("tooltip.crystal_chronicles.ring_description")
                .withStyle(ChatFormatting.GRAY, ChatFormatting.ITALIC));

        super.appendHoverText(stack, context, tooltip, flag);
    }

    private MutableComponent getSchoolComponent(String school) {
        ChatFormatting color = switch (school) {
            case "fire" -> ChatFormatting.RED;
            case "ice" -> ChatFormatting.AQUA;
            case "lightning" -> ChatFormatting.BLUE;
            case "holy" -> ChatFormatting.GOLD;
            case "ender" -> ChatFormatting.DARK_PURPLE;
            case "blood" -> ChatFormatting.DARK_RED;
            case "evocation" -> ChatFormatting.DARK_GREEN;
            case "nature" -> ChatFormatting.GREEN;
            default -> ChatFormatting.WHITE;
        };

        return Component.literal(school.toUpperCase()).withStyle(color, ChatFormatting.BOLD);
    }
}