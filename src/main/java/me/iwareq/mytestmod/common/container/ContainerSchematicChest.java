package me.iwareq.mytestmod.common.container;

import me.iwareq.mytestmod.common.block.tile.TileEntitySchematicChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerSchematicChest extends Container {

    private final TileEntitySchematicChest chest;

    public ContainerSchematicChest(TileEntitySchematicChest chest, InventoryPlayer inventoryPlayer) {
        this.chest = chest;

        // Инвентарь сундука
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                this.addSlotToContainer(new Slot(chest, col + row * 3, 62 + col * 18, 17 + row * 18));
            }
        }

        // Инвентарь игрока
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                this.addSlotToContainer(new Slot(inventoryPlayer, col + row * 9 + 9, 8 + col * 18, 84 + row * 18));
            }
        }

        // Хот-бар игрока
        for (int col = 0; col < 9; col++) {
            this.addSlotToContainer(new Slot(inventoryPlayer, col, 8 + col * 18, 142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return this.chest.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {
        ItemStack stack = null;
        Slot slot = (Slot) this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack()) {
            ItemStack slotStack = slot.getStack();
            stack = slotStack.copy();

            if (index < this.chest.getSizeInventory()) { // Клик был выполнен в инвентаре сундука
                if (!this.mergeItemStack(slotStack, this.chest.getSizeInventory(), this.inventorySlots.size(), true))
                    return null;
            } else if (!this.mergeItemStack(slotStack, 0, this.chest.getSizeInventory(), false))
                return null;

            if (slotStack.stackSize <= 0) slot.putStack(null);
            else slot.onSlotChanged();
        }

        return stack;
    }
}
