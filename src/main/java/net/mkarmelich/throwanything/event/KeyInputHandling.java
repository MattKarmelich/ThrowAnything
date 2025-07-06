package net.mkarmelich.throwanything.event;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.Text;
import org.lwjgl.glfw.GLFW;

public class KeyInputHandling {
    public static final String KEY_CATEGORY_INPUT = "key.category.input";
    public static final String KEY_THROW_ITEM = "key.throw_item";

    public static KeyBinding throwingKey;

    public static void registerKeyInputs() {
        ClientTickEvents.END_CLIENT_TICK.register(minecraftClient -> {
            if(throwingKey.isPressed()) {
                assert minecraftClient.player != null;
                String item = minecraftClient.player.getStackInHand(minecraftClient.player.getActiveHand()).toString();

                if(!item.isEmpty()) minecraftClient.player.sendMessage(Text.of("This is a " + item), true);
            }
        });
    }

    public static void register() {
        throwingKey = KeyBindingHelper.registerKeyBinding( new KeyBinding(
                KEY_THROW_ITEM,
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_R,
                KEY_CATEGORY_INPUT
        ));

        registerKeyInputs();
    }
}
