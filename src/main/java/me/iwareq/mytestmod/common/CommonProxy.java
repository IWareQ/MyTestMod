package me.iwareq.mytestmod.common;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import me.iwareq.mytestmod.common.block.BlockRegistry;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;
import me.iwareq.mytestmod.common.container.ContainerSchematicChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class CommonProxy implements IGuiHandler {

    public static final int GUI_SCHEMATIC_CHEST = 0;

    public void preInit(FMLPreInitializationEvent event) {
        BlockRegistry.register();
    }

    public void init(FMLInitializationEvent event) {}

    public void postInit(FMLPostInitializationEvent event) {}

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (id == GUI_SCHEMATIC_CHEST)
            return new ContainerSchematicChest((TileEntitySchematicChest) tileEntity, player.inventory);

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        return null; // NO-OP
    }
}
