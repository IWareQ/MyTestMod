package me.iwareq.mytestmod.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import me.iwareq.mytestmod.Tags;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;

public class BlockRegistry {

    public static void register() {
        GameRegistry.registerBlock(new BlockSchematicChest(), "schematic_chest");

        GameRegistry.registerTileEntity(TileEntitySchematicChest.class, Tags.MODID + ":schematic_chest");
    }
}
