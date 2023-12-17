package me.iwareq.mytestmod.client.renderer.item;

import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import static org.lwjgl.opengl.GL11.*;

public abstract class CustomItemRenderer implements IItemRenderer {

    @Override
    public boolean handleRenderType(ItemStack item, ItemRenderType type) {
        return true;
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
        switch (helper) {
            case ENTITY_ROTATION:
            case ENTITY_BOBBING:
            case INVENTORY_BLOCK:
                return true;
            default:
                return false;
        }
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
        glPushMatrix();
        bindTextures();
        modelTransform(type);
        renderModels();
        glPopMatrix();
    }

    public void modelTransform(ItemRenderType type) {
        switch (type) {
            case ENTITY:
                glTranslatef(0.0f, 0.3f, 0.0f);
                break;
            case EQUIPPED:
                glRotatef(190, 0.0f, 1.0f, 0.0f);
                glRotatef(-15, 0.0f, 0.0f, 1.0f);
                glTranslatef(-0.4f, 0.4f, 0.0f);
                break;
            case EQUIPPED_FIRST_PERSON:
                glRotatef(-90, 0.0f, 1.0f, 0.0f);
                glRotatef(25, 1.0f, 0.0f, 0.0f);
                glScalef(6.0f, 6.0f, 6.0f);
                glTranslatef(0.6f, 0.0f, -1.0f);
                break;
        }
    }

    public abstract void bindTextures();

    public abstract void renderModels();
}
