package net.veroxuniverse.crystal_chronicles.util;

import net.minecraft.util.StringRepresentable;

public enum CrystalPart implements StringRepresentable {
    DOWN_BACK_LEFT("down_back_left"),
    DOWN_BACK_RIGHT("down_back_right"),
    DOWN_FRONT_LEFT("down_front_left"),
    DOWN_FRONT_RIGHT("down_front_right"),
    UP_BACK_LEFT("up_back_left"),
    UP_BACK_RIGHT("up_back_right"),
    UP_FRONT_LEFT("up_front_left"),
    UP_FRONT_RIGHT("up_front_right");

    private final String name;

    CrystalPart(String name) { this.name = name; }
    public String getSerializedName() { return this.name; }
}