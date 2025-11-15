package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class HolyMarblePillarBlock extends Block {

    public static final VoxelShape SHAPE_BASE = Block.box(2.0D, 0, 2.0D, 14.0D, 16.0D, 14.0D);

    public static final EnumProperty<Part> PART = EnumProperty.create("part", Part.class);

    public HolyMarblePillarBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(PART, Part.SINGLE)
        );
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(PART);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Part part = getPartFor(level, pos);
        return this.defaultBlockState().setValue(PART, part);
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

    @Override
    protected BlockState updateShape(BlockState state,
                                     Direction direction,
                                     BlockState neighborState,
                                     LevelAccessor level,
                                     BlockPos pos,
                                     BlockPos neighborPos) {

        BlockState newState = state;

        if (direction == Direction.UP || direction == Direction.DOWN) {
            Part newPart = getPartFor(level, pos);
            newState = state.setValue(PART, newPart);
        }

        return super.updateShape(newState, direction, neighborState, level, pos, neighborPos);
    }

    private Part getPartFor(LevelAccessor level, BlockPos pos) {
        boolean upSame = level.getBlockState(pos.above()).is(this);
        boolean downSame = level.getBlockState(pos.below()).is(this);

        if (upSame && downSame) {
            return Part.MIDDLE;
        } else if (upSame) {
            return Part.BOTTOM;
        } else if (downSame) {
            return Part.TOP;
        } else {
            return Part.SINGLE;
        }
    }

    public enum Part implements StringRepresentable {
        SINGLE("single"),
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom");

        private final String name;

        Part(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
