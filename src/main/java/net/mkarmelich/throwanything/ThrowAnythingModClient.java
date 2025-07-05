package net.mkarmelich.throwanything;

import net.fabricmc.api.ClientModInitializer;
import net.mkarmelich.throwanything.event.KeyInputHandling;

public class ThrowAnythingModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        KeyInputHandling.register();

    }
}
