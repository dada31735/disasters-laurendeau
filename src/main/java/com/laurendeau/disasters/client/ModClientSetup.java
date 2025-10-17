package com.laurendeau.disasters.client;

import com.laurendeau.disasters.client.renderer.TornadoRenderer;
import com.laurendeau.disasters.disastersLaurendeau;
import com.laurendeau.disasters.entity.ModEntities;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;

public class ModClientSetup {

    public static void register() {
        // Register this class to NeoForge's event bus
        NeoForge.EVENT_BUS.register(new ModClientSetup());
    }

    @SubscribeEvent
    public void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.TORNADO.get(), TornadoRenderer::new);
    }
}
