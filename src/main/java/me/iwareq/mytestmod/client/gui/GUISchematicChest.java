package me.iwareq.mytestmod.client.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.common.container.ContainerSchematicChest;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

@SideOnly(Side.CLIENT)
public class GUISchematicChest extends GuiContainer {

    private static final ResourceLocation bgTexture = new ResourceLocation("textures/gui/container/dispenser.png");

    public GUISchematicChest(ContainerSchematicChest container) {
        super(container);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String name = I18n.format("container.schematic_chest.name");
        this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 4, 4210752);

        this.fontRendererObj.drawString(I18n.format("container.inventory"), 8, this.ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GL11.glColor4f(1F, 1F, 1F, 1F);
        this.mc.getTextureManager().bindTexture(bgTexture);

        int left = (this.width - this.xSize) / 2;
        int top = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(left, top, 0, 0, this.xSize, this.ySize);
    }
}
