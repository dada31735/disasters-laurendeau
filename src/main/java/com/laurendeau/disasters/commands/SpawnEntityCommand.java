package com.laurendeau.disasters.commands;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.event.RegisterCommandsEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.phys.Vec3;


public class SpawnEntityCommand {
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("spawn_creeper")
                .executes(context -> {
                    CommandSourceStack source = context.getSource();
                    ServerLevel level = source.getLevel();
                    Vec3 pos = source.getPosition().add(0, 1, 0); // Vec3
                    
                    BlockPos blockPos = new BlockPos(
                            (int) Math.floor(pos.x),
                            (int) Math.floor(pos.y),
                            (int) Math.floor(pos.z)
                    );

                    EntityType.CREEPER.spawn(level, blockPos, MobSpawnType.COMMAND);


                    source.sendSuccess(() -> net.minecraft.network.chat.Component.literal("Spawned a creeper!"), true);
                    return Command.SINGLE_SUCCESS;
                }));

    }
}
