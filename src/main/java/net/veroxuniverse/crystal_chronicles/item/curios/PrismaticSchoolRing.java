package net.veroxuniverse.crystal_chronicles.item.curios;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.api.magic.MagicData;
import io.redspace.ironsspellbooks.api.registry.AttributeRegistry;
import io.redspace.ironsspellbooks.item.CastingItem;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.veroxuniverse.crystal_chronicles.item.armor.prismatic.PrismaticKnightArmor;
import net.veroxuniverse.crystal_chronicles.registry.CCDataComponents;
import net.veroxuniverse.crystal_chronicles.registry.CCKeybinds;
import top.theillusivec4.curios.api.SlotContext;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

import java.util.List;

public class PrismaticSchoolRing extends CastingItem implements ICurioItem {

    private static final List<String> SCHOOLS = List.of("fire", "ice", "lightning", "holy", "ender", "blood", "evocation", "nature");
    private static final int MANA_COST = 50;

    public PrismaticSchoolRing(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide) {
            swapSchool(stack, player);
        }
        return InteractionResultHolder.success(stack);
    }

    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        LivingEntity entity = slotContext.entity();
        if (!entity.level().isClientSide && entity.tickCount % 20 == 0) {
            if (!hasFullPrismaticArmor(entity)) {
                if (entity instanceof Player player) {
                    ItemStack copy = stack.copy();
                    stack.setCount(0);

                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ITEM_BREAK, SoundSource.PLAYERS, 1.0f, 0.5f);
                    player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                            SoundEvents.ARMOR_EQUIP_GENERIC, SoundSource.PLAYERS, 1.0f, 1.0f);

                    if (!player.getInventory().add(copy)) {
                        player.drop(copy, false);
                        player.displayClientMessage(Component.translatable("tooltip.crystal_chronicles.ring_dropped")
                                .withStyle(ChatFormatting.RED), true);
                    }
                }
            }
        }
    }

    @Override
    public Multimap<Holder<Attribute>, AttributeModifier> getAttributeModifiers(SlotContext slotContext, ResourceLocation id, ItemStack stack) {
        ImmutableMultimap.Builder<Holder<Attribute>, AttributeModifier> builder = ImmutableMultimap.builder();
        String school = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");
        double bonus = 0.20;

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
                .withStyle(ChatFormatting.GOLD)
                .append(": ")
                .append(getSchoolComponent(school)));

        if (net.minecraft.client.gui.screens.Screen.hasShiftDown()) {
            tooltip.add(Component.empty());

            tooltip.add(Component.translatable("tooltip.crystal_chronicles.shift_focus_header").withStyle(ChatFormatting.GRAY));

            tooltip.add(Component.translatable("tooltip.crystal_chronicles.shift_focus_click").withStyle(ChatFormatting.GRAY));

            if (Minecraft.getInstance() != null) {
                MutableComponent hotkeyLine = Component.translatable("tooltip.crystal_chronicles.ring_hotkey_1").withStyle(ChatFormatting.GRAY)
                        .append(CCKeybinds.RING_SWAP_KEY.getTranslatedKeyMessage().copy().withStyle(ChatFormatting.YELLOW))
                        .append(Component.translatable("tooltip.crystal_chronicles.ring_hotkey_2").withStyle(ChatFormatting.GRAY));
                tooltip.add(hotkeyLine);
            }

            tooltip.add(Component.empty());

            tooltip.add(Component.translatable("tooltip.crystal_chronicles.ring_desc_3", MANA_COST).withStyle(ChatFormatting.BLUE));
            tooltip.add(Component.translatable("tooltip.crystal_chronicles.requires_armor_set").withStyle(ChatFormatting.RED, ChatFormatting.BOLD));
        } else {
            tooltip.add(Component.translatable("tooltip.crystal_chronicles.shift_for_info").withStyle(ChatFormatting.DARK_GRAY, ChatFormatting.ITALIC));
        }

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

    @Override
    public boolean canEquip(SlotContext slotContext, ItemStack stack) {
        return hasFullPrismaticArmor(slotContext.entity());
    }

    private boolean hasFullPrismaticArmor(LivingEntity entity) {
        return entity.getItemBySlot(EquipmentSlot.HEAD).getItem() instanceof PrismaticKnightArmor &&
                entity.getItemBySlot(EquipmentSlot.CHEST).getItem() instanceof PrismaticKnightArmor &&
                entity.getItemBySlot(EquipmentSlot.LEGS).getItem() instanceof PrismaticKnightArmor &&
                entity.getItemBySlot(EquipmentSlot.FEET).getItem() instanceof PrismaticKnightArmor;
    }

    public void swapSchool(ItemStack stack, Player player) {
        MagicData magicData = MagicData.getPlayerMagicData(player);

        if (magicData.getMana() < MANA_COST) {
            player.displayClientMessage(Component.translatable("tooltip.crystal_chronicles.not_enough_mana").withStyle(ChatFormatting.RED), true);
            return;
        }

        magicData.setMana(magicData.getMana() - MANA_COST);
        String current = stack.getOrDefault(CCDataComponents.SPELL_SCHOOL_ID.get(), "fire");
        int nextIndex = (SCHOOLS.indexOf(current) + 1) % SCHOOLS.size();
        String nextSchool = SCHOOLS.get(nextIndex);

        stack.set(CCDataComponents.SPELL_SCHOOL_ID.get(), nextSchool);

        player.level().playSound(null, player.getX(), player.getY(), player.getZ(),
                SoundEvents.AMETHYST_BLOCK_CHIME, SoundSource.PLAYERS, 1.0f, 1.0f);

        player.displayClientMessage(
                Component.translatable("tooltip.crystal_chronicles.school_changed")
                        .append(": ")
                        .append(getSchoolComponent(nextSchool)), true);
    }
}