package net.veroxuniverse.crystal_chronicles.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import net.veroxuniverse.crystal_chronicles.CrystalChronicles;
import net.veroxuniverse.crystal_chronicles.worldgen.CCConfiguredFeatures;

import java.util.Optional;

public class CCTreeGrower {
    public static final TreeGrower BRONCHUS = new TreeGrower(CrystalChronicles.MODID + ":bronchus",
            Optional.empty(), Optional.of(CCConfiguredFeatures.BRONCHUS_KEY), Optional.empty());
}