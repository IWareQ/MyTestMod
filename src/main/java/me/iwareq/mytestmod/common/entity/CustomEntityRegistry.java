package me.iwareq.mytestmod.common.entity;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import me.iwareq.mytestmod.Tags;
import me.iwareq.mytestmod.common.entity.entityhanging.EntityPortal;
import me.iwareq.mytestmod.common.entity.entitythrowable.EntityPortalBall;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;

public class CustomEntityRegistry {
    public static final int ENTITY_PORTAL_BALL_ID = 0;
    public static final int ENTITY_PORTAL_ID = 1;

    public static void register() {
        EntityRegistry.registerModEntity(EntityPortalBall.class, Tags.MODID + ".entity_portal_ball", ENTITY_PORTAL_BALL_ID, Tags.MODID, 64, 1, true);
        EntityRegistry.registerModEntity(EntityPortal.class, Tags.MODID + ".entity_portal", ENTITY_PORTAL_ID, Tags.MODID, 64, 2, false);
    }

    public static void registerRenderer() {
        RenderingRegistry.registerEntityRenderingHandler(EntityPortalBall.class, new RenderSnowball(Items.slime_ball));
    }
}
