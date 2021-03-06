package net.dodogang.marbles.datagen.models;

import me.andante.chord.block.helper.WoodBlocks;
import net.dodogang.marbles.datagen.models.modelgen.ModelGen;
import net.dodogang.marbles.datagen.models.stategen.StateGen;
import net.dodogang.marbles.init.MarblesBlocks;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.function.BiConsumer;
import java.util.function.Function;

import static net.dodogang.marbles.datagen.models.modelgen.InheritingModelGen.*;
import static net.dodogang.marbles.datagen.models.modelgen.ParticleOnlyModelGen.particles;
import static net.dodogang.marbles.datagen.models.stategen.BuildingBlocks.slabAll;
import static net.dodogang.marbles.datagen.models.stategen.BuildingBlocks.stairsAll;
import static net.dodogang.marbles.datagen.models.stategen.BuildingBlocks.*;
import static net.dodogang.marbles.datagen.models.stategen.InteractiveBlocks.button;
import static net.dodogang.marbles.datagen.models.stategen.InteractiveBlocks.fenceGate;
import static net.dodogang.marbles.datagen.models.stategen.InteractiveBlocks.pressurePlate;
import static net.dodogang.marbles.datagen.models.stategen.InteractiveBlocks.*;
import static net.dodogang.marbles.datagen.models.stategen.SimpleBlocks.*;

public final class BlockStateTable {
    private static BiConsumer<Block, StateGen> consumer;

