package me.iwareq.mytestmod.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lombok.experimental.UtilityClass;
import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;

@UtilityClass
public class BlockRegistry {

    public static void register() {
        GameRegistry.registerBlock(new BlockSchematicChest(), "schematic_chest");

        GameRegistry.registerTileEntity(TileEntitySchematicChest.class, MOD_ID + ":schematic_chest");
    }
}
