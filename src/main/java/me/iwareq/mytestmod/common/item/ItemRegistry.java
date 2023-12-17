package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lombok.experimental.UtilityClass;
import me.iwareq.mytestmod.client.renderer.item.PortalGunRenderer;
import net.minecraftforge.client.MinecraftForgeClient;

@UtilityClass
public class ItemRegistry {

    public static final ItemPortalGun PORTAL_GUN = new ItemPortalGun();

    public static void register() {
        GameRegistry.registerItem(PORTAL_GUN, "portal_gun");
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        MinecraftForgeClient.registerItemRenderer(PORTAL_GUN, new PortalGunRenderer());
    }
}
