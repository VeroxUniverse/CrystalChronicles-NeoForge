package net.veroxuniverse.crystal_chronicles.dimension;

import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

public class AlphaDimensionData extends SavedData {

    private static final String NAME = "dimension_data";
    private boolean structureGenerated = false;

    public static AlphaDimensionData get(ServerLevel level) {
        return level.getDataStorage().computeIfAbsent(
                new SavedData.Factory<>(
                        AlphaDimensionData::new,
                        AlphaDimensionData::load,
                        null
                ),
                NAME
        );
    }

    public static AlphaDimensionData load(CompoundTag tag, HolderLookup.Provider provider) {
        AlphaDimensionData data = new AlphaDimensionData();
        data.structureGenerated = tag.getBoolean("structureGenerated");
        return data;
    }

    @Override
    public CompoundTag save(CompoundTag tag, HolderLookup.Provider provider) {
        tag.putBoolean("structureGenerated", structureGenerated);
        return tag;
    }

    public boolean isStructureGenerated() {
        return structureGenerated;
    }

    public void setStructureGenerated() {
        this.structureGenerated = true;
        setDirty();
    }
}