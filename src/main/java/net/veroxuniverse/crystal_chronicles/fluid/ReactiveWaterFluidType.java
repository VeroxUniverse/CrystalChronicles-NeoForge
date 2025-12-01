package net.veroxuniverse.crystal_chronicles.fluid;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidType;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ReactiveWaterFluidType extends FluidType {

    public ReactiveWaterFluidType(Properties properties) {
        super(properties);
    }

    @Override
    public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {

        final int ALPHA_TRANSLUCENT = 0x77;
        final int DEFAULT_TINT = (ALPHA_TRANSLUCENT << 24) | 0xA5D5D5;
        final Vector3f FOG_COLOR = new Vector3f(1.0f, 0.9f, 0.5f);
        final int MAX_SEARCH_DEPTH = 3;

        consumer.accept(new IClientFluidTypeExtensions() {

            @Override
            public ResourceLocation getStillTexture() {
                return ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_still");
            }

            @Override
            public ResourceLocation getFlowingTexture() {
                return ResourceLocation.fromNamespaceAndPath("minecraft", "block/water_flow");
            }

            @Override
            public int getTintColor(FluidState state, BlockAndTintGetter getter, BlockPos pos) {

                if (getter == null || pos == null) return DEFAULT_TINT;

                List<Integer> foundColors = new ArrayList<>();

                for (int yOffset = 1; yOffset <= MAX_SEARCH_DEPTH; yOffset++) {

                    BlockPos baseSearchPos = pos.below(yOffset);

                    List<BlockPos> positionsToCheck = new ArrayList<>();
                    positionsToCheck.add(baseSearchPos);

                    positionsToCheck.add(baseSearchPos.relative(Direction.NORTH));
                    positionsToCheck.add(baseSearchPos.relative(Direction.SOUTH));
                    positionsToCheck.add(baseSearchPos.relative(Direction.EAST));
                    positionsToCheck.add(baseSearchPos.relative(Direction.WEST));

                    boolean foundSolidBlock = false;

                    for (BlockPos searchPos : positionsToCheck) {
                        BlockState bs = getter.getBlockState(searchPos);
                        int color = -1;

                        if (bs.is(CCBlocks.GREEN_SULPHUR_POOL.get())) color = 0x00FF00;
                        else if (bs.is(CCBlocks.YELLOW_SULPHUR_POOL.get())) color = 0xFFFF00;
                        else if (bs.is(CCBlocks.ORANGE_SULPHUR_POOL.get())) color = 0xFF8800;
                        else if (bs.is(CCBlocks.RED_SULPHUR_POOL.get())) color = 0xFF0000;
                        else if (bs.is(CCBlocks.VERMILLION_SULPHUR_POOL.get())) color = 0xDD2200;

                        if (color != -1) {
                            foundColors.add(color);
                        }

                        if (searchPos.equals(baseSearchPos) && bs.isSolidRender(getter, searchPos)) {
                            foundSolidBlock = true;
                        }
                    }

                    if (foundSolidBlock) {
                        break;
                    }

                    if (getter.getBlockState(baseSearchPos).isAir()) {
                        break;
                    }

                }

                if (!foundColors.isEmpty()) {
                    long totalRed = 0;
                    long totalGreen = 0;
                    long totalBlue = 0;

                    for (int color : foundColors) {
                        totalRed += (color >> 16) & 0xFF;
                        totalGreen += (color >> 8) & 0xFF;
                        totalBlue += color & 0xFF;
                    }

                    int averageRed = (int) (totalRed / foundColors.size());
                    int averageGreen = (int) (totalGreen / foundColors.size());
                    int averageBlue = (int) (totalBlue / foundColors.size());

                    int blendedColor = (averageRed << 16) | (averageGreen << 8) | averageBlue;

                    return (ALPHA_TRANSLUCENT << 24) | blendedColor;
                }

                return DEFAULT_TINT;
            }

            @Override
            public Vector3f modifyFogColor(Camera camera, float partialTick, ClientLevel level, int renderDistance, float darkenWorldAmount, Vector3f fluidFogColor) {
                return FOG_COLOR;
            }

            @Override
            public void modifyFogRender(Camera camera, FogRenderer.FogMode mode, float renderDistance, float partialTick, float nearDistance, float farDistance, FogShape shape) {
                if (mode == FogRenderer.FogMode.FOG_SKY || mode == FogRenderer.FogMode.FOG_TERRAIN) {
                    RenderSystem.setShaderFogStart(1.0F);
                    RenderSystem.setShaderFogEnd(3.0F);
                    RenderSystem.setShaderFogShape(FogShape.SPHERE);
                }
            }
        });
    }
}