package com.laurendeau.disasters.particles;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;

public class TornadoParticleManager {

    public static void spawnBasicParticles(ServerLevel level, Vec3 positon) {
        level.sendParticles(
                ParticleTypes.CAMPFIRE_SIGNAL_SMOKE,
                positon.x,
                positon.y + 1,
                positon.z,
                1000,
                0.5,
                0.5,
                0.5,
                0.02
        );
    }
}
