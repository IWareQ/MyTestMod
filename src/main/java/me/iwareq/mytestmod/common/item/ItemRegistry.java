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
    public static final ItemBottlePortalLiquid BOTTLE_PORTAL_LIQUID = new ItemBottlePortalLiquid();


    public static void register() {
        GameRegistry.registerItem(PORTAL_GUN, PORTAL_GUN.getUnlocalizedName());
        GameRegistry.registerItem(BOTTLE_PORTAL_LIQUID, BOTTLE_PORTAL_LIQUID.getUnlocalizedName());
    }

    @SideOnly(Side.CLIENT)
    public static void registerRender() {
        MinecraftForgeClient.registerItemRenderer(PORTAL_GUN, new PortalGunRenderer());
    }
}
