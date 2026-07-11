package com.goobers.daylightcreaking.Listeners;

import org.bukkit.block.Block;
import org.bukkit.block.data.type.CreakingHeart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPhysicsEvent;

public class CreakingHeartListener implements Listener {
    @EventHandler
    public void onPhysics(BlockPhysicsEvent event) {
        Block block = event.getBlock();

        if (!(block.getBlockData() instanceof CreakingHeart heart)) return;

        // If the game is trying to change the state to DORMANT, block it
        if (heart.getCreakingHeartState() == CreakingHeart.State.DORMANT) {
            heart.setCreakingHeartState(CreakingHeart.State.AWAKE);
            block.setBlockData(heart, false);
        }
    }
}

