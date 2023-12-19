package me.iwareq.mytestmod.common.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.iwareq.mytestmod.common.entity.entitythrowable.EntityPortalBall;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class ItemPortalGun extends Item {

    private static final int MAX_CHARGE = 3;

    private int currentCharge;

    private boolean reloading;
    private boolean coolDown;

    public ItemPortalGun() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("portal_gun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        player.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
        if (currentCharge <= 0) {
            reloading = true;
            return itemStackIn;
        }
        if (coolDown) {
            return itemStackIn;
        }
        coolDown = true;

        worldIn.spawnEntityInWorld(new EntityPortalBall(worldIn, player));
        currentCharge--;
        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack p_77626_1_) {
        return 10;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUsingTick(ItemStack itemStack, EntityPlayer player, int count) {
        if (count == 1 && reloading) reload(player);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        if (reloading) return EnumAction.bow;
        return EnumAction.none;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int count) {
        if (coolDown) coolDown = false;
    }

    private void reload(EntityPlayer player) {
        if (player.getEntityWorld().isRemote) return;
        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);
            if (stackInSlot == null) continue;
            if (stackInSlot.getItem() != ItemRegistry.BOTTLE_PORTAL_LIQUID) continue;

            player.inventory.decrStackSize(i, 1);
            player.inventoryContainer.detectAndSendChanges();
            currentCharge = MAX_CHARGE;
            reloading = false;

            break;
        }
    }
}
