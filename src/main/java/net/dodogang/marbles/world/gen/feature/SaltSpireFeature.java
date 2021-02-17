package net.dodogang.marbles.world.gen.feature;

import com.mojang.serialization.Codec;
import net.dodogang.marbles.block.PinkSaltSpireBlock;
import net.dodogang.marbles.init.MarblesBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;

import java.util.Random;

public class SaltSpireFeature extends Feature<DefaultFeatureConfig> {
    public static final String id = "salt_spire";

    private static final BlockState SALT_SPIRE = MarblesBlocks.PINK_SALT_SPIRE.getDefaultState();

    public SaltSpireFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        int placedBlocks = 0;

        BlockPos.Mutable mpos = new BlockPos.Mutable();
        mpos.set(pos);

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        for (int proj = 0; proj < 40; proj++) {
            int y1 = y - proj;
            int y2 = y + proj;

            mpos.set(x, y1, z);
            if (canBuildUpAt(world, mpos)) {
                y = y1;
                break;
            }

            mpos.set(x, y2, z);
            if (canBuildUpAt(world, mpos)) {
                y = y2;
                break;
            }

            mpos.set(x, y1, z);
            if (canBuildDownAt(world, mpos)) {
                y = y1;
                break;
            }

            mpos.set(x, y2, z);
            if (canBuildDownAt(world, mpos)) {
                y = y2;
                break;
            }
        }

        if (!projectState(world, x, y, z, SALT_SPIRE, mpos, random, 8)) {
            return false;
        }


        for (int ox = -5; ox <= 5; ox++) {
            for (int oz = -5; oz <= 5; oz++) {
                int r = ox * ox + oz * oz;

                if (random.nextInt(4 + r / 3) == 0 && r < 5 * 5) {
                    if (projectState(world, ox + x, y, oz + z, SALT_SPIRE, mpos, random, 2 + 10 / (r + 1))) {
                        placedBlocks++;
                    }
                }
            }
        }


        return placedBlocks > 0;
    }

    private boolean projectState(StructureWorldAccess world, int x, int y, int z, BlockState state, BlockPos.Mutable mpos, Random rand, int maxlen) {
        for (int proj = 0; proj < 10; proj++) {
            int y1 = y - proj;
            int y2 = y + proj;

            mpos.set(x, y1, z);
            if (canBuildUpAt(world, mpos)) {
                mpos.set(x, y1, z);
                int len = rand.nextInt(maxlen) + 1;
                for (int i = 0; i < len; i++) {
                    if (world.getBlockState(mpos).isAir()) {
                        placeCorrectBlock(world, state, mpos);
                    }
                    mpos.move(Direction.UP);
                }
                return true;
            }

            mpos.set(x, y2, z);
            if (canBuildUpAt(world, mpos)) {
                mpos.set(x, y2, z);
                int len = rand.nextInt(maxlen) + 1;
                for (int i = 0; i < len; i++) {
                    if (world.getBlockState(mpos).isAir()) {
                        placeCorrectBlock(world, state, mpos);
                    }
                    mpos.move(Direction.UP);
                }
                return true;
            }

            mpos.set(x, y1, z);
            if (canBuildDownAt(world, mpos)) {
                mpos.set(x, y1, z);
                int len = rand.nextInt(maxlen) + 1;
                for (int i = 0; i < len; i++) {
                    if (world.getBlockState(mpos).isAir()) {
                        placeCorrectBlock(world, state.with(PinkSaltSpireBlock.VERTICAL_DIRECTION, Direction.DOWN), mpos);
                    }
                    mpos.move(Direction.DOWN);
                }
                return true;
            }

            mpos.set(x, y2, z);
            if (canBuildDownAt(world, mpos)) {
                mpos.set(x, y2, z);
                int len = rand.nextInt(maxlen) + 1;
                for (int i = 0; i < len; i++) {
                    if (world.getBlockState(mpos).isAir()) {
                        placeCorrectBlock(world, state.with(PinkSaltSpireBlock.VERTICAL_DIRECTION, Direction.DOWN), mpos);
                    }
                    mpos.move(Direction.DOWN);
                }
                return true;
            }
        }

        return false;
    }

    private void placeCorrectBlock(StructureWorldAccess world, BlockState state, BlockPos pos) {
        BlockPos up = pos.up();
        BlockPos down = pos.down();
        BlockState modified = state.getStateForNeighborUpdate(Direction.UP, world.getBlockState(up), world, pos, pos.up());
        modified = modified.getStateForNeighborUpdate(Direction.DOWN, world.getBlockState(down), world, pos, pos.down());
        world.setBlockState(pos, modified, 2);
    }

    private boolean canBuildUpAt(StructureWorldAccess world, BlockPos.Mutable pos) {
        return world.getBlockState(pos).isAir() && (
            world.getBlockState(pos.move(Direction.DOWN)).isOf(MarblesBlocks.PINK_SALT) ||
                world.getBlockState(pos.move(Direction.DOWN)).isOf(MarblesBlocks.CRUMBLED_PINK_SALT)
        );
    }

    private boolean canBuildDownAt(StructureWorldAccess world, BlockPos.Mutable pos) {
        return world.getBlockState(pos).isAir() && (
            world.getBlockState(pos.move(Direction.UP)).isOf(MarblesBlocks.PINK_SALT) ||
                world.getBlockState(pos.move(Direction.UP)).isOf(MarblesBlocks.CRUMBLED_PINK_SALT)
        );
    }
}
