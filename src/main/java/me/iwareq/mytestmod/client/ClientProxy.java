package me.iwareq.mytestmod.client;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import me.iwareq.mytestmod.client.gui.GUISchematicChest;
import me.iwareq.mytestmod.common.CommonProxy;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;
import me.iwareq.mytestmod.common.container.ContainerSchematicChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if (id == GUI_SCHEMATIC_CHEST)
            return new GUISchematicChest(new ContainerSchematicChest((TileEntitySchematicChest) tileEntity, player.inventory));

        return null;
    }
}
