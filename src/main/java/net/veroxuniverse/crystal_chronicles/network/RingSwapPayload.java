package net.veroxuniverse.crystal_chronicles.network;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.item.curios.PrismaticSchoolRing;
import top.theillusivec4.curios.api.CuriosApi;

public record RingSwapPayload() implements CustomPacketPayload {
    public static final Type<RingSwapPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(CrystalChronicles.MODID, "ring_swap"));

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static final StreamCodec<FriendlyByteBuf, RingSwapPayload> STREAM_CODEC = StreamCodec.unit(new RingSwapPayload());

    public static void handle(final RingSwapPayload payload, final IPayloadContext context) {
        context.enqueueWork(() -> {
            if (context.player() instanceof ServerPlayer player) {
                CuriosApi.getCuriosHelper().findFirstCurio(player, stack -> stack.getItem() instanceof PrismaticSchoolRing)
                        .ifPresent(slotResult -> {
                            ((PrismaticSchoolRing) slotResult.stack().getItem()).swapSchool(slotResult.stack(), player);
                        });
            }
        });
    }
}