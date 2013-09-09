package com.github.francescodesa.pvptools;

import java.util.logging.Logger;

import net.milkbowl.vault.permission.Permission;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class PVPTools extends JavaPlugin {

	@Override
    public void onEnable(){
		init();
        // TODO Insert logic to be performed when the plugin is enabled
    }
 
    @Override
    public void onDisable() {
        // TODO Insert logic to be performed when the plugin is disabled
    }
    
    public void init(){
		this.logger = this.getLogger();
		logger.info("Enabling PVPTools....");
		if(setupPermissions()){
			logger.info("Hooked vault");
		}else{
			logger.severe("Failed to hook vault");
		}
    }
    private boolean setupPermissions()
    {
        RegisteredServiceProvider<Permission> permissionProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.permission.Permission.class);
        if (permissionProvider != null) {
            permission = permissionProvider.getProvider();
        }
        return (permission != null);
    }
    public static Permission permission = null;
    public Logger logger;
}
