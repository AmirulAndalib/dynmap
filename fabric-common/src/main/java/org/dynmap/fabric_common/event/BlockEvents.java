package org.dynmap.fabric_common.event;

import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockEvents {
    private BlockEvents() {
    }

    public static Event<BlockCallback> BLOCK_EVENT = EventFactory.createArrayBacked(BlockCallback.class,
            (listeners) -> (world, pos) -> {
                for (BlockCallback callback : listeners) {
                    callback.onBlockEvent(world, pos);
                }
            }
    );

    @FunctionalInterface
    public interface BlockCallback {
        void onBlockEvent(World world, BlockPos pos);
    }
}
