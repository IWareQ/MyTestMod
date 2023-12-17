package me.iwareq.mytestmod.common.tab;

import me.iwareq.mytestmod.Tags;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class MyTestTab extends CreativeTabs {

    public static final MyTestTab INSTANCE = new MyTestTab();

    private MyTestTab() {
        super(Tags.MODID);
        this.setBackgroundImageName("item_search.png");
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(Blocks.obsidian);
    }

    @Override
    public int getSearchbarWidth() {
        return 70;
    }

    @Override
    public boolean hasSearchBar() {
        return true;
    }
}
