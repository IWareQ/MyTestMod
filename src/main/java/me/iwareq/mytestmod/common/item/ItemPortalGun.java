package me.iwareq.mytestmod.common.item;

import me.iwareq.mytestmod.common.entity.throwable.EntityPortalBall;
import me.iwareq.mytestmod.common.tab.MyTestTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortalGun extends Item {

    private static final int MAX_CHARGE = 3;

    private int currentCharge;

    private boolean shouldReloading;
    private boolean canCoolDown;

    public ItemPortalGun() {
        this.setCreativeTab(MyTestTab.INSTANCE);
        this.setMaxStackSize(1);
        this.setUnlocalizedName("portal_gun");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer player) {
        player.setItemInUse(itemStackIn, this.getMaxItemUseDuration(itemStackIn));
        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack item) {
        return 10;
    }

    @Override
    public void onUsingTick(ItemStack itemStack, EntityPlayer player, int count) {
        if (count == 1 && this.shouldReloading) this.reload(player);
        if (!this.shouldReloading) this.shot(player);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        return this.shouldReloading ? EnumAction.bow : EnumAction.none;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int count) {
        if (this.canCoolDown) this.canCoolDown = false;
    }

    private void shot(EntityPlayer player) {
        World entityWorld = player.getEntityWorld();
        if (entityWorld.isRemote) return;
        if (this.canCoolDown) return;

        if (this.currentCharge <= 0) {
            this.shouldReloading = true;
            return;
        }

        this.canCoolDown = true;

        this.currentCharge--;
        entityWorld.spawnEntityInWorld(new EntityPortalBall(entityWorld, player));
    }

    private void reload(EntityPlayer player) {
        if (player.getEntityWorld().isRemote || !this.shouldReloading) return;

        for (int i = 0; i < player.inventory.mainInventory.length; i++) {
            ItemStack stackInSlot = player.inventory.getStackInSlot(i);
            if (stackInSlot == null) continue;
            if (stackInSlot.getItem() != ItemRegistry.BOTTLE_PORTAL_LIQUID) continue;

            player.inventory.consumeInventoryItem(ItemRegistry.BOTTLE_PORTAL_LIQUID);

            this.currentCharge = MAX_CHARGE;
            this.shouldReloading = false;
            break;
        }
    }
}
