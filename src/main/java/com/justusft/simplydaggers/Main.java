package com.justusft.simplydaggers;

import com.justusft.simplydaggers.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main
{
	@SidedProxy(clientSide="com.justusft.simplydaggers.proxy.ClientProxy", serverSide="com.justusft.simplydaggers.proxy.ServerProxy")
	public static CommonProxy proxy;
	
    public static final String MODID = "SimplyDaggers";
    public static final String MODNAME = "Simply Daggers";
    public static final String VERSION = "1.7.10-1.1";
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
