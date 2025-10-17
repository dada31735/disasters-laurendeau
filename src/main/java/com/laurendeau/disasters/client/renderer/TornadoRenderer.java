package com.laurendeau.disasters.client.renderer;

import com.laurendeau.disasters.entity.custom.TornadoEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.resources.ResourceLocation;

public class TornadoRenderer extends MobRenderer<TornadoEntity, VillagerModel<TornadoEntity>> {

    private static final ResourceLocation TEXTURE =
            ResourceLocation.fromNamespaceAndPath("disasterslaurendeau", "entities/transparent.png");

    public TornadoRenderer(EntityRendererProvider.Context context) {
        super(context, new VillagerModel<>(context.bakeLayer(ModelLayers.VILLAGER)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(TornadoEntity entity) {
        return TEXTURE;
    }
}
