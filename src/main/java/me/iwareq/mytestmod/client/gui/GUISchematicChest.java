package me.iwareq.mytestmod.client.gui;

import me.iwareq.mytestmod.Tags;
import me.iwareq.mytestmod.common.container.ContainerSchematicChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GUISchematicChest extends GuiContainer {

    private static final ResourceLocation bgTexture = new ResourceLocation(Tags.MODID + ":textures/gui/schematic_chest.png");

    public GUISchematicChest(ContainerSchematicChest container) {
        super(container);
        this.ySize = 227;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, 135, 0xFFFFFF);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(bgTexture);

        int left = (width - xSize) / 2;
        int top = (height - ySize) / 2;
        this.drawTexturedModalRect(left, top, 0, 0, xSize, ySize);
    }
}
