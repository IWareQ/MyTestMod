package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import static me.iwareq.mytestmod.Resources.PREFIX_MOD;

public class ItemBottlePortalLiquid extends Item {

    public ItemBottlePortalLiquid() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(64);
        this.setUnlocalizedName("bottle_portal_liquid");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister register) {
        this.itemIcon = register.registerIcon(PREFIX_MOD + "bottle_with_portal_liquid");
    }
}
