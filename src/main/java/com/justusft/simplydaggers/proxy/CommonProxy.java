package com.justusft.simplydaggers.proxy;

import net.minecraftforge.common.MinecraftForge;

import com.justusft.simplydaggers.EventHandler;
import com.justusft.simplydaggers.items.ModItems;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent e) {
    	//enable events
    	EventHandler handler = new EventHandler();
    	FMLCommonHandler.instance().bus().register(handler);
    	MinecraftForge.EVENT_BUS.register(handler);
    }

    public void init(FMLInitializationEvent e) {
    	ModItems.init();
    }

    public void postInit(FMLPostInitializationEvent e) {
		// some example code
        System.out.println("Simplydaggers Initialized");
    }
}