package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.client.renderer.item.PortalGunRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

public class ItemRegistry {
    static ItemPortalGun item = new ItemPortalGun();
    public static void register(){
        GameRegistry.registerItem(item,"portal_gun");
    }
    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        MinecraftForgeClient.registerItemRenderer(item, new PortalGunRenderer());
    }
}
