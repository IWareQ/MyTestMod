package me.iwareq.mytestmod.common.tab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import static me.iwareq.mytestmod.MyTestMod.MOD_ID;

public class MyTestTab extends CreativeTabs {

    public static final MyTestTab INSTANCE = new MyTestTab();

    private MyTestTab() {
        super(MOD_ID);
        this.setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.obsidian);
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
