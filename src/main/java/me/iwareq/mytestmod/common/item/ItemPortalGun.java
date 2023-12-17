package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.item.Item;

@SideOnly(Side.CLIENT)
public class ItemPortalGun extends Item {

    public ItemPortalGun() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("portal_gun");
    }
}
