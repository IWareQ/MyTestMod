package me.iwareq.mytestmod.client.renderer.item;

import me.iwareq.mytestmod.Tags;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;

public class PortalGunRenderer extends CustomItemRenderer {
    private final ResourceLocation modelPath = new ResourceLocation(Tags.MODID, "models/items/portalGun.obj");
    private final ResourceLocation texturePath = new ResourceLocation(Tags.MODID, "textures/models/portalGun.png");
    private final IModelCustom model = AdvancedModelLoader.loadModel(modelPath);

    @Override
    public void bindTextures() {
        Minecraft.getMinecraft().renderEngine.bindTexture(texturePath);
    }

    @Override
    public void renderModels() {
        model.renderAll();
    }
}
