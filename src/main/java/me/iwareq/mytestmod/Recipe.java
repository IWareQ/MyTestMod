package me.iwareq.mytestmod;

import net.minecraft.item.ItemStack;

public class Recipe {
    public final ItemStack[] input;
    public final ItemStack output;
    public Recipe(ItemStack[] input, ItemStack output) {
        this.input = input;
        this.output = output;
    }
}
