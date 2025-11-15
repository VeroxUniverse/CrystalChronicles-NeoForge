package net.veroxuniverse.crystal_chronicles.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VentBlock extends Block {

    private static final VoxelShape SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);

    public VentBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);

        int count = 3 + random.nextInt(2);

        for (int i = 0; i < count; i++) {

            double x = pos.getX() + 0.5D + (random.nextDouble() - 0.5D) * 0.3D;
            double y = pos.getY() + 1.0D + random.nextDouble() * 0.2D;
            double z = pos.getZ() + 0.5D + (random.nextDouble() - 0.5D) * 0.3D;

            /*

            if (random.nextFloat() < 0.9F) {
                level.addParticle(
                        ParticleTypes.BUBBLE,
                        x, y, z,
                        0.0D,
                        0.01D + random.nextDouble() * 0.02D,
                        0.0D
                );
            }

            if (random.nextFloat() < 0.7F) {
                level.addParticle(
                        ParticleTypes.CLOUD,
                        x, y, z,
                        0.0D,
                        0.01D + random.nextDouble() * 0.02D,
                        0.0D
                );
            }

             */

            level.addParticle(
                    ParticleTypes.SMOKE,
                    x, y, z,
                    0.0D,
                    0.01D + random.nextDouble() * 0.02D,
                    0.0D
            );

            if (random.nextFloat() < 0.25F) {
                level.addParticle(
                        ParticleTypes.LARGE_SMOKE,
                        x, y, z,
                        0.0D,
                        0.01D + random.nextDouble() * 0.02D,
                        0.0D
                );
            }
        }
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);

        if (!level.isClientSide && entity instanceof Player player) {
            if (!player.isCreative() && !player.isSpectator()) {
                player.igniteForSeconds(2);
            }
        }
    }
}
