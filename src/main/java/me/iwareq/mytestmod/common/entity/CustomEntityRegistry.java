package me.iwareq.mytestmod.common.entity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lombok.experimental.UtilityClass;
import me.iwareq.mytestmod.common.entity.hanging.EntityPortal;
import me.iwareq.mytestmod.common.entity.throwable.EntityPortalBall;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

import java.util.concurrent.atomic.AtomicInteger;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;

@UtilityClass
public class CustomEntityRegistry {

    private static final AtomicInteger ID = new AtomicInteger(0);

    public static void register() {
        EntityRegistry.registerModEntity(EntityPortalBall.class, MOD_ID + ".entity_portal_ball", generateId(), MOD_ID, 64, 1, true);
        EntityRegistry.registerModEntity(EntityPortal.class, MOD_ID + ".entity_portal", generateId(), MOD_ID, 64, 2, false);
    }

    private static int generateId() {
        return ID.getAndIncrement();
    }

    @SideOnly(Side.CLIENT)
    public static void registerRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPortalBall.class, new RenderSnowball(Items.slime_ball));
    }
}
