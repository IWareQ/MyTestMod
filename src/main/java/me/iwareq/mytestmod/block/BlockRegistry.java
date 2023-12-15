package me.iwareq.mytestmod.block;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.block.impl.CraftTable;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockRegistry {

    public static final CreativeTabs TABS = new CreativeTabs("test_tab") {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.obsidian);
        }
    };

    public static void init() {
        GameRegistry.registerBlock(new CraftTable(), "craft_table");
    }
}
