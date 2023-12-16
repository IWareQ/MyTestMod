package me.iwareq.mytestmod.common.block.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

import java.util.Arrays;

public class TileEntitySchematicChest extends TileEntity implements IInventory {

    private final ItemStack[] items = new ItemStack[63];

    @Override
    public boolean canUpdate() {
        return false;
    }

    @Override
    public int getSizeInventory() {
        return this.items.length;
    }

    @Override
    public ItemStack getStackInSlot(int slotIn) {
        return this.items[slotIn];
    }

    @Override
    public ItemStack decrStackSize(int index, int count) {
        if (items[index] == null) return null;

        ItemStack stack;

        if (items[index].stackSize <= count) {
            stack = items[index];
            items[index] = null;
        } else {
            stack = items[index].splitStack(count);

            if (items[index].stackSize <= 0) items[index] = null;
        }

        this.markDirty();
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int index) {
        if (items[index] == null) return null;

        ItemStack stack = items[index];
        items[index] = null;
        return stack;
    }

    @Override
    public void setInventorySlotContents(int index, ItemStack stack) {
        items[index] = stack;

        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
            stack.stackSize = this.getInventoryStackLimit();

        this.markDirty();
    }

    @Override
    public String getInventoryName() {
        return "container.chest";
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) == this
                && player.getDistanceSq((double) xCoord + 0.5D, (double) yCoord + 0.5D, (double) zCoord + 0.5D) <= 64D;
    }

    @Override
    public void openInventory() {
        // NO-OP
    }

    @Override
    public void closeInventory() {
        // NO-OP
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);

        NBTTagList itemsTag = new NBTTagList();
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == null) continue;

            NBTTagCompound tag = new NBTTagCompound();
            tag.setByte("Slot", (byte) i);
            this.items[i].writeToNBT(tag);
            itemsTag.appendTag(tag);
        }

        compound.setTag("Items", itemsTag);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);

        NBTTagList itemsTag = compound.getTagList("Items", 10);
        Arrays.fill(this.items, null); // чтобы айтемы не дюпнулись при повторной загрузке

        for (int i = 0; i < itemsTag.tagCount(); i++) {
            NBTTagCompound tag = itemsTag.getCompoundTagAt(i);
            int slot = tag.getByte("Slot") & 255;

            if (slot >= 0 && slot < this.items.length) {
                this.items[slot] = ItemStack.loadItemStackFromNBT(tag);
            }
        }
    }
}
