package net.veroxuniverse.crystal_chronicles.registry;

import net.minecraft.client.KeyMapping;
import com.mojang.blaze3d.platform.InputConstants;
import org.lwjgl.glfw.GLFW;

public class CCKeybinds {
    public static final KeyMapping RING_SWAP_KEY = new KeyMapping(
            "key.crystal_chronicles.ring_swap",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_R,
            "category.crystal_chronicles"
    );
}