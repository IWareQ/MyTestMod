package me.iwareq.mytestmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.iwareq.mytestmod.common.CommonProxy;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;
import static me.iwareq.mytestmod.MyTestMod.VERSION;

@Mod(modid = MOD_ID, version = VERSION)
public class MyTestMod {

    public static final String MOD_ID = "mytestmod";
    public static final String VERSION = "1.0";

    @Mod.Instance(MOD_ID)
    public static MyTestMod instance;

    @SidedProxy(
            clientSide = "me.iwareq.mytestmod.client.ClientProxy",
            serverSide = "me.iwareq.mytestmod.common.CommonProxy"
    )
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
