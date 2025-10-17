package com.laurendeau.disasters.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TornadoEntity extends Mob {
    private static final double ATTRACTION_RADIUS = 10.0;

    public TornadoEntity(EntityType<? extends TornadoEntity> type, Level level) {
        super(type, level);
    }

    // ✅ Required in 1.21+
    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0)
                .add(Attributes.MOVEMENT_SPEED, 0.3);
    }

    @Override
    public void tick() {
        super.tick();

        if (!this.level().isClientSide()) {
            AABB box = this.getBoundingBox().inflate(ATTRACTION_RADIUS);
            List<Entity> nearby = this.level().getEntities(this, box, e -> e != this);

            for (Entity e : nearby) {
                Vec3 direction = this.position().subtract(e.position()).normalize().scale(0.2);
                e.setDeltaMovement(e.getDeltaMovement().add(direction));
            }
        }
    }

    @Override
    public boolean hurt(@NotNull net.minecraft.world.damagesource.DamageSource source, float amount) {
        return false;
    }
}
