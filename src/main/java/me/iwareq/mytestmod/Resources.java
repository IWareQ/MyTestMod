package me.iwareq.mytestmod;

import lombok.experimental.UtilityClass;
import net.minecraft.util.ResourceLocation;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;

@UtilityClass
public class Resources {

    public static final String PREFIX_MOD = MOD_ID + ":";

    public static final String PREFIX_GUI = "textures/gui/";
    public static final String PREFIX_TEXTURE_ITEMS = "textures/items/";
    public static final String PREFIX_MODEL_ITEMS = "models/items/";

    public static final String GUI_SCHEMATIC_CHEST = PREFIX_GUI + "container/dispenser.png";

    public static final String TEXTURE_PORTAL_GUN = PREFIX_TEXTURE_ITEMS + "portalGun.png";
    public static final String MODEL_PORTAL_GUN = PREFIX_MODEL_ITEMS + "portalGun.obj";

    public static ResourceLocation of(String path) {
        return new ResourceLocation(MOD_ID, path);
    }
}
