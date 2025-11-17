package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.veroxuniverse.crystal_chronicles.registry.CCBlocks;

public class HolyLightSegmentBlock extends Block {

    public HolyLightSegmentBlock(Properties props) {
        super(props);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public VoxelShape getVisualShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return Shapes.empty();
    }

    @Override
    public boolean canBeReplaced(BlockState state, BlockPlaceContext ctx) {
        return true;
    }

    @Override
    public float getDestroyProgress(BlockState state, Player player, BlockGetter level, BlockPos pos) {
        return 0.0F;
    }

    private void scheduleHolyLightUpdate(Level level, BlockPos pos) {
        for (int dy = 1; dy <= 4; dy++) {
            BlockPos abovePos = pos.above(dy);
            BlockState aboveState = level.getBlockState(abovePos);

            if (aboveState.is(CCBlocks.HOLY_LIGHT_BLOCK.get())) {
                level.scheduleTick(abovePos, aboveState.getBlock(), 1);
                break;
            }

            if (!aboveState.is(CCBlocks.HOLY_LIGHT_1.get())
                    && !aboveState.is(CCBlocks.HOLY_LIGHT_2.get())
                    && !aboveState.is(CCBlocks.HOLY_LIGHT_3.get())
                    && !aboveState.isAir()) {
                break;
            }
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        super.onPlace(state, level, pos, oldState, isMoving);
        if (!level.isClientSide) {
            scheduleHolyLightUpdate(level, pos);
        }
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            scheduleHolyLightUpdate(level, pos);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        super.neighborChanged(state, level, pos, block, fromPos, isMoving);

        if (!level.isClientSide) {
            if (fromPos.getY() < pos.getY()) {
                scheduleHolyLightUpdate(level, pos);
            }
        }
    }
}
