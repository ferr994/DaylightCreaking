package com.goobers.daylightcreaking;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.goobers.daylightcreaking.Listeners.CreakingHeartListener;

/*
 * horsesummoning java plugin
 */
public class Plugin extends JavaPlugin
{
    private static final Logger LOGGER=Logger.getLogger("Daylight Creaking");

    // Singleton like pattern, but instead of initializing the static instance ourselves, it gets initialized by the main engine and we retrieve it onEnable
    private static Plugin instance = null;
    public static Plugin getInstance() {
        return instance;
    }
    public Logger getLogger() {
        return LOGGER;
    }

    public void onEnable()
    {
        instance = this;
        Bukkit.getPluginManager().registerEvents(new CreakingHeartListener(), this);
        LOGGER.info("registered event handler");
    }

    public void onDisable()
    {
        instance = null;
        LOGGER.info("disabled");
    }
}
