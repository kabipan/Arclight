package io.izzel.arclight.common.bridge.core.network.login;

import com.mojang.authlib.GameProfile;
import io.izzel.arclight.common.bridge.core.network.common.ServerCommonPacketListenerBridge;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.login.custom.DiscardedQueryAnswerPayload;

public interface ServerLoginNetHandlerBridge extends ServerCommonPacketListenerBridge {
    default Thread bridge$newHandleThread(String name, Runnable runnable) {
        return new Thread(runnable, name);
    }

    int bridge$getVelocityLoginId();

    void bridge$preLogin(GameProfile authenticatedProfile) throws Exception;

    default FriendlyByteBuf bridge$getDiscardedQueryAnswerData(DiscardedQueryAnswerPayload payload) {
        // Todo: use Mixin to save vanilla payload data.
        return null;
    }
}