    public static void registerBlockStates(BiConsumer<Block, StateGen> c) {
        consumer = c;

        registerWoodBlocks(MarblesBlocks.ASPEN);
        registerWoodBlocks(MarblesBlocks.HOOPSI_SPRUCE);

        register(MarblesBlocks.TRAVERTINE, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.TRAVERTINE_BRICKS, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CAPPED_TRAVERTINE, block -> facingRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.POLISHED_TRAVERTINE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.TRAVERTINE_BRICK_SLAB, block -> using(name(block, "block/%s_bricks", "_brick_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.CAPPED_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.POLISHED_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabAll(name(block, "block/%s"), n, n)));
        register(MarblesBlocks.TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.TRAVERTINE_BRICK_STAIRS, block -> using(name(block, "block/%s_bricks", "_brick_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsAll(name(block, "block/%s"), n)));
        register(MarblesBlocks.TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.TRAVERTINE_BRICK_WALL, block -> using(name(block, "block/%s_bricks", "_brick_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallAll(name(block, "block/%s"), n)));

        register(MarblesBlocks.LEMON_TRAVERTINE, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.LEMON_TRAVERTINE_BRICKS, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CAPPED_LEMON_TRAVERTINE, block -> facingRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.POLISHED_LEMON_TRAVERTINE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.LEMON_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.LEMON_TRAVERTINE_BRICK_SLAB, block -> using(name(block, "block/%s_bricks", "_brick_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.CAPPED_LEMON_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.POLISHED_LEMON_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabAll(name(block, "block/%s"), n, n)));
        register(MarblesBlocks.LEMON_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.LEMON_TRAVERTINE_BRICK_STAIRS, block -> using(name(block, "block/%s_bricks", "_brick_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_LEMON_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_LEMON_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsAll(name(block, "block/%s"), n)));
        register(MarblesBlocks.LEMON_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.LEMON_TRAVERTINE_BRICK_WALL, block -> using(name(block, "block/%s_bricks", "_brick_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_LEMON_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_LEMON_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallAll(name(block, "block/%s"), n)));

        register(MarblesBlocks.PEACH_TRAVERTINE, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.PEACH_TRAVERTINE_BRICKS, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CAPPED_PEACH_TRAVERTINE, block -> facingRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.POLISHED_PEACH_TRAVERTINE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.PEACH_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.PEACH_TRAVERTINE_BRICK_SLAB, block -> using(name(block, "block/%s_bricks", "_brick_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.CAPPED_PEACH_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.POLISHED_PEACH_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabAll(name(block, "block/%s"), n, n)));
        register(MarblesBlocks.PEACH_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.PEACH_TRAVERTINE_BRICK_STAIRS, block -> using(name(block, "block/%s_bricks", "_brick_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_PEACH_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_PEACH_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsAll(name(block, "block/%s"), n)));
        register(MarblesBlocks.PEACH_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.PEACH_TRAVERTINE_BRICK_WALL, block -> using(name(block, "block/%s_bricks", "_brick_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_PEACH_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_PEACH_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallAll(name(block, "block/%s"), n)));

        register(MarblesBlocks.TANGERINE_TRAVERTINE, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_BRICKS, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CAPPED_TANGERINE_TRAVERTINE, block -> facingRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.POLISHED_TANGERINE_TRAVERTINE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_BRICK_SLAB, block -> using(name(block, "block/%s_bricks", "_brick_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.CAPPED_TANGERINE_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabColumn(name(block, "block/%s"), n, n + "_top", n)));
        register(MarblesBlocks.POLISHED_TANGERINE_TRAVERTINE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabAll(name(block, "block/%s"), n, n)));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_BRICK_STAIRS, block -> using(name(block, "block/%s_bricks", "_brick_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_TANGERINE_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_TANGERINE_TRAVERTINE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsAll(name(block, "block/%s"), n)));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_BRICK_WALL, block -> using(name(block, "block/%s_bricks", "_brick_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.CAPPED_TANGERINE_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallColumn(name(block, "block/%s"), n + "_top", n)));
        register(MarblesBlocks.POLISHED_TANGERINE_TRAVERTINE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallAll(name(block, "block/%s"), n)));

        register(MarblesBlocks.TRAVERTINE_OBSIDIAN, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));

        register(MarblesBlocks.TRAVERTINE_SALT_LAMP, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.LEMON_TRAVERTINE_SALT_LAMP, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.PEACH_TRAVERTINE_SALT_LAMP, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.TANGERINE_TRAVERTINE_SALT_LAMP, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));

        register(MarblesBlocks.PINK_SALT, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.CRUMBLED_PINK_SALT, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.PINK_SALT_SPIRE, block -> predefined(name(block, "block/%s")));
        register(MarblesBlocks.PINK_SALT_STACK, block -> predefined(name(block, "block/%s")));
        register(MarblesBlocks.PINK_SALT_STUMP, block -> predefined(name(block, "block/%s")));

        register(MarblesBlocks.LAPIS_SHINGLES, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.LAPIS_SHINGLES_SLAB, block -> slabAll(name(block, "block/%s"), name(block, "block/%s", "_slab"), name(block, "block/%s", "_slab")));
        register(MarblesBlocks.LAPIS_SHINGLES_STAIRS, block -> stairsAll(name(block, "block/%s"), name(block, "block/%s", "_stairs")));
        register(MarblesBlocks.LAPIS_SPOTLIGHT, block -> facingRotated(name(block, "block/%s"), cubeSeparateSided(name(block, "block/%s_top"), name(block, "block/%s_side"), name(block, "block/%s_front"), name(block, "block/%s_back"))));
        register(MarblesBlocks.SPOTLIGHT_AIR, block -> simple(name(block, "block/%s"), ModelGen.EMPTY));

        register(MarblesBlocks.DAWN_SAND, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.DAWN_SANDSTONE, block -> simple(name(block, "block/%s"), cubeBottomTop(name(block, "block/%s_bottom"), name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CHISELED_DAWN_SANDSTONE, block -> simple(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top", "^chiseled_", ""), name(block, "block/%s"))));
        register(MarblesBlocks.CUT_DAWN_SANDSTONE, block -> simple(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top", "^cut_", ""), name(block, "block/%s"))));
        register(MarblesBlocks.SMOOTH_DAWN_SANDSTONE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s_top", "^smooth_", ""))));
        register(MarblesBlocks.DAWN_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabSided(name(block, "block/%s"), n, n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DAWN_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "(^cut_)|(_slab$)", ""), n -> slabColumn(name(block, "block/%s"), n, n + "_top", name(block, "block/%s", "_slab"))));
        register(MarblesBlocks.SMOOTH_DAWN_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "(^smooth_)|(_slab$)", ""), n -> slabAll(name(block, "block/%s"), n, n + "_top")));
        register(MarblesBlocks.DAWN_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsSided(name(block, "block/%s"), n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DAWN_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "(^cut_)|(_stairs$)", ""), n -> stairsColumn(name(block, "block/%s"), n + "_top", name(block, "block/%s", "_stairs"))));
        register(MarblesBlocks.SMOOTH_DAWN_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "(^smooth_)|(_stairs$)", ""), n -> stairsAll(name(block, "block/%s"), n + "_top")));
        register(MarblesBlocks.DAWN_SANDSTONE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallSided(name(block, "block/%s"), n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DAWN_SANDSTONE_WALL, block -> using(name(block, "block/%s", "(^cut_)|(_wall$)", ""), n -> wallColumn(name(block, "block/%s"), n + "_top", name(block, "block/%s", "_wall"))));
        register(MarblesBlocks.SMOOTH_DAWN_SANDSTONE_WALL, block -> using(name(block, "block/%s", "(^smooth_)|(_wall$)", ""), n -> wallAll(name(block, "block/%s"), n + "_top")));

        register(MarblesBlocks.DUSK_SAND, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(MarblesBlocks.DUSK_SANDSTONE, block -> simple(name(block, "block/%s"), cubeBottomTop(name(block, "block/%s_bottom"), name(block, "block/%s_top"), name(block, "block/%s"))));
        register(MarblesBlocks.CHISELED_DUSK_SANDSTONE, block -> simple(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top", "^chiseled_", ""), name(block, "block/%s"))));
        register(MarblesBlocks.CUT_DUSK_SANDSTONE, block -> simple(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top", "^cut_", ""), name(block, "block/%s"))));
        register(MarblesBlocks.SMOOTH_DUSK_SANDSTONE, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s_top", "^smooth_", ""))));
        register(MarblesBlocks.DUSK_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "_slab"), n -> slabSided(name(block, "block/%s"), n, n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DUSK_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "(^cut_)|(_slab$)", ""), n -> slabColumn(name(block, "block/%s"), n, n + "_top", name(block, "block/%s", "_slab"))));
        register(MarblesBlocks.SMOOTH_DUSK_SANDSTONE_SLAB, block -> using(name(block, "block/%s", "(^smooth_)|(_slab$)", ""), n -> slabAll(name(block, "block/%s"), n, n + "_top")));
        register(MarblesBlocks.DUSK_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "_stairs"), n -> stairsSided(name(block, "block/%s"), n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DUSK_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "(^cut_)|(_stairs$)", ""), n -> stairsColumn(name(block, "block/%s"), n + "_top", name(block, "block/%s", "_stairs"))));
        register(MarblesBlocks.SMOOTH_DUSK_SANDSTONE_STAIRS, block -> using(name(block, "block/%s", "(^smooth_)|(_stairs$)", ""), n -> stairsAll(name(block, "block/%s"), n + "_top")));
        register(MarblesBlocks.DUSK_SANDSTONE_WALL, block -> using(name(block, "block/%s", "_wall"), n -> wallSided(name(block, "block/%s"), n + "_bottom", n + "_top", n)));
        register(MarblesBlocks.CUT_DUSK_SANDSTONE_WALL, block -> using(name(block, "block/%s", "(^cut_)|(_wall$)", ""), n -> wallColumn(name(block, "block/%s"), n + "_top", name(block, "block/%s", "_wall"))));
        register(MarblesBlocks.SMOOTH_DUSK_SANDSTONE_WALL, block -> using(name(block, "block/%s", "(^smooth_)|(_wall$)", ""), n -> wallAll(name(block, "block/%s"), n + "_top")));

        register(MarblesBlocks.GRISP_DIRT, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
    }

    private static void registerWoodBlocks(WoodBlocks blocks) {
        register(blocks.PLANKS, block -> simple(name(block, "block/%s"), cubeAll(name(block, "block/%s"))));
        register(blocks.SAPLING, block -> simple(name(block, "block/%s"), cross(name(block, "block/%s"))));
        register(blocks.LOG, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(blocks.STRIPPED_LOG, block -> axisRotated(name(block, "block/%s"), cubeColumn(name(block, "block/%s_top"), name(block, "block/%s"))));
        register(blocks.WOOD, block -> axisRotated(name(block, "block/%s"), cubeAll(name(block, "block/%s_log", "_wood"))));
        register(blocks.STRIPPED_WOOD, block -> axisRotated(name(block, "block/%s"), cubeAll(name(block, "block/%s_log", "_wood"))));
        register(blocks.LEAVES, block -> simple(name(block, "block/%s"), leaves(name(block, "block/%s"))));
        register(blocks.SLAB, block -> slabAll(name(block, "block/%s"), name(block, "block/%s_planks", "_slab"), name(block, "block/%s_planks", "_slab")));
        register(blocks.STAIRS, block -> stairsAll(name(block, "block/%s"), name(block, "block/%s_planks", "_stairs")));
        register(blocks.FENCE, block -> fence(name(block, "block/%s"), name(block, "block/%s_planks", "_fence")));
        register(blocks.DOOR, block -> door(name(block, "block/%s")));
        register(blocks.TRAPDOOR, block -> trapdoor(name(block, "block/%s")));
        register(blocks.FENCE_GATE, block -> fenceGate(name(block, "block/%s"), name(block, "block/%s_planks", "_fence_gate")));
        register(blocks.BUTTON, block -> button(name(block, "block/%s"), name(block, "block/%s_planks", "_button")));
        register(blocks.PRESSURE_PLATE, block -> pressurePlate(name(block, "block/%s"), name(block, "block/%s_planks", "_pressure_plate")));
        register(blocks.SIGN, block -> simple(name(block, "block/%s"), particles(name(block, "block/%s_planks", "_sign"))));
        register(blocks.WALL_SIGN, block -> simple(name(block, "block/%s_sign", "_wall_sign"), null)); // same particle-only model as floor sign, avoid double generation
    }

    private static void register(Block block, Function<Block, StateGen> genFactory) {
        consumer.accept(block, genFactory.apply(block));
    }

    private static String name(Block block, String nameFormat) {
        Identifier id = Registry.BLOCK.getId(block);

        return String.format("%s:%s", id.getNamespace(), String.format(nameFormat, id.getPath()));
    }

    private static String name(Block block, String nameFormat, String omitSuffix) {
        Identifier id = Registry.BLOCK.getId(block);

        String path = id.getPath();
        if (path.endsWith(omitSuffix)) {
            path = path.substring(0, path.length() - omitSuffix.length());
        }

        return String.format("%s:%s", id.getNamespace(), String.format(nameFormat, path));
    }

    private static String name(Block block, String nameFormat, String pattern, String reformat) {
        Identifier id = Registry.BLOCK.getId(block);

        String path = id.getPath();
        path = path.replaceAll(pattern, reformat);

        return String.format("%s:%s", id.getNamespace(), String.format(nameFormat, path));
    }

    private static String name(Block block) {
        Identifier id = Registry.BLOCK.getId(block);
        return id.toString();
    }

    private static <T> T using(String name, Function<String, T> func) {
        return func.apply(name);
    }


    private BlockStateTable() {
    }
}
