package net.veroxuniverse.crystal_chronicles.util;

import net.minecraft.util.StringRepresentable;

public enum PortalFramePart implements StringRepresentable {
    BOTTOM_LEFT("bottom_left"),
    BOTTOM_MID_LEFT("bottom_mid_left"),
    BOTTOM_MID_RIGHT("bottom_mid_right"),
    BOTTOM_RIGHT("bottom_right"),

    MID_LOW_LEFT("mid_low_left"),
    MID_LOW_RIGHT("mid_low_right"), // Die MID_MID Teile sind gelöscht

    MID_HIGH_LEFT("mid_high_left"),
    MID_HIGH_RIGHT("mid_high_right"), // Die MID_MID Teile sind gelöscht

    TOP_LEFT("top_left"),
    TOP_MID_LEFT("top_mid_left"),
    TOP_MID_RIGHT("top_mid_right"),
    TOP_RIGHT("top_right");

    private final String name;
    PortalFramePart(String name) {
        this.name = name;
    }

    @Override
    public String getSerializedName() { return this.name; }
}