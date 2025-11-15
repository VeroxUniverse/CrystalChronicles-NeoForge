package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class HolyBeaconBlock extends Block {

    public static final VoxelShape SHAPE_BASE = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 11.0D, 11.0D);


    public HolyBeaconBlock(Properties properties) {
        super(properties);
    }

    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    public @NotNull VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return SHAPE_BASE;
    }

    public boolean useShapeForLightOcclusion(BlockState pState) {
        return true;
    }

    public @NotNull VoxelShape getCollisionShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        return SHAPE_BASE;
    }


    public @NotNull VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext context) {
        return SHAPE_BASE;
    }

}
