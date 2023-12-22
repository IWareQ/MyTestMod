package me.iwareq.mytestmod.common.item;

import me.iwareq.mytestmod.common.entity.entitythrowable.EntityPortalBall;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortalGun extends Item {

    private static final int MAX_CHARGE = 3;

    private int currentCharge;

    private boolean canReloading;
    private boolean cooldown;

    public ItemPortalGun() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("portal_gun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        player.setItemInUse(itemStackIn, getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack item) {
        return 10;
    }

    @Override
    public void onUsingTick(ItemStack itemStack, EntityPlayer player, int count) {
        if (count == 1 && canReloading) reload(player);
        if (!canReloading) shot(player);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return canReloading ? EnumAction.bow : EnumAction.none;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int count) {
        if (cooldown) cooldown = false;
    }

    private void shot(EntityPlayer player) {
        World entityWorld = player.getEntityWorld();
        if (entityWorld.isRemote) return;

        if (cooldown) return;
        if (currentCharge <= 0) {
            canReloading = true;
            return;
        }
        cooldown = true;

        currentCharge--;
        entityWorld.spawnEntityInWorld(new EntityPortalBall(entityWorld, player));
    }

    private void reload(EntityPlayer player) {
        if (player.getEntityWorld().isRemote || !canReloading) return;
        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);
            if (stackInSlot == null) continue;
            if (stackInSlot.getItem() != ItemRegistry.BOTTLE_PORTAL_LIQUID) continue;

            player.inventory.consumeInventoryItem(ItemRegistry.BOTTLE_PORTAL_LIQUID);

            currentCharge = MAX_CHARGE;
            canReloading = false;
            break;
        }
    }
}
