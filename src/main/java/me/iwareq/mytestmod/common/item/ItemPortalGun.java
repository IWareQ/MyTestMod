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

        if (currentCharge <= 0) {
            canReloading = true;
            return itemStackIn;
        }

        if (cooldown) return itemStackIn;
        cooldown = true;

        worldIn.spawnEntityInWorld(new EntityPortalBall(worldIn, player));
        currentCharge--;
        return itemStackIn;
    }

    @Override
    public int getMaxItemUseDuration(ItemStack item) {
        return 10;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void onUsingTick(ItemStack itemStack, EntityPlayer player, int count) {
        if (count == 1 && canReloading) reload(player);
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack) {
        if (canReloading) return EnumAction.bow;
        return EnumAction.none;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int count) {
        if (cooldown) cooldown = false;
    }

    private void reload(EntityPlayer player) {
        if (player.getEntityWorld().isRemote) return;
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
