package com.laurendeau.disasters.entity;

import com.laurendeau.disasters.disastersLaurendeau;
import com.laurendeau.disasters.entity.custom.TornadoEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(Registries.ENTITY_TYPE, disastersLaurendeau.MODID);

    public static final DeferredHolder<EntityType<?>, EntityType<TornadoEntity>> TORNADO =
            ENTITY_TYPES.register("tornado",
                    () -> EntityType.Builder.of(TornadoEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.95F)
                            .clientTrackingRange(10)
                            .build("tornado")
            );
}
