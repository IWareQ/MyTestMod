package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.common.entity.entitythrowable.EntityPortalBall;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class ItemPortalGun extends Item {

    private static final int MAX_CHARGE = 3;

    private int currentCharge;

    public ItemPortalGun() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("portal_gun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        if (currentCharge <= 0) {
            reload(player);
            return itemStackIn;
        }
        worldIn.spawnEntityInWorld(new EntityPortalBall(worldIn, player));
        currentCharge--;
        return itemStackIn;
    }

    private void reload(EntityPlayer player) {
        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);
            if (stackInSlot == null) continue;
            if (Item.getIdFromItem(stackInSlot.getItem()) != 374) continue;

            player.inventory.decrStackSize(i, 1);
            player.inventoryContainer.detectAndSendChanges();
            currentCharge = MAX_CHARGE;
            break;
        }
    }
}
