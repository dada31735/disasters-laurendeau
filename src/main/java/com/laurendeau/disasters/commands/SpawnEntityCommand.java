package com.laurendeau.disasters.commands;

import com.laurendeau.disasters.entity.ModEntities;
import com.laurendeau.disasters.entity.custom.TornadoEntity;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;

public class SpawnEntityCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("spawn_tornado")
                .executes(context -> {
                    CommandSourceStack source = context.getSource();
                    ServerLevel level = source.getLevel();
                    Vec3 pos = source.getPosition().add(0, 1, 0);

                    BlockPos blockPos = new BlockPos(
                            (int) Math.floor(pos.x),
                            (int) Math.floor(pos.y),
                            (int) Math.floor(pos.z)
                    );

                    TornadoEntity tornado = ModEntities.TORNADO.get().spawn(level, blockPos, MobSpawnType.COMMAND);
                    if (tornado != null) {
                        tornado.setCustomName(Component.literal("Tornado"));
                    }

                    source.sendSuccess(() -> Component.literal("Spawned a Tornado!"), true);
                    return Command.SINGLE_SUCCESS;
                }));
    }
}
