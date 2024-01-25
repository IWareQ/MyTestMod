package me.iwareq.mytestmod.client.renderer.item;

import me.iwareq.mytestmod.Resources;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

import static me.iwareq.mytestmod.Resources.TEXTURE_PORTAL_GUN;
import static me.iwareq.mytestmod.Resources.MODEL_PORTAL_GUN;

public class PortalGunRenderer extends CustomItemRenderer {

    private static final ResourceLocation TEXTURE = Resources.of(TEXTURE_PORTAL_GUN);
    private static final IModelCustom MODEL = AdvancedModelLoader.loadModel(Resources.of(MODEL_PORTAL_GUN));

    @Override
    public void bindTextures() {
        Minecraft.getMinecraft().renderEngine.bindTexture(TEXTURE);
    }

    @Override
    public void renderModels() {
        MODEL.renderAll();
    }
}
